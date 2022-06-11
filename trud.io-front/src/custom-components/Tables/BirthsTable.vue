<template>
  <div>
    <Table v-if="pregnancies !== null ">
      <TableHead :columnNames="['Ime i prezime pacijenta', 'Jmbg', 'Datum i vreme porođaja','']"></TableHead>
      <TableBody>
        <TableRow
          v-for="(pregnancy, i) in pregnancies"
          :key="i"
          :values="[pregnancy.patient.name + ' '+ pregnancy.patient.lastName, pregnancy.patient.jmbg, formatDateTime(pregnancy.birth.birthDateTime)]">
            <div class="pull-right text-gray">
            <DropDownMenu>
            <ModalOpener :modalBoxId="'displayBirthModal'">
                <DropDownItem @click="selectedPregnancy = pregnancy">Više detalja</DropDownItem>
            </ModalOpener>
            </DropDownMenu>
          </div>
        
        </TableRow>
      </TableBody>
    </Table>
    <Modal v-if="selectedPregnancy !== null" modalBoxId="displayBirthModal" title="Porođaj" :sizeClass="'modal-sg'">
      <div slot="body">
         <ViewBirthForm :birth="selectedPregnancy.birth"/>
      </div>
    </Modal>
  </div>
</template>

<script>
import Table from "../../generic-components/Table/Table.vue";
import TableHead from "../../generic-components/Table/TableHead.vue";
import TableBody from "../../generic-components/Table/TableBody.vue";
import TableRow from "../../generic-components/Table/TableRow.vue";
import DropDownItem from '../../generic-components/DropdownMenu/DropdownItem.vue'
import DropDownMenu from '../../generic-components/DropdownMenu/DropdownMenu.vue'
import Modal from '../../generic-components/Modal/Modal.vue'
import ModalOpener from '../../generic-components/Modal/ModalOpener.vue'
import ViewBirthForm from '../../custom-components/Forms/ViewBirthForm.vue'
import moment from 'moment'

export default {
  props: {
    pregnancies: {},
  },
  data: () => {
    return {
        selectedPregnancy: null,
    };
  },
  components: {
    Table,
    TableHead,
    TableBody,
    TableRow,
    DropDownItem,
    Modal,
    ModalOpener,
    DropDownMenu,
    ViewBirthForm
  },

  computed: {
  },
  watch: {
  },
  methods: {
       formatDateTime(date) {
            return moment(date).format("DD-MM-YYYY HH:mm");
        },
  },
  mounted() {
     
    }
};
</script>
