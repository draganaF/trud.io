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
    </Form>
</template>

<script>

import Button from '../../generic-components/Form/Button.vue'
import Form from '../../generic-components/Form/Form.vue'
import FormRow from '../../generic-components/Form/FormRow.vue'
import TextInput from '../../generic-components/Form/TextInput.vue'
import toastr from 'toastr'
import { mapActions, mapGetters } from 'vuex'
import { getPregnancyId } from '../../utils/userInfo.js'

export default {
   components: {
       Form,
       FormRow,
       TextInput,
       Button
    },

    data: function() {
        return {
            dailyGlucoseLevel: {
                preprandial: null,
                firstPostprandial: null,
                secondPostprandial: null
            }
        }
    },

    computed: {
        ...mapGetters({result: 'ogtt/getResult'})
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
