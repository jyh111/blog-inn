<!-- 写文章界面 -->
<template>
	<div>
	<Header></Header>
	<div class="write_blog">
	<a-input v-model="title"></a-input>
	<a-textarea v-model="content" :rows="18" />
	<a-button type="primary" @click="submit">提交</a-button>
	</div>
	</div>
</template>

<script>
	import Vue from 'vue'
	import Vuex from 'vuex'
	import Router from "vue-router"
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	  import Header from '@/components/Header.vue';
	  Vue.use(Router);
	export default{
		name:'WriteBlog',
		data(){
			return{
				content:'',
				title:''
			}
		},
		created() {
			this.set_userInfo(sessionStorage.getItem('userInfo'))
		},
		computed:{
			...mapGetters([
				'blogParams',
				'userInfo'
			])
		},
		components:{
			Header
		},
		methods:{
			...mapActions([
				'writeBlog',

			]),
			...mapMutations([
				'set_userInfo'
			]),
			submit(){
				console.log('这是content')
				console.log(this.content);
				this.writeBlog({
					userId:this.userInfo.userId,
					title:this.title,
					content:this.content
				})
				this.$router.push({name:'MyBlog',query:{userId:this.userInfo.userId}})
			}
		}
	}
</script>

<style>
	.write_blog{
		width: 80%;
		margin: 100px auto;
		padding: 10px 0 20px 0;
		background-color: #e1e1e1;
	}
</style>
