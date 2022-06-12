<template>
    <Form v-if="pregnancy !== null">
        <form-row>
            <div class="col-12">
                <text-input 
                    label="Ime i prezime pacijentkinje"
                    :value="pregnancy.patient.name + ' ' +pregnancy.patient.lastName"
                    type="text"
                    :disabled="true"
                />
            </div>
        </form-row>

        <form-row>
            <div class="col-12">
                <text-input 
                    label="Email adresa"
                    v-model="pregnancy.patient.emailAddress"
                    type="text"
                    :disabled="true"
                />
            </div>
        </form-row>

        <form-row>
            <div class="col-12">
                 <text-input
                    label="JMBG"
                    v-model="pregnancy.patient.jmbg"
                    type="text"
                    :disabled="true"
                />
            </div>
        </form-row>

        <form-row>
            <div class="col-12">
                <text-input 
                    label="Datum rođenja"
                    :value="formatDateTime(pregnancy.patient.dateOfBirth)"
                    type="text"
                    :disabled="true"
                />
            </div>
        </form-row>

    <Button @click="clickMoreDetails">Više detalja</Button>

    <Modal modalBoxId="displayPatientModal" title="Osnovni podaci" :sizeClass="'modal-sg'">
            <div slot="body">
                <Form v-if="pregnancy !== null">
                    <form-row>
                        <div class="col-6">
                            <text-input 
                                label="Visina"
                                v-model="pregnancy.patient.height"
                                type="number"
                                :disabled="true"/>
                        </div>
                         <div class="col-6">
                            <text-input 
                                label="Težina"
                                v-model="pregnancy.patient.weight"
                                type="number"
                                :disabled="true"/>
                        </div>
                    </form-row>
                    <form-row>
                       <div class="col-6">
                            <text-input
                                label="Alkoholičar"
                                :value="checkIfIs(pregnancy.patient.isAlcoholic)"
                                type="text"
                                :disabled="true"/>
                        </div>
                        <div class="col-6">
                            <text-input
                                label="Zavisnik"
                                :value="checkIfIs(pregnancy.patient.isAddict)"
                                type="text"
                                :disabled="true"/>
                        </div>
                    </form-row>
                    <form-row>
                        <div class="col-6">
                            <text-input
                                label="Pušač"
                                :value="checkIfIs(pregnancy.patient.isSmoker)"
                                type="text"
                                :disabled="true"/>
                        </div>
                        <div class="col-6">
                            <text-input
                                label="Genetske anomalije u porodici"
                                :value="checkIfIs(pregnancy.patient.isGeneticAnomalies)"
                                type="text"
                                :disabled="true"/>
                        </div>
                    </form-row>
                </Form>
            </div>
        </Modal>
        <ModalOpener id="displayPatientModalOpener" class="d-none" modalBoxId="displayPatientModal" />
    </Form>

    
</template>

<script>

import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import Modal from '../../generic-components/Modal/Modal.vue'
import ModalOpener from '../../generic-components/Modal/ModalOpener.vue'
import Button from '../../generic-components/Form/Button.vue'
import moment from 'moment'

export default {
    props: {
        pregnancy: null,
    },
   components: {
       Form,
       FormRow,
       TextInput,
       Button,
       ModalOpener,
       Modal
    },

    data: function() {
        return {
        }
    },

    computed: {
    },

    watch: {
    },

    methods: {
         formatDateTime(date) {
            return moment(date).format("DD.MM.YYYY");
        },

        clickMoreDetails(){
                document.getElementById('displayPatientModalOpener').click();
        },
        checkIfIs(check){
            if(check == true){
                return "DA";
            }else{
                return "NE";
            }
        }
    }
}

</script>
