<template>
  <Form >
    <form-row>
      <div class="col-6">
        <text-input
           label="HCG (IU/ml)"
          v-model="quadripleTest.hcg"
          type="number"
          :disabled="true"
        />
      </div>
      <div class="col-6">
        <text-input
          label="AFP (IU/ml)"
          v-model="quadripleTest.afp"
          type="number"
          :disabled="true"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-6">
       <text-input
          label="Ue3 (nmol/l)"
          v-model="quadripleTest.ue3"
          type="number"
          :disabled="true"
        />
      </div>

      <div class="col-6">
       <text-input
          label="Inhibin A (pg/ml)"
          v-model="quadripleTest.inhibinA"
          type="number"
          :disabled="true"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-6">
        <text-input
          label="Daunov sindrom rizik"
          :value="risk(quadripleTest.trisomy21)"
          type="text"
          :disabled="true"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Rezultat testa za Daunov sindrom"
          :value="result(quadripleTest.resultT21)"
          type="text"
          :disabled="true"
        />
      </div>
    </form-row>

    <form-row>
      <div class="col-6">
        <text-input
          label="Patauov sindrom rizik"
          :value="risk(quadripleTest.trisomy13)"
          type="text"
          :disabled="true"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Rezultat testa za Patauov sindrom"
          :value="result(quadripleTest.resultT13)"
          type="text"
          :disabled="true"
        />
      </div>
    </form-row>

    <form-row>
      <div class="col-6">
        <text-input
          label="Edvardov sindrom rizik"
          :value="risk(quadripleTest.trisomy18)"
          type="text"
          :disabled="true"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Rezultat testa za Edvardov sindrom"
          :value="result(quadripleTest.resultT18)"
          type="text"
          :disabled="true"
        />
      </div>
    </form-row>
  </Form>
</template>

<script>

import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'

export default {
     props: {
        pregnancyId: null,
        quadripleTest: null
    },
   components: {
       Form,
       FormRow,
       TextInput
    },

    data: function() {
        return {
        }
    },

    computed: {
    },

    watch: {
       
    },

    methods: {

        risk(r){
            return "1:" + r;
        },
         result(screen){
          if(screen == 'Screen negative'){
            return "Negativan rezultat";
          }else {
            return "Pozitivan rezultat";
          }
        }
    }
}

</script>
