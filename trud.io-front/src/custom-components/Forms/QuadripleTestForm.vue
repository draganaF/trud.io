<template>
  <Form>
    <form-row>
      <div class="col-12">
        <text-input
          label="HCG (IU/ml)"
          v-model="quadripleTest.hcg"
          type="number"
        />
      </div>
      <div class="col-12">
        <text-input
          label="AFP (IU/ml)"
          v-model="quadripleTest.afp"
          type="number"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-12">
        <text-input
          label="Ue3 (nmol/l)"
          v-model="quadripleTest.ue3"
          type="number"
        />
      </div>
       <div class="col-12">
        <text-input
          label="Inhibin A (pg/ml)"
          v-model="quadripleTest.inhibinA"
          type="number"
        />
      </div>
    </form-row>
     <Button @click="handleClick">Dodajte parametre kvadripl testa</Button>
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
     props: {
        pregnancyId: null,
    },
   components: {
       Form,
       FormRow,
       TextInput,
       Button
    },

    data: function() {
        return {
            quadripleTest: {
                hcg: null,
                afp: null,
                ue3: null,
                inhibinA:null,
                result: 'Not yet processed'
            },
        }
    },

    computed: {
        ...mapGetters({result: 'quadripleTest/getResult'})
    },

    watch: {
        result({ok, message, label}) {
            if(label !== 'create') 
                return;

            if(ok) {
                toastr.success('Uspešno ste uneli podatke za kvadripl test.')
            } else {
                toastr.error(message)
            }
        }
    },

    methods: {
        ...mapActions({createQuadripleTest: 'quadripleTest/createQuadripleTest'}),

        handleClick() {
            this.createQuadripleTest({pregnancyId: this.pregnancyId,quadripleTest: this.quadripleTest});
        }
    }
}

</script>
