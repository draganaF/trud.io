<template>
  <Form>
    <form-row>
      <div class="col-6">
        <text-input
          label="Datum i vreme porođaja"
          :value="formatDateTime(birth.birthDateTime)"
          type="text"
          :disabled="true"
        />
      </div>
       <div class="col-6">
       <text-input
          label="Nedelja trudnoće"
          :value="birth.gestationalAge"
          type="text"
          :disabled="true"
        />
      </div>
    </form-row>
    <form-row>
        <div class="col-6">
        <text-input
          label="Težina bebe (kg)"
          v-model="birth.weight"
          type="number"
          :disabled="true"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-6">
         <text-input
          label="Komplikacije"
          :value="checkIf(birth.complications)"
          type="text"
          :disabled="true"
        />
      </div>
      <div class="col-6">
         <text-input
          label="Carski rez"
          :value="checkIf(birth.cSection)"
          type="text"
          :disabled="true"
        />
         
      </div>
    </form-row>
    <form-row>
        <div class="col-6">
          <text-input
          label="Pobačaj"
          :value="checkIf(birth.miscarriage)"
          type="text"
          :disabled="true"
        />
      </div>
      <div class="col-6">
         <text-input
          label="Abortus"
          :value="checkIf(birth.abortion)"
          type="text"
          :disabled="true"
        />
         
      </div>
    </form-row>
    <form-row>
        <div class="col-12">
         <text-input
          label="Poremećaj"
          :value="disorder(birth.chromosomalDisorder)"
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
import moment from 'moment'

export default {
     props: {
        birth:null,
    },
   components: {
       Form,
       FormRow,
       TextInput,
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
        checkIf(value){
            if(value === true){
                return "Da";
            }else{
                return "Ne";
            }
        },
        disorder(chromosomalDisorder){
            if(chromosomalDisorder === 'NO_DISORDER'){
                return "Bez poremećaja";
            }else if(chromosomalDisorder === 'DOWN'){
                return "Daunov sindrom";
            }else if(chromosomalDisorder === 'EDWARDS'){
                return "Edvardov sindrom";
            }else if(chromosomalDisorder === 'PATAU'){
                return "Patauov sindrom";
            }
        },

         formatDateTime(date) {
            return moment(date).format("DD-MM-YYYY HH:mm");
        },
       
    },
    mounted(){
       
    }
}
</script>