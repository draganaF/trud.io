<template>
  <div>
    <Table v-if="patients !== null ">
      <TableHead :columnNames="['Ime i prezime pacijenta', 'Jmbg', 'Email adresa','Datum rođenja', '']"></TableHead>
      <TableBody>
        <TableRow
          v-for="(patient, i) in patients"
          :key="i"
          :values="[patient.name + ' ' + patient.lastName, patient.jmbg, patient.emailAddress, formatDateTime(patient.dateOfBirth)]">
        <div class="pull-right text-gray">
            <DropDownMenu>
                <ModalOpener :modalBoxId="'displayPatientModal'">
                    <DropDownItem @click="selectedPatient = patient">Više detalja</DropDownItem>
                </ModalOpener>
            </DropDownMenu>
          </div>
        
        </TableRow>
      </TableBody>
    </Table>
    <Modal modalBoxId="displayPatientModal" title="Osnovni podaci" :sizeClass="'modal-sg'">
            <div slot="body">
                <Form v-if="selectedPatient !== null">
                    <form-row>
                        <div class="col-6">
                            <text-input 
                                label="Visina"
                                v-model="selectedPatient.height"
                                type="number"
                                :disabled="true"/>
                        </div>
                         <div class="col-6">
                            <text-input 
                                label="Težina"
                                v-model="selectedPatient.weight"
                                type="number"
                                :disabled="true"/>
                        </div>
                    </form-row>
                    <form-row>
                       <div class="col-6">
                            <text-input
                                label="Alkoholičar"
                                :value="checkIfIs(selectedPatient.isAlcoholic)"
                                type="text"
                                :disabled="true"/>
                        </div>
                        <div class="col-6">
                            <text-input
                                label="Zavisnik"
                                :value="checkIfIs(selectedPatient.isAddict)"
                                type="text"
                                :disabled="true"/>
                        </div>
                    </form-row>
                    <form-row>
                        <div class="col-6">
                            <text-input
                                label="Pušač"
                                :value="checkIfIs(selectedPatient.isSmoker)"
                                type="text"
                                :disabled="true"/>
                        </div>
                        <div class="col-6">
                            <text-input
                                label="Genetske anomalije u porodici"
                                :value="checkIfIs(selectedPatient.isGeneticAnomalies)"
                                type="text"
                                :disabled="true"/>
                        </div>
                    </form-row>
                </Form>
            </div>
        </Modal>
  </div>
</template>

<script>
import Table from "../../generic-components/Table/Table.vue";
import TableHead from "../../generic-components/Table/TableHead.vue";
import TableBody from "../../generic-components/Table/TableBody.vue";
import TableRow from "../../generic-components/Table/TableRow.vue";
import DropDownMenu from '../../generic-components/DropdownMenu/DropdownMenu.vue'
import DropDownItem from '../../generic-components/DropdownMenu/DropdownItem.vue'
import Modal from '../../generic-components/Modal/Modal.vue'
import ModalOpener from '../../generic-components/Modal/ModalOpener.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import moment from 'moment'
export default {
  props: {
    patients: {},
  },
  data: () => {
    return {
        selectedPatient: null
    };
  },
  components: {
    Table,
    TableHead,
    TableBody,
    TableRow,
    DropDownMenu,
    DropDownItem,
    Modal,
    ModalOpener,
    Form,
    FormRow,
    TextInput,
  },

  computed: {
  },

  watch: {
  },

  methods: {
       formatDateTime(date) {
            return moment(date).format("DD.MM.YYYY");
        },

        checkIfIs(check){
            if(check == true){
                return "DA";
            }else{
                return "NE";
            }
        }
  },

  mounted() {
     
  }
};
</script>
