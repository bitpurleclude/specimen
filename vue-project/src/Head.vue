<template>
    <el-page-header :icon="null">
        <template #content>
            <div class="content">
                <el-avatar :size="40" class="mr-3"
                    src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" alt="头像"/>
                <span class="text-large font-600 mr-3"> Title </span>
                <span class="text-sm mr-2" style="color: var(--el-text-color-regular)">
                    Sub title
                </span>
                <el-tag>Default</el-tag>
            </div>
        </template>
        <template #extra>
            <div class="flex items-center">
                <el-button @click="tomarking">Print</el-button>
                <el-button type="primary" class="ml-2">Edit</el-button>
            </div>
        </template>
    </el-page-header>
</template>

<script setup>
import { useRouter } from 'vue-router'
const router = useRouter()
const tomarking = () => {
    router.push('/marking')
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
}

.content {
    display: flex;
    align-items: center;
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