<!-- 具体文章界面, 评论和回复功能 -->
<template>
	<div >
		<Header></Header>
		<AddFavor></AddFavor>
		<a-avatar size="small" :src="userDisplay.userImg"/>
		<span>{{userDisplay.username}}</span>
		<a-icon type="heart" :theme="blogParams.isInFavor=='null'?'twoTone':'filled'" @click="addFavorHandler"/>
		<p>{{blogParams.content}}</p>
		<span>浏览量:{{blogParams.page_view}}</span>
		<Message></Message>
	</div>
</template>

<script>
	import Vue from 'vue'
	import Message from '@/views/comments/Message'
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
				'getUserDisplay'
			]),
			...mapMutations([
				'set_userInfo',
				'set_addFavorVisible',
			]),
			addFavorHandler(){
				// if(this.blogParams.isInFavor==false){
				this.set_addFavorVisible(true)
				console.log('set_addFavorVisible')
				console.log(this.addFavorVisible)
				// }else{
					
				// }
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
</style>
