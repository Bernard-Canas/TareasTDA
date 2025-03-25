/* 
Autor: Bernardo Canas
Carnet: 202401637
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AplicacionTDA_Cola {
    //Cola para almacenar los clientes en espera
    private static Queue<String> fila_Clientes = new LinkedList<>();
    //Scanner para leer la entrada del usuario
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nSISTEMA DE GESTIÓN DE FILA DE CLIENTES");
        
        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 4); //Blucle para finalizar el menu
        
        scanner.close();//Cerrar el scanner al finalizar
    }
    //Menu principal de opciones
    private static void mostrarMenu() {
        System.out.println("\n<=== MENÚ PRINCIPAL ===>");
        System.out.println("1. LLEGAR [nombre]");
        System.out.println("2. ATENDER");
        System.out.println("3. MOSTRAR");
        System.out.println("4. SALIR");
        System.out.print("Elije una opción: ");
    }
    //Obtiene y valida la opción ingresada por el usuario
    private static int obtenerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Opción Invalida");
            scanner.next();
            System.out.print("Elije una opción: ");
        }
        return scanner.nextInt();
    }
    //Procesa la opción seleccionada por el usuario
    private static void procesarOpcion(int opcion) {
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                llegada_Cliente();
                break;
            case 2:
                atenderCliente();
                break;
            case 3:
                mostrar_Fila();
                break;
            case 4:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }

    // Método para agregar un nuevo cliente a la fila
    private static void llegada_Cliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine().trim();
        
        if (!nombre.isEmpty()) {
            fila_Clientes.add(nombre);
            System.out.println("Cliente " + nombre + " agregado a la fila.");
        } else {
            System.out.println("¡El nombre no puede estar vacío!");
        }
    }

    //Método para atender al primer cliente en la fila
    private static void atenderCliente() {
        if (fila_Clientes.isEmpty()) {
            System.out.println("No hay clientes en la fila.");
        } else {
            String clienteAtendido = fila_Clientes.poll();
            System.out.println("Atendiendo a: " + clienteAtendido);
        }
    }

    //Método para mostrar el estado actual de la fila
    private static void mostrar_Fila() {
        if (fila_Clientes.isEmpty()) {
            System.out.println("La fila está vacía.");
        } else {
            System.out.println("\n--- ESTADO ACTUAL DE LA FILA ---");
            System.out.println("Clientes en espera: " + fila_Clientes.size());
            System.out.println("Orden de atención:");
            
            int posicion = 1;
            for (String cliente : fila_Clientes) {
                System.out.println(posicion + ". " + cliente);
                posicion++;
            }
            System.out.println("-----------------------------");
        }
    }
}