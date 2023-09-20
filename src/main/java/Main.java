public class Main {
    public static void main(String[] args) {
        int[] arreglo = {1, -4, 2, 2, 5, -1};
        int maxProducto = productoAdyacentes(arreglo);
        System.out.println("El producto adyacente es: " + maxProducto);
    }

    public static int productoAdyacentes(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("El arreglo debe tener al menos dos elementos");
        }

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
