<template>
  <div class="specimen-display">
    <div class="img">
      <img :src="Url" alt="specimen"/>
    </div>
    <p>{{ Name }}</p>
  </div>
</template>

<script>
export default {
  name: "specimen-display",
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
.specimen-display {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: 20px;
}
.img {
  width: 200px;
  height: 200px;
  overflow: hidden;
  margin-bottom: 10px;
  border-radius: 10px;
}
.img img{
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>