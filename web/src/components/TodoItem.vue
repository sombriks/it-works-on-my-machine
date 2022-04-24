<template>
  <div class="container">
    <div v-if="item">
      <input
        type="checkbox"
        :checked="item.completed"
        @input="(e) => $emit('complete', { checked: e.target.checked, item })"
      />
    </div>
    <div class="title">{{ item.title }}</div>
  </div>
</template>
<script setup>
defineProps(["item"]);
</script>
<style scoped>
.container {
  display: flex;
  justify-content: space-between;
  align-items: stretch;
}
.title {
  flex-grow: 1;
}
</style>
