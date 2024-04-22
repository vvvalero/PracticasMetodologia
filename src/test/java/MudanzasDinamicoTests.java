import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import operaciones.ArrayMatriz;

public class MudanzasDinamicoTests {
    @Test
    public void testMain() {
        assertTrue(true);
    }


    public int[] operaciones(int[] pesosA,int pmax){
        //Pasar de float[] a ArrayList[Float] para la entrada de voraz()
        ArrayList<Integer> pesos = ArrayMatriz.toArrayList(pesosA);

        //Pasar el resultado del algoritmo de ArrayList<Float> a float[]
        ArrayList<Integer> res = MudanzasDinamico.algoritmoDinamico(pesos,pmax,6);
        int[] Res = ArrayMatriz.toMatriz(res);

        return Res;
    }

    @Test
    public void testFactura() {
        int[] aux = {20,15,5};
        assertEquals(120, MudanzasDinamico.factura(3, ArrayMatriz.toArrayList(aux)));
    }

    @Test
    public void testFacturaNulo() {assertEquals(0, MudanzasDinamico.factura(0, new ArrayList<>()));}

    @Test
    public void testListaEstandar(){
        //Variables a cambiar para modificar el test facilmente
        int[] pesosA = {3,4,3,3,3};
        int pmax = 9;
        int[] esperado = {3,3,3};
        int esperadoFactura = 54;
        int benefKilo = 6;

        int[]Res = operaciones(pesosA,pmax);

        //comprobacion que el algoritmo devuelve lo esperado:
        assertArrayEquals(esperado, Res);
        //comprobacion que factura() devuelve lo esperado:
        assertEquals(esperadoFactura, MudanzasDinamico.factura(benefKilo,ArrayMatriz.toArrayList(Res)));
    }
    @Test
    public void testListaEstandarDos(){
        //Variables a cambiar para modificar el test facilmente
        int[] pesosA = {30,50,20,70,10};
        int pmax = 100;
        int[] esperado = {20,50,30};
        int esperadoFactura = 600;
        int benefKilo = 6;

        int[]Res = operaciones(pesosA,pmax);

        //comprobacion que el algoritmo devuelve lo esperado:
        assertArrayEquals(esperado, Res);
        //comprobacion que factura() devuelve lo esperado:
        assertEquals(esperadoFactura, MudanzasDinamico.factura(benefKilo,ArrayMatriz.toArrayList(Res)));
    }
    @Test
    //NO PASA EL TEST, DEVUELVE {50,50} POR ALGUN MOTIVO:
    public void testListaEstandarTres(){
        //Variables a cambiar para modificar el test facilmente
        int[] pesosA = {30,50,80};
        int pmax = 100;
        int[] esperado = {50,30};
        int esperadoFactura = 360;
        int benefKilo = 6;

        int[]Res = operaciones(pesosA,pmax);

        //comprobacion que el algoritmo devuelve lo esperado:
        assertArrayEquals(esperado, Res);
        //comprobacion que factura() devuelve lo esperado:
        assertEquals(esperadoFactura, MudanzasDinamico.factura(benefKilo,ArrayMatriz.toArrayList(Res)));
    }

    @Test
    public void testListaPesoNulo(){
        //Variables a cambiar para modificar el test facilmente
        int[] pesosA = {};
        int pmax = 100;
        int[] esperado = {};
        int esperadoFactura = 0;
        int benefKilo = 6;

        int[]Res = operaciones(pesosA,pmax);

        //comprobacion que el algoritmo devuelve lo esperado:
        assertArrayEquals(esperado, Res);
        //comprobacion que factura() devuelve lo esperado:
        assertEquals(esperadoFactura, MudanzasDinamico.factura(benefKilo,ArrayMatriz.toArrayList(Res)));
    }
    @Test
    public void testListaPesoMayor(){
        //Variables a cambiar para modificar el test facilmente
        int[] pesosA = {150,20,70};
        int pmax = 100;
        int[] esperado = {70,20};
        int esperadoFactura = 540;
        int benefKilo = 6;

        int[]Res = operaciones(pesosA,pmax);

        //comprobacion que el algoritmo devuelve lo esperado:
        assertArrayEquals(esperado, Res);
        //comprobacion que factura() devuelve lo esperado:
        assertEquals(esperadoFactura, MudanzasDinamico.factura(benefKilo,ArrayMatriz.toArrayList(Res)));
    }

}
//Domain driven design
