<template>
  <div class="dynamic-container" :style="containerStyle">
    <slot></slot> <!-- 允许父组件插入内容 -->
  </div>
</template>

<script>
export default {
  name: 'DynamicContainer',
  props: {
    flexDirection: {
      type: String,
      default: 'row', // 默认为行排列
    },
    justifyContent: {
      type: String,
      default: 'flex-start', // 默认对齐方式
    },
    alignItems: {
      type: String,
      default: 'flex-start', // 默认项目对齐方式
    }
  },
  computed: {
    containerStyle() {
      return {
        display: 'flex',
        flexDirection: this.flexDirection, // 控制主轴方向
        justifyContent: this.justifyContent, // 控制主轴上的对齐方式
        alignItems: this.alignItems, // 控制交叉轴上的对齐方式
      };
    }
  }
}
</script>

<style scoped>
.dynamic-container {
  box-sizing: border-box;
  display: flex;
  flex-direction: column; /* Stack children vertically */
  justify-content: center; /* Center children vertically */
  align-items: center; /* Center children horizontally */
  border: 1px solid #ccc;
  margin: 10px; /* Margin around the container */
  padding: 20px; /* Padding inside the container */
  background-color: #fff;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  width: calc(100% - 20px); /* Adjust width for margin */
  min-height: 100px; /* Minimum height of the container */
  flex-wrap: wrap; /* Allow children to wrap if needed */
}

.dynamic-container {
  display: flex;
  flex-direction: row;
  justify-content: center; /* Center content vertically */
  align-items: center; /* Center content horizontally */
  height: 100%; /* Container takes full height */
  padding: 10px; /* Adjust padding as needed */
}

.dynamic-container > * {
  width: 30%; /* Child elements take up 80% of the container's width */
  height: 30%; /* Child elements take up 80% of the container's height */
  margin: auto; /* Center the child elements */
}
</style>