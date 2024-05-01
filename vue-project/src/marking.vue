
<template>
  <div>
    <input type="file" @change="handleFileUpload">
    <img v-if="imageUrl" :src="imageUrl" alt="Preview">
    <div v-for="(svgObject, index) in svgObjects" :key="index" v-html="svgObject.svgPath" v-tooltip="svgObject.name"></div>
  </div>
</template>

<script setup>
import Vue from 'vue'
import VTooltip from 'v-tooltip'

Vue.use(VTooltip)

import { ref } from 'vue';

const imageUrl = ref(null);
const svgPaths = ref([]);

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
const getSvgPaths = () =>{
  fetch('/api/svg-paths')
      .then(response => response.json())
      .then(data => {
        svgPaths.value = data;
      });

}

</script>

<style scoped>

</style>