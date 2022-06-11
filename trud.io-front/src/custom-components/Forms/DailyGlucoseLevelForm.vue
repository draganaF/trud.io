<template>
    <Form>
        <form-row>
            <div class="col-12">
                <text-input 
                    label="Preprandial"
                    v-model="dailyGlucoseLevel.preprandial"
                    type="number"
                    :step="0.01"
                />
            </div>
        </form-row>

        <form-row>
            <div class="col-12">
                <text-input 
                    label="First postprandial"
                    v-model="dailyGlucoseLevel.firstPostprandial"
                    type="number"
                    :step="0.01"
                />
            </div>
        </form-row>

        <form-row>
            <div class="col-12">
                <text-input 
                    label="Second postprandial"
                    v-model="dailyGlucoseLevel.secondPostprandial"
                    type="number"
                    :step="0.01"
                />
            </div>
        </form-row>

        <Button @click="handleSaveClick">Sačuvaj</Button>

        <form-row v-if="isSaved">
            <div class="col-12">
                <TherapiesTable v-if="pregnancyResult.patient.therapies.length > 0" :therapies="pregnancyResult.patient.therapies"/>
                <h5 v-else style="margin-top: 3%; margin-left: 1%;">Nemate prepisane terapije</h5>
            </div>
        </form-row>

    </Form>
</template>

<script>

import Button from '../../generic-components/Form/Button.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import TherapiesTable from '../Tables/TherapiesTable.vue'
import toastr from 'toastr'
import { mapActions, mapGetters } from 'vuex'
import { getPregnancyId } from '../../utils/userInfo.js'

export default {
   components: {
       Form,
       FormRow,
       TextInput,
       Button,
       TherapiesTable
    },

    data: function() {
        return {
            dailyGlucoseLevel: {
                preprandial: null,
                firstPostprandial: null,
                secondPostprandial: null
            },
            isSaved: false,
            pregnancyResult: null
        }
    },

    computed: {
        ...mapGetters({
            result: 'ogtt/getResult',
            getPregnancyResult: 'ogtt/getPregnancyResult'
        })
    },

    watch: {
        result({ok, message, label}) {
            if(label === "createDailyGlucoseLevel") {
                if(ok) {
                    toastr.success(message);
                } else {
                    toastr.error(message)
                }
            }
        },
        getPregnancyResult(pregnancyResult) {
            this.isSaved = true;
            this.pregnancyResult = pregnancyResult;
        }
    },

    methods: {
        ...mapActions({createDailyGlucoseLevel: 'ogtt/createDailyGlucoseLevel'}),

        handleSaveClick() {
            this.createDailyGlucoseLevel({
                "glucoseLevel": this.dailyGlucoseLevel, 
                "pregnancyId": getPregnancyId()
        });
        }
    }
}

</script>
