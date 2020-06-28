<!-- 收藏详情界面 功能: 删文章, 改分类-->
<template>
	<div>
		<Header></Header>
		<a-list v-for="(item, index) in favorFolders" :key="index">
			<a-icon type="close" @click="deleteFavorFolderHandler(item.folder_name)" />
			{{item.folder_name}}
			<a-icon :type="index==currentIndex?'up-circle':'down-circle'" @click="showBlogs(item.folder_name, index)" />
			<a-list-item v-for="(item,index) in blogListInFavor" :key="index" v-if="index==currentIndex">
				<router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">{{item.title}}</router-link>
				<a-icon type="close" @click="deleteBlogHandler(item.blogId)"/>
			</a-list-item>
		</a-list>
		<a-list item-layout="horizontal" :data-source="blogListWithoutFolderInFavor">
		<a-list-item slot="renderItem" slot-scope="item, index">
		    <router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">{{item.title}}</router-link>
			<a-icon type="close" @click="deleteBlogHandler(item.blogId)"/>
		</a-list-item>
		</a-list>
	</div>
</template>

<script>
import Vue from 'vue'
  import Header from '../../components/Header.vue';
import { mapGetters, mapMutations, mapActions } from 'vuex'

	export default{
		name:"MyFavor",
		data(){
			return {
				currentIndex:-1,
			}
		},
		created() {
			this.set_userInfo(sessionStorage.getItem('userInfo'))
		},
		mounted () {
			this.getFavorFoldersByUserId(this.userInfo.userId)
			// this.$axios.get('/api/favors/'+this.userInfo.userId+'/getFavor',{
			// 	userId:this.userInfo.userId,
			// 	classfication:""
			// }).then(res=>{
			// 	this.blogListWithoutFolder = res
			// }).catch(Error=>{
			// 	console.log('获取默认收藏文章失败')
			// })
			var data = {
					userId:this.userInfo.userId,
					classification:'',
			}
			this.getFavor(data)
		},
		computed:{
			...mapGetters([
				'favorFolders',
				'userInfo',
				'blogListWithoutFolderInFavor',
				'blogListInFavor'
			])
		},
		components:{
			Header
		},
		methods:{
			...mapActions([
				'getFavorFoldersByUserId',
				'deleteFavorFolder',
				'getFavor'
			]),
			...mapMutations([
				'set_userInfo'
			]),
			showBlogs(folder_name, index){
				// this.$axios.get('/api/favors/'+this.userInfo.userId+'/getFavor',{
				// 	userId:this.userInfo.userId,
				// 	classfication:folder_name
				// }).then(res=>{
				// 	this.blogList = res
				// 	this.currentIndex = index
				// }).catch(Error=>{
				// 	console.log('获取收藏夹列表失败')
				// })
				var  data2 = {
						userId:this.userInfo.userId,
						classification:folder_name
				}
				this.getFavor(data2)
				console.log('blogListInFavor')
				console.log(this.blogListInFavor)
				this.currentIndex = index
			},
			deleteBlogHandler:(blogId)=>{
				this.deleteBlog(blogId)
				
			},
			deleteFavorFolderHandler:(folder_name)=>{
				this.deleteFavorFolder(folder_name)
			}
		}
	}
</script>

<style>
</style>
