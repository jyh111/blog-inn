import Vue from 'vue'
import Router from 'vue-router'
import store from '../store'
import MyBlog from '@/views/blogs/MyBlog'
import SearchBlog from '@/views/blogs/SearchBlog'
import BlogList from '@/views/blogs/BlogList'
import DisplayBlog from '@/views/blogs/DisplayBlog'
import Login from '@/views/Login'
import EditBlog from '@/views/blogs/EditBlog'
import Register from '@/views/Register'
import WriteBlog from '@/views/blogs/WriteBlog'
import UserInfo from '@/views/users/UserInfo'
import MyMessage from '@/views/users/MyMessage'
import MyFavor from '@/views/favors/MyFavor'
Vue.use(Router)

const router =  new Router({
	mode:'history',
  routes: [
    {
		path:'/',
		redirect:'/searchBlog'
    },
	// 	children:[
	// 		path:'/:blogId'
	// 	]
	// },
	{
		path:'/searchBlog',
		name:'SearchBlog',
		component:SearchBlog,
	},
	{
		path:'/blogList',
		name:'BlogList',
		component:BlogList
	},
	{
		path:'/displayBlog',
		name:'DisplayBlog',
		component:DisplayBlog
	},
	{
		path:'/login',
		name:'Login',
		component:Login
	},
	{
		path:'/editBlog',
		name:'EditBlog',
		component:EditBlog
	},
  {
    path:'/register',
    name:'Register',
    component:Register
  },
  {
	  path:'/writeBlog',
	  name:'WriteBlog',
	  component:WriteBlog
  },
  {
	  path:'/userInfo',
	  name:'UserInfo',
	  component:UserInfo
  },
  {
	  path:'/myBlog',
	  name:'MyBlog',
	  component:MyBlog
  },
  {
	  path:'/myMessage',
	  name:'MyMessage',
	  component:MyMessage
  },
  {
	  path:'/myFavor',
	  name:'MyFavor',
	  component:MyFavor
  }
  ]
})
export default router
