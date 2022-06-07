<template>
  <Form>
    <form-row>
      <div class="col-12">
        <text-input
          label="Crl (mm)"
          v-model="doubleTest.crl"
          type="number"
        />
      </div>
      <div class="col-12">
        <text-input
          label="Nuhalna transluenca (mm)"
          v-model="doubleTest.nt"
          type="number"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-12">
       <SelectOptionInput class="col-6" label="Prisustvo nosne kosti" :showLabel="true" :options="nasalBoneOptions" v-model="doubleTest.nasalBone"/>
      </div>
      <div class="col-12">
        <text-input
          label="Free beta HCG (IU/ml)"
          v-model="doubleTest.freeBetaHCG"
          type="number"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-12">
        <text-input
          label="Pappa (IU/ml)"
          v-model="doubleTest.pappa"
          type="number"
        />
      </div>
    </form-row>
     <Button @click="handleClick">Dodajte parametre dabl testa</Button>
  </Form>
</template>

<script>

import Button from '../../generic-components/Form/Button.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import SelectOptionInput from '../../generic-components/Form/SelectOptionInput.vue'
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
       Button,
       SelectOptionInput
    },

    data: function() {
        return {
            doubleTest: {
                crl: null,
                nt: null,
                nasalBone: null,
                freeBetaHCG: null,
                pappa: null,
                result: 'Not yet processed'
            },
            nasalBoneOptions: [
                    {
                        label: 'PRISUTNA',
                        value: true,
                    },
                    {
                        label: 'NIJE PRISUTNA',
                        value: false,
                    },
                ],
        }
    },

    computed: {
        ...mapGetters({result: 'doubleTest/getResult'})
    },

    watch: {
        result({ok, message, label}) {
            if(label !== 'create') 
                return;

            if(ok) {
                toastr.success('Uspešno ste uneli podatke za dabl test.')
            } else {
                toastr.error(message)
            }
        }
    },

    methods: {
        ...mapActions({createDoubleTest: 'doubleTest/createDoubleTest'}),

        handleClick() {
            this.createDoubleTest({pregnancyId: this.pregnancyId,doubleTest: this.doubleTest});
        }
    }
}

</script>
