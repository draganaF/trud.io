<template>
    <div class="content">
        <div class="container-fluid">
            <div class="center align-items-center col-10" style="margin-left: 8%">
                <card :title="'Izveštaj o simptomima'">
                    <SymptomsReportForm />
                </card>
                <card :title="'Izveštaj o poremećajima'">
                    <ChromosomalDisordersReportForm />
                </card>
                <card :title="'Izveštaj o bolestima'">
                    <IllnessesReportForm />
                </card>
            </div>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import SymptomsReportForm from '../custom-components/Forms/SymptomsReportForm.vue'
import ChromosomalDisordersReportForm from "../custom-components/Forms/ChromosomalDisordersReportForm.vue"
import IllnessesReportForm from "../custom-components/Forms/IllnessesReportForm.vue"

export default {
    components: {
        Card,
        SymptomsReportForm,
        ChromosomalDisordersReportForm,
        IllnessesReportForm
    }
}
</script>
