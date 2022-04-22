<template>
  <RouterLink v-for="todo in todos" :key="todo" :to="`/todo/${item}`">
    <TodoList :todo="todo" />
  </RouterLink>
</template>
<script setup>
import { ref } from "vue";

import TodoList from "../components/TodoList.vue";

const todos = ref([1, 2, 3]);
</script>
