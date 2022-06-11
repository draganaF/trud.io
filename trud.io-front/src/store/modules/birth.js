import axios from "axios";

const state = {
    result: null
};

const getters = {
    getResult: state => state.result
};  

const actions = {
    createBirth: (context, createBirth) => {
        axios.post(`/birth`, createBirth)
        .then(() => {
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
                message: error.response.data.errorMessage
            });
        });        
    },

      abortion: (context, id) => {
        axios.put(`/birth/abortion/${id}`)
        .then(response => {
          context.commit("setResult", response.data);
        })
        .catch(error => {
          context.commit("setResult", {label: "abortion", ok: false, message: error.response.data.errorMessage })
        })
      },
};

const mutations = {
    setResult: (state, response) => {
      state.result = response;
    },
};

export default {
    state: state,
    getters: getters,
    actions: actions,
    mutations: mutations,
    namespaced: true
};