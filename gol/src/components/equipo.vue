<template>
  <header class="header1">
    <router-link class="link perfil" to="/perfil">
      <img class="api1" src="../assets/iconos header/perfil-del-usuario.png" alt="Perfil" />
    </router-link>
    <router-link class="link home" to="/home2">
      <img class="api2" src="../assets/iconos header/hogar.png" alt="Home" />
    </router-link>
    <router-link class="link torneos" to="/torneos">
      <img class="api3" src="../assets/iconos header/torneo.png" alt="Torneo" />
    </router-link>
    <router-link class="link equipo" to="/equipos">
      <img class="api5" src="../assets/iconos header/clan.png" alt="Equipo" />
    </router-link>
    <router-link class="link-video" to="/videos">
      <img class="api4" src="../assets/iconos header/reproduccion-de-video.png" alt="Video" />
    </router-link>
    <router-link class="link api8" to="/home2">
      <img class="api8" src="../assets/imagenes/logo.png" alt="Logo" />
    </router-link>
  </header>

  <div v-if="!tiene" class="container-custom">
    <div v-for="(item, index) in lista" :key="index" class="card-custom">
      <img :src="imagenes[index]" class="card-img-top-custom" alt="Imagen de tarjeta" />
      <div class="card-body-custom">
        <h5 class="card-title-custom">{{ item }}</h5>
        <p class="card-text-custom">Nombre: {{ desc[index] }}</p>
        <p class="card-text-custom">ID: {{ id[index] }}</p>
        <a href="#" @click.prevent="seleccionarEquipo(item)" class="btn-custom"><router-link to="/formulario">Unirse</router-link></a>
      </div>
    </div>
  </div>
  <div v-if="tiene">
  <h1>Tienes equipo</h1>
</div>

<input type="text" id="buscar-custom" v-model="buscar" placeholder="Buscar" />

<div v-for="(i, index) in lista" :key="index">
  <li v-if="buscar && i === buscar">
    <div id="fil-custom" class="container-custom">
      <div class="card-custom" id="card2-custom">
        <img :src="imagenes[index]" class="card-img-top-custom" alt="Imagen de tarjeta" />
        <div class="card-body-custom">
          <h5 class="card-title-custom">{{ i }}</h5>
          <p class="card-text-custom">Nombre: {{ desc[index] }}</p>
          <p class="card-text-custom">ID: {{ id[index] }}</p>
          <a href="#" @click.prevent="seleccionarEquipo(i)" class="btn-custom"><router-link to="/formulario">Unirse</router-link></a>

        </div>
      </div>
    </div>
  </li>
</div>

</template>

<script setup>
import { ref } from 'vue';
import Swal from 'sweetalert2';

const buscar = ref("");
const lista = ref(["buenosdias", "brasil", "argentina", "equipoPython", "brasil", "jose", "andres", "diego", "portero", "jaja", "los hackers"]);
const imagenes = ref([
  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwxZyjNEOX9cXrGZz293vqKWAL0kEK_lLltA&s",
  "https://www.shutterstock.com/image-vector/assassin-ninja-esport-gaming-mascot-600nw-2244091989.jpg",
  "https://i.pinimg.com/474x/2b/0c/58/2b0c581f8208cc114a3c6c560275fec1.jpg",
  "https://i.pinimg.com/originals/77/b6/6c/77b66c086174208fac7b59a428cd6274.jpg",
  "https://cdnb.artstation.com/p/assets/images/images/028/491/475/large/thales-muchante-playboys.jpg?1594647464",
  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwxZyjNEOX9cXrGZz293vqKWAL0kEK_lLltA&s",
  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwxZyjNEOX9cXrGZz293vqKWAL0kEK_lLltA&s",
  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwxZyjNEOX9cXrGZz293vqKWAL0kEK_lLltA&s",
  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwxZyjNEOX9cXrGZz293vqKWAL0kEK_lLltA&s",
  "https://www.shutterstock.com/image-vector/assassin-ninja-esport-gaming-mascot-600nw-2244091989.jpg",
  "https://www.metafrase.com/blog/wp-content/uploads/sites/4/2023/09/hacker-fb-dp-photo-9-jpg.webp"
]);
const desc = ref(["soy malo", "soy pro", "diego pro xd", "agt", "Jose andres", "jose", "los mejores"]);
const tiene = ref(false);
const id = ref(["1", "2", "3", "4", "6", "7", "8", "9", "10", "11", "12", "13", "14"]);

const seleccionarEquipo = (equipo) => {
  Swal.fire({
    icon: 'success',
    title: `¡Equipo ${equipo} seleccionado!`,
    text: 'Ahora puedes completar el formulario y enviar tu solicitud.',
    timer: 3000,
    showConfirmButton: false
  });
};
</script>

<style>
#card2-custom {
  background-color: black;
  color: #ffffff;
  border-color: rgb(0, 0, 0);
  border-style: solid;
  border-radius: 0%;
  background-image: url("https://media.istockphoto.com/id/1293988714/es/foto/fondo-dorado-metal-pulido-dorado-con-textura-de-acero.jpg?s=612x612&w=0&k=20&c=dYBE-ZrxpIsKbkVgbSFkUvYcymSjyjTr9j61tQKsoXI=");
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: absolute;
  left: 500%;
}

#fil-custom {
  display: flex;
  flex-direction: column;
  align-items: center;
  top: 20%;
  width: 10%;
  font-size: 20px;
}

.container-custom {
  display: flex;
  flex-wrap: wrap;
  height: 100%;
  width: 100%;
  gap: 1rem;
  margin-top: 20px;
  position: absolute;
  color: black;
  top: 80%;
  left: 0;
}

.card-custom {
  width: 18rem;
  background-color: rgb(21, 21, 21);
  transition: transform 0.5s;
  border-color: rgba(98, 96, 96, 0.278);
  border-style: solid;
  color: white;
  border-width: 1px;
  margin-bottom: 5%;
}

.card-custom:hover {
  transform: scale(1.05);
  box-shadow: 0 0 40px rgb(255, 230, 0);
}

.card-img-top-custom {
  width: 100%;
  border: 5px solid transparent;
  border-image: linear-gradient(to right, #FFD700, #FFFFFF) 1;
  border-style: solid;
}

.btn-custom {
  margin-top: 1rem;
  background-color: rgba(255, 255, 255, 0.71);
  text-shadow: 0 0 2px #FFD700;
  border-color: black;
  font-size: 20px;
  color: black;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}

#buscar-custom {
  position: absolute;
  height: 5%;
  width: 25%;
  left: 10%;
  top: 40%;
  font-size: 20px;
  border-color: #FFD700;
  font-family: monospace;
  border-style: solid;
  border-width: 3px;
  border-radius: 15px;
  text-align: center;
}

#buscar-custom {
  transform: none;
  transition: none;
}
</style>
