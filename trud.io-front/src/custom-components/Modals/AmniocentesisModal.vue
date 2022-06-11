<template>
    <div>
        <Modal v-if="pregnancy.amniocentesis !== null && pregnancy.amniocentesis.result === 'Calculate risks'" modalBoxId="displayAmniocentesisModal" title="Amniocenteza" :sizeClass="'modal-lg'">
            <div slot="body">
                 <ViewAmniocentesisForm :pregnancyId="pregnancy.id" :amniocentesis="pregnancy.amniocentesis"/>
            </div>
            
            <ModalCloser id="displayAmniocentesisModal"></ModalCloser>
        </Modal>

        <ModalOpener id="displayAmniocentesisModalOpener" class="d-none" modalBoxId="displayAmniocentesisModal" />

            <Modal v-if="(amniocentesis !== null || (pregnancy.amniocentesis !== null && pregnancy.amniocentesis.result === ' ')) && this.role === 'DOCTOR' && pregnancy.birth == null" modalBoxId="createAmniocentesisModal" title="Amniocenteza">
                <div slot="body">
                    <AmniocentesisForm v-if="pregnancy.amniocentesis !== null " :pregnancyId="pregnancy.id" :amniocentesis="pregnancy.amniocentesis" :update="true"/>
                    <AmniocentesisForm  v-if="pregnancy.amniocentesis === null" :pregnancyId="pregnancy.id" :amniocentesis="amniocentesis" :update="false"/>
                </div>
            <ModalCloser id="createAmniocentesisModal"></ModalCloser>
        </Modal>
        <ModalOpener id="createAmniocentesisModalOpener" class="d-none" modalBoxId="createAmniocentesisModal" />
        
    </div>
</template>

<script>
import Modal from '../../generic-components/Modal/Modal.vue'
import ModalOpener from '../../generic-components/Modal/ModalOpener.vue'
import ModalCloser from '../../generic-components/Modal/ModalCloser.vue'
import AmniocentesisForm from '../../custom-components/Forms/AmniocentesisForm.vue'
import ViewAmniocentesisForm from '../../custom-components/Forms/ViewAmniocentesisForm.vue'
import {getRole} from '../../utils/userInfo.js';

export default {
    props: {
        pregnancy: null,
        amniocentesis: null
    },
    components: {
        Modal,
        ModalOpener,
        AmniocentesisForm,
        ViewAmniocentesisForm,
        ModalCloser
    },
    data: function() {
        return {
            role: "",
        }
    },
    computed: {
    },

    watch: {
    },

    methods: {

        clickAmniocentesis(){
            if(this.pregnancy.amniocentesis == null){
                document.getElementById('createAmniocentesisModalOpener').click();
            }else {
                 document.getElementById('displayAmniocentesisModalOpener').click();
            }
           
        },

    },
    mounted()
    {
        this.role = getRole();
    },
}
</script>