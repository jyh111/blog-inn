<!-- 具体文章界面, 评论和回复功能 -->
<template>
	<div >
		<Header></Header>
		<AddFavor></AddFavor>
		<div class="display_blog_content">
		<h2>{{blogParams.title}}</h2>
		<a-avatar size="small" src="../../static/image/default_logo.jpg"/>
		<span>{{userDisplay.username}}</span>
		<a-icon type="heart" :theme="blogParams.isInFavor=='null'?'twoTone':'filled'" @click="addFavorHandler" style="float: right; wIdth: 30px;"/>
		<p>{{blogParams.content}}</p>
		<span class="page_view">浏览量:{{blogParams.page_view}}</span>
		</div>
		<Message></Message>
	</div>
</template>

<script>
	import Vue from 'vue'
	import Message from '@/views/comments/Message'
	import {message} from 'ant-design-vue'
	  import Header from '../../components/Header.vue'
	  import AddFavor from '@/views/favors/AddFavor'
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:'DisplayBlog',
		data(){
			return {

			}
		},
		components:{
			Message,
			Header,
			AddFavor
		},
		created(){
			this.set_userInfo(sessionStorage.getItem('userInfo'))
			this.patchBlogpage_view(this.$route.query.blogId);
		},
		mounted() {
			this.getBlogByBlogId({
				blogId:this.$route.query.blogId,
				userId:this.userInfo.userId
				})
			
			this.getUserDisplay(this.blogParams.writerId)
		},
		computed:{
			...mapGetters([
				'blogParams',
				'userDisplay',
				'page_view',
				'userInfo',
				'addFavorVisible'
			])
		},
		methods:{
			...mapActions([
				'getBlogByBlogId',
				'getUserDisplay',
				'deleteFavor',
				'patchBlogpage_view'
			]),
			...mapMutations([
				'set_userInfo',
				'set_addFavorVisible',
			]),
			addFavorHandler(){
				if(this.userInfo.userId==0){
					message.error('请登录')
				}else{
				if(this.blogParams.isInFavor=='null'){
				this.set_addFavorVisible(true)
				console.log('set_addFavorVisible')
				console.log(this.addFavorVisible)
				}else{
					this.deleteFavor({
						userId:this.userInfo.userId,
						blogId:this.$route.query.blogId,
						classification:"null",
					})
				}
				this.getBlogByBlogId({
					blogId:this.$route.query.blogId,
					userId:this.userInfo.userId
				})
				}
			}
		}
	}
	// 第一种方式
	// import ant from 'ant-design-vue'
	// import 'ant-design-vue/dist/antd.css'
	// Vue.use(ant)
	// 第二种方式
	// import {Button} from 'ant-design-vue'
</script>
<a-button></a-button>
<style>
	.display_blog_content{
		wIdth: 80%;
		text-align: left;
		padding: 10px 0 20px 0;
		background-color: #e1e1e1;
		margin: 0 auto;
	}
	
	.page_view{
		float: right;
		padding-bottom: 15px;
	}
</style>
