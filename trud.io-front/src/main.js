import Vue from 'vue'
import App from './App.vue'
import toastr from 'toastr'
import axios from 'axios';
import store from './store'
import router from './router'
import AppLayout from '@/layouts/AppLayout'
import VueApexCharts from 'vue-apexcharts'


Vue.use(VueApexCharts)

Vue.component('apexchart', VueApexCharts)
Vue.component("AppLayout", AppLayout);

axios.defaults.baseURL = "http://localhost:8080/api/v1";
// axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
// axios.defaults.headers.common['Access-Control-Allow-Headers'] = 'Origin, X-Requested-With, Content-Type, Accept';
// axios.defaults.withCredentials = true;
// axios.defaults.crossDomain = true;

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
