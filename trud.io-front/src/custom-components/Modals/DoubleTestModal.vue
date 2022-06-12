<template>
    <div>
     <Modal :v-if="pregnancy.doubleTest !== null && pregnancy.doubleTest.result === 'Calculate risks' " modalBoxId="displayDoubleTestModal" title="Dabl test" :sizeClass="'modal-lg'">
                    <div slot="body">
                        <ViewDoubleTestForm  :pregnancyId="pregnancy.id" :doubleTest="pregnancy.doubleTest"/>
            
                    </div>
                </Modal>
                <ModalOpener id="displayDoubleTestModalOpener" class="d-none" modalBoxId="displayDoubleTestModal" />

                <Modal v-if="doubleTest !== null && pregnancy !== null && (pregnancy.week >=12 && pregnancy.week <= 14) && this.role === 'DOCTOR' && pregnancy.birth == null" modalBoxId="createDoubleTestModal" title="Dabl test">
                    <div slot="body">
                         <DoubleTestForm v-if="doubleTest!== null" :pregnancyId="pregnancy.id" :doubleTest="doubleTest"/>
                    </div>
                <ModalCloser id="createDoubleTestModal"></ModalCloser>
    </Modal>
                <ModalOpener id="createDoubleTestModalOpener" class="d-none" modalBoxId="createDoubleTestModal" />
    </div>
</template>

<script>
import Modal from '../../generic-components/Modal/Modal.vue'
import ModalOpener from '../../generic-components/Modal/ModalOpener.vue'
import ModalCloser from '../../generic-components/Modal/ModalCloser.vue'
import DoubleTestForm from '../../custom-components/Forms/DoubleTestForm.vue'
import ViewDoubleTestForm from '../../custom-components/Forms/ViewDoubleTestForm.vue'
import {getRole} from '../../utils/userInfo.js'
import {mapGetters} from 'vuex'

export default {
    props: {
        pregnancy: null,
        doubleTest: null,
    },
    components: {
        Modal,
        ModalOpener,
        DoubleTestForm,
        ViewDoubleTestForm,
        ModalCloser
    },
    data: function() {
        return {
            role: ""
        }
    },
    computed: {
          ...mapGetters({
            getDoubleTest: 'doubleTest/getDoubleTest'
        }),
    },

    watch: {
        getDoubleTest(doubleTest){
            this.pregnancy.doubleTest = doubleTest; 
        }
    },

    methods: {

        clickDoubleTest(){
            if(this.pregnancy.doubleTest == null){
                document.getElementById('createDoubleTestModalOpener').click();
            }else {
                document.getElementById('displayDoubleTestModalOpener').click();
            }
           
        },

    },
    mounted()
    {
        this.role = getRole();
    },
}
</script>