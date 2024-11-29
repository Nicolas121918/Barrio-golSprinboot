<template>
    <header class="header-home">
      <section class="botones-prin">
        <router-link id="boton"to="/home_video">Home</router-link>
        <router-link id="boton" class="sobreNosotros" to="/redes">Sobre Nosotros</router-link>
        <router-link id="boton" class="consultar" to="/inicioSesion">Iniciar Sesión</router-link>
      </section>
    </header>
  </template>
  
  <style scoped>
  .botones-prin {
    display: flex;
    justify-content: center;
    gap:20px;
    margin-top: -100px;
    position: relative;
    float: left;
  
  }


#boton {
  padding: 10px 20px;
  font-weight: bold;
  border-radius: 8px;
  transition: background-color 0.3s ease;
  border: 2px solid black; 
  color: white;
  text-align: center;
  text-decoration: none;
  cursor: pointer;
  background-image: linear-gradient(
    rgba(0, 0, 0, 0.2),
    rgba(0, 0, 0, 0.3)
  ), 
  url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRliDRc-R2CvZHWA7uopNByFtaWoUIhmqk3Q&s);
  background-size: cover;
  background-position: center;
}

#boton:hover {
  background-image: linear-gradient(
    rgba(0, 0, 0, 0.7), 
    rgba(0, 0, 0, 0.7)
  ), 
  url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRliDRc-R2CvZHWA7uopNByFtaWoUIhmqk3Q&s);
}

  #boton:hover {
    background-color: #000; 
    color: #fff;
  }
  
  #boton:active {
    background-color: #FFD700;
  }
  
  .sobreNosotros {
    background-color: #444;
  }
  
  .Contacto {
    background-color: #444;
  }
  
  .consultar {
    background-color: #444;
  }
  </style>
  