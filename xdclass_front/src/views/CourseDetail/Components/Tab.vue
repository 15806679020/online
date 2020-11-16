<template>
  <div>
    <cube-tab-bar v-model="selectedLable" show-slider>
      <cube-tab v-for="item in tabs" :label="item.lable" :key="item.lable"></cube-tab>
    </cube-tab-bar>
  
    <component :videoInfo="videoInfo" :chapterList="chapterList" :is='selectedLable=="简介"?"Summary":"Calalog"'>

    </component>
  
  </div>
</template>


<script>
import Summary from "./Summary";
import Calalog from "./Calalog";

export default {
  components: {
    Summary,
    Calalog,
  },
  props: {
    videoInfo: {
      type: Object,
      required: true,
    },
    chapterList: {
      type: Array,
      required: true,
    },
  },
  data() {
    return {
      selectedLable: "简介",
      tabs: [
        {
          lable: "简介",
        },
        {
          lable: "目录",
        },
      ],
    };
  },
};
</script>

<style lang="scss" scoped>
</style>