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
		putFavorBlogId:0,
		addFavorVisble:false,
		favorFolders:[],
		favorFolderParam:{
			userId:0,
			folder_name:''
		}
	},
	mutations:{
		set_addFavorVisble:function(state,data){
			state.addFavorVisble = data
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
		set_putFavorBlogId:function(state,data){
			state.putFavorBlogId = data
		}
	},
	actions:{
		addFavorFolder:async({state,commit,dispatch},folder_name)=>{
			const res = await putFavorFolderAPI({
				userId:state.userInfo.userId,
				folder_name:folder_name
			})
			if(res){
				dispatch('getFavorFoldersByUserId')
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
		deleteFavorFolder:async({state,commit,dispatch},folder_name)=>{
			const res = await deleteFavorFolderAPI({
				userId:state.userInfo.userId,
				folder_name:folder_name
			})
			if(res){
				dispatch('getFavorFoldersByUserId')
			}else{
				console.log('删除收藏夹失败')
			}
		},
		putFavor:async({state,commit,dispatch},classification)=>{
			const res = await putFavorAPI({
				userId:state.userInfo.userId,
				classification:classification,
				blogId:state.putFavorBlogId
			})
		},
	}
}
export default favor