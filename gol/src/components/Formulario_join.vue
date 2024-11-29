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
  
    <section class="formulario_join">
      <h1 id="equipo_titulo">Únete a Nuestro Equipo de Fútbol</h1>
  
      <div class="form_container">
        <form @submit.prevent="enviarFormulario">
  <br>
  <label class="formulario_campo">
    <input class="Form_input" v-model="insertar.nombre" type="text" placeholder="Digite su nombre" required>
  </label>
  <br><br>
  <label class="formulario_campo">
    <input class="Form_input" v-model="insertar.edad" type="number" placeholder="Digite su edad" required>
  </label>
  <br><br>
  <label class="formulario_campo">
    <select v-model="insertar.posicion" required>
      <option disabled value="">Seleccione una posición de juego</option>
      <option value="Delantero">Delantero</option>
      <option value="Defensa">Defensa</option>
      <option value="Centrocampista">Centrocampista</option>
      <option value="Portero">Portero</option>
    </select>
  </label>
  <br><br>
  <label class="formulario_campo">
    <input class="Form_input" v-model="insertar.email" type="email" placeholder="Digite su Correo electrónico" required>
  </label>
  <br>
  <label class="formulario_campo">
    <input class="Form_input" v-model="insertar.celular" type="text" placeholder="Digite su celular" required>
  </label>
  <br><br>
  <label class="formulario_campo">
    <select v-model="insertar.equipo" required>
      <option disabled value="">Seleccione un equipo</option>
      <option v-for="equipo in equipos" :key="equipo">{{ equipo }}</option>
    </select>
  </label>
  <br><br>
  <button class="formulario_boton" type="submit">Enviar Solicitud</button>
</form>

      </div>
    </section>
  
    <footer class="animal">
      <a href="https://x.com/?lang=es"><img class="logos" src="../assets/logospng/gorjeo.png" alt=""></a>
      <a href="https://www.instagram.com/"><img class="logos" src="../assets/logospng/logotipo-de-instagram.png" alt=""></a>
      <a href="https://www.tiktok.com/@cool.sant.2000/video/7252833008783215877"><img class="logos" src="../assets/logospng/tik-tok (1).png" alt=""></a>
      <a href="https://web.whatsapp.com/"><img class="logos" src="../assets/logospng/whatsapp (1).png" alt=""></a>
    </footer>
  </template>
  
  <style>
  #equipo_titulo {
    position: absolute;
    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
    top: -20%;
    left: 4%;
    width: 200%;
    font-size: 50px;
    background-image: url('https://static.vecteezy.com/system/resources/thumbnails/000/549/015/small/vector-apr-2018-19.jpg');
    background-size: cover;
    color: transparent;
    background-clip: text;
    text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.158);
  }
  
  .formulario_join {
    position: relative;
    top: 15%;
    text-align: center;
  }
  
  * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
  }
  
  .form_container {
    background-color: rgb(0, 0, 0);
    border: 5px solid rgb(255, 255, 255);
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
    display: flex;
    flex-direction: column;
    gap: 10px;
    width: 100%;
    max-width: 400px;
    margin-left: 50%;
  }
  
  .Form_input {
    margin: 10px 0;
    width: 300px;
    padding: 5px;
    background-color: black;
    text-align: center;
    color: aliceblue;
  }
  
  .formulario_boton {
    background-image: url('https://static.vecteezy.com/system/resources/thumbnails/000/549/015/small/vector-apr-2018-19.jpg');
    background-size: cover;
    border: none;
    padding: 10px 20px;
    cursor: pointer;
    border-radius: 20px;
    text-align: center;
    font-size: 120%;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  }
  
  .logos {
    margin-left: 100px;
    position: relative;
    top: 20px;
    left: 500px;
    width: 70px;
    height: 50px;
    cursor: pointer;
  }
  
  input:hover, .form_container:hover{
    transform: scale(1.0);
    border-color: #FFD700;;
  }
  </style>
  
  <script>
import axios from 'axios';
import { ref, onMounted } from 'vue';
import Swal from 'sweetalert2';

export default {
  setup() {
    const insertar = ref({
      nombre: '',
      edad: '',
      posicion: '',
      email: '',
      celular: '',
      equipo: ''
    });

    const equipos = ref([]);

    const obtenerEquipos = async () => {
      try {
        const response = await axios.get('http://localhost:8000/equipo/lista');
        equipos.value = response.data;
      } catch (error) {
        console.error('Error al obtener los equipos:', error);
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'No se pudieron cargar los equipos. Intenta de nuevo más tarde.',
        });
      }
    };

    const enviarFormulario = async () => {
      const result = await Swal.fire({
        title: '¿Estás seguro?',
        text: `¿Quieres enviar tu solicitud para unirte al equipo ${insertar.value.equipo}?`,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Sí, enviar',
        cancelButtonText: 'No, cancelar',
      });

      if (result.isConfirmed) {
        try {
          const response = await axios.post('http://localhost:8000/jugadores', insertar.value);

          if (response.status === 200) {
            Swal.fire({
              icon: 'success',
              title: 'Solicitud enviada',
              text: 'Tu solicitud para unirte al equipo ha sido enviada correctamente.',
            });

            insertar.value = {
              nombre: '',
              edad: '',
              posicion: '',
              email: '',
              celular: '',
              equipo: ''
            };
          } else {
            Swal.fire({
              icon: 'error',
              title: 'Error',
              text: 'Hubo un problema al enviar tu solicitud. Inténtalo de nuevo.',
            });
          }
        } catch (error) {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Hubo un problema al enviar tu solicitud. Inténtalo de nuevo.',
          });
          console.error('Error al enviar la solicitud:', error);
        }
      }
    };

    onMounted(obtenerEquipos); // Llama a obtenerEquipos cuando el componente se monte

    return {
      insertar,
      equipos,
      enviarFormulario,
    };
  },
};
</script>
  