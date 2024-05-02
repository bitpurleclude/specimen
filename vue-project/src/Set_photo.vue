<script setup>
import { getallService, getjpgService } from '@/api/service.js'
import Show_photo from './Show_photo.vue';
import { ref, computed } from 'vue';
import { useStore } from 'vuex';
import url from '@/photo/背面（原图）.jpg'

const All = ref([]);
const img = ref([]);
const src = ref([]);
const getimage = async function () {
  for (let i = 0; i < img.value.length; i++) {
    if (img.value[i] == null) continue;
    let data = await getjpgService(img.value[i]);
    let image = document.createElement('img');
    image.src = URL.createObjectURL(data);
    src.value.push(image.src);
  }
  console.log(src.value);
  if (src.value[0] == null) {
    src.value[0] = url;
    img.value[0] = 11;
  }
}//获取图片函数
const getimformation = async function () {
  let data = await getallService();
  All.value = data;
  for (let i = 0; i < 6; i++) {
    if (All.value[i] != null) { img.value.push({ imgId: All.value[i].id }); }
    else { img.value.push({ imgId: null }); }
  }//获取图片id
  getimage();
}//获取信息函数
getimformation();
//console.log(src.value);

//声明一个点击事件
const store = useStore();
const handleClick = (index) => {
  console.log('click');
  selectedImageIndex.value = img[index];
  store.commit('setGlobalVar', true);
};

const selectedImageIndex = ref(-1); // 初始未选择
const singleView = computed(() => {
  return store.state.globalVar;
});  // 是否处于单张图片展示模式
</script>

<template>
  <el-col v-if="!singleView">
    <el-row>
      <el-col :span="6" class="photo">
        <img v-if="src[0] != null" :src="src[0]" alt="" @click="handleClick(0)" class="image-container">
        <div class="grid-content ep-bg-purple" />
      </el-col>
      <el-col :span="6" class="photo">
        <img v-if="src[1] != null" :src="src[1]" alt="" @click="handleClick(1)" class="image-container">
        <div class="grid-content ep-bg-purple" />
      </el-col>
      <el-col :span="6" class="photo">
        <img v-if="src[2] != null" :src="src[2]" alt="" @click="handleClick(2)" class="image-container">
        <div class="grid-content ep-bg-purple" />
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6" class="photo">
        <img v-if="src[3] != null" :src="src[3]" alt="" @click="handleClick(3)" class="image-container">
        <div class="grid-content ep-bg-purple" />
      </el-col>
      <el-col :span="6" class="photo">
        <img v-if="src[4] != null" :src="src[4]" alt="" @click="handleClick(4)" class="image-container">
        <div class="grid-content ep-bg-purple" />
      </el-col>
      <el-col :span="6" class="photo">
        <img v-if="src[5] != null" :src="src[5]" alt="" @click="handleClick(5)" class="image-container">
        <div class="grid-content ep-bg-purple" />
      </el-col>
    </el-row>
  </el-col>
  <div v-else class="single">
    <Show_photo :id="selectedImageIndex" />
  </div>
</template>

<style>
.el-row {
  display: flex;
  height: 50%;
  width: 100%;
  align-content: center;
}

.el-row:last-child {
  margin-bottom: 0;
}

.el-col {
  border-radius: 4px;
  height: 100%;
  width: 100%;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.photo {
  display: flex;
  height: 100%;
  width: 100px;
  justify-content: center;
  align-items: center;
}

.single {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  width: 100%;
}

.image-container {
  max-width: 100%;
  max-height: 100%;
  cursor: pointer;
}
</style>