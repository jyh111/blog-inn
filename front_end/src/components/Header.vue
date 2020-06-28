<!-- 头部组件 -->
<template>



	<div class="location">
		<router-link :to="{name:'SearchBlog'}"><span class="header_title">博客馆</span></router-link>
		<UserIcon></UserIcon>
		<router-link :to="{name:'WriteBlog',query:{userId:userInfo.userId}}" v-if="isLogin"><span class="writeIcon">创作</span></router-link>
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
		created(){
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
	background-color: #ffff7f;
	color: #000000;
	padding: 5px;
	float: right;
	margin-right: 10px;
	margin-top: 5px;
}

.location{
  background-image: url(../../static/image/back3.jpg);
  background-repeat:no-repeat;
  background-size:cover;
	height: 40px;
}

.header_title{
	color: #ffff7f;
	background-color:#13C2C2;
	padding: 5px;
	float: left;
	margin-top: 5px;
}
</style>
