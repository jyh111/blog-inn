import Vue from 'vue'
import router from '@/router'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { message } from 'ant-design-vue'
import {
    loginAPI,
    registerAPI,
    getUserInfoAPI,
    updateUserInfoAPI,
} from '@/api/user'


const getDefaultState = () => {
    return {
		token:'',
        userInfo: {
			userId: 0,
			email:'',
			username:'',
			userImg:'',
			password:'',
			self_introduction:''
        },
		userDisplay:{
			userId:'',
			username:'',
			userImg:''
		},
    }
}

const user = {
    state : {
		token: '',
		userInfo: {
			userId: 0,
			email:'',
			username:'',
			userImg:'',
			password:'',
			self_introduction:''
		},
		userDisplay:{
			userId:0,
			username:'',
			userImg:''
		}
	},

    mutations: {
        reset_state: function(state) {
            state.token = '',
            state.userInfo = {
				userId:0,
                username:'',
				userImg:''
            },
            state.userOrderList = []
        },
        set_token: function(state, token){
            state.token = token
        },
        set_userInfo: (state, data) => {
            state.userInfo = {
                ...state.userInfo,
                ...data
            }
        },
		set_userDisplay:(state,data)=>{
			state.userDisplay={
				...state.userDisplay,
				...data
			}
		},
        set_userOrderList: (state, data) => {
            state.userOrderList = data
        }
    },

    actions: {
        login: async ({ dispatch, commit }, userData) => {
			console.log(userData)
            const res = await loginAPI(userData)
            if(res){
				console.log('登录成功')
                // setToken(res.id)
                // commit('set_userId', res.id)
                // dispatch('getUserInfo')
                // router.push('/hotel/hotelList')
            }
        },
        register: async({ commit }, data) => {
            const res = await registerAPI(data)
            if(res){
                message.success('注册成功')
            }
        },
        getUserInfo({ state, commit }) {
            return new Promise((resolve, reject) => {
              getUserInfoAPI(state.userInfo.userId).then(response => {
                const data = response
                if (!data) {
                  reject('登录已过期，请重新登录')
                }
                commit('set_userInfo', data)
                commit('set_userId', data.id)
                resolve(data)
              }).catch(error => {
                reject(error)
              })
            })
        },
		getUserDisplay({ state, commit },userId) {
		    return new Promise((resolve, reject) => {
		      getUserDisplayAPI(userId).then(response => {
		        const data = response
				commit('set_userDisplay',data)
		      }).catch(error => {
		        console.log("获取userDisplay失败")
		      })
		    })
		},
        updateUserInfo: async({ state, dispatch }, data) => {
            const params = {
                id: state.userId,
                ...data,
            }
            const res = await updateUserInfoAPI(params)
            if(res){
                message.success('修改成功')
                dispatch('getUserInfo')
            }
        },
        logout: async({ commit }) => {
            removeToken()
            commit('reset_state')
        },
          // remove token
        resetToken({ commit }) {
            return new Promise(resolve => {
                removeToken() // must remove  token  first
                commit('reset_state')
                resolve()
            })
        },
    }
}

export default user
