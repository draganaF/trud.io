<template>
    <div class="col-md-6 col-lg-6 col-sm-10">
        <card :title="'Profil'">
            <PatientForm :patient="p"/>
        </card>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import PatientForm from '../custom-components/Forms/PatientForm.vue'
import { getUserId } from '../utils/userInfo'
import {mapGetters, mapActions} from 'vuex'
export default {
    components: {
        Card,
        PatientForm
    },
     data: function() {
        return {
            p: null
        }
    },
    computed: {
           ...mapGetters({
            patient: 'patient/getPatient'}),
         
    },

    watch: {
        patient(newPatient){
            this.p = newPatient;
        }
    },

    methods: {
         ...mapActions({fetchPatient: 'patient/fetchPatient'}),
    },

    mounted()
    {
        
        this.fetchPatient(getUserId());
    }
}
</script>
