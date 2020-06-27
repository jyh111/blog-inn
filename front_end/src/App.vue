<template>
  <div id="al">
    <div id="app">
     <div class="header">
    	<Header></Header>
    </div>
    <div id="content">
    	<router-view/>
    </div>
    </div>
  </div>

</template>

<script>
	import Header from '@/components/Header'
export default {
    name: 'App',
	components:{
		Header
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
}
.header{
	/* width: 100%; */
	margin-top: 5px;
	margin-right: 0px;
	position: fixed;
}
#content{

}
#al{
    background-image: url("../static/image/main1.jpg");
    background-attachment: fixed;
    background-repeat:no-repeat;
    background-size: cover;
    width:100%;
    height:200%;
  }
</style>
