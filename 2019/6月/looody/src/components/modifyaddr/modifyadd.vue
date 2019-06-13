<template>
  <div class="modifyaddr">
    <div class="content">
      <div class="content-header border-1px">
        <div class="back" @click="hide">
          <i class="icon-arrow_lift"></i>
        </div>
        <div class="address-info">
          <div class="text">新增地址</div>
        </div>
      </div>
      <div class="content-info">
        <div class="user-info border-1px">
          <div class="text">联系人</div>
          <input type="text" class="info" placeholder="姓名" ref="user">
        </div>
        <div class="sex border-1px">
          <div class="men" @click="menClick" :class="{'highlight': this.sexFlag<1}">先生</div>
          <div class="women" @click="womenClick" :class="{'highlight': this.sexFlag>0}">女士</div>
        </div>
        <div class="phone-info border-1px">
          <div type="text" class="text">电话</div>
          <input class="info" placeholder="手机号码" ref="phone">
        </div>
        <div class="address-info border-1px">
          <div type="text" class="text">地址</div>
          <input class="info" placeholder="例:升升公寓C栋" ref="address">
        </div>
        <div class="address-detail border-1px">
          <div type="text" class="text">门牌号</div>
          <input class="info" placeholder="例:5号楼205室" ref="addrDetail">
        </div>
      </div>
      <div class="submit" @click="addAddress">保存并使用</div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import util from '../../common/js/util.js';

  const ERR_OK = 0;

  export default {
    // created() {
    //   this.$http.get('').then((response) => {
    //     response = response.body;
    //     console.log(response);
    //     if (response.code === ERR_OK) {
    //       this.goods = response.data;
    //       console.log(this.goods);
    //     };
    //   });
    // },
    data() {
      return {
        sexFlag: 0,
        selectFoods: []
      };
    },
    mounted() {
      this.selectFoods = this.$route.query.foods;
    },
    methods: {
      hide() {
        this.$router.push({
          path: '/useradd',
          query: {
            foods: this.selectFoods
          }
        });
      },
      menClick() {
        this.sexFlag = 0;
      },
      womenClick() {
        this.sexFlag = 1;
      },
      sexName() {
        if (this.sexFlag === 0) {
          return '先生';
        } else {
          return '女士';
        }
      },
      addAddress() {
        alert(util.getCookie('foods'));
        console.log(util.getCookie('foods'));
        let username = this.$refs.user.value;
        let phone = this.$refs.phone.value;
        let address = this.$refs.address.value;
        let addrDetail = this.$refs.addrDetail.value;
        this.$http.post('http://dylxh.natapp1.cc/dylxh/address/addr', {
          username: username,
          openid: util.getCookie('openid'),
          sex: this.sexFlag,
          phone: phone,
          address: address,
          addressInfo: addrDetail
        }).then((response) => {
          response = response.body;
          console.log(response.data.orderId);
          if (response.code === ERR_OK) {
            this.$router.push({
              path: '/orderdetail',
              query: {
                username: username,
                //      openid: util.getCookie('openid'),
                sex: this.sexName(),
                phone: phone,
                address: address,
                addressInfo: addrDetail,
                foods: this.selectFoods
              }
            });
          }
        }, (response) => {
          alert('服务器开小差啦');
        });
      }
    }
  };
</script>

<style lang="stylus"
       rel="stylesheet/stylus">
  @import "../../common/stylus/mixin.styl"

  .modifyaddr
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
      padding-bottom: 10px
      padding-top: 10px
      border-1px(rgba(7,17,27,0.1))
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
        padding: 10px 20px
        .text
          display: inline-block
          text-align: center
    .content-info
      position: relative
      padding: 10px 10px
      .user-info, .phone-info, .address-info, .address-detail
        position: relative
        margin-top: 15px
        padding-bottom: 15px
        border-1px(rgba(7,17,27,0.1))
        .text
          display: inline-block
          text-align: center
          font-size: 16px
          font-weight: 700
        .info
          display: inline-block
          line-height: 18px
          height: 18px
          margin-left: 15px
          border: 0px
          outline: none
      .sex
        position: relative
        margin-top: 10px
        padding-left: 50px
        padding-bottom: 10px
        border-1px(rgba(7,17,27,0.1))
        .men, .women
          display: inline-block
          padding:5px 10px
          margin-left: 10px
          border-radius: 4px
          border: 1px solid #DCDCDC
          &.highlight
            border: 1px solid #1E90FF
            color: #1E90FF
    .submit
      position: relative
      margin: 10px 10px
      line-height: 40px
      text-align: center
      color: #fff
      background: #00FF00
</style>
