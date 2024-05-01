import {createRouter, createWebHistory} from 'vue-router'
import marking from '@/views/marking.vue'
import index from '@/views/index.vue'


const routes = [
    {path: '/', component: index},
    {path: '/marking', component: marking}
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
}) 

export default router