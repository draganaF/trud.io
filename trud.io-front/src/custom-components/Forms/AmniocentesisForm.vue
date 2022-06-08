<template>
  <Form>
    <form-row>
      <div class="col-12">
        <text-input
          label="AFP (IU/ml)"
          v-model="amniocentesis.afp"
          type="number"
        />
      </div>
    </form-row>
     <Button @click="handleClick">Dodajte parametar amnioceneteze</Button>
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
            amniocentesis: {
                afp: null,
                result: 'Not yet processed'
            },
        }
    },

    computed: {
        ...mapGetters({result: 'amniocentesis/getResult'})
    },

    watch: {
        result({ok, message, label}) {
            if(label !== 'create') 
                return;

            if(ok) {
                toastr.success('Uspešno ste uneli podatak za amniocentezu.')
            } else {
                toastr.error(message)
            }
        }
    },

    methods: {
        ...mapActions({createAmniocentesis: 'amniocentesis/createAmniocentesis'}),

        handleClick() {
            this.createAmniocentesis({pregnancyId: this.pregnancyId,amniocentesis: this.amniocentesis});
        }
    }
}

</script>
