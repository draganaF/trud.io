<template>
  <Form>
    <form-row>
      <div class="col-6">
        <text-input
          label="Ime"
          v-model="patient.name"
          type="text"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Prezime"
          v-model="patient.lastName"
          type="text"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-6">
        <date-time-picker
          label="Datum rođenja"
          v-model="patient.dateOfBirth"
          type="date"
          />
      </div>
      <div class="col-6">
        <text-input
          label="Broj telefona"
          v-model="patient.phoneNumber"
          type="text"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-12">
        <text-input
          label="JMBG"
          v-model="patient.jmbg"
          type="text"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-6">
        <text-input 
          label="Email"
          v-model="patient.emailAddress"
          type="text"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Lozinka"
          v-model="patient.password"
          type="text"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-6">
        <text-input
          label="Visina"
          v-model="patient.height"
          type="number"
        />
      </div>
      <div class="col-6">
        <text-input
          label="Težina"
          v-model="patient.weight"
          type="number"
        />
      </div>
    </form-row>
    
    <form-row>
      <div class="col-12">
        <text-input
          label="Molimo da unesete broj spontanih ukoliko ste ih imali"
          v-model="patient.numberOfMisscarriage"
          type="number"
        />
      </div>
    </form-row>
    <hr/>
    <form-row>
      <div class="col-10">
        <label>Da li neko u porodici pati od genetskih anomalija ili ste imali problema u prethodnim trudnoćama?</label>
      </div>
      <div>
        <input 
          v-model="patient.geneticAnomalies"
          type="checkbox" id="geneticAnomalies" name="geneticAnomalies"/>
      </div>
    </form-row>
    <form-row>
      <div class="col-5">
        <label>Da li ste pušač?</label>
      </div>
      <div>
        <input 
          v-model="patient.smoker"
          type="checkbox" id="smoker" name="smoker"/>
      </div>
    </form-row>
    <form-row>
      <div class="col-5">
        <label>Da li koristite narkotike?</label>
      </div>
      <div>
        <input 
          v-model="patient.addict"
          type="checkbox" id="addict" name="addict"/>
      </div>
    </form-row>
    <form-row>
      <div class="col-5">
        <label>Da li pijete alkohol?</label>
      </div>
      <div>
        <input 
          v-model="patient.alcoholic"
          type="checkbox" id="alcoholic" name="alcoholic"/>
      </div>
    </form-row>
    <Button @click="handleClickRegisterPatient">Registrujte se</Button>
  </Form>
</template>

<script>
import Button from '../../generic-components/Form/Button.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import DateTimePicker from '../../generic-components/Form/DateTimePicker.vue'

import toastr from 'toastr'
import { mapActions, mapGetters } from 'vuex'

export default {
   components: {
       Form,
       FormRow,
       TextInput,
       Button,
       DateTimePicker,
    },

    data: function() {
        return {
          patient: {
            username: '',
            password: '',
            name: '',
            lastName: '',
            phoneNumber: '',
            emailAddress: '',
            jmbg: '',
            dateOfBirth: '',
            numberOfMisscarriage: 0,
            weight: 0,
            height: 0,
          }
        }
    },
    computed: {
        ...mapGetters({result: 'patient/getResult'})
    },

    watch: {
        result({ok, message, label}) {
            if(label !== 'register') 
                return;

            if(ok) {
                toastr.success("Uspešno ste se registrovali.")
                this.$router.push("/auth")
            } else {
                toastr.error(message)
            }
        }
    },

    methods: {
        ...mapActions({registerPatient: 'patient/registerPatient'}),

        handleClickRegisterPatient() {

            this.registerPatient(this.patient);
        }
    }
}
</script>
