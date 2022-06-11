<template>
    <div class="content">
        <Card title='Trudnoće'>
            <PregnanciesTable v-if="pregnancies !== null" :pregnancies="pregnancies" />
        </Card>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import PregnanciesTable from '../custom-components/Tables/PregnanciesTable.vue'
import { mapActions, mapGetters } from 'vuex'

export default {
    components: {
        Card,
        PregnanciesTable
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
            fetchPregnancies: 'pregnancy/fetchPregnancies',
        }),

    },

    mounted()
    {
        this.fetchPregnancies();
        
    },
}
</script>
