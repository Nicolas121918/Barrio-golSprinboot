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
      </router-link>botones_prin
      <router-link class="link-video" to="/videos" >
        <img class="api4" src="../assets/iconos header/reproduccion-de-video.png" alt="Video">
      </router-link>
      <router-link class="link api8" to="/home2">
        <img class="api8" src="../assets/imagenes/logo.png" alt="Logo">
      </router-link>
    </header>
    <div class="creacion_evento">
      <!-- Selección de tipo de evento -->
      <router-link class="volver_actualizar" to="/torneos">
        volver
      </router-link>
      <h2 class="creacion_evento_titulo">¿Qué deseas crear?</h2>
      
      <!-- Caja central con opciones -->
      <div class="creacion_evento_opciones">
        <select v-model="tipoEvento" class="creacion_evento_select">
          <option value="" disabled>Seleccione una opción</option>
          <option value="torneo">Torneo</option>
          <option value="partido">Partido</option>
        </select>
      </div>
      <article class="fondo_black">

      </article>
  
      <!-- Formulario para crear torneo -->
      <transition name="fade">
        <div v-if="tipoEvento === 'torneo'" class="creacion_torneo_formulario">
          <!-- Logo para el torneo -->
          <div class="creacion_torneo_logo">
            <img src="https://example.com/torneo-logo.png" alt="Logo Torneo" />
          </div>
  
          <h3 class="creacion_torneo_titulo">Crear Torneo</h3>
  
          <label for="nombreTorneo" class="creacion_torneo_label">Nombre del Torneo:</label>
          <input type="text" v-model="torneo.nombre" class="creacion_torneo_input" placeholder="Nombre del torneo" />
  
          <label for="participantes" class="creacion_torneo_label">Participantes:</label>
          <input type="number" v-model="torneo.participantes" class="creacion_torneo_input" min="1" />
  
          <label for="precioInscripcion" class="creacion_torneo_label">Precio de Inscripción:</label>
          <input type="number" v-model="torneo.precioInscripcion" class="creacion_torneo_input" min="0" />
  
          <label for="precioArbitraje" class="creacion_torneo_label">Precio por Arbitraje:</label>
          <input type="number" v-model="torneo.precioArbitraje" class="creacion_torneo_input" min="0" />
  
          <label for="premio" class="creacion_torneo_label">Premio (opcional):</label>
          <input type="number" v-model="torneo.premio" class="creacion_torneo_input" min="0" />
  
          <label for="lugar" class="creacion_torneo_label">Lugar:</label>
          <input type="text" v-model="torneo.lugar" class="creacion_torneo_input" placeholder="Lugar del torneo" />
  
          <!-- Pago requerido de 30 mil pesos -->
          <transition name="fade">
            <div v-if="!premioPagado" class="creacion_torneo_pago">
              <p class="creacion_torneo_aviso">Debe pagar $30,000 COP para poder crear el torneo</p>
              <button @click="pagarPremio('torneo')" class="creacion_torneo_boton_pagar">Pagar $30,000</button>
            </div>
          </transition>
  
          <!-- Campo de reglas con opciones predeterminadas y personalizadas -->
          <h4 class="creacion_torneo_subtitulo">Reglas</h4>
          <div v-for="(regla, index) in reglas" :key="index" class="creacion_torneo_regla">
            <input type="checkbox" v-model="torneo.reglas" :value="regla" class="creacion_torneo_checkbox" />
            <label class="creacion_torneo_label">{{ regla }}</label>
          </div>
  
          <label for="reglasPersonalizadas" class="creacion_torneo_label">Reglas Personalizadas:</label>
          <textarea v-model="torneo.reglasPersonalizadas" class="creacion_torneo_input" rows="3" placeholder="Escribe tus propias reglas"></textarea>
  
          <button @click="crearTorneo" :disabled="!premioPagado" class="creacion_torneo_boton">Crear Torneo</button>
          <transition name="fade">
            <p v-if="torneoCreado" class="creacion_torneo_confirmacion">¡Torneo creado con éxito!</p>
          </transition>
        </div>
      </transition>
  
      <!-- Formulario para crear partido -->
      <transition name="fade">
        <div v-if="tipoEvento === 'partido'" class="creacion_partido_formulario">
          <h3 class="creacion_partido_titulo">Crear Partido</h3>
  
          <label for="hora" class="creacion_partido_label">Hora:</label>
          <input type="time" v-model="partido.hora" class="creacion_partido_input" />
  
          <label for="lugar" class="creacion_partido_label">Lugar:</label>
          <input type="text" v-model="partido.lugar" class="creacion_partido_input" placeholder="Lugar del partido" />
  
          <label for="participantes" class="creacion_partido_label">Número de Participantes:</label>
          <input type="number" v-model="partido.participantes" class="creacion_partido_input" min="1" />
  
          <label for="apuesta" class="creacion_partido_label">Apuesta (COP):</label>
          <input type="number" v-model="partido.apuesta" class="creacion_partido_input" min="0" />
  
          <label for="numeroPartidos" class="creacion_partido_label">Número de Partidos:</label>
          <input type="number" v-model="partido.numeroPartidos" class="creacion_partido_input" min="1" />
  
          <!-- Validación de apuesta y pago -->
          <transition name="fade">
            <div v-if="!apuestaPagada" class="creacion_partido_pago">
              <p class="creacion_partido_aviso">Debe pagar $10,000 COP más el valor de la apuesta: ${{ partido.apuesta }} COP</p>
              <button @click="pagarPremio('partido')" class="creacion_partido_boton_pagar">Pagar ${{ 10000 + partido.apuesta }}</button>
            </div>
          </transition>
  
          <button @click="crearPartido" :disabled="!apuestaPagada" class="creacion_partido_boton">Crear Partido</button>
          <transition name="fade">
            <p v-if="partidoCreado" class="creacion_partido_confirmacion">¡Partido creado con éxito!</p>
          </transition>
        </div>
      </transition>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        tipoEvento: "", // Valor para seleccionar entre 'torneo' o 'partido'
        torneo: {
          nombre: "",
          participantes: 0,
          precioInscripcion: 0,
          precioArbitraje: 0,
          premio: 0,
          lugar: "",
          reglas: [], // Reglas seleccionadas
          reglasPersonalizadas: "" // Reglas adicionales
        },
        partido: {
          hora: "",
          lugar: "",
          participantes: 0,
          apuesta: 0,
          numeroPartidos: 1
        },
        reglas: [
          "El participante debe ser mayor de edad",
          "Se requiere asistir con tarjeta",
          "Prohibido el uso de sustancias prohibidas",
          "Se requiere uniforme adecuado",
        ],
        premioPagado: false, // Control para validar si el pago del torneo ha sido realizado
        apuestaPagada: false, // Control para validar si el pago del partido ha sido realizado
        torneoCreado: false, // Para mostrar el mensaje de confirmación al crear el torneo
        partidoCreado: false, // Para mostrar el mensaje de confirmación al crear el partido
      };
    },
    methods: {
      pagarPremio(tipo) {
        if (tipo === 'torneo') {
          // Simulación de pago de $30,000 COP para el torneo
          alert("Pago de $30,000 COP completado para el torneo.");
          this.premioPagado = true;
        } else if (tipo === 'partido') {
          // Simulación de pago de $10,000 COP más la apuesta para el partido
          alert(`Pago de $${10000 + this.partido.apuesta} COP completado para el partido.`);
          this.apuestaPagada = true;
        }
      },
      crearTorneo() {
        if (this.premioPagado) {
          console.log("Torneo creado:", this.torneo);
          this.torneoCreado = true;
          alert(`Torneo "${this.torneo.nombre}" creado con éxito!`);
        } else {
          alert("Por favor, paga los $30,000 COP antes de crear el torneo.");
        }
      },
      crearPartido() {
        if (this.apuestaPagada) {
          console.log("Partido creado:", this.partido);
          this.partidoCreado = true;
          alert(`Partido creado con éxito!`);
        } else {
          alert("Por favor, realiza el pago de la apuesta antes de crear el partido.");
        }
      }
    }
  };
  </script>
  
  <style scoped>
  /* Estilo general */
  .creacion_evento {
    text-align: center;
    margin-top: 50px;
    font-family: 'Arial', sans-serif;
    position: relative;
    top: 28%;
    left: 40%;
    color: black;
    border: 2px;
    border: solid;
    border-color: #f9f9f9;
    background-color: rgb(117, 117, 117);
    
  }
  
  .creacion_evento_titulo {
    font-size: 28px;
    color: black;
    margin-bottom: 30px;
  }
  
  /* Opciones de selección */
  .creacion_evento_select {
    font-size: 18px;
    padding: 10px;
    border-radius: 8px;
    border: 2px solid #4CAF50;
    width: 60%;
    max-width: 300px;
    margin-bottom: 40px;
  }
  
  .creacion_evento_opciones {
    margin-bottom: 30px;
  }
  .fondo_black{
    position: absolute;
    background-color: rgba(0, 0, 0, 0.678);
    width: 600%;
    height: 300%;
    z-index: -4;
    left:-240%;
    top: -100%;
  }
  
  /* Estilo para formularios de torneos y partidos */
  .creacion_torneo_formulario, .creacion_partido_formulario {
    margin: 0 auto;
    padding: 20px;
    width: 80%;
    max-width: 600px;
    background-color: #f9f9f9;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  }
  
  /* Imagen del torneo */
  .creacion_torneo_logo img {
    display: block;
    margin: 0 auto;
    max-width: 200px;
    height: auto;
  }
  
  /* Estilos para los inputs */
  .creacion_torneo_input, .creacion_partido_input, .creacion_torneo_textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border-radius: 5px;
    border: 1px solid #ccc;
    font-size: 16px;
  }
  
  .creacion_torneo_input:focus, .creacion_partido_input:focus {
    border-color: #4CAF50;
  }
  
  /* Botones */
  .creacion_torneo_boton, .creacion_partido_boton {
    background-color: #4CAF50;
    color: white;
    font-size: 18px;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  
  .creacion_torneo_boton:hover, .creacion_partido_boton:hover {
    background-color: #45a049;
  }
  
  /* Avisos y mensajes */
  .creacion_torneo_aviso, .creacion_partido_aviso {
    color: red;
    margin-bottom: 15px;
    font-size: 14px;
  }
  
  .creacion_torneo_confirmacion, .creacion_partido_confirmacion {
    color: green;
    margin-top: 15px;
    font-size: 16px;
  }
  
  /* Reglas */
  .creacion_torneo_subtitulo {
    font-size: 20px;
    margin-bottom: 10px;
  }
  
  .creacion_torneo_regla {
    margin-bottom: 10px;
  }
  
  .creacion_torneo_checkbox {
    margin-right: 10px;
  }
  
  /* Animaciones */
  .fade-enter-active, .fade-leave-active {
    transition: opacity 0.5s;
  }
  
  .fade-enter, .fade-leave-to {
    opacity: 0;
  }
  </style>
  