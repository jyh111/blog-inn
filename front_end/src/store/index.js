import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'
import blog from './modules/blog'
import comment from './modules/comment'
import favor from './modules/favor'
import msg from './modules/message'
import getters from './getters'
import blogFolder from './modules/blogFolder.js'
Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    blog,
	blogFolder,
    user,
    comment,
    favor,
	msg,
  },
  state:sessionStorage.getItem('state') ? JSON.parse(sessionStorage.getItem('state')): {
  },
  mutations: {
  },
  actions: {
  },
  getters
})

export default store