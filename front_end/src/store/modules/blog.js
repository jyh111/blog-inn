import store from '@/store'
import {
    getBlogByBlogIdAPI,
    getBlogsByQueryAPI,
	patchBlogContentAPI,
	putBlogAPI,
	deleteBlogByIDAPI,
	patchBlogPageviewAPI,
	patchBlogClassification
} from '@/api/blog.js'
import {
	getBlogFoldersByUserIdAPI,
	getBlogsByFolderAPI,
	putBlogFolderAPI,
	deleteBlogFolderAPI
} from '@/api/blogFolder.js'
import { message } from 'ant-design-vue'

const blog = {
    state: {
		putFavorBlogId:0,
		blogList:[],
		blogListParams:{
			pageNo:0,
			pageSize:12
		},
		blogListLoading:true,
		blogParams:{
			blogID:0,
			writerId:0,
			title:'',
			content:'',
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
		},
		set_putFavorBlogId:function(state,data){
			state.putFavorBlogId = data
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
			console.log(res)
			// this.$router.push({name:'DisplayBlog'})
		},

		writeBlog:async({state,commit,dispatch},data)=>{
			commit('set_blogParams',{
				blogId:0,
				writerId:state.userInfo['userId'],
				content:data.content,
				pageView:0,
				title:data.title,
				isInFavor:false,
				classification:'null'
			})
			const res = await putBlogAPI(state.blogParams)
			if(res){
				commit('set_blogParams',{
					blogID:'',
					writerID:'',
					content:'',
					pageView:0,
					title:'',
					isInFavor:false,
					classification:'null'
				})
				message.success('发布成功')
				dispatch('getBlogList')
				this.$router.push({name:'MyBlog'})
			}
		},
		
		getBlogByBlogId:async({state,commit,dispatch},blogId)=>{
			const res = await getBlogByBlogIdAPI({
				blogId:blogId,
				userId:state.userInfo.userId
			})
			if(res){
				commit('set_blogParams',res)
			}else{
				console.log('获取文章失败')
			}
		},
		
		updateBlog:async({state,commit,dispatch},data)=>{
			const res = await patchBlogContentAPI({
				blogId:data.blogId,
				content:data.content,
				title:data.title
			})
			if(res){
				dispatch('getBlogByBlogId',data.blogId)
			}else{
				message.error('删除文章失败')
				console.log('更新文章失败')
			}
		},
		
		deleteBlog:async({state,commit,dispatch},blogId)=>{
			const res = await deleteBlogByIDAPI(blogId)
			if(res){
				dispatch('getBlogByBlogId',blogId)
			}else{
				message.error('删除文章失败')
				console.log('删除文章失败')
			}
		}
    }
}
export default blog