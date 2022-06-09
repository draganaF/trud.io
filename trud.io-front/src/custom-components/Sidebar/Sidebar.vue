<template>
  <div class="sidebar" data-color="purple" data-background-color="white">
    <sidebar-logo></sidebar-logo>
    <div class="sidebar-wrapper">
      <ul class="nav">
        <sidebar-item name="Home" icon="dashboard" to="/"></sidebar-item>
        <sidebar-item name="Report" icon="summarize" to="/reports"></sidebar-item>
        <sidebar-item name="Create pregnancy" icon="add_circle_outline" to="/create-pregnancy"></sidebar-item>
        <sidebar-item name="Appointments" icon="summarize" to="/appointments/not-processed"></sidebar-item>
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
