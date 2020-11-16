<template>
  <div>
    <!-- 首页轮播图 -->
    <home-banner :banners="banners"></home-banner>
    <!-- 视频列表组件 -->
    <video-list :videoList = "videoList"></video-list>
    <!-- 底部导航栏组件 -->
    <common-footer></common-footer>
  </div>
</template>


<script>
//导入组件
import HomeBanner from "./Component/Banner";
import VideoList from "./Component/VideoList";
import CommonFooter from "@/components/CommonFooter";
//按需导入方法
import { getBanner, getVideoList } from "@/api/getData.js";

export default {
  //注册组件
  components: {
    HomeBanner,
    VideoList,
    CommonFooter,
  },
  //声明数据源
  data() {
    return {
      banners: [],
      videoList: [],
    };
  },
  //定义方法
  methods: {
    //async 用于声明一个function是异步的
    //获取轮播图数据
    async getBannerData() {
      try {
        //await 等待一个异步方法执行完
        const result = await getBanner();
        console.log(result);
        if (result.data.code == 0) {
          this.banners = result.data.data;
        }
      } catch (error) {
        console.log(error);
      }
    },

    //获取视频列表
    async getVList() {
      try {
        const result = await getVideoList();
        console.log(result);
        if (result.data.code == 0) {
          this.videoList = result.data.data;
        }
      } catch (error) {
        console.log(error);
      }
    },
  },
  mounted() {
    //页面渲染完成后，调用方法获取数据
    this.getBannerData();
    this.getVList();
  },
};
</script>

<style lang="scss" scoped>
</style>