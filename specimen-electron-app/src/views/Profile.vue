<template>
  <div class="profile-container">
    <header class="profile-header">
      <div class="avatar-placeholder">
        <img src="../assets/photo/touxiang.jpg" alt="Feature"/>
      </div>
      <div class="user-info">
        <p class="name">姓名</p>
        <p class="school">学校</p>
      </div>
    </header>
    <section class="membership">
      <div class="membership-info">
        开通解剖会员<br/>
        升级会员立享所有付费功能
      </div>
      <div class="membership-price">最低 0.1 / 天</div>
    </section>
    <section class="menu">
      <div class="menu-item">收藏</div>
      <div class="menu-item">成绩与错题</div>
      <div class="menu-item">机构</div>
      <div class="menu-item">企业认证</div>
      <div class="menu-item">帮助与反馈</div>
      <div class="menu-item">版本信息</div>
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
  background-color: #ecf0f1;
  color: black;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.profile-header {
  border-bottom: 1px solid #bdc3c7;
  display: flex;
  align-items: center;
  padding: 20px;
  width: 100%;
  background-color: #ecf0f1;
  justify-content: flex-start;

  .user-info {
    display: flex;
    flex-direction: column;

    .name {
      font-size: 20px;
      font-weight: bold;
    }

    .school {
      font-size: 16px;
    }
  }
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

.avatar-placeholder img {
  width: 100%;
  height: 100%;
  object-fit: cover; /* 使用 cover 可以保持图片的宽高比 */
  border-radius: 50%; /* 使图片变为圆形 */
}

.membership {
  width: 90%;
  background-color: #f39c12;
  color: #ecf0f1;
  padding: 15px;
  border-radius: 10px;
  margin: 10px 0;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.membership-info {
  flex-grow: 1;
}

.membership-price {
  background-color: #e67e22;
  padding: 5px 10px;
  border-radius: 5px;
}

.menu {
  width: 90%;
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin-bottom: 20px;
}

.menu-item {
  border: 1px solid black;
  background-color: #ecf0f1;
  padding: 15px;
  border-radius: 10px;
  display: flex;
  align-items: center;
}
</style>
