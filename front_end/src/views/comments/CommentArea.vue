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
import { message } from 'ant-design-vue'
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
		  'userInfo',
		  'blogParams',
		  'userDisplay'
	  ])
  },
  created() {
  	this.set_userInfo(sessionStorage.getItem('userInfo'))
  },
  mounted() {
  	this.getBlogByBlogId({
		blogId:this.$route.query.blogId,
		userId:this.userInfo.userId
	})
	// this.getUserDisplay(this.blogParams.writerId)
  },
  methods: {
	...mapActions([
		'addComment',
		'addMessage',
		'getBlogByBlogId',
		'getUserDisplay',
	]),
	...mapMutations([
		'set_userInfo'
	]),
    handleSubmit() {
      if (!this.content) {
        return;
      }
	  if(typeof(this.userInfo)=="undefined" || this.userInfo.userId==0){
		  message.error('请登录')
		  return
	  }
	  var blogId = this.$route.query.blogId
	  this.getUserDisplay(this.blogParams.writerId)
	  this.addComment({
		  commentId:0,
		  content:this.content,
		  reviewer:{
		  	userId:this.userInfo.userId,
		  	username:this.userInfo.username,
		  	userimg:this.userInfo.userImg
		  },
		  recipient:{
		  	userId:this.userDisplay.userId,
		  	username:this.userDisplay.username,
		  	userImg:this.userDisplay.userImg
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
	  this.addMessage({
		  sender:{
			  userId:this.userInfo.userId,
			  userImg:this.userInfo.userImg,
			  username:this.userInfo.username
		  },
		  recipient:{
			  userId:this.userDisplay.userId,
			  username:this.userDisplay.username,
			  userImg:this.userDisplay.userImg
		  },
		  blogId:blogId,
		  content:this.content,
		  messageId:0
	  })
	  this.content = ''
    },
    handleChange(e) {
      this.value = e.target.value;
    }
  }
};
</script>