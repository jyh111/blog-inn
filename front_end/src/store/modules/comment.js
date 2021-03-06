import store from '@/store'
import { message } from 'ant-design-vue'
import {
	putCommentAPI,
	getCommentByBlogIdAPI
} from '@/api/comment.js'
const comment = {
	state:{
		commentList:[],
		commentParams:{
			commentId:0,
			content:'',
			reviewer:{
				userId:0,
				username:'',
				userimg:''
			},
			recipient:{
				userId:0,
				username:'',
				userImg:''
			},
			blogId:0
		},
		replyModalVisible:false
	},
	mutations:{
		set_commentList:function(state,data){
			state.commentList = data
		},
		set_commentParams:function(state,data){
			state.commentParams={
				...state.commentParams,
				...data
			}
		},
		set_blogId:function(state,data){
			state.blogId = data
		},
		set_replyModalVisible(state,data){
			state.replyModalVisible = data
		}
	},
	actions:{
		getCommentListByBlogId:async({state,commit,dispatch},blogId)=>{
			console.log('blogId'+blogId)
			const res = await getCommentByBlogIdAPI(blogId)
			if(res){
				commit('set_commentList',res)
			}else{
				message.error('获取评论失败')
			}
		},
		addComment:async({state,commit,dispatch},data)=>{
			console.log('addComment')
			console.log(data)
			const res = await putCommentAPI(data)
			if(res){
				dispatch('getCommentListByBlogId',data.blogId)
			    message.success('评论成功')				
			}else{
			    message.error('评论失败')
			}
		}
	}
}
export default comment