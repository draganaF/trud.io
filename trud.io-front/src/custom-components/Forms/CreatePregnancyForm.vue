<template>
    <Form>
        <form-row>
            <div class="col-12">
                <text-input 
                    label="JMBG pacijentkinje"
                    v-model="pregnancy.jmbg"
                    type="text"
                />
            </div>
        </form-row>

        <form-row>
            <div class="col-12">
                <date-time-picker 
                    label="Datum početka trudnoće"
                    v-model="pregnancy.startDate"
                    type="date"
                />
            </div>
        </form-row>

        <form-row>
            <div class="col-12">
                <text-input 
                    label="Broj trudnoće"
                    v-model="pregnancy.numberOfPregnancy"
                    type="number"
                />
            </div>
        </form-row>

        <Button @click="handleClickCreatePregnancy">Kreiraj trudnoću</Button>
    </Form>
</template>

<script>

import Button from '../../generic-components/Form/Button.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import DateTimePicker from '../../generic-components/Form/DateTimePicker.vue'
import toastr from 'toastr'
import { mapActions, mapGetters } from 'vuex'

export default {
   components: {
       Form,
       FormRow,
       TextInput,
       Button,
       DateTimePicker
    },

    data: function() {
        return {
            pregnancy: {
                jmbg: null,
                startDate: null,
                numberOfPregnancy: 0
            }
        }
    },

    computed: {
        ...mapGetters({result: 'pregnancy/getResult'})
    },

    watch: {
        result({ok, message, label}) {
            if(label !== 'create') 
                return;

            if(ok) {
                toastr.success("Uspešno ste dodali trudnoću.")
            } else {
                toastr.error(message)
            }
        }
    },

    methods: {
        ...mapActions({createPregnancy: 'pregnancy/createPregnancy'}),

        handleClickCreatePregnancy() {

            this.createPregnancy(this.pregnancy);
        }
    }
}

</script>
