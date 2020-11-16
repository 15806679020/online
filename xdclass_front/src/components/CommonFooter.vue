<template>
  <div class="tab">
    <cube-tab-bar v-model="selectedLabelSlots" @click="changHandler">
      <cube-tab
        v-for="(item) in tabs"
        :icon="item.icon"
        :label="item.label"
        :key="item.path"
        :value="item.path"
      ></cube-tab>
    </cube-tab-bar>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedLabelSlots: "/",
      tabs: [
        {
          label: "⾸⻚",
          icon: "cubeic-home",
          path: "/",
        },
        {
          label: "我的订单",
          icon: "cubeic-like",
          path: "/order",
        },
        {
          label: "个人中⼼",
          icon: "cubeic-person",
          path: "/personal",
        },
      ],
    };
  },
  methods: {
    changHandler(path) {
      //this.$route.path 当前路径
      if (path !== this.$route.path) {
        this.$router.push(path);
      }
    },
    created() {
      //默认路由选择器，比如刷新页面，需要重新进入当前页面
      this.selectedLabelSlots = this.$route.path;
    },
  },
};
</script>

<!--SCSS是一种CSS预处理理语言, scoped 是指这个scss样式 只作用于当前组件-->
<style lang="scss" scoped>
.tab {
  position: fixed;
  bottom: 0;
  z-index: 999;
  background-color: #fff;
  width: 100%;
  border-top: 1px solid rgba($color: #000000, $alpha: 0.1);
}
.cube-tab_active {
  color: #3bb149;
}
</style>