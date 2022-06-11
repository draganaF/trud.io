import axios from "axios";

const state = {
    result: null,
    appointments: null,
    appointment: null
};

const getters = {
    getResult: state => state.result,
    getAppointments: state => state.appointments,
    getAppointment: state => state.appointment
};  

const actions = {
    fetchAppointments: (context) => {
        axios.get(`/appointment/not-processed`)
        .then((response) => {
            context.commit('setAppointments', response.data);
        })
        .catch(error => {
            context.commit('setResult', {
                label: 'fetch',
                ok: false,
                message: error.response.data.message
            });
        });        
    },
    fetchAppointmentsByPatientJmbg: (context, jmbg) => {
        axios.get(`/appointment/not-processed/by-patient/` + jmbg)
        .then((response) => {
            context.commit('setAppointments', response.data);
        })
        .catch(error => {
            context.commit('setResult', {
                label: 'fetch',
                ok: false,
                message: error.response.data.message
            });
        });        
    },
    fetchAppointmentById: (context, id) => {
        axios.get(`/appointment/` + id)
        .then((response) => {
            context.commit('setAppointment', response.data);
        })
        .catch(error => {
            context.commit('setResult', {
                label: 'fetch',
                ok: false,
                message: error.response.data.errorMessage
            });
        });        
    },
    updateAppointment: (context, {appointmentForUpdate, id}) => {
        axios.put(`/appointment/` + id, appointmentForUpdate)
        .then((response) => {
            context.commit('setAppointment', response.data);
            context.commit('setResult', {
                label: 'update',
                ok: true,
                message: "Uspešno ste sačuvali izveštaj."
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
    createAppointment: (context, pregnancyId) => {
        axios.post(`/appointment/` + pregnancyId)
        .then(() => {
            context.commit('setResult', {
                label: 'create',
                ok: true,
                message: "Uspešno ste kreirali novi termin."
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
    setAppointments: (state, response) => {
        state.appointments = response;
    },
    setAppointment: (state, response) => {
        state.appointment = response;
    }
};

export default {
    state: state,
    getters: getters,
    actions: actions,
    mutations: mutations,
    namespaced: true
};