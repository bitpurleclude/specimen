<script>
import TopNav from "@/components/top-nav.vue";
import PicturesDescriptions from "@/components/pictures-descriptions.vue";

export default {
  components: {
    TopNav,
    PicturesDescriptions
  },
  name: "Pathology"
}
</script>

<template>
  <div>
    <!-- 设置每行两个specimendisplay组件，一共三行，使用section，不使用v-for -->
    <section class="hang">
      <PicturesDescriptions url="/src/assets/photo/1.jpg" name="肝硬化"/>
      <PicturesDescriptions url="/src/assets/photo/2.jpg" name="循环系统疾病"/>
      <PicturesDescriptions url="/src/assets/photo/3.jpg" name="脑出血"/>
      <PicturesDescriptions url="/src/assets/photo/4.jpg" name="心脏病"/>
    </section>
  </div>
</template>

<style scoped>

</style>