<template>
  <div class="sidebar" data-color="purple" data-background-color="white">
    <sidebar-logo></sidebar-logo>
    <div class="sidebar-wrapper">
      <ul class="nav">
        <sidebar-item name="Početna" icon="dashboard" to="/"></sidebar-item>
        <sidebar-item name="Izveštaji" icon="summarize" to="/reports"></sidebar-item>
         <sidebar-item name="Trudnoće" icon="pregnant_woman" to="/pregnancies"></sidebar-item>
        <sidebar-item name="Dodaj trudnoću" icon="add_circle_outline" to="/create-pregnancy"></sidebar-item>
        <sidebar-item name="Termini" icon="summarize" to="/appointments/not-processed"></sidebar-item>
        <sidebar-item name="Ogtt testovi" icon="dashboard" to="/ogtt-table"></sidebar-item>

        <!-- dodati proveru ukoliko je majka ulogovana i prevesti sve ovo na srpski-->
        <sidebar-item name="Dnevno merenje glukoze" icon="summarize" to="/daily-glucose-level"></sidebar-item>
        <sidebar-item name="Cut off vrednosti" icon="article" to="/risks"></sidebar-item>
        <sidebar-item name="Pregled CTGa" icon="equalizer" to="/ctgs"></sidebar-item>
      </ul>
    </div>
  </div>
</template>

<script>
import SidebarItem from "../../generic-components/Sidebar/SidebarItem.vue";
import SidebarLogo from "../../generic-components/Sidebar/SidebarLogo.vue";
export default {
  data: () => {
    return {};
  },
  mounted() {},
  components: {
    SidebarLogo,
    SidebarItem,
  },
  methods: {},
};
</script>

<style></style>
