import { createRouter,createWebHistory } from "vue-router";
import sobreNosotros from "@/components/sobreNosotros.vue";
import componente from "@/components/componente.vue";
import invitado from "@/components/invitado.vue";
import principal2 from "@/components/principal2.vue";
import Perfil from "@/components/Perfil.vue";
import Home2 from "@/components/home2.vue";
import Actualizar_perfil from "@/components/actualizar_perfil.vue";
import equipo from "@/components/equipo.vue";
import videos from "@/components/videos.vue";
import torneos from "@/components/torneos.vue";
import aplicacion from "@/components/aplicacion.vue";
import inicioSesion from "@/components/inicioSesion.vue";
import creacion_torneo from "@/components/creacion_torneo.vue";
import Contacto from "@/components/Contacto.vue";
import Formulario_join from "@/components/Formulario_join.vue";
import redes from "@/components/redes.vue";
import video_home from "@/components/video_home.vue";
const routes=[
  {
        path:'/principal2',
        name:'home',
        component:principal2

  },
    { 
        path:'/Contacto',
        name:'Contacto',
        component:Contacto
    },
    {
        path: '/componente',
        name: 'componente',
        component: componente
      },
      {
        path: '/invitado',
        name: 'invitado',
        component: invitado
      },
      {
        path: '/sobreNosotros',
        name: 'sobreNosotros',
        component: sobreNosotros
      },
      {
        path: '/perfil',
        name: 'perfil',
        component: Perfil
      },
      {
        path: '/home2',
        name: 'home',
        component: Home2
      },
      {
        path: '/actualizar_perfil',
        name: 'actualizar_perfil',
        component: Actualizar_perfil
      },

      {
        path: '/equipos',
        name: 'equipos',
        component: equipo
      },
      {
        path: '/videos',
        name: 'videos',
        component: videos
      },
      {
        path: '/torneos',
        name: 'torneos',
        component: torneos
      },
    {
      path: '/aplicacion',
      name: 'aplicacion',
      component: Perfil
    },{
      path: '/inicioSesion',
      name: 'inicioSesion',
      component: inicioSesion
    },{
      path: '/creacion_torneo',
      name: 'creacion_torneo',
      component: creacion_torneo
    },{
      path: '/formulario',
      name: 'formulario_join',
      component: Formulario_join
    },
    {
      path:'/redes',
      name:'redes',
      component:redes

    },
    {
      path:'/home_video',
      name:'video',
      component:video_home

    },

];
const router=createRouter({
    history:createWebHistory(),
    routes
})
export default router