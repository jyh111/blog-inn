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
		blogListInFolder:[],
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
		addFolder:async({state,commit,dispatch},folder_name)=>{
			const res = await putBlogFolderAPI({
				userId:state.userInfo.userId,
				folder_name:folder_name,
			})
			if(res){
				console.log('添加成功')
				dispatch('getBlogFoldersByUserId',state.userInfo.userId)
			}
		},
		getBlogsByFolder:async({state,commit,dispatch},data)=>{
			const res = await getBlogsByFolderAPI({
				userId:data.userId,
				classification:data.classification,
				writerId:data.writerId,
			})
			if(res){
				var j, len, isInList=false;
				var j, len;
				for(j=0,len=blogListInFolder.length;j<len;j++){
					if(blogListInFolder[j].folder_name == data.folder_name){
						isInList = true
						blogListInFolder[j].blogList = res
					}
				}
				if(!isInList){
					blogListInFolder.push({
						blogList:res,
						folder_name:data.classification
					})
				}
				commit('set_blogFolderParams',{
					userId:0,
					folder_name:''
				})
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
		deleteBlogFolder:async({state,commit,dispatch},folder_name)=>{
			const res = await deleteBlogFolderAPI({
				userId:state.userInfo.userId,
				folder_name:folder_name
			})
			if(res){
				dispatch('getBlogFoldersByUserId',state.userInfo.userId)
			}else{
				message.error("删除文件夹失败")
			}
		}

	}
}
export default blogFolder