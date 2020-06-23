<template>
	<div>
	<h2>注册界面</h2>
	  <input type="text" placeholder="请输入您的邮箱" v-model="email" />
	  <input type="text" placeholder="请输入用户名" v-model="username" />
	  <input type="password" placeholder="请输入密码" v-model="password" />
    <input type="password" placeholder="确认密码" v-model="password2" />
    <el-alert v-show="npassword2Err" title="重复密码错误" type="error" show-icon:closable="false"> </el-alert>
    <div @click="newRegister" v-loading.fullscreen.lock="fullscreenLoading"  element-loading-text="提交中">注册</div>
	  <button v-on:click="register">注&nbsp;&nbsp;册</button>

	  <!-- <p v-on:click="ToLogin">已有账号？马上登录</p> -->
	  <p>
	    <router-link to="/login">已有账号？马上登录</router-link>
	  </p>
	  <br />
	</div>
</template>

<script>
  	import { mapGetters, mapMutations, mapActions } from 'vuex'
    export default{
    	name:'Register',
      fullscreenLoading: false,//全屏loading
    	data(){
    		return{
          username:'',
    			email:'',
    			password:''
    		}
    	},
    	computed:{
    		...mapGetters([
				'userInfo'
    		])
    	},
    	methods:{
    		...mapActions([
    			'register'
    		]),
    		RegisterHandler(){
    			this.register({
            username:this.name,
    				email:this.email,
    				password:this.password
    			})
				this.$route.push({name:'Login'})
    		}
    	}
    }
</script>

<style>
	.login-wrap {
	  text-align: center;
	}

	h2 {
	  text-align: center;
	}
	span {
	  text-align: center;
	}
	input {
	  display: block;
	  width: 250px;
	  height: 40px;
	  line-height: 40px;
	  margin: 0 auto;
	  margin-bottom: 10px;
	  outline: none;
	  border: 1px solid #888;
	  padding: 10px;
	  box-sizing: border-box;
	}

	p {
	  color: red;
	  text-align: center;
	}

	button {
	  display: block;
	  width: 250px;
	  height: 40px;
	  line-height: 40px;
	  margin: 0 auto;
	  border: none;
	  background-color: #41b883;
	  color: #fff;
	  font-size: 16px;
	  margin-bottom: 5px;
	}

	span {
	  cursor: pointer;
	}

	span:hover {
	  color: #41b883;
	}
</style>
