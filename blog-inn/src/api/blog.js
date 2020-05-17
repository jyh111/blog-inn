import { axios } from '@/utils/request'
const api = {
    blog: '/api/blogs'
}

// 
export function getBlogByIdAPI(param) {
    return axios({
        url: `${api.blog}/${param.blogId}/detail`,
        method: 'GET',
    })
}

// 提供更改后的content
export function patchBlog(data) {
    return axios({
        url: `${api.blog}/patchBlog`,
        method: 'POST',
        data
    })
}

// 提供完整的blogVO
export function putBlog(data){
	return axios({
	    url: `${api.blog}/putBlog`,
	    method: 'POST',
	    data
	})
}

// 删除blog
export function deleteBlogByID(param){
	
}
