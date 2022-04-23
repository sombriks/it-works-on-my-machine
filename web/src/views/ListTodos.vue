<template>
  <RouterLink
    v-for="todo in todoStore.todos"
    :key="todo.id"
    :to="`/todo/${todo.id}`"
  >
    <TodoList :todo="todo" />
  </RouterLink>
</template>
<script setup>
import TodoList from "@/components/TodoList.vue";

import { useTodoListStore } from "@/stores/todoListStore.js";

const todoStore = useTodoListStore();

</script>
