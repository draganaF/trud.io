<template>
  <Form>
    <form-row>
      <div class="col-12">
        <text-input
          label="Težina bebe (kg)"
          v-model="birth.weight"
          type="number"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-12">
       <SelectOptionInput  label="Komplikacije prilikom porađanja" :showLabel="true" :options="options" v-model="birth.complications"/>
      </div>
    </form-row>
    <form-row>
        <div class="col-12">
         <SelectOptionInput label="Carski rez" :showLabel="true" :options="options" v-model="birth.cSection"/>
      </div>
    </form-row>
    <form-row>
        <div class="col-12">
         <SelectOptionInput 
                        label="Poremećaj"
                        v-model="birth.chromosomalDisorder"
                        :options="disorders"
        ></SelectOptionInput>
      </div>
    </form-row>
    <form-row>
        <div class="col-12">
         <SelectOptionInput 
                        label="Pobačaj"
                        v-model="birth.miscarriage"
                        :options="options"
        ></SelectOptionInput>
      </div>
    </form-row>
     <Button @click="handleClick">Dodajte informacije o porođaju</Button>
  </Form>
</template>

<script>
import Button from '../../generic-components/Form/Button.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import SelectOptionInput from '../../generic-components/Form/SelectOptionInput.vue'
import {chromosomalDisorders} from '../../constants.js'
import toastr from 'toastr'
import { mapActions, mapGetters } from 'vuex'
export default {
     props: {
        pregnancy: null,
        birth:null,
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
            options: [
                    {
                        label: 'DA',
                        value: true,
                    },
                    {
                        label: 'NE',
                        value: false,
                    },
                ],
            disorders: null
        }
    },
    computed: {
        ...mapGetters({result: 'birth/getResult'})
    },

    watch: {
        result({ok, message}) {
            if(ok) {
                toastr.success('Uspešno ste uneli podatke za porođaj.')
            } else {
                toastr.error(message)
            }
             document.getElementById('createBirthModal').click();
        }
    },

    methods: {
        ...mapActions({createBirth: 'birth/createBirth'}),

        handleClick() {
            this.birth.pregnancyId = this.pregnancy.id;
            this.birth.gestationalAge = this.pregnancy.week;
            this.createBirth(this.birth);
            document.getElementById('createBirthModal').click();
        }
    },
    mounted(){
        this.disorders = chromosomalDisorders;
    }
}
</script>