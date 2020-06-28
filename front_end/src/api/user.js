import { axios } from '@/utils/request.js'

const api = {
    userPre: '/api/user'
}

export function loginAPI(data){
    return axios({
        url:`${api.userPre}/login`,
        method: 'POST',
        data
    })
}
// UserVO
export function registerAPI(data){
    return axios({
        url: `${api.userPre}/register`,
        method: 'POST',
        data
    })
}
//userVO
export function getUserInfoAPI(Id){
    return axios({
        url: `${api.userPre}/${Id}/getUserInfo`,
        method: 'GET'
    })
}

export function updateUserInfoAPI(data) {
    return axios({
        url: `${api.userPre}/${data.userId}/userInfo/update`,
        method: 'POST',
        data
    })
}

//userDisplayVO
export function getUserDisplayAPI(Id){
	return axios({
		url:`${api.userPre}/${Id}/getUserDisplay`,
		method:`GET`
	})
}