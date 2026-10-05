import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmpleadoTest {

    private Empleado empleado;
    private static final float DELTA = 0.001f; //Lo pongo porque al trabajar con float
    //siempre puede haber un margen de error. Si el error es inferior a 0.0001, es resultado válido.
    

    @BeforeEach
    void setUp() {
        empleado = new Empleado();
    }

    @Test
    @DisplayName("1. Tipo de empleado: VENDEDOR")
    void test1_tipoVendedor() {
        assertEquals(2000.0f, Empleado.calcularNominaBruta(TipoEmpleado.VENDEDOR, 0.0f, 0.0f), DELTA);
    }

    @Test
    @DisplayName("2. Tipo de empleado: ENCARGADO")
    void test2_tipoEncargado() {
        assertEquals(2500.0f, Empleado.calcularNominaBruta(TipoEmpleado.ENCARGADO, 0.0f, 0.0f), DELTA);
    }

    @Test
    @DisplayName("3. Tipo de empleado: OTRO (inválido)")
    void test3_tipoOtro() {
        assertEquals(-1.0f, Empleado.calcularNominaBruta(TipoEmpleado.OTRO, 0.0f, 0.0f), DELTA);
    }

    @Test
    @DisplayName("4. Ventas: < 1000 euros (sin prima)")
    void test4_ventasMenor1000() {
        assertEquals(2000.0f, Empleado.calcularNominaBruta(TipoEmpleado.VENDEDOR, 800.0f, 0.0f), DELTA);
    }

    @Test
    @DisplayName("5. Ventas: entre 1000 y 1500 euros (prima 100)")
    void test5_ventasEntre1000y1500() {
        assertEquals(2100.0f, Empleado.calcularNominaBruta(TipoEmpleado.VENDEDOR, 1200.0f, 0.0f), DELTA);
    }

    @Test
    @DisplayName("6. Ventas: >= 1500 euros (prima 200)")
    void test6_ventasMayorIgual1500() {
        // Base 2000 + prima 200 = 2200
        assertEquals(2200.0f, Empleado.calcularNominaBruta(TipoEmpleado.VENDEDOR, 1500.0f, 0.0f), DELTA);
    }

    @Test
    @DisplayName("7. Ventas: Negativas (inválido)")
    void test7_ventasNegativas() {
        assertEquals(-1.0f, Empleado.calcularNominaBruta(TipoEmpleado.VENDEDOR, -100.0f, 0.0f), DELTA);
    }

    @Test
    @DisplayName("8. Horas extra: SÍ (con horas extra)")
    void test8_horasExtraSi() {
        assertEquals(2060.0f, Empleado.calcularNominaBruta(TipoEmpleado.VENDEDOR, 0.0f, 2.0f), DELTA);
    }

    @Test
    @DisplayName("9. Horas extra: NO (0 horas extra)")
    void test9_horasExtraNo() {
        assertEquals(2000.0f, Empleado.calcularNominaBruta(TipoEmpleado.VENDEDOR, 0.0f, 0.0f), DELTA);
    }

    @Test
    @DisplayName("10. Neto: nómina bruta < 2100 euros (retención 0%)")
    void test10_netoMenor2100() {
        assertEquals(2000.0f, empleado.calculoNominaNeta(2000.0f), DELTA);
    }

    @Test
    @DisplayName("11. Neto: nómina bruta entre 2100 y 2500 euros (retención 15%)")
    void test11_netoEntre2100y2500() {
        assertEquals(1785.0f, empleado.calculoNominaNeta(2100.0f), DELTA);
    }

    @Test
    @DisplayName("12. Neto: nómina bruta >= 2500 euros (retención 18%)")
    void test12_netoMayorIgual2500() {
        assertEquals(2050.0f, empleado.calculoNominaNeta(2500.0f), DELTA);
    }

    @Test
    @DisplayName("13. Neto: nómina bruta Negativa (inválido)")
    void test13_netoNegativo() {
        assertEquals(-1.0f, empleado.calculoNominaNeta(-500.0f), DELTA);
    }
}