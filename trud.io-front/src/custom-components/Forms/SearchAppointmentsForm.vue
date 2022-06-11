<template>
    <Form>
        <form-row>
            <div class="col-12">
                <text-input 
                    label="JMBG pacijenta"
                    v-model="jmbg"
                    type="text"
                />
            </div>
        </form-row>

        <Button @click="handleSearchClick">Pretražite</Button>
    </Form>
</template>

<script>

import Button from '../../generic-components/Form/Button.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import toastr from 'toastr'
import { mapActions, mapGetters } from 'vuex'

export default {
   components: {
       Form,
       FormRow,
       TextInput,
       Button
    },

    data: function() {
        return {
            jmbg: ''
        }
    },

    computed: {
        ...mapGetters({result: 'appointments/getResult'})
    },

    watch: {
        result({ok, message, label}) {
            if(label !== 'fetch') 
                return;

            if(!ok) {
                toastr.error(message)
            }
        }
    },

    methods: {
        ...mapActions({
            fetchByJmbg: 'appointments/fetchAppointmentsByPatientJmbg',
            fetchAll: 'appointments/fetchAppointments'
            }),

        handleSearchClick() {
            if(this.jmbg === '') {
                this.fetchAll();
            }
            else {
                this.fetchByJmbg(this.jmbg);
            }
        }
    }
}

</script>
