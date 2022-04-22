import { createRouter, createWebHistory } from "vue-router";
import ListBeer from "../views/ListBeer.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "list",
      component: ListBeer,
    },
    {
      path: "/beer/:idbeer",
      name: "detailBeer",
      component: () => import("../views/DetailBeer.vue"),
    },
  ],
});

export default router;
