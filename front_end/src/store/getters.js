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
	isLogin:state=>state.user.isLogin,
	// userId: state => state.user.userId,
	userInfo: state => state.user.userInfo,
	userDisplay:state=>state.user.userDisplay,
	//comment
	commentList:state=>state.comment.commentList,
	commentParams:state=>state.comment.commentParams,
	blogId:state=>state.comment.blogId,
	//message
	msgList:state=>state.msg.msgList,
	//blogFolder
	blogListInMyBlog:state=>state.blogFolder.blogListInMyBlog,
	blogListWithoutFolderInMyBlog:state=>state.blogFolder.blogListWithoutFolderInMyBlog,
	blogFolders:state=>state.blogFolder.blogFolders,
	blogFolderParams:state=>state.blogFolder.blogFolders,
	//favor
	addFavorVisible:state=>state.favor.addFavorVisible,
	favorFolders:state=>state.favor.favorFolders,
	favorFolderParam:state=>state.favor.favorFolderParam,
	putFavorBlogId:state=>state.favor.putFavorBlogId,
	blogListInFavor:state=>state.favor.blogListInFavor,
	blogListWithoutFolderInFavor:state=>state.favor.blogListWithoutFolderInFavor
  }
  
  export default getters