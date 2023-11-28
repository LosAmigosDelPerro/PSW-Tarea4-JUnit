package PSW_JUnit;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
	static PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		GestionVuelos gestionVuelos = new GestionVuelos();
		gestionVuelos.crearVuelo("001", 100, "01-01-2021 10:00", "01-01-2021 12:00", "Bogotá", "Medellín");
		gestionVuelos.crearVuelo("002", 200, "01-01-2021 10:00", "01-01-2021 17:00", "Madrid", "Santiago");
		gestionVuelos.crearVuelo("003", 120, "03-01-2021 10:00", "03-01-2021 14:00", "Santiago", "Sao Paulo");

		do {
			printMenu();
			option = scanner.nextInt();
			switch (option) {
				case 1:
					String codigo;
					Integer numAsientos;
					String fechaYHoraSalida;
					String fechaYHoraLlegada;
					String origen;
					String destino;
					out.println("Ingrese el código del vuelo: ");
					codigo = scanner.next();
					out.println("Ingrese el número de asientos: ");
					numAsientos = scanner.nextInt();
					out.println("Ingrese la fecha y hora de salida (dd-MM-yyyy HH:mm): ");
					scanner.nextLine();
					fechaYHoraSalida = scanner.nextLine();
					out.println("Ingrese la fecha y hora de llegada (dd-MM-yyyy HH:mm): ");
					fechaYHoraLlegada = scanner.nextLine();
					out.println("Ingrese el origen: ");
					origen = scanner.next();
					out.println("Ingrese el destino: ");
					destino = scanner.next();
					
					gestionVuelos.crearVuelo(codigo, numAsientos, fechaYHoraSalida, fechaYHoraLlegada, origen, destino);
					break;
				case 2:	
					// Buscar vuelo por origen y destino
					scanner.nextLine();
					out.println("Ingrese el origen: ");
					origen = scanner.nextLine();
					out.println("Ingrese el destino: ");
					destino = scanner.nextLine();
					for (Vuelo vuelo : gestionVuelos.buscarVuelosPorOrigenYDestino(origen, destino)) {
						out.println(vuelo.toString());
					}
					break;
				case 3:
					printPrintAllVuelos(gestionVuelos);
					break;
				case 4:
					// Hacer reserva
					out.println("Ingrese el código del vuelo: ");
					codigo = scanner.next();
					out.println("Ingrese el número de asientos: ");
					numAsientos = scanner.nextInt();
					scanner.nextLine();
					out.println("Ingrese el nombre del pasajero: ");
					String nombre = scanner.nextLine();
					boolean resultado = gestionVuelos.crearReservas(codigo, numAsientos, nombre);
					if (resultado) {
						out.println("Reserva creada exitosamente");
					} else {
						out.println("No se pudo crear la reserva");
					}
					break;
				case 5:
					// Eliminar vuelo
					out.println("Ingrese el código del vuelo: ");
					codigo = scanner.next();
					gestionVuelos.eliminarVuelo(codigo);
					out.println("Vuelo eliminado exitosamente");
					break;
				case 6:
					// Salir
					break;
				default:
					out.println("Opción inválida");
					break;
			}

		} while (option != 6);
		
		out.println("Gracias por utilizar el sistema de vuelos Dogcraft :D");
		scanner.close();

	}

	static void printMenu() {
		out.println("1. Crear vuelo");
		out.println("2. Buscar vuelo por origen/destino");
		out.println("3. Obtener todos los vuelos");
		out.println("4. Hacer reserva");
		out.println("5. Eliminar vuelo");
		out.println("6. Salir");
		out.println("Ingrese una opción: ");
	}

	static void printPrintAllVuelos(GestionVuelos gestionVuelos) {
		for (Vuelo vuelo : gestionVuelos.obtenerTodosLosVuelos()) {
			out.println(vuelo.toString());
		}
	}

}
