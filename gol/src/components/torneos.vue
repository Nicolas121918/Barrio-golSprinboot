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

    <div class="main-container">
      <h1 class="titulo_torneo">Lista de Torneos y Partidos</h1>
      
      <!-- Barra de búsqueda y botón "Ver Juegos" -->
      <div class="search-container">
        <input 
          v-model="searchQuery" 
          type="text" 
          placeholder="Buscar torneos o partidos..." 
          class="search-input"
        />
        <button @click="viewGames" class="view-games-button">Ver Juegos</button>
        <router-link class="view-games-button2" to="/creacion_torneo">
        crear evento
      </router-link>
      </div>
  
      <div class="card-list">
        <div v-for="(item, index) in filteredList" :key="index" class="card3">
          <!-- Si es un torneo -->
          <div v-if="item.tipo === 'torneo'">
            <div class="card-header-tor">
              <img :src="item.logo" alt="Logo del Torneo" class="logo-img">
              <div class="card-info-tor">
                <h2 class="titu">{{ item.nombre }}</h2>
                <p>Participantes: {{ item.numeroParticipantes }}</p>
                <p>Precio de Inscripción: ${{ item.precioInscripcion }}</p>
                <p>Precio de Arbitraje por partido: ${{ item.precioArbitraje }}</p>
              </div>
            </div>
            <div class="rules-container">
              <button @mouseover="showRules('torneo', index)" @mouseleave="hideRules('torneo', index)" class="torn_boton">Ver Reglas</button>
              <div v-if="activeRules.torneo === index" class="rules-info-tor">
                <p class="reglas">Reglas del Torneo {{ item.nombre }}</p>
                <!-- Agrega aquí el contenido de las reglas -->
              </div>
            </div>
            <button class="action-button-tor" @click="inscribirTorneo(index)">Inscribir</button>
          </div>
          
          <!-- Si es un partido -->
          <div v-if="item.tipo === 'partido'" class="card4">
            <div class="card-header-match">
              <div class="card-info-match">
                <h2 class="titu2">Partido {{ index + 1 }}</h2>
                <p>Hora: {{ item.hora }}</p>
                <p>Lugar: {{ item.lugar }}</p>
                <p>Número de partidos: {{ item.numeroPartidos }}</p>
                <p>Apuesta: ${{ item.apuesta }}</p>
              </div>
            </div>
            <div class="rules-container">
              <button @mouseover="showRules('partido', index)" @mouseleave="hideRules('partido', index)" class="torn_boton">Ver Reglas</button>
              <div v-if="activeRules.partido === index" class="rules-info-match">
                <p class="reglas">Reglas del Partido {{ index + 1 }}</p>
                <!-- Agrega aquí el contenido de las reglas -->
              </div>
            </div>
            <button class="action-button-match" @click="unirPartido(index)">Unir</button>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  
  
  <script setup>
  import router from '@/mis_rutas/rutas';
import { ref, computed } from 'vue';
  
  // Datos de ejemplo
  const torneos = ref([
    {
      tipo: "torneo",
      nombre: "Torneo Nacional de Fútbol",
      numeroParticipantes: 16,
      precioInscripcion: 200000,
      precioArbitraje: 50000,
      logo: "https://www.universidadviu.com/sites/universidadviu.com/files/images/torneos%20de%20LOL.jpg" // URL del logo del torneo
    },
    {
      tipo: "torneo",
      nombre: "Copa Juvenil de Baloncesto",
      numeroParticipantes: 12,
      precioInscripcion: 150000,
      precioArbitraje: 40000,
      logo: "https://media.istockphoto.com/id/1163749879/es/foto/jugador-de-f%C3%BAtbol-patea-una-pelota.jpg?s=612x612&w=0&k=20&c=NFc1RIf2AQRCBxp5Bs3uAguz9Hga-KheHK_kp-lbW2w=" // URL del logo del torneo
    }
    // Otros torneos...
  ]);
  
  const partidos = ref([
    {
      tipo: "partido",
      hora: "15:00",
      lugar: "Estadio Nacional",
      numeroPartidos: 5,
      apuesta: 100000
    },
    {
      tipo: "partido",
      hora: "18:00",
      lugar: "Campo de Juego",
      numeroPartidos: 3,
      apuesta: 50000
    }
    // Otros partidos...
  ]);
  
  // Combinar torneos y partidos en un solo array
  const combinedList = ref([...torneos.value, ...partidos.value]);
  
  // Función para mezclar la lista de manera aleatoria
  const shuffleArray = (array) => {
    for (let i = array.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
  };
  
  // Mezclar la lista combinada al cargar la página
  combinedList.value = shuffleArray(combinedList.value);
  
  const activeRules = ref({ torneo: null, partido: null });
  
  const showRules = (type, index) => {
    activeRules.value[type] = index;
  };
  
  const hideRules = (type, index) => {
    if (activeRules.value[type] === index) {
      activeRules.value[type] = null;
    }
  };
  
  const inscribirTorneo = (index) => {
    alert(`Inscripción al torneo ${index + 1}`);
  };
  
  const unirPartido = (index) => {
    alert(`Unirse al partido ${index + 1}`);
  };
  
  // Buscador
  const searchQuery = ref('');
  const filteredList = computed(() => {
    const query = searchQuery.value.toLowerCase();
    return combinedList.value.filter(item => {
      if (item.tipo === 'torneo') {
        return item.nombre.toLowerCase().includes(query);
      } else if (item.tipo === 'partido') {
        return item.lugar.toLowerCase().includes(query) || item.hora.toLowerCase().includes(query);
      }
      return false;
    });
  });
  
  // Función para ver juegos (ejemplo de funcionalidad)
  const viewGames = () => {
    alert('Ver Juegos');
  };
  </script>
  
  
  <style>
  .main-container {
  padding: 20px;
  position: relative;
  top: 30%;
  left: 0%;
  text-align: center;
}

.header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
  
}

