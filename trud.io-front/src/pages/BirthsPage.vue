<template>
    <div class="content">
        <Card title='Porođaji'>
            <BirthsTable v-if="pregnancies !== null" :pregnancies="pregnancies" />
        </Card>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import BirthsTable from '../custom-components/Tables/BirthsTable.vue'
import { mapActions, mapGetters } from 'vuex'

export default {
    components: {
        Card,
        BirthsTable
    },
    data: function() {
        return {
        }
    },
    computed: {
           ...mapGetters({
            pregnancies: 'pregnancy/getPregnancies',
        }),
         
    },

    watch: {
    },

    methods: {
        ...mapActions({
            fetchPregnanciesAndBirths: 'pregnancy/fetchPregnanciesAndBirths',
        }),

    },

    mounted()
    {
        this.fetchPregnanciesAndBirths();
        
    },
}
</script>
