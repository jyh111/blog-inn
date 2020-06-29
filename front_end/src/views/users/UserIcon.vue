<!-- 用户头像，下拉框(包含个人信息,我的博客,我的消息,我的收藏)等，在顶部使用 -->
<template>

	<div class="userIcon">
	    <router-link :to="{name:'Login'}" v-if="!isLogin">
			<a-avatar src="../../static/image/default_logo.jpg" size="large"></a-avatar>
			<span class="header_login">登录</span>
		</router-link>
		<a-dropdown v-if="isLogin">
		    <a class="ant-dropdown-link" @click="e => e.preventDefault()">
		       <a-avatar src="../../static/image/default_logo.jpg" size="large"/>
			   <span class="username">{{userInfo.username}}</span>
		    </a>
		    <a-menu slot="overlay">
		      <a-menu-item>
		        <router-link :to="{name:'UserInfo',query:{userId:userInfo.userId}}">个人信息</router-link>
		      </a-menu-item>
		      <a-menu-item>
		        <router-link :to="{name:'MyBlog',query:{writerId:userInfo.userId}}">我的博客</router-link>
		      </a-menu-item>
		      <a-menu-item>
		        <router-link :to="{name:'MyMessage',query:{userId:userInfo.userId}}">我的消息</router-link>
		      </a-menu-item>
			  <a-menu-item>
			    <router-link :to="{name:'MyFavor',query:{userId:userInfo.userId}}">我的收藏</router-link>
			  </a-menu-item>
		    </a-menu>
		  </a-dropdown>
	</div>
</template>

<script>
	import { mapGetters, mapMutations, mapActions } from 'vuex'
  export default{
  	name:'UserIcon',
  	data(){
  		return{
        // blognav:[
        //     comp:<a-popover trigger="click">,
        //       <template slot="content">
        //         <p><router-link :to="{name:'UserInfo',query:{userId:userId}}">个人信息</router-link></p>
        //         <p><a href="../blogs/MyBlog">我的博客</a></p>
        //         <p><a href="MyMessage">我的消息</a></p>
        //         <p><a href="../favors/collect">我的收藏</a></p>
        //   },

          // ]
		}
	  },
	  watch:{
		  isLogin(val){
			  console.log(val)
		  }
	  },
		created() {
			this.set_userInfo(sessionStorage.getItem('userInfo'))
		},
	  computed:{
		  ...mapGetters([
			  'userInfo',
			  'isLogin'
		  ])
	  },
	  methods:{
		  ...mapMutations([
			  'set_isLogin',
			  'set_userInfo'
		  ]),
		  ...mapActions([

		  ]),
		  handleMenuClick(){

		  }
	  },


  }
</script>

<style>
	.userIcon{
		float: right;
		margin-right: 20px;
		margin-bottom: 40px;
	}
	span.login{
		font-size: 25px;
		color: #FFFFFF;
		background-color: #00ff7f;
		padding: 10px 5px;
	}
  .al{
    right: auto;
  }
  .header_login{
      wIdth: 72px;
      height: 30px;
      line-height: 28px;
      text-align: center;
      text-decoration: none;
      color: #ffff7f;
      font-size: 16px;
      margin: 0 12px 0 0;
      background: #202d40;
      border-radius: 2px;
      text-decoration: none;
  }
  .username{
	  wIdth: 72px;
	      height: 30px;
	      line-height: 28px;
	      text-align: center;
	      text-decoration: none;
	      color: #ffff7f;
	      font-size: 16px;
	      margin: 0 12px 0 0;
	      background: #202d40;
	      border-radius: 2px;
	      text-decoration: none;
  }
</style>
