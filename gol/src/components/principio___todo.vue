<template>
  <header class="casa_cabeza">
    <router-link id="casa_HOME" class="casa_home" to="/principal2">
      <img id="casa_logo" src="../src/assets/imagenes/logo.png" alt="logo">
    </router-link>
    <li>
      <principal></principal>
    </li>
  </header>
  <router-view></router-view>
</template>


<script setup>
import principal from './principal.vue';
</script>

<style>
body {
  background: 
    linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)), 
    url('../src/assets/imagenes/fondo.jpeg');
  background-size: cover;
  background-attachment: fixed;
  background-position: center;
  background-repeat: no-repeat;
  height: auto;
}

#casa_logo {
  filter: drop-shadow(1px 1px 2px rgb(0, 0, 0));
  position: absolute;
  right: 1100px;
  top: -250px;
  height: auto;
  width: 500px;
}

#casa_logo:hover {
  filter: drop-shadow(1px 1px 2px rgb(255, 255, 255));
}

.casa_cabeza {
  position: fixed;
  left: 960px;
  bottom: 650px;
  height: auto;
  width: auto;
  z-index: 999;
}

li {
  list-style: none;
}

body {
  color: azure;
}
</style>
