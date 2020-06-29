<!-- 个人信息查看/修改界面 -->
<template>
  <div>
	  <Header></Header>
    <div class="container">
      <div v-show="isEdit" class="userInfo">
          <header>
              <h1>个人信息修改</h1>
          </header>
          <section>
              <ul class="userInfoBox">
                  <li>
                      <span >用户头像</span>
					  <a-avatar src="../../../static/image/default_logo.jpg"/>
                  </li>

                  <li>
                      用户名:
                      <a-input v-model="username" placeholder="用户名" style="width: 40%;"></a-input>
                  </li>

                  <li>
                      <span>电子邮件</span>
                      <a-input v-model="useremail"style="width: 40%;"></a-input>
                  </li>

                  <li>
                      <span>个人介绍</span>
                      <a-textarea v-model="self_introduction" :rows="4"></a-textarea>
                  </li>

              </ul>

              <div class=" saveInfo">
                  <a-button type="default" @click="isEdit=!isEdit">返&nbsp;&nbsp;回</a-button>
                  <a-button type="primary" @click="saveInfo">保&nbsp;&nbsp;存</a-button>
              </div>
          </section>
      </div>


      <div v-show="!isEdit" class="tcommonBox">
          <header>
              <h1>个人中心
                  <span class="gotoEdit" @click="isEdit=!isEdit">编辑</span>
              </h1>
          </header>
          <section>
              <ul class="userInfoBox">
                  <li>
                      <span>用户头像:  </span>
                       <a-avatar src="../../../static/image/default_logo.jpg"/>
                  </li>

                  <li>
                      <span >用户名:  </span>
                      <span>{{username}}</span>
                  </li>

                  <li>
                      <span >电子邮件:  </span>
                      <span>{{useremail}}</span>
                  </li>

                  <li>
                      <span >个人介绍:  </span>
                      <span>{{self_introduction}}</span>
                  </li>
              </ul>
          </section>
      </div>
  </div>
</div>

</template>



<script>
  import Header from '../../components/Header.vue';
  import UserIcon from "@/views/users/UserIcon.vue";
  import { mapGetters, mapMutations, mapActions } from 'vuex';
  export default {
    name: "UserInfo",
    data() { //选项 / 数据
      return {
        isEdit: false,
        username:'',
		useremail:'',
		self_introduction:''
      };
    },
    computed:{
      ...mapGetters([
        'commentList',
      ])
    },
	created() {
		this.set_userInfo(sessionStorage.getItem('userInfo'))
	},
    components: {
      UserIcon,
	  Header
    },
    computed:{
  	  ...mapGetters([
  		  'userInfo',
  	  ])
    },
	mounted() {
		this.username = this.userInfo.username,
		this.useremail = this.userInfo.email,
		this.self_introduction = this.userInfo.self_introduction
	},
    methods: {
		...mapMutations([
			'set_userInfo'
		]),
		...mapActions([
			'updateUserInfo'
		]),
      saveInfo: function(){//保存编辑的用户信息
          // var that = this;
          // UserInfoSave(that.userInfoObj,function(result){//保存信息接口，返回
          //     that.$message.success( '保存成功！');
          //     that.isEdit = false;
          // })
		  this.updateUserInfo({
			  userId:this.userInfo.userId,
			  username:this.username,
			  email:this.useremail,
			  userImg:'',
			  password:this.userInfo.password,
			  self_introduction:this.self_introduction
		  })
		  this.isEdit = false
      },

    }
  };

</script>

<style>
    .avatar {
      wIdth: 120px;
      height: 120px;
      border-radius: 50%;
      display: block;
      object-fit: cover;
    }
  .gotoEdit{
      font-size: 15px;
      float:right;
      cursor: pointer;
      color:#999;
  }
  .gotoEdit:hover {
      color:#333;
  }
  /*个人设置*/
  .userInfoBox .leftTitle{
      display: inline-block;
      wIdth:100px;
      padding: 10px 0;
  }
  .userInfoBox li{
      padding:20px;
      border-bottom: 1px solId #ddd;
  }
  .userInfoBox li:last-child{
      border-bottom: 1px solId transparent;
  }
  .userInfoBox  .el-input,.userInfoBox  .el-textarea{
      max-wIdth:300px;
      min-wIdth: 100px;
  }

  .userInfoBox .el-input__inner{
      border-radius: 4px;
  }
  .userInfoBox  .el-textarea{
      vertical-align: top;
  }
  .saveInfo{
      margin: 20px 0;
      text-align: center;
  }
  .saveInfo a{
      color:#fff;
      padding:6px 20px;
      margin:5px 10px;
      border-radius: 5px;
      font-size: 14px;
  }
  .container{
    background-image: url(../../../static/image/back5.jpg);
    background-repeat:no-repeat;
    background-size:cover;
  }

</style>
