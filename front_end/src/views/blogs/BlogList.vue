<!-- blog列表 -->
<template>
	<div>
		<Header></Header>
		<div class="content">
		<a-list item-layout="horizontal" :data-source="blogList" >
			<a-list-item slot="renderItem" slot-scope="item, index">
				<router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">
				<span>{{item.title}}</span>
				<a-icon v-if="userInfo.userId!=0" type="heart" :theme="item.infavor=='null'?'twoTone':'filled'"></a-icon>
				</router-link>
			</a-list-item>
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
	}
}
</script>

<style>
.content{
	background-color: #FFFFFF;
	width: 80%;
	height: 100%;
}

</style>
