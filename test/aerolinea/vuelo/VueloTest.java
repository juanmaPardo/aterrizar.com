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
import aerolinea.vuelo.informacionVuelo.InformacionFechaVuelo;
import aerolinea.vuelo.informacionVuelo.InformacionHorariosVuelo;
import aerolinea.vuelo.informacionVuelo.InformacionRutaVuelo;
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
    LinkedList<DatosAsientoLanchita> asientos;
    DatosAsientoLanchita asiento;
    DatosAsientoLanchita asiento1;
    DatosAsientoLanchita asiento2;
    DatosAsientoLanchita asiento3;
    DatosAsientoLanchita asiento4;
    CiudadPartida orig;
    CiudadDestino dest;
    Fecha fechaSalida;
    Fecha fechaLlegada;
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
            InformacionVuelo infoVuelo;
            InformacionFechaVuelo infoFecha;
            InformacionHorariosVuelo infoHorario;
            InformacionRutaVuelo infoRuta;
            
            
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
            
            fechaSalida = new FechaFlexible("12/05/2018");
            fechaLlegada = new FechaFlexible("13/05/2018");
            infoFecha = new InformacionFechaVuelo(fechaSalida, fechaLlegada);
            infoRuta = new InformacionRutaVuelo(orig, dest);
            infoHorario = new InformacionHorariosVuelo(new Hora("15:30"), new Hora("12:30"));
            infoVuelo = new InformacionVuelo(infoFecha, infoHorario, infoRuta);
            
            vuelo = new Vuelo(infoVuelo);
          
        } catch (PrecioNegativoException ex) {
            Assert.assertEquals(true, false);
        } catch (FormatoFechaIncorrectoException | FechaNoValidaException | FormatoHoraIncorrectoException | HoraInvalidaException ex) {
            Logger.getLogger(VueloTest.class.getName()).log(Level.SEVERE, null, ex);
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
        LinkedList<AsientoVueloLanchita> resultado = vuelo.getDatosAsientoVuelo();
        resultado.forEach(asiento ->{
            Assert.assertEquals(asiento.getDestino(), "LA");
            Assert.assertEquals(asiento.getOrigen(), "BA");
            assertTrue(asientos.contains(asiento.getDatosAsiento()));
            
        });
        //assertThat()
    }
}
