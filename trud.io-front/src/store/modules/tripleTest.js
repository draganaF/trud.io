import axios from "axios";

const state = {
    result: null,
    tripleTest: null,
};

const getters = {
    getResult: state => state.result,
    getTripleTest: state => state.tripleTest,
};  

const actions = {
    createTripleTest: (context, createTripleTest) => {
        axios.post(`/triple-test/${createTripleTest.pregnancyId}`, createTripleTest.tripleTest)
        .then((response) => {
            context.commit('setTripleTest', response.data);
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
        .then((response) => {
            context.commit('setTripleTest', response.data);
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

    setTripleTest: (state, response) => {
        state.tripleTest = response;
    },
};

export default {
    state: state,
    getters: getters,
    actions: actions,
    mutations: mutations,
    namespaced: true
};