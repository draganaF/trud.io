<template>
    <div class="content">
        <div class="container-fluid">
            <div class="center align-items-center col-10" style="margin-left: 8%">
                <card :title="'Registracija'">
                    <RegistrationForm />
                </card>
            </div>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import RegistrationForm from '../custom-components/Forms/RegistrationForm.vue'

export default {
    components: {
        Card,
        RegistrationForm
    }
}
</script>