<!-- 我的博客界面 -->
<template>
	<div >
		<Header></Header>
		<a-list v-for="(item, index) in blogFolders" :key="index">
			<a-icon :type="index==currentIndex?circleType:'down-circle'" @click="showBlogs(item.folder_name, index)" />
			<a-list-item v-for="(item,index) in blogList" :key="index" v-if="index==currentIndex">
				<router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">{{item.title}}</router-link>
				<a-icon type="close" @click="deleteBlogHandler(item.blogId)"/>
			</a-list-item>
		</a-list>
		<a-list item-layout="horizontal" :data-source="blogListWithoutFolder">
		<a-list-item slot="renderItem" slot-scope="item, index">
	        <router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">{{item.title}}</router-link>
			<a-icon type="close" @click="deleteBlogHandler(item.blogId)"/>
	    </a-list-item>
		</a-list>
	</div>
</template>

<script>
import Vue from 'vue'
import { mapGetters, mapMutations, mapActions } from 'vuex'
import { axios } from '@/utils/request.js'
  import Header from '../../components/Header.vue';
Vue.prototype.$axios = axios
	export default{
		name:'MyBlog',
		data(){
			return {
				currentIndex:-1,
				blogList:[],
				circleType:'up-circle',
				blogListWithoutFolder:[]
			}
		},
		created(){
			this.set_userInfo(sessionStorage.getItem('userInfo'))
			console.log(this.userInfo)

		},
		mounted() {
			this.getBlogFoldersByUserId(this.userInfo.userId)
			this.$axios.get('/api/blogFolders/'+this.$route.query.userId+'/getBlogsByFolder',{
				writerId:this.userInfo.userId,
				userId:this.userInfo.userId,
				classification:''
			}).then(res=>{
				this.blogListWithoutFolder =res
			}).catch(Error=>{
				console.log(Error)
			})
		},
		components:{
			Header
		},
		computed:{
			...mapGetters([
				'blogFolders',
				'userInfo',
			])
		},
		methods:{
			...mapActions([
				'deleteBlog',
				'getBlogFoldersByUserId'
			]),
			...mapMutations([
				'set_userInfo'
			]),
			showBlogs:(folder_name, index)=>{
				this.$axios.get('/api/blogs/'+this.$router.query.writerId+'/getBlogsByFolder',{
					// writerId userId classification
					userId:this.userInfo.userId,
					classification:folder_name
				}).then(res=>{
					this.blogList = res
					this.currentIndex = index
				}).catch(Error=>{
					console.log(Error)
				})
			},
			deleteBlogHandler:(blogId)=>{
				this.deleteBlog(blogId)
			}
		}
	}
</script>

<style>
</style>
