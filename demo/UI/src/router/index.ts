import { createRouter, createWebHistory } from 'vue-router';
import LoginStub from '../components/LoginStub.vue';
import SearchTop from '../components/SearchTop.vue';
import S1 from '../components/S1.vue';
import S2 from '../components/S2.vue';
import S3 from '../components/S3.vue';
import C20 from '../components/C20.vue';
import C22 from '../components/C22.vue';
import C10 from '../components/C10.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: LoginStub
    },
    {
      path: '/login',
      component: LoginStub
    },
    {
      path: '/search',
      component: SearchTop
    },
    {
      path: '/s1',
      component: S1
    },
    {
      path: '/s2',
      component: S2
    },
    {
      path: '/s3',
      component: S3
    },
    {
      path: '/c10',
      component: C10
    },
    {
      path: '/c20',
      component: C20
    },
    {
      path: '/c22',
      component: C22
    }
  ]
});

export default router;