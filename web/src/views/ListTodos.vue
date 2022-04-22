<template>
  <RouterLink v-for="todo in todos" :key="todo" :to="`/todo/${item}`">
    <Todo :todo="todo" />
  </RouterLink>
</template>
<script setup>
import { ref } from "vue";

import Todo from "../components/Todo.vue";

const todos = ref([1, 2, 3]);
</script>
