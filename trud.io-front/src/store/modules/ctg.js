import axios from 'axios'

const state = {
  result: null,
  ctg: null,
  ctgs: []
};

const getters = {
  getResult: state => state.result,
  getCTG: state => state.ctg,
  getCTGs: state => state.ctgs,
};

const actions = {
  allCTGs: (context) => {
    axios.get('/ctg/all')
    .then(response => {
      context.commit('setCTGs', response.data);
    })
    .catch(error => {
      context.commit('setResult', {
        label: 'getAllCtgs',
        ok: false,
        message: error.response.data.message
      })
    })
  },

  allPregnanciesCTGs: (context, pregnancyId) => {
    axios.get('/ctg/pregnancy-ctgs/' + pregnancyId)
    .then(response => {
      context.commit('setCTGs', response.data);
    })
    .catch(error => {
      context.commit('setResult', {
        label: 'getAllCtgs',
        ok: false,
        message: error.response.data.message
      })
    })
  }
};

const mutations = {
  setResult: (state, response) => {
    state.result = response;
  },
  setCTG: (state, response) => {
    state.ctg = response;
  },
  setCTGs: (state, response) => {
    state.ctgs = response;
  }
};

export default {
  state: state,
  getters: getters,
  actions: actions,
  mutations: mutations,
  namespaced: true
};