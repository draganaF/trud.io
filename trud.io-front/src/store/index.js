import Vue from "vue";
import Vuex from "vuex";
import authentication from "./modules/authetication.js"
import pregnancy from "./modules/pragnancy.js"
import doubleTest from "./modules/doubleTest.js"
import tripleTest from "./modules/tripleTest.js"
import quadripleTest from './modules/quadripleTest.js'
import amniocentesis from './modules/amniocentesis.js'
import report from "./modules/report.js"
import ogtt from "./modules/ogtt.js"

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    authentication,
    pregnancy,
    report,
    ogtt,
    doubleTest,
    tripleTest,
    quadripleTest,
    amniocentesis,
    report
  },
});
