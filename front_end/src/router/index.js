import Vue from 'vue'
import Router from 'vue-router'
import MyBlog from '@/views/blogs/MyBlog'
import SearchBlog from '@/views/blogs/SearchBlog'
Vue.use(Router)

export default new Router({
  routes: [
    {
		path:'/',
		redirect:'/searchBlog'
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
	}
  ]
})
// import Vue from 'vue'
// import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'

// Vue.use(Router)

// export default new Router({
//   routes: [
//     {
//       path: '/',
//       name: 'HelloWorld',
//       component: HelloWorld
//     }
//   ]
// })