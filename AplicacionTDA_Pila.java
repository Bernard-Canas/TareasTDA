/* 
Autor: Bernardo Canas
Carnet: 202401637
*/
import java.util.Scanner;
import java.util.Stack;

public class AplicacionTDA_Pila {
    private static Stack<String> texto = new Stack<>();
    private static Stack<String> deshechos = new Stack<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {        
        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 5);
        
        scanner.close();
    }
    private static void mostrarMenu() {
        System.out.println("\n<=== MENÚ PRINCIPAL ===>");
        System.out.println("1. Agregar texto");
        System.out.println("2. MOSTRAR");
        System.out.println("3. DESHACER");
        System.out.println("4. REHACER");
        System.out.println("5. Salir");
        System.out.print("   Elije una opción: ");
    }
    private static int obtenerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor ingrese un número.");
            scanner.next(); //Limpiamos entrada 
            System.out.print("Elije una opción: ");
        }
        return scanner.nextInt();
    }
    private static void procesarOpcion(int opcion) {
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                agregarTexto();
                break;
            case 2:
                mostrarTexto();
                break;
            case 3:
                deshacer();
                break;
            case 4:
                rehacer();
                break;
            case 5:
                System.out.println("Saliendo del programa...\n");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }
    private static void agregarTexto() {
        System.out.print("Ingrese el texto a agregar: ");
        String entrada = scanner.nextLine().trim();
        if (!entrada.isEmpty()) {
            texto.push(entrada);
            deshechos.clear(); //Limpiar al agregar texto nuevo
            System.out.println("Texto agregado: " + entrada);
        } else {
            System.out.println("No se puede agregar texto vacío.");
        }
    }
    private static void mostrarTexto() {
        if (texto.isEmpty()) {
            System.out.println("¡No hay Texto agreado!");
        } else {
            System.out.println("\n<--- TEXTO AGREGADO --->");
            texto.forEach(System.out::println);
            System.out.println("<--------------------->");
        }
        
        //Opción para agregar texto después de mostrar
        System.out.print("¿Deseas agregar texto? (S/N): ");
        String respuesta = scanner.nextLine().trim();
        if (respuesta.equalsIgnoreCase("S")) {
            agregarTexto();
        }
    }
    private static void deshacer() {
        if (!texto.isEmpty()) {
            String ultimo = texto.pop();
            deshechos.push(ultimo);
            System.out.println("Acción deshecha: " + ultimo);
        } else {
            System.out.println("No hay texto para deshacer.");
        }
    }
    private static void rehacer() {
        if (!deshechos.isEmpty()) {
            String rehacer = deshechos.pop();
            texto.push(rehacer);
            System.out.println("Acción rehecha: " + rehacer);
        } else {
            System.out.println("No hay texto para rehacer.");
        }
    }
}
