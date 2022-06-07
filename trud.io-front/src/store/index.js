import Vue from "vue";
import Vuex from "vuex";
import authentication from "./modules/authetication.js"
import pregnancy from "./modules/pragnancy.js"
import report from "./modules/report.js"
import patient from "./modules/patient.js"


Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    authentication,
    pregnancy,
    report,
    patient
  },
});
