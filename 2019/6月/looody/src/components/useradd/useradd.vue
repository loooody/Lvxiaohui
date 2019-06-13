<template>
  <div class="useradd">
    <div class="content">
      <div class="content-header">
        <div class="back" @click="hide">
          <i class="icon-arrow_lift"></i>
        </div>
        <div class="address-info">
          <div class="text">收货地址</div>
          <div class="add" @click="newAddress">新增地址</div>
        </div>
      </div>
      <div class="content-info">
         <ul>
           <li class="user-info border-1px" @click='useAddress(item, $event)' v-for="(item,index) in userInfo" :key="index">
             <div class="info">
               <div class="address">{{item.address}}</div>
               <div class="address-info">{{item.addressInfo}}</div>
               <span class="username">{{item.username}}({{sexDisplay(item.sex)}})</span>
               <span class="phone">{{item.phone}}</span>
             </div>
             <img height="25px" width="25px" src="http://dylxh.natapp1.cc/pictures/modify.jpg">
           </li>
         </ul>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import util from '../../common/js/util.js';

  const ERR_OK = 0;

  export default {
    created() {
      this.$http.get('http://dylxh.natapp1.cc/dylxh/address/list?openid=' + util.getCookie('openid')).then((response) => {
        response = response.body;
        console.log(response);
        if (response.code === ERR_OK) {
          this.userInfo = response.data;
          console.log(this.userInfo);
          };
      });
    },
    data() {
      return {
        selectFoods: [],
        userInfo: []
      };
    },
    mounted() {
      this.selectFoods = this.$route.query.foods;
    },
    methods: {
      sexDisplay(sex) {
        if (sex === 0) {
          return '先生';
        } else {
          return '女士';
        }
      },
      hide() {
        this.$router.push({
          path: '/orderdetail',
          query: {
            foods: this.selectFoods
          }
        });
      },
      newAddress() {
        this.$router.push({
          path: '/newaddress',
          query: {
            foods: this.selectFoods
          }
        });
      },
      useAddress(item, event) {
        this.$router.push({
          path: '/orderdetail',
          query: {
            username: item.username,
            //      openid: util.getCookie('openid'),
            sex: this.sexDisplay(item.sex),
            phone: item.phone,
            address: item.address,
            addressInfo: item.addressInfo,
            foods: this.selectFoods
          }
        });
      }
    }
  };
</script>

<style lang="stylus"
       rel="stylesheet/stylus">
  @import "../../common/stylus/mixin.styl"

  .useradd
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
      padding: 20px 0px 10px 0px
      .back
        display: inline-block
        top: 10px
        left: 0
        .icon-arrow_lift
          display: block
          padding: 10px
          font-size: 20px
          color: #000
      .address-info
          display: inline-block
          padding: 10px 0
          .text
            display: inline-block
            text-align: center
          .add
            display: inline-block
            position: absolute
            color: #1E90FF
            top: 38px
            right: 10px
    .content-info
      position: relative
      padding: 10px 10px
      .user-info
        position: relative
        padding-top: 15px
        border-1px(rgba(7,17,27,0.1))
        .info
          display: inline-block
          .address
            line-height: 16px
            height: 16px
            font-weight: 700
          .address-info
            line-height: 14px
            font-size: 14px
            padding-top: 5px
          .username, .phone
            display: inline-block
            padding: 10px 0px
            font-size: 14px
          .phone
            padding-left: 10px
            padding-bottom: 15px
        img
          display: inline-block
          position: absolute
          right: 15px
          bottom: 34px
          vertical-align: middle

</style>
