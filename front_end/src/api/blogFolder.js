import { axios } from '@/utils/request.js'
const api = {
    blog: '/api/blogFolders'
};

// userId
export function getBlogFoldersByUserIdAPI(userId){
	return axios({
		url: `${api.blog}/${userId}/getBlogFolders`,
		method: 'GET',
	})
}

// writerId userId classification
export function getBlogsByFolderAPI(params){
	return axios({
		url: `${api.blog}/getBlogsByFolder`,
		method: 'GET',
		params
	})
}

// blogFolderVO
export function putBlogFolderAPI(data){
	return axios({
		url:`${api.blog}/${data.userId}/putBlogFolder`,
		method:'POST',
		data
	})
}

// // userId, folder_name, blogId
// export function insertIntoFolderAPI(param){
// 	return axios({
// 		url:`$(api.blog)/$(param.userId)/insertIntoFolder`,
// 		method:'GET',
// 		param
// 	})
// }

// folder_name userId
export function deleteBlogFolderAPI(param){
	return axios({
		url:`$(api.blog)/$(param.userId)/deleteBlogFolder`,
		method:'GET',
		param
	})
}