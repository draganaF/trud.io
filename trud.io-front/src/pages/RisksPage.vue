<template>
    <div class="content">
        <div class="container-fluid">
            <div class="center align-items-center col-5" style="margin-left: 8%">
                <card :title="'Dodajte \'\cut off\' vrednost za hromozompatije'">
                    <RisksForm />
                </card>
            </div>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import RisksForm from '../custom-components/Forms/RisksForm.vue'

export default {
    components: {
        Card,
        RisksForm
    }
}
</script>
