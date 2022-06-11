<template>
  <div>
    <Table>
      <TableHead
        :columnNames="['Lek','Uputstvo']"
        ></TableHead>
        <TableBody>
            <TableRow
            v-for="(therapy, index) in therapies"
            :key="index"
            :values="[therapy.medicine, therapy.report]"
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

export default {
  props: {
      therapies: null
  },
  data: () => {
    return {
      
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
  },
};
</script>
