<template>
  <div class="userorder" ref="orderWrapper">
    <div class="content">
      <div class="content-header">
        <div class="back" @click="hide">
          <i class="icon-arrow_lift"></i>
        </div>
        <div class="title">历史订单</div>
      </div>
      <div class="order-item">
        <ul>
          <li class="order" v-for="(item, index) in orderList" :key="index">
            <div class="order-content">
              <!--<img width="46px" height="46px" src="http://47.105.170.25/pictures/1.1.webp">-->
              <div class="order-one">
                <div class="order-info">
                  <h1 class="order_number">订单号:{{item.orderId}}</h1>
                  <span class="status" v-show="item.orderStatus>-1">{{OrderStatus(item.orderStatus)}}</span>
                </div>
                <div class="time">
                  {{item.createTime*1000 | formatDate}}
                </div>
              </div>
            </div>
            <ul>
              <li class="orderDetail border-1px" v-for="(o_item, index) in item.orderDetailList" :key="index">
                <img width="42" height="42" :src="o_item.productIcon">
                <div class="name">
                  <span class="text">{{o_item.productName}}</span>
                </div>
                <div class="price" ref="moneyWrapper">
                  <span class="count">*{{o_item.productQuantity}}</span>
                  <span>￥{{o_item.productPrice*o_item.productQuantity}}</span>
                </div>
              </li>
            </ul>
            <div class="extra-money">
              <div class="text">餐具+配送费</div>
              <div class="info">￥4.5</div>
            </div>
            <div class="payfor">
              <span class="pay-money">订单支付</span>
              <div class="pay-text">
                <span class="icon-pay">小计</span>
                <div class="money">
                  <span class="money-text">￥{{item.orderAmount + 1.5 + 3}}</span>
                </div>
                <!--<i class="icon-keyboard_arrow_right"></i>-->
              </div>
            </div>
            <div class="de-order">
              <div class="cancle-button" @click="cancelOrder(item, $event)" v-show="item.orderStatus!=1">
                <span class="cancle">{{displayOrderStatus(item.orderStatus)}}</span>
              </div>
              <!--<div class="continue-pay" v-if="item.payStatus=0?'去支付':'评价'">-->
                <!--<span class="pay">{{item.payStatus}}</span>-->
              <!--</div>-->
              <div class="continue-pay" @click="payClick(item, $event)">
                <span class="pay-user">{{displayRating(item.payStatus)}}</span>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import BScroll from 'better-scroll';
  import {formatDate} from '../../common/js/date';
  import util from '../../common/js/util.js';
  const ERR_OK = 0;

  export default {
    data() {
      return {
        orderList: [],
        money: []
      };
    },
    created() {
      this.classMap = ['取消订单', '订单已送达'];

      this.getUserorder();
    },
    computed: {
      // totalPrice(item) {
      //   var total = 0;
      //   console.log('fsjdkljsf');
      //   console.log(item.orderId);
      //   let data = this.orderList;
      //   total = total + 1.5 + 3;
      //   return total;
      // }
    },
    mounted() {
      this.openid = this.$route.query.openid;
    },
    methods: {
      getUserorder() {
         this.$http.get('http://dylxh.natapp1.cc/dylxh/buyer/order/list?openid=' + util.getCookie('openid')).then((response) => {
   //     this.$http.get('http://dylxh.natapp1.cc/dylxh/buyer/order/list?openid=456dsfsdgesr').then((response) => {
        response = response.body;
          console.log(response);
          if (response.code === ERR_OK) {
            this.orderList = response.data;
  //          console.log(this.orderList);
            this.$nextTick(() => {
              this._initScroll();
            });
          }
        });
      },
      cancelOrder(item, $event) {
        let orderId = item.orderId;
        this.$http.post('http://dylxh.natapp1.cc/dylxh/buyer/order/cancel?openid=' + util.getCookie('openid') + '&orderId=' + orderId).then((response) => {
          response = response.body;
     //     if (response.code === ERR_OK) {
     //      this.$route.push('/userorder');
     //      alert('订单已取消');
    //      }
        });
        alert('订单已取消');
        this.$router.push('/seller');
      },
      payClick(item, event) {
        if (!event._constructed) {
          return;
        }
  //      console.log('click' + item);
        if (item.payStatus === 0) {
          this.payFood(item);
        } else if (item.payStatus === 1) {
          this.ratingFood(item);
        }
      },
      payFood(food) {
        let orderId = food.orderId;
        this.$router.push({
          path: '/pay',
          query: {
            totalPrice: food.orderAmount + 1.5 + 3,
            openid: util.getCookie('openid'),
            orderId: orderId
          }
        });
      },
      ratingFood(food) {
        console.log(food.orderDetailList);
        var orderIdList = '';
        food.orderDetailList.forEach((item) => {
          orderIdList += item.productId + ',';
        });
        this.$router.push({
          path: '/rating',
          query: {
            orderIdList: orderIdList
          }
        });
      },
      OrderStatus(orderStatus) {
        if (orderStatus === 0) {
          return '配送中';
        } else if (orderStatus === 1) {
          return '订单已送达';
        } else {
          return '订单已取消';
        }
      },
      displayOrderStatus(orderStatus) {
        if (orderStatus === 0) {
          return '取消订单';
        } else {
          return '订单已取消';
        }
      },
      displayRating(payStatus) {
        if (payStatus === 0) {
          return '去支付';
        } else {
          return '评价';
        }
      },
      _initScroll() {
        this.scroll = new BScroll(this.$refs.orderWrapper,
          {click: true});
      },
      hide() {
   //     console.log(this.selectFoods);
        this.$router.push('/goods');
      }
    },
    watch: {
      '$route': 'getUserorder'
    },
    filters: {
      formatDate(time) {
        let date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh:mm');
      }
    }
  };
