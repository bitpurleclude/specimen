import {createRouter, createWebHistory} from 'vue-router'
import marking from '@/views/marking.vue'
import index from '@/views/index.vue'
import text from '@/views/text.vue'


const routes = [
    {path: '/', component: index},
    {path: '/marking', component: marking},
    {path: '/text', component: text}
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
}) 

export default router