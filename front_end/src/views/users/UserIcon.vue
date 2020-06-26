<!-- 用户头像，下拉框(包含个人信息,我的博客,我的消息,我的收藏)等，在顶部使用 -->
<template>
	<div>
	    <router-link :to="{name:'Login'}" v-if="!isLogin">
			<a-avatar icon="user"></a-avatar>登录
		</router-link>
		<a-dropdown v-if="isLogin">
		    <a class="ant-dropdown-link" @click="e => e.preventDefault()">
		       <a-avatar :src="userDisplay.userId" />{{userDisplay.username}}
		    </a>
		    <a-menu slot="overlay">
		      <a-menu-item>
		        <router-link :to="{name:'UserInfo',query:{userId:userDisplay.userId}}">个人信息</router-link>
		      </a-menu-item>
		      <a-menu-item>
		        <router-link :to="{name:'MyBlog',query:{userId:userDisplay.userId}}">我的博客</router-link>
		      </a-menu-item>
		      <a-menu-item>
		        <router-link :to="{name:'MyMessage',query:{userId:userDisplay.userId}}">我的消息</router-link>
		      </a-menu-item>
			  <a-menu-item>
			    <router-link :to="{name:'MyFavor',query:{userId:userDisplay.userId}}">我的收藏</router-link>
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
			isLogin:false
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
	  created: () => {
	  	if(typeof(this.userInfo)=="undefined"|| this.userDisplay.userId==0){
			this.isLogin = false
		}else{
			this.isLogin = true
		}
	  },
	  props:['userDisplay'],
	  computed:{
		  ...mapGetters([
			  'userInfo'
		  ])
	  },
	  methods:{
		  ...mapActions([
			  
		  ]),
		  handleMenuClick(){
			  
		  }
	  },
  	
  	
  }
</script>

<style>
</style>
