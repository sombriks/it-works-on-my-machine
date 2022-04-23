import { defineStore } from "pinia";

export const useTodoListStore = defineStore({
  id: "todos",
  state: () => ({
    todos: [],
    todoItems: [],
  }),
  actions: {
    async getTodos() {
      const response = await fetch(`${import.meta.env.VITE_BASE_API}/todos`);
      const result = await response.json();
      console.log(result);
      this.todos = result;
    },
  },
});
