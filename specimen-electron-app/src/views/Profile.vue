<template>
  <div class="profile-container">
    <header class="profile-header">
      <div class="avatar-placeholder">Avatar</div>
      <div class="user-info">
        <p>万康人体解剖ID: liNuuuSr</p>
      </div>
    </header>
    <section class="menu">
      <div class="menu-item">我的收藏</div>
      <div class="menu-item">微信交流群</div>
      <div class="menu-item">QQ交流群</div>
      <div class="menu-item">客服微信</div>
      <div class="menu-item">反馈建议</div>
      <div class="menu-item">其他设置</div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'Home'
}
</script>

<style>
.profile-container {
  font-family: Arial, sans-serif;
  background-color: #2c3e50;
  color: #ecf0f1;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.profile-header {
  display: flex;
  align-items: center;
  padding: 20px;
  width: 100%;
  background-color: #34495e;
}

.avatar-placeholder {
  width: 50px;
  height: 50px;
  background-color: #bdc3c7;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-right: 10px;
}

.user-info {
  display: flex;
  flex-direction: column;
}

.menu {
  width: 90%;
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin-bottom: 20px;
}

.menu-item {
  background-color: #34495e;
  padding: 15px;
  border-radius: 10px;
  display: flex;
  align-items: center;
}
</style>
