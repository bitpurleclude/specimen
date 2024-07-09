<template>
  <div class="component-wrapper" :style="{ marginTop: marginTop }">
    <componentWrapper v-for="(item, index) in items" :key="index" :text="item.text" :icon="item.iconClass"/>
    <GameContainer>
      <img-bottom :icon="['fas', 'gamepad']" text="解趣坊" class="icon-button1"/>
      <img-bottom :src="src1" text="智剖界"  class="icon-button2"/>
      <img-bottom :icon="['fas', 'brain']" text="脑旅途" class="icon-button3" />
      </GameContainer >
  </div>

</template>
<script>
import componentWrapper from "@/components/component-wrapper.vue";
import GameContainer from "@/components/game-container.vue";
import imgBottom from "@/components/img-bottom.vue";
import { library } from '@fortawesome/fontawesome-svg-core'
import { faGamepad } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faBook } from '@fortawesome/free-solid-svg-icons'
import { faFileAlt } from '@fortawesome/free-solid-svg-icons'
import { faChalkboardTeacher } from '@fortawesome/free-solid-svg-icons'
import { faBrain } from '@fortawesome/free-solid-svg-icons';

library.add(faBrain);
library.add(faChalkboardTeacher)
library.add(faFileAlt)
library.add(faBook)
library.add(faGamepad)
export default {
  components: {
    FontAwesomeIcon,
    componentWrapper,
    GameContainer,
    imgBottom,
  },
  data() {
    return {
      src1: '\\手术刀2f.png',
      items: [
        {
          text: '线上课程',
          iconClass: {
            prefix: 'fas', // 图标的样式前缀
            iconName: 'chalkboard-teacher'
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
.icon-button3 {
  display: inline-flex;
  align-items: center;
  padding: 8px 16px;
  border: 1px solid blue; /* Set border color to blue */
  background-color: #f0f0f0;
  cursor: pointer;
  border-radius: 4px;
  color: blue; /* Set text color to blue */
  height: 80%; /* Set height to 80% of the container */
}

.icon-button3:hover {
  background-color: #e0e0e0;
}
.icon-button2{
  display: inline-flex;
  align-items: center;
  padding: 8px 16px;
  border: 1px solid #ff7700; /* Set border color to blue */
  background-color: #f0f0f0;
  cursor: pointer;
  border-radius: 4px;
  color: #ff8000; /* Set text color to blue */
}

.icon-button2:hover {
  background-color: #e0e0e0;
}
.icon-button1{
  display: inline-flex;
  align-items: center;
  padding: 8px 16px;
  border: 1px solid #3baa10; /* Set border color to blue */
  background-color: #f0f0f0;
  cursor: pointer;
  border-radius: 4px;
  color: #3baa10; /* Set text color to blue */
}

.icon-button1:hover {
  background-color: #e0e0e0;
}
</style>