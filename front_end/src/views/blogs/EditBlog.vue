<!-- 修改文章界面 -->
<template>
	<div>
		<a-input v-model="title"></a-input>
		<a-textarea value="content" :rows="10" />
		<a-button type="danger" @click="reset">重置</a-button>
		<a-button type="primary" @click="submit">提交</a-button>
	</div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
export default{
	name:'EditBlog',
	data(){
		return {
			content:blogParams.content,
			title:blogParams.title
		}
	},
	mounted:function(){
		getBlogByBlogId(this.$route.query.blogId)
	},
	computed:{
		...mapGetters([
			'blogParams',
		])
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
		submit(){
			this.updateBlog({
				blogId:this.blogParams.blogId,
				content:this.blogParams.content,
				title:this.blogParams.title
			})
			this.reset()
		}
	}
}
</script>

<style>
</style>
