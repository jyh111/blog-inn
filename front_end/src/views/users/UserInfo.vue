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
                  <li class="avatarlist">
                      <span class="leftTitle">用户头像</span>
                      <el-upload
                        class="avatar-uploader"
                        :action="this.$store.state.host+'Userinfo/UploadImg'"
                        :show-file-list="false"
                        :on-success="handleAvatarSuccess"
                        :before-upload="beforeAvatarUpload">
                        <img v-if="userInfoObj.avatar" :src="userInfoObj.avatar?wwwHost+userInfoObj.avatar:'static/img/example.png'"   :onerror="$store.state.errorImg" class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        <div slot="tip" class="el-upload__tip">点击上传头像，只能上传jpg/png文件</div>
                      </el-upload>
                  </li>

                  <li class="username">
                      <span class="leftTitle">用户名</span>
                      <el-input v-model="userInfoObj.username" placeholder="用户名"></el-input>
                  </li>

                  <li>
                      <span class="leftTitle">电子邮件</span>
                      <span>{{userInfoObj.email}}</span>
                  </li>

                  <li>
                      <span class="leftTitle">个人介绍</span>
                      <el-input v-model="userInfoObj.self_introduction" placeholder="简单介绍下自己..."></el-input>
                  </li>

              </ul>

              <div class=" saveInfo">
                  <a class="tcolors-bg"  href="javascript:void(0);" @click="isEdit=!isEdit">返&nbsp;&nbsp;回</a>
                  <a class="tcolors-bg" href="javascript:void(0);" @click="saveInfo">保&nbsp;&nbsp;存</a>
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
                  <li class="avatarlist">
                      <span class="leftTitle">用户头像</span>
                      <div class="avatar-uploader">
                          <img  :src="userInfoObj.avatar?wwwHost+userInfoObj.avatar:''"   :onerror="$store.state.errorImg" class="avatar">
                      </div>
                  </li>

                  <li class="username">
                      <span class="leftTitle">用户名</span>
                      <span>{{userInfoObj.username?userInfoObj.username:"NULL"}}</span>
                  </li>

                  <li>
                      <span class="leftTitle">电子邮件</span>
                      <span>{{userInfoObj.email}}</span>
                  </li>

                  <li>
                      <span class="leftTitle">个人介绍</span>
                      <span>{{userInfoObj.label?userInfoObj.label:"此人什么也没有说"}}</span>
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
        userInfoObj:'',//用户的信息
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
    methods: {
		...mapMutations([
			'set_userInfo'
		]),
      handleAvatarSuccess(res, file) {//上传头像
          if(res.code==1001){//存储
              this.userInfoObj.avatar = res.image_name;
              this.userInfoObj.head_start = 1;
          }else{
              this.$message.error('上传图片失败');
          }
      },
      beforeAvatarUpload(file) {//判断头像大小
          const isJPG = file.type == 'image/png'||file.type=='image/jpg'||file.type=='image/jpeg';
          const isLt21M = file.size / 1024 / 1024 < 1;
          if (!isJPG) {
            this.$message.error('上传头像图片只能为 JPG/JPEG/PNG 格式!');
          }
          if (!isLt21M) {
            this.$message.error('上传头像图片大小不能超过 1MB!');
          }
          return isJPG && isLt21M;
      },
      saveInfoFun: function(){//保存编辑的用户信息
          var that = this;
          UserInfoSave(that.userInfoObj,function(result){//保存信息接口，返回
              that.$message.success( '保存成功！');
              that.isEdit = false;
          })
      },

    }
  };

</script>

<style>
  .userInfoBox .avatarlist{
      position: relative;
  }

  .avatar-uploader {
      display: inline-block;
      vertical-align: top;
  }
  .avatar-uploader .el-upload {
      border: 1px dashed #d9d9d9;
      border-radius: 50%;
      cursor: pointer;
      position: relative;
      overflow: hidden;
      width: 120px;
      height: 120px;
    }
    .avatar-uploader .el-upload:hover {
      border-color: #20a0ff;
    }
    .avatar-uploader-icon {
      font-size: 28px;
      color: #8c939d;
      width: 120px;
      height: 120px;
      line-height: 120px;
      text-align: center;
      position: absolute;
      top:0;
      left:0;
    }
    .avatar {
      width: 120px;
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
      width:100px;
      padding: 10px 0;
  }
  .userInfoBox li{
      padding:20px;
      border-bottom: 1px solid #ddd;
  }
  .userInfoBox li:last-child{
      border-bottom: 1px solid transparent;
  }
  .userInfoBox  .el-input,.userInfoBox  .el-textarea{
      max-width:300px;
      min-width: 100px;
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
