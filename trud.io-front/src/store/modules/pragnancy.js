import axios from "axios";
import { getUserId, setPregnancyId } from "../../utils/userInfo";

const state = {
    result: null
};

const getters = {
    getResult: state => state.result
};  

const actions = {
    createPregnancy: (context, pregnancy) => {
        axios.post('/pregnancy', pregnancy)
        .then(response => {
            console.log(response)
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
                message: error.response.data.message
            });
        });        
    },
    
    fetchCurrentPregnancyForPatient: (context) => {
        const userId = getUserId();
        axios.get('/pregnancy/current/' + userId)
        .then(response => {
            setPregnancyId(response.data.id);
        })
        .catch(error => {
            context.commit('setResult', {
                label: 'authenticate',
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