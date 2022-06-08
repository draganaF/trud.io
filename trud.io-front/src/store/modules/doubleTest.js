import axios from "axios";

const state = {
    result: null
};

const getters = {
    getResult: state => state.result
};  

const actions = {
    createDoubleTest: (context, createDoubleTest) => {
        axios.post(`/double-test/${createDoubleTest.pregnancyId}`, createDoubleTest.doubleTest)
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
    }
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