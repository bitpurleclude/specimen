<template>
  <div class="pictures-descriptions">
    <div class="img">
      <img :src="Url" alt="specimen"/>
    </div>
    <!--固定一块区域用于显示文本，避免因为文本长度不同导致图片位置被改变-->
    <div style="width: 100px;">
      <p>{{ Name }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "pictures-descriptions",
  props: {
    url: {
      type: String,
      default: ''
    },
    name: {
      type: String,
      default: ''
    },
  },
  data() {
    return {
      Url: '',
      Name: ''
    }
  },
  mounted() {
    this.Url = this.url
    this.Name = this.name
  }
}
</script>

<style scoped>
.pictures-descriptions {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  margin: 20px;
}

.img {
  width: 200px;
  height: 150px;
  overflow: hidden;
  border-radius: 10px;
  margin-right: 100px;
}

.img img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>