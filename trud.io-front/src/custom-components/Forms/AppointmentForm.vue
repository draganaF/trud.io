<template>
    <Form>
        <form-row v-if="appointment">
            <div class="col-4">
                <label style="font-size: 18px; margin-right: 3%;">Ime: </label>
                <label style="font-size: 18px;"><b>{{appointment.patientName}}</b></label>
            </div>
            <div class="col-4">
                <label style="font-size: 18px; margin-right: 3%;">Prezime: </label>
                <label style="font-size: 18px;"><b>{{appointment.patientLastName}}</b></label>
            </div>
            <div class="col-4">
                <label style="font-size: 18px; margin-right: 3%;">JMBG: </label>
                <label style="font-size: 18px;"><b>{{appointment.patientJmbg}}</b></label>
            </div>
        </form-row>

        <form-row>
            <div class="col-12">
                <br>
            </div>
        </form-row>

        <form-row v-if="!isSaved">
            <div class="col-4">
                <text-input 
                    label="Gornji pritisak"
                    v-model="appointmentForUpdate.bloodPressureUpper"
                    type="number"
                />
            </div>
            <div class="col-4">
                <text-input 
                    label="Donji pritisak"
                    v-model="appointmentForUpdate.bloodPressureLower"
                    type="number"
                />
            </div>
            <div class="col-4">
                <text-input 
                    label="Težina"
                    v-model="appointmentForUpdate.weight"
                    type="number"
                />
            </div>
        </form-row>

        <form-row v-if="!isSaved">
            <div class="col-12">
                <text-input 
                    label="Izveštaj"
                    v-model="appointmentForUpdate.report"
                    type="text"
                />
            </div>
        </form-row>

        <form-row v-if="!isSaved">
            <div class="col-12">
                <MultiSelectOptionInput 
                        label="Dodajte simptome"
                        v-model="appointmentForUpdate.symptoms"
                        :options="symptoms"
                ></MultiSelectOptionInput>
            </div>
        </form-row>

        <form-row v-if="!isSaved">
            <div class="col-6">
                <text-input 
                    label="Naziv nove bolesti"
                    v-model="illnessName"
                    type="text"
                />
            </div>
            <div class="col-6">
                <Button style="margin-top:4%" @click="handleAddNewIllness">Dodaj</Button>
            </div>
        </form-row>

        <form-row v-if="!isSaved">
            <div class="col-12">
                <Table>
                    <TableHead
                        :columnNames="['Bolest','']"
                    ></TableHead>
                    <TableBody>
                        <TableRow
                        v-for="illness in appointmentForUpdate.illnesseesNames"
                        :key="illness"
                        :values="[illness]"
                        >
                        <div class="pull-right text-gray">
                            <Button @click="onDeleteIllness(illness)">Izbriši</Button>
                        </div>
                        </TableRow>
                    </TableBody>
                </Table>
            </div>
        </form-row>

        <Button v-if="!isSaved" @click="handleSaveClick">Sačuvaj</Button>
        <div v-if="!isCreated && isSaved">
            <Button @click="handleNewAppointmentClick">Zakaži novi pregled</Button>
            <h5 style="margin: 2%"><b>Terapije prepisane pacijentkinji</b></h5>
            <TherapiesTable :therapies="appointment.therapies" />
            <h5 style="margin: 2%"><b>Bolesti dijagnostikovane pacijentkinji</b></h5>
            <IllnessesTable :illnesses="appointment.illnesses" />
            <div class="col-4" v-if="appointment.isHihgRiskPregnancy">
                <label style="font-size: 18px; margin-right: 3%;"><b>Trudnoća je visokorizična</b></label>
            </div>
            <div class="col-4" v-if="appointment.isPermatureLabor">
                <label style="font-size: 18px; margin-right: 3%;"><b>Mže doći do prevremenog porođaja</b></label>
            </div>
        </div>
    </Form>
</template>

<script>

import Button from '../../generic-components/Form/Button.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import MultiSelectOptionInput from '../../generic-components/Form/MultiSelectOptionInput.vue'
import Table from "../../generic-components/Table/Table.vue";
import TableHead from "../../generic-components/Table/TableHead.vue";
import TableBody from "../../generic-components/Table/TableBody.vue";
import TableRow from "../../generic-components/Table/TableRow.vue";
import TherapiesTable from "../Tables/TherapiesTable.vue"
import IllnessesTable from "../Tables/IllnessesTable.vue"
import toastr from 'toastr'
import { mapActions, mapGetters } from 'vuex'
import { doctorSymptoms } from '../../constants.js';

export default {
   components: {
       Form,
       FormRow,
       TextInput,
       Button,
       MultiSelectOptionInput,
       Table,
       TableHead,
       TableBody,
       TableRow,
       TherapiesTable,
       IllnessesTable
    },

    data: function() {
        return {
            appointment: null,
            appointmentForUpdate: {
                bloodPressureUpper: 0,
                bloodPressureLower: 0,
                weight: 0,
                report: "",
                symptoms: [],
                illnesseesNames: []
            },
            symptoms: null,
            isSaved: false,
            isCreated: false,
            illnessName: null
        }
    },

    computed: {
        ...mapGetters({
            result: 'appointments/getResult',
            getAppointment: 'appointments/getAppointment'
        })
    },

    watch: {
        result({label, ok, message}) {
            if(label === 'update') {
                if(ok) {
                    this.isSaved = true;
                    toastr.success(message);
                }
                else {
                    toastr.error(message);
                }
            }
            if(label === 'create') {
                if(ok) {
                    this.isCreated = true;
                    toastr.success(message);
                    this.$router.push("/appointments/not-processed");
                }
                else {
                    toastr.error(message);
                }
            }
        },
        getAppointment(appointment) {
            this.appointment = appointment;
        }
    },

    methods: {
        ...mapActions({
            fetchAppointment: 'appointments/fetchAppointmentById',
            updateAppointment: 'appointments/updateAppointment',
            createAppointment: 'appointments/createAppointment'
            }),

        handleSaveClick() {
            this.updateAppointment({
                "appointmentForUpdate": this.appointmentForUpdate,
                "id": this.appointment.id
            })
            
        },

        handleNewAppointmentClick() {
            this.createAppointment(this.appointment.pregnancyId);
        },

        handleAddNewIllness() {
            this.appointmentForUpdate.illnesseesNames.push(this.illnessName);
            this.illnessName = null;
        },

        onDeleteIllness(illness) {
            this.appointmentForUpdate.illnesseesNames = this.appointmentForUpdate.illnesseesNames.filter(name => name !== illness);
        }
    },
    
    mounted() {
        this.fetchAppointment(this.$route.params.id);
        this.symptoms = doctorSymptoms;
        this.symptoms.splice(0, 0, {
            value: -1,
            label: ''
        })
        this.symptoms.splice(0, 0, {
            value: -1,
            label: ''
        })
    }
}

</script>
