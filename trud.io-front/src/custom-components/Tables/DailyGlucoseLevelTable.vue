<template>
  <div>
    <Card :title="'Dnevna merenja glukoze'"> 
      <Table>
        <TableHead :columnNames="['Id','Datum', 'Preprandial', 'Prvi postprandial', 'Drugi postprandial']">
        </TableHead>
        <TableBody>
          <TableRow v-for="l in levels"
            :key="l.id"
            :values="[l.id, formatDate(l.date), l.preprandial, l.firstPostprandial, l.secondPostprandial]">

          </TableRow>
        </TableBody>
      </Table>
    </Card>
  </div>
</template>

<script>
import { mapGetters} from 'vuex'
import Table from '../../generic-components/Table/Table.vue'
import TableHead from '../../generic-components/Table/TableHead.vue'
import TableBody from '../../generic-components/Table/TableBody.vue'
import TableRow from '../../generic-components/Table/TableRow.vue'
import Card from '../../generic-components/Card/Card.vue'
import moment from 'moment'
export default{
  components: {
    Table,
    TableBody,
    TableHead,
    TableRow,
    Card
  },
  props: {
    levels: {}
  },
  mounted() {
    console.log(this.levels);
  },
  computed: {
    ...mapGetters({result: 'glucoseLevels/getResult'})
  },

  methods: {

    formatDate(date) {
      return moment(date).format("DD.MM.YYYY HH:mm");
    }
  }
}
</script>
