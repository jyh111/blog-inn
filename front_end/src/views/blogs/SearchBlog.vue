<!-- 搜索文章界面,显示文章列表 -->
<template>

	<div>
	<Header></Header>
  <div class="al" >
 <a-input-search placeholder="input search text" style="wIdth: 400px" size="large" class="search" @search="onSearch" />
	  </div>
  </div>

</template>

<script>
	import Vue from 'Vue'
	import Vuex from 'vuex'
	Vue.use(Vuex)
	  import Header from '../../components/Header.vue'
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:'SearchBlog',
		data(){
				return{

				}
			},
		computed:{
			...mapGetters([
				'blogList',
				'blogListParams',
				'blogListLoading',
				'blogParams',
				'queryParams',
				'userInfo'
			])
		},
		created(){
			this.set_userInfo(sessionStorage.getItem('userInfo'))
			console.log(this.userInfo)
		},
		components:{
			Header
		},
		methods:{
			...mapMutations([
				'set_blogList',
				'set_currentBlogInfo',
				'set_page_view',
				'set_blogListParams',
				'set_blogParams',
				'set_queryParams',
				'set_userInfo'
			]),
			...mapActions([
				'getBlogListByQuery',
				'getBlogList',
			]),

			onSearch(value){
				console.log('searching')
				var userId = 0
				if(typeof(this.userInfo)=="undefined"){
					userId = 0
				}else{
					userId = this.userInfo.userId
				}
				this.set_queryParams({
					keyword:value,
					userId:userId
				})
				console.log(userId)
				console.log(value)
				this.getBlogListByQuery()
				this.$router.push({name:'BlogList'})
				// this.$router.push({name:'SearchBlog'})
			}
		}
	}
</script>

<style>
	.search{
		margin-top: 300px;
		width: 30%;
	}

 .al{
   background-attachment: fixed;
   background-repeat:no-repeat;
   background-size:cover;
   width:100%;
 }

</style>
