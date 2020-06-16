<template>
  <div>
    <a-comment id="comment-area">
      <a-avatar slot="avatar" :src="require('assets/images/login_logo.png')" alt="Han Solo" />
      <div slot="content">
        <a-form-item>
          <a-textarea id="my-textarea" :rows="4" v-model="content" />
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
import {insertMsg} from 'network/ajax.js'

export default {
  data() {
    return {
      content: "",
      submitting: false
    };
  },
  props: {
    parentMsgId: "",
    replyMsgUsername: ""
  },
  watch: {
    replyMsgUsername() {
      document
        .querySelector("#my-textarea")
        .setAttribute("placeholder", "回复: " + "@" + this.replyMsgUsername);
    }
  },
  methods: {
    handleSubmit() {
      if (!this.content) {
        return;
      }
      this.submitting = true;
      insertMsg(this.content, this.parentMsgId, this.$store.state.userId).then(res => {
        this.submitting = false;
        this.content = "";
        document
        .querySelector("#my-textarea")
        .setAttribute("placeholder", '');
        this.$emit('reload')
      }).catch(err => {
        console.log(err);
        this.$router.push('/500')
      })
    },
    handleChange(e) {
      this.value = e.target.value;
    }
  }
};
</script>