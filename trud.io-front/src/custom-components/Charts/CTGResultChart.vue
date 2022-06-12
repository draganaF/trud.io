<template>
  <div id="chart">
    <apexchart
      ref="realtimeChart"
      type="bar"
      :options="chartOptions"
      :series="series">
    </apexchart>
  </div>
</template>

<script>

export default {
  props: {
    seriesData: {
      type: Array,
      default: () => []
    },
  },

  watch: {
    seriesData() {
      this.updateSeriesBars();
    },
  },
  data: () => {
    return {
      series: [{
        data: []
      }],
      chartOptions: {
        chart: {
          type: 'bar'
        },
        xaxis: {
          type: 'category'
        }
      },
    }
  },

  methods: {
    updateSeriesBars() {
      
      this.series[0].data = [...this.seriesData];
      this.$refs.realtimeChart.updateSeries([...this.series],false, true);
    }
  },
  mounted() {
    this.updateSeriesBars();
  }
}
</script>
