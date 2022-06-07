<template>
    <Form>
        <form-row>
            <div class="col-12">
                <SelectOptionInput 
                        label="Izaberite poremećaj"
                        v-model="selectedDisorder"
                        :options="disorders"
                ></SelectOptionInput>
            </div>
        </form-row>

        <form-row v-if="disorderReport">
            <div class="col-12">
                <h4 style="margin-top: 2%; margin-left: 1%">Procenat trudnoća sa izabranim poremećajom je <b>{{disorderReport.percentage}}</b></h4>
            </div>
        </form-row>

        <Button @click="handleGenerateReport">Generiši izveštaj</Button>
    </Form>
</template>

<script>

import Button from '../../generic-components/Form/Button.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import SelectOptionInput from '../../generic-components/Form/SelectOptionInput.vue'
import toastr from 'toastr'
import { mapActions, mapGetters } from 'vuex'
import { chromosomalDisorders } from '../../constants.js';

export default {
   components: {
       Form,
       FormRow,
       SelectOptionInput,
       Button
    },

    data: function() {
        return {
            selectedDisorder: [],
            disorders: null
        }
    },

    computed: {
        ...mapGetters({
            result: 'report/getResult',
            disorderReport: "report/getDisorderReport"
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
        ...mapActions({generateDisorderReport: 'report/generateDisorderReport'}),

        handleGenerateReport() {

            this.generateDisorderReport(this.selectedDisorder);
        }
    },

    mounted()
    {
        this.disorders = chromosomalDisorders;
    },
}

</script>
