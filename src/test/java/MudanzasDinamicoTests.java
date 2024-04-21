import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MudanzasDinamicoTests {
    @Test
    public void testMain() {
        assertTrue(true);
    }

    @Test
    public void testFactura() {
        assertEquals(120, MudanzasDinamico.factura(3, 40));
    }

    @Test
    public void testFacturaNulo() {assertEquals(0, MudanzasDinamico.factura(0, 40));}

    @Test
    public void testListaEstandar(){
        //Variables a cambiar para modificar el test facilmente
        float[] pesosA = {3,4,3,3,3};
        float pmax = 9;
        float[] esperado = {3,3,3};

        //Pasar de float[] a ArrayList[Float] para la entrada de voraz()
        ArrayList<Float> pesos = new ArrayList<>();
        for (float p : pesosA) {
            pesos.add(p);
        }

        //Pasar el resultado de voraz() de ArrayList<Float> a float[]
        ArrayList<Float> res = MudanzasMainList.voraz(pesos, pmax);
        float[] Res = new float[res.size()];
        for (int i = 0; i<res.size(); i++) {
            Res[i] = res.get(i);
        }

        //comprobacion que voraz() devuelve lo esperado:
        assertArrayEquals(esperado, Res);
        //comprobacion que factura() devuelve lo esperado:
        assertEquals(esperado.length*40, MudanzasMainList.factura(Res.length, 40));
    }
}
//Domain driven design
