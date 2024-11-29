<template>
  <div class="inicio_sesion_contenedor">
    <div v-if="isLogin">
      <div class="inicio_sesion_container_titulo">
      <h1 class="inicio_sesion_titulo">Iniciar sesión</h1>
    </div>
      <form class="inicio_sesion_form" @submit.prevent="iniciarSesion">
        <br>

        <div class="frminput">
          <label for="correo">Correo electrónico:</label>
          <br>
          <input class="inicio_sesion_cont" placeholder="correo electronico" type="email" id="correo" v-model="correo" required />
          <br>
        </div>
        <div class="frminput">
          <label for="password">Contraseña: </label>
          <br>
          <input class="inicio_sesion_cont" placeholder="contraseña" type="password" id="password" v-model="password" required />
          <br>
        </div>
        <button class="inicio_sesion_boton" type="submit">Iniciar sesión</button>
        <p class="inicio_sesion_letra">¿No tienes cuenta? <a @click="toggleForm">Regístrate</a></p>

        <div v-if="menError" class="error-message">{{ menError }}</div>
      </form>

    </div>   
    <div  v-else>
      <div class="registro_contenedor">
      <h1 class="registro_titulo">Crear una cuenta</h1>
      </div>
      <form class="registro_form" @submit.prevent="registrarUsuario">
        <div class="frminput">
          <label for="nombre">Nombre</label>
          <input class="registro_cont" type="text" id="nombre" v-model="nombre" required />
        </div>
        <div class="frminput">
          <label for="telefono">Ciudad</label>
          <input class="registro_cont" type="text" id="ciudad" v-model="ciudad" required />
        </div>
        <div class="frminput">
          <label for="telefono">Descripcion</label>
          <input class="registro_cont" type="text" id="Descripcion" v-model="descripcion" required placeholder="Descripcion minimo 50 caracteres" />
        </div>

        <div class="frminput">
          <label for="correo">Correo electrónico</label>
          <input class="registro_cont" type="email" id="correo" v-model="correo" required />
        </div>

        <div class="frminput">
    <label for="documento">Documento</label>
    <input 
        class="registro_cont" 
        type="text" 
        id="documento" 
        v-model="documento" 
        required 
        pattern="[0-9]*" 
        inputmode="numeric"
        title="Solo se permiten números."
    />
</div>


<div class="frminput">
    <label for="telefono">Teléfono</label>
    <input 
        class="registro_cont" 
        type="text" 
        id="telefono" 
        v-model="telefono" 
        required 
        pattern="[0-9]*" 
        inputmode="numeric" 
        title="Solo se permiten números."
    />
</div>

  
        <div class="frminput">
          <label for="fecha_nacimiento">Fecha de nacimiento</label>
          <br>
          <input type="date" id="fecha_nacimiento" v-model="fechaNacimiento" required />
        </div>


        <div class="frminput">
    <label for="password">Contraseña</label>
    <input 
        class="registro_cont" 
        type="password" 
        id="password" 
        v-model="password" 
        required 
        pattern="^(?=.*[A-Z])(?=.*).{8,}$" 
         title="La contraseña debe tener al menos 8 caracteres, al menos una letra mayúscula."
    />
</div>






        <button class="inicio_sesion_boton" type="submit">Registrar</button>
        <p>¿Ya tienes cuenta? <a @click="toggleForm" >Inicia sesión</a></p>

        <div v-if="menError" class="error-message">{{ menError }}</div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import Swal from 'sweetalert2';
import { useRouter } from 'vue-router';

const router = useRouter();
const isLogin = ref(true); 
const nombre = ref('');
const correo = ref('');
const documento = ref('');
const telefono = ref('');  
const fechaNacimiento = ref('');  
const password = ref('');
const menError = ref('');
const ciudad = ref('');
const descripcion = ref(''); 

const toggleForm = () => {
  isLogin.value = !isLogin.value;
};

const iniciarSesion = async () => {
  try {
    const response = await axios.post('http://127.0.0.1:8080/api/registro/iniciar', {
      correo: correo.value,
      contraseña: password.value,
    });

    if (response.data) {
      const userData = {
        correo: response.data.correo,
        id: response.data.id,
        nombreUsuario: response.data.nombreUsuario,
        ciudad: response.data.ciudad,
        descripcion: response.data.descripcion,
        fechaNacimiento: response.data.fechaNacimiento,
      };
      localStorage.setItem('usuario', JSON.stringify(userData));

      router.push('/aplicacion').then(() => {
        Swal.fire({
          icon: 'success',
          title: '¡Inicio de sesión exitoso!',
          text: 'Bienvenido de nuevo',
          confirmButtonText: 'Aceptar',
        });
      });
    }
  } catch (error) {
    menError.value = 'Correo o contraseña incorrectos';
    console.error('Error al iniciar sesión:', error);
  }
};

