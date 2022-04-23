<script setup>
import { RouterView } from "vue-router";

import { useTodoListStore } from "@/stores/todoListStore.js";

const todoStore = useTodoListStore();

todoStore.getTodos();
</script>

<template>
  <RouterView />
</template>

<style>
@import "@/assets/base.css";
</style>
