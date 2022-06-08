<template>
  <Form>
    <form-row>
      <div class="col-12">
        <text-input
          label="HCG (IU/ml)"
          v-model="tripleTest.hcg"
          type="number"
        />
      </div>
      <div class="col-12">
        <text-input
          label="AFP (IU/ml)"
          v-model="tripleTest.afp"
          type="number"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-12">
        <text-input
          label="Ue3 (nmol/l)"
          v-model="tripleTest.ue3"
          type="number"
        />
      </div>
    </form-row>
     <Button @click="handleClick">Dodajte parametre triple testa</Button>
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
            tripleTest: {
                hcg: null,
                afp: null,
                ue3: null,
                result: 'Not yet processed'
            },
        }
    },

    computed: {
        ...mapGetters({result: 'tripleTest/getResult'})
    },

    watch: {
        result({ok, message, label}) {
            if(label !== 'create') 
                return;

            if(ok) {
                toastr.success('Uspešno ste uneli podatke za tripl test.')
            } else {
                toastr.error(message)
            }
        }
    },

    methods: {
        ...mapActions({createTripleTest: 'tripleTest/createTripleTest'}),

        handleClick() {
            this.createTripleTest({pregnancyId: this.pregnancyId,tripleTest: this.tripleTest});
        }
    }
}

</script>
