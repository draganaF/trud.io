<template>
  <div class="sidebar" data-color="purple" data-background-color="white">
    <sidebar-logo></sidebar-logo>
    <div class="sidebar-wrapper">
      <ul class="nav">
        <sidebar-item name="Početna" icon="dashboard" to="/"></sidebar-item>
        <sidebar-item  v-if="role === 'PATIENT'" name="Trudnoća" icon="pregnant_woman" to="/pregnancyPath" ></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR'" name="Izveštaji" icon="summarize" to="/reports"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' || role === 'NURSE'" name="Trudnoće" icon="pregnant_woman" to="/pregnancies"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' || role === 'NURSE'" name="Porođaji" icon="child_care" to="/births"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' " name="Dodaj trudnoću" icon="add_circle_outline" to="/create-pregnancy"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR' || role === 'NURSE'" name="Termini" icon="summarize" to="/appointments/not-processed"></sidebar-item>
        <sidebar-item  v-if="role === 'DOCTOR' || role === 'NURSE' || role === 'PATIENT'" name="Ogtt testovi" icon="dashboard" to="/ogtt-table"></sidebar-item>
        <sidebar-item v-if="role === 'DOCTOR'" name="Cut off vrijednosti" icon="article" to="/risks"></sidebar-item>
        <!-- dodati proveru ukoliko je majka ulogovana i prevesti sve ovo na srpski-->
        <sidebar-item name="Dnevno merenje glukoye" icon="summarize" to="/daily-glucose-level"></sidebar-item>
        <sidebar-item name="Pregled CTGa" icon="equalizer" to="/ctgs"></sidebar-item>
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
      //Zasto je ovo zakomentarisano
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
