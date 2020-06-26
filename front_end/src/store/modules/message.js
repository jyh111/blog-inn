import store from '@/store'
import { message } from 'ant-design-vue'
import{
	getMessageByUserIdAPI
} from '@/api/message.js'
const msg = {
	state:{
		msgList:[],
	},
	mutations:{
		set_msgList:function(state,data){
			state.msgList = data
		}
	},
	actions:{
		getMsgList:async({state,commit,dispatch})=>{
			const res = await getMessageByUserIdAPI({
				userId:state.userInfo.userId
			})
			if(res){
				commit('set_msgList',res)
			}
		},
		addMessage:async({state,commit,dispatch})=>{
			
		}
	}
}
export default msg