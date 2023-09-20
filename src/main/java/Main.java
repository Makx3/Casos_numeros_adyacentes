import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ejecutarPrograma(scanner);
    }

    public static void ejecutarPrograma(Scanner scanner) {
        int[] arreglo = validarArregloDesdeConsola(scanner);

        int maxProducto = productoAdyacente(arreglo);
        System.out.println("El mayor producto de números adyacentes es: " + maxProducto);
    }

    public static int[] validarArregloDesdeConsola(Scanner scanner) {
        System.out.print("Ingrese la cantidad de elementos en el arreglo: ");
        int n = scanner.nextInt();

        if (n < 2) {
            throw new IllegalArgumentException("El arreglo debe tener al menos dos elementos");
        }

        int[] arreglo = new int[n];

        System.out.println("Ingrese los elementos del arreglo uno por uno:");

        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
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
