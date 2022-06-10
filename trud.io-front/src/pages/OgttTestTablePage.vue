<template>
  <div class="content">
    <div class="container-fluid">
      <Card title="Ogtt Tests">
        <OgttTable :ogtts="ogtts"></OgttTable>
      </Card>

    </div>
  </div>
</template>

<script>
  
import { mapGetters, mapActions } from 'vuex'
import Card from '../generic-components/Card/Card.vue'
import OgttTable from '../custom-components/Tables/OgttTable.vue'
import {getRole} from '../utils/userInfo.js'

export default {
  components: {
    Card, 
    OgttTable
  },
  computed: {
    ...mapGetters({
      ogtts: 'ogtt/getOgttTests'
    })
  },
  methods: {
    ...mapActions({
      fetchDoctorsOgtts: 'ogtt/doctorsOgtt',
      fetchPatientOgtts: 'ogtt/patientOgtt'
    })
  },
  //Zakucana trudnoca dok ne skontam kako da je ubacim u localstorage 
  mounted() {
    if(getRole() == "PATIENT") {
      this.fetchPatientOgtts(1);
    }
    else {
      this.fetchDoctorsOgtts();
    }
    console.log(this.ogtts)
  }


}
</script>