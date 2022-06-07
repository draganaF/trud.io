<template>
    <Form>
        <form-row>
            <div class="col-12">
                <MultiSelectOptionInput 
                        label="Izaberite simptome"
                        v-model="selectedSymptoms"
                        :options="symptoms"
                ></MultiSelectOptionInput>
            </div>
        </form-row>

        <form-row v-if="symptomsReport">
            <div class="col-12">
                <h4 style="margin-top: 2%; margin-left: 1%">Procenat trudnoća sa izabranim simptomima je <b>{{symptomsReport.percentage}}</b></h4>
            </div>
        </form-row>

        <Button @click="handleGenerateReport">Generiši izveštaj</Button>
    </Form>
</template>

<script>

import Button from '../../generic-components/Form/Button.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import MultiSelectOptionInput from '../../generic-components/Form/MultiSelectOptionInput.vue'
import toastr from 'toastr'
import { mapActions, mapGetters } from 'vuex'
import { doctorSymptoms } from '../../constants.js';

export default {
   components: {
       Form,
       FormRow,
       MultiSelectOptionInput,
       Button
    },

    data: function() {
        return {
            selectedSymptoms: [],
            symptoms: null
        }
    },

    computed: {
        ...mapGetters({
            result: 'report/getResult',
            symptomsReport: "report/getSymptomReport"
        })
    },

    watch: {
        result(result) {
            if(!result.ok) {
                toastr.error(result.message)
            }
        }
    },

    methods: {
        ...mapActions({generateSymptomReport: 'report/generateSymptomReport'}),

        handleGenerateReport() {

            this.generateSymptomReport(this.selectedSymptoms);
        }
    },

    mounted()
    {
        this.symptoms = doctorSymptoms;
        this.symptoms.splice(0, 0, {
            value: -1,
            label: ''
        })
        this.symptoms.splice(0, 0, {
            value: -1,
            label: ''
        })
    },
}

</script>
