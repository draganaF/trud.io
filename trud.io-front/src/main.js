import Vue from 'vue'
import App from './App.vue'
import toastr from 'toastr'
import axios from 'axios';
import store from './store'
import router from './router'
import AppLayout from '@/layouts/AppLayout'

Vue.component("AppLayout", AppLayout);

axios.defaults.baseURL = "http://localhost:8080/api/v1";

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');


toastr.options = {
  closeButton: false,
  debug: false,
  newestOnTop: false,
  progressBar: false,
  positionClass: "toast-top-center",
  preventDuplicates: true,
  onclick: null,
  showDuration: "300",
  hideDuration: "1000",
  timeOut: "5000",
  extendedTimeOut: "1000",
  showEasing: "swing",
  hideEasing: "linear",
  showMethod: "fadeIn",
  hideMethod: "fadeOut",
};
