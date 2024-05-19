package es.tiernoparla.daw.mercadaw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.tiernoparla.daw.mercadaw.model.entity.producto.Alimentacion;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Caracteristica;
import es.tiernoparla.daw.mercadaw.model.entity.producto.Producto;

public class CalcularPrecioTest {
    @Test
    public void calcularPrecioCasoUnoTest() {
        Caracteristica c1 = new Caracteristica(0.5, 0.5, 1, 1);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c1, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.44, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoDosTest() {
        Caracteristica c2 = new Caracteristica(1, 1, 1, 1);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c2, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.56, resultado, 0.1);
    }

    //Cambiado anchura de 0.5 a 1 y elementos de 1 a 2
    @Test
    public void calcularPrecioCasoTresTest() {
        Caracteristica c3 = new Caracteristica(0.5, 1, 1, 2);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c3, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.74, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoCuatroTest() {
        Caracteristica c4 = new Caracteristica(1, 1, 1, 3);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c4, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.86, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoCincoTest() {
        Caracteristica c5 = new Caracteristica(0.5, 0.5, 2, 1);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c5, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.50, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoSeisTest() {
        Caracteristica c6 = new Caracteristica(1, 1, 2, 1);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c6, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.63, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoSieteTest() {
        Caracteristica c7 = new Caracteristica(0.5, 0.5, 2, 3);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c7, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.80, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoOchoTest() {
        Caracteristica c8 = new Caracteristica(1, 1, 2, 1);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c8, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.63, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoNueveTest() {
        Caracteristica c9 = new Caracteristica(0.5, 0.5, 6, 1);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c9, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.56, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoDiezTest() {
        Caracteristica c10 = new Caracteristica(1, 1, 6, 1);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c10, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.69, resultado, 0.1);
    }

    //Cambiado elementos de 3 a 2
    @Test
    public void calcularPrecioCasoOnceTest() {
        Caracteristica c11 = new Caracteristica(0.5, 0.5, 6, 2);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c11, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.86, resultado, 0.1);
    }

    //Cambiado anchura de 1 a 0.5
    @Test
    public void calcularPrecioCasoDoceTest() {
        Caracteristica c12 = new Caracteristica(1, 0.5, 6, 2);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c12, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.99, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoTreceTest() {
        Caracteristica c13 = new Caracteristica(0.5, 1, 1, 1);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c13, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.50, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoCatorceTest() {
        Caracteristica c14 = new Caracteristica(1, 0.5, 1, 1);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c14, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.44, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoQuinceTest() {
        Caracteristica c15 = new Caracteristica(0.5, 1, 1, 3);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c15, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.80, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoDieciseisTest() {
        Caracteristica c16 = new Caracteristica(0.5, 1, 2, 1);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c16, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.56, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoDiecisieteTest() {
        Caracteristica c17 = new Caracteristica(0.5, 1, 2, 3);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c17, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.86, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoDieciochoTest() {
        Caracteristica c18 = new Caracteristica(0.5, 1, 6, 1);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c18, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.63, resultado, 0.1);
    }

    @Test
    public void calcularPrecioCasoDiecinueveTest() {
        Caracteristica c19 = new Caracteristica(0.5, 1, 6, 3);
        Producto p = new Alimentacion("Leche", "Hacendado", 1, c19, "Leche de la marca Hacendado", "Alimentacion");

        double resultado = p.calcularPrecioTotal();
        assertEquals(1.93, resultado, 0.1);
    }
}
