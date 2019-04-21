package aerolinea.vuelo;

import aerolinea.datosAsiento.ClaseAsientoVuelo;
import aerolinea.datosAsiento.ClasesAsientoVuelo;
import aerolinea.datosAsiento.CodigoAsiento;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import aerolinea.datosAsiento.EstadoAsiento;
import aerolinea.datosAsiento.EstadoAsientoVuelo;
import aerolinea.datosAsiento.PrecioAsiento;
import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.datosAsiento.UbicacionAsiento;
import aerolinea.datosAsiento.UbicacionAsientoVuelo;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AsientoVueloTest {
    
    @Test
    public void creaAsientoVueloExitosamenteYFuncionanLosGetters(){
        try {
            CodigoAsiento codigo = new CodigoAsiento("G4V3", "13");
            PrecioAsiento precio = new PrecioAsiento(125.50);
            ClaseAsientoVuelo clase = new ClaseAsientoVuelo(ClasesAsientoVuelo.TURISTA);
            UbicacionAsiento ubicacion = new UbicacionAsiento(UbicacionAsientoVuelo.VENTANA);
            
            DatosAsientoLanchita asiento = new DatosAsientoLanchita(codigo, precio, clase, ubicacion);
            CiudadDestino dest = new CiudadDestino("LA");
            CiudadPartida orig = new CiudadPartida("BA");
            AsientoVueloLanchita asVuelo = new AsientoVueloLanchita(asiento, orig, dest);
            Assert.assertEquals(asVuelo.getDatosAsiento(), asiento);
            Assert.assertEquals(asVuelo.getOrigen(), "BA");
            Assert.assertEquals(asVuelo.getDestino(), "LA");
        } catch (PrecioNegativoException ex) {
            Assert.assertEquals(true, false);
        }
            
    }
    
}
