<template>
   <div class="content">
        <div class="container-fluid">
            <CTGResultChart :seriesData="chartData"/>
        </div>
    </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

import CTGResultChart from '../Charts/CTGResultChart.vue'
export default {
  components: {
    CTGResultChart
  },
  computed: {
    ...mapGetters({
      chartData: 'report/getCtgChartResult'
    })
  },
  methods: {
    ...mapActions({
      fetchChartData: 'report/ctgChartReport'
    })
  },
  mounted() {
    this.fetchChartData();
  }
}
</script>