import {createRouter, createWebHistory} from 'vue-router'
import Learn from '../views/Learn.vue'
import Discover from '../views/Discover.vue'
import Home from '../views/Home.vue'
import Profile from '../views/Profile.vue'
import Anatomy from "@/views/Anatomy.vue";
import AlternatingCurrent from "@/views/AlternatingCurrent.vue";
import RealSample from "../views/RealSample.vue";
import sport from "../views/Sport.vue";
import Pathology from "@/views/Pathology.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {path: '/', name: 'home', component: Home},
        {
            path: '/learn',
            name: 'learn',
            component: Learn,
            children: [
                {path: 'anatomy', name: 'learn-anatomy', component: Anatomy},
                {path: 'pathology', name: 'learn-pathology', component: Pathology}
            ]
        },
        {
            path: '/discover',
            name: 'discover',
            component: Discover,
            children: [
                {path: 'alternating-current', name: 'discover-alternating-current', component: AlternatingCurrent}
            ]
        },
        {path: '/profile', name: 'profile', component: Profile},
        {
            path: '/realSample', name: 'realSample', component: RealSample, children: [
                {path: '/sport', name: 'sport', component: sport}
            ]
        },
    ]
})

export default router
