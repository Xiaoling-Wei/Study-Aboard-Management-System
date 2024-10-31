<template>
  <div style="padding: 10px 0">
    <h4>院校介绍</h4>
     <el-tooltip class="item" effect="dark" content="大牛学院" placement="top-start">
     <img style=" width: 80%;margin: 16px 0;" src="../../assets/1.jpg" alt="大牛学院"  @click="$router.push('/front/item2')">
    </el-tooltip>
  </div>
</template>

<script>
export default {
  name: "Item1",
  data() {
    return {}
  },
  created() {

  },
  methods: {}
}
</script>

<style></style>
