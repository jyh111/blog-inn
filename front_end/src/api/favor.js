import {axios} from '@/utils/request'
const api = {
    favor: '/api/favors'
}
// POST 收藏文章 分类:string 博客ID:Integer userID:Integer
// 没有分类null 默认分类default 自定义分类 
export function putFavorAPI(data){
	return axios({
		url:`$(api.favor)/${data.userID}/putFavor`,
		method:'POST',
		data
	})
}

// GET 获取用户收藏列表 返回Favor[]
export function getFavorsByUserIDAPI(param){
	return axios({
		url:`$(api.favor)/${param.userID}/getFavor`,
		method:'GET'
	})
}