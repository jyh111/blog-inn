<!-- 添加到收藏夹弹窗 -->
<template>
	<div>
		
	</div>
</template>

<script>
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:"AddFavor",
		data(){
			return {
				
			}
		},
		computed:{
			...mapGetters([
				'addFavorVisble'
			])
		}
	}
</script>

<style>
</style>
