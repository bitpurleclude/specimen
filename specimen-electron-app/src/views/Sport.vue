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
    <div class="top-bar">运动系统</div>
    <TopNav :nav-items="navItems" :current-selected="currentSelected" class="nav"/>
    <!-- 设置每行两个specimendisplay组件，一共三行，使用section，不使用v-for -->
    <section class="hang">
        <specimendisplay url="/src/assets/photo/xi.jpg" name="膝关节"/>
        <specimendisplay url="/src/assets/photo/zhou.jpg" name="肘关节"/>
    </section>
    <section class="hang">
        <specimendisplay url="/src/assets/photo/jian.jpg" name="肩关节"/>
        <specimendisplay url="/src/assets/photo/huai.jpg" name="踝关节"/>
    </section>
    <section class="hang">
        <specimendisplay url="/src/assets/photo/zu.jpg" name="足"/>
        <specimendisplay url="/src/assets/photo/gugu.jpg" name="股骨"/>
    </section>
</template>

<style scoped>
.hang{
    display: flex;
    justify-content: space-around;
    margin-top: 50px;
}
</style>