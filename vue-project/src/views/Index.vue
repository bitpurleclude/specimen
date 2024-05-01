<script setup>
import { ref } from 'vue'
import Set_photo from '../Set_photo.vue';
import Head from '../Head.vue'
</script>

<template>
  <div class="common-layout">
    <el-container class="down-divider">
      <el-header>

        <Head />
      </el-header>
      <el-container class="lr-divider">
        <el-aside>Aside</el-aside>
        <el-main>
          <div class="demo-image__preview">
            <Set_photo />
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style>
html,
body,
#app {
  padding: 0;
  margin: 0;
  width: 100%;
  height: 100%;
  max-width: none;
}

.down-divider>:not(:last-child) {
  border-bottom: 1px solid #ffffff55;
  /* 使用白色边框作为分割线 */
}

.lr-divider>:not(:last-child) {
  border-right: 1px solid #ffffff55;
  /* 使用白色边框作为分割线 */
}

.common-layout {
  width: 200%;
}

.el-container {
  margin: 0px;
  height: 100%;
}

.el-header {
  padding: 0;
}

.el-main {
  display: flex;
  padding: 0%;
}

.el-aside,
.el-footer {
  display: flex;
  padding: 0%;
  justify-content: center;
  /* 垂直居中 */
  align-items: center;
  /* 水平居中所有内容 */
}

.demo-image__preview {
  position: relative;
  z-index: 1;
  width: 100%;
  height: 100%;
}
</style>