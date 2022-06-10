<template>
    <div class="content">
        <div class="container-fluid">
            <div class="center align-items-center col-10" style="margin-left: 8%">
                <card :title="'OGTT TEST'">
                    <OgttTestForm  :action="action" :existingOgtt="ogtt" :pregnancyId="pregnancyId" :ogttId="ogttId"/>
                </card>
            </div>
        </div>
    </div>
</template>

<script>
import Card from '../generic-components/Card/Card.vue'
import OgttTestForm from '../custom-components/Forms/OgttTestForm.vue'
import {getRole} from '../utils/userInfo.js'

export default {
    components: {
        Card,
        OgttTestForm
    },
    data: () => {
      return {
      ogtt: {},
      action: "",
      pregnancyId: 0,
      ogttId: 0,
      role: ""
      }
    },
    mounted() {
      if("ogtt" in this.$route.query) {
        this.ogtt = this.$route.query.ogtt;
      }

      this.ogttId = this.ogtt.id;
      this.pregnancyId = this.ogtt.pregnancyId;

      if(this.ogtt.result === "NOT_SUBMITED") {
        this.action = "Primary";
      }
      else if (this.ogtt.result === "POSITIVE" || this.ogtt.result === "NEGATIVE") {
        this.action = "Done";
      }
      else {
        this.action = "Extended";
      }
      if(getRole() === "PATIENT") {
        this.action = "Done";
      }
      console.log(this.action)
    }
}
</script>