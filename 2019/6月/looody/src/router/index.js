import Vue from 'vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';
import goods from '../components/goods/goods';
import ratings from '../components/ratings/ratings';
import seller from 'components/seller/seller';
import orderdetail from 'components/orderdetail/orderdetail';
import userorder from 'components/userorder/userorder';
import pay from 'components/pay/pay';
import useradd from '../components/useradd/useradd';
import newaddress from 'components/modifyaddr/modifyadd';
import rating from 'components/rating/rating';

Vue.use(VueRouter);
Vue.use(VueResource);

Vue.config.productionTip = false;

export default new VueRouter({
  mode: 'history',
  linkActiveClass: 'active',
  routes: [
    {
      path: '/',
      component: goods
    },
    {
      path: '/goods',
      component: goods
    },
    {
      path: '/ratings',
      component: ratings
    },
    {
      path: '/seller',
      component: seller
    },
    {
      path: '/orderdetail',
      component: orderdetail
    },
    {
      path: '/userorder',
      component: userorder
    },
    {
      path: '/pay',
      component: pay
    },
    {
      path: '/useradd',
      component: useradd
    },
    {
      path: '/newaddress',
      component: newaddress
    },
    {
      path: '/rating',
      component: rating
    }
  ]
});
