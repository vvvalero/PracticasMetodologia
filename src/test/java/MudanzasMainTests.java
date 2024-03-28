import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class MudanzasMainTests {
    @Test
    public void testMain() {
        assertTrue(true);
    }

    @Test
    public void testFactura() {
        assertEquals(120, MudanzasMainList.factura(3, 40));
    }

    @Test
    public void testFacturaNulo() {
        assertEquals(0, MudanzasMainList.factura(0, 40));
    }

    @Test
    public void testVorazListEstandar(){
        //Variables a cambiar para modificar el test facilmente
        float[] pesosA = {30,50,20,70,10};
        float pmax = 100;
        float[] esperado = {10,20,30};

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

    @Test
    public void testVorazListInsuficiente(){
        float[] pesosA = {60,30,40};
        float pmax = 50;
        float[] esperado = {30};

        ArrayList<Float> pesos = new ArrayList<>();
        for (float p : pesosA) {
            pesos.add(p);
        }

        ArrayList<Float> res = MudanzasMainList.voraz(pesos, pmax);
        float[] Res = new float[res.size()];
        for (int i = 0;i<res.size();i++) {
            Res[i] = res.get(i);
        }

        assertArrayEquals(esperado, Res);
        assertEquals(esperado.length*40, MudanzasMainList.factura(Res.length, 40));
    }

    @Test
    public void testVorazListIgual(){
        float[] pesosA = {30,30,30,30,30};
        float pmax = 100;
        float[] esperado = {30,30,30};

        ArrayList<Float> pesos = new ArrayList<>();
        for (float p : pesosA) {
            pesos.add(p);
        }

        ArrayList<Float> res = MudanzasMainList.voraz(pesos, pmax);
        float[] Res = new float[res.size()];
        for (int i = 0;i<res.size();i++) {
            Res[i] = res.get(i);
        }

        assertArrayEquals(esperado, Res);
        assertEquals(esperado.length*40, MudanzasMainList.factura(Res.length, 40));
    }

    @Test
    public void testVorazListPesoMax(){
        float[] pesosA = {100,100};
        float pmax = 100;
        float[] esperado = {100};

        ArrayList<Float> pesos = new ArrayList<>();
        for (float p : pesosA) {
            pesos.add(p);
        }

        ArrayList<Float> res = MudanzasMainList.voraz(pesos, pmax);
        float[] Res = new float[res.size()];
        for (int i = 0;i<res.size();i++) {
            Res[i] = res.get(i);
        }

        assertArrayEquals(esperado, Res);
        assertEquals(esperado.length*40, MudanzasMainList.factura(Res.length, 40));
    }

    @Test
    public void testVorazListVacio(){
        float[] pesosA = {};
        float pmax = 100;
        float[] esperado = {};

        ArrayList<Float> pesos = new ArrayList<>();
        for (float p : pesosA) {
            pesos.add(p);
        }

        ArrayList<Float> res = MudanzasMainList.voraz(pesos, pmax);
        float[] Res = new float[res.size()];
        for (int i = 0;i<res.size();i++) {
            Res[i] = res.get(i);
        }

        assertArrayEquals(esperado, Res);
        assertEquals(esperado.length*40, MudanzasMainList.factura(Res.length, 40));
    }
    @Test
    public void testVorazListDuplicados(){
        float[] pesosA = {20,30,30,40};
        float pmax = 100;
        float[] esperado = {20,30,30};

        ArrayList<Float> pesos = new ArrayList<>();
        for (float p : pesosA) {
            pesos.add(p);
        }

        ArrayList<Float> res = MudanzasMainList.voraz(pesos, pmax);
        float[] Res = new float[res.size()];
        for (int i = 0;i<res.size();i++) {
            Res[i] = res.get(i);
        }

        assertArrayEquals(esperado, Res);
        assertEquals(esperado.length*40, MudanzasMainList.factura(Res.length, 40));
    }

    @Test
    public void testVorazNegativo(){
        float[] pesosA = {20,30,30,40};
        float pmax = -100;
        RuntimeException esperado = new RuntimeException("Peso maximo superado");

        ArrayList<Float> pesos = new ArrayList<>();
        for (float p : pesosA) {
            pesos.add(p);
        }
        try {
            MudanzasMainList.voraz(pesos, pmax);

        }catch(RuntimeException res){
            assertEquals(res.getMessage(), esperado.getMessage());
        }

    }

    @Test
    public void testVorazListCero(){
        float[] pesosA = {20,30,30,40};
        float pmax = 0;
        float[] esperado = {};

        ArrayList<Float> pesos = new ArrayList<>();
        for (float p : pesosA) {
            pesos.add(p);
        }

        ArrayList<Float> res = MudanzasMainList.voraz(pesos, pmax);
        float[] Res = new float[res.size()];
        for (int i = 0;i<res.size();i++) {
            Res[i] = res.get(i);
        }

        assertArrayEquals(esperado, Res);
        assertEquals(0, MudanzasMainList.factura(Res.length, 40));
    }

    @Test
    public void testVorazListPesoNegativo(){
        float[] pesosA = {20,-30,40};
        float pmax = 100;
        float[] esperado = {20,40};

        ArrayList<Float> pesos = new ArrayList<>();
        for (float p : pesosA) {
            pesos.add(p);
        }

        ArrayList<Float> res = MudanzasMainList.voraz(pesos, pmax);
        float[] Res = new float[res.size()];
        for (int i = 0;i<res.size();i++) {
            Res[i] = res.get(i);
        }

        assertArrayEquals(esperado, Res);
        assertEquals(esperado.length*40, MudanzasMainList.factura(Res.length, 40));
    }
    @Test
    public void testVorazListPesoNegativoUnico(){
        float[] pesosA = {-30};
        float pmax = 100;
        float[] esperado = {};

        ArrayList<Float> pesos = new ArrayList<>();
        for (float p : pesosA) {
            pesos.add(p);
        }

        ArrayList<Float> res = MudanzasMainList.voraz(pesos, pmax);
        float[] Res = new float[res.size()];
        for (int i = 0;i<res.size();i++) {
            Res[i] = res.get(i);
        }

        assertArrayEquals(esperado, Res);
        assertEquals(esperado.length*40, MudanzasMainList.factura(Res.length, 40));
    }
    @Test
    public void testVorazListUnicoPesoExcede(){
        float[] pesosA = {60};
        float pmax = 50;
        float[] esperado = {};

        ArrayList<Float> pesos = new ArrayList<>();
        for (float p : pesosA) {
            pesos.add(p);
        }

        ArrayList<Float> res = MudanzasMainList.voraz(pesos, pmax);
        float[] Res = new float[res.size()];
        for (int i = 0;i<res.size();i++) {
            Res[i] = res.get(i);
        }

        assertArrayEquals(esperado, Res);
        assertEquals(esperado.length*40, MudanzasMainList.factura(Res.length, 40));
    }


}
