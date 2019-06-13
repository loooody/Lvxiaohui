<template>
  <div class="rating">
    <div class="content-header border-1px">
      <div class="back" @click="hide">
        <i class="icon-arrow_lift"></i>
      </div>
      <div class="address-info">
        <div class="text">订单评价</div>
      </div>
    </div>
    <div class="content-info">
      <div class="rating-icon">
        <img class="bad" v-show="badFlag<1" @click="badClick" height="80px" width="80px" src="http://dylxh.natapp1.cc/pictures/bad1.jpg">
        <img class="bad1" v-show="badFlag>0" height="80px" width="80px" src="http://dylxh.natapp1.cc/pictures/bad2.jpg">
        <img v-show="goodFlag<1" @click="goodClick" height="80px" width="80px" src="http://dylxh.natapp1.cc/pictures/good1.jpg">
        <img v-show="goodFlag>0" height="80px" width="80px" src="http://dylxh.natapp1.cc/pictures/good2.jpg">
      </div>
      <div v-show="badFlag>0" class="text">”抱歉影响您的体验，平台将对商家进行管束“</div>
      <div v-show="badFlag<1&&goodFlag<1" class="re-info">“请评价此订单”</div>
      <div class="badRating" v-show="badFlag>0">
        <div class="select-info">
          <span @click="badClick1" :class="{'highlight': bad1Flag>0}">不送上楼</span><span @click="badClick2" :class="{'highlight': bad2Flag>0}">着装脏乱</span><span @click="badClick3" :class="{'highlight': bad3Flag>0}">食品坏了</span><span @click="badClick4" :class="{'highlight': bad4Flag>0}">配送慢</span>
        </div>
        <div class="select-info1">
          <span @click="badClick5" :class="{'highlight': bad5Flag>0}">额外收费</span><span @click="badClick6" :class="{'highlight': bad6Flag>0}">未穿制服</span><span @click="badClick7" :class="{'highlight': bad7Flag>0}">态度差</span>
        </div>
        <div class="select-info2">
          <span @click="ratingInfo">x写评价</span>
        </div>
      </div>
      <div class="goodRating" v-show="goodFlag>0">
        <div class="select-info">
          <span @click="goodClick1" :class="{'highlight': good1Flag>0}">衣着整洁</span><span @click="goodClick2" :class="{'highlight': good2Flag>0}">穿着专业</span><span @click="goodClick3" :class="{'highlight': good3Flag>0}">准时送达</span>
        </div>
        <div class="select-info1">
          <span @click="goodClick4" :class="{'highlight': good4Flag>0}">服务态度好</span><span @click="goodClick5" :class="{'highlight': good5Flag>0}">送餐快</span>
        </div>
        <div class="select-info2">
          <span @click="ratingInfo">x写评价</span>
        </div>
      </div>
      <div v-show="ratingFlag>0" class="input-info">
          <textarea class="area-text" ref="ratingRef" placeholder="提出您宝贵的意见......">
          </textarea>
      </div>
    </div>
    <div class="submit" @click="addRating">提交评论</div>
  </div>
</template>

