## **5 - PRUEBAS**

Vamos a proceder a documentar las pruebas que realizaremos sobre nuestra aplicación.

En esta ocasión usaremos el método de **caja negra**, ya que vamos a hacerlas antes de tener el código.

### **Clases de Equivalencia**

- Vamos a determinar las clases de Equivalencia.

        - Peso Valido > 0

        - Altura/Anchura Valida > 0

        - Numero Elementos Validos > 0

        - Precio Valido > 0

### **Conjetura de errores**

- En conjetura de errores al ser productos sabemos que todo no puede ser 0, ni menor de 0.

        - Conjetura de errores <= 0

### **Limites**

- Dentro de los valores válidos de los elementos de entrada, tenemos ciertos límites según los cuales cambiará el valor de los recargos.

1. Peso

    ![alt text](/images/image.png)

2. Altura y anchura

    ![alt text](/images/image-1.png)

3. Número de elementos

    ![alt text](/images/image-2.png)

### **Tabla de apoyo para los casos de prueba**

- Al tener tantos valores, hemos hecho una tabla de apoyo en la que nos fijaremos para hacer los casos de prueba.

    ![alt text](/images/image-3.png)

### **Casos de prueba basados en los valores que teníamos antes**

![alt text](/images/Excel.png)

### **Nomenclatura de pruebas en JUnit 5**

Para hacer las pruebas en JUnit 5 en concordancia con la tabla, hemos hecho una guía muy básica.

En este caso por prueba tenemos Caso 1 que en Junit 5 sería calcularPrecioCaso**Uno**Test.

Y asi con cada caso.

```java
    @Test
    public void calcularPrecioCasoUnoTest() {
        //Contenido de la prueba correspondiente al Caso 1
    }
```

---

[INDEX](../../index.html)