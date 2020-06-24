<!-- blog列表 -->
<template>
	<div>
		<a-list item-layout="horizontal" :data-source="blogList">
			<a-list-item slot="renderItem" slot-scope="item, index">
				<router-link :to="{name:'DisplayBlog',query:{blogId:item.blogId}}">
				<p>{{item.title}}</p>
				<span>{{item.pageView}}</span>
				<a-icon type="heart" :theme="item.infavor=='null'?'twoTone':'filled'"></a-icon>
				</router-link>
			</a-list-item>
		</a-list>
	</div>
</template>

<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
	
export default{
	name:'BlogList',
	data(){
		return{
			
		}
	},
	computed:{
		...mapGetters([
			'blogList'
		])
	}
}
</script>

<style>
</style>
