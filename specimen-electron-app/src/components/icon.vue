<script>
export default {
  name: "icon",
  props: {
    Icon: {
      type: String,
      required: true
    },
    text: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      icon: ''
    }
  },
  mounted() {
    this.icon = `#icon-${this.Icon}`
  }
}
</script>

<template>
  <div class="icon-item">
    <svg class="icon" aria-hidden="true">
      <use :xlink:href="icon"></use>
    </svg>
    <span>{{ text }}</span>
  </div>
</template>

<style scoped>
.icon {
  /*设置字体颜色*/
  color: white;
  font-size: 20px;
  width: 1em;
  height: 1em;
  vertical-align: -0.15em;
  /* fill: currentColor; */
  overflow: hidden;
  cursor: pointer
}
.icon-item {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #ecf0f1;
  padding: 10px;
  border-radius: 10px;
}
</style>