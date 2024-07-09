<template>
  <div class="app-container">
    <header>
      <input type="text" placeholder="输入关键词搜索"/>
    </header>
    <main>
      <section class="feature">
        <div class="image-placeholder">Image Placeholder</div>
        <div class="description">手术模拟-椎间盘置换</div>
      </section>
      <section class="content-grid">
        <div class="grid-item">
          <div class="image-placeholder">真实图片</div>
          <div class="label">真实标本</div>
        </div>
        <div class="right">
          <div class="grid-item" style="margin-bottom: 5px">
            <div class="image-placeholder">虚拟图片</div>
            <div class="label">虚拟标本</div>
          </div>
          <div class="grid-item">
            <div class="image-placeholder">肝脏图片</div>
            <div class="label">病理变化</div>
          </div>
        </div>
      </section>
      <section class="icon-grid">
        <icon Icon="yixueyingxiangke" text="影像"></icon>
        <icon Icon="zhongyike" text="中医"></icon>
        <icon Icon="kouqiangke" text="口腔"></icon>
        <icon Icon="shoushu" text="互动手术"></icon>
        <icon Icon="shenjing" text="神经支配"></icon>
        <icon Icon="xieye" text="血液循环"></icon>
        <icon Icon="jirou" text="肌肉运动"></icon>
        <icon Icon="renshenpregnancy" text="妊娠过程"></icon>
      </section>
    </main>
  </div>
</template>

<script>
import "@/assets/icon/iconfont.js"
import icon from "@/components/icon.vue";

export default {
  components: {
    icon
  },
  name: 'App'
}
</script>

<style>
.app-container {
  font-family: Arial, sans-serif;
}

header {
  display: flex;
  justify-content: center;
  padding: 10px;
  background-color: #2c3e50;
}

header input {
  width: 80%;
  padding: 10px;
  border-radius: 5px;
  border: none;
}

main {
  padding: 10px;
}

.feature {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #ecf0f1;
  padding: 10px;
  border-radius: 10px;
  margin-bottom: 10px;
}

.image-placeholder {
  width: 100%;
  height: 150px;
  background-color: #bdc3c7;
  display: flex;
  justify-content: center;
  align-items: center;
}

.description {
  margin-top: 10px;
  font-size: 18px;
}

.content-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 10px;
}

.grid-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #ecf0f1;
  padding: 10px;
  border-radius: 10px;

  .right {
    display: flex;
    flex-direction: column;
  }
}

.label {
  margin-top: 10px;
}

.icon-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 10px;
  margin-top: 20px;
}

footer {
  display: flex;
  justify-content: space-around;
  padding: 10px;
  background-color: #2c3e50;
}

</style>
