<template>
  <div>
    <Table v-if="pregnancies !== null ">
      <TableHead :columnNames="['Ime i prezime pacijenta', 'Jmbg', 'Početak trudnoće','']"></TableHead>
      <TableBody>
        <TableRow
          v-for="(pregnancy, i) in pregnancies"
          :key="i"
          :values="[pregnancy.patient.name + ' ' + pregnancy.patient.lastName, pregnancy.patient.jmbg, formatDate(pregnancy.startDate)]">
        <div class="pull-right text-gray">
            <DropDownMenu>
                <DropDownItem @click="moreDetails(pregnancy)">Više detalja</DropDownItem>
            </DropDownMenu>
          </div>
        
        </TableRow>
      </TableBody>
    </Table>
  </div>
</template>

<script>
import Table from "../../generic-components/Table/Table.vue";
import TableHead from "../../generic-components/Table/TableHead.vue";
import TableBody from "../../generic-components/Table/TableBody.vue";
import TableRow from "../../generic-components/Table/TableRow.vue";
import DropDownMenu from '../../generic-components/DropdownMenu/DropdownMenu.vue'
import DropDownItem from '../../generic-components/DropdownMenu/DropdownItem.vue'
import moment from 'moment'

export default {
  props: {
    pregnancies: {},
  },
  data: () => {
    return {
    };
  },
  components: {
    Table,
    TableHead,
    TableBody,
    TableRow,
    DropDownMenu,
    DropDownItem
  },

  computed: {
  },

  watch: {
  },

  methods: {
    moreDetails(pregnancy){
      this.$router.push(`/pregnancy/${pregnancy.id}`);  
    },
    formatDate(date) {
      return moment(date).format("DD.MM.YYYY");
    }
  },

  mounted() {
     
  }
};
</script>
