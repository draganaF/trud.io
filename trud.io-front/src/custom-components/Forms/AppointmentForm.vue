<template>
    <Form>
        <form-row v-if="appointment">
            <div class="col-4">
                <label style="font-size: 18px; margin-right: 3%;">Ime: </label>
                <label style="font-size: 18px;"><b>{{appointment.patientName}}</b></label>
            </div>
            <div class="col-4">
                <label style="font-size: 18px; margin-right: 3%;">Prezime: </label>
                <label style="font-size: 18px;"><b>{{appointment.patientLastName}}</b></label>
            </div>
            <div class="col-4">
                <label style="font-size: 18px; margin-right: 3%;">JMBG: </label>
                <label style="font-size: 18px;"><b>{{appointment.patientJmbg}}</b></label>
            </div>
        </form-row>

        <form-row>
            <div class="col-12">
                <br>
            </div>
        </form-row>

        <form-row v-if="!isSaved">
            <div class="col-4">
                <text-input 
                    label="Gornji pritisak"
                    v-model="appointmentForUpdate.bloodPressureUpper"
                    type="number"
                />
            </div>
            <div class="col-4">
                <text-input 
                    label="Donji pritisak"
                    v-model="appointmentForUpdate.bloodPressureLower"
                    type="number"
                />
            </div>
            <div class="col-4">
                <text-input 
                    label="Težina"
                    v-model="appointmentForUpdate.weight"
                    type="number"
                />
            </div>
        </form-row>

        <form-row v-if="!isSaved">
            <div class="col-12">
                <text-input 
                    label="Izveštaj"
                    v-model="appointmentForUpdate.report"
                    type="text"
                />
            </div>
        </form-row>

        <Button v-if="!isSaved" @click="handleSaveClick">Sačuvaj</Button>
        <Button v-if="!isCreated && isSaved" @click="handleNewAppointmentClick">Zakaži novi pregled</Button>
    </Form>
</template>

<script>

import Button from '../../generic-components/Form/Button.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import toastr from 'toastr'
import { mapActions, mapGetters } from 'vuex'

export default {
   components: {
       Form,
       FormRow,
       TextInput,
       Button
    },

    data: function() {
        return {
            appointment: null,
            appointmentForUpdate: {
                bloodPressureUpper: 0,
                bloodPressureLower: 0,
                weight: 0,
                report: ""
            },
            isSaved: false,
            isCreated: false
        }
    },

    computed: {
        ...mapGetters({
            result: 'appointments/getResult',
            getAppointment: 'appointments/getAppointment'
        })
    },

    watch: {
        result({label, ok, message}) {
            if(label === 'update') {
                if(ok) {
                    this.isSaved = true;
                    toastr.success(message);
                }
                else {
                    toastr.error(message);
                }
            }
            if(label === 'create') {
                if(ok) {
                    this.isCreated = true;
                    toastr.success(message);
                    this.$router.push("/appointments/not-processed");
                }
                else {
                    toastr.error(message);
                }
            }
        },
        getAppointment(appointment) {
            this.appointment = appointment;
        }
    },

    methods: {
        ...mapActions({
            fetchAppointment: 'appointments/fetchAppointmentById',
            updateAppointment: 'appointments/updateAppointment',
            createAppointment: 'appointments/createAppointment'
            }),

        handleSaveClick() {
            this.updateAppointment({
                "appointmentForUpdate": this.appointmentForUpdate,
                "id": this.appointment.id
            })
            
        },

        handleNewAppointmentClick() {
            this.createAppointment(this.appointment.pregnancyId);
        }
    },
    
    mounted() {
        this.fetchAppointment(this.$route.params.id);
    }
}

</script>
