<template>
    <div class="content">
        <div class="container-fluid">
            <div class="center align-items-center col-10" style="margin-left: 8%">
                <card :title="'Unos podataka o nivou šećera u krvi'">
                    <DailyGlucoseLevelForm />
                </card>
            </div>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import DailyGlucoseLevelForm from '../custom-components/Forms/DailyGlucoseLevelForm.vue'

export default {
    components: {
        Card,
        DailyGlucoseLevelForm
    }
}
</script>
