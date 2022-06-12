import axios from "axios";

const state = {
    result: null,
    doubleTest: null
};

const getters = {
    getResult: state => state.result,
    getDoubleTest: state => state.doubleTest
};  

const actions = {
    createDoubleTest: (context, createDoubleTest) => {
        axios.post(`/double-test/${createDoubleTest.pregnancyId}`, createDoubleTest.doubleTest)
        .then((response) => {
            context.commit('setDoubleTest', response.data);
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
    }
};

const mutations = {
    setResult: (state, response) => {
        state.result = response;
    },
    setDoubleTest: (state, response) => {
        state.doubleTest = response;
    },
};

export default {
    state: state,
    getters: getters,
    actions: actions,
    mutations: mutations,
    namespaced: true
};