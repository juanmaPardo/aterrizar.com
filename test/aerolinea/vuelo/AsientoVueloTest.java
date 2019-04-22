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
import fecha.FechaFlexible;
import fecha.excepcionesFecha.FechaNoValidaException;
import fecha.excepcionesFecha.FormatoFechaIncorrectoException;
import horarios.Hora;
import horarios.excepcionesHora.FormatoHoraIncorrectoException;
import horarios.excepcionesHora.HoraInvalidaException;
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
            FechaFlexible fecha = new FechaFlexible("2018/12/05");
            Hora hora = new Hora("20:15");
            
            DatosAsientoLanchita asiento = new DatosAsientoLanchita(codigo, precio, clase, ubicacion);
            CiudadDestino dest = new CiudadDestino("LA");
            CiudadPartida orig = new CiudadPartida("BA");
            AsientoVueloLanchita asVuelo = new AsientoVueloLanchita(asiento, dest, orig, fecha, hora);
            Assert.assertEquals(asVuelo.getDatosAsiento(), asiento);
            Assert.assertEquals(asVuelo.getOrigen().getCiudad(), "BA");
            Assert.assertEquals(asVuelo.getDestino().getCiudad(), "LA");
            Assert.assertEquals(asVuelo.getFechaSalida(), fecha);
            Assert.assertEquals(asVuelo.getHoraSalida(),hora);
        } catch (PrecioNegativoException ex) {
            Assert.assertEquals(true, false);
        } catch (FormatoFechaIncorrectoException | FechaNoValidaException | FormatoHoraIncorrectoException | HoraInvalidaException ex) {
            Assert.assertEquals(true, false);
        }
            
    }
    
}
