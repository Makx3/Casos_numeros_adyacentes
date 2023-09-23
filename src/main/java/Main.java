import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arreglo = validarArregloDesdeConsola(scanner);

        int maxProducto = productoAdyacente(arreglo);
        System.out.println("El mayor producto de números adyacentes es: " + maxProducto);

        scanner.close();
    }

    public static int[] validarArregloDesdeConsola(Scanner scanner) {
        int n = 0;
        do {
            try {
                System.out.print("Ingrese la cantidad de elementos en el arreglo (debe ser al menos 2): ");
                n = scanner.nextInt();

                if (n < 2) {
                    System.out.println("El arreglo debe tener al menos dos elementos.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor numérico válido.");
                scanner.nextLine();
            }
        } while (n < 2);

        int[] arreglo = new int[n];

        System.out.println("Ingrese los elementos del arreglo uno por uno:");

        for (int i = 0; i < n; i++) {
            boolean entradaValida = false;
            do {
                try {
                    System.out.print("Elemento " + (i + 1) + ": ");
                    arreglo[i] = scanner.nextInt();
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un valor numérico válido.");
                    scanner.nextLine();
                }
            } while (!entradaValida);
        }

        return arreglo;
    }

    public static int productoAdyacente(int[] arr) {
        int maxProducto = arr[0] * arr[1];

        for (int i = 1; i < arr.length - 1; i++) {
            int productoActual = arr[i] * arr[i + 1];
            if (productoActual > maxProducto) {
                maxProducto = productoActual;
            }
        }

        return maxProducto;
    }
}
