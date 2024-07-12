<template>
  <div class="top-bar">真实标本</div>
<TopNav :nav-items="navItems" :current-selected="currentSelected" class="nav"/>
  <RouterView />
</template>
<script>
import TopNav from "@/components/top-nav.vue";
import specimendisplay from "@/components/specimen-display.vue";
import {RouterView} from "vue-router";
import {onMounted, ref} from "vue";

export default {
  components: {
    TopNav,
    RouterView,
    specimendisplay
  },
  data() {
    return {
      currentSelected: '', // 存储当前选中的路由名称
      navItems: [
        {name: '运动系统', route: 'sport'},
        {name: '神经系统', route: 'discover-alternating-current'},
        {name: '消化系统', route: 'discover-alternating-current'},
        {name: '循环系统', route: 'discover-alternating-current'},
        // 可以在这里添加更多的导航项
      ],
    }
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
.nav {
  margin-top: 50px;

}

.top-bar {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 50px; /* Adjust the height as needed */
  width: 100%; /* Make it fill the horizontal space */
  position: fixed; /* Fix its position to the viewport */
  top: 0; /* Stick to the top edge */
  left: 0; /* Align to the left edge */
  background-color: #2c3e50; /* Dark background for contrast */
  color: white; /* White text color for readability */
  font-size: 20px; /* Adjust the font size as needed */
  z-index: 1000; /* Ensure it stays on top of other content */
}
</style>