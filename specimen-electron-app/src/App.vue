

<template>
  <RouterView />
  <BottomNav/>
</template>
<script>
import { RouterView } from 'vue-router'
import BottomNav from "@/components/bottom-nav.vue";
export default {
  components: {
    BottomNav,
    RouterView
  }
}
</script>
<style scoped>

</style>
