import axios from "axios";

const state = {
    result: null,
    patient: null,
    patients: null
};

const getters = {
    getResult: state => state.result,
    getPatient: state => state.patient,
    getPatients: state => state.patients
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
    },
    fetchPatient: (context, id) => {
        axios.get(`/patient/` + id)
        .then(response => {
            console.log(response);
          context.commit("setPatient", response.data);
        })
        .catch(error => {
          context.commit("setResult", {label: "fetchPatient", ok: false, message: error.response.data.errorMessage })
        })
      },

      fetchPatients: (context) => {
        axios.get(`/patient/`)
        .then(response => {
          context.commit("setPatients", response.data);
        })
        .catch(error => {
          context.commit("setResult", {label: "fetchPatients", ok: false, message: error.response.data.errorMessage })
        })
      },
};

const mutations = {
    setResult: (state, response) => {
        state.result = response;
    },
    setPatient: (state, response) => {
        state.patient = response;
    },
    setPatients: (state, response) => {
        state.patients = response;
    }
};

export default {
    state: state,
    getters: getters,
    actions: actions,
    mutations: mutations,
    namespaced: true
};