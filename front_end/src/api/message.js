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
export function getMessageByUserID(param){
	return axios({
		url:`${api.msg}/${param.userID}/getMessages`,
		method:'GET'
	})
}
