import Vue from 'vue'
import Router from 'vue-router'
import MyBlog from '@/views/blogs/MyBlog'
import SearchBlog from '@/views/blogs/SearchBlog'
import BlogList from '@/views/blogs/BlogList'
import DisplayBlog from '@/views/blogs/DisplayBlog'
import Login from '@/views/Login'
Vue.use(Router)

export default new Router({
  routes: [
    {
		path:'/',
		redirect:'/login'
    },
	// {
	// 	path:'/myBlog',
	// 	component:MyBlog,
	// 	name:'MyBlog',
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
    path:'/register',
    name:'Register',
    component:Register
  }
  ]
})
