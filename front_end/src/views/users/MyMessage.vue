<!-- 我的消息界面 -->
<template>
	<div>
		<Header></Header>
		  <a-list item-layout="horizontal" :data-source="msgList">
		    <a-list-item slot="renderItem" slot-scope="item, index">
				<router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">
					<span>来自{{ item.recipient.username }}:</span>
					{{ item.content }}
				</router-link>
		    </a-list-item>
		  </a-list>
	</div>
</template>

<script>
	import Vue from 'vue'
	  import Header from '../../components/Header.vue';
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:"MyMessage",
		data(){
			return {

			}
		},
		created() {
			this.set_userInfo(sessionStorage.getItem('userInfo'))
		},
		computed:{
			...mapGetters([
				'msgList'
			]),

		},
		components:{
			Header
		},
		methods:{
			...mapMutations([
				'set_userInfo'
			])
		}
	}
</script>

<style>
</style>
