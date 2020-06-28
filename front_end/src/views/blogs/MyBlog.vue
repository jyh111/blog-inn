<!-- 我的博客界面 -->
<template>
	<div >
		<Header></Header>
		<div class="my_blog">
		<a-list v-for="(item, index) in blogFolders" :key="index" style="width: 100%; margin: 20px auto;">
			<span class="folder_name">{{item.folder_name}}
			<a-icon :type="index==currentIndex?circleType:'up-circle'" @click="showBlogs(item.folder_name, index)" />
			</span>
			<a-list-item v-for="(item2,index2) in blogListInMyBlog" :key="index2" v-if="index==currentIndex">
				<div style="width: 100%;">
				<router-link :to="{name:'DisplayBlog',query:{blogId:item2.blogId}}">{{item2.title}}</router-link>
				<!-- <a-icon type="close" @click="deleteBlogHandler(item2.blogId,item2.folder_name)"/> -->
				<a-button type="danger" @click="deleteBlogHandler(item2.blogId,item2.folder_name)" class="delete_button">删除</a-button>
				<!-- <router-link :to="{name:'EditBlog',query:{blogId:item2.blogId}}"style="edit">修改</router-link> -->
				<a-button type="primary" @click="editHandler(item2.blogId)" class="edit_button">修改</a-button>
				<hr style="color: #cacaca;"/>
				</div>
			</a-list-item>
		</a-list>
		<a-list item-layout="horizontal" :data-source="blogListWithoutFolderInMyBlog" v-if="blogListWithoutFolderInMyBlog.length>0">
		<a-list-item slot="renderItem" slot-scope="item, index">
	        <router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">{{item.title}}</router-link>
			<a-icon type="close" @click="deleteBlogHandler(item.blogId,item.folder_name)"/>
	    </a-list-item>
		</a-list>
		</div>
	</div>
</template>

<script>
import Vue from 'vue'
import { mapGetters, mapMutations, mapActions } from 'vuex'
import { axios } from '@/utils/request.js'
import {message} from 'ant-design-vue'
  import Header from '../../components/Header.vue';
Vue.prototype.$ajax = axios
	export default{
		name:'MyBlog',
		data(){
			return {
				currentIndex:-1,
				circleType:'up-circle',
				// blogList:[],
				// blogListWithoutFolder:[]
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
				'getBlogsByFolder',
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
				if(index==this.currentIndex){
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
				}else{
					this.circleType = 'down-circle'
					this.getBlogsByFolder({
						userId:this.userInfo.userId,
						classification:folder_name,
						writerId:this.userInfo.userId
					})
					this.currentIndex = index
				}
			},
			deleteBlogHandler(blogId, folder_name){
				this.deleteBlog({
					blogId:blogId,
					userId:this.userInfo.userId,
					writerId:this.userInfo.userId,
					classification:typeof(folder_name)=="undefined"?"":folder_name
				})
				window.location.reload()
			},
			editHandler(blogId){
				this.$router.push({name:'EditBlog',query:{blogId:blogId}})
			}
		}
	}
</script>

<style>
	.my_blog{
		background-color: #dfdfdf;
		margin: 0px auto;
		width: 60%;
		height: 679px;
	}
	.folder_name{
		font-size: 24px;
	}
	.delete_button{
		float: right;
		width: 70px;
		margin-right: 10px;
	}
	.edit_button{
		float: right;
		width: 70px;
				margin-right: 10px;
	}
</style>
