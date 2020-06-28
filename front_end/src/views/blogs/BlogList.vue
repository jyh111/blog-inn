<!-- blog列表 -->
<template>
	<div>
		<Header></Header>

		<a-list item-layout="horizontal" :data-source="blogList" >
			<a-list-item slot="renderItem" slot-scope="item, index">
				<router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">
				<span>{{item.title}}</span>
				<span>{{item.page_view}}</span>
				<a-icon v-if="userInfo.userId!=0" type="heart" :theme="item.infavor=='null'?'twoTone':'filled'"></a-icon>
				</router-link>
			</a-list-item>
		</a-list>
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


</style>
