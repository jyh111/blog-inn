<template>

  <div Id="app">
	<router-view/>

<!--  <div Id="al">
    <div Id="app">
     <div class="header">
    	<Header></Header>
    </div>
    <div Id="content">
    	<router-view/>
    </div>
    </div> -->
  </div>

</template>

<script>
	import store from './store'
	import Header from '@/components/Header'
	import UserIcon from '@/views/users/UserIcon.vue'
export default {
    name: 'App',
created () {
//在页面加载时读取sessionStorage里的状态信息
if (sessionStorage.getItem("store") ) {
this.$store.replaceState(Object.assign({}, this.$store.state,JSON.parse(sessionStorage.getItem("store"))))
}

//在页面刷新时将vuex里的信息保存到sessionStorage里
window.addEventListener("beforeunload",()=>{
sessionStorage.setItem("store",JSON.stringify(this.$store.state))
})
},
	components:{
		Header,
		UserIcon
	}
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 0 auto;
  height: 150%;
	margin: 0 auto;
	/* height: 440px; */
	background-image:url("../static/image/back5.jpg");
	background-repeat:no-repeat;
	background-size: cover;
}
.header{
	wIdth: 100%;
	margin-top: 5px;
	margin-right: 1px;
	position: fixed;
}
#content{

}
#al{
    background-image: url("../static/image/main1.jpg");
    background-attachment: fixed;
    background-repeat:no-repeat;
    background-size: cover;
    wIdth:100%;
    height:200%;
  }
</style>
