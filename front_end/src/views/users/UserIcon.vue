<!-- 用户头像，下拉框(包含个人信息,我的博客,我的消息,我的收藏)等，在顶部使用 -->
<template>
</template>

<script>
  export default{
  	name:'navbar',
  	data(){
  		return{
        blognav:[
          {path:"avatar",meta:{navname:"用户头像",index:100},
            comp:<a-popover trigger="click">,
              <template slot="content">
                <p><a href="UserInfo">个人信息</a></p>
                <p><a href="../blogs/MyBlog">我的博客</a></p>
                <p><a href="MyMessage">我的消息</a></p>
                <p><a href="../favors/collect">我的收藏</a></p>
              </template>  
          },
          
          ]
      }
  	},
  	
  }
</script>

<style>
</style>
