<template>
  <div>
    <transition name="move">
    <div class="orderdetail" ref="orderdetailWrapper">
      <div>
          <div class="content-header">
            <div class="back" @click="hide">
              <i class="icon-arrow_lift"></i>
            </div>
            <div class="delivery_method">
              外卖配送
            </div>
            <div v-show="flag<1" class="addressAdd">
              <div class="address" @click="addressAdd">
                <span class="user-address">请添加联系地址</span>
                <i class="icon-keyboard_arrow_right"></i>
              </div>
            </div>
            <div v-show="flag>0" class="user_information">
              <div class="address" @click="addressAdd">
                <span class="user-address">{{address}}{{addressInfo}}</span>
                <i class="icon-keyboard_arrow_right"></i>
              </div>
              <span class="username">{{username}}({{sex}})</span>
              <span class="phone">{{phone}}</span>
            </div>
          </div>
          <div class="payorder">
            <div class="delivery_time border-1px">
              <span class="text">传达时间</span>
              <!--<span class="service" >准时达服务:超时10分钟享赔</span>-->
              <div class="time">
                <span class="text">尽快送达（19:16送达)</span>
                <i class="icon-keyboard_arrow_right"></i>
              </div>
            </div>
            <div class="pay_method">
              <span class="text">支付方式</span>
              <!--<span class="service" >准时达服务:超时10分钟享赔</span>-->
              <div class="method">
                <span class="text">支付宝</span>
                <i class="icon-keyboard_arrow_right"></i>
              </div>
            </div>
          </div>
          <div class="content-order">
            <span class="title">Loooody甜品店</span>
            <ul>
              <li class="food-item " v-for="food in selectFoods" :key="food.id">
                <img width="42" height="42" :src="food.icon">
                <div class="name">
                  <span class="text">{{food.name}}</span>
                </div>
                <div class="price">
                  <span class="count">*{{food.count}}</span>
                  <span>￥{{food.price*food.count}}</span>
                </div>
              </li>
            </ul>
            <div class="extra-text">
              <div class="method">
                <span class="icon">包装费</span>
                <div class="icon-back">
                  <span class="icon-text">餐盒</span>
                </div>
                <!--<i class="icon-keyboard_arrow_right"></i>-->
              </div>
              <span class="text">￥1.5</span>
            </div>
            <div class="seller-delivery">
              <div class="method">
                <span class="icon">配送费</span>
                <div class="icon-back">
                  <span class="icon-text">蜂鸟专送</span>
                </div>
                <!--<i class="icon-keyboard_arrow_right"></i>-->
              </div>
              <span class="text">￥3</span>
            </div>
            <div class="info">满减活动与折扣商品不同享</div>
            <div class="payfor">
              <span class="pay-money">订单支付</span>
              <div class="pay-text">
                <span class="icon-pay">小计</span>
                <div class="money">
                  <span class="money-text">￥{{totalPrice}}</span>
                </div>
                <!--<i class="icon-keyboard_arrow_right"></i>-->
              </div>
            </div>
          </div>
          <div class="extra">
            <div class="order-notes">
              <span class="note-text">订单备注</span>
              <div class="note-detail">
                <span class="detail-text">口味 偏好</span>
                <i class="icon-keyboard_arrow_right"></i>
              </div>
            </div>
            <div class="tableware-count">
              <span class="note-text">餐具份数</span>
              <div class="note-detail">
                <span class="detail-text">1</span>
                <i class="icon-keyboard_arrow_right"></i>
              </div>
            </div>
            <div class="invoice-info">
              <span class="invoice-text">发票信息</span>
              <div class="invoice-detail">
                <span class="detail-text">该店不支持线上开票，请电话联系商户</span>
              </div>
            </div>
            <div class="blank"></div>
          </div>
          <div class="ordercart"></div>
      </div>
      <payorder :totalPrice="totalPrice" :username="username" :sex="sex" :phone="phone" :address="address" :addressInfo="addressInfo" :selectFoods="selectFoods"></payorder>
    </div>
    </transition>
  </div>
</template>
<script type="text/ecmascript-6">
  import BScroll from 'better-scroll';
  import payorder from 'components/payorder/payorder';
 // import util from '../../common/js/util.js';

  export default {
    components: {
      payorder
    },
    data() {
      return {
        selectFoods: [],
        openid: '',
        addressInfo: '',
        address: '',
        username: '',
        sex: '',
        phone: '',
        flag: 0
      };
    },
    created() {
      this.$nextTick(() => {
        this._initScroll();
      });
    },
    mounted() {
      this.selectFoods = this.$route.query.foods;
      this.addressInfo = this.$route.query.addressInfo;
      this.address = this.$route.query.address;
      this.username = this.$route.query.username;
      this.sex = this.$route.query.sex;
      this.phone = this.$route.query.phone;
      this.showClass();
    },
    computed: {
      totalPrice() {
        var total = 0;
        var data = JSON.stringify(this.selectFoods);
        data = JSON.parse(data);
        console.log(data);
        data.forEach(food => {
          total += food.price * food.count;
        });
        total = total + 1.5 + 3;
        return total;
      }
    },
    methods: {
        showClass() {
//          alert(this.sex);
          if (this.sex === '先生' || this.sex === '女士') {
            this.flag = 1;
          }
        },
        addressAdd() {
          this.$router.push({
            path: '/useradd',
            query: {
              foods: this.selectFoods
            }
          });
        },
        hide() {
          console.log(this.selectFoods);
          this.$router.push('/goods');
        },
        _initScroll() {
            if (!this.scroll) {
              this.scroll = new BScroll(this.$refs.orderdetailWrapper, {
                click: true
              });
            } else {
              this.scroll.refresh();
            }
        }
    }
  };
