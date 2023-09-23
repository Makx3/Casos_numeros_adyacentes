import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

public class MainTest {
    private final InputStream originalSystemIn = System.in;
    private final ByteArrayInputStream testInput = new ByteArrayInputStream("".getBytes());

    @BeforeEach
    public void setUp() {
        System.setIn(testInput);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testValidarArregloDesdeConsola() {
        String input = "1\n2\n3\n";
        testInput.reset();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int[] arreglo = Main.validarArregloDesdeConsola(new java.util.Scanner(System.in));
        int[] expected = {1, 2, 3};

        assertArrayEquals(expected, arreglo);
    }

    @Test
    public void testValidarArregloDesdeConsola_ArgumentoInvalido() {
        String input = "invalid\n2\n3\n";
        testInput.reset();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(InputMismatchException.class, () -> {
            Main.validarArregloDesdeConsola(new java.util.Scanner(System.in));
        });
    }

    @Test
    public void testValidarArregloDesdeConsola_LargoInvalido() {
        String input = "1\n";
        testInput.reset();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            Main.validarArregloDesdeConsola(new java.util.Scanner(System.in));
        });
    }

    @Test
    public void testProductoAdyacente() {
        int[] arreglo = {1, -4, 2, 2, 5, -1};
        int maxProducto = Main.productoAdyacente(arreglo);
        assertEquals(10, maxProducto);
    }

    @Test
    public void testProductoAdyacente_UnElemento() {
        int[] arreglo = {5};
        int maxProducto = Main.productoAdyacente(arreglo);
        assertEquals(0, maxProducto);
    }

    @Test
    public void testProductoAdyacente_ElementosNegativos() {
        int[] arreglo = {-2, 5, -3, 4};
        int maxProducto = Main.productoAdyacente(arreglo);
        assertEquals(15, maxProducto);
    }

    @Test
    public void testProductoAdyacente_ArrayVacio() {
        int[] arreglo = {};
        int maxProducto = Main.productoAdyacente(arreglo);
        assertEquals(0, maxProducto);
    }

    @Test
    public void testProductoAdyacente_ProductoCero() {
        int[] arreglo = {1, 0, 2};
        int maxProducto = Main.productoAdyacente(arreglo);
        assertEquals(2, maxProducto);
    }

    @Test
    public void testProductoAdyacente_ListaNegativa() {
        int[] arreglo = {-5, -10, -3, -7};
        int maxProducto = Main.productoAdyacente(arreglo);
        assertEquals(30, maxProducto);
    }

    @Test
    public void testProductoAdyacenteIndexOverflow() {
        int[] arreglo = {1};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Main.productoAdyacente(arreglo);
        });
    }
}
