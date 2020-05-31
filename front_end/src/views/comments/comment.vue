<!-- 评论组件, 回复接口 -->
<template>
	  <div>
	    <a-list
	      v-if="commentList.length"
	      :data-source="commentList"
	      :header="`${commentList.length} ${commentList.length > 1 ? 'replies' : 'reply'}`"
	      item-layout="horizontal"
	    >
	      <a-list-item slot="renderItem" slot-scope="item, index">
	        <a-comment
	          :author="item.userInfo.username"
	          :avatar="item.userInfo.userimg"
	          :content="item.content"
	          <!-- :datetime="item.datetime" -->
	        />
	      </a-list-item>
	    </a-list>
	    <a-comment>
	      <a-avatar
	        slot="avatar"
	        src="userInfo.userimg"
	        alt="userInfo.username"
	      />
	      <div slot="content">
	        <a-form-item>
	          <a-textarea :rows="4" :value="value" @change="handleChange" />
	        </a-form-item>
	        <a-form-item>
	          <a-button html-type="submit"  type="primary" @click="handleSubmit">
	            Add Comment
	          </a-button>
	        </a-form-item>
	      </div>
	    </a-comment>
	  </div>
</template>

<script>
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default{
		name:'Comment',
		data(){
			return{
				value: ''
			}
		},
		computed:{
			...mapGetters([
				'commentList',
				'blogId',
				'userInfo',
				'blogParams'
			])
		},
		methods:{
			...mapActions([
				'addComment'
			]),
			handleSubmit() {
			      if (!this.value) {
			        return;
			      }
				  const data = {
				      commentId:'',
				      content:this.value,
				      reviewerId:userInfo.userId,
				      recipientId:blogParams.writerId,
				      blogId:blogId
				  };
				  this.addComment(data)
			},
		    handleChange(e) {
		      this.value = e.target.value;
		    },
	},
	}
</script>

<style>
</style>
