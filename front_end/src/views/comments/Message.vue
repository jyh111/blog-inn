<!-- 主视图 -->
<template>
	 <div>
	    <comment-message @handleReply="handleReply" :commentList="commentList"></comment-message>
	    <comment-area @reload="reload" :commentId="commentId" :recipientDisplay="recipientDisplay"></comment-area>
  </div>
</template>
	
<script>
	import CommentMessage from "@/views/comments/CommentMessage";
	import CommentArea from "@/views/comments/CommentArea";
	import { mapGetters, mapMutations, mapActions } from 'vuex'
		  import Header from '../../components/Header.vue';
	export default {
	  name: "Message",
	  components: {
	    CommentMessage,
	    CommentArea,
		Header
	  },
	  data() {
	    return {
	      // replyMsgId: "",
	      // replyMsgUsername: ""
		  commentId:'',
		  recipientDisplay:{}
	    };
	  },
		created() {
			this.set_userInfo(sessionStorage.getItem('userInfo'))
		},
		mounted() {
			this.getCommentListByBlogId(this.$route.query.blogId)
			console.log(this.commentList)
		},
	  computed:{
		  ...mapGetters([
			  'commentList',			  
		  ])
	  },
	  methods: {
		  ...mapMutations([
			  'set_userInfo'
		  ]),
		  ...mapActions([
			  'addMessage',
			  'getCommentListByBlogId'
		  ]),
	    handleReply(data) {
			this.commentId = data.commentId,
			this.recipientDisplay = data.recipientDisplay
	      // this.replyMsgId = data.msgId;
	      // this.replyMsgUsername = data.msgUsername;
	    },
	    reload() {
	      this.$emit("reload")
	    }
	  }
	};
</script>
	
<style>
</style>
