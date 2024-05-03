<script setup>
import { onMounted, ref, computed, inject } from 'vue'
import url from '@/photo/背面（原图）.jpg'
import { SVGData } from './data/SVGData';
const props = defineProps({
  id: Number,
  svg: {
    type: Number, // 指定props的类型
    required: true, // 是否必填
    default: null // 默认值
  }
});
//图片大小获取
const child = ref(null);
const childRect = ref(null);
onMounted(() => {
  adjustImageSize();
  // 获取元素的边界框
  if (!child.value) {
    console.error('Child element is not available');
  }
  else childRect.value = child.value.getBoundingClientRect();
  getSvgById(props.id);
});
//通过id获取svg的路径
const getSvgById=(Id)=>{
  let imgId1={
    imgId : Id
  }
  let svgDatas = [];
  fetch('http://[240c:cd22:138f:dbd:a8e9:781d:f34e:2]:8080/api/GetSVGById' ,{
        method: 'POST', // 或者 'PUT'
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(imgId1),
      }
  ) // 替换为你的API URL

      .then(response => response.json())
      .then(data => {
        for (let i = 0; i < data.length; i++) {
          let svgData = new SVGData(
              JSON.parse(data[i].svgPath).join(''),
              data[i].id,
              data[i].svgName,
              data[i].imageId,
              data[i].width,
              data[i].height,
              data[i].description,
              false
          );
          svgObjects.value.push(svgData);
        }
        console.log(data);
      })
      .catch(error => {
        // 在这里处理任何在请求过程中发生的错误
        console.error('Error:', error);
      });
}

const image_url = ref(url)

const svgObjects = ref([]);
//for (let i = 0; i < svgData.value.length; i++) {
 // svgObjects.value.push(new SVGData(svgData.value[i], false));
//}

const imageSize = ref({ left: 0, top: 0, width: 0, height: 0, realWidth: 0, realHeight: 0, xScale: 1, yScale: 1 });
const imgRef = ref(null);
const activeSVGPaths = computed(() => {
  return svgObjects.value.filter(svgObj => svgObj.isOn).map(svgObj => svgObj.svgPath)
});
console.log(activeSVGPaths)
const visible = ref(false);
const tooltipX = ref(0);
const tooltipY = ref(0);
const onMousesvg = (index, event) => {
  svgObjects.value[index].toggle();

  if (!child.value) {
    console.error('Child element is not available');
    return; // 如果元素不可用，则直接返回
  }
  // 设置tooltip的位置
  tooltipX.value = event.clientX - childRect.value.left;
  tooltipY.value = event.clientY - childRect.value.top;

  // 显示tooltip
  visible.value = !visible.value;
};
const outMousesvg = (index) => {
  svgObjects.value[index].toggle();
  visible.value = !visible.value;
};

const adjustImageSize = () => {
  const imgElement = imgRef.value;
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
  imageSize.value = {
    width: img.offsetWidth,
    height: img.offsetHeight,
    realWidth: img.naturalWidth,
    realHeight: img.naturalHeight,
    xScale: img.offsetWidth / img.naturalWidth,
    yScale: img.offsetHeight / img.naturalHeight,
    left: img.offsetLeft,
    top: img.offsetTop
  };
};

const getImageCenter = () => {
  return {
    x: this.imageSize.width / 2,
    y: this.imageSize.height / 2,
  };
};

const getSvgCenter = (index) => {
  const svgElement = this.$refs[`svgElementRef-${index}`][0];
  if (svgElement) {
    const { left, top, width, height } = svgElement.getBoundingClientRect();
    return {
      x: left + width / 2,
      y: top + height / 2,
    };
  }
  return null;
};



</script>

<template>
  <div ref="child" class="container" :style="{ position: 'relative' }">
    <!-- 渲染图片 -->
    <img ref="imgRef" :src="image_url" alt="..." width=1080px height=1440px />
    <!-- 渲染SVG，根据imageSize进行缩放和定位 -->
    <!-- 渲染tooltip -->
    <div v-if="visible"
         :style="{ position: 'absolute', top: `${tooltipY}px`, left: `${tooltipX}px`, padding: '10px', background: 'white', border: '1px solid black', borderRadius: '5px', display: 'block' }">
      <span>Tooltip</span>
    </div>
    <svg :width="imageSize.width" :height="imageSize.height" :view-box="`0 0 1080px 1440px`"
      xmlns="http://www.w3.org/2000/svg"
      :style="{ position: 'absolute', left: `${imageSize.left}px`, top: `${imageSize.top}px` }">

      <path v-for="(path, index) in activeSVGPaths" :key="index" :d="path" stroke="black" fill="none" stroke-width="2">
      </path>
      <path v-for="(svgData, index) in svgObjects" :key="`overlay-${index}`" :d="svgData.svgPath" fill="transparent" fill-opacity="0"
        style="cursor: pointer;" @mouseover="onMousesvg(index, $event)" @mouseout="outMousesvg(index)">
      </path>
    </svg>

  </div>
</template>

<style>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>