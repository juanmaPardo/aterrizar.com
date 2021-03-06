package aerolinea.vuelo;

import aerolinea.datosAsiento.ClaseAsientoVuelo;
import aerolinea.datosAsiento.ClasesAsientoVuelo;
import aerolinea.datosAsiento.CodigoAsiento;
import aerolinea.datosAsiento.DatosAsientoGeneral;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import aerolinea.datosAsiento.EstadoAsiento;
import aerolinea.datosAsiento.EstadoAsientoVuelo;
import aerolinea.datosAsiento.PrecioAsiento;
import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.datosAsiento.UbicacionAsiento;
import aerolinea.datosAsiento.UbicacionAsientoVuelo;
import aerolinea.vuelo.informacionVuelo.InformacionVuelo;
import fecha.Fecha;
import fecha.FechaFlexible;
import fecha.excepcionesFecha.FechaNoValidaException;
import fecha.excepcionesFecha.FormatoFechaIncorrectoException;
import horarios.Hora;
import horarios.excepcionesHora.FormatoHoraIncorrectoException;
import horarios.excepcionesHora.HoraInvalidaException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VueloTest {
    LinkedList<DatosAsientoGeneral> asientos;
    DatosAsientoLanchita asiento;
    DatosAsientoLanchita asiento1;
    DatosAsientoLanchita asiento2;
    DatosAsientoLanchita asiento3;
    DatosAsientoLanchita asiento4;
    CiudadPartida orig;
    CiudadDestino dest;
    Fecha fechaSalida;
    Hora horaSalida;
    Vuelo vuelo;
    public VueloTest() {
    }
    
    @Before
    public void setUp(){
        try {
            CodigoAsiento codigo = new CodigoAsiento("G4V3", "13");
            CodigoAsiento codigo1 = new CodigoAsiento("G4V3", "14");
            CodigoAsiento codigo2 = new CodigoAsiento("G4V3", "15");
            CodigoAsiento codigo3 = new CodigoAsiento("G4V3", "16");
            CodigoAsiento codigo4 = new CodigoAsiento("G4V3", "17");
            PrecioAsiento precio1 = new PrecioAsiento(125.50);
            PrecioAsiento precio2 = new PrecioAsiento(250.50);
            PrecioAsiento precio3 = new PrecioAsiento(500);
            ClaseAsientoVuelo clase = new ClaseAsientoVuelo(ClasesAsientoVuelo.TURISTA);
            ClaseAsientoVuelo clase1 = new ClaseAsientoVuelo(ClasesAsientoVuelo.EJECUTIVO);
            ClaseAsientoVuelo clase2 = new ClaseAsientoVuelo(ClasesAsientoVuelo.PRIMERA_CLASE);
            UbicacionAsiento ubicacion = new UbicacionAsiento(UbicacionAsientoVuelo.VENTANA);
            UbicacionAsiento ubicacion2 = new UbicacionAsiento(UbicacionAsientoVuelo.PASILLO);
            horaSalida = new Hora("20:15");
            
            
            asiento = new DatosAsientoLanchita(codigo, precio1, clase, ubicacion);
            asiento1 = new DatosAsientoLanchita(codigo1, precio1, clase, ubicacion);
            asiento2 = new DatosAsientoLanchita(codigo2, precio2, clase1, ubicacion2);
            asiento3 = new DatosAsientoLanchita(codigo3, precio2, clase1, ubicacion2);
            asiento4 = new DatosAsientoLanchita(codigo4, precio3, clase2, ubicacion);
            asientos = new LinkedList<>();
            asientos.add(asiento);
            asientos.add(asiento1);
            asientos.add(asiento2);
            asientos.add(asiento3);
            asientos.add(asiento4);
            
            dest = new CiudadDestino("LA");
            orig = new CiudadPartida("BA");
            
            fechaSalida = new FechaFlexible("2018/11/01");
            
            
            vuelo = new Vuelo(orig, dest, horaSalida, fechaSalida);
          
        } catch (PrecioNegativoException ex) {
            Assert.assertEquals(true, false);
        } catch (FormatoFechaIncorrectoException | FechaNoValidaException | FormatoHoraIncorrectoException | HoraInvalidaException ex) {
            Assert.assertEquals(true, false);
        }
    }
    
    @Test
    public void seAgreganTodosLosAsientosCorrectamente(){
        vuelo.agregarAsiento(asiento);
        vuelo.agregarAsiento(asiento1);
        vuelo.agregarAsiento(asiento2);
        vuelo.agregarAsiento(asiento3);
        vuelo.agregarAsiento(asiento4);
    }
    
    @Test
    public void seObtieneLaListaDeAsientosDelVuelo(){
        LinkedList<AsientoGeneralVuelo> resultado = vuelo.getDatosAsientoVuelo();
        resultado.forEach(as ->{
            Assert.assertEquals(as.getDestino().getCiudad(), "LA");
            Assert.assertEquals(as.getOrigen().getCiudad(), "BA");
            assertTrue(asientos.contains(as.getDatosAsiento()));
            
        });
        //assertThat()
    }
}
