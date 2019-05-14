package aerolinea.busqueda;

import aerolinea.AerolineaLanchita;
import aerolinea.AerolineaOceanic;
import aerolinea.busqueda.ExcepcionesBusqueda.ParametrosInsuficienteException;
import aerolinea.datosAsiento.ClaseAsientoVuelo;
import aerolinea.datosAsiento.ClasesAsientoVuelo;
import aerolinea.datosAsiento.CodigoAsiento;
import aerolinea.datosAsiento.DatosAsientoGeneral;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import aerolinea.datosAsiento.DatosAsientoOceanic;
import aerolinea.datosAsiento.PrecioAsiento;
import aerolinea.datosAsiento.PrecioMaximoAsiento;
import aerolinea.datosAsiento.PrecioMinimoAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;
import aerolinea.datosAsiento.UbicacionAsientoVuelo;
import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.vuelo.AsientoGeneral;
import aerolinea.vuelo.AsientoGeneralVuelo;
import aerolinea.vuelo.CiudadDestino;
import aerolinea.vuelo.CiudadPartida;
import aerolinea.vuelo.Vuelo;
import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import fecha.Fecha;
import fecha.FechaFlexible;
import fecha.FechaFormatoLatinoamericano;
import fecha.excepcionesFecha.FechaNoValidaException;
import fecha.excepcionesFecha.FormatoFechaIncorrectoException;
import horarios.Hora;
import horarios.excepcionesHora.FormatoHoraIncorrectoException;
import horarios.excepcionesHora.HoraInvalidaException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import junit.framework.Assert;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BusquedaTest {
    
    DatosAsientoLanchita asientoEjecutivoPasillo500;
    DatosAsientoLanchita asientoPrimeraCLaseVentana125;
    DatosAsientoLanchita asientoTuristaVentana250;
    CiudadPartida buenosAires;
    CiudadPartida paris;
    CiudadPartida asuncion;
    CiudadDestino montevideo;
    CiudadDestino roma;
    CiudadDestino losAngeles;
    Fecha fechaSalida;
    Fecha fechaSalida2;
    Hora horaSalida2;
    Hora horaSalida3;
    Vuelo vueloParisMontevideo;
    Busqueda busquedaUno;
    Busqueda busquedaDos;
    Busqueda busquedaTres;
    
    
    FechaFlexible busquedaFecha;
    Hora busquedaHora;
    CiudadPartida busquedaCiudadPartida;
    CiudadDestino busquedaCiudadDestino;
    PrecioMaximoAsiento precioMaximo;
    PrecioMinimoAsiento precioMinimo;
    ClaseAsientoVuelo busquedaClase;
    ClaseAsientoVuelo claseEjecutivo;
    
    public BusquedaTest() {
    }
    
    @Before
    public void setUp() {
        try {
            PrecioAsiento sale125 = new PrecioAsiento(125.50);
            PrecioAsiento sale250 = new PrecioAsiento(250.50);
            PrecioAsiento sale500 = new PrecioAsiento(500);
            ClaseAsientoVuelo claseTurista = new ClaseAsientoVuelo(ClasesAsientoVuelo.TURISTA);
            claseEjecutivo = new ClaseAsientoVuelo(ClasesAsientoVuelo.EJECUTIVO);
            ClaseAsientoVuelo primeraClase = new ClaseAsientoVuelo(ClasesAsientoVuelo.PRIMERA_CLASE);
            UbicacionAsiento ubVentana = new UbicacionAsiento(UbicacionAsientoVuelo.VENTANA);
            UbicacionAsiento ubPasillo = new UbicacionAsiento(UbicacionAsientoVuelo.PASILLO);
            
            
            losAngeles = new CiudadDestino("LA");
            buenosAires = new CiudadPartida("BA");
            
            fechaSalida = new FechaFlexible("2018/11/01");
            
                        
            asuncion = new CiudadPartida("ASU");
            paris = new CiudadPartida("PAR");
            montevideo = new CiudadDestino("MON");
            roma = new CiudadDestino("ROM");
            fechaSalida2 = new FechaFlexible("2017/12/03");
            horaSalida2 = new Hora("18:30");
            CodigoAsiento codigoVueloDos1 = new CodigoAsiento("LV2O","15");
            CodigoAsiento codigoVueloDos2 = new CodigoAsiento("LV2O","16");
            CodigoAsiento codigoVueloDos3 = new CodigoAsiento("LV2O","17");
            asientoEjecutivoPasillo500 = new DatosAsientoLanchita(codigoVueloDos1, sale500, claseEjecutivo, ubPasillo);
            asientoPrimeraCLaseVentana125 = new DatosAsientoLanchita(codigoVueloDos1, sale125, primeraClase, ubVentana);
            asientoTuristaVentana250 = new DatosAsientoLanchita(codigoVueloDos1, sale250, claseTurista, ubVentana);
            
            vueloParisMontevideo = new Vuelo(paris, montevideo, horaSalida2, fechaSalida2);
            vueloParisMontevideo.agregarAsiento(asientoEjecutivoPasillo500);
            vueloParisMontevideo.agregarAsiento(asientoPrimeraCLaseVentana125);
            vueloParisMontevideo.agregarAsiento(asientoTuristaVentana250);
            
            
            
            busquedaFecha = new FechaFlexible("2017/05/12");
            busquedaHora = new Hora("13:30");
            busquedaCiudadPartida = new CiudadPartida("ROM");
            busquedaCiudadDestino = new CiudadDestino("MON");
            precioMaximo = new PrecioMaximoAsiento(500);
            precioMinimo = new PrecioMinimoAsiento(150);
            busquedaClase = new ClaseAsientoVuelo(ClasesAsientoVuelo.TURISTA);
            
            
            busquedaUno = new Busqueda(paris,montevideo,fechaSalida2,claseEjecutivo);
            busquedaDos = new Busqueda(paris,montevideo,fechaSalida2,claseEjecutivo,primeraClase);
            /*busquedaDos = new Busqueda(new CiudadPartida("ROM"), new CiudadDestino("MON"),new FechaFlexible("2017/05/12"));
            busquedaTres = new Busqueda(new CiudadPartida("ROM"), new CiudadDestino("MON"),new FechaFlexible("2017/05/12"));*/
        } catch (FormatoFechaIncorrectoException | FechaNoValidaException | FormatoHoraIncorrectoException | HoraInvalidaException | PrecioNegativoException | ParametrosInsuficienteException ex) {
            Assert.assertEquals(true, false);
        }
    }

    
    @Test
    public void creaBusquedaExitosamente() {
        try {
            Busqueda busqueda = new Busqueda(busquedaFecha,busquedaHora,busquedaCiudadPartida
                    ,busquedaCiudadDestino,precioMaximo,precioMinimo,busquedaClase);
        } catch (ParametrosInsuficienteException ex) {
            Assert.assertEquals(true, false);
        }
    }
    
    @Test
    public void creaBusquedaExitosamenteConTres() throws ParametrosInsuficienteException {
        Busqueda busqueda = new Busqueda(busquedaCiudadDestino,busquedaCiudadPartida,fechaSalida);
    }
    @Test
    public void creaBusquedaExitosamenteSinDestino() {
        Busqueda busqueda = new Busqueda(busquedaCiudadPartida,fechaSalida);
    }
    
    
    @Test(expected = ParametrosInsuficienteException.class)
    public void fallaCreacionBusquedaPorFaltaCiudadDestino() throws ParametrosInsuficienteException {
            Busqueda busqueda = new Busqueda(busquedaFecha,busquedaHora,busquedaCiudadPartida
                    ,precioMaximo,precioMinimo,busquedaClase);

    }
    
    @Test(expected = ParametrosInsuficienteException.class)
    public void fallaCreacionBusquedaPorFaltaCiudadPartida() throws ParametrosInsuficienteException {
        Busqueda busqueda = new Busqueda(busquedaFecha,busquedaHora,busquedaCiudadDestino
                ,precioMaximo,precioMinimo,busquedaClase);
        
    }
    
    @Test(expected = ParametrosInsuficienteException.class)
    public void fallaCreacionBusquedaPorFaltaFecha() throws ParametrosInsuficienteException {
            Busqueda busqueda = new Busqueda(busquedaHora,busquedaCiudadDestino
                    ,busquedaCiudadPartida,precioMaximo,precioMinimo,busquedaClase);
    }
    @Test
    public void filtraAsientosDevuelveUnoSolo() throws ParametrosInsuficienteException{
        busquedaUno = new Busqueda(paris,montevideo,fechaSalida2,claseEjecutivo);
        List<AsientoGeneralVuelo> resultado = busquedaUno.asientosCumplenRequisitoBusqueda(vueloParisMontevideo.getDatosAsientoVuelo());
        List<DatosAsientoGeneral> asientos = resultado.stream()
                .map(asiento -> asiento.getDatosAsiento()).collect(Collectors.toList());
        MatcherAssert.assertThat(asientos,Matchers.hasItem(asientoEjecutivoPasillo500));
        
    }
    @Test
    public void filtraAsientosDevuelveDosAsientos(){
        List<AsientoGeneralVuelo> resultado = busquedaDos.asientosCumplenRequisitoBusqueda(vueloParisMontevideo.getDatosAsientoVuelo());
        List<DatosAsientoGeneral> asientos = resultado.stream()
                .map(asiento -> asiento.getDatosAsiento()).collect(Collectors.toList());
        MatcherAssert.assertThat(asientos,Matchers.hasItems(asientoEjecutivoPasillo500,asientoPrimeraCLaseVentana125));
        
    }
}