.search-bar {
  width: 40%;
  padding: 10px;
  font-size: 16px;
  position: relative;
  left: 100%;
}

.view-games-button {
  
  background-color: #0c0452;
  color: white;
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  transition: background-color 0.3s ease;
  position: relative;

}
.view-games-button2{
  background-color: #0099ff;
  color: white;
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  transition: background-color 0.3s ease;
  position: relative;
  left: 40%;
}

.view-games-button:hover {
  background-color: #00ccff;
}


.card-list {
  display: flex;
  flex-direction: column; /* Mostrar en vertical */
  gap: 20px;
}

.card3 {
  width: 60vw; /* 60% del ancho de la vista del usuario */
  min-height: 100%;
  min-width: 150%;
  background-color: #000000;
  padding: 15px;
  box-shadow: 0px 4px 2px rgb(255, 255, 255);
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  border: none; /* Sin bordes redondeados */
  box-sizing: border-box; /* Asegura que el padding no aumente el ancho total */
  overflow: hidden; /* Asegura que no haya bordes redondeados */
  position: relative;
  right: 10%;
}

.card-header-tor, .card-header-match {
  display: flex;
  align-items: center;
  gap: 15px;
}

.logo-img {
  width: 80px; /* Ajusta el tamaño del logo */
  height: 80px; /* Ajusta el tamaño del logo */
  object-fit: cover;
}

.card-info-tor, .card-info-match {
  flex-grow: 1;
  position: relative;
  text-align: left;
  font-size: 120%;
  width: 10%;
  display: inline;
}

.rules-container {
  position: relative;
  height: auto;
  font-size: 90%;
}

.card-info-tor, .card-info-match {
  flex-grow: 0; /* Elimina el crecimiento del elemento */
  text-align: left;
  font-size: 120%;
  width: auto; /* Elimina la ocupación total del ancho */
  display: inline-block; /* Solo ocupa el ancho del contenido */
}

.titulo_torneo {
  position: relative;
  left: 20%;
  text-shadow: 0 0 6px rgb(255, 255, 255);
  color: #ffffff;
  font-size: 250%;
}

.action-button-tor, .action-button-match {
  margin-top: 10px;
  background-image: url("https://static.vecteezy.com/system/resources/thumbnails/000/549/015/small/vector-apr-2018-19.jpg");
  height: auto;
  color: white;
  padding: 10px;
  font-size: 300%;
  cursor: pointer;
  position: absolute;
  left: 70%;
  bottom: 35%;
  font-family: 'Times New Roman', Times, serif;
  text-shadow: 0 0 5px black;
  font-weight: bold;
  transition: all 0.3s ease; /* Transición suave */
  box-shadow: 0 8px 15px rgba(0, 0, 0, 0.1);
}

.torn_boton {
  color: rgb(255, 255, 255);
  position: relative;
}

.reglas {
  background-color: rgb(90, 90, 90);
  width: auto;
  height: auto;
}

.titu {
  font-size: 170%;
  font-weight: bold;
  position: relative;
  left: 100%;
  background-image: url("https://static.vecteezy.com/system/resources/thumbnails/000/549/015/small/vector-apr-2018-19.jpg");
  background-size: cover; /* Ajusta el tamaño de la imagen para que cubra todo el texto */
  background-clip: text;
  -webkit-background-clip: text; /* Para navegadores que requieren prefijo */
  color: transparent; /* Hace el texto transparente para mostrar el fondo */
  text-shadow: none; /* Elimina sombras en el texto si hay */
}
.search-input{
  font-size: 140%;
}
.titu2 {
  font-size: 170%;
  font-weight: bold;
  position: relative;
  left: 300%;
  background-image: url("https://static.vecteezy.com/system/resources/thumbnails/000/549/015/small/vector-apr-2018-19.jpg");
  background-size: cover; /* Ajusta el tamaño de la imagen para que cubra todo el texto */
  background-clip: text;
  -webkit-background-clip: text; /* Para navegadores que requieren prefijo */
  color: transparent; /* Hace el texto transparente para mostrar el fondo */
  text-shadow: none;
}
  </style>
  