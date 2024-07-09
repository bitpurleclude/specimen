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
        <div class="grid-item">
          <div class="image-placeholder">虚拟图片/div>
            <div class="label">虚拟标本</div>
            <div class="image-placeholder">肝脏图片</div>
            <div class="label">病理变化</div>
          </div>
        </div>
      </section>
      <section class="icon-grid">
        <div class="icon-item">微观解剖</div>
        <div class="icon-item">肌肉运动</div>
        <div class="icon-item">断层解剖</div>
        <div class="icon-item">医学动画</div>
        <div class="icon-item">口腔解剖</div>
        <div class="icon-item">肌肉供血</div>
        <div class="icon-item">神经支配</div>
        <div class="icon-item">解剖测验</div>
      </section>
    </main>
  </div>
</template>

<script>
export default {
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

.icon-item {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #ecf0f1;
  padding: 10px;
  border-radius: 10px;
}

footer {
  display: flex;
  justify-content: space-around;
  padding: 10px;
  background-color: #2c3e50;
}

.footer-item {
  color: white;
}
</style>
