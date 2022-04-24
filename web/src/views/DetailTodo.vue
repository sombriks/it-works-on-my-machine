<template>
  <TodoList
    v-if="todoStore.todo"
    :todo="todoStore.todo"
    :items="todoStore.items"
  />
  <RouterLink to="/">Back</RouterLink>
</template>
<script setup>
import { onMounted } from "vue";

import { RouterLink } from "vue-router";

import TodoList from "@/components/TodoList.vue";

import { useTodoListStore } from "@/stores/todoListStore.js";

const props = defineProps(["id"]);

const todoStore = useTodoListStore();

onMounted(() => {
  todoStore.getTodo(props.id);
});
</script>
