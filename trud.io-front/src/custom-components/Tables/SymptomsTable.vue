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
import {patientSymptoms} from '../../constants.js'
export default {
  props: {
      symptoms: {},
  },
  data: () => {
    return {
      patientSymptoms: patientSymptoms
    };
  },

  mounted() {},

  components: {
    Table,
    TableHead,
    TableBody,
    TableRow,
  },

  watch: {
  },

computed: {
  
  },
  methods: {
   
    onDelete(symptom) {
        this.symptoms.filter(s => s !== symptom);
    },
  },
};
</script>
