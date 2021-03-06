import axios from "axios";

const state = {
    result: null,
    symptomReport: null,
    disorderReport: null,
    illnessesReport: null,
    statusReport: null,
    ctgChartResultReport: []
};

const getters = {
    getResult: state => state.result,
    getSymptomReport: state => state.symptomReport,
    getDisorderReport: state => state.disorderReport,
    getIllnessesReport: state => state.illnessesReport,
    getStatusReport: state => state.statusReport,
    getCtgChartResult: state => state.ctgChartResultReport
};  

const actions = {
    generateSymptomReport: (context, symptoms) => {
        const symptomsString = symptoms.length > 0 ? symptoms.reduce((f, s) => `${f},${s}`) : "";
        axios.get('/report/symptoms-report', {params: {"symptoms": symptomsString}})
        .then(response => {
            context.commit('setSymptomReport', response.data);
        })
        .catch(error => {
            context.commit('setResult', {
                label: 'symptomReport',
                ok: false,
                message: error.response.data.message
            });
        });        
    },
    generateDisorderReport: (context, chromosomalDisorder) => {
        axios.get('/report/disorders-report', {params: {"chromosomalDisorder": chromosomalDisorder}})
        .then(response => {
            context.commit('setDisorderReport', response.data);
        })
        .catch(error => {
            context.commit('setResult', {
                label: 'disordereport',
                ok: false,
                message: error.response.data.message
            });
        });        
    },
    generateIllnessesReport: (context, illneses) => {
        const illnessesString = illneses.length > 0 ? illneses.reduce((f, s) => `${f},${s}`) : "";
        axios.get('/report/illnesses-report', {params: {"illnessesNames": illnessesString}})
        .then(response => {
            context.commit('setIllnessesReport', response.data);
        })
        .catch(error => {
            context.commit('setResult', {
                label: 'illnessesReport',
                ok: false,
                message: error.response.data.message
            });
        });        
    },

    generateStatusReport: (context, status) => {
        
        axios.get('/report/ctg-result-report', {params: {"status": status}})
        .then(response => {
            context.commit('setStatusReport', response.data);
        })
        .catch(error => {
            context.commit('setResult', {
                label: 'statusReport',
                ok: false,
                message: error.response.data.message
            });
        });        
    },

    ctgChartReport: (context) => {
        axios.get('/report/ctg-chart')
        .then(response => {
            context.commit('setCtgChartResultReport', response.data);
        })
        .catch(error => {
            context.commit('setResult', {
                label: 'statusChartReport',
                ok: false,
                message: error.response.data.message
            });
        })
    }
};

const mutations = {
    setResult: (state, response) => {
        state.result = response;
    },
    setSymptomReport: (state, response) => {
        state.symptomReport = response;
    },
    setDisorderReport: (state, response) => {
        state.disorderReport = response;
    },
    setIllnessesReport: (state, response) => {
        state.illnessesReport = response;
    },
    setStatusReport: (state, response) => {
        state.statusReport = response;
    },
    setCtgChartResultReport: (state, response) => {
        state.ctgChartResultReport = response;
    }
};

export default {
    state: state,
    getters: getters,
    actions: actions,
    mutations: mutations,
    namespaced: true
};