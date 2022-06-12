<template>
    <div class="content">
        <Card title='Pacijenti'>
            <PatientsTable v-if="patients !== null" :patients="patients" />
        </Card>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import PatientsTable from '../custom-components/Tables/PatientsTable.vue'
import { mapActions, mapGetters } from 'vuex'

export default {
    components: {
        Card,
        PatientsTable
    },
    data: function() {
        return {
        }
    },
    computed: {
           ...mapGetters({
            patients: 'patient/getPatients',
        }),
         
    },

    watch: {
    },

    methods: {
        ...mapActions({
            fetchPatients: 'patient/fetchPatients'}),

    },

    mounted()
    {
        this.fetchPatients();
        
    },
}
</script>
