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
      <router-link class="link api8" to="/home2">
        <img class="api8" src="../assets/imagenes/logo.png" alt="Logo">
      </router-link>
    </header>
    <nav class="menu">
    <router-link class="menu-item" to="/perfil">
      Mi Perfil
    </router-link>
    <router-link class="menu-item" to="/Contacto">
      Ayuda
    </router-link>
    <router-link class="menu-item cerrar-sesion" to="/inicioSesion">
      Cerrar Sesión
    </router-link>
  </nav>


</template>


<script setup>

</script>

<style>
*{
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}
.menu {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  text-align: center;
  background-color: #333;
  padding: 20px;
  border-radius: 8px;
  position: absolute;
  width: 300px;
  height: 200px;
  left: 40%;
  top: 35%;
}

.menu-item {
  color: white;
  text-decoration: none;
  margin-bottom: 15px;
  padding: 10px 0;
  width: 100%;
  font-size: 18px;
  transition: color 0.3s ease;
}

.menu-item:hover {
  color: #00bfff;
}

.cerrar-sesion {
  color: #ff4c4c;
}

.cerrar-sesion:hover {
  color: #ff7777;
}

</style>