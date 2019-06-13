<template>
  <div>
    <div class="shopcart">
      <div class="content">
        <div class="content-left">
          <div class="price" :class="{'highlight': totalPrice>0}">￥{{totalPrice}}</div>
          <div class="desc">已优惠 ￥0</div>
        </div>
        <div class="content-right" @click.stop.prevent="payMoney">
          <div class="pay-food">
            确认支付
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import util from '../../common/js/util.js';
  const ERR_OK = 0;

  export default {
    props: {
      totalPrice: {
        type: Number,
        default: 88.88
      },
      selectFoods: {
        type: Array
      },
      username: {
        type: String
      },
      sex: {
        type: String
      },
      phone: {
        type: String
      },
      address: {
        type: String
      },
      addressInfo: {
        type: String
      }
    },
    data() {
      return {
        foods: [],
        openid: util.getCookie('openid')
      };
    },
    methods: {
      sexName() {
        if (this.sex === '先生') {
          return 0;
        } else {
          return 1;
        }
      },
      payMoney() {
        var totalPrice = this.totalPrice;
        for (let i = 0; i < this.selectFoods.length; i++) {
          this.foods[i] = {
            productId: this.selectFoods[i].id,
            productQuantity: this.selectFoods[i].count
          };
        }
        var item = JSON.stringify(this.foods);
//        console.log(this.selectFoods);
//        var SelectFoods = JSON.stringify(this.selectFoods);
         this.$http.post('http://dylxh.natapp1.cc/dylxh/buyer/order/create', {
            name: this.username,
            phone: this.phone,
            address: this.address + this.addressInfo,
            openid: this.openid,
            items: item
        }).then((response) => {
          response = response.body;
   //        alert('111');
          console.log(response.data.orderId);
          if (response.code === ERR_OK) {
            util.setCookie('username', this.username, 1000 * 60 * 60);
            this.$router.push({
              path: '/pay',
              query: {
                totalPrice: totalPrice,
                openid: this.openid,
                orderId: response.data.orderId
              }
            });
          }
        }, (response) => {
           alert('服务器错误，请重新登录或在商品浏览页面刷新后重试');
         });
      }
    }
  };
</script>

<style lang="stylus"
       rel="stylesheet/stylus">
  @import "../../common/stylus/mixin.styl"
  .shopcart
    position: fixed
    left: 0
    bottom: 0
    z-index: 50
    width: 100%
    height: 48px
    .content
      display: flex
      background: #141d27
      font-size: 0
      .content-left
        flex: 1
        .price
          display: inline-block
          vertical-align: top
          font-size: 16px
          margin-top: 12px
          margin-left: 20px
          line-height: 24px
          padding-right: 12px
          box-sizing: border-box
          border-right: 1px solid rgba(255, 255, 255, 0.1)
          font-weight: 700
          color: rgba(255, 255, 255, 0.4)
          &.highlight
            color: #fff
        .desc
          display: inline-block
          vertical-align: top
          line-height: 24px
          margin: 12px 0 0 12px
          color: rgba(255, 255, 255, 0.4)
          font-size: 10px
      .content-right
        flex: 0 0 105px
        width: 105px
        .pay-food
          height: 48px
          line-height: 48px
          text-align: center
          font-size: 12px
          color: rgba(255, 255, 255, 0.4)
          font-weight: 700
          background:#00b43c
          color: #fff
</style>
