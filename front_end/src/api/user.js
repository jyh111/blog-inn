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
export function getUserInfoAPI(id){
    return axios({
        url: `${api.userPre}/${id}/getUserInfo`,
        method: 'GET'
    })
}

export function updateUserInfoAPI(data) {
    return axios({
        url: `${api.userPre}/${data.id}/userInfo/update`,
        method: 'POST',
        data
    })
}

//userDisplayVO
export function getUserDisplayAPI(id){
	return axios({
		url:`${api.userPre}/${id}/getUserDisplay`,
		method:`GET`
	})
}