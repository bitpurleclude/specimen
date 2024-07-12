<template>
  <button class="icon-button" @click="onClick">
    <img v-if="src" :src="src" alt="Example Icon" :style="{ width: imgWidth, height: imgHeight }" />
    <FontAwesomeIcon :icon="icon" /> {{ text }}
  </button>
</template>

<script>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

export default {
  components: {
    FontAwesomeIcon
  },
  props: {
    icon: {
      type: Array,
      default: ''
    },
    text: {
      type: String,
      default: ''
    },
    src:{
      type: String,
      default: ''
    },
    // 可以通过 props 传入图片的宽度和高度
    imgWidth: {
      type: String,
      default: '20px' // 默认宽度为100px
    },
    imgHeight: {
      type: String,
    }
  },
  methods: {
    onClick() {
      this.$emit('click');
    }
  }
}
</script>

<style scoped>
.icon-button {
  display: inline-flex;
  align-items: center;
  padding: 8px 16px;
  border: 1px solid #ccc;
  background-color: #f0f0f0;
  cursor: pointer;
  border-radius: 4px;
  font-size: 20px;
}

.icon-button:hover {
  background-color: #e0e0e0;
}

/* FontAwesome图标和文本之间的间距 */
.icon-button .fa-icon {
  margin-right: 8px;
}
</style>