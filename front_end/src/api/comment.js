import { axios } from '@/utils/request.js'
const api = {
    comment: '/api/comments'
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
// 评论ID:string data.commentId
 //评论内容:string data.content
 //评论者ID:Integer data.commentorId
 //被评论者ID:Integer data.repliedUserId
 //博客ID: Integer data.blogId
 // 后台自动添加通知
export function putCommentAPI(data){
	return axios({
		url:`${api.comment}/putComment`,
		method:'POST',
		data
	})
}

// GET 获取评论列表 Comment[]
export function getCommentByBlogIDAPI(blogId){
	return axios({
		url:`${api.comment}/${blogId}/getCommentByBlogId`,
		method:'GET'
	})
}



