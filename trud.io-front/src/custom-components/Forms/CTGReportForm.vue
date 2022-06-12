<template>
  <Form>
    <FormRow>
      <div class="col-12">
        <MultiSelectOptionInput
          label="Izaberite rezultat CTGa"
          v-model="selectedStatus"
          :options="statuses"
        ></MultiSelectOptionInput>
      </div>
    </FormRow>

    <FormRow v-if="statusReport">
        <div class="col-12">
          
                <h4 style="margin-top: 2%; margin-left: 1%">Procenat CTGa sa izabranim rezultatom je <b>{{statusReport.percentage}}</b></h4>
            </div>
    </FormRow>
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
import { statuses } from '../../constants.js';

export default {
   components: {
       Form,
       FormRow,
       MultiSelectOptionInput,
       Button
    },

    data: function() {
        return {
            selectedStatus: [],
            statuses: null
        }
    },

    computed: {
        ...mapGetters({
            result: 'report/getResult',
            statusReport: "report/getStatusReport"
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
        ...mapActions({generateStatusReport: 'report/generateStatusReport'}),

        handleGenerateReport() {

            this.generateStatusReport(this.selectedStatus[0]);
        }
    },

    mounted()
    {
        this.statuses = statuses;
    },
}

</script>

