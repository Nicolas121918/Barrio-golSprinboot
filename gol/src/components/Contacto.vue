<template>
  <section class="contacto_contact1">
      <h1 id="contacto_contact">Contáctanos</h1>

      <div class="contacto_gente">
          <form @submit.prevent="enviarFormulario">
              <br>
              <label class="contacto_camp">
                  <input class="contacto_input" v-model="insertar.nombre" type="text" placeholder="Digite su nombre" required>
              </label>
              <br><br>
              <label class="contacto_camp_cont">¿Cuál es el motivo de tu contacto?
                  <select class="contacto_select" v-model="insertar.queja_reclamo_quest" name="opciones" required>
                      <option value="Queja">Queja</option>
                      <option value="Reclamo">Reclamo</option>
                      <option value="Inquietud">Inquietud</option>
                  </select>
              </label>
              <br><br>
              <label class="contacto_camp">
                  <input class="contacto_input" v-model="insertar.email" type="email" placeholder="Digite su Correo electrónico" required>
              </label>
              <br>
              <label class="contacto_camp">
                  <input class="contacto_input" v-model="insertar.celular" type="text" placeholder="Digite su celular" required>
              </label>
              <br>
              <label class="contacto_camp">
                  <textarea id="contacto_comentario" class="contacto_textarea" v-model="insertar.comentario" rows="10" placeholder="Escribe tu mensaje" required></textarea>
              </label>
              <br><br>
              <button class="contacto_boton" type="submit">Enviar</button>
          </form>
      </div>
  </section>

</template>

<style>
  #contacto_contact {
      position: absolute;
      font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
      top: -15%;
      left: 69%;
      font-size: 50px;
      background-image: url('https://static.vecteezy.com/system/resources/thumbnails/000/549/015/small/vector-apr-2018-19.jpg');
      background-size: cover;
      color: transparent;
      background-clip: text;
      text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.158);
  }
  
  .contacto_contact1 {
      position: relative;
      top: 6%;
      text-align: center;
  }   

  * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
  }

  .contacto_textarea {
      margin-top: 15px;
      width: 300px;
      height: 60px;
      text-align: center;
      background-color: black;
      color: antiquewhite;
  }

  .contacto_input {
      margin: 10px 0;
      width: 300px;
      padding: 5px;
      background-color: black;
      text-align: center;
      color: aliceblue;
  }

  .contacto_select {
      margin-top: 15px;
      width: 300px;
      height: 30px;
      border-radius: 10px;
      background-color: black;
      color: antiquewhite;
      text-align: center;
      font-size: 90%;
  }

  .contacto_gente {
      background-color: rgb(0, 0, 0);
      border: 5px solid rgb(255, 255, 255);
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
      display: flex;
      flex-direction: column;
      gap: 10px; /* Espacio entre los campos del formulario */
      width: 100%; /* Ocupará todo el ancho disponible */
      max-width: 400px; /* Limita el ancho máximo del formulario */
      margin-left: 50%;
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

  .contacto_boton {
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

  input:hover, .contacto_boton:hover {
      transform: scale(1.01);
  }
</style>

<script>
import axios from 'axios';
import { ref } from 'vue';
import Swal from 'sweetalert2';

export default {
  setup() {
      const insertar = ref({
          nombre: '',
          queja_reclamo_quest: '',
          email: '',
          celular: '',
          comentario: '',
      });

      const enviarFormulario = async () => {
    const result = await Swal.fire({
        title: '¿Estás seguro?',
        text: '¿Quieres enviar el formulario?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Sí, enviar',
        cancelButtonText: 'No, cancelar',
    });

    if (result.isConfirmed) {
        try {
            const response1 = await axios.post('http://localhost/enviar.php', insertar.value);
            const response2 = await axios.post('http://localhost:8000/contacto/', insertar.value);
            const response3 = await axios.post('http://localhost:8000/contactos/', insertar.value);

            if (response1.data.message === 'Correo enviado correctamente.' || response2.status === 200 || response3.status===200) {
                Swal.fire({
                    icon: "success",
                    title: 'Enviado',
                    text: 'El formulario ha sido enviado correctamente.',
                });

                insertar.value = {
                    nombre: '',
                    queja_reclamo_quest: '',
                    email: '',
                    celular: '',
                    comentario: '',
                };
            } 
            else {
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: 'Hubo un problema al enviar el formulario. Inténtalo de nuevo.',
                });
            }
        } catch (error) {
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'Hubo un problema al enviar el formulario. Inténtalo de nuevo.',
            });
            console.error('Error al enviar el formulario:', error);
        }
    }
};

return {
    insertar,
    enviarFormulario,
};

  },
};
</script>
