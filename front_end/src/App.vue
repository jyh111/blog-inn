<template>
  <div id="app">
	 <div class="header">
		<Header></Header>
	</div>
	<div id="content">
		<router-view/>
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
	width: 100%;
	margin-top: 5px;
	margin-right: 10px;
	position: fixed;
}
#content{

}
</style>
