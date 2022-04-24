import { defineStore } from "pinia";

export const useTodoListStore = defineStore({
  id: "todos",
  state: () => ({
    todo: null,
    todos: [],
    items: [],
  }),
  actions: {
    async getTodos() {
      const response = await fetch(`${import.meta.env.VITE_BASE_API}/todos`);
      const result = await response.json();
      this.todos = result;
    },
    async getTodo(id) {
      const response = await fetch(
        `${import.meta.env.VITE_BASE_API}/todo/${id}`
      );
      const result = await response.json();
      this.todo = result;
      this.getItems(this.todo.id);
    },
    async getItems(id) {
      this.items = [];
      const response = await fetch(
        `${import.meta.env.VITE_BASE_API}/todo/${id}/items`
      );
      const result = await response.json();
      this.items = result;
    },
    async updateItem(item) {
      await fetch(
        `${import.meta.env.VITE_BASE_API}/todo/${item.todoListId}/item`,
        {
          headers: {
            "Content-Type": "application/json",
          },
          method: "PUT",
          body: JSON.stringify(item),
        }
      );
    },
  },
});
