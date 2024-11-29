<template>
  <header>
    <aplicacion></aplicacion>
</header>
    <div class="pie_container">
      <form @submit.prevent="insertar_cliente">
        <h1 id="pie_tit">Registrarse</h1>
        <label class="pie_espacios" for="">
          <input v-model="insertar.documento" type="text" placeholder="Digite su documento" required>
        </label>
        <label class="pie_espacios" for="">
          <input v-model="insertar.nombre" type="text" placeholder="Digite su nombre" required>
        </label>
        <label class="pie_espacios" for="">
          <input v-model="insertar.telefono" type="text" placeholder="Telefono" required>
        </label>
        <label class="pie_espacios" for="">
          <input v-model="insertar.correo" type="text" placeholder="Digite su correo Electronico" required>
        </label>
        <label class="pie_espacios" for="">
          <input v-model="insertar.contraseña" type="text" placeholder="Digite una contraseña" required>
        </label>
        <label class="pie_espacios" for="">
          <input v-model="insertar.fecha_nacimiento" type="date" placeholder="Digite su fecha de nacimiento" required>
        </label>
        <button class="pie_dorado" type="submit">registrar</button>
      </form>
      <router-view></router-view>
    </div>
  
    
  </template>
  
  <style>
  * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
  }
  
  </style>
  
  <script>
  import rutas2 from './rutas2.vue';
  import axios from 'axios';
  import { ref } from 'vue';
  
  export default {
    setup() {
      const insertar = ref({
        documento: null,
        nombre: "",
        telefono: "",
        correo: "",
        contraseña: "",
        fecha_nacimiento: ""
      });
  
      const message = ref('');
      const insertar_cliente = async () => {
        try {
          const link = await axios.post("http://127.0.0.1:8000/insertar", insertar.value);
          message.value = "se agrego correctamente";
        } catch (e) {
          if (e.response) {
            console.error("no se pudo registrar");
          }
        }
      };
  
      return { insertar, insertar_cliente, message };
    }
  }
  </script>
  