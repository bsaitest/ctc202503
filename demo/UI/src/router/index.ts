import { createRouter, createWebHistory } from 'vue-router';
import LoginStub from '../components/LoginStub.vue';
import SearchTop from '../components/SearchTop.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: LoginStub
    },
    {
      path: '/search',
      component: SearchTop
    }
  ]
});

export default router;