</script>

<style lang="stylus"
       rel="stylesheet/stylus">
  @import "../../common/stylus/mixin.styl"
  .userorder
    position: fixed
    left: 0
    top: 0
    bottom: 0
    z-index: 30
    width: 100%
    background: #fff
    .content-header
      position: relative
      width: 100%
      .back
        top: 10px
        left: 0
        .icon-arrow_lift
          display: block
          padding: 10px
          font-size: 20px
          color: rgb(0,0,0)
      .title
        margin-top: 10px
        padding: 10px 0
        margin-left: 10px
        font-size: 20px
        font-weight: 700
    .order-item
      position: relative
      padding: 2px 10px
      .order-content
          position: relative
          padding: 12px 0
          img
            display: inline-block
            margin-right: 10px
            vertical-align: middle
          .order-one
            display: inline-block
            vertical-align: middle
            .order-info
              .order_number
                display: inline-block
                padding: 2px 10px 2px 15px
                font-size: 16px
                font-weight: 700
              .status
                display: inline-block
                position: absolute
                right: 10px
                top: 18px
                font-size: 15px
            .time
              line-height: 12px
              font-size: 10px
              color: rgb(147,153,159)
              height: 16px
              padding-left: 15px
              padding-top: 10px
      .orderDetail
        position: relative
        padding: 12px 0 12px 40px
        box-sizing: border-box
        border-1px(rgba(7,17,27,0.1))
        img
          display: inline-block
          vertical-align: middle
          margin-right: 3px
        .name
          display: inline-block
          .text
            display: table-cell
            width: 200px
            vertical-align: middle
            font-size: 14px
        .price
          position: absolute
          right: 10px
          bottom: 25px
          font-size: 16px
          font-weight: 700
          color: rgb(240,20,20)
          .count
            position: absolute
            right: 100px
            color: rgb(0,0,0)
      .extra-money
        position: relative
        padding: 12px 0 12px 40px
        .text
          display: inline-block
          line-height: 14px
          font-size: 14px
        .info
          display: inline-block
          position: absolute
          right: 10px
      .payfor
        position: relative
        padding: 14px 0 14px 15px
        .pay-money
          display: inline-block
          line-height: 40px
          font-size: 16px
          color: #93999f
        .pay-text
          display: inline-block
          position: absolute
          line-height: 40px
          right: 10px
          .icon-pay
            display: inline-block
            font-size: 16px
            font-weight: 700
          .money
            display: inline-block
            .money-text
              font-size: 24px

      .de-order
        position: relative
        padding: 5px 10px 15px 10px
        .cancle-button, .continue-pay
          display: inline-block
          line-height: 16px
          height: 14px
          padding: 5px 5px
          .cancle, .pay-user
            display: inline-block
            line-height: 16px
            height: 14px
            padding: 5px 5px
            margin-right: 3px
            font-size: 12px
            text-align: center
            border: 1px solid rgb(0,0,0)
            position: absolute
          .cancle
            right: 70px
          .pay-user
            right: 10px
</style>
