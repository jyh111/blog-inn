import { axios } from '@/utils/request.js'
const api = {
    blog: '/api/blogs'
};


// 得到完整的blogVO,传入userId, 如果用户未登录,userId=0
export function getBlogByBlogIdAPI(params) {
  return axios({
        url: `${api.blog}/${params.blogId}/detail`,
        method: 'GET',
		params
    })
}

// POST 搜索文章, 传入一个字符串(搜索内容)
// data.query, data.userId
// 如果用户未登录,userId=0
// 返回值 blogVO[]
export function getBlogsByQueryAPI(data){
	return axios({
		url:`${api.blog}/query`,
		method:'POST',
		data
	})
}

// GET    更新文章内容
// param.blogId param.content param.title
export function patchBlogContentAPI(params) {
    return axios({
        url: `${api.blog}/patchBlogContent/${params.blogId}`,
        method: 'GET',
        params
    })
}

// POST 写文章 提供完整的blogVO
export function putBlogAPI(data){
	return axios({
	    url: `${api.blog}/putBlog`,
	    method: 'POST',
	    data
	})
}


// 删除blog BlogId:Integer
export function deleteBlogByIdAPI(blogId){
	return axios({
		url:`${api.blog}/${blogId}/delete`,
		method:'GET'
	})
}


// GET 浏览量加一
export function patchBlogpage_viewAPI(params){
	return axios({
		url:`${api.blog}/${params.blogId}/patchBlogPage_viewAPI`,
		method:'GET'
	})
}


// POST 添加文章分类
// 分类 data.classification 博客Id data.blogId
export function patchBlogClassificationAPI(data){
	return axios({
		url:`${api.blog}/patchBlogClassification`,
		method:'GET',
		data
	})
}



