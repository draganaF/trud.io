<template>
    <div class="content">
        <div class="container-fluid">
            <div class="center align-items-center col-10" style="margin-left: 8%">
                <card :title="'Izveštaj o pregledu pacijentkinje'">
                    <AppointmentForm />
                </card>
            </div>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import AppointmentForm from '../custom-components/Forms/AppointmentForm.vue'

export default {
    components: {
        Card,
        AppointmentForm
    }
}
</script>
