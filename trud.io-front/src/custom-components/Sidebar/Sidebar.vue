<template>
  <div class="sidebar" data-color="purple" data-background-color="white">
    <sidebar-logo></sidebar-logo>
    <div class="sidebar-wrapper">
      <ul class="nav">
        <sidebar-item name="Home" icon="dashboard" to="/"></sidebar-item>
        <sidebar-item  v-if="role === 'PATIENT'" name="Pregnancy" icon="pregnant_woman" :to=pregnancyPath></sidebar-item>
        <sidebar-item  v-if="role === 'DOCTOR'" name="Report" icon="summarize" to="/reports"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' || role === 'NURSE'" name="Pregnancies" icon="pregnant_woman" to="/pregnancies"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' || role === 'NURSE'" name="Porođaji" icon="child_care" to="/births"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' " name="Create pregnancy" icon="add_circle_outline" to="/create-pregnancy"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' || role === 'NURSE'" name="Appointments" icon="summarize" to="/appointments/not-processed"></sidebar-item>
        <sidebar-item  v-if="role === 'DOCTOR' || role === 'NURSE' || role === 'PATIENT'" name="Ogtt table" icon="dashboard" to="/ogtt-table"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR'" name="Cut off values" icon="article" to="/risks"></sidebar-item>

      </ul>
    </div>
  </div>
</template>

<script>
import SidebarItem from "../../generic-components/Sidebar/SidebarItem.vue";
import SidebarLogo from "../../generic-components/Sidebar/SidebarLogo.vue";
import { getRole} from "../../utils/userInfo.js";

export default {
  data: () => {
    return {
      role: "",
      pregnancyPath: ""
    };
  },
  mounted() {
    if(getRole() === 'PATIENT'){
    //  this.pregnancyPath = "/pregnancy/" + getPregnancyId();
    this.pregnancyPath = "/pregnancy/1" ;
    }
    this.role = getRole();
     
  },
  components: {
    SidebarLogo,
    SidebarItem,
  },
  methods: {},
};
</script>

<style></style>
