<!-- 留言组件 -->
<template>
  <a-comment>
    <span
      slot="actions"
      key="comment-basic-reply-to"
      @click="handlReply(comment.id, comment.recipient)"
    >
      <a href="#my-textarea">回复</a>
    </span>
    <a slot="author" style="font-size: 15px">{{comment.reviewer.username}}</a>
    <a
      v-if="comment.parent_msg_username"
      slot="author"
      class="reply-to"
    >@{{comment.recipient.username}}</a>
    <a-avatar slot="avatar" src="@/assets/default_logo.jpg" alt />
    <p slot="content">{{comment.content}}</p>
<!--    <a-tooltip slot="datetime">
      <span>{{comment.date}}</span>
    </a-tooltip> -->
    <slot name="childComment"></slot>
  </a-comment>
</template>

<script>
export default {
  name: 'Comment',
  props: {
    comment: {
		
	}
  },
  created() {

  },
  methods: {
    handlReply(commentId, recipientDisplay) {
      this.$emit("handleReply", { commentId, recipientDisplay });
    }
  }
};
</script>

<style scoped>
.reply-to {
  padding-left: 5px;
  color: #409eff;
  font-weight: 500;
  font-size: 15px;
}
</style>