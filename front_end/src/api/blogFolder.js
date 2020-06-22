import { axios } from '@/utils/request.js'
const api = {
    blog: '/api/blogs'
};

// userId
export function getBlogFoldersByUserIdAPI(param){
	return axios({
		url: `${api.blog}/${param.userId}/getBlogFolders`,
		method: 'GET',
		param
	})
}

// writerId userId classification
export function getBlogsByFolderAPI(param){
	return axios({
		url: `${api.blog}/${param.writerId}/getBlogsByFolder`,
		method: 'GET',
		param
	})
}

// blogFolderVO
export function putBlogFolderAPI(data){
	return axios({
		url:`$(api.blog)/${data.userId}/putBlogFolder`,
		method:'POST',
		data
	})
}

// userId, folder_name, blogId
export function insertIntoFolderAPI(param){
	return axios({
		url:`$(api.blog)/$(param.userId)/insertIntoFolder`,
		method:'GET',
		param
	})
}

// folder_name userId
export function deleteBlogFolderAPI(param){
	return axios({
		url:`$(api.blog)/$(data.userId)/deleteBlogFolder`,
		method:'GET',
		param
	})
}