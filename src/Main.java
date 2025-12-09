import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner entrada = new Scanner(System.in);

        int opc;

        do {
            System.out.println("\n=== Gestion de Participantes ===");
            System.out.println("1. Agregar participantes");
            System.out.println("2. Visualizar recorridos (Pre, In, Post)"); // Texto actualizado
            System.out.println("3. Visualizar estadisticas");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            opc = entrada.nextInt();

            switch (opc) {
                case 1:
                    agregarParticipantes(arbol, entrada);
                    break;

                case 2:
                    arbol.visualizarRecorridos();
                    break;

                case 3:
                    arbol.mostrarEstadisticas();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opc != 4);

        entrada.close();
    }

    private static void agregarParticipantes(ArbolBinario arbol, Scanner entrada) {
        int respuesta;
        do {
            System.out.print("Matricula: ");
            int matricula = entrada.nextInt();

            System.out.println("Selecciona la categoria:");
            System.out.println("1. Principiante");
            System.out.println("2. Intermedio");
            System.out.println("3. Avanzado");
            System.out.print("Opción: ");
            int opcCat = entrada.nextInt();
            String categoria;

            switch (opcCat) {
                case 1: categoria = "Principiante"; break;
                case 2: categoria = "Intermedio"; break;
                case 3: categoria = "Avanzado"; break;
                default:
                    System.out.println("Opcion no válida, se asignara 'Principiante' por defecto.");
                    categoria = "Principiante";
                    break;
            }

            System.out.print("Edad: ");
            int edad = entrada.nextInt();

            Participante nuevo = new Participante(matricula, categoria, edad);
            if (!arbol.validarRaiz()) {
                arbol.setRaiz(nuevo);
                System.out.println("Participante agregado como raiz del arbol.");
            } else {
                arbol.insertarNodo(arbol.getRaiz(), nuevo);
                System.out.println("Participante agregado al arbol.");
            }

            System.out.print("¿Deseas agregar otro participante? (1 = Si, otro numero = No): ");
            respuesta = entrada.nextInt();

        } while (respuesta == 1);
    }
}