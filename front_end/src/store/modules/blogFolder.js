import store from '@/store'
import {
	getBlogFoldersByUserIdAPI,
	getBlogsByFolderAPI,
	putBlogFolderAPI,
	deleteBlogFolderAPI,
} from '@/api/blogFolder.js'

import{
	patchBlogClassificationAPI
}from '@/api/blog.js'
import { message } from 'ant-design-vue'

const blogFolder = {
	state:{
		blogListInMyBlog:[],
		blogListWithoutFolderInMyBlog:[],
		blogFolders:[],
		blogFolderParams:{
			userId:0,
			folder_name:''
		}
	},
	mutations:{
		set_blogFolderParams:function(state,data){
			state.blogFolderParams={
				...state.blogFolderParams,
				...data
			}
		},
		set_blogFolders:function(state,data){
			state.blogFolders = data
		},
		set_blogListInMyBlog:function(state,data){
			state.blogListInMyBlog = data
		},
		set_blogListWithoutFolderInMyBlog:function(state,data){
			state.blogListWithoutFolderInMyBlog = data
		}
	},
	actions:{
		getBlogFoldersByUserId:async({state,commit,dispatch},userId)=>{
			console.log(userId)
			console.log('getBlogFoldersByUserId:'+userId)
			const res = await getBlogFoldersByUserIdAPI(userId)
			if(res){
				commit('set_blogFolders',res)
			}else{
				message.error('获取博客失败')
			}
		},
		addFolder:async({state,commit,dispatch},param)=>{
			const res = await putBlogFolderAPI(param)
			if(res){
				message.success('添加成功')
				dispatch('getBlogFoldersByUserId',param.userId)
			}
		},
		getBlogsByFolder:async({state,commit,dispatch},data)=>{
			const res = await getBlogsByFolderAPI(data)
			if(res){
				console.log(res)
				if(data.classification==""){
					commit('set_blogListWithoutFolderInMyBlog',res)
				}else{
					commit('set_blogListInMyBlog',res)
				}
			}else{
				message.error('获取文章失败')
			}
		},
		insertIntoFolder:async({state,commit,dispatch},data)=>{
			const res = await patchBlogClassificationAPI({
				classification:data.folder_name,
				blogId:data.blogId
			})
			if(res){
				// blogListInFolder.push({
				// 	blogList:res,
				// 	folder_name:data.folder_name
				// })
				dispatch('getBlogsByFolder',{
					writerId:state.userInfo.userId,
					folder_name:data.folder_name
				})
			}
		},
		deleteBlogFolder:async({state,commit,dispatch},data)=>{
			const res = await deleteBlogFolderAPI({
				userId:data.userId,
				folder_name:data.folder_name
			})
			if(res){
				dispatch('getBlogFoldersByUserId',data.userId)
			}else{
				message.error("删除文件夹失败")
			}
		}

	}
}
export default blogFolder