import store from '@/store'
import { message } from 'ant-design-vue'
import {
	putFavorAPI
} from '@/api/favor.js'
import{
	getFavorFoldersByUserIdAPI,
	putFavorFolderAPI,
	getFavorsByUserIdAPI
}from '@/api/favorFolder.js'
const favor = {
	state:{
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
		}
	},
	actions:{
		addFavorFolder:async({state,commit,dispatch},folder_name)=>{
			const res = await putFavorFolderAPI({
				userId:state.userInfo.userId,
				folder_name:folder_name
			})
			if(res){
				dispatch(getFavorFoldersByUserId)
			}else{
				message.error('新建收藏夹失败')
				console.log('新建收藏夹失败')
			}
		},
		getFavorFoldersByUserId:async({state,commit,dispatch})=>{
			const res = await getFavorFoldersByUserIdAPI(state.userInfo.userId)
			if(res){
				commit('set_favorFolders',res)
			}else{
				console.log('获取收藏夹列表失败')
			}
		}
	}
}
export default favor