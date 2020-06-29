<!-- 修改文章界面 -->
<template>
	<div >
		<Header></Header>
		<div class="edit_blog">
		<a-input v-model="title"></a-input>
		<a-textarea v-model="content" :rows="18" />
		<a-button type="danger" @click="reset">重置</a-button>
		<a-button type="primary" @click="submit">提交</a-button>
		</div>
	</div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
  import Header from '../../components/Header.vue';
  	import {message} from 'ant-design-vue'
export default{
	name:'EditBlog',
	data(){
		return {
			content:'',
			title:''
		}
	},
	mounted(){
		this.getBlogByBlogId({
			blogId:this.$route.query.blogId,
			userId:this.userInfo.userId
		}).then(val=>{
		this.content = this.blogParams.content
		this.title = this.blogParams.title
		})
	},
	created(){
		this.set_userInfo(sessionStorage.getItem('userInfo'))
	},
	computed:{
		...mapGetters([
			'blogParams',
			'userInfo'
		])
	},
	components:{
		Header
	},
	methods:{
		reset(){
			this.content = this.blogParams.content,
			this.title = this.blogParams.title
		},
		...mapActions([
			'updateBlog',
			'getBlogByBlogId'
		]),
		...mapMutations([
			'set_userInfo'
		]),
		submit(){
			this.updateBlog({
				blogId:this.blogParams.blogId,
				content:this.content,
				title:this.title,
				userId:this.userInfo.userId
			})
			this.$router.push({name:'MyBlog',query:{writerId:this.userInfo.userId}})
		}
	}
}
</script>

<style>
	.edit_blog{
		width: 80%;
		margin: 100px auto;
		padding: 10px 0 20px 0;
		background-color: #e1e1e1;
	}
</style>
