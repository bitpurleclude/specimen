<template>
  <div>
    <input type="file" @change="handleFileUpload">
    <div class="container" :style="{ position: 'relative' }">
      <img :src="imageUrl" alt="Preview" @mousedown.prevent="startDrawing" @mousemove="draw" @mouseup="stopDrawing">
      <svg width="100%" height="100%" view-box="`0 0 100% 100%`"
        xmlns="http://www.w3.org/2000/svg"
        :style="{ position: 'absolute'}" @mousedown.prevent="startDrawing" @mousemove="draw" @mouseup="stopDrawing">
        <path v-for="(svgObject, index) in svgPaths" :key="index" :d="svgObject.svgPath.join(' ')" stroke="black" fill="none"
          stroke-width="2" v-tooltip="svgObject.name"></path>
      </svg>
      <!-- <div v-for="(svgObject, index) in svgPaths" :key="index" v-html="svgObject.svgPath" v-tooltip="svgObject.name"> -->
      <!-- </div> -->
    </div>
    <button @click="sendSvgPaths">发送 SVG 路径</button>
  </div>
</template>

<script setup>
let height=0;
let wight=0;
const photoId = -1;
let file = null;
import { onMounted, ref  } from 'vue';
//获取img并展示
const imgName = ref(null);
const imageUrl = ref(null);
const handleFileUpload = event => {
  file = event.target.files[0];
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
const getSvgPaths = () => {
  fetch('/api/svg-paths')
    .then(response => response.json())
    .then(data => {
      svgPaths.value = data;
    });
};
//绘制svg路径
import { reactive } from 'vue';
import { SVGDrowing } from '@/data/SVGDrowing.js';
const newSvgPaths = ref([]);
const imageSize = reactive({ width: 0, height: 0 });
let size =0;
let currentPath = [];

let isDrawing = false;
let currentName = '';
let currentPhotoId = '';


const startDrawing = (event) => {
  let svgPath = [];  // SVG路径，这是一个数组
  currentName = imgName;
  currentPhotoId = photoId;
  let Name='';
  let description='';
  let copiedWidth = wight;
  let copiedHeight = height;
  let svgDrowing = new SVGDrowing(svgPath, Name, currentPhotoId, copiedWidth, copiedHeight, description);
  svgPaths.value.push(svgDrowing);
  svgPaths.value[size].StartPath(event.offsetX, event.offsetY);
  newSvgPaths.value.push(svgDrowing);
  isDrawing = true;
};

const draw = (event) => {
  if (!isDrawing) return;
  svgPaths.value[size].addPath(event.offsetX, event.offsetY);
};

const stopDrawing = () => {
  if (!isDrawing) return;
  isDrawing = false;
  svgPaths.value[size].EndPath();
  let svgPathInput = window.prompt("请输入SVG的路径:");
  if (svgPathInput) {
    // 如果用户输入了SVG的路径，将其添加到svgPaths中
    svgPaths.value[size].setName(svgPathInput);
  }
  let svgPathDesInput = window.prompt("请输入SVG的描述:");
  if (svgPathDesInput) {
    // 如果用户输入了SVG的路径，将其添加到svgPaths中
    svgPaths.value[size].setDescription(svgPathDesInput);
  }
  size=svgPaths.value.length;
};
//发送svg路径
const SendPath = "https://localhost:8443/";
const sendSvgPaths = async () => {
  if (photoId!=-1){
    try {
      const response = await fetch(SendPath+'SendSVGPathWithId', {
        method: 'POST',
        body:newSvgPaths.value,
      });

      if (!response.ok) {
        throw new Error('Network response was not ok');
      } else {
        newSvgPaths.value = [];
      }
    } catch (error) {
      console.error('Error:', error);
    }
  }else {
    let formData = new FormData();
    formData.append('file', file);
    formData.append('svgPaths', JSON.stringify(newSvgPaths.value));
    try {
      const response = await fetch(SendPath+'SendSVGPath', {
        method: 'POST',
        body: formData,
      });

      if (!response.ok) {
        throw new Error('Network response was not ok');
      } else {
        newSvgPaths.value = [];
      }
    } catch (error) {
      console.error('Error:', error);
    }
  }

};
onMounted(() => {
  adjustImageSize();
});
const adjustImageSize = () => {
  const imgElement = imageUrl.value;
  if (imgElement) {
    // 如果图片已加载完成，则直接计算尺寸
    if (imgElement.complete) {
      calculateImageSize(imgElement);
    } else {
      // 否则，设置onload监听器等待图片加载完成
      imgElement.onload = () => {
        calculateImageSize(imgElement);
      };
    }
  }
};
const calculateImageSize = (img) => {
  wight = img.width;
  height = img.height;
  imageSize.value = {
    width: img.offsetWidth,
    height: img.offsetHeight,
  };
};

</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>