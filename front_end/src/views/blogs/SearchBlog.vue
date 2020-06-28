<!-- 搜索文章界面,显示文章列表 -->
<template>

	<div>
	<Header></Header>
  <div class="al" >
	  <div>
	  	<a-input-search
	  	      placeholder="input search text"
	  	      enter-button="Search"
	  	      size="large"
	  	      @search="onSearch"
	  		    class="search"
	  	    />
	  </div>
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
				'set_pageView',
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
		padding-top: 150px;
		width: 40%;
		margin-top: 150px;
	}

 .al{
   background-attachment: fixed;
   background-repeat:no-repeat;
   background-size:cover;
   width:100%;
 }

</style>
