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
        quadripleTest: null
    },
   components: {
       Form,
       FormRow,
       TextInput,
       Button
    },

    data: function() {
        return {
        }
    },

    computed: {
        ...mapGetters({result: 'quadripleTest/getResult'})
    },

    watch: {
        result({ok, message}) {
            if(ok) {
                toastr.success('Uspešno ste uneli podatke za kvadripl test.')
            } else {
                toastr.error(message)
            }
             document.getElementById('createQuadripleTestModal').click();
        }
    },

    methods: {
        ...mapActions({createQuadripleTest: 'quadripleTest/createQuadripleTest'}),

        handleClick() {
            this.createQuadripleTest({pregnancyId: this.pregnancyId,quadripleTest: this.quadripleTest});
            document.getElementById('createQuadripleTestModal').click();
        }
    }
}

</script>
