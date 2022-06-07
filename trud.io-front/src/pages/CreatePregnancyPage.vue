<template>
    <div class="content">
        <div class="container-fluid">
            <div class="center align-items-center col-10" style="margin-left: 8%">
                <card :title="'Dodajte novu trudnoću'">
                    <CreatePregnancyForm />
                </card>
            </div>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import CreatePregnancyForm from '../custom-components/Forms/CreatePregnancyForm.vue'

export default {
    components: {
        Card,
        CreatePregnancyForm
    }
}
</script>
