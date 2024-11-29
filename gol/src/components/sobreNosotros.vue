<template>

    
  </template>
  
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap');
  
    .card {
      height: 100vh;
      width: 100vh;
      perspective: 1000px;
    }
  
    .card-inner {
      width: 100%;
      height: 100%;
      position: relative;
      transform-style: preserve-3d;
      transition: transform 1.5s;
    }
  
    .card:hover .card-inner {
      transform: rotateY(180deg);
    }
  
    .card-front,
    .card-back {
      position: absolute;
      width: 100%;
      height: 100%;
      backface-visibility: hidden;
    }
  
    .card-front {
      color: #fff;
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 24px;
      transform: rotateY(0deg);
    }
  
    .card-back {
      color: #fff;
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 24px;
      transform: rotateY(180deg);
    }

  
    .texto {
      color: rgb(255, 255, 255);
      font-size: 20px;
      font-family: 'Poppins', sans-serif;
    }
  
    .titulos {
      color: #ffffff;
      text-shadow: 0 0 3px rgb(255, 255, 255);
      font-family: 'Poppins', sans-serif;
    }
  
    .con {
      font-size: 30px;
      background: linear-gradient(rgba(0, 0, 0, 0.2), rgb(0, 0, 0));
      text-align: center;
      position: relative;
      top: 2%;
      height: 80%;
      width: 100%;
      border-radius: 5%;
      border-width: 10;
      border-style: solid;
      border-color: rgb(0, 0, 0);
    }
  
    .seccion1, .seccion2, .seccion3 {
      margin-top: 20px;
    }
  
    #fin {
      margin-top: 20px;
    }
  
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
    }
    body{
        overflow-y: hidden;
    }
  </style>
  
  <script>
    // Tu código JavaScript (si es necesario)
  </script>
  