<script type="text/ecmascript-6">
  import util from '../../common/js/util.js';
  const ERR_OK = 0;

  export default {
    data() {
      return {
        badFlag: 0,
        goodFlag: 0,
        ratingFlag: 0,
        rateType: 0,
        rating: '',
        orderList: '',
        badMap: ['不送上楼', '着装脏乱', '食品坏了', '配送慢', '额外收费', '未穿制服', '态度差'],
        goodMap: ['衣着整洁', '穿着专业', '准时送达', '服务态度好', '送餐快'],
        bad1Flag: 0,
        bad2Flag: 0,
        bad3Flag: 0,
        bad4Flag: 0,
        bad5Flag: 0,
        bad6Flag: 0,
        bad7Flag: 0,
        good1Flag: 0,
        good2Flag: 0,
        good3Flag: 0,
        good4Flag: 0,
        good5Flag: 0
      };
    },
    mounted() {
      this.orderList = this.$route.query.orderIdList;
    },
    methods: {
      addRating() {
        if (this.badFlag === 1) {
          this.rateType = 0;
          this.badInfo();
        }
        if (this.goodFlag === 1) {
          this.rateType = 1;
          this.goodInfo();
        }
        if (this.ratingFlag === 1) {
          this.rating += ' ' + this.$refs.ratingRef.value;
        }
        this.addRatingToServer();
        this.rating = '';
      },
      addRatingToServer() {
        this.$http.post('http://dylxh.natapp1.cc/dylxh/buyer/rating/create', {
          orderIdList: this.orderList,
          username: util.getCookie('username'),
          rateType: this.rateType,
          avatar: 'http://47.105.170.25/pictures/avatar.jpeg',
          ratingText: this.rating
        }).then((response) => {
          response = response.body;
          console.log(response.data);
          if (response.code === ERR_OK) {
            this.$router.push('/ratings');
          }
        });
      },
      hide() {
        this.$router.push('/ratings');
      },
      badClick() {
        this.badFlag = 1;
        this.goodFlag = 0;
        this.rating = '';
      },
      badClick1() {
        if (this.bad1Flag === 0) {
          this.bad1Flag = 1;
        } else {
          this.bad1Flag = 0;
        }
      },
      badInfo() {
        if (this.bad1Flag === 1) {
          this.rating += this.badMap[0] + ' ';
        }
        if (this.bad2Flag === 1) {
          this.rating += this.badMap[1] + ' ';
        }
        if (this.bad3Flag === 1) {
          this.rating += this.badMap[2] + ' ';
        }
        if (this.bad4Flag === 1) {
          this.rating += this.badMap[3] + ' ';
        }
        if (this.bad5Flag === 1) {
          this.rating += this.badMap[4] + ' ';
        }
        if (this.bad6Flag === 1) {
          this.rating += this.badMap[5] + ' ';
        }
        if (this.bad7Flag === 1) {
          this.rating += this.badMap[6] + ' ';
        }
      },
      goodInfo() {
        if (this.good1Flag === 1) {
          this.rating += this.goodMap[0] + ' ';
        }
        if (this.good2Flag === 1) {
          this.rating += this.goodMap[1] + ' ';
        }
        if (this.good3Flag === 1) {
          this.rating += this.goodMap[2] + ' ';
        }
        if (this.good4Flag === 1) {
          this.rating += this.goodMap[3] + ' ';
        }
        if (this.good5Flag === 1) {
          this.rating += this.goodMap[4] + ' ';
        }
      },
      badClick2() {
        if (this.bad2Flag === 0) {
          this.bad2Flag = 1;
        } else {
          this.bad2Flag = 0;
        }
      },
      badClick3() {
        if (this.bad3Flag === 0) {
          this.bad3Flag = 1;
        } else {
          this.bad3Flag = 0;
        }
      },
      badClick4() {
        if (this.bad4Flag === 0) {
          this.bad4Flag = 1;
        } else {
          this.bad4Flag = 0;
        }
      },
      badClick5() {
        if (this.bad5Flag === 0) {
          this.bad5Flag = 1;
        } else {
          this.bad5Flag = 0;
        }
      },
      badClick6() {
        if (this.bad6Flag === 0) {
          this.bad6Flag = 1;
        } else {
          this.bad6Flag = 0;
        }
      },
      badClick7() {
        if (this.bad7Flag === 0) {
          this.bad7Flag = 1;
        } else {
          this.bad7Flag = 0;
        }
      },
      goodClick() {
        this.badFlag = 0;
        this.goodFlag = 1;
        this.rating = '';
      },
      goodClick1() {
        if (this.good1Flag === 0) {
          this.good1Flag = 1;
        } else {
          this.good1Flag = 0;
        }
      },
      goodClick2() {
        if (this.good2Flag === 0) {
          this.good2Flag = 1;
        } else {
          this.good2Flag = 0;
        }
      },
      goodClick3() {
        if (this.good3Flag === 0) {
          this.good3Flag = 1;
        } else {
          this.good3Flag = 0;
        }
      },
      goodClick4() {
        if (this.good4Flag === 0) {
          this.good4Flag = 1;
        } else {
          this.good4Flag = 0;
        }
      },
      goodClick5() {
        if (this.good5Flag === 0) {
          this.good5Flag = 1;
        } else {
          this.good5Flag = 0;
        }
      },
      ratingInfo() {
        this.$refs.ratingRef.value = '';
        if (this.ratingFlag === 0) {
          this.ratingFlag = 1;
        } else {
          this.ratingFlag = 0;
        }
      }
    }
  };
</script>

<style lang="stylus"
       rel="stylesheet/stylus">
  @import "../../common/stylus/mixin.styl"

  .rating
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
      .bad, .bad1
        margin-left: 26%
      .text
        line-height: 16px
        height: 16px
        padding: 1px 0
        text-align: center
        font-size: 14px
        color: red
      .re-info
        line-height: 20px
        height: 20px
        padding: 30px 0
        text-align: center
        font-size: 20px
        color: #969696
      .badRating
        position: relative
        padding: 15px 10px
        .select-info, .select-info1, .select-info2
          line-height: 34px
          height: 34px
          text-align: center
          span
            padding: 5px 10px
            margin-right: 10px
            border-radius: 5px
            font-size: 14px
            color: #969696
            border: solid 1px #AAAAAA
            &.highlight
              background: #CCCCCC
      .goodRating
        position: relative
        padding: 15px 10px
        .select-info, .select-info1, .select-info2
          line-height: 34px
          height: 34px
          text-align: center
          span
            padding: 5px 10px
            margin-right: 10px
            border-radius: 5px
            font-size: 14px
            color: #FFA500
            border: solid 1px #FFA500
            &.highlight
              background: #FFE7BA
      .input-info
        position: relative
        padding: 0 10px
        .area-text
          height: 90px
          width: 100%
          border: 0px
          outline: none
          background: #F7F7F7
    .submit
      position: absolute
      width: 95%
      bottom: 5px
      margin: 10px 10px
      line-height: 40px
      text-align: center
      color: #fff
      background: #00FF00
</style>
