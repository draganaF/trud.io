import axios from "axios";

const state = {
    result: null,
    amniocentesis: null
};

const getters = {
    getResult: state => state.result,
    getAmniocentesis: state => state.amniocentesis
};  

const actions = {
    createAmniocentesis: (context, createAmniocentesis) => {
        axios.post(`/amniocentesis/${createAmniocentesis.pregnancyId}`, createAmniocentesis.amniocentesis)
        .then((response) => {
            context.commit('setAmniocentesis', response.data);
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
        .then((response) => {
            context.commit('setAmniocentesis', response.data);
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
    },
    setAmniocentesis: (state, response) => {
        state.amniocentesis = response;
    }
   
};

export default {
    state: state,
    getters: getters,
    actions: actions,
    mutations: mutations,
    namespaced: true
};