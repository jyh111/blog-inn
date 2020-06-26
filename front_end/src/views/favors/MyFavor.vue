<!-- 收藏详情界面 功能: 删文章, 改分类-->
<template>
	<div>
		<a-list v-for="(item, index) in blogFolders" :key="index">
			<a-icon :type="index==currentIndex?'up-circle':'down-circle'" @click="showBlogs(item.folder_name, index)" />
			<a-list-item v-for="(item,index) in blogList" :key="index" v-if="index==currentIndex"></a-list-item>
		</a-list>
	</div>
</template>

<script>
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:"MyFavor",
		data(){
			return {
				blogList:[],
				currentIndex:-1
			}
		},
		computed:{
			...mapGetters([
				'favorFolders',
				'userInfo'
			])
		},
		methods:{
			showBlogs:(folder_name, index)=>{
				
			}
		}
	}
</script>

<style>
</style>
