
<template>
  <div class="component-wrapper" :style="{ marginTop: marginTop }">
    <chat-container v-for="(userData) in userDatas" :userData="userData" class="chat-container-spacing" />/>
  </div>
</template>

<script>
import chatContainer from "@/components/chat-container.vue";
import componentWrapper from "@/components/component-wrapper.vue";

export default {
  data() {
    return {
      marginTop: '0px',
      userDatas:[
        {
          username: '匿名用户',
          avatarSrc: '\\微信图片_20240708213847.jpg',
          content: '真好，不用特意跑到实验室就可以看到真实标本啦！',
        },
        {
          username: '匿名用户',
          avatarSrc: '\\微信图片_20240708213842.jpg',
          content: '家有什么好的学习解剖学的方法吗？',
        },
        {
          username: '匿名用户',
          avatarSrc: '\\微信图片_20240708213850.jpg',
          content: '正中柿经损伤会造成什么？',
        },
      ],
    }
  },
  components: {
    componentWrapper,
    chatContainer
  },
  mounted() {
    this.$nextTick(() => {
      const topNavHeight = document.querySelector('.top-nav').offsetHeight;
      this.marginTop = `${topNavHeight}px`;
    });
  }
}

</script>

<style scoped>
.chat-container-spacing {
  margin-bottom: 10px;
}
</style>