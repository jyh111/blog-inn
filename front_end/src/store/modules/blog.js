import store from '@/store'
import {
    getBlogByBlogIdAPI,
    getBlogsByQueryAPI,
	patchBlogContentAPI,
	putBlogAPI,
	deleteBlogByIdAPI,
	patchBlogpage_viewAPI,
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
		
		blogList:[],
		blogListParams:{
			pageNo:0,
			pageSize:12
		},
		blogListLoading:true,
		blogParams:{
			blogId:0,
			writerId:0,
			title:'',
			content:'',
			page_view:0,
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
		set_page_view:function(state,data){
			state.page_view = data
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

    },
    actions: {
		getBlogListByQuery:async({state,commit,dispatch})=>{
			const res = await getBlogsByQueryAPI(state.queryParams)
			if(res){
				commit('set_blogList',res)
				commit('set_queryParams',{
					keyword:'',
					userId:'',
				})
			}
			console.log(res)
			// this.$router.push({name:'DisplayBlog'})
		},

		writeBlog:async({state,commit,dispatch},data)=>{
			commit('set_blogParams',{
				blogId:0,
				writerId:data.userId,
				content:data.content,
				page_view:0,
				title:data.title,
				isInFavor:false,
				classification:''
			})
			const res = await putBlogAPI(state.blogParams)
			if(res){
				const param = {
						userId:data.userId,
						classification:'',
						writerId:data.userId					
					}
				dispatch('getBlogsByFolder',param);
				commit('set_blogParams',{
					blogId:'',
					writerId:'',
					content:'',
					page_view:0,
					title:'',
					isInFavor:false,
					classification:''
				})
				message.success('发布成功')
			}
		},
		
		getBlogByBlogId:async({state,commit,dispatch},data)=>{
			const res = await getBlogByBlogIdAPI({
				blogId:data.blogId,
				userId:data.userId
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
				dispatch('getBlogByBlogId',{
					blogId:data.blogId,
					userId:data.userId
				})
			}else{
				console.log('更新文章失败')
			}
		},
		
		deleteBlog:async({state,commit,dispatch},data)=>{

			const res = await deleteBlogByIdAPI(data.blogId)
			if(res){
				dispatch('getBlogsByFolder',{
					userId:data.userId,
					classification:data.classification,
					writerId:data.writerId
				})
				message.success('删除成功')
			}else{
				message.error('删除失败')
			}
		},
		
		patchBlogpage_view: async({},blogId)=>{
			const res= await patchBlogpage_viewAPI(blogId);
			if(!res){
				message.error('浏览量增加失败')
			}
		}
    }
}
export default blog