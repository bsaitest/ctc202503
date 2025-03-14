import { createRouter, createWebHistory } from 'vue-router';
import LoginStub from '../components/LoginStub.vue';
import SearchTop from '../components/SearchTop.vue';
import S1 from '../components/S1.vue';
import S2 from '../components/S2.vue';
import S3 from '../components/S3.vue';
import C20 from '../components/C20.vue';
import C22 from '../components/C22.vue';
import C10 from '../components/C10.vue';
import C221 from '../components/C221.vue';
import C222 from '../components/C222.vue';
import Lmsscs0100 from '../components/lmsscs0100/Lmsscs0100.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: Lmsscs0100
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
    },
    {
      path: '/c221',
      component: C221
    },
    {
      path: '/c222',
      component: C222
    },
    {
      path: '/lmsscs0100',
      component: Lmsscs0100
    }
  ]
});

export default router;