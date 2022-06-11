import axios from "axios";

const state = {
    result: null
};

const getters = {
    getResult: state => state.result
};  

const actions = {
    createTripleTest: (context, createTripleTest) => {
        axios.post(`/triple-test/${createTripleTest.pregnancyId}`, createTripleTest.tripleTest)
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
    updateTripleTest: (context, updateTripleTest) => {
        axios.put(`/triple-test/${updateTripleTest.pregnancyId}`, updateTripleTest.tripleTest)
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