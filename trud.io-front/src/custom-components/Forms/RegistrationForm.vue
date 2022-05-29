<template>
  <Form>
    <form-row>
      <div class="col-12">
        <text-input
          label="Ime"
          v-model="name"
          type="text"
        />
      </div>
      <div class="col-12">
        <text-input
          label="Prezime"
          v-model="lastName"
          type="text"
        />
      </div>
      <div>
        <date-time-picker 
          label="Datum rođenja"
          v-model="dateOfBirth"
          />
      </div>
    </form-row>
    <form-row>
      <div class="col-12">
        <text-input
          label="Broj telefona"
          v-model="phoneNumber"
          type="text"
        />
      </div>
      <div class="col-12">
        <text-input
          label="JMBG"
          v-model="jmbg"
          type="text"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-12">
        <text-input
          label="Visina"
          v-model="height"
          type="number"
        />
      </div>
      <div class="col-12">
        <text-input
          label="Težina"
          v-model="weight"
          type="number"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-12">
        <text-input 
          label="Email"
          v-model="username"
          type="text"
        />
      </div>
      <div class="col-12">
        <text-input
          label="Lozinka"
          v-model="password"
          type="text"
        />
      </div>
    </form-row>
    <form-row>
      <div class="col-12">
        <text-input
          label="Molimo da unesete broj spontanih ukoliko ste ih imali"
          v-model="numberOfMisscarriage"
          type="number"
        />
      </div>
    </form-row>
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
   components: {
       Form,
       FormRow,
       TextInput,
       Button
    },

    data: function() {
        return {
            username: '',
            password: '',
            name: '',
            lastName: '',
            phoneNumber: '',
            jmbg: '',
            dateOfBirth: '',
            numberOfMisscarriage: 0,
            weight: 0,
            height: 0,
        }
    }
}
</script>
