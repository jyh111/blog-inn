<!-- 添加到收藏夹弹窗 -->
<template>

		<a-modal :visible="addFavorVisible"
		cancelText="取消"
        okText="确定"
        @cancel="cancle"
        @ok="handleSubmit">
			<a-list v-for="(item, index) in favorFolders" :key="index" :class="{'selected':index==selectedIndex}" @click="selectFolderHandler(item.folder_name,index)">
				{{item.folder_name}}
				<a-icon type="close" @click="deleteFavorFolderHandler(item.folder_name)" />
			</a-list>
		</a-modal>

</template>

<script>
	import Vue from 'vue'
	import { Modal } from 'ant-design-vue';
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	Vue.use(Modal)
	export default{
		name:"AddFavor",
		data(){
			return {
				selectedFolderName:'',
				selectedIndex:-1,
			}
		},
		created() {
			this.set_userInfo(sessionStorage.getItem('userInfo'))
		},
		computed:{
			...mapGetters([
				'addFavorVisible',
				'favorFolders',
				'putFavorBlogId',
				'userInfo'
			])
		},
		methods:{
			...mapActions([
				'deleteFavorFolder',
				'putFavor',
				'addFavorFolder'
			]),
			...mapMutations([
				'set_addFavorVisible',
				'set_userInfo'
			]),
			deleteFavorFolderHandler(folder_name){
				this.deleteFavorFolder(folder_name)
			},
			selectFolderHandler(folder_name,index){
				this.selectedFolderName = folder_name,
				this.selectedIndex = index
			},
			handleSubmit(){
				this.putFavor({
					userId:this.userInfo.userId,
					blogId:this.$route.query.blogId,
					classification:this.selectedFolderName,
					})
				this.set_addFavorVisible(false)
			},
			cancle(){
				this.set_addFavorVisible(false)
			},
		}
	}
</script>

<style>
	.selected{
		background-color: skyblue;
	}
</style>
