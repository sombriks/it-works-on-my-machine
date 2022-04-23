<template>
  <div class="container">
    <div class="item" v-for="todo in todoStore.todos" :key="todo.id">
      <RouterLink :to="`/todo/${todo.id}`">
        <TodoList :todo="todo" />
      </RouterLink>
    </div>
  </div>
</template>
<script setup>
import TodoList from "@/components/TodoList.vue";

import { useTodoListStore } from "@/stores/todoListStore.js";

const todoStore = useTodoListStore();
</script>
<style scoped>
.container {
  display: flex;
  flex-wrap: wrap;
}
.item {
  flex-basis: 30%;
}
@media (max-width: 800px) {
  .item {
    flex-basis: 50%;
  }
}
</style>
