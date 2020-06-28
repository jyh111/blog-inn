<template>
	<div class= "all">
	  <img src="../../static/image/imac.png" alt="A frame for login and register." class="p2" />
	  <div class ="loginAndReg">
	    <input type="email" placeholder="请输入邮箱" v-model="email" />
	    <input type="password" placeholder="请输入密码" v-model="password" />
	    <button v-on:click="loginHandler">登&nbsp;&nbsp;录</button>
	
	    <p>
	      <router-link to="/register" style="color: #FFFFFF;">没有账号？马上注册</router-link>
	    </p>
	    <!-- <p v-on:click="ToRegister">没有账号？马上注册</p> -->
	    <br />
	  </div>
	</div>
</template>

<script>
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:'Login',
		data(){
			return{
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
				'login',
				'getUserInfo'
			]),
			loginHandler(){
				var res = this.login({
					email:this.email,
					password:this.password
				})
				this.$router.push({name:'SearchBlog'})
				sessionStorage.setItem('userInfo',this.userInfo)
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
	  bottom: 600px;
	  position: relative;
	  text-align: center;    
	}
	.all{
	  background-image: url("../../static/image/back.jpg");
	  background-attachment: fixed;
	  background-repeat:no-repeat;
	  background-size:cover
	}
	.p2{
	  wIdth: 900px;
	}
</style>
