package principal;

import modelos.Conversor;
import modelos.GestorDeMoneda;
import modelos.Moneda;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Index {
    public static void main(String[] args) {
        GestorDeMoneda gestorMoneda = new GestorDeMoneda();  // Para obtener las monedas
        Scanner scanner = new Scanner(System.in);
        // Maneja las conversiones
        Conversor conversor = new Conversor();

        while (true) {
            mostrarMenu();

            try {
                System.out.print("Ingrese una opción (1-5): ");
                int opcionMenu = scanner.nextInt();

                switch (opcionMenu) {
                    case 1:
                        // Seleccionar moneda de origen
                        Moneda monedaOrigen = seleccionarMoneda(scanner, gestorMoneda);
                        if (monedaOrigen != null) {
                            conversor.setMonedaOrigen(monedaOrigen);
                            System.out.println("Moneda de origen seleccionada: " + monedaOrigen.getNombre());
                        }
                        break;
                    case 2:
                        // Seleccionar moneda de destino
                        Moneda monedaDestino = seleccionarMoneda(scanner, gestorMoneda);
                        if (monedaDestino != null) {
                            conversor.setMonedaDestino(monedaDestino);
                            System.out.println("Moneda de destino seleccionada: " + monedaDestino.getNombre());
                        }
                        break;
                    case 3:
                        // Ingresar monto
                        ingresarMonto(scanner, conversor);
                        break;
                    case 4:
                        // Mostrar detalles de la conversión
                        conversor.mostrarConversion();
                        break;
                    case 5:
                        // Salir
                        System.out.println("Saliendo del programa...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción inválida. Por favor, elija nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese solo los números correspondientes.");
                scanner.next();  // Limpiar el input
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("=== Menú de Conversor de Monedas ===");
        System.out.println("1. Seleccionar moneda de origen");
        System.out.println("2. Seleccionar moneda de destino");
        System.out.println("3. Ingresar monto");
        System.out.println("4. Mostrar conversión");
        System.out.println("5. Salir");
    }

    // Método para seleccionar moneda basado en el continente
    private static Moneda seleccionarMoneda(Scanner scanner, GestorDeMoneda gestorMonedas) {
        System.out.println("Seleccione un continente para ver las monedas disponibles:");
        System.out.println("1. África");
        System.out.println("2. Asia");
        System.out.println("3. Europa");
        System.out.println("4. América");
        System.out.println("5. Oceanía");

        int opcionContinente = scanner.nextInt();
        String continenteSeleccionado;

        switch (opcionContinente) {
            case 1: continenteSeleccionado = "África"; break;
            case 2: continenteSeleccionado = "Asia"; break;
            case 3: continenteSeleccionado = "Europa"; break;
            case 4: continenteSeleccionado = "América"; break;
            case 5: continenteSeleccionado = "Oceanía"; break;
            default:
                System.out.println("Opción inválida");
                return null;
        }

        List<Moneda> monedasDisponibles = gestorMonedas.obtenerMonedasPorContinente(continenteSeleccionado);
        if (monedasDisponibles.isEmpty()) {
            System.out.println("No hay monedas disponibles en este continente.");
            return null;
        }

        System.out.println("Monedas disponibles en " + continenteSeleccionado + ":");
        for (int i = 0; i < monedasDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + monedasDisponibles.get(i).getNombre());
        }

        System.out.print("Seleccione el número de la moneda: ");
        int indiceMoneda = scanner.nextInt() - 1;

        if (indiceMoneda < 0 || indiceMoneda >= monedasDisponibles.size()) {
            System.out.println("Selección inválida.");
            return null;
        }

        return monedasDisponibles.get(indiceMoneda);
    }

    // Método para ingresar monto con validación
    private static void ingresarMonto(Scanner scanner, Conversor conversor) {
        System.out.print("Ingrese el monto a convertir: ");
        try {
            double monto = scanner.nextDouble();
            conversor.setMonto(monto);
            System.out.println("Monto ingresado: " + monto);
        } catch (InputMismatchException e) {
            System.out.println("Formato de monto inválido. Debe ser un número decimal.");
            scanner.next();
        }
    }

}

