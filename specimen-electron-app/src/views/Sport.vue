<script>
import specimendisplay from "@/components/specimen-display.vue";
import TopNav from "@/components/top-nav.vue";
export default {
  components: {
    specimendisplay,
    TopNav
  },
}
</script>

<template>
  <section>
    <div class="top-bar">运动系统</div>
    <TopNav :nav-items="navItems" :current-selected="currentSelected" class="nav"/>
    <specimendisplay url="https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg" name="树"/>
    <specimendisplay url="https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg" name="树"/>
    <specimendisplay url="https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg" name="树"/>
  </section>
</template>

<style scoped>

</style>