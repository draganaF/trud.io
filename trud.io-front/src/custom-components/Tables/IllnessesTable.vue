<template>
  <div>
    <Table>
      <TableHead
        :columnNames="['Naziv bolesti']"
        ></TableHead>
        <TableBody>
            <TableRow
            v-for="(illness, index) in illnesses"
            :key="index"
            :values="[illness.name]"
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
      illnesses: null
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
