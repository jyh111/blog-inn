import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'
import blog from './modules/blog'
import comment from './modules/comment'
import favor from './modules/favor'
import message from './modules/message'
import getters from './getters'
Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    blog,
    user,
    comment,
    favor,
	message
  },
  state: {
  },
  mutations: {
  },
  actions: {
  },
  getters
})