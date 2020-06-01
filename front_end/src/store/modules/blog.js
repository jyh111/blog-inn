import store from '@/store'
import {
    getBlogByBlogIdAPI,
    getBlogsByQueryAPI,
	patchBlogContentAPI,
	putBlogAPI,
	deleteBlogByIDAPI,
	patchBlogPageviewAPI,
	getBlogsByUserIDAPI,
	patchBlogClassification
} from '@/api/blog.js'
import { message } from 'ant-design-vue'

const blog = {
    state: {
		blogList:[],
		blogListParams:{
			pageNo:0,
			pageSize:12
		},
		blogListLoading:true,
		blogParams:{
			blogID:'',
			writerId:'',
			content:'',
			commentList:[],
			pageView:0,
			isInFavor:false,
			classification:''
		},
		queryParams:{
			keyword:'',
			userId:'',
		}
    },
    mutations: {
		set_blogList:function(state,data){
			state.blogList = data
		},
		set_currentBlogInfo:function(state,data){
			state.currentBlogInfo = {
				...state.currentBlogInfo,
				...data
			}
		},
		set_pageView:function(state,data){
			state.pageView = data
		},
		set_blogListParams:function(state,data){
			state.blogListParams={
				...state.blogListParams,
				...data
			}
		},
		set_blogParams:function(state,data){
			state.blogParams = {
				...state.blogParams,
				...data
			}
		},
		set_queryParams:function(state,data){
			state.queryParams={
				...state.queryParams,
				...data
			}
		}
		
    },
    actions: {
		getBlogListByQuery:async({state,commit,dispatch})=>{
			const res = await getBlogsByQueryAPI(state.queryParams)
			if(res){
				commit('set_blogList',res)
				commit('set_queryParams',{
					keyword:'',
					userID:'',
				})
			}
			// this.$router.push({name:'DisplayBlog'})
			this.$router.push('/blogList')
		},
		writeBlog:async({state,commit,dispatch})=>{
			const res = await putBlogAPI(state.blogParams)
			if(res){
				commit('set_blogParams',{
					blogID:'',
					writerID:'',
					content:'',
					commentList:[],
					pageView:0,
					isInFavor:false,
					classification:''
				})
				message.success('发布成功')
				dispatch('getBlogList')
				this.$router.push({name:'MyBlog'})
			}
		},
		getBlogList:async({state, commit, dispatch})=>{
			const res = await getBlogsByUserIDAPI(state.userId)
			if(res){
				commit('set_blogList',res)
			}
		}
    }
}
export default blog