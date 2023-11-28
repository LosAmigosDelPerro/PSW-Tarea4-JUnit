package PSW_JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VuelosTest {

	private GestionVuelos gestionVuelos;

	@BeforeEach
	void setUp() throws Exception {
		gestionVuelos = new GestionVuelos();
	}

	@Test
	void crearVuelo() throws Exception {
		gestionVuelos.crearVuelo("IB1234", 100, "26-11-2023 12:00", "26-11-2023 14:00", "Santiago", "Coquimbo");
		Vuelo vuelo = gestionVuelos.buscarVueloPorCodigo("IB1234");
		assertEquals("IB1234", vuelo.getCodigoVuelo());
	}

	@Test
	void buscarVueloPorCodigo() throws Exception {
		gestionVuelos.crearVuelo("IB1234", 100, "26-11-2023 12:00", "26-11-2023 14:00", "Santiago", "Coquimbo");
		Vuelo vuelo = gestionVuelos.buscarVueloPorCodigo("IB1234");
		assertEquals("IB1234", vuelo.getCodigoVuelo());
	}

	@Test
	void obtenerTodosLosVuelos() throws Exception {
		gestionVuelos.crearVuelo("IB1234", 100, "26-11-2023 12:00", "26-11-2023 14:00", "Santiago", "Coquimbo");
		gestionVuelos.crearVuelo("IB1235", 100, "26-11-2023 14:00", "26-11-2023 16:00", "Santiago", "Coquimbo");
		gestionVuelos.crearVuelo("IB1236", 100, "26-11-2023 16:00", "26-11-2023 18:00", "Santiago", "Coquimbo");
		List<Vuelo> vuelos = gestionVuelos.obtenerTodosLosVuelos();
		assertEquals(3, vuelos.size());
		assertEquals("IB1234", vuelos.get(0).getCodigoVuelo());
		assertEquals("IB1235", vuelos.get(1).getCodigoVuelo());
		assertEquals("IB1236", vuelos.get(2).getCodigoVuelo());
	}

	@Test
	void actualizarReservas() throws Exception {
		gestionVuelos.crearVuelo("IB1234", 100, "26-11-2023 12:00", "26-11-2023 14:00", "Santiago", "Coquimbo");
		Vuelo vuelo = gestionVuelos.buscarVueloPorCodigo("IB1234");
		assertEquals("IB1234", vuelo.getCodigoVuelo());
		boolean result = gestionVuelos.crearReservas("IB1234", 10, "Juan Perez");
		assertTrue(result);
		assertEquals(10, vuelo.getNumAsientosOcupados());
	}

	@Test
	void actualizarReservasError() throws Exception {
		gestionVuelos.crearVuelo("IB1234", 100, "26-11-2023 12:00", "26-11-2023 14:00", "Santiago", "Coquimbo");
		Vuelo vuelo = gestionVuelos.buscarVueloPorCodigo("IB1234");
		assertEquals("IB1234", vuelo.getCodigoVuelo());
		boolean result = gestionVuelos.crearReservas("IB1234", 110, "Juan Perez");
		assertFalse(result);
		assertEquals(0, vuelo.getNumAsientosOcupados());
	}

	@Test
	void eliminarVuelo() throws Exception {
		gestionVuelos.crearVuelo("IB1234", 100, "26-11-2023 12:00", "26-11-2023 14:00", "Santiago", "Coquimbo");
		Vuelo vuelo = gestionVuelos.buscarVueloPorCodigo("IB1234");
		assertEquals("IB1234", vuelo.getCodigoVuelo());
		gestionVuelos.eliminarVuelo("IB1234");
		vuelo = gestionVuelos.buscarVueloPorCodigo("IB1234");
		assertNull(vuelo);
	}

	@Test
	void vueloNoExiste() throws Exception {
		Vuelo vuelo = gestionVuelos.buscarVueloPorCodigo("IB1234");
		assertNull(vuelo);
	}


}
