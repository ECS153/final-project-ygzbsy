
<template>
  <el-tabs v-model="activeName" @tab-click="handleClick" >
    <el-tab-pane label="Sign In" name="first"><login/></el-tab-pane>
    <el-tab-pane label="Sign up" name="second"><signup/></el-tab-pane>
    <el-tab-pane label="GitHub" name="third"></el-tab-pane>


  </el-tabs>
</template>
<script>
import login from './login'
import signup from './signup'
  export default {
    components: {
      login,
      signup
    },
    data() {
      return {
        activeName: 'first'
      };
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
  };
</script>
<style>
.el-tabs__header .is-top{
  /* float: right; */
  /* margin-left: 800px; */
  /* width:250px; */
}
</style>


<!-- <template><div class = nav>
<el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
  <el-menu-item index="1">Sign in</el-menu-item>
  <el-menu-item index="2">Sign up</el-menu-item>
  <el-menu-item index="3"><a href="https://github.com/ECS153/final-project-ygzbsye" target="_blank">GitHub</a></el-menu-item>
</el-menu>
<div class="line"></div>
</div></template>


<script>
  export default {
    data() {
      return {
        activeIndex: '1'
      };
    },
    methods: {
      handleSelect(key, keyPath) {

        // console.log(key, keyPath);
      }
    }
  }
</script>

<style>
  .nav{
    float: right;
    /* margin-left: 800px; */
    width:250px;
  }
</style> -->
