<template>
        <header class="header1">
      <router-link class="link perfil" to="/perfil">
        <img class="api1" src="../assets/iconos header/perfil-del-usuario.png" alt="Perfil">
      </router-link>
      <router-link class="link home" to="/home2">
        <img class="api2" src="../assets/iconos header/hogar.png" alt="Home">
      </router-link>
      <router-link class="link torneos" to="/torneos">
        <img class="api3" src="../assets/iconos header/torneo.png" alt="Torneo">
      </router-link>
      <router-link class="link equipo" to="/equipos">
        <img class="api5" src="../assets/iconos header/clan.png" alt="Equipo">
      </router-link>
      <router-link class="link-video" to="/videos" >
        <img class="api4" src="../assets/iconos header/reproduccion-de-video.png" alt="Video">
      </router-link>
      <router-link class="link api8" to="/home">
        <img class="api8" src="../assets/imagenes/logo.png" alt="Logo">
      </router-link>
    </header>

    <main>
    </main>
  </template>
  <script setup>
  import { ref, onMounted } from 'vue';
  
  const texto = ref("");
  
  // Usar onMounted para asegurarse de que el DOM está listo antes de buscar el elemento
  onMounted(() => {
    const linkElement = document.querySelector('.router-link-active.home');
    if (linkElement) {
      linkElement.classList.remove('router-link-active');
    }
  });
  import Perfil from './Perfil.vue';
  </script>
  
  <style>
  /* Estilos para enlaces activos */
  a.router-link-active, a.router-link-exact-active {
    color: inherit;
    text-decoration: none;
    background-color: none;
  }
  
  /* Estilos generales */
  .link {
    display: inline-block;
    margin: 0;
    padding: 0;
  }
  
  /* Estilos del header */
  .header1 {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    padding: 10px;
    z-index: 1000;
    background: linear-gradient(rgb(129, 126, 126), rgb(255, 255, 255));
    display: flex;
    align-items: center;
    justify-content: space-around;
    flex-wrap: wrap;
    height: auto;
    overflow: hidden;

  }

  
  /* Estilos para las imágenes */
  .api1, .api2, .api3, .api4, .api5, .api6 {
    filter: drop-shadow(0 0 1px rgb(0, 0, 0));
    transition: transform 0.5s;
    height: 55px;
    width: auto;
    margin: 0 5px;
  }
  
  /* Ajuste específico para la imagen del logo */
  .api8 {
    position: relative;
    height: 100px;
    width: auto;
    margin-left: 10px;
    border-right: 2px solid rgb(3, 0, 0);
  }
  
  .api8:hover {
    transform: scale(1.1);
    filter: drop-shadow(0 0 3px rgb(0, 174, 255));
  }
  
  /* Hover para las imágenes */
  .api1:hover, .api2:hover, .api3:hover, .api4:hover, .api5:hover, .api6:hover {
    transform: scale(1.1);
    filter: drop-shadow(0 0 3px rgb(0, 174, 255));
  }
  
  /* Media queries para dispositivos móviles */
  @media (max-width: 768px) {
    .header {
      padding: 5px;
      flex-direction: column;
      align-items: center;
      justify-content: center;
    }
    .api1, .api2, .api3, .api4, .api5, .api6, .api8 {
      height: 40px;
      margin: 5px 0;
    }
    .api8 {
      height: 50px;
      margin-left: 0;
    }
  }
  </style>
  

  