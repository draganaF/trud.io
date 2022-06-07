import Vue from "vue";
import Vuex from "vuex";
import authentication from "./modules/authetication.js"
import pregnancy from "./modules/pragnancy.js"
import doubleTest from "./modules/doubleTest.js"
import tripleTest from "./modules/tripleTest.js"
import quadripleTest from './modules/quadripleTest.js'
import amniocentesis from './modules/amniocentesis.js'

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    authentication,
    pregnancy,
    doubleTest,
    tripleTest,
    quadripleTest,
    amniocentesis
  },
});
