<!-- 我的博客界面 -->
<template>
	<div >
		<Header></Header>
		<a-list v-for="(item, index) in blogFolders" :key="index">
			{{item.folder_name}}
			<a-icon :type="index==currentIndex?circleType:'up-circle'" @click="showBlogs(item.folder_name, index)" />
			<a-list-item v-for="(item,index2) in blogListInMyBlog" :key="index2" v-if="index==currentIndex">
				<router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">{{item.title}}</router-link>
				<a-icon type="close" @click="deleteBlogHandler(item.blogId)"/>
				<router-link :to="{name:'EditBlog',query:{blogId:item.blogId}}">修改</router-link>
			</a-list-item>
		</a-list>
		<a-list item-layout="horizontal" :data-source="blogListWithoutFolderInMyBlog" v-if="blogListWithoutFolderInMyBlog.length>0">
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
Vue.prototype.$ajax = axios
	export default{
		name:'MyBlog',
		data(){
			return {
				currentIndex:-1,
				circleType:'up-circle',
			}
		},
		created(){
			this.set_userInfo(sessionStorage.getItem('userInfo'))
			console.log(this.userInfo)

		},
		mounted() {
			this.getBlogFoldersByUserId(this.userInfo.userId)
			console.log(this.blogFolders)
			console.log('MyBlog:'+this.userInfo.userId)
			// res = this.$axios.get('/api/blogFolders/getBlogsByFolder',{
			// 	userId:this.userInfo.userId,
			// 	classification:'',
			// 	writerId:this.userInfo.userId
			// })
			const data = {
					userId:this.userInfo.userId,
					classification:'',
					writerId:this.userInfo.userId
				}
			this.getBlogsByFolder(data)

		},
		components:{
			Header
		},
		computed:{
			...mapGetters([
				'blogFolders',
				'userInfo',
				'blogListWithoutFolderInMyBlog',
				'blogListInMyBlog'
			])
		},
		methods:{
			...mapActions([
				'deleteBlog',
				'getBlogFoldersByUserId',
				'getBlogsByFolder'
			]),
			...mapMutations([
				'set_userInfo'
			]),
			showBlogs(folder_name, index){
				// this.$axios.get('/api/blogs/'+this.$router.query.writerId+'/getBlogsByFolder',{
				// 	// writerId userId classification
				// 	userId:this.userInfo.userId,
				// 	classification:folder_name
				// }).then(res=>{
				// 	this.blogList = res
				// 	this.currentIndex = index
				// }).catch(Error=>{
				// 	console.log(Error)
				// })
				if(this.circleType=='up-circle'){
					this.circleType = 'down-circle'
					var data2 = {
						userId:this.userInfo.userId,
						classification:folder_name,
						writerId:this.userInfo.userId
					}
					this.getBlogsByFolder(data2)
					this.currentIndex = index
				}else{
					this.circleType = 'up-circle'
					this.currentIndex = -1
				}
			},
			deleteBlogHandler(blogId){
				this.deleteBlog(blogId)
			}
		}
	}
</script>

<style>
</style>
