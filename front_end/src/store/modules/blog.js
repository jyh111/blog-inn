import store from '@/store'
import {
    getBlogByBlogIdAPI,
    getBlogsByQueryAPI,
	patchBlogContentAPI,
	putBlogAPI,
	deleteBlogByIDAPI,
	patchBlogPageviewAPI,
	getBlogsByUserIDAPI,
	patchBlogClassification
} from '@/api/blog.js'
import { message } from 'ant-design-vue'

const blog = {
    state: {
		// state: {
		//     hotelList: [
		        
		//     ],
		//     hotelListParams: {
		//         pageNo: 0,
		//         pageSize: 12
		//     },
		//     hotelListLoading: true,
		//     currentHotelId: '',
		//     currentHotelInfo: {
		
		//     },
		//     orderModalVisible: false,
		//     currentOrderRoom: {
		
		//     },
		//     orderMatchCouponList: [
		
		//     ]
		
		// addHotelParams: {
		//     name: '',
		//     address: '',
		//     bizRegion:'XiDan',
		//     hotelStar:'',
		//     rate: 0,
		//     description:'',
		//     phoneNum:'',
		//     managerId:'',
		// },
		blogList:[],
		blogListParams:{
			pageNo:0,
			pageSize:12
		},
		blogListLoading:true,
		blogParams:{
			blogID:'',
			writerID:'',
			content:'',
			commentList:[],
			pageView:0,
			isInFavor:false,
			classification:''
		},
		queryParams:{
			keyword:'',
			userID:'',
		}
    },
    mutations: {
		set_blogList:function(state,data){
			state.blogList = data
		},
		set_currentBlogInfo:function(state,data){
			state.currentBlogInfo = {
				...state.currentBlogInfo,
				...data
			}
		},
		set_pageView:function(state,data){
			state.pageView = data
		},
		set_blogListParams:function(state,data){
			state.blogListParams={
				...state.blogListParams,
				...data
			}
		},
		set_blogParams:function(state,data){
			state.blogParams = {
				...state.blogParams,
				...data
			}
		},
		set_queryParams:function(state,data){
			state.queryParams={
				...state.queryParams,
				...data
			}
		}
		
    //     set_hotelList: function(state, data) {
    //         state.hotelList = data
    //     },
    //     set_hotelListParams: function(state, data) {
    //         state.hotelListParams = {
    //             ...state.hotelListParams,
    //             ...data,
    //         }
    //     },
    //     set_hotelListLoading: function(state, data) {
    //         state.hotelListLoading = data
    //     },
    //     set_currentHotelId: function(state, data) {
    //         state.currentHotelId = data
    //     },
    //     set_currentHotelInfo: function(state, data) {
    //         state.currentHotelInfo = {
    //             ...state.currentHotelInfo,
    //             ...data,
    //         }
    //     },
    //     set_orderModalVisible: function(state, data) {
    //         state.orderModalVisible = data
    //     },
    //     set_currentOrderRoom: function(state, data) {
    //         state.currentOrderRoom = {
    //             ...state.currentOrderRoom,
    //             ...data,
    //         }
    //     },
    //     set_orderMatchCouponList: function(state, data) {
    //         state.orderMatchCouponList = data
    //     }
    // },
    },
    actions: {
		getBlogListByQuery:async({state,commit,dispatch})=>{
			const res = await getBlogsByQueryAPI(state.queryParams)
			if(res){
				commit('set_blogList',res)
				commit('set_queryParams',{
					keyword:'',
					userID:'',
				})
			}
		},
		writeBlog:async({state,commit,dispatch})=>{
			const res = await putBlogAPI(state.blogParams)
			if(res){
				commit('set_blogParams',{
					blogID:'',
					writerID:'',
					content:'',
					commentList:[],
					pageView:0,
					isInFavor:false,
					classification:''
				})
				message.success('发布成功')
				dispatch('getBlogList')
				this.$router.push({name:'MyBlog'})
			}
		},
		getBlogList:async({state, commit, dispatch})=>{
			const res = await getBlogsByUserIDAPI(state.userId)
			if(res){
				commit('set_blogList',res)
			}
		}
        // getManagerList: async({ commit }) => {
        //     const res = await getManagerListAPI()
        //     if(res){
        //         commit('set_managerList', res)
        //     }
        // },
        // addManager: async({ state, commit, dispatch }) => {
        //     const res = await addManagerAPI(state.addManagerParams)
        //     if(res) {
        //         commit('set_addManagerParams',{
        //             email:'',
        //             password:''
        //         })
        //         commit('set_addManagerModalVisible', false)
        //         message.success('添加成功')
        //         dispatch('getManagerList')
        //     }else{
        //         message.error('添加失败')
        //     }
        // }
    }
}
export default admin