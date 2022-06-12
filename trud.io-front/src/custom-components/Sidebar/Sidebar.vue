<template>
  <div class="sidebar" data-color="purple" data-background-color="white">
    <sidebar-logo></sidebar-logo>
    <div class="sidebar-wrapper">
      <ul class="nav">
        <!-- <sidebar-item name="Početna" icon="dashboard" to="/"></sidebar-item> -->
        <sidebar-item v-if="role === 'DOCTOR' || role === 'NURSE'" name="Pacijenti" icon="person" to="/patients"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' " name="Dodaj trudnoću" icon="add_circle_outline" to="/create-pregnancy"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' || role === 'NURSE'" name="Trudnoće" icon="pregnant_woman" to="/pregnancies"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' || role === 'NURSE'" name="Termini" icon="summarize" to="/appointments/not-processed"></sidebar-item>
        <sidebar-item  v-if="role === 'PATIENT' && preganncyId !== null" name=" Aktivna Trudnoća" icon="pregnant_woman" :to="this.pregnancyPath" ></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' || role === 'PATIENT'" name="Pregled CTGa" icon="equalizer" to="/ctgs"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' || role === 'NURSE'" name="Porođaji" icon="child_care" to="/births"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR'" name="Izveštaji" icon="summarize" to="/reports"></sidebar-item>
        <sidebar-item v-if="role === 'PATIENT'" name="Moje trudnoće" icon="article" to="/pregnancies"></sidebar-item>
       
     
        <sidebar-item  v-if="role === 'DOCTOR' || role === 'NURSE'" name="Ogtt testovi" icon="dashboard" to="/ogtt-table"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR'" name="Cut off vrednosti" icon="article" to="/risks"></sidebar-item>
        <!-- dodati proveru ukoliko je majka ulogovana i prevesti sve ovo na srpski-->
        <sidebar-item v-if="role === 'PATIENT'" name="Dnevno merenje glukoze" icon="summarize" to="/daily-glucose-level"></sidebar-item>
      
      </ul>
    </div>
  </div>
</template>

<script>
import SidebarItem from "../../generic-components/Sidebar/SidebarItem.vue";
import SidebarLogo from "../../generic-components/Sidebar/SidebarLogo.vue";
import { getRole, getPregnancyId} from "../../utils/userInfo.js";

export default {
  data: () => {
    return {
      role: "",
      pregnancyPath: "",
      preganncyId: null,
    };
  },
  mounted() {
    if(getRole() === 'PATIENT'){
      if(getPregnancyId() !== null){
        this.preganncyId = getPregnancyId();
        this.pregnancyPath = "/pregnancy/" + getPregnancyId();
      }
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
