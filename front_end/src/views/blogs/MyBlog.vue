<!-- 我的博客界面 -->
<template>
	<div>
		<a-list v-for="(item, index) in blogFolders" :key="index">
			<a-icon :type="index==currentIndex?circleType:'down-circle'" @click="showBlogs(item.folder_name, index)" />
			<a-list-item v-for="(item,index) in blogList" :key="index"></a-list-item>
		</a-list>
	</div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:'MyBlog',
		data(){
			return {
				currentIndex:-1,
				blogList:[],
				circleType:'down-circle'
			}
		},
		mounted:{
			
		},
		computed:{
			...mapGetters([
				'blogFolders',
				
			])
		},
		methods:{
			...mapActions([
				
			]),
			showBlogs(folder_name, index){
				
			}
		}
	}
</script>

<style>
</style>
