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
	userDisplay:state=>state.user.userDisplay,
	//comment
	commentList:state=>state.comment.commentList,
	commentParams:state=>state.comment.commentParams,
	blogId:state=>state.comment.blogId,
	//message
	msgList:state=>state.message.msgList,
	//blogFolder
	blogListInFolder:state=>state.blogFolder.blogListInFolder,
	blogFolders:state=>state.blogFolder.blogFolders,
	blogFolderParams:state=>state.blogFolder.blogFolders,
	//favor
	addFavorVisble:state=>state.favor.addFavorVisble,
	favorFolders:state=>state.favor.favorFolders,
	favorFolderParam:state=>state.favor.favorFolderParam,
	putFavorBlogId:state=>state.favor.putFavorBlogId
  }
  
  export default getters