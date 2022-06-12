import axios from "axios";

const state = {
    result: null,
    quadripleTest: null
};

const getters = {
    getResult: state => state.result,
    getQuadripleTest: state => state.quadripleTest

};  

const actions = {
    createQuadripleTest: (context, createQuadripleTest) => {
        axios.post(`/quadriple-test/${createQuadripleTest.pregnancyId}`, createQuadripleTest.quadripleTest)
        .then((response) => {
            context.commit('setQuadripleTest', response.data);
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
    setQuadripleTest: (state, response) => {
        state.quadripleTest = response;
    }
};

export default {
    state: state,
    getters: getters,
    actions: actions,
    mutations: mutations,
    namespaced: true
};