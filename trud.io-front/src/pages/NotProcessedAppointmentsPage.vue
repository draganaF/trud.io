<template>
    <div class="content">
        <div class="container-fluid">
            <div class="center align-items-center col-10" style="margin-left: 8%">
                <card :title="'Neobrađeni pregledi'">
                    <SearchAppointmentsForm />
                    <NotProcessedAppointmentsTable />
                </card>
            </div>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import NotProcessedAppointmentsTable from '../custom-components/Tables/NotProcessedAppointmentsTable.vue'
import SearchAppointmentsForm from '../custom-components/Forms/SearchAppointmentsForm.vue'
import { mapActions } from 'vuex'

export default {
    components: {
        Card,
        NotProcessedAppointmentsTable,
        SearchAppointmentsForm
    },

    methods: {
        ...mapActions({fetchAppointments: 'appointments/fetchAppointments'}),
    },

    mounted() {
        this.fetchAppointments();
    }
}
</script>
