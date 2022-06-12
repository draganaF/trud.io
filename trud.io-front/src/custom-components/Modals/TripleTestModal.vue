<template>
    <div>
        <Modal v-if="pregnancy.tripleTest !== null && pregnancy.tripleTest.result === 'Calculate risks' " modalBoxId="displayTripleTestModal" title="Tripl test" :sizeClass="'modal-lg'">
            <div slot="body">
                <ViewTripleTestForm  :pregnancyId="pregnancy.id" :tripleTest="pregnancy.tripleTest"/>
            </div>
        </Modal>

        <ModalOpener id="displayTripleTestModalOpener" class="d-none" modalBoxId="displayTripleTestModal" />
            <Modal v-if="(tripleTest !== null || (pregnancy.tripleTest !== null && regnancy.tripleTest.result === ' ')) && this.role === 'DOCTOR' && pregnancy.birth == null" modalBoxId="createTripleTestModal" title="Tripl test">
                <div slot="body">
                    <TripleTestForm v-if="pregnancy.tripleTest !== null" :pregnancyId="pregnancy.id" :tripleTest="pregnancy.tripleTest" :update="true"/>
                     <TripleTestForm v-if="pregnancy.tripleTest === null" :pregnancyId="pregnancy.id" :tripleTest="tripleTest" :update="false"/>
                </div>
            <ModalCloser id="createTripleTestModal"></ModalCloser>
        </Modal>
        <ModalOpener id="createTripleTestModalOpener" class="d-none" modalBoxId="createTripleTestModal" />
        
    </div>
</template>

<script>
import Modal from '../../generic-components/Modal/Modal.vue'
import ModalOpener from '../../generic-components/Modal/ModalOpener.vue'
import ModalCloser from '../../generic-components/Modal/ModalCloser.vue'
import TripleTestForm from '../../custom-components/Forms/TripleTestForm.vue'
import ViewTripleTestForm from '../../custom-components/Forms/ViewTripleTestForm.vue'
import {getRole} from '../../utils/userInfo.js'
export default {
    props: {
        pregnancy: null,
        tripleTest: null,
    },
    components: {
        Modal,
        ModalOpener,
        TripleTestForm,
        ViewTripleTestForm,
        ModalCloser
    },
    data: function() {
        return {
            role: ""
        }
    },
    computed: {
    },

    watch: {
    },

    methods: {

        clickTripleTest(){
            if(this.pregnancy.tripleTest == null){
                document.getElementById('createTripleTestModalOpener').click();
            }else {
                document.getElementById('displayTripleTestModalOpener').click();
            }
           
        },

    },
    mounted()
    {
        this.role = getRole();
    },
}
</script>