<template>
  <Form>
    <form-row>
      <div class="col-12">
        <text-input
          label="Cut off vrednost trizomije 21"
          v-model="templateTestRule.cutOffT21"
          type="number"
        />
      </div>
      <div class="col-12">
        <text-input
          label="Cut off vrednost trizomije 18"
          v-model="templateTestRule.cutOffT18"
          type="number"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-12">
        <text-input
          label="Cut off vrednost trizomije 13"
          v-model="templateTestRule.cutOffT13"
          type="number"
        />
      </div>
    </form-row>
     <Button @click="handleClick">Dodaj</Button>
  </Form>
</template>

<script>
import Button from '../../generic-components/Form/Button.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import {mapActions, mapGetters} from 'vuex';
import toastr from 'toastr';

export default {
   components: {
       Form,
       FormRow,
       TextInput,
       Button
    },

    data: function() {
        return {
          templateTestRule: {
            cutOffT21: null,
            cutOffT18: null,
            cutOffT13: null,
            signT21: ">",
            signT18: ">",
            signT13: ">",
            result: "Screen negative",
            statusDouble: "",
            statusTriple: "",
            statusQuadriple:""
          }
        }
    },

    computed: {
        ...mapGetters({result: 'templateTestRule/getResult'})
    },

    watch: {
        result({ok, message, label}) {
            if(label !== 'create'){
                return;
            }

            if(ok) {
                toastr.success('Uspešno ste uneli cut off vrednosti za trizomije.')
            } else {
                toastr.error(message)
            }
        }
    },

    methods: {
        ...mapActions({createTemplateTestRule: 'templateTestRule/createTemplateTestRule'}),

        handleClick() {
            this.createTemplateTestRule(this.templateTestRule);

        }
    }
}
</script>