<template>
    <!-- From Uiverse.io by csemszepp -->
    <div class="container">
      <label>
        <input class="play-btn" type="checkbox" @change="togglePlay">
        <div class="play-icon"></div>
        <div class="pause-icon"></div>
        <div class="video-container" :class="{ active: isPlaying }">
          <video ref="videoElement" muted loop playsinline>
            <source src="../assets/videos/video.mp4" type="video/mp4" />
            Tu navegador no soporta la reproducción de videos.
          </video>
        </div>
      </label>
    </div>
  </template>
  
  <script>
  export default {
    name: "VideoBackground",
    data() {
      return {
        isPlaying: false,
      };
    },
    methods: {
      togglePlay(event) {
        const video = this.$refs.videoElement;
        this.isPlaying = event.target.checked;
        if (this.isPlaying) {
          video.play();
        } else {
          video.pause();
        }
      },
    },
  };
  </script>
  
  <style scoped>
  /* From Uiverse.io by csemszepp */
  .container {
    width: 120px;
    height: 120px;
    position: relative;
    border-radius: 50%;
    flex-wrap: wrap;
  }
  
  .play-btn {
    position: absolute;
    appearance: none;
    width: 100%;
    height: 100%;
    border-radius: 50%;
    background: conic-gradient(#ff6347, #ff6347);
    cursor: pointer;
    outline: none;
    z-index: 10;
  }
  
  .play-btn::before {
    content: "";
    position: absolute;
    width: 93%;
    height: 93%;
    background-color: #000;
    border-radius: 50%;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    z-index: 10;
  }
  
  .play-btn:checked {
    animation: borderAnimate 700ms ease-in-out 1;
    animation-fill-mode: forwards;
    z-index: 10;
  }
  
  @keyframes borderAnimate {
    0% {
      transform: rotate(0);
      background: conic-gradient(#ff6347, transparent 20%);
    }
    80% {
      background: conic-gradient(#ff6347, transparent 90%);
    }
    100% {
      transform: rotate(360deg);
      background: conic-gradient(#ff6347, #ff6347);
    }
  }
  
  .play-icon {
    position: absolute;
    width: 40px;
    height: 40px;
    left: 60%;
    top: 50%;
    background-color: #ff6347;
    transform: translate(-60%, -50%) rotate(90deg);
    clip-path: polygon(50% 15%, 0% 100%, 100% 100%);
    transition: all 400ms ease-in-out;
    cursor: pointer;
    z-index: 10;
  }
  
  .play-btn:checked + .play-icon {
    clip-path: polygon(0 100%, 0% 100%, 100% 100%);
  }
  
  .pause-icon {
    position: absolute;
    width: 40px;
    height: 40px;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    cursor: pointer;
    z-index: 10;
  }
  
  .pause-icon::before {
    content: "";
    position: absolute;
    width: 0%;
    height: 100%;
    background-color: #ff6347;
    left: 0;
    z-index: 10;
  }
  
  .pause-icon::after {
    content: "";
    position: absolute;
    width: 0;
    height: 100%;
    background-color: #ff6347;
    right: 0;
    z-index: 10;
  }
  
  .play-btn:checked ~ .pause-icon::before {
    animation: reveal 300ms ease-in-out 350ms 1;
    animation-fill-mode: forwards;
  }
  
  .play-btn:checked ~ .pause-icon::after {
    animation: reveal 300ms ease-in-out 600ms 1;
    animation-fill-mode: forwards;
  }
  
  @keyframes reveal {
    0% {
      width: 0;
    }
    100% {
      width: 35%;
    }
  }
  
  .video-container {  
    display: flex;
    justify-content: center;
    align-items: center;
    opacity: 0;
    visibility: hidden;
    margin-top: -300%;
    width: 100vh;
    transition: opacity 0.5s ease-in-out, visibility 0.5s ease-in-out;
  }
  
  .video-container.active {
    opacity: 1;
    visibility: visible;
  }
  </style>
  