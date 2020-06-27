<!-- 具体文章界面, 评论和回复功能 -->
<template>
	<div >
		<Header></Header>
		<a-avatar size="small" :src="userDisplay.userImg"/>
		<span>{{userDisplay.username}}</span>
		<a-icon type="heart" :theme="blogParams.isInFavor=='null'?'twoTone':'filled'"></a-icon>
		<p>{{blogParams.content}}</p>
		<span>浏览量:{{blogParams.pageView}}</span>
		<Message></Message>
	</div>
</template>

<script>
	import Vue from 'vue'
	import Message from '@/views/comments/Message'
	  import Header from '../../components/Header.vue';
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:'DisplayBlog',
		data(){
			return {

			}
		},
		components:{
			Message,
			Header
		},
		created() {
			getBlogByBlogId(this.$route.query.blogId)
			this.set_userInfo(sessionStorage.getItem('userInfo'))
		},
		computed:{
			...mapGetters([
				'blogParams',
				'userDisplay',
				'pageView'
			])
		},
		methods:{
			...mapActions([
				'getBlogByBlogId',
				
			]),
			...mapMutations([
				'set_userInfo'
			])
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
