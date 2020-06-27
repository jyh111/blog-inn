<!-- 头部组件 -->
<template>
	<div>
		<router-link :to="{name:'WriteBlog',query:{userId:userInfo.userId}}" v-if="isLogin"><span class="writeIcon">写文章</span></router-link>
		<UserIcon></UserIcon>
	</div>
</template>

<script>
	import UserIcon from '@/views/users/UserIcon.vue'
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:'Header',
		data(){
			return{

			}
		},
		computed:{
			...mapGetters([
				'userInfo',
				'isLogin'
			])
		},
		created:()=>{
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
span.writeIcon{
	background-color: #00ffff;
	color: #FFFFFF;
	padding: 5px;
}
</style>
