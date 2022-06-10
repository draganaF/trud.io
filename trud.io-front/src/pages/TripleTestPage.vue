<template>
    <div class="content">
        <div class="container-fluid">
            <div class="center align-items-center col-5" style="margin-left: 8%">
                <card :title="'Dodajte podatke za tripl test'">
                    <TripleTestForm :pregnancyId="1"/>
                </card>
            </div>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import TripleTestForm from '../custom-components/Forms/TripleTestForm.vue'

export default {
    components: {
        Card,
        TripleTestForm
    }
}
</script>
