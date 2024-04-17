import org.junit.jupiter.api.Test;
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

}
