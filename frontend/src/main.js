import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
Vue.use(BootstrapVue)

Vue.config.productionTip = false;

// グローバルなフィルターを設定。
Vue.filter('moneyDelemiter', function(val){
  return Number(val).toLocaleString(); //3桁区切りでカンマをつける
});
new Vue({
  el: "",
  data: {iminteger:654321},

})

new Vue({
  store,
  router,
  render: h => h(App),
}).$mount('#app');