const registrarUsuario = async () => {
  const { value: passwordConfirmation } = await Swal.fire({
    title: 'Confirmar contraseña',
    input: 'password',
    inputLabel: 'Por favor, confirma tu contraseña',
    inputPlaceholder: 'Introduce tu contraseña',
    showCancelButton: true,
    confirmButtonText: 'Confirmar',
    cancelButtonText: 'Cancelar',
  });

  if (passwordConfirmation) {
    if (passwordConfirmation === password.value) {
      // Crear el objeto con los datos del formulario
      const userData = {
        nombre: nombre.value,
        correo: correo.value,
        documento: documento.value,
        telefono: telefono.value,
        fecha_nacimiento: fechaNacimiento.value,
        contraseña: password.value,
        ciudad: ciudad.value,
        descripcion: descripcion.value,
      };

      try {
        const response = await axios.post('http://127.0.0.1:8080/api/registro/registrar', userData, {
          headers: {
            'Content-Type': 'application/json', 
          },
        });

        const newUser = {
          id: response.data.documento,
          nombreUsuario: response.data.nombre,
          correo: response.data.correo,
          ciudad: response.data.ciudad,
          descripcion: response.data.descripcion,
          fecha_nacimiento: response.data.fechaNacimiento,
        };

        localStorage.setItem('usuario', JSON.stringify(newUser));

        Swal.fire({
          icon: 'success',
          title: 'Cuenta creada exitosamente',
          text: 'Ahora puedes iniciar sesión',
        });

        isLogin.value = true; 
      } catch (error) {
        const errorMessage = error.response?.data?.detail || 'Error al registrar';

        if (errorMessage.includes('El correo ya está registrado')) {
          Swal.fire({
            icon: 'error',
            title: 'Correo ya registrado',
            text: 'Ya existe una cuenta registrada con este correo. ¿Quieres iniciar sesión?',
            confirmButtonText: 'Iniciar sesión',
            showCancelButton: true,
            cancelButtonText: 'Cancelar',
          }).then((result) => {
            if (result.isConfirmed) {
              toggleForm();
            }
          });
        } else if (errorMessage.includes('El documento ya está registrado')) {
          Swal.fire({
            icon: 'error',
            title: 'Documento ya registrado',
            text: 'Ya existe una cuenta registrada con este documento.',
            confirmButtonText: 'Aceptar',
          });
        } else {
          menError.value = errorMessage;
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: errorMessage,
          });
        }
      }
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'Las contraseñas no coinciden.',
      });
    }
  }
};
</script>

<style scoped>
.inicio_sesion_form{
background-color: rgb(0, 0, 0);
border: 5px solid rgb(255, 255, 255);
padding: 20px;
border-radius: 8px;
box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
display: flex;
flex-direction: column;
gap: 20px; 
width: 100%; 
max-width: 400px;
margin-left: 10%;
transition: initial;
}
.inicio_sesion_form:hover{
  border-color: #FFD700;
}

.inicio_sesion_container_titulo{
  position: absolute;
  background-color: rgb(0, 0, 0);
  width: 60%;
  top: -5%;
  left:30%;
  box-shadow: 0 0 6px rgb(255, 255, 255);
  border: solid;
  border: 50px;
  border-color: antiquewhite;
}
.registro_titulo{
  margin-left: 10%;
  margin-right: 10%;
  position: relative;
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-size: 25px;
  background-image: url('https://static.vecteezy.com/system/resources/thumbnails/000/549/015/small/vector-apr-2018-19.jpg');
  background-size: cover;
  color: transparent;
  background-clip: text;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.158);
  width: 200px;

}
.registro_contenedor{
  position: absolute;
  background-color: rgb(0, 0, 0);
  width: 60%;
  top: -5%;
  left:35%;
  box-shadow: 0 0 6px rgb(255, 255, 255);
  border: solid;
  border: 50px;
  border-color: antiquewhite;

}
.logos3{
    margin-left: 100px;
    position: relative;
    top: 20px;
    left: 500px;
    width: 70px;
    height: 50px;
    cursor: pointer;
}
.registro_form{
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
  font-size: 50%;
  margin-left: 15%;

}

#animal{
    position: relative;
    height: 150px;
    width: 1500px;
    top: 495px;
    left: -143px;
    position: absolute;
    top: 800px;
    width: 1640px;
    height: 100px;
    background-color: rgba(255, 255, 255, 0.199);
    
    
}
.inicio_sesion_titulo{
  margin-left: 10%;
  margin-right: 10%;
  position: relative;
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-size: 25px;
  background-image: url('https://static.vecteezy.com/system/resources/thumbnails/000/549/015/small/vector-apr-2018-19.jpg');
  background-size: cover;
  color: transparent;
  background-clip: text;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.158);
}
.inicio_sesion_contenedor{
  font-size: 25px;
  text-align: center;
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  position: relative;
  left: 36%;

}
.inicio_sesion_cont{
  background-color: black;
  font-size: 20px;
  text-align: center;
  width: 90%;
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  color: aliceblue;
}
.registro_cont{
  background-color: black;
  font-size: 20px;
  text-align: center;
  width: 90%;
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  color: aliceblue;
}
.inicio_sesion_boton{
  background-image: url('https://static.vecteezy.com/system/resources/thumbnails/000/549/015/small/vector-apr-2018-19.jpg');
        background-size: cover;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 20px;
        text-align: center;
        font-size: 90%;
        margin-top: 30px;
        width: 70%;
        position: relative;
        font-family:'Times New Roman', Times, serif;
        right: -15%;
}
.inicio_sesion_letra{
  font-size: 70%;
}
</style>