<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <navi/>
    <login/>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld'
import navi from './components/navigator'
import login from './components/login'

export default {
  name: 'App',
  components: {
    navi,
    login
  }
}
</script>

<style>
/* #app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
</style>
