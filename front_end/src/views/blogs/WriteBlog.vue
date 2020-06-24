<!-- 写文章界面 -->
<template>
	<div>
	<a-input v-model="title"></a-input>
	<a-textarea :value="content" :rows="10" />
	<a-button type="primary" @click="submit">提交</a-button>
	</div>
</template>

<script>
	import Vue from 'vue'
	import Vuex from 'vuex'
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:'WriteBlog',
		data(){
			return{
				content:'',
				title:''
			}
		},
		computed:{
			...mapGetters([
				'blogParams'
			])
		},
		methods:{
			...mapActions([
				'writeBlog',
				
			]),
			submit(){
				this.writeBlog({
					title:this.title,
					content:this.content
				})
			}
		}
	}
</script>

<style>
</style>
