
import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './mis_rutas/rutas'

createApp(App)
.use(router)
.mount('#app')