</script>

<style lang="stylus"
       rel="stylesheet/stylus">
  @import "../../common/stylus/mixin.styl"
  .orderdetail
    position: fixed
    left: 0
    top: 0
    bottom: 0
    z-index: 30
    width: 100%
    background: linear-gradient(to bottom, #1E90FF, #fff)
    .content-header
      position: relative
      width: 100%
      height: 145px
      .back
          top: 10px
          left: 0
          .icon-arrow_lift
            display: block
            padding: 10px
            font-size: 20px
            color: #fff
      .delivery_method
        position: relative
        left: 10px
        z-index: 10
        height: 24px
        margin: 4px 0
        width: 85px
        line-height: 24px
        padding: 1px 0
        font-size: 14px
        text-align: center
        border-radius: 12px
        color: #1E90FF
        background: #fff
      .addressAdd
        position: relative
        color: #fff
        .address
          line-height: 24px
          vertical-align: left
          height: 24px
          left: 0
          padding: 10px
          .user-address
            display: inline-block
            margin-top: 15px
            font-size: 20px
            font-weight: 700
          .icon-keyboard_arrow_right
            display: inline-block
            font-size: 20px
      .user_information
        position: absolute
        color: #fff
        .address
            line-height: 24px
            vertical-align: left
            height: 24px
            left: 0
            padding: 10px
            .user-address
              display: inline-block
              margin-top: 5px
              font-size: 20px
              font-weight: 700
            .icon-keyboard_arrow_right
              display: inline-block
              font-size: 20px
        .username, .phone
            display: inline-block
            padding: 5px 10px
            font-size: 14px
    .payorder
        position: relative
        width: 90%
        left: 10px
        padding: 0 10px
        margin-top: 10px
        background: #fff
        .delivery_time
          position: relative
          padding: 16px 0
          box-sizing: border-box
          border-1px(rgba(7,17,27,0.1))
          font-size: 16px
          .text
            display: inline-block
          .time
            display: inline-block
            position: absolute
            right: 12px
            .text
              display: inline-block
              color: #1E90FF
            .icon-keyboard_arrow_right
              display: inline-block
        .pay_method
          position: relative
          padding: 16px 0
          box-sizing: border-box
          font-size: 16px
          .text
            display: inline-block
          .method
            display: inline-block
            position: absolute
            right: 12px
            .text
              display: inline-block
              color: #1E90FF
            .icon-keyboard_arrow_right
              display: inline-block
    .content-order
        position: relative
        width: 90%
        left: 10px
        padding: 0 10px
        margin-top: 10px
        background: #fff
        .title
          line-height: 46px
          height: 46px
          font-size: 16px
          margin: 15px 0
          font-weight: 700
        .food-item
          position: relative
          padding: 12px 0
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
        .extra-text, .seller-delivery
          position: relative
          padding: 12px 0
          .method
            display: inline-block
            padding: 4px 0
            .icon
              display: inline-block
              line-height: 16px
              height: 14px
              padding: 2px 0
              margin-right: 3px
              left: 0
              font-size: 12px
              text-align: center
            .icon-back
              display: inline-block
              .icon-text
                line-height: 22px
                height: 22px
                font-size: 16px
          .text
            display: inline-block
            position: absolute
            font-size: 16px
            margin-top: 7px
            right: 10px
            color: rgb(0,0,0)
        .extra-text
          .icon
            background: #EBEBEB
            color: #919191
        .seller-delivery
          .icon
            background: #1E90FF
            color: #fff
        .info
          padding: 12px 0
          line-height: 22px
          height: 22px
          font-size: 16px
        .payfor
          position: relative
          padding: 14px 0
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
    .extra
        position: relative
        width: 90%
        left: 10px
        padding: 0 10px
        margin-top: 10px
        background: #fff
        .order-notes, .tableware-count
          position: relative
          padding: 12px 0
          .note-text
            display: inline-block
            line-height: 22px
            height: 22px
            font-size: 16px
            font-weight: 700
          .note-detail
            display: inline-block
            position: absolute
            right: 10px
            .detail-text
              display: inline-block
              line-height: 22px
              height: 22px
            .icon-keyboard_arrow_right
              display: inline-block
              vertical-align: middle
              margin-bottom: 1px
              font-size: 20px
        .invoice-info
          position: relative
          padding: 12px 0
          .invoice-text
            display: inline-block
            font-size: 16px
            font-weight: 700
          .invoice-detail
            display: inline-block
            position: absolute
            right: 10px
            .detail-text
              font-size: 14px
        .blank
          position: relative
          padding: 50px 0
          color: #fff
</style>
