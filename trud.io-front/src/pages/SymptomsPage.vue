<template>
    <div class="content">
        <div class="container-fluid">
            <Card title='Simptomi'>
                <div style="display: flex;">
                    <div class="col-4">
                        <MultiSelectOptionInput 
                        label="Simptomi"
                        v-model="selectedSymptoms"
                        :options="patientSymptoms"
                        @input="addSymptom"
                        ></MultiSelectOptionInput>
                    
                    </div>
                    <div class="col-7">
                        <Card title='Simptomi pacijenta'>
                        <SymptomsTable :symptoms="selectedSymptoms"></SymptomsTable>
                        </Card>
                    </div>
                    
                </div>
            </Card>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import MultiSelectOptionInput from '../generic-components/Form/MultiSelectOptionInput.vue'
import SymptomsTable from '../custom-components/Tables/SymptomsTable.vue'
import { patientSymptoms} from '../constants.js';

export default {
    components: {
        Card,
        MultiSelectOptionInput,
        SymptomsTable
    },
    name: 'SymptomsPage',

    data: function() {
        return {
            selectedSymptoms: [],
            patientSymptoms: null

        }
    },

    computed: {},

    watch: {},

    methods: {
        addSymptom(){
            
            console.log(this.selectedSymptoms);
        }

    },

    mounted()
    {
        this.patientSymptoms = patientSymptoms;
    },
}
</script>
