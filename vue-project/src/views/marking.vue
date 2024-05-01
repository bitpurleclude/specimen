
<template>
  <div>
    <input type="file" @change="handleFileUpload">
    <img v-if="imageUrl" :src="imageUrl" alt="Preview">
    <div v-for="(svgObject, index) in svgObjects" :key="index" v-html="svgObject.svgPath" v-tooltip="svgObject.name"></div>
  </div>
</template>

<script setup>
/* import Vue from 'vue' */
import VTooltip from 'v-tooltip'

Vue.use(VTooltip)

import { ref } from 'vue';
//获取img并展示
const imageUrl = ref(null);
const handleFileUpload = event => {
  const file = event.target.files[0];
  if (file) {
    const reader = new FileReader();
    reader.onload = e => {
      imageUrl.value = e.target.result;
    };
    reader.readAsDataURL(file);
  }
};
//获取svg路径
const svgPaths = ref([]);
const getSvgPaths = () =>{
  fetch('/api/svg-paths')
      .then(response => response.json())
      .then(data => {
        svgPaths.value = data;
      });
};
//绘制svg路径
import { reactive } from 'vue';
const newSvgPaths = ref([]);
const imageSize = reactive({ width: 0, height: 0 });
let currentPath = [];
let isDrawing = false;

const startDrawing = (event) => {
  isDrawing = true;
  currentPath = [`M ${event.offsetX} ${event.offsetY}`];
};

const draw = (event) => {
  if (!isDrawing) return;
  currentPath.push(`L ${event.offsetX} ${event.offsetY}`);
};

const stopDrawing = () => {
  if (!isDrawing) return;
  isDrawing = false;
  currentPath.push('Z');
  svgPaths.value.push(currentPath.join(' '));
  newSvgPaths.value.push(currentPath.join(' '));
  currentPath = [];
};

</script>

<style scoped>

</style>