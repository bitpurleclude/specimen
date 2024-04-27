<script setup>
import {onMounted, ref,withDefaults} from 'vue'
const svgData = ref("M360 226 L360 225 L359 225 L358 224 L356 224 L352 223 L346 223 L337 223 L324 225 L313 227 L304 230 L292 234 L280 238 L267 243 L256 248 L248 252 L242 258 L236 264 L236 267 L235 274 L234 283 L234 290 L234 291 L235 299 L236 302 L236 303 L240 310 L247 316 L250 318 L251 318 L256 320 L264 321 L274 322 L285 323 L295 323 L307 323 L317 323 L329 322 L337 321 L349 320 L357 318 L367 317 L373 316 L380 314 L384 312 L388 310 L390 307 L392 304 L393 301 L394 298 L394 294 L394 289 L394 285 L394 280 L394 275 L393 268 L392 266 L392 265 L389 259 L387 253 L383 247 L381 243 L378 240 L376 238 L375 236 L374 236 L373 235 L372 235 L371 235 L370 235 L369 235 L368 235 L367 235 L366 235 L365 234 L364 234 L363 234 L362 234 L362 233 L361 233 L360 233 L360 232 L359 231 L358 230 L357 230 L356 229 L355 229 L355 228 L354 228 L353 228 L352 228 L352 228 L351 228 L350 228 L349 228 L348 228 L347 228 L346 227 L345 227 L344 226 L343 226 L342 226 L341 225 L340 224 L339 224 L338 223 L337 222 L336 222 L336 222 L335 222 L334 222")
const el = ref(null)
//获取父组件img原本大小
const props = withDefaults(defineProps({
  imgRef: Object
}), {
  imgRef: null
});
const imageSize = ref({left:0,top:0, width: 0, height: 0 ,realWidth: 0, realHeight: 0,xScale: 1, yScale: 1});
const imgSize=() => {
  const imgElement = props.imgRef.value.$el.querySelector('img');
  if (imgElement) {
    const img = new Image();
    img.onload = function() {
      imageSize.value = {
        width: this.width,
        height: this.height,
        realWidth: imgElement.width,
        realHeight: imgElement.height,
        xScale: imgElement.width/this.width,
        yScale: imgElement.height/this.height,
        left: imgElement.offsetLeft,
        top: imgElement.offsetTop
      };
    }
    img.src = imgElement.src;
  }
}

onMounted(() => {
  imgSize();
});
</script>

<template>
  <svg :width="`${imageSize.realWidth}` ":height="`${imageSize.realHeight} `"xmlns="http://www.w3.org/2000/svg" :viewBox="`0 0 ${imageSize.realWidth} ${imageSize.realHeight}`">
    <g :transform="`translate(${imageSize.left},${imageSize.top}) scale(${imageSize.xScale},${imageSize.yScale})`">
      <path :d="svgData" stroke="black" fill="none" stroke-width="2"></path>
    </g>
  </svg>
</template>