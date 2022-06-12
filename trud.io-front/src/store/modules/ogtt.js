import axios from "axios";
const state = {
  result: null,
  ogttTest: null,
  ogttTests: [],
  pregnancyResult: null
};

const getters = {
  getResult: state => state.result,
  getOgttTest: state => state.ogttTest,
  getOgttTests: state => state.ogttTests,
  getPregnancyResult: state => state.pregnancyResult
};

const actions = {
  doctorsOgtt: (context) => {
    axios.get('/ogtt-test/all')
    .then(response => {
      console.log(response);
      context.commit('setOgttTests', response.data)
    })
    .catch(error => {
      context.commit('setResult', {
        label: 'create',
        ok: false,
        message: error.response.data.message
      })
    })
  },
  patientOgtt: (context, id) => {
    axios.get('/ogtt-test/patient/' + id)
      .then(response => {
        context.commit('setOgttTests', response.data)
      })
      .catch(error => {
        context.commit('setResult', {
          label: 'create',
          ok: false,
          message: error.response.data.message
        })
      })
  },
  createOgttTest: (context, { pregnancyId, id, ogtt }) => {
    axios.post('/ogtt-test/' + pregnancyId + "/" + id, ogtt)
      .then(response => {
        context.commit('setResult', {
          ogttObject: response.data,
          label: 'create',
          ok: true,
          message: 'Uspješno ste upisali rezultate primarnog ogtt testa.'
        });
      })
      .catch(error => {
        context.commit('setResult', {
          label: 'create',
          ok: false,
          message: error.response.data.message
        });
      });
  },

  updateOgttTest: (context, { pregnancyId, id, ogtt }) => {
    axios.post('/ogtt-test/' + pregnancyId + "/extendedOgtt/" + id, ogtt)
      .then(response => {
        context.commit('setResult', {
          ogttObject: response.data,
          label: 'update',
          ok: true,
          message: 'Kreiran prošireni ogtt'
        });
      })
      .catch(error => {
        context.commit('setResult', {
          label: 'update',
          ok: false,
          message: error.response.data.message
        });
      });
  },

  createDailyGlucoseLevel: (context, {glucoseLevel, pregnancyId}) => {
    console.log(glucoseLevel);
    axios.post('/glucose-levels/' + pregnancyId, glucoseLevel)
      .then((response) => {
        context.commit('setPregnancyResult', response.data);
        context.commit('setResult', {
          label: 'createDailyGlucoseLevel',
          ok: true,
          message: 'Uspešno su sačuvani uneti podaci.'
        });
      })
      .catch(error => {
        context.commit('setResult', {
          label: 'createDailyGlucoseLevel',
          ok: false,
          message: error.response.data.message
        });
      });
  }
};

const mutations = {
  setResult: (state, response) => {
    state.result = response;
  },
  setOgttTest: (state, response) => {
    state.ogttTest = response;
  },
  setOgttTests: (state, response) => {
    state.ogttTests = response;
  },
  setPregnancyResult: (state, response) => {
    state.pregnancyResult = response;
  }
};

export default {
  state: state,
  getters: getters,
  actions: actions,
  mutations: mutations,
  namespaced: true
};