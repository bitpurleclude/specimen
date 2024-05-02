import './assets/main.css'
import 'element-plus/dist/index.css'

import ElementPlus from 'element-plus'
import { createApp } from 'vue'
import App from './App.vue'
import router from '@/router/index.js'
import VTooltip from 'v-tooltip'
import store from '@/data/All.js'


const app = createApp(App)
app.use(router)
app.use(VTooltip)
app.use(ElementPlus)
app.use(store)
app.mount('#app')
