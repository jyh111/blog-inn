const getters = {
  //blog
  // token: state => state.user.token,
	blogList:state=>state.blog.blogList,
	blogListParams:state=>state.blog.blogListParams,
	blogListLoading:state=>state.blog.blogListLoading,
	blogParams:state=>state.blog.blogParams,
	queryParams:state=>state.blog.queryParams,
	//user
	token: state => state.user.token,
	// userId: state => state.user.userId,
	userInfo: state => state.user.userInfo,
	//comment
	commentList:state=>state.comment.commentList,
	commentParams:state=>state.comment.commentParams,
	blogId:state=>state.comment.blogId
  }
  
  export default getters