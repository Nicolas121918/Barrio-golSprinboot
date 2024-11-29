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
    <router-link class="link-video" to="/videos">
      <img class="api4" src="../assets/iconos header/reproduccion-de-video.png" alt="Video">
    </router-link>
    <router-link class="link api8" to="/home2">
      <img class="api8" src="../assets/imagenes/logo.png" alt="Logo">
    </router-link>
  </header>

  <h1 id="datos">Datos De su Perfil</h1>

  <section class="fondo" v-if="isUserLoaded">
    <img :src="imagen" alt="Imagen de perfil" />
    <router-link class="actualizar_perfil" to="/actualizar_perfil">Actualizar Datos</router-link>
    <router-link class="equipos2" to="/equipos">
      <img class="clan" src="../assets/iconos header/clan.png" alt="">
    </router-link>
    <div class="datos-basicos">
      <h2 class="texto-2">Nombre: {{ nombre }}</h2>
      <h2 class="texto-2">Correo: {{ correo }}</h2>
    <h2 class="texto-2">Ciudad: {{ ciudad }}</h2>
    <h2 class="texto-2">Descripción: {{ descripcion }}</h2>
    <h2 class="texto-2">Fecha de nacimiento: {{ fecha_nacimiento }} </h2>
    </div>
   
    <article class="fondo_negro"></article>
  </section>
  <section v-else>
    <h2>Cargando datos del perfil...</h2>
  </section>
</template>

<script setup>
import { ref, onMounted } from 'vue';

const nombre = ref('');
const ciudad = ref('');
const correo = ref('');
const descripcion = ref('');
const fecha_nacimiento = ref('');

const isUserLoaded = ref(false);

const loadProfileFromStorage = () => {
  const user = JSON.parse(localStorage.getItem('usuario'));
  if (user) {
    nombre.value = user.nombreUsuario || 'Sin nombre';
    correo.value = user.correo || 'Sin correo';
    ciudad.value = user.ciudad || 'Sin ciudad';
    descripcion.value = user.descripcion || 'Sin descripción';
    fecha_nacimiento.value= user.fechaNacimiento || 'Sin descripcion';

    isUserLoaded.value = true; // Cambia el estado a true
  } else {
    console.error('No se encontró usuario en localStorage');
  }
};

// Llamar a la función al montar el componente
onMounted(() => {
  loadProfileFromStorage();
});
</script>



<style>
.datos-basicos {
    max-width: 100%; 
    box-sizing: border-box; 
    overflow: hidden; 
}

.texto-2 {
    margin: 10px 0; 
    color: white;
    text-shadow: 0 0 4px rgb(0, 0, 0);
    font-family: monospace;
    font-size: 20px;
}
body{
  overflow-x: hidden;
}
.clan {
  height: 70px;
  position: absolute;
  background-color: rgb(255, 255, 255);
  border-radius: 50%;
  border: 4px solid rgba(255, 255, 255, 0.986);
  left: 300px;
}

.actualizar_perfil {
  background-color: rgb(154, 153, 153);
  position: absolute;
  color: rgb(0, 0, 0);
  left: 1%;
  top: 20%;
  font-family: monospace;
  font-size: 20px;
}

.equipos2 {
  position: absolute;
  color: rgb(0, 0, 0);
  left: 70%;
  top: 20%;
  font-family: monospace;
  font-size: 20px;
}
.equipos2:hover {
  box-shadow: 0 0 100% rgb(255, 2, 2);
  transform: scale(1.05);
}
.fondo_negro{ 
  background-color: rgba(0, 0, 0, 0.541);
  position: absolute;
  width: 100%;
  height: 77%;
  left: 0;
  top: 0;
  z-index: -4;
}

.actualizar_perfil {
  background: linear-gradient(45deg, #bdbebe, #575757); /* Degradado azul */
  
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 12px;
  position: absolute;
  left: 1%;
  top: 20%;
  font-family: 'Arial', sans-serif;
  font-size: 20px;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease; /* Suaviza las transiciones */
}

.actualizar_perfil:hover {
  background-color: rgba(127, 255, 212, 0.5);
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2), 0 2px 6px blue;
  text-shadow: 0 0 3px black;
  transform: scale(1.1);
}


#imagen_perfil {
  position: absolute;
  left: 30%;
  top: 35%;
  border-radius: 50%; 
  height: 200px;
  width: 200px; 
  box-shadow: 0 0 10px rgb(255, 255, 255);
  border: 4px solid rgba(0, 0, 0, 0.986);
}

#imagen_perfil:hover {
  box-shadow: 0 0 40px rgb(0, 238, 255);
  transform: scale(1.05);
}

#datos {
  color: rgb(8, 103, 192);
  width: 400%;
  height: auto;
  font-size: 300%;
  text-align: center;
  text-shadow: 0 0 3px rgb(255, 255, 255);
  position: relative;
  bottom: 60%;
  right: 90%;
  margin-bottom: 140px;
}

.texto-2:hover, #datos:hover {
  color: aquamarine;
  text-shadow: 0 0 4px rgb(255, 255, 255);
  
}

.linea {
  position: absolute;
  background-color: rgb(255, 255, 255);
  width: 1535px;
  height: 5px;
  right: 0;
  top: 550px;
}

.videos {
  width: 100%;
  height: 100%; 
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 600px;
  right: 5px;
}

video {
  width: 500px;
  height: 800px;
}

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

/* Ajuste solo para el texto "Datos de su Perfil" y el icono de equipo en responsive */
@media (max-width: 768px) {
  #datos {
    font-size: 2rem; /* Reducir el tamaño del texto en pantallas más pequeñas */
    right: 0; /* Ajuste de la posición */
    bottom: 0; /* Ajuste de la posición */
  }

  .equipos2 {
    left: 50%; /* Centrar el icono de equipo en pantallas pequeñas */
    transform: translateX(-50%);
    top: 40%;
  }
}
</style>
