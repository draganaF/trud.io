<template>
  <div class="content">
    <div class="container-fluid">
      <Card title="Pregled CTGa">
        <CTGsTable :ctgs="ctgs"></CTGsTable>
      </Card>

    </div>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
import Card from '../generic-components/Card/Card.vue'
import CTGsTable from '../custom-components/Tables/CTGsTable.vue'
import {getRole, getPregnancyId} from '../utils/userInfo.js'

export default {
  components: {
    Card,
    CTGsTable
  },
  computed: {
    ...mapGetters({
        ctgs: 'ctg/getCTGs'
    })
  },
  methods: {
    ...mapActions({
      fetchCtgs: 'ctg/allCTGs',
      fetchPregnancyCtgs: 'ctg/allPregnanciesCTGs'
    })
  },
  mounted(){
    if(getRole() == "PATIENT") {
      this.fetchPregnancyCtgs(getPregnancyId());
    }
    else {
      this.fetchCtgs();
    }
  }
}

</script>
