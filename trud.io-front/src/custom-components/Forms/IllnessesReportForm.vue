<template>
    <Form>
        <form-row>
            <div class="col-12">
                <MultiSelectOptionInput 
                        label="Izaberite bolesti"
                        v-model="selectedIllnesses"
                        :options="illnesses"
                ></MultiSelectOptionInput>
            </div>
        </form-row>

        <form-row v-if="illnessesReport">
            <div class="col-12">
                <h4 style="margin-top: 2%; margin-left: 1%">Procenat trudnoća sa izabranim bolestima je <b>{{illnessesReport.percentage}}</b></h4>
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
import { illnesses } from '../../constants.js';

export default {
   components: {
       Form,
       FormRow,
       MultiSelectOptionInput,
       Button
    },

    data: function() {
        return {
            selectedIllnesses: [],
            illnesses: null
        }
    },

    computed: {
        ...mapGetters({
            result: 'report/getResult',
            illnessesReport: "report/getIllnessesReport"
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
        ...mapActions({generateIllnessesReport: 'report/generateIllnessesReport'}),

        handleGenerateReport() {

            this.generateIllnessesReport(this.selectedIllnesses);
        }
    },

    mounted()
    {
        this.illnesses = illnesses;
    },
}

</script>
