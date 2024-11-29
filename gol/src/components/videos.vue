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

    <div class="contenedor">
      <div class="videos-container" ref="videosContainer">
        <!-- Bucle para mostrar los videos -->
        <div v-for="(video, index) in videos" :key="index" class="video-wrapper">
          <video
            ref="videos"
            :src="video.url"
            controls
            loop
            class="video-item"
          ></video>
        </div>
      </div>
      
  
      <!-- Botón flotante para subir un video -->
      <div class="boton-subir">
        <button @click="subirVideo">
          Subir Video
        </button>
      </div>
  
      <!-- Botones de navegación para arriba y abajo -->
      <div class="botones-navegacion">
        <button @click="scrollUp">
          <img src="https://img.icons8.com/ios-filled/50/ffffff/up.png" alt="Arriba" />
        </button>
        <button @click="scrollDown">
          <img src="https://img.icons8.com/ios-filled/50/ffffff/down.png" alt="Abajo" />
        </button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted, onBeforeUnmount } from 'vue';
  
  // Lista de videos
  const videos = ref([
  { url: 'https://www.w3schools.com/html/mov_bbb.mp4' },
  { url: 'https://www.w3schools.com/html/movie.mp4' },
  { url: 'https://samplelib.com/lib/preview/mp4/sample-5s.mp4' },
  { url: 'https://samplelib.com/lib/preview/mp4/sample-20s.mp4' },
  { url: 'https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4' },
  { url: 'https://www.h264info.com/download/sample.mp4' },
  { url: 'https://www.pexels.com/video/3184436/download/' },
  
]);

  
  // Función para subir un nuevo video
  const subirVideo = () => {
    alert('Función para subir un video.');
    // Aquí podrías implementar la lógica para subir un video.
  };
  
  // Referencia al contenedor de videos
  const videosContainer = ref(null);
  const videoElements = ref([]); // Para almacenar las referencias de los videos
  
  // Función para hacer scroll hacia arriba
  const scrollUp = () => {
    const container = videosContainer.value;
    if (container) {
      container.scrollBy({
        top: -window.innerHeight, // Mueve hacia arriba una pantalla completa
        behavior: 'smooth' // Desplazamiento suave
      });
    }
  };
  
  // Función para hacer scroll hacia abajo
  const scrollDown = () => {
    const container = videosContainer.value;
    if (container) {
      container.scrollBy({
        top: window.innerHeight, // Mueve hacia abajo una pantalla completa
        behavior: 'smooth' // Desplazamiento suave
      });
    }
  };
  
  // Lógica para reproducir/pausar videos usando Intersection Observer
  let observer;
  
  onMounted(() => {
    videoElements.value = videosContainer.value.querySelectorAll('video');
    
    observer = new IntersectionObserver((entries) => {
      entries.forEach((entry) => {
        const video = entry.target;
        if (entry.isIntersecting) {
          video.play(); // Reproducir el video si es visible
        } else {
          video.pause(); // Pausar el video si no es visible
        }
      });
    }, {
      threshold: 0.5 // Se activará cuando al menos el 50% del video esté visible
    });
  
    // Observamos cada video
    videoElements.value.forEach((video) => observer.observe(video));
  });
  
  onBeforeUnmount(() => {
    // Limpiar el observer cuando el componente se desmonte
    if (observer) {
      observer.disconnect();
    }
  });
  </script>
  
  <style>
  /* Estilos globales */
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }
  
  body, html {
    height: 100%;
    font-family: Arial, sans-serif;
  }
  
  /* Estilos del contenedor de videos */
  .contenedor {
    display: flex;
    height: 100vh; /* Ocupa toda la altura de la pantalla */
    overflow: hidden;
    position: relative;
    background-color: black;
    top: 10%;
    left: 52%; /* Color de fondo negro para contraste */
  }
  
  /* Ajuste del contenedor de videos */
  .videos-container {
    flex-grow: 1;
    overflow-y: hidden;
  }
  
  /* Estilo para cada video */
  .video-wrapper {
    height: 100vh; /* Cada video ocupa toda la altura de la pantalla */
    display: flex;
    justify-content: center;
    align-items: center;
    scroll-snap-align: start; /* Alinea el video en el inicio del scroll */
    position: relative;
    overflow: hidden;
  }
  
  /* Estilo del video */
  .video-item {
    width: 100%;
    height: 100%;
    object-fit: cover; /* Ajusta el video para cubrir el contenedor sin distorsión */
    transition: transform 0.3s ease;
  }
  
  /* Botón flotante para subir video */
  .boton-subir {
    position: fixed;
    left: 2%;
    bottom: 70%;
    z-index: 10;
  }
  
  .boton-subir button {
    background: linear-gradient(135deg, #ffffff, #a09f9f, #5e5e5e);
    text-shadow: 0 0 2px rgb(51, 30, 30);
    color: rgb(0, 0, 0);
    font-size: 200%;
    width: 150%;
    height: auto;
    border: 2px solid black;
    justify-content: center;
    align-items: center;
    cursor: pointer;
    box-shadow: 0px 0px 2px rgb(255, 255, 255);    
  }
     .boton-subir button:hover {
    transform: scale(1.1);
    box-shadow: 0px 0px 10px rgba(0, 255, 242, 0.986);
  }
  
  .boton-subir button:active {
    transform: scale(1);
    box-shadow: none;
  }
  
  /* Botones de navegación (arriba y abajo) */
  .botones-navegacion {
    position: fixed;
    right: 25%;
    top: 50%;
    transform: translateY(-50%);
    display: flex;
    flex-direction: column;
    gap: 20px;
  }
  
  .botones-navegacion button {
    background-color: rgba(255, 255, 255, 0.1);
    border: none;
    width: 50px;
    height: 50px;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  
  .botones-navegacion button img {
    width: 25px;
    height: 25px;
  }
  
  .botones-navegacion button:hover {
    background-color: rgba(255, 255, 255, 0.3);
  }
  
  .botones-navegacion button:active {
    background-color: rgba(255, 255, 255, 0.5);
  }
  
  /* Ajustes para pantallas más pequeñas */
  @media (max-width: 768px) {
    .boton-subir {
      right: 10px;
      bottom: 50px;
    }
  
    .boton-subir button {
      width: 50px;
      height: 50px;
    }
  
    .boton-subir button img {
      width: 24px;
      height: 24px;
    }
  
    .botones-navegacion button {
      width: 40px;
      height: 40px;
    }
  
    .botones-navegacion button img {
      width: 20px;
    }
  }
  </style>