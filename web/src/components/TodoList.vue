<template>
  <div class="todo">
    <div class="title">{{ todo.title }}</div>
    <ul v-if="items">
      <li v-for="item in items" :key="item.id">
        <TodoItem :item="item" @complete="onComplete" />
      </li>
    </ul>
  </div>
</template>
<script setup>
import TodoItem from "@/components/TodoItem.vue";

import { useTodoListStore } from "@/stores/todoListStore.js";

defineProps(["todo", "items"]);

const todoStore = useTodoListStore();

const onComplete = (e) => {
  todoStore.updateItem({ ...e.item, completed: e.checked });
};
</script>
<style scoped>
.todo {
  /* From https://css.glass */
  background: rgba(30, 152, 60, 0.28);
  border-radius: 16px;
  box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
  backdrop-filter: blur(2.2px);
  -webkit-backdrop-filter: blur(2.2px);
  border: 1px solid rgba(30, 152, 60, 0.37);
}
.todo {
  min-width: 200px;
  margin: 1em;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.title {
  margin: 1em;
  align-items: center;
}
</style>
