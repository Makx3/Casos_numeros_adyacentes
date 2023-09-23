# Casos_numeros_adyacentes

Tiempo esperado: 20 minutos

Estructura de la definición del método productoAdyacentes:

i. Parámetros de entrada (y tipo de dato asociado):

Parámetro de entrada: arr (tipo de dato: int[])
Este parámetro es un arreglo de enteros que representa la lista de números de la cual se buscará el mayor producto de números adyacentes.

ii. Valor de retorno:

Tipo de dato de retorno: int
El método devuelve un valor de tipo entero que representa el mayor producto de números adyacentes encontrados en el arreglo de entrada.

iii. Instrucciones:

1. Comprobar si el arreglo tiene al menos dos elementos. Si no, lanzar una validación.    
2. Inicializar una variable para el máximo producto.
3. Usar un bucle para recorrer el arreglo desde el segundo elemento hasta el penúltimo elemento.
4. En cada iteración, calcula el producto de los elementos adyacentes actual y el siguiente.
5. Comparar el producto actual con el máximo producto y actualizarlo si es mayor. 
6. Retornar el valor del máximo producto.
