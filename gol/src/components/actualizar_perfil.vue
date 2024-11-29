
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
    <article class="fondo_negro2">

    </article>
    <section v-if="mostrar" class="Actualizar_contenedor">
      <router-link class="volver_actualizar" to="/perfil">
        volver
      </router-link>
      <h1 class="actualizar_h1"> QUE DESEA ACTUALIZAR</h1>
      <input v-on:click="cambiar_foto" class="Actualizar_button" type="button" value="Cambiar Foto de perfil">
      <br>
      <br>
      <button @click="cambiar_nombre" class="Actualizar_button">Cambiar Nombre</button>
      <br>
      <br>
      <input v-on:click="cambiar_ciudad" class="Actualizar_button" type="button" value="Cambiar Ciudad">
      <br>
      <br>
      <input v-on:click="cambiar_descripcion" class="Actualizar_button" type="button" value="Cambiar Descripcion">
      <br>
      <br>
    </section>
    <section class="nombre" v-if="nombre">
      <button v-on:click="volver" ><img class="salir" src="../assets/iconos header/emblemunreadable_93487 (1).png" alt=""></button>
      <form class="formulario_nombre" action="">
      NUEVO NOMBRE:
      <br>
      <input class="espacio_nombre" type="text">
      <br>
      <input class="cambiar_nombre" v-on:click="cambiar" type="button" value="cambiar">
    </form>
    </section>
    <section class="nombre" v-if="ciudad">
      <button v-on:click="volver" ><img class="salir" src="../assets/iconos header/emblemunreadable_93487 (1).png" alt=""></button>
      <form class="formulario_nombre" action="">
      CIUDAD:
      <br>
      <input class="espacio_nombre" type="text">
      <br>
      <input class="cambiar_nombre" v-on:click="cambiar" type="button" value="cambiar">
    </form>
    </section>
    <section class="nombre" v-if="descripcion">
      <button v-on:click="volver" ><img class="salir" src="../assets/iconos header/emblemunreadable_93487 (1).png" alt=""></button>
      <form class="formulario_nombre" action="">
      Descripcion:
      <br>
      <input class="espacio_nombre" type="text">
      <br>
      <input class="cambiar_nombre" v-on:click="cambiar" type="button" value="cambiar">
    </form>
    </section>
    <section class="nombre" v-if="foto">
      <button v-on:click="volver" ><img class="salir" src="../assets/iconos header/emblemunreadable_93487 (1).png" alt=""></button>
      <form class="formulario_nombre" action="">
      Seleccione foto de perfil
      <br>
      <input class="espacio_nombre" type="file" id="fileUpload" name="fileUpload" accept="image/*" multiple>
      
      <br>
      <input class="cambiar_nombre" v-on:click="cambiar" type="button" value="cambiar">
    </form>
    </section>
</template>

<style>
.fondo_negro2{
  background-color: rgba(0, 0, 0, 0.589);
  position: absolute;
  width: 100%;
  height: 100%;
  left: 0%;
  top: 0;
  z-index: -4;
}
.volver_actualizar{
  font-size: 200%;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  color: rgb(255, 0, 0);
  border-style: solid;
  position: relative;
  left: 44%;
  text-shadow: 0 0 2px rgb(214, 178, 178);
  background-color: rgb(255, 240, 244);
}
.volver_actualizar:hover{
  color: rgb(0, 0, 0);
  background-color: beige;
  text-shadow: 0 0 2px rgb(0, 238, 255);
}
.salir{
  position: absolute;
  height: 10%;
  left: 70%;
  top: 25%;
}
.salir:hover{
  transform: scale(1.1);
}
 
.nombre{
  background-color: black;
  font-size: 300%;
  width: 200%;
  text-align: center;
  font-family: 'Times New Roman', Times, serif;
  border: 10px;
  border-style: solid;
  text-decoration:underline;
  box-shadow: 0 0 10px rgb(251, 255, 255);
}
.cambiar_nombre{
  background-image: url('');
  font-size: 100%;
  text-shadow: 0 0 5px rgb(3, 73, 100);
  box-shadow: 0 0 10px rgb(4, 95, 131);
  text-align: center;
}
.espacio_nombre{
  font-size: 50%;
  text-align: center;
}
.formulario_nombre{
  margin: 5%;
}
.Actualizar_contenedor{
  position: relative;
  top: 30px;
  background-color: rgb(0, 0, 0);
  height: auto;
  left: 0%;
  width: 200%;
  text-align: center;
  border: 2%;
  border-style: solid;
  border-color: aliceblue;
}
.Actualizar_button{
  border: none;
  background-color: none;
  font-size: 200%;
  text-align:left;
  position: relative;
  font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  text-decoration:double;
  background-color: rgb(0, 0, 0);
  color: aliceblue;
  width: 100%;
  border-bottom: rgb(253, 253, 253);
  border-left: none;
  border: solid;
  width: 50%;
  text-align: center;
}
.Actualizar_button:hover{
  text-shadow: 1px rgb(56, 56, 56);
  color: rgb(0, 183, 255);
  transform: scale(1.1);
  
}
.actualizar_h1{
  background-color: rgb(255, 255, 255);
  border: 1px;
  border-color: rgb(255, 255, 255);
  border-style: solid;
  text-shadow: 0 0 2px black;
  margin: 5%;
  width: 100%;
  font-size: 200%;
  position: relative;
  left: -5%;
  color: rgb(0, 0, 0);
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}
</style>
<script setup>
import { ref } from 'vue';
const selector=document.querySelector('body');
var nombre = ref(false);
var ciudad = ref(false);
var descripcion = ref(false);
var mostrar = ref(true);
var foto=ref(false);

const cambiar_nombre = () => {
  mostrar.value = false;
  nombre.value = true;
  alert("cambiando nombre...");
};
const cambiar_ciudad = () => {
  mostrar.value = false;
  ciudad.value = true;

  alert("cambiando ciudad...");
};
const cambiar_descripcion = () => {
  mostrar.value = false;
  descripcion.value = true;
  alert("cambiando descripcion...");
  selector.style.backgroundColor=red;
};
const cambiar_foto = () => {
  mostrar.value = false;
  foto.value = true;
  alert("cambiando foto...");
  selector.style.backgroundColor=red;
};
const volver = () => {
  mostrar.value = true;
  nombre.value = false;
  ciudad.value = false;
  foto.value = false;
  descripcion.value = false;
  alert("No se hicieron cambios");
};
const cambiar = () => {
  mostrar.value = true;
  nombre.value = false;
  ciudad.value = false;
  foto.value = false;
  descripcion.value = false;
  alert("Cambio correctamente");
};



</script>