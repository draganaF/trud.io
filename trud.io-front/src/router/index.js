import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const $ = window.$;

const routes = [
  {
    path: "/auth",
    name: "Auth",
    component: () => import("@/pages/LoginPage.vue"),
    meta: {
      layout: "AuthLayout",
    },
  },
  {
    path: "/",
    name: "Home",
    component: () => import("@/pages/HomePage.vue"),
    meta: {
      layout: "AppLayoutMain",
    },
  },
  {
    path: "/symptoms",
    name: "SymptomsPage",
    component: () => import("@/pages/SymptomsPage.vue"),
    meta: {
      layout: "AppLayoutMain",
    },
  },
  {
    path: "/create-pregnancy",
    name: "CreatePregnancyPage",
    component: () => import("@/pages/CreatePregnancyPage.vue"),
    meta: {
      layout: "AppLayoutMain",
    },
  },
  {
    path: "/patient-registration",
    name: "RegisterPatientPage",
    component: () => import("@/pages/RegisterPatientPage.vue"),
    meta: {
      layout: "AppLayoutMain",
    },
  },
  {
    path: "/reports",
    name: "ReportPage",
    component: () => import("@/pages/ReportPage.vue"),
    meta: {
      layout: "AppLayoutMain",
    },
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

router.afterEach(() => {
  setTimeout(() => {
    $('.selectpicker').selectpicker('refresh');
  }, 100);
});

export default router;
