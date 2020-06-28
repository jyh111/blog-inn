<!-- 添加留言或回复的表单组件 -->
<template>
  <div>
    <a-comment Id="comment-area">
      <a-avatar slot="avatar" src="../../static/image/default_logo.jpg" alt="Han Solo" />
      <div slot="content">
        <a-form-item>
          <a-textarea Id="my-textarea" :rows="4" v-model="content" />
        </a-form-item>
        <a-form-item>
          <a-button
            html-type="submit"
            :loading="submitting"
            type="primary"
            @click="handleSubmit"
          >添加留言</a-button>
        </a-form-item>
      </div>
    </a-comment>
  </div>
</template>
<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {
	name:'CommentArea',
  data() {
    return {
      content: "",
      submitting: false
    };
  },
  props: {
    commentId:'',
    recipientDisplay:{}
  },
  watch: {
    replyMsgUsername() {
      document
        .querySelector("#my-textarea")
        .setAttribute("placeholder", "回复: " + "@" + this.replyMsgUsername);
    }
  },
  computed:{
	  ...mapGetters([
		  'userInfo'
	  ])
  },
  created() {
  	this.set_userInfo(sessionStorage.getItem('userInfo'))
  },
  methods: {
	...mapActions([
		'addComment',
		'addMesage'
	]),
	...mapMutations([
		'set_userInfo'
	]),
    handleSubmit() {
      if (!this.content) {
        return;
      }
	  var blogId = this.$route.query.blogId
	  this.addComment({
		  commentId:0,
		  content:this.content,
		  reviewer:{
		  	userId:this.userInfo.userId,
		  	username:this.userInfo.username,
		  	userimg:this.userInfo.userImg
		  },
		  recipient:{
		  	userId:this.recipientDisplay.userId,
		  	username:this.recipientDisplay.username,
		  	userImg:this.recipientDisplay.userImg
		  },
		  blogId:blogId
	  })
      // this.submitting = true;
      // insertMsg(this.content, this.parentMsgId, this.$store.state.userId).then(res => {
      //   this.submitting = false;
      //   this.content = "";
      //   document
      //   .querySelector("#my-textarea")
      //   .setAttribute("placeholder", '');
      //   this.$emit('reload')
      // }).catch(err => {
      //   console.log(err);
      //   this.$router.push('/500')
      // })
    },
    handleChange(e) {
      this.value = e.target.value;
    }
  }
};
</script>