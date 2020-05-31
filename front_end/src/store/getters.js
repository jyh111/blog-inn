const getters = {
  //blog
  // token: state => state.user.token,
	blogList:state=>state.blog.blogList,
	blogListParams:state=>state.blog.blogListParams,
	blogListLoading:state=>state.blog.blogListLoading,
	blogParams:state=>state.blog.blogParams,
	queryParams:state=>state.blog.queryParams
  }
  
  export default getters