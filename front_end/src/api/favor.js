import { axios } from '@/utils/request.js'
const api = {
    favor: '/api/favors'
};
// POST 收藏文章 分类:params.classification string 博客ID params.blogId Integer userId:Integer
// 没有分类null 默认分类default 自定义分类
export function putFavorAPI(params){
	return axios({
		url:`${api.favor}/putFavor`,
		method:'GET',
		params,
	})
}

// GET 获取用户收藏列表 返回Favor[]
export function getFavorsByUserIdAPI(param){
	return axios({
		url:`${api.favor}/${param.userId}/getFavor`,
		method:'GET'
	})
}
