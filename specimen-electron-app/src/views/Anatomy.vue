<template>
  <div class="component-wrapper" :style="{ marginTop: marginTop }">
    <componentWrapper v-for="(item, index) in items" :key="index" :text="item.text" :icon="item.iconClass"/>
  </div>

</template>
<script>
import componentWrapper from "@/components/component-wrapper.vue";
import { library } from '@fortawesome/fontawesome-svg-core'
import { faGamepad } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faBook } from '@fortawesome/free-solid-svg-icons'
import { faFileAlt } from '@fortawesome/free-solid-svg-icons'
import { faChalkboardTeacher } from '@fortawesome/free-solid-svg-icons'

library.add(faChalkboardTeacher)
library.add(faFileAlt)
library.add(faBook)
library.add(faGamepad)
export default {
  components: {
    FontAwesomeIcon,
    componentWrapper,
  },
  data() {
    return {
      items: [
        {
          text: '线上课程',
          iconClass: {
            prefix: 'fas', // 图标的样式前缀
            iconName: 'chalkboard-teacher'
          }
        },
        {
          text: '闯关游戏',
          iconClass: {
            prefix: 'fas', // 图标的样式前缀
            iconName: 'gamepad'
          }
        },
        {
          text: '作业',
          iconClass: {
            prefix: 'fas', // 图标的样式前缀
            iconName: 'book'
          }
        },
        {
          text: '考试',
          iconClass: {
            prefix: 'fas', // 图标的样式前缀
            iconName: 'file-alt'
          }
        }],
      marginTop: '0px'
    };
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
</style>