<template>
  <Form @submit="onSubmit">
    <form-group>
      <form-row>
        <div class="col-6">
          <text-input
            label="Primarno vađenje krvi: "
            v-model="ogtt.primarySampling"
            type="number"
          />
        </div>
      </form-row>
      <form-row>
        <div class="col-6">
          <label>Rezultat: {{ formatResult(ogtt.result) }}</label>
        </div>
      </form-row>
    </form-group>
    <div class="col-12">
      <Button @click="toggleExtendedOgttForm" v-if="action !== 'Primary' || ogtt.result === 'EXTENDED_OGTT'"
        >Prošireni Ogtt Test</Button
      >
    </div>

    <form-group v-if="extendedOgttForm">
      <form-row>
        <div class="col-3">
          <text-input
            label="Prvo vađenje krvi: "
            v-model="ogtt.firstBloodSampling"
            type="number"
          />
        </div>
        <div class="col-3">
          <text-input
            label="Drugo vađenje krvi: "
            v-model="ogtt.secondBloodSampling"
            type="number"
          />
        </div>
        <div class="col-3">
          <text-input
            label="Treće vađenje krvi: "
            v-model="ogtt.thirdBloodSampling"
            type="number"
          />
        </div>
        <div class="col-3">
          <text-input
            label="Četvrto vađenje krvi: "
            v-model="ogtt.fourthBloodSampling"
            type="number"
          />
        </div>
      </form-row>
    </form-group>
    <div class="col-12">
      <Button type="submit" v-if="action!=='Done'">{{
        action === "Extended" ? "Upiši prošireni ogtt" : "Upiši rezultat"
      }}</Button>
    </div>
  </Form>
</template>

<script>
import Form from "../../generic-components/Form/Form.vue";
import Button from "../../generic-components/Form/Button.vue";
import toastr from "toastr";
import FormGroup from "../../generic-components/Form/FormGroup.vue";
import FormRow from "../../generic-components/Form/FormRow.vue";
import TextInput from "../../generic-components/Form/TextInput.vue";

import { mapActions, mapGetters } from "vuex";

const initialOgtt = {
  primarySampling: 0,
  firstBloodSampling: 0,
  secondBloodSampling: 0,
  thirdBloodSampling: 0,
  fourthBloodSampling: 0,
  result: "NOT_SUBMITTED",
};

export default {
  components: {
    Form,
    Button,
    FormGroup,
    FormRow,
    TextInput,
  },

  props: {
    action: {
      type: String,
      default: "Primary",
    },

    existingOgtt: {
      type: Object,
    },

    pregnancyId: {
      type: Number,
      default: 1,
    },

    ogttId: {
      type: Number,
      default: 1,
    },
  },

  data: () => {
    return {
      ogtt: { ...initialOgtt },
      extendedOgttForm: true,
    };
  },

  computed: {
    ...mapGetters({ result: "ogtt/getResult"}),
  },
  watch: {
    result({ ok, message, ogttObject }) {
      if (ok) {
        toastr.success(message);
        this.ogtt = {...ogttObject};
        if(this.ogtt.result === "EXTENDED_OGTT") {
          this.action = "Extended";
        }
      } else {
        toastr.error(message);
      }
    },

    existingOgtt() {
      this.setAction();
    },
  },
  methods: {
    ...mapActions({
      createOgtt: "ogtt/createOgttTest",
      extendedOgtt: "ogtt/updateOgttTest",
    }),

    toggleExtendedOgttForm() {
      this.extendedOgttForm = !this.extendedOgttForm;
    },

    setAction() {
      if (this.action == "Primary") {
        this.ogtt = { ...initialOgtt };
        return;
      }

      if (this.existingOgtt) {
        this.ogtt = { ...this.existingOgtt };
      }
    },
    formatResult(ogttResult) {
      if(ogttResult == "POSITIVE"){
        return "Pozitivan"
      }
      else if (ogttResult == "NEGATIVE") {
        return "Negativan"
      }
      else if(ogttResult == "EXTENDED_OGTT") {
        return "Potreban produženi ogtt"
      }
      else {
        return "Predan"
      }
    },
    onSubmit(e) {
      e.preventDefault();
      if (this.action === "Primary") {
        this.ogtt.result = "SUBMITED";
        this.createOgtt({ pregnancyId:this.pregnancyId, id: this.ogttId, ogtt: this.ogtt });
      } else {
        this.extendedOgtt({ pregnancyId:this.pregnancyId, id: this.ogttId, ogtt: this.ogtt });
      }
    },
  },
};
</script>
