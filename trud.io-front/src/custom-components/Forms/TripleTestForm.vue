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
        tripleTest: null,
        update: null,
    },
   components: {
       Form,
       FormRow,
       TextInput,
       Button
    },

    data: function() {
        return {
          updatedTripleTest: {
            id: null,
            afp: null,
            hcg: null,
            ue3: null
          }
        }
    },

    computed: {
        ...mapGetters({result: 'tripleTest/getResult'})
    },

    watch: {
        result({ok, message}) {
            if(ok) {
                toastr.success('Uspešno ste uneli podatke za tripl test.')
            } else {
                toastr.error(message)
            }
             document.getElementById('createTripleTestModal').click();
        }
    },

    methods: {
        ...mapActions({createTripleTest: 'tripleTest/createTripleTest',
                       updateTripleTest: 'tripleTest/updateTripleTest'}),

        handleClick() {
          if(this.update === true){
            this.updatedTripleTest.id = this.tripleTest.id;
            this.updatedTripleTest.afp = this.tripleTest.afp;
            this.updatedTripleTest.hcg = this.tripleTest.hcg;
            this.updatedTripleTest.ue3 = this.tripleTest.ue3;
            this.updateTripleTest({pregnancyId: this.pregnancyId, tripleTest: this.updatedTripleTest});
          }else {
            this.createTripleTest({pregnancyId: this.pregnancyId, tripleTest: this.tripleTest});
          }
          document.getElementById('createTripleTestModal').click();
        }
    }
}

</script>
