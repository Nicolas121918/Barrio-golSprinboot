// useLista.js
import { ref, onMounted } from 'vue';
import axios from 'axios';

export const useLista = () => {
  const lista = ref([]);

  const obtenerEquipos = async () => {
    try {
      const response = await axios.get('http://localhost:8000/equipo/lista');
      lista.value = response.data;
    } catch (error) {
      console.error('Error al obtener la lista de equipos:', error);
    }
  };

  onMounted(() => {
    obtenerEquipos(); // Obtener equipos al montar el componente
  });

  return {
    lista,
  };
};