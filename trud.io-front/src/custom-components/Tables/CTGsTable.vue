<template>
  <Table>
    <TableHead :columnNames="['Id', 'Broj otkucaja', 'Status','Varijabilnost', 'Status', 'Broj kontrakcija', 'Rezultat']"></TableHead>
    <TableBody>
      <TableRow
      v-for="c in ctgs"
      :key="c.id"
      :values="[c.id, c.fetalHartRate, formatResults(c.fhrStatus), c.varibilty, formatResults(c.variabiltyStatus), c.contractions, formatResults(c.result)]"
      >

      </TableRow>
    </TableBody>
  </Table>
</template>

<script>
import { mapGetters } from "vuex";
import Table from '../../generic-components/Table/Table.vue'
import TableHead from '../../generic-components/Table/TableHead.vue'
import TableBody from '../../generic-components/Table/TableBody.vue'
import TableRow from '../../generic-components/Table/TableRow.vue'

export default{
  components: {
    Table,
    TableHead,
    TableBody,
    TableRow
  },
  props: {
    ctgs: {}
  },

  computed: {
    ...mapGetters({result: 'ogtt/getResult'})
  },

  methods: {
    formatResults(result) {
      if(result == "REASSURING") {
        return "Normalno";
      }
      else if(result == "NON_REASSURING") {
        return "Sumnjivo";
      }
      return "Abnormalno";
    }
  }
}
</script>
