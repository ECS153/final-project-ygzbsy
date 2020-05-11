<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <navi/>
    <!-- <div class = "layout"> -->
      <!-- <login/>
      <signup/> -->
    </div>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld'
import navi from './components/navigator'
// import login from './components/login'
// import signup from './components/signup'
export default {
  name: 'App',
  components: {
    navi
    // login,
    // signup
  },
  method:{
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style>
.layout{
  clear:right;
  position: relative;
  z-index: 0;
}
.active{
  visibility: visible;
}
/* #app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
</style>
