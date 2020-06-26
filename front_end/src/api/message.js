import { axios } from '@/utils/request.js'
const api = {
    msg: '/api/message'
};
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
// }

// GET 通知用户 userID:Integer
// 返回messageVO
// public class MessageVO {
//     private UserDisplayVO sender;
//     private UserDisplayVO recipient;
//     private Integer blogId;
//     private Integer commentId;
//     private Integer messageId;
// }
export function getMessageByUserIdAPI(param){
	return axios({
		url:`${api.msg}/${param.userId}/getMessages`,
		method:'GET'
	})
}


// POST 添加通知 
// data:msgVO
export function addMessageAPI(data){
	return axios({
		url:`${api.msg}/addMessage`,
		method:'POST',
		data
	})
}
