<!-- 搜索文章界面,显示文章列表 -->
<template>
	<div>
		<a-input-search
		      placeholder="input search text"
		      enter-button="Search"
		      size="large"
		      @search="onSearch"
			  class="search"
		    />
	</div>
</template>

<script>
	import Vue from 'Vue'
	import Vuex from 'vuex'
	Vue.use(Vuex)
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
		methods:{
			...mapMutations([
				'set_blogList',
				'set_currentBlogInfo',
				'set_pageView',
				'set_blogListParams',
				'set_blogParams',
				'set_queryParams'
			]),
			...mapActions([
				'getBlogListByQuery',
				'getBlogList',
			]),
			onSearch:(value)=>{
				console.log('searching')
				console.log(this.$store)
				this.$store.commit('set_queryParams',{
					keyword:value,
					userId:1
				})
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
		border-radius: 15px;
		width: 40%;
	}
</style>
