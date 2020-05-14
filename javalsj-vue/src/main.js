// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import Vue from 'vue'
import App from './App'


Vue.config.productionTip = false
Vue.use(ElementUI);
export const bus = new Vue();
/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>'
})

// var Ctor = Vue.extend(Main)
// new Ctor().$mount('#app')
