package aerolinea.datosAsiento;

import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatosAsientoTest {
    
    public DatosAsientoTest() {
    }

    @Test
    public void seCreaExitosamenteLosDatosDeUnAcientoYFuncionanLosGetters(){
        try {
            CodigoAsiento codigo = new CodigoAsiento("G4V3", "13");
            PrecioAsiento precio = new PrecioAsiento(125.50);
            
            DatosAsiento asiento = new DatosAsiento(codigo, precio, ClaseAsiento.TURISTA, UbicacionAsiento.VENTANA, EstadoAsiento.RESERVADO);
            
            Assert.assertEquals(asiento.getCodigoAsiento(), "G4V3-13");
            Assert.assertEquals(asiento.getEstado(), EstadoAsiento.RESERVADO);
            Assert.assertEquals(asiento.getPrecio(), 125.50);
            Assert.assertEquals(asiento.getUbicacion(), UbicacionAsiento.VENTANA);
            Assert.assertEquals(asiento.getClaseAsiento(), ClaseAsiento.TURISTA);
        } catch (PrecioNegativoException ex) {
            Assert.assertEquals(true, false);
        }
    }
    
    @Test(expected = CodigoAsientoException.class)
    public void fallaCreacionCodigoSeLanzaException() throws CodigoAsientoException{
        CodigoAsiento codigo = new CodigoAsiento("CualquierCosa");
    }
    
    @Test(expected = PrecioNegativoException.class)
    public void fallaCreacionPrecioAsientoSeLanzaException() throws PrecioNegativoException{
        PrecioAsiento precio = new PrecioAsiento(-250);
    }
}
