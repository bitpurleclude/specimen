<template>
  <nav class="top-nav">
    <ul>
      <li v-for="item in navItems" :key="item.route" @click="navigateTo(item.route)" :class="{ 'active': item.route === currentSelected }">{{ item.name }}</li>
    </ul>
  </nav>
</template>

<script>
export default {
  props: {
    navItems: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      currentSelected: '', // 存储当前选中的路由名称
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
.top-nav {
  position: fixed;
  top: 0;
  left: 0; /* 确保导航栏从左侧开始 */
  width: 100%;
  display: flex;
  justify-content: space-around;
  background-color: #f0f0f0;
  margin: 0; /* 重置外边距 */
  padding: 0; /* 重置内边距 */
}

.top-nav ul {
  list-style: none;
  display: flex;
  width: 100%;
  justify-content: space-around;
  padding: 10px 0;
  margin: 0; /* 确保没有外边距 */
}

.top-nav li {
  cursor: pointer;
}
.top-nav li.active {
  color: red; /* Active state color */
}

.top-nav li:hover {
  color: blue; /* Hover state color */
}
.top-nav li.active:hover {
  color: red; /* 确保选中状态下鼠标悬停时颜色不变 */
}
</style>