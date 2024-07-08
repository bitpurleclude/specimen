<template>
  <div class="chat-container">
    <div class="top-bar">
      <!-- Use prop for the avatar image source -->
      <img :src="userData.avatarSrc" alt="Avatar" class="avatar">
      <!-- Use prop for the username -->
      <span class="username">{{ userData.username }}</span>
    </div>
    <div class="content-area">
      <!-- Use prop for the content text -->
      <p>{{ userData.content }}</p>
    </div>
    <div class="bottom-bar">
      <button class="like-btn">
        <FontAwesomeIcon :icon="['fas', 'thumbs-up']" /> 点赞
      </button>
      <button class="share-btn">
        <FontAwesomeIcon :icon="['fas', 'share']" /> 转发
      </button>
    </div>
  </div>
</template>

<script>
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'
import {library} from '@fortawesome/fontawesome-svg-core'
import { faThumbsUp, faShare } from '@fortawesome/free-solid-svg-icons'
library.add(faThumbsUp, faShare)

export default {

  name: 'CustomComponent',
  components: {FontAwesomeIcon},
  // Define a prop to accept the external object
  props: {
    userData: {
      type: Object,
      required: true,
      default: () => ({
        avatarSrc: '',
        username: '用户名',
        content: ''
      })
    }
  }
}
</script>

<style scoped>
/* 原有样式保持不变，添加媒体查询进行响应式调整 */
@media (max-width: 600px) {
  .top-bar, .bottom-bar {
    padding: 5px;
  }

  .avatar {
    width: 40px;
    height: 40px;
  }

  .username {
    font-size: 16px;
  }

  .like-btn, .share-btn {
    padding: 5px 10px;
    font-size: 14px;
  }
}
.chat-container {
  display: flex;
  flex-direction: column;
  border: 2px solid #333; /* 添加的大边框 */
}
.top-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
}

.avatar {
  width: 50px;
  height: 50px;
  border-radius: 50%;
}

.username {
  font-size: 15px;
}
.top-bar, .bottom-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
}
.content-area {
  flex-grow: 1;
  padding: 20px;
}

.bottom-bar {
  display: flex;
  justify-content: space-around;
  padding: 10px;
}

.like-btn, .share-btn {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.like-btn {
  background-color: white;
  color: black;
}

.share-btn {
  background-color: white;
  color: black;
}
</style>