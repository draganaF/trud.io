<template>
    <div class="content">
        <div class="container-fluid">
            <div class="center align-items-center col-5" style="margin-left: 8%">
                <card :title="'Dodajte podatke za amniocentezu'">
                    <AmniocentesisForm :pregnancyId="1"/>
                </card>
            </div>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import AmniocentesisForm from '../custom-components/Forms/AmniocentesisForm.vue'

export default {
    components: {
        Card,
        AmniocentesisForm
    }
}
</script>
