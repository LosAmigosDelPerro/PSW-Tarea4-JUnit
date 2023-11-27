package PSW_JUnit;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
	static PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		do {
			printMenu();
			option = scanner.nextInt();
			switch (option) {
				case 1:
					// Crear vuelo
					break;
				case 2:	
					// Buscar vuelo por código
					break;
				case 3:
					// Obtener todos los vuelos
					break;
				case 4:
					// Actualizar reservas
					break;
				case 5:
					// Eliminar vuelo
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
		out.println("2. Buscar vuelo por código");
		out.println("3. Obtener todos los vuelos");
		out.println("4. Actualizar reservas");
		out.println("5. Eliminar vuelo");
		out.println("6. Salir");
		out.println("Ingrese una opción: ");
	}

}
