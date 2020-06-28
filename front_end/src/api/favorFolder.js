import { axios } from '@/utils/request.js'
const api={
	favorFolder:'/api/favorFolders'
}

export function getFavorFoldersByUserIdAPI(userId){
	return axios({
		url:`${api.favorFolder}/${userId}/getFavorFolders`,
		method:'GET',
	})
}

export function putFavorFolderAPI(data){
	return axios({
		url:`${api.favorFolder}/${data.userId}/putFavorFolder`,
		method:'POST',
		data
	})
}

export function deleteFavorFolderAPI(params){
	return axios({
		url:`${api.favorFolder}/${params.userId}/deleteFavorFolder`,
		method:'GET',
		params
	})
}