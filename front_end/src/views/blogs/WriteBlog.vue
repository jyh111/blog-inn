<!-- 写文章界面 -->
<template>
	<div>
		<Header></Header>
	<a-input v-model="title"></a-input>
	<a-textarea :value="content" :rows="10" />
	<a-button type="primary" @click="submit">提交</a-button>
	</div>
</template>

<script>
	import Vue from 'vue'
	import Vuex from 'vuex'
	import Router from "vue-router"
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	  import Header from '../../components/Header.vue';
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
		comments:{
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
				this.writeBlog({
					userId:this.userInfo.userId,
					title:this.title,
					content:this.content
				})
				console.log('router:')
				console.log(this.$router)
				this.$router.push({name:'MyBlog',query:{userId:this.userInfo.userId}})
			}
		}
	}
</script>

<style>
</style>
