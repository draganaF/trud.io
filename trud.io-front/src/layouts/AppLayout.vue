<template>
  <component :is="layout">
    <slot />
  </component>
</template>

<script>
import { tryConnecting } from "../utils/sockets.js";

const defaultLayout = 'AppLayoutDefault'
export default {
  name: "AppLayout",
  data: function() {
    return {
    }
  },
  mounted() {
    tryConnecting()
  },
  computed: {
    layout() {
      const layout = this.$route.meta.layout || defaultLayout
      return () => import(`@/layouts/${layout}.vue`)
    },
  }
}
</script>