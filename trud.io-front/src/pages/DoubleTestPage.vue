<template>
    <div class="content">
        <div class="container-fluid">
            <div class="center align-items-center col-5" style="margin-left: 8%">
                <card :title="'Dodajte podatke za dabl test'">
                    <DoubleTestForm :pregnancyId="1"/>
                </card>
            </div>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import DoubleTestForm from '../custom-components/Forms/DoubleTestForm.vue'

export default {
    components: {
        Card,
        DoubleTestForm
    }
}
</script>
