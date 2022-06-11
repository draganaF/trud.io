import axios from "axios";
import { tryConnecting } from "../../utils/sockets.js";
import { setRole, setUserId } from "../../utils/userInfo.js"

const state = {
    result: null
};

const getters = {
    getResult: state => state.result
};  

const actions = {
    authenticate: (context, credentials) => {
        axios.post('/auth/login', credentials)
        .then(response => {
            setRole(response.data.role);
            setUserId(response.data.id);

            if(response.data.role == 'DOCTOR') {
                tryConnecting();
            }

            //treba dodati pregnancy ukoliko je pacijent u pitanju
            context.commit('setResult', {
                label: 'authenticate',
                ok: true,
                message: ''
            });
        })
        .catch(error => {
            context.commit('setResult', {
                label: 'authenticate',
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