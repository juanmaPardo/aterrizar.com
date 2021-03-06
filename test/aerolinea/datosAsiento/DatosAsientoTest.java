package aerolinea.datosAsiento;

import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.datosAsiento.excepcionesAsiento.CodigoAsientoException;
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
            ClaseAsientoVuelo clase = new ClaseAsientoVuelo(ClasesAsientoVuelo.TURISTA);
            UbicacionAsiento ubicacion = new UbicacionAsiento(UbicacionAsientoVuelo.VENTANA);
            
            DatosAsientoLanchita asiento = new DatosAsientoLanchita(codigo, precio, clase, ubicacion);
            
            Assert.assertEquals(asiento.getCodigoAsiento().getCodigo(), "G4V3-13");
            Assert.assertEquals(asiento.getEstado().getEstadoAsiento(), EstadoAsientoVuelo.DISPONIBLE);
            Assert.assertEquals(asiento.getPrecio().getPrecioAsiento(), 125.50);
            Assert.assertEquals(asiento.getUbicacionAsiento().getUbicacionAsiento(), UbicacionAsientoVuelo.VENTANA);
            Assert.assertEquals(asiento.getClaseAsiento().getClaseAsiento(), ClasesAsientoVuelo.TURISTA);
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
