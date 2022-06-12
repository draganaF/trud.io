import axios from "axios";
const state = {
  result: null,
  levels: [],
};

const getters = {
  getResult: state => state.result,
  getLevels: state => state.levels
};

const actions = {
  patientsLevels: (context, pregnancyId) => {
    axios.get('/glucose-levels/patients-level/' + pregnancyId)
    .then(response => {
      console.log(response.data);
      context.commit('setLevels', response.data)
    })
    .catch(error => {
      context.commit('setResult', {
        label: 'get',
        ok: false,
        message: error.response.data.message
      })
    })
  },
}

const mutations = {
  setResult: (state, response) => {
    state.result = response;
  },
  setLevels: (state, response) => {
    state.levels = response;
  }
};

export default {
  state: state,
  getters: getters,
  actions: actions,
  mutations: mutations,
  namespaced: true
};