import store from '@/store'
import { message } from 'ant-design-vue'
import{
	getMessageByUserIdAPI,
	addMessageAPI
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
		getMsgList:async({state,commit,dispatch},userId)=>{
			const res = await getMessageByUserIdAPI({
				userId:userId
			})
			if(res){
				commit('set_msgList',res)
			}
		},
		addMessage:async({state,commit,dispatch},data)=>{
			const res = await addMessageAPI(data)
		}
	}
}
export default msg