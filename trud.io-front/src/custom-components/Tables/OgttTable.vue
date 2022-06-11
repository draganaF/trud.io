<template>
  <Table>
    <TableHead :columnNames="['Id','Datum', 'Rezultat', 'Id trudnoce', '']"></TableHead>
    <TableBody>
      <TableRow
        v-for="o in ogtts"
        :key="o.id"
        :values="[o.id,o.date, formatResult(o.result), o.pregnancyId]">
        <Button :title="'Vidi'" @click="seeTest(o)">Pogledaj</Button>
      </TableRow>
    </TableBody>
  </Table>
</template>

<script>
import { mapGetters} from 'vuex'
import Table from '../../generic-components/Table/Table.vue'
import TableHead from '../../generic-components/Table/TableHead.vue'
import TableBody from '../../generic-components/Table/TableBody.vue'
import TableRow from '../../generic-components/Table/TableRow.vue'
import Button from '../../generic-components/Form/Button.vue'

export default{
  components: {
    Table,
    TableBody,
    TableHead,
    TableRow,
    Button
  },
  props: {
    ogtts: {}
  },

  mounted() {
    console.log(this.ogtts)
  },
  computed: {
    ...mapGetters({result: 'ogtt/getResult'})
  },

  methods: {
    seeTest(o) {
      this.$router.push({ path: '/ogtt', query: { ogtt: o } })
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
  }
}
</script>
