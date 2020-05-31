<!-- 具体文章界面, 评论和回复功能 -->
<template>
	<div>
		<h1>我是具体文章</h1>
		<Comment></Comment>
	</div>
</template>

<script>
	import Vue from 'vue'
	import Comment from '@/views/comments/Comment'
	export default{
		name:'DisplayBlog',
		data(){
			return {
				
			}
		},
		components:{
			Comment,
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
