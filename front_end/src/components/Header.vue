<!-- 头部组件 -->
<template>
	<div class="location">
		<router-link :to="{name:'WriteBlog',query:{userId:userInfo.userId}}" v-if="isLogin">写文章</router-link>
		<UserIcon :userInfo="userInfo"></UserIcon>
	</div>
</template>

<script>
	import UserIcon from '@/views/users/UserIcon.vue'
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:'Header',
		data(){
			return{
				isLogin:false
			}
		},
		computed:{
			...mapGetters([
				'userInfo'
			])
		},
		created:()=>{
			if(typeof(this.userInfo)=="undefined" || this.userInfo.userId==0){
				this.isLogin = false
			}else{
				this.isLogin = true
			}
		},
		methods:{
			...mapActions([

			])
		},
		components:{
			UserIcon
		}
	}
</script>

<style>
  
</style>
