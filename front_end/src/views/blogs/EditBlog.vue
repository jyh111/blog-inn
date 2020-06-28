<!-- 修改文章界面 -->
<template>
	<div >
		<Header></Header>
		<div class="edit_blog">
		<a-input v-model="title"></a-input>
		<a-textarea v-model="content" :rows="10" />
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
		})
		this.content = this.blogParams.content
		this.title = this.blogParams.title
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
			console.log(this.blogParams)
			this.updateBlog({
				blogId:this.blogParams.blogId,
				content:this.blogParams.content,
				title:this.blogParams.title,
				userId:this.userInfo.userId
			})
			message.success('修改成功')
			this.$router.push({name:'MyBlog',query:{writerId:this.userInfo.userId}})
		}
	}
}
</script>

<style>
</style>
