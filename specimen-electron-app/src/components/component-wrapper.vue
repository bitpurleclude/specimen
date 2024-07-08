<template>
  <div class="component-wrapper">
    <span class="text-content">{{ text }}</span>
    <span class="icon-wrapper">
    <FontAwesomeIcon :icon="icon"/>
    </span>
  </div>
</template>

<script>
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'
import {library} from '@fortawesome/fontawesome-svg-core'
import {faGamepad} from '@fortawesome/free-solid-svg-icons'

library.add(faGamepad)
export default {
  components: {
    FontAwesomeIcon
  },
  name: 'component-wrapper',
  props: {
    text: {
      type: String,
      required: true
    },
    icon: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>
.component-wrapper {
  box-sizing: border-box;
  align-items: flex-start;
  border: 1px solid #ccc;
  margin: 10px; /* 设置所有边的外边距为10px */
  padding: 20px; /* 保持卡片内部的填充 */
  background-color: #fff;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  width: calc(100% - 20px); /* 调整宽度以考虑两侧的外边距 */
  min-height: 100px; /* 设置一个最小高度 */
  display: flex; /* 使用flex布局 */
  justify-content: space-between; /* 文本和图标分布在两侧 */
}
.component-wrapper {
  display: flex; /* 使用flex布局 */
  justify-content: space-between; /* 文本和图标分布在两侧 */
  align-items: center; /* 垂直居中对齐 */
}

.text-content {
  /* 文字样式，根据需要进行调整 */
}

.icon-wrapper {
  /* 图标样式，根据需要进行调整 */
}
</style>