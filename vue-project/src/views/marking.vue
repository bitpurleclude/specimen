
<template>
  <div>
    <input type="file" @change="handleFileUpload">
    <<img ref="imgRef" :src="imageUrl" alt="Preview" @mousedown="startDrawing" @mousemove="draw" @mouseup="stopDrawing">
    <div v-for="(svgObject, index) in svgObjects" :key="index" v-html="svgObject.svgPath" v-tooltip="svgObject.name"></div>
    <button @click="sendSvgPaths">发送 SVG 路径</button>
  </div>
</template>

<script setup>
const photoId=-1;
import { ref } from 'vue';
//获取img并展示
const imgName = ref(null);
const imageUrl = ref(null);
const handleFileUpload = event => {
  const file = event.target.files[0];
  if (file) {
    imgName.value = file.name;
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
let currentName = '';
let currentPhotoId = '';

const startDrawing = (event) => {
  isDrawing = true;
  currentPath = [`M ${event.offsetX} ${event.offsetY}`];
};

const draw = (event) => {
  if (!isDrawing) return;
  currentName = imgName;
  currentPhotoId = photoId;
  currentPath.push(`L ${event.offsetX} ${event.offsetY}`);
};

const stopDrawing = () => {
  if (!isDrawing) return;
  isDrawing = false;
  currentPath.push('Z');
  svgPaths.value.push({ path: currentPath.join(' '), name: currentName, photoId: currentPhotoId });
  currentPath = [];
  currentName = '';
  currentPhotoId = '';
};
//发送svg路径
const sendSvgPaths = async () => {
  try {
    const response = await fetch('/api/svg-paths', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newSvgPaths.value),
    });

    if (!response.ok) {
      throw new Error('Network response was not ok');
    }else {
      newSvgPaths.value = [];
    }

    const data = await response.json();
    console.log('Response:', data);
  } catch (error) {
    console.error('Error:', error);
  }
};
</script>

<style scoped>

</style>