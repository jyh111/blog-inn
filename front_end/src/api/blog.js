import { axios } from '@/utils/request.js'
const api = {
    blog: '/api/blogs'
};

// 得到完整的blogVO,传入userId
export function getBlogByBlogIdAPI(param) {
  return axios({
        url: `${api.blog}/${param.blogId}/detail`,
        method: 'GET',
		    param
    })
}

// POST 搜索文章, 传入一个字符串(搜索内容)
// data.query, data.userId
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
export function patchBlogContentAPI(param) {
    return axios({
        url: `${api.blog}/patchBlogContent/${param.blogId}`,
        method: 'GET',
        param
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
export function deleteBlogByIDAPI(param){
	return axios({
		url:`${api.blog}/${param.blogID}/delete`,
		method:'GET'
	})
}


// GET 浏览量加一
export function patchBlogPageviewAPI(param){
	return axios({
		url:`${api.blog}/${param.blogID}/patchBlogPageviewAPI`,
		method:'GET'
	})
}


// POST 添加文章分类
// 分类 data.classification 博客ID data.blogId
export function patchBlogClassification(data){
	return axios({
		url:`${api.blog}/patchBlogClassification`,
		method:'GET',
		data
	})
}



