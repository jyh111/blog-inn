<!-- 主视图 -->
<template>
	 <div>
	    <comment-message @handleReply="handleReply" :commentList="commentList"></comment-message>
	    <comment-area @reload="reload" :commentId="commentId" :recipientDisplay="recipientDisplay"></comment-area>
  </div>
</template>
	
<script>
	import CommentMessage from "components/common/comment/CommentMessage";
	import CommentArea from "components/common/comment/CommentArea";
	import { mapGetters, mapMutations, mapActions } from 'vuex'
	export default {
	  name: "Message",
	  components: {
	    CommentMessage,
	    CommentArea
	  },
	  data() {
	    return {
	      // replyMsgId: "",
	      // replyMsgUsername: ""
		  commentId:'',
		  recipientDisplay:{}
	    };
	  },
	  computed:{
		  
	  },
	  mounted() {
	    
	  },
	  computed:{
		  ...mapGetters([
			  'commentList',			  
		  ])
	  },
	  methods: {
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
