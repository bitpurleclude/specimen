<template>
  <topNav :selected="selectedNav" :navItems="navItems"/>
  <RouterView />
</template>

<script>
import { ref, onMounted } from 'vue';
import topNav from "@/components/top-nav.vue";
import { RouterView } from "vue-router";

export default {
  data() {
    return {
      currentSelected: '', // 存储当前选中的路由名称
      navItems: [
        { name: '解剖学', route: 'learn-anatomy' },
        { name: '影像学', route: 'learn-Imaging' },
        { name: '病理学', route: 'learn-pathology' },
        { name: '考研', route: 'learn-GSEE' },
        // 可以在这里添加更多的导航项
      ],
    };
  },
  components: {
    topNav,
    RouterView
  },
  setup() {
    const selectedNav = ref(0); // 假设顶部栏的第一个选项是0索引

    onMounted(() => {
      // 可以在这里设置默认选中的顶部栏选项，如果需要的话
      // 例如，selectedNav.value = 0;
      // 如果顶部栏组件需要通过方法来设置选中项，则调用该方法
    });

    return {
      selectedNav
    };
  }
}
</script>

<style scoped>
/* 样式 */
</style>