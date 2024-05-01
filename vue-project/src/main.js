import './assets/main.css'
import 'element-plus/dist/index.css'

import ElementPlus from 'element-plus'
import { createApp } from 'vue'
import App from './App.vue'
import router from '@/router/index.js'
import VTooltip from 'v-tooltip'



const app = createApp(App)
app.use(router)
app.use(VTooltip)
app.use(ElementPlus)
app.mount('#app')
