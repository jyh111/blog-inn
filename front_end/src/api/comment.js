import { axios } from '@/utils/request.js'
const api = {
    commment: '/api/comments'
}
// export function getManagerListAPI(){
//     return axios({
//         url: `${api.adminPre}/getAllManagers`,
//         method: 'POST'
//     })
// }
// export function addManagerAPI(data) {
//     return axios({
//         url: `${api.adminPre}/addManager`,
//         method: 'POST',
//         data
//     })



// POST 添加评论
 //评论内容:string data.content
 //评论者ID:Integer data.commentorID
 //被评论者ID:Integer data.repliedUserID
 //博客ID: Integer data.blogID
 // 后台自动添加通知
export function putCommentAPI(data){
	return axios({
		url:`$(api.comment)/putComment`,
		method:'POST',
		data
	})
}

// GET 获取评论列表 Comment[]
export function getCommentByBlogIDAPI(){
	return axios({
		url:`$(api.comment)/getCommentByBlogID`,
		method:'GET'
	})
}



