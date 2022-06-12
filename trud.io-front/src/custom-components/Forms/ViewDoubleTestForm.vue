<template>
  <Form v-if="doubleTest !== null">
    <form-row>
      <div class="col-6">
        <text-input
          label="Crl (mm)"
          v-model="doubleTest.crl"
          type="number"
          :disabled="true"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Nuhalna transluenca (mm)"
          v-model="doubleTest.nt"
          type="number"
          :disabled="true"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-6">
        <text-input
        v-if=" doubleTest.nasalBone === true"
          label="Nosna kost"
          value="PRISUTNA"
          type="text"
          :disabled="true"
        />
         <text-input
        v-if="doubleTest.nasalBone === false"
          label="Nosna kost"
          value="NIJE PRISUTNA"
          type="text"
          :disabled="true"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Free beta HCG (IU/ml)"
          v-model="doubleTest.freeBetaHCG"
          type="number"
          :disabled="true"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-6">
        <text-input
          label="Pappa (IU/ml)"
          v-model="doubleTest.pappa"
          type="number"
          :disabled="true"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-6">
        <text-input
          label="Daunov sindrom rizik"
          :value="risk(doubleTest.trisomy21)"
          type="text"
          :disabled="true"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Rezultat testa za Daunov sindrom"
          :value="result(doubleTest.resultT21)"
          type="text"
          :disabled="true"
        />
      </div>
    </form-row>

    <form-row>
      <div class="col-6">
        <text-input
          label="Patauov sindrom rizik"
          :value="risk(doubleTest.trisomy13)"
          type="text"
          :disabled="true"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Rezultat testa za Patauov sindrom"
          :value="result(doubleTest.resultT13)"
          type="text"
          :disabled="true"
        />
      </div>
    </form-row>

    <form-row>
      <div class="col-6">
        <text-input
          label="Edvardov sindrom rizik"
          :value="risk(doubleTest.trisomy18)"
          type="text"
          :disabled="true"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Rezultat testa za Edvardov sindrom"
          :value="result(doubleTest.resultT18)"
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
        doubleTest: null
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
