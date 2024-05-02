<template>
  <div ref="svgContainer" style="position: relative;">
    <svg :width="300" :height="300" viewBox="0 0 300 300">
      <path
        v-for="(path, index) in paths"
        :key="index"
        :d="path.d"
        stroke="black"
        fill="none"
        stroke-width="2"
        @mouseover="showTooltip($event, path.info)"
        @mouseout="hideTooltip"
      />
    </svg>
    <div
      v-if="tooltipVisible"
      :style="{ position: 'absolute', top: tooltipPosition.y + 'px', left: tooltipPosition.x + 'px', padding: '10px', background: 'white', border: '1px solid black', borderRadius: '5px', display: 'block' }"
    >
      {{ tooltipContent }}
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue';

const paths = ref([
  { d: 'M10 80 C 40 10, 65 10, 95 80 S 150 150, 180 80', info: 'Bezier Curve' },
  { d: 'M20,230 A1,1 0 0,0 50,230 A1,1 0 0,0 20,230 Z', info: 'Circle' }
]);

const tooltipVisible = ref(false);
const tooltipContent = ref('');
const tooltipPosition = reactive({ x: 0, y: 0 });

const showTooltip = (event, info) => {
  tooltipPosition.x = event.clientX + 10;
  tooltipPosition.y = event.clientY + 10;
  tooltipContent.value = info;
  tooltipVisible.value = true;
};

const hideTooltip = () => {
  tooltipVisible.value = false;
};

const svgContainer = ref(null);
</script>

<style scoped>
/* 这里可以加入你的 CSS 样式 */
</style>
