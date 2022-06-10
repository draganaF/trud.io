import axios from "axios";

const state = {
    result: null,
    pregnancy: null,
    pregnancies: null
};

const getters = {
    getResult: state => state.result,
    getPregnancy: state => state.pregnancy,
    getPregnancies: state => state.pregnancies
};  

const actions = {
    createPregnancy: (context, pregnancy) => {
        axios.post('/pregnancy', pregnancy)
        .then(response => {
            console.log(response)
            context.commit('setResult', {
                label: 'create',
                ok: true,
                message: ''
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

    fetchPregnancy: (context, id) => {
        axios.get(`/pregnancy/` + id)
        .then(response => {
          context.commit("setPregnancy", response.data);
        })
        .catch(error => {
          context.commit("setResult", {label: "fetchPregnancy", ok: false, message: error.response.data.errorMessage })
        })
      },

      fetchPregnancies: (context) => {
        axios.get(`/pregnancy/`)
        .then(response => {
          context.commit("setPregnancies", response.data);
        })
        .catch(error => {
          context.commit("setResult", {label: "fetchPregnancies", ok: false, message: error.response.data.errorMessage })
        })
      },

      addSymptoms: (context, pregnancy) => {
        axios.put(`/pregnancy/symptoms/${pregnancy.id}`, pregnancy.symptoms)
        .then(response => {
          context.commit("setResult", response.data);
        })
        .catch(error => {
          context.commit("setResult", {label: "addSymptoms", ok: false, message: error.response.data.errorMessage })
        })
      },
};

const mutations = {
    setResult: (state, response) => {
      state.result = response;
    },
    setPregnancy: (state, pregnancy) => {
      state.pregnancy = pregnancy;
      },
    setPregnancies: (state, pregnancies) => {
      state.pregnancies = pregnancies;
      }
};

export default {
    state: state,
    getters: getters,
    actions: actions,
    mutations: mutations,
    namespaced: true
};