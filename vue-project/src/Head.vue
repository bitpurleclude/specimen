<template>
    <div data-v-0a9bf5fc="" class="el-page-header el-page-header--has-extra"><!--v-if-->
        <div class="el-page-header__header">
            <div class="el-page-header__left">
              <div class="el-page-header__content">
                <div data-v-0a9bf5fc="" class="content">
                  <el-icon style="margin-right: 10px;">
                  <img src="/photo/logo.jpg" style="width: 50px; height: 50px;">
                </el-icon>
                  <span>科技之躯</span> <!-- 添加的项目名称 -->
                </div>
              </div>
                <div class="el-page-header__content">
                    <div data-v-0a9bf5fc="" class="content"><span data-v-0a9bf5fc=""
                            class="el-avatar el-avatar--circle mr-3" style="--el-avatar-size: 40px;"><img
                                src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" alt="头像"
                                style="object-fit: cover;"></span><span data-v-0a9bf5fc=""
                            class="text-large font-600 mr-3">
                            游客 </span><span data-v-0a9bf5fc="" class="text-sm mr-2"
                            style="color: var(--el-text-color-regular);"> 查看标本 </span><span data-v-0a9bf5fc=""
                            class="el-tag el-tag--primary el-tag--light"><span
                                class="el-tag__content">查看</span><!--v-if--></span>
                    </div>
                </div>
            </div>

            <div class="el-page-header__extra">
                <div data-v-0a9bf5fc="" class="flex items-center"><button data-v-0a9bf5fc="" aria-disabled="false"
                        type="button" class="el-button" @click="tomarking"><!--v-if--><span class="">Print</span></button><button
                        data-v-0a9bf5fc="" aria-disabled="false" type="button"
                        class="el-button el-button--primary ml-2" @click="totext"><!--v-if--><span class="">Edit</span></button></div>
            </div>
              </div>
        </div><!--v-if-->


</template>

<script setup>
import { useRouter } from 'vue-router'
const router = useRouter()
const tomarking = () => {
    router.push('/marking')
}
const totext = () => {
    router.push('/text')
}
</script>

<style>
.el-page-header {
  margin: 0px;
  height: 100%;
  padding: 0;
}

.el-page-header__header {
  display: flex;
  margin: 0px;
  height: 100%;
  padding: 0%;
}

.el-page-header__left {
  display: flex;
  margin: 0px;
  height: 100%;
  padding: 0%;
  justify-content: space-between; /* 添加这个属性来分隔左右两边的元素 */
}

.content {
  display: flex;
  align-items: center;
  gap: 10px; /* 添加这个属性来给元素之间添加间距 */
}

.el-page-header__extra {
  display: flex;
  margin: 0px;
  height: 100%;
  padding: 0%;
  align-items: center;
}
</style>
<style scoped>
.content :deep(span) {
  display: flex;
  margin-right: 10px;
  margin-left: 10px;
}
</style>