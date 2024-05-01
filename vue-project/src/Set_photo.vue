<script setup>
import Show_photo from './Show_photo.vue';
import { ref, onMounted } from 'vue';
import src from '@/photo/背面（原图）.jpg';
//声明一个点击事件
const url =ref(src);
const handleClick = (index) => {
  console.log('click');
  selectedImageIndex.value = index;
  singleView.value = true;
};
const selectedImageIndex = ref(-1); // 初始未选择
const singleView = ref(false); // 是否处于单张图片展示模式
</script>

<template>
  <el-col v-if="!singleView">
    <el-row>
      <el-col :span="6" class="photo">
        <img :src="url" alt="" @click="handleClick(1)" class="image-container">
      </el-col>
      <el-col :span="6" class="photo">
        <div class="grid-content ep-bg-purple" />
      </el-col>
      <el-col :span="6" class="photo">
        <div class="grid-content ep-bg-purple" />
      </el-col>
      <el-col :span="6" class="photo">
        <div class="grid-content ep-bg-purple" />
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6" class="photo">
        <div class="grid-content ep-bg-purple" />
      </el-col>
      <el-col :span="6" class="photo">
        <div class="grid-content ep-bg-purple" />
      </el-col>
      <el-col :span="6" class="photo">
        <div class="grid-content ep-bg-purple" />
      </el-col>
      <el-col :span="6" class="photo">
        <div class="grid-content ep-bg-purple" />
      </el-col>
    </el-row>
  </el-col>
  <div v-else class="single">
    <Show_photo/>
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

.single{
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