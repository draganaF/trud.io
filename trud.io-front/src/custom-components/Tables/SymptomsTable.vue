<template>
  <div>
    <Table>
      <TableHead
        :columnNames="['','']"
      ></TableHead>
      <TableBody>
        <TableRow
          v-for="symptom in symptoms"
          :key="symptom.value"
          :values="[patientSymptoms.find(s => s.value === symptom).label]"
        >
          <div class="pull-right text-gray">
            <DropDownMenu>
                <DropDownItem @click="onDelete(symptom)">Obriši</DropDownItem>
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
import DropDownMenu from "../../generic-components/DropdownMenu/DropdownMenu.vue";
import DropDownItem from "../../generic-components/DropdownMenu/DropdownItem.vue";
import {patientSymptoms} from '../../constants.js'
export default {
  props: {
      symptoms: {},
  },
  data: () => {
    return {
      patientSymptoms: patientSymptoms,
    };
  },

  mounted() {console.log(this.symptoms);},

  components: {
    Table,
    TableHead,
    TableBody,
    TableRow,
    DropDownItem,
    DropDownMenu
  },

  watch: {
    
  },

computed: {
  
  },
  methods: {
   
    onDelete(symptom) {
      console.log(symptom);
     this.symptoms.find(s => s.value)
    },
  },
};
</script>
