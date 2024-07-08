<template>
  <nav class="bottom-nav">
    <ul>
      <li v-for="item in navItems" :key="item.route" @click="navigateTo(item.route)" :class="{ 'active': item.route === currentSelected }">{{ item.name }}</li>
    </ul>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      currentSelected: '', // 存储当前选中的路由名称
      navItems: [
        { name: '首页', route: 'home' },
        { name: '学习', route: 'learn' },
        { name: '发现', route: 'discover' },
        { name: '个人', route: 'profile' },
        // 可以在这里添加更多的导航项
      ],
    };
  },
  methods: {
    navigateTo(route) {
      this.currentSelected = route; // 更新当前选中的路由名称
      this.$router.push({ name: route });
    }
  }
}
</script>

<style scoped>
.bottom-nav {
  position: fixed;
  bottom: 0;
  left: 0; /* 确保导航栏从左侧开始 */
  width: 100%;
  display: flex;
  justify-content: space-around;
  background-color: #f0f0f0;
  margin: 0; /* 重置外边距 */
  padding: 0; /* 重置内边距 */
}

.bottom-nav ul {
  list-style: none;
  display: flex;
  width: 100%;
  justify-content: space-around;
  padding: 10px 0;
  margin: 0; /* 确保没有外边距 */
}

.bottom-nav li {
  cursor: pointer;
}
.bottom-nav li.active {
  color: red; /* Active state color */
}

.bottom-nav li:hover {
  color: blue; /* Hover state color */
}
.bottom-nav li.active:hover {
  color: red; /* 确保选中状态下鼠标悬停时颜色不变 */
}
</style>