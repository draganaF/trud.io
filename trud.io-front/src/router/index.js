import Vue from "vue";
import VueRouter from "vue-router";
import {Roles} from '../constants.js';
import {getRole} from '../utils/userInfo.js'

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
    path: "/symptoms/:id",
    name: "SymptomsPage",
    component: () => import("@/pages/SymptomsPage.vue"),
    meta: {
      layout: "AppLayoutMain",
      role: [Roles.ROLE_DOCTOR, Roles.ROLE_PATIENT, Roles.ROLE_NURSE]
    },
  },
  {
    path: "/create-pregnancy",
    name: "CreatePregnancyPage",
    component: () => import("@/pages/CreatePregnancyPage.vue"),
    meta: {
      layout: "AppLayoutMain",
      role: [Roles.ROLE_DOCTOR]
    },
  },
  {
    path: "/reports",
    name: "ReportPage",
    component: () => import("@/pages/ReportPage.vue"),
    meta: {
      layout: "AppLayoutMain",
      role: [Roles.ROLE_DOCTOR]
    },
  },
  {
    path: "/patient-registration",
    name: "RegisterPatientPage",
    component: () => import("@/pages/RegisterPatientPage.vue"),
    meta: {
      layout: "AppLayoutMain",
      role: [Roles.ROLE_PATIENT]
    },
  },
  {
    path: "/pregnancies",
    name: "PregnanciesPage",
    component: () => import("@/pages/PregnanciesPage.vue"),
    meta: {
      layout: "AppLayoutMain",
      role: [Roles.ROLE_DOCTOR, Roles.ROLE_NURSE]
    },
  },
  {
    path: "/pregnancy/:id",
    name: "PregnancyPage",
    component: () => import("@/pages/PregnancyPage.vue"),
    meta: {
      layout: "AppLayoutMain",
      role: [Roles.ROLE_DOCTOR, Roles.ROLE_NURSE, Roles.ROLE_PATIENT]
    },
  },
  {
    path: "/appointments/not-processed",
    name: "NotProcessedAppointmentsPage",
    component: () => import("@/pages/NotProcessedAppointmentsPage.vue"),
    meta: {
      layout: "AppLayoutMain",
      role: [Roles.ROLE_DOCTOR, Roles.ROLE_NURSE]
    },
  },
  {
    path: "/appointment/:id",
    name: "AppointmentPage",
    component: () => import("@/pages/AppointmentPage.vue"),
    meta: {
      layout: "AppLayoutMain",
      role: [Roles.ROLE_DOCTOR, Roles.ROLE_NURSE]
    },
  },
  {
    path: "/ogtt-table",
    name: "OgttTestTablePage",
    component: () => import("@/pages/OgttTestTablePage.vue"),
    meta: {
      layout: "AppLayoutMain",
      role: [Roles.ROLE_DOCTOR, Roles.ROLE_NURSE, Roles.ROLE_PATIENT]
    }
  },
  {
    path: "/ogtt",
    name: "OgttTestPage",
    component: () => import("@/pages/OgttTestPage.vue"),
    meta: {
      layout: "AppLayoutMain",
      role: [Roles.ROLE_DOCTOR, Roles.ROLE_NURSE, Roles.ROLE_PATIENT]
    }
  },
  {
    path: "/daily-glucose-level",
    name: "DailyGlucoseLevelPage",
    component: () => import("@/pages/DailyGlucoseLevelPage.vue"),
    meta: {
      layout: "AppLayoutMain",
    }
  },
  {
    path: "/risks",
    name: "RisksPage",
    component: () => import("@/pages/RisksPage.vue"),
    meta: {
      layout: "AppLayoutMain",
      role: [Roles.ROLE_DOCTOR]
    }
  },
  {
    path: "/births",
    name: "BirthsPage",
    component: () => import("@/pages/BirthsPage.vue"),
    meta: {
      layout: "AppLayoutMain",
      role: [Roles.ROLE_DOCTOR, Roles.ROLE_NURSE]
    }
  },
  {
    path: '/ctgs',
    name: 'CTGTable',
    component: () => import("@/pages/CTGsPage.vue"),
    meta: {
      layout: "AppLayoutMain",
    }
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach((to, from, next) => {
  const { role} = to.meta;
	if(role){
		const userRole = getRole();
		if(role.length && !role.includes(userRole)){
			return next({path: 'auth'});
		}

	}
	next();
});

router.afterEach(() => {
  setTimeout(() => {
    $('.selectpicker').selectpicker('refresh');
  }, 100);
});

export default router;
