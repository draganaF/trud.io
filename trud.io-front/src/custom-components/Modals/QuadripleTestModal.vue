<template>
    <div>
        <Modal v-if="pregnancy.quadripleTest !== null && pregnancy.quadripleTest.result === 'Calculate risks' " modalBoxId="displayQuadripleTestModal" title="Kvadripl test" :sizeClass="'modal-lg'">
            <div slot="body">
                <ViewQuadripleTestForm  :pregnancyId="pregnancy.id" :quadripleTest="pregnancy.quadripleTest"/>
            </div>
        </Modal>
        <ModalOpener id="displayQuadripleTestModalOpener" class="d-none" modalBoxId="displayQuadripleTestModal" />

        <Modal v-if="quadripleTest !== null &&  (pregnancy.week >15 && pregnancy.week < 18)" modalBoxId="createQuadripleTestModal" title="Kvadripl test">
                <div slot="body">
                    <QuadripleTestForm v-if="pregnancy.quadripleTest === null" :pregnancyId="pregnancy.id" :quadripleTest="quadripleTest"/>
                </div>
            <ModalCloser id="createQuadripleTestModal"></ModalCloser>
        </Modal>
        <ModalOpener id="createQuadripleTestModalOpener" class="d-none" modalBoxId="createQuadripleTestModal" />
        
    </div>
</template>

<script>
import Modal from '../../generic-components/Modal/Modal.vue'
import ModalOpener from '../../generic-components/Modal/ModalOpener.vue'
import ModalCloser from '../../generic-components/Modal/ModalCloser.vue'
import QuadripleTestForm from '../../custom-components/Forms/QuadripleTestForm.vue'
import ViewQuadripleTestForm from '../../custom-components/Forms/ViewQuadripleTestForm.vue'

export default {
    props: {
        pregnancy: null,
        quadripleTest: null,
    },
    components: {
        Modal,
        ModalOpener,
        QuadripleTestForm,
        ViewQuadripleTestForm,
        ModalCloser
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

        clickQuadripleTest(){
            if(this.pregnancy.quadripleTest == null){
                document.getElementById('createQuadripleTestModalOpener').click();
            }else {
                document.getElementById('displayQuadripleTestModalOpener').click();
            }
           
        },

    },
    mounted()
    {
    },
}
</script>