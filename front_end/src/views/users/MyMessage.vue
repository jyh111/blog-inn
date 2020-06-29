<!-- 我的消息界面 -->
<template>
	<div>
		<Header></Header>
		<div class="Mymessage">
		  <a-list item-layout="horizontal" :data-source="msgList">
		    <a-list-item slot="renderItem" slot-scope="item, index">
				<router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">
					<span>来自{{ item.sender.username }}:</span>
					{{ item.content }}
				</router-link>
		    </a-list-item>
		  </a-list>
		  </div>
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
		mounted() {
			console.log('message')
			console.log(this.userInfo.userId)
			this.getMsgList(this.userInfo.userId)
		},
		computed:{
			...mapGetters([
				'msgList',
				'userInfo'
			]),

		},
		components:{
			Header
		},
		methods:{
			...mapMutations([
				'set_userInfo',

			]),
			...mapActions([
				'getMsgList'
			])
		}
	}
</script>

<style>
  .Mymessage{
  	width: 80%;
  	text-align: left;
  	padding: 10px 0 20px 0;
  	background-color: #e1e1e1;
  	margin: 0 auto;
  }

</style>
