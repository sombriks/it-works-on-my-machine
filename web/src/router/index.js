import { createRouter, createWebHistory } from "vue-router";

import ListTodos from "@/views/ListTodos.vue";
import DetailTodo from "@/views/DetailTodo.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "list",
      component: ListTodos,
    },
    {
      path: "/todo/:id",
      name: "detail",
      component: DetailTodo,
    },
  ],
});

export default router;
