<template>
	<h2>注册界面</h2>
	  <input type="text" placeholder="请输入您的邮箱" v-model="email" />
	  <input type="text" placeholder="请输入用户名" v-model="username" />
	  <input type="password" placeholder="请输入密码" v-model="password" />
		
	  <button v-on:click="register">注册</button>
		
	  <!-- <p v-on:click="ToLogin">已有账号？马上登录</p> -->
	  <p>
	    <router-link to="/login">已有账号？马上登录</router-link>
	  </p>
	  <br />
	  <!-- <router-link to="/">返回</router-link> -->
	</div>
</template>

<script>
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
