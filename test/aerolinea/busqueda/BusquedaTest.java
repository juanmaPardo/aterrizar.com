package aerolinea.busqueda;

import aerolinea.AerolineaLanchita;
import aerolinea.AerolineaOceanic;
import aerolinea.busqueda.ExcepcionesBusqueda.ParametrosInsuficienteException;
import aerolinea.datosAsiento.ClaseAsientoVuelo;
import aerolinea.datosAsiento.ClasesAsientoVuelo;
import aerolinea.datosAsiento.CodigoAsiento;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import aerolinea.datosAsiento.DatosAsientoOceanic;
import aerolinea.datosAsiento.PrecioAsiento;
import aerolinea.datosAsiento.PrecioMaximoAsiento;
import aerolinea.datosAsiento.PrecioMinimoAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;
import aerolinea.datosAsiento.UbicacionAsientoVuelo;
import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.vuelo.CiudadDestino;
import aerolinea.vuelo.CiudadPartida;
import aerolinea.vuelo.Vuelo;
import fecha.Fecha;
import fecha.FechaFlexible;
import fecha.FechaFormatoLatinoamericano;
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


public class BusquedaTest {
    
    Fecha busquedaFecha;
    CiudadPartida busquedaCiudadPartida;
    CiudadDestino busquedaCiudadDestino;
    Hora busquedaHora;
    PrecioMaximoAsiento precioMaximo;
    PrecioMinimoAsiento precioMinimo;
    ClaseAsientoVuelo busquedaClase;
        DatosAsientoLanchita asiento;
    DatosAsientoLanchita asiento1;
    DatosAsientoLanchita asiento2;
    DatosAsientoLanchita asiento3;
    DatosAsientoLanchita asiento4;
    DatosAsientoLanchita asiento5;
    DatosAsientoLanchita asiento6;
    DatosAsientoLanchita asiento7;
    DatosAsientoLanchita asiento8;
    DatosAsientoLanchita asiento9;
    DatosAsientoLanchita asiento10;
    DatosAsientoOceanic asientoOc1;
    DatosAsientoOceanic asientoOc2;
    CiudadPartida buenosAires;
    CiudadPartida paris;
    CiudadPartida asuncion;
    CiudadDestino montevideo;
    CiudadDestino roma;
    CiudadDestino losAngeles;
    Fecha fechaSalida;
    Fecha fechaSalida2;
    Fecha fechaSalida3;
    FechaFormatoLatinoamericano fechaSalida4;
    Hora horaSalida2;
    Hora horaSalida3;
    Hora horaSalida4;
    Hora horaSalida;
    Vuelo vuelo;
    Vuelo vueloDos;
    Vuelo vueloTres;
    Vuelo vueloOceanicUno;
    AerolineaLanchita aerolineaUno;
    AerolineaLanchita aeroLineaDos;
    AerolineaOceanic aerolineaOc;
    public BusquedaTest() {
    }
    
    @Before
    public void setUp() {
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
            busquedaFecha = new FechaFlexible("2017/05/12");
            busquedaHora = new Hora("13:30");
            busquedaCiudadPartida = new CiudadPartida("ROM");
            busquedaCiudadDestino = new CiudadDestino("MON");
            precioMaximo = new PrecioMaximoAsiento(500);
            precioMinimo = new PrecioMinimoAsiento(150);
            busquedaClase = new ClaseAsientoVuelo(ClasesAsientoVuelo.TURISTA);
        } catch (FormatoFechaIncorrectoException | FechaNoValidaException | FormatoHoraIncorrectoException | HoraInvalidaException | PrecioNegativoException ex) {
            Assert.assertEquals(true, false);
        }
    }

    
    @Test
    public void creaBusquedaExitosamente() {
        try {
            Busqueda busqueda = new Busqueda(busquedaFecha,busquedaHora,busquedaCiudadPartida
                    ,busquedaCiudadDestino,precioMaximo,precioMinimo,busquedaClase);
        } catch (ParametrosInsuficienteException ex) {
            Logger.getLogger(BusquedaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
}
