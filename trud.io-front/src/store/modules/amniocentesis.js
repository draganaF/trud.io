import axios from "axios";

const state = {
    result: null
};

const getters = {
    getResult: state => state.result
};  

const actions = {
    createAmniocentesis: (context, createAmniocentesis) => {
        axios.post(`/amniocentesis/${createAmniocentesis.pregnancyId}`, createAmniocentesis.amniocentesis)
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
    updateAmniocentesis: (context, updateAmniocentesis) => {
        axios.put(`/amniocentesis/${updateAmniocentesis.pregnancyId}`, updateAmniocentesis.amniocentesis)
        .then(() => {
            context.commit('setResult', {
                label: 'update',
                ok: true,
                message: ''
            });
        })
        .catch(error => {
            context.commit('setResult', {
                label: 'update',
                ok: false,
                message: error.response.data.errorMessage
            });
        });        
    },
};

const mutations = {
    setResult: (state, response) => {
        state.result = response;
    }
};

export default {
    state: state,
    getters: getters,
    actions: actions,
    mutations: mutations,
    namespaced: true
};