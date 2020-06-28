<!-- blog列表 -->
<template>
	<div>
		<Header></Header>
		<div class="content">
		<a-list item-layout="horizontal" :data-source="blogList" >
			<a-list-item slot="renderItem" slot-scope="item, index" class="list_item">
				<router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}" class="list_item_link">
				<span>{{item.title}}</span>
				<a-icon v-if="userInfo.userId!=0" type="heart" :theme="item.infavor=='null'?'twoTone':'filled'"></a-icon>
				</router-link>
			</a-list-item>
			<hr style="width: 100%;color: #000000;"/>
		</a-list>
		</div>
	</div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'

	  import Header from '../../components/Header.vue';

export default{
	name:'BlogList',
	data(){
		return{

		}
	},
	created() {
		this.set_userInfo(sessionStorage.getItem('userInfo'))

	},
	mounted() {
		console.log(this.blogList)
	},
	computed:{
		...mapGetters([
			'blogList',
			'userInfo'
		])
	},
	components:{
		Header
	},
	methods:{
		...mapMutations([
			'set_userInfo'
		])
	},
	
}
</script>

<style>
.content{
	background-color: #FFFFFF;
	margin: 0px auto;
	width: 60%;
	height: 679px;
}
.list_item{
	width: 100%;
	/* margin: auto auto; */
	text-align: left;
	padding-left: 20px;
	padding-right: 20px ;
	height: 100%;
}
.list_item_link{
	width: 100%;
	text-decoration: none;
	color: #000000;
	background-color: #FFFFFF;
	height: 100%;
}
.list_item_link:hover{
	background-color: #e1e1e1;
	color: #000000;
}
</style>
