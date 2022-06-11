<template>
    <div>
        <Modal v-if="pregnancy.birth !== null" modalBoxId="displayBirthModal" title="Porođaj" :sizeClass="'modal-sg'">
            <div slot="body">
              <ViewBirthForm :birth="pregnancy.birth"/>
            </div>
            
            <ModalCloser id="displayBirthModal"></ModalCloser>
        </Modal>

        <ModalOpener id="displayBirthModalOpener" class="d-none" modalBoxId="displayBirthModal" />

            <Modal v-if="pregnancy.birth === null && role == 'NURSE'" modalBoxId="createBirthModal" title="Porođaj">
                <div slot="body">
                    <BirthForm  :pregnancy="pregnancy" :birth="birth"/>
                </div>
            <ModalCloser id="createBirthModal"></ModalCloser>
        </Modal>
        <ModalOpener id="createBirthModalOpener" class="d-none" modalBoxId="createBirthModal" />
        
    </div>
</template>

<script>
import Modal from '../../generic-components/Modal/Modal.vue'
import ModalOpener from '../../generic-components/Modal/ModalOpener.vue'
import ModalCloser from '../../generic-components/Modal/ModalCloser.vue'
import BirthForm from '../../custom-components/Forms/BirthForm.vue'
import ViewBirthForm from '../../custom-components/Forms/ViewBirthForm.vue'
import {getRole} from '../../utils/userInfo.js';

export default {
    props: {
        pregnancy: null,
        birth: null
    },
    components: {
        Modal,
        ModalOpener,
        BirthForm,
        ModalCloser,
        ViewBirthForm
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

        clickBirth(){
            if(this.pregnancy.birth == null){
                document.getElementById('createBirthModalOpener').click();
            }else{
                 document.getElementById('displayBirthModalOpener').click();
            }
           
        },

    },
    mounted()
    {
        this.role = getRole();
    },
}
</script>