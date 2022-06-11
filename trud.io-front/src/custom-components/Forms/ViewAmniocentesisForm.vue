<template>
  <Form>
    <form-row>
      <div class="col-12">
        <text-input
          label="AFP (IU/ml)"
          v-model="amniocentesis.afp"
          type="number"
          :disabled="true"
        />
      </div>
    </form-row>
     <form-row>
      <div class="col-6">
        <text-input
          label="Daunov sindrom rizik"
          :value="risk(amniocentesis.trisomy21)"
          type="text"
          :disabled="true"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Rezultat testa za Daunov sindrom"
          :value="result(amniocentesis.resultT21)"
          type="text"
          :disabled="true"
        />
      </div>
    </form-row>

    <form-row>
      <div class="col-6">
        <text-input
          label="Patauov sindrom rizik"
          :value="risk(amniocentesis.trisomy13)"
          type="text"
          :disabled="true"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Rezultat testa za Patauov sindrom"
          :value="result(amniocentesis.resultT13)"
          type="text"
          :disabled="true"
        />
      </div>
    </form-row>

    <form-row>
      <div class="col-6">
        <text-input
          label="Edvardov sindrom rizik"
          :value="risk(amniocentesis.trisomy18)"
          type="text"
          :disabled="true"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Rezultat testa za Edvardov sindrom"
          :value="result(amniocentesis.resultT18)"
          type="text"
          :disabled="true"
        />
      </div>
    </form-row>
     <form-row>
      <div class="col-6">
        <text-input
          label="Nervni defekti"
          :value="defect(amniocentesis.neuralDefects)"
          type="text"
          :disabled="true"
        />
      </div>
    </form-row>
     <form-row>
      <div class="col-6">
         <SelectOptionInput 
            v-if="amniocentesis !== null && checkResult() === true"
            label="Da li želite da nastavite sa trudnoćom?"
            v-model="answer"
            :options="this.options"
            @input="answered()"
          ></SelectOptionInput>
      </div>
    </form-row>

  </Form>
</template>

<script>

import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import SelectOptionInput from '../../generic-components/Form/SelectOptionInput.vue'
import { mapActions } from "vuex";
export default {
     props: {
        pregnancyId: null,
        amniocentesis: null
    },
   components: {
       Form,
       FormRow,
       TextInput,
       SelectOptionInput
    },

    data: function() {
        return {
          answer: "",
          options: [
           {
            value: "DA",
            label: "Da"
            },
            {
            value: "NE",
            label: "Ne"
            },
          ]
        }
    },

    computed: {
    },

    watch: {
       
    },

    methods: {
      ...mapActions({
      abortion: "birth/abortion"
       }),
        risk(r){
            return "1:" + r;
        },

        defect(neuralDefects){
            if(neuralDefects === "High risk"){
                return "Veliki rizik";
            }else{
                return "Mali rizik";
            }
        },

        result(screen){
          if(screen == 'Screen negative'){
            return "Negativan rezultat";
          }else {
            return "Pozitivan rezultat";
          }
        },

        checkResult(){
          // if(this.amniocentesis.resultT13 === 'Screen positive' || this.amniocentesis.resultT21 === 'Screen positive' 
          // || this.amniocentesis.resultT18 === 'Screen positive '){
          //   return true;
          // }
          // return false;
          // }
          return true;
        },

        answered(){
          if(this.answer === 'NE'){
              this.abortion(this.pregnancyId);
              document.getElementById('displayAmniocentesisModal').click();
          }
        }
    
        
        
    },

    mounted(){
    }
}

</script>
