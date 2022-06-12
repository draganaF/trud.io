<template>
  <div>
    <Table>
      <TableHead
        :columnNames="['Datum i vreme pregleda','JMBG pacijenta', 'Ime pacijenta', 'Prezime pacijenta', '']"
      ></TableHead>
      <TableBody>
        <TableRow
          v-for="appointment in appointments"
          :key="appointment.id"
          :values="[formatDate(appointment.date), appointment.patientJmbg, appointment.patientName, appointment.patientLastName]"
        >
          <div class="pull-right text-gray">
            <DropDownMenu>
                <DropDownItem @click="updateAppointment(appointment)">Popuni</DropDownItem>
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
import { mapGetters } from 'vuex'
import moment from 'moment'

export default {
  props: {
  },
  data: () => {
    return {
      appointments: []
    };
  },

  components: {
    Table,
    TableHead,
    TableBody,
    TableRow,
    DropDownItem,
    DropDownMenu
  },

  watch: {
      getAppointments(allAppointments) {
          this.appointments = allAppointments;
      }
  },

  computed: {
        ...mapGetters({
            result: 'appointments/getResult',
            getAppointments: "appointments/getAppointments"
        })
    },

  methods: {
   
    updateAppointment(appointment) {
        this.$router.push("/appointment/" + appointment.id);
    },
    formatDate(date) {
      return moment(date).format("DD.MM.YYYY HH:ss");
    }
  },

  mounted() {
  }
};
</script>
