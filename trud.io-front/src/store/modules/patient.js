import axios from "axios";

const state = {
    result: null
};

const getters = {
    getResult: state => state.result
};  

const actions = {
    registerPatient: (context, patient) => {
        axios.post('/patient', patient)
        .then(response => {
            console.log(response)
            context.commit('setResult', {
                label: 'register',
                ok: true,
                message: ''
            });
        })
        .catch(error => {
            context.commit('setResult', {
                label: 'register',
                ok: false,
                message: error.response.data.message
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