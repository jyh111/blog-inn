<!-- �ղ��������� ����: ɾ����, �ķ���-->
<template>
	<div>
		<Header></Header>
		<a-button type="primary" @click="createFolderHandler">新建文件夹</a-button>
		<a-modal :visible="isCreateNewFolder"
		cancelText="取消"
		okText="确定"
		@cancel="cancelNewFolder"
		@ok="addFavorFolderHandler"
		>
			<a-input v-model="newFolderName" @keyup.enter.native="addFavorFolderHandler"></a-input>
		</a-modal>
		<div class="my_favor">
		<a-list v-for="(item, index) in favorFolders" :key="index" style=" margin: 20px auto;">
			<span style="font-size: 24px;">
			{{item.folder_name}}

			<a-icon :type="index==currentIndex?circleType:'up-circle'" @click="showBlogs(item.folder_name, index)" />
			<a-icon type="close" @click="deleteFavorFolderHandler(item.folder_name)" style="float: right;"/>
			</span>
			<div style="width: 100%">
			<a-list-item v-for="(item,index2) in blogListInFavor" :key="index2" v-if="index==currentIndex">
				<div style="width: 100%;">
				<router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">{{item.title}}</router-link>
				<a-icon type="close" @click="deleteBlogHandler(item.blogId,item.inFavor)" style="float: right;"/>
				<hr style="color: #000000;"/>
				</div>
			</a-list-item>
			</div>
		</a-list>
		<a-list item-layout="horizontal" :data-source="blogListWithoutFolderInFavor" v-if="blogListWithoutFolderInFavor.length>0">
		<a-list-item slot="renderItem" slot-scope="item, index">
			<div style="width: 100%;">
		    <router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">{{item.title}}</router-link>
			<a-icon type="close" @click="deleteBlogHandler(item.blogId,item.inFavor)" style="float: right;"/>
			<hr style="color: #000000;"/>
			</div>
		</a-list-item>
		</a-list>
		</div>
	</div>
</template>

<script>
	import Vue from 'vue'
	import Header from '../../components/Header.vue';
	import { Modal } from 'ant-design-vue';
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	Vue.use(Modal)
	export default{
		name:"MyFavor",
		data(){
			return {
				currentIndex:-1,
				circleType:'up-circle',
				newFolderName:'新建文件夹',
				isCreateNewFolder:false
			}
		},
		created() {
			this.set_userInfo(sessionStorage.getItem('userInfo'))
		},
		mounted () {
			this.getFavorFoldersByUserId(this.userInfo.userId)
			// this.$axios.get('/api/favors/'+this.userInfo.userId+'/getFavor',{
			// 	userId:this.userInfo.userId,
			// 	classfication:""
			// }).then(res=>{
			// 	this.blogListWithoutFolder = res
			// }).catch(Error=>{
			// 	console.log('��ȡĬ���ղ�����ʧ��')
			// })
			var data = {
					userId:this.userInfo.userId,
					classification:'',
			}
			this.getFavor(data)
		},
		computed:{
			...mapGetters([
				'favorFolders',
				'userInfo',
				'blogListWithoutFolderInFavor',
				'blogListInFavor'
			])
		},
		components:{
			Header
		},
		methods:{
			...mapActions([
				'getFavorFoldersByUserId',
				'deleteFavorFolder',
				'getFavor',
				'deleteFavor',
				'addFavorFolder'
			]),
			...mapMutations([
				'set_userInfo',
				'set_blogListInFavor'
			]),
			showBlogs(folder_name, index){
				// this.$axios.get('/api/favors/'+this.userInfo.userId+'/getFavor',{
				// 	userId:this.userInfo.userId,
				// 	classfication:folder_name
				// }).then(res=>{
				// 	this.blogList = res
				// 	this.currentIndex = index
				// }).catch(Error=>{
				// 	console.log('��ȡ�ղؼ��б�ʧ��')
				// })
				if(index==this.currentIndex){
				if(this.circleType=="up-circle"){
					this.circleType = "down-circle"
					var  data2 = {
						userId:this.userInfo.userId,
						classification:folder_name
					}
					this.getFavor(data2)
					console.log('blogListInFavor')
					console.log(this.blogListInFavor)
					this.currentIndex = index
				}else{
					this.circleType="up-circle"
					this.currentIndex = -1
				}}else{
					this.circleType = "down-circle"
					this.getFavor({
						userId:this.userInfo.userId,
						classification:folder_name
					})
					this.currentIndex = index
				}
			},
			deleteBlogHandler(blogId,folder_name){
				this.deleteFavor({
					blogId:blogId,
					userId:this.userInfo.userId,
					classification:'null'
				})				
			},
			deleteFavorFolderHandler(folder_name){
				this.deleteFavorFolder({
					folder_name:folder_name,
					userId:this.userInfo.userId
				})
			},
			cancelNewFolder(){
				this.newFolderName = '新建文件夹'
				this.isCreateNewFolder = false
			},
			createFolderHandler(){
				this.isCreateNewFolder = true
			},
			addFavorFolderHandler(){
				if(this.newFolderName==''){
					this.newFolderName='新建文件夹'
					this.isCreateNewFolder = false
					return
				}
				const param={
					userId:this.userInfo.userId,
					folder_name:this.newFolderName
				}
				this.addFavorFolder(param)
				this.newFolderName = '新建文件夹'
				this.isCreateNewFolder = false
			}
		}
	}
</script>

<style>
	.my_favor{
		background-color: #dfdfdf;
		margin: 0px auto;
		width: 60%;
		height: 679px;
	}
</style>
