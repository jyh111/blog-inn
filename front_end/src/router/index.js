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
  routes: [
    {
		path:'/',
		redirect:'/searchBlog'
    },
	{
		path:'/myBlog',
		component:MyBlog,
		name:'MyBlog'
	},
	// 	children:[
	// 		path:'/:blogID'
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
		path:'/:blogId/displayBlog',
		name:'DisplayBlog',
		component:DisplayBlog
	},
	{
		path:'/login',
		name:'Login',
		component:Login
	},
	{
		path:'/:blogId/editBlog',
		name:'EditBlog',
		component:EditBlog
	},
  {
    path:'/register',
    name:'Register',
    component:Register
  },
  {
	  path:'/:userId/writeBlog',
	  name:'WriteBlog',
	  component:WriteBlog
  },
  {
	  path:'/:userId/userInfo',
	  name:'UserInfo',
	  component:UserInfo
  },
  {
	  path:'/:writerId/myBlog',
	  name:'MyBlog',
	  component:MyBlog
  },
  {
	  path:'/:userId/myMessage',
	  name:'MyMessage',
	  component:MyMessage
  },
  {
	  path:'/:userId/MyFavor',
	  name:'MyFavor',
	  component:MyFavor
  }
  ]
})
export default router
