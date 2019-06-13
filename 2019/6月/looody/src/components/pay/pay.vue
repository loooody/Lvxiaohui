<template>
  <div class="pay">
    <div class="content">
      <div class="pay-header">
        <div class="back" @click="hide">
          <i class="icon-arrow_lift"></i>
        </div>
        <div class="text">在线支付</div>
      </div>
      <div class="pay-money">
        <div class="pay-text">
          支付金额
        </div>
        <div class="money">￥{{this.totalPrice}}</div>
      </div>
      <div class="alipay">
        <div class="text">选择支付方式</div>
        <div class="alipay-content">
          <img width="36px" height="36px" src="http://47.105.170.25/pictures/zhifubao.jpg">
          <div class="ali">支付宝</div>
        </div>
      </div>
      <div class="de-pay" @click="payOrder">确认支付</div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  const ERR_OK = 0;

  export default {
    data() {
      return {
        totalPrice: 0,
        openid: '',
        orderId: ''
      };
    },
    mounted() {
      this.totalPrice = this.$route.query.totalPrice;
      this.openid = this.$route.query.openid;
      this.orderId = this.$route.query.orderId;
    },
    methods: {
      hide() {
        console.log(this.selectFoods);
        this.$router.push('/userorder');
      },
      payOrder() {
        this.$http.get('http://dylxh.natapp1.cc/dylxh/buyer/order/paid?openid=' + this.openid + '&orderId=' + this.orderId).then((response) => {
          response = response.body;
          if (response.code === ERR_OK) {
            this.$router.push('/userorder');
          }
        });
      }
    }
  };
</script>

<style lang="stylus"
       rel="stylesheet/stylus">
  .pay
    position: fixed
    left: 0
    top: 0
    bottom: 0
    z-index: 30
    width: 100%
    background: #fff
    .pay-header
      position: relative
      padding: 5px 10px
      background: #1E90FF
      .back
        display: inline-block
        top: 10px
        left: 0
        .icon-arrow_lift
          display: block
          padding: 10px
          font-size: 20px
          color: #fff
      .text
        display: inline-block
        padding: 10px
        font-size: 20px
        color: #fff
    .pay-money
      padding: 15px 10px
      position: relative
      .pay-text
        padding: 5px 10px
        font-size: 14px
        line-height: 24px
        height: 24px
        text-align: center
      .money
        padding: 5px 10px
        line-height: 26px
        height: 26px
        text-align: center
        font-size: 16px
        font-weight: 700
    .alipay
      position: relative
      padding: 10px 0 20px 0
      .text
        padding: 15px 0 10px 10px
        background: #F4F4F4
        font-size: 14px
      .alipay-content
        padding: 10px 0 20px 0
        img
          display: inline-block
          padding: 15px 0 10px 10px
          vertical-align: middle
        .ali
          display: inline-block
          padding: 15px 0 10px 10px
    .de-pay
      position: absolute
      padding: 10px 0 10px 0
      line-height: 30px
      height: 30px
      width: 100%
      text-align: center
      bottom: 0
      background: #00FF7F
      color: #fff
</style>
