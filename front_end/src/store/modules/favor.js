import store from '@/store'
import { message } from 'ant-design-vue'
import {
	putFavorAPI,
	getFavorsAPI
} from '@/api/favor.js'
import{
	getFavorFoldersByUserIdAPI,
	putFavorFolderAPI,
	deleteFavorFolderAPI
}from '@/api/favorFolder.js'
const favor = {
	state:{
		blogListWithoutFolderInFavor:[],
		blogListInFavor:[],
		putFavorBlogId:0,
		addFavorVisible:false,
		favorFolders:[],
		favorFolderParam:{
			userId:0,
			folder_name:''
		}
	},
	mutations:{
		set_addFavorVisible:function(state,data){
			state.addFavorVisible = data
		},
		set_favorFolders:function(state,data){
			state.favorFolders = data
		},
		set_favorFolderParam:function(state,data){
			state.favorFolderParam={
				...state.favorFolderParam,
				...data
			}
		},
		set_blogListWithoutFolderInFavor:function(state,data){
			state.blogListWithoutFolderInFavor = data
		},
		set_putFavorBlogId:function(state,data){
			state.putFavorBlogId = data
		},
		set_blogListInFavor:function(state,data){
			state.blogListInFavor = data
		}
	},
	actions:{
		addFavorFolder:async({state,commit,dispatch},param)=>{
			const res = await putFavorFolderAPI(param)
			if(res){
				dispatch('getFavorFoldersByUserId')
				message.success('新建收藏夹成功')
			}else{
				message.error('新建收藏夹失败')
				console.log('新建收藏夹失败')
			}
		},
		getFavorFoldersByUserId:async({state,commit,dispatch},userId)=>{
			const res = await getFavorFoldersByUserIdAPI(userId)
			if(res){
				commit('set_favorFolders',res)
			}else{
				console.log('获取收藏夹列表失败')
			}
		},
		deleteFavorFolder:async({state,commit,dispatch},data)=>{
			const res = await deleteFavorFolderAPI({
				userId:data.userId,
				folder_name:data.folder_name
			})
			if(res){
				dispatch('getFavorFoldersByUserId',data.userId)
			}else{
				console.log('删除收藏夹失败')
			}
		},
		putFavor:async({state,commit,dispatch},data)=>{
			const res = await putFavorAPI(data)
			if(res){
				message.success('收藏成功')
				dispatch('getBlogByBlogId',{
					userId:data.userId,
					blogId:data.blogId
				})
			}
		},
		getFavor:async({state,commit,dispatch},data)=>{
			console.log('getFavor:')
			console.log(data)
			const res = await getFavorsAPI(data)
			if(res){
			if(data.classfication==""){
				commit('set_blogListWithoutFolderInFavor',res)
			}else{
				commit('set_blogListInFavor',res)
			}
			}else{
				message.error("获取收藏失败")
			}
			
		},
		deleteFavor:async({state,commit,dispatch},data)=>{
			const res = await putFavorAPI(data)
			if(res){
				message.success('取消收藏成功')
				dispatch('getBlogByBlogId',{
					userId:data.userId,
					blogId:data.blogId
				})
			}
		}
	}
}
export default favor