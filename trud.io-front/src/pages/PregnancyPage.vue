<template>
    <div class="content">
        <div class="container-fluid">
            <Card title='Trudnoća' v-if="pregnancy !== null">
                <div class="center align-items-center">
                    <div class="row">
                        <div class="col-4">
                            <PatientForm :pregnancy="pregnancy"/>
                        </div>
                        <div class="col-8">
                            <Button class="pull-left" @click="clickDoubleTest">Dabl test</Button>
                            <Button class="pull-left" @click="clickTripleTest">Tripl test</Button>
                            <Button class="pull-left" @click="clickQuadripleTest">Kvadripl test</Button>
                            <Button class="pull-left" @click="clickAmniocentesis">Amniocenteza</Button>
                            <Button class="pull-left" @click="clickSymptoms">Simptomi</Button>
                            <Button class="pull-left" @click="clickBirth">Porođaj</Button>
                        </div>
                    </div>
                </div>

                <DoubleTestModal :doubleTest="doubleTest" :pregnancy="pregnancy"/>
                <TripleTestModal :tripleTest="tripleTest" :pregnancy="pregnancy"/>
                <QuadripleTestModal :quadripleTest="quadripleTest" :pregnancy="pregnancy"/>
                <AmniocentesisModal :amniocentesis="amniocentesis" :pregnancy="pregnancy"/>
                <BirthModal :birth="birth" :pregnancy="pregnancy"/>
            </Card>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import PatientForm from '../custom-components/Forms/PatientForm.vue'
import Button from '../generic-components/Form/Button.vue'
import DoubleTestModal from '../custom-components/Modals/DoubleTestModal.vue'
import TripleTestModal from '../custom-components/Modals/TripleTestModal.vue'
import QuadripleTestModal from '../custom-components/Modals/QuadripleTestModal.vue'
import AmniocentesisModal from '../custom-components/Modals/AmniocentesisModal.vue'
import BirthModal from '../custom-components/Modals/BirthModal.vue'
import {mapActions, mapGetters} from 'vuex'

export default {
    components: {
        Card,
        PatientForm,
        Button,
        DoubleTestModal,
        TripleTestModal,
        QuadripleTestModal,
        AmniocentesisModal,
        BirthModal
    },
    data: function() {
        return {
            pregnancyId: null,
            doubleTest: {
                crl: null,
                nt: null,
                nasalBone: null,
                freeBetaHCG: null,
                pappa: null,
                result: 'Not yet processed'
            },
             tripleTest: {
                hcg: null,
                afp: null,
                ue3: null,
                result: 'Not yet processed'
            },
            quadripleTest: {
                hcg: null,
                afp: null,
                ue3: null,
                inhibinA:null,
                result: 'Not yet processed'
            },
            amniocentesis: {
                afp: null,
                result: 'Not yet processed'
            },
            birth: {
                weight: null,
                cSection: null,
                complications: null,
                chromosomalDisorder: null,
                miscarriage: null
            }
        }
    },
    computed: {
           ...mapGetters({
            pregnancy: 'pregnancy/getPregnancy'
        }),
         
    },

    watch: {
    },

    methods: {
         ...mapActions({
            fetchPregnancy: 'pregnancy/fetchPregnancy',
        }),

        clickDoubleTest(){
            if(this.pregnancy.doubleTest == null){
                document.getElementById('createDoubleTestModalOpener').click();
            }else {
                document.getElementById('displayDoubleTestModalOpener').click();
            }
           
        },
         clickTripleTest(){
            if(this.pregnancy.tripleTest == null || (this.pregnancy.tripleTest !== null && this.pregnancy.tripleTest.result === ' ')){
                document.getElementById('createTripleTestModalOpener').click();
            }else {
                document.getElementById('displayTripleTestModalOpener').click();
            }
           
        },
         clickQuadripleTest(){
            if(this.pregnancy.quadripleTest == null || (this.pregnancy.quadripleTest !== null && this.pregnancy.quadripleTest.result === ' ')){
                document.getElementById('createQuadripleTestModalOpener').click();
            }else {
                document.getElementById('displayQuadripleTestModalOpener').click();
            }
           
        },

        clickAmniocentesis(){
            if(this.pregnancy.amniocentesis == null || (this.pregnancy.amniocentesis !== null && this.pregnancy.amniocentesis.result === ' ')){
                document.getElementById('createAmniocentesisModalOpener').click();
            }else {
                document.getElementById('displayAmniocentesisModalOpener').click();
            }
           
        },

        clickSymptoms(){
             this.$router.push(`/symptoms/${this.pregnancyId}`);
        },

        clickBirth(){
            if(this.pregnancy.birth == null){
                document.getElementById('createBirthModalOpener').click();
            }else{
                document.getElementById('displayBirthModalOpener').click();
            }
           
        }

    },

    mounted()
    {
        this.pregnancyId = this.$route.params.id;
        this.fetchPregnancy(this.pregnancyId);
       
    },
}
</script>
