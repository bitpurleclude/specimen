<script setup>
import svgshow from './Svgshow.vue'
import src from '@/1.jpg'
const srcList = [
  src,
  'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg',
  'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
  'https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg',
  'https://fuss10.elemecdn.com/d/e6/c4d93a3805b3ce3f323f7974e6f78jpeg.jpeg',
  'https://fuss10.elemecdn.com/3/28/bbf893f792f03a54408b3b7a7ebf0jpeg.jpeg',
  'https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg',
]
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside>Aside</el-aside>
        <el-container>
          <el-main>

            <div class="demo-image__preview">
              <el-image style="width: 200px; height: 200px" :src="src" :zoom-rate="1.2" :max-scale="7" :min-scale="0.2"
                :preview-src-list="srcList" :initial-index="4" fit="cover" />
            </div>
          </el-main>
          <el-footer>Footer</el-footer>
        </el-container>
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

.common-layout {
  width: 200%;
}

.el-container {
  margin: 0px;
  height: 100%;
}

.el-main,
.el-header,
.el-aside,
.el-footer {
  display: flex;
  padding: 0%;
  justify-content: center;
  /* 垂直居中 */
  align-items: center;
  /* 水平居中所有内容，包括 svgshow 组件 */
}

.demo-image__preview {
  width: 100px;
  height: 100px;
}
</style>