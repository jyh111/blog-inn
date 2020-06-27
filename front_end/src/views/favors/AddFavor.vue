<!-- 添加到收藏夹弹窗 -->
<template>
	<div>
		<a-modal :visble="addFavorVisble"
		cancelText="取消"
        okText="确定"
        @cancel="cancle"
        @ok="handleSubmit">
			<a-button type="primary" @click="addFavorFolderHandler">新建文件夹</a-button>
			<a-list v-for="(item, index) in favorFolders" :key="index" @click="selectFolderHandler(item.folder_name,index)">
				{{item.folder_name}}
				<a-icon type="close" @click="deleteFavorFolderHandler(item.folder_name)" />
			</a-list>
			<a-input v-modal="newFolderName" v-show="isCreateNewFolder" @keyup.enter.native=""></a-input>
		</a-modal>
	</div>
</template>

<script>
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:"AddFavor",
		data(){
			return {
				selectedFolderName:'',
				selectedIndex:-1,
				newFolderName:'',
				isCreateNewFolder:false
			}
		},
		created() {
			this.set_userInfo(sessionStorage.getItem('userInfo'))
		},
		computed:{
			...mapGetters([
				'addFavorVisble',
				'favorFolders',
				'putFavorBlogId'
			])
		},
		methods:{
			...mapActions([
				'deleteFavorFolder',
				'putFavor',
				'addFavorFolder'
			]),
			...mapMutations([
				'set_addFavorVisble',
				'set_userInfo'
			]),
			deleteFavorFolderHandler:(folder_name)=>{
				this.deleteFavorFolder(folder_name)
			},
			selectFolderHandler:(folder_name,index)=>{
				this.selectedFolderName = folder_name,
				this.selectedIndex = index
			},
			handleSubmit:()=>{
				this.putFavor(this.selectedFolderName)
			},
			cancle:()=>{
				this.set_addFavorVisble(false)
			},
			createFolderHandler:()=>{
				this.isCreateNewFolder = true
			},
			addFavorFolderHandler:()=>{
				if(this.newFolderName==''){
					this.isCreateNewFolder = false
					return
				}
				this.addFavorFolder(this.newFolderName)
				this.newFolderName = ''
				this.isCreateNewFolder = false
			}
		}
	}
</script>

<style>
</style>
