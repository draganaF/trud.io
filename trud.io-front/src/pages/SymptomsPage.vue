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
                        @input="add"
                        ></MultiSelectOptionInput>
                    
                    </div>

                    <div class="col-7">
                        <Card title='Simptomi pacijenta'>
                        <SymptomsTable v-if="pregnancy !== null"  :symptoms="pregnancy.symptoms"></SymptomsTable>
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
import { mapActions, mapGetters } from 'vuex'

export default {
    components: {
        Card,
        MultiSelectOptionInput,
        SymptomsTable
    },
    name: 'SymptomsPage',

    data: function() {
        return {
            patientSymptoms: null,
            selectedSymptoms: null,

        }
    },
    computed: {
           ...mapGetters({
            pregnancy: 'pregnancy/getPregnancy',
        }),
         
    },

    watch: {
            pregnancy(newPregnancy){
                if(newPregnancy.symptoms !== undefined){
                    const symptoms = [];
                    newPregnancy.symptoms.forEach(symptom => symptoms.push(symptom));
                    this.selectedSymptoms = symptoms;
                }
            },
    },

    methods: {
        ...mapActions({
            fetchPregnancy: 'pregnancy/fetchPregnancy',
            addSymptoms: 'pregnancy/addSymptoms',
        }),

        add(){
            this.pregnancy.symptoms = this.selectedSymptoms;
            this.addSymptoms({id:1, symptoms: this.pregnancy.symptoms});
        }

    },

    mounted()
    {
        this.patientSymptoms = patientSymptoms;
        this.fetchPregnancy(1);
        
    },
}
</script>
