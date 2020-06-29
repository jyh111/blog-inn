<template>
	<div class= "all">
	  <img src="../../static/image/imac.png" alt="A frame for login and register."  />
	  <div  class ="loginAndReg">
	    <h1>注册界面</h1>
	    <input type="text" placeholder="请输入您的邮箱" v-model="email" />
	    <input type="text" placeholder="请输入用户名" v-model="username" />
	    <input type="password" placeholder="请输入密码" v-model="password" />
	    <input type="password" placeholder="确认密码" v-model="password2" @blur="blurHandler"/>
	    <!-- <el-alert v-show="npassword2Err" title="重复密码错误" type="error" show-icon:closable="false"> </el-alert> -->
		<p style="color: red;" v-show="npassword2Err">重复密码错误</p>
	    <!-- <div @click="newRegister" v-loading.fullscreen.lock="fullscreenLoading"  element-loading-text="提交中"> -->
        <button v-on:click="register">注&nbsp;&nbsp;册</button>
      </div>


	    <!-- <p v-on:click="ToLogin">已有账号？马上登录</p> -->
	    <p>
	      <router-link to="/login">已有账号？马上登录</router-link>
	    </p>
	    <br />
	  </div>
	</div>
</template>

<script>
  	import { mapGetters, mapMutations, mapActions } from 'vuex'
    export default{
    	name:'Register',

    	data(){
    		return{
				username:'',
    			email:'',
    			password:'',
				password2:'',
				npassword2Err:false,
				fullscreenLoading: false,//全屏loading
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
				if(this.password!=this.password2){
					this.npassword2Err = true
				}else{
					this.npassword2Err = false
				}
    			this.register({
					username:this.name,
    				email:this.email,
    				password:this.password
    			})
				this.$router.push({name:'Login'})
    		},
			blurHandler(){
				if(this.password!=this.password2){
					this.npassword2Err=true
				}else{
					this.npassword2Err = false
				}
			}
    	}
    }
</script>

<style>
	.login-wrap {
	  text-align: center;
	}

	h1 {
	  text-align: center;
	}
	span {
	  text-align: center;
	}
	input {
	  display: block;
	  wIdth: 250px;
	  height: 40px;
	  line-height: 40px;
	  margin: 0 auto;
	  margin-bottom: 10px;
	  outline: none;
	  border: 1px solId #888;
	  padding: 10px;
	  box-sizing: border-box;
	}

	p {
	  color: red;
	  text-align: center;
	}

	button {
	  display: block;
	  wIdth: 250px;
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
	.loginAndReg{
	  size: a3;
	  bottom: 700px;
	  position: relative;
	  text-align: center;
	}
	.all{
	  background-image: url("../../static/image/back.jpg");
	  background-repeat:no-repeat;
	  background-size:cover
	}
	.p2{
	  wIdth: 900px;
	}
</style>
