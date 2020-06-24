import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'
import blog from './modules/blog'
import comment from './modules/comment'
import favor from './modules/favor'
import message from './modules/message'
import getters from './getters'
import blogFolder from './modules/blogFolder.js'
Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    blog,
    user,
    comment,
    favor,
	message,
	blogFolder
  },
  state: {
  },
  mutations: {
  },
  actions: {
  },
  getters
})

export default store