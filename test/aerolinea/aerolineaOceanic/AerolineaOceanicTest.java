
package aerolinea.aerolineaOceanic;

import aerolinea.AerolineaOceanic;
import aerolinea.busqueda.Busqueda;
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
import aerolinea.datosAsiento.excepcionesAsiento.CodigoAsientoException;
import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.excepcionesAerolinea.PorcentajeIncorrectoException;
import aerolinea.vuelo.AsientoGeneral;
import aerolinea.vuelo.AsientoGeneralVuelo;
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
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AerolineaOceanicTest {
    
    DatosAsientoOceanic asiento5;
    DatosAsientoOceanic asiento6;
    DatosAsientoOceanic asiento7;
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
    Vuelo vueloDos;
    Busqueda busquedaUno;
    Busqueda busqueda2;
    Busqueda busquedaDos;
    Busqueda busquedaTres;
    
    
    FechaFlexible busquedaFecha;
    Hora busquedaHora;
    CiudadPartida busquedaCiudadPartida;
    CiudadDestino busquedaCiudadDestino;
    PrecioMaximoAsiento precioMaximo;
    PrecioMinimoAsiento precioMinimo;
    ClaseAsientoVuelo busquedaClase;
    
    public AerolineaOceanicTest() {
    }
    
    @Before
    public void setUp() throws CodigoAsientoException {
        try {
            PrecioAsiento precio1 = new PrecioAsiento(125.50);
            PrecioAsiento precio2 = new PrecioAsiento(250.50);
            PrecioAsiento precio3 = new PrecioAsiento(500);
            ClaseAsientoVuelo clase = new ClaseAsientoVuelo(ClasesAsientoVuelo.TURISTA);
            ClaseAsientoVuelo clase1 = new ClaseAsientoVuelo(ClasesAsientoVuelo.EJECUTIVO);
            ClaseAsientoVuelo clase2 = new ClaseAsientoVuelo(ClasesAsientoVuelo.PRIMERA_CLASE);
            UbicacionAsiento ubicacion = new UbicacionAsiento(UbicacionAsientoVuelo.VENTANA);
            UbicacionAsiento ubicacion2 = new UbicacionAsiento(UbicacionAsientoVuelo.PASILLO);
            
                        
            asuncion = new CiudadPartida("ASU");
            paris = new CiudadPartida("PAR");
            montevideo = new CiudadDestino("MON");
            roma = new CiudadDestino("ROM");
            fechaSalida2 = new FechaFlexible("2017/12/03");
            horaSalida2 = new Hora("18:30");
            CodigoAsiento codigoVueloDos1 = new CodigoAsiento("LV2O","15");
            CodigoAsiento codigoVueloDos2 = new CodigoAsiento("LV2O","16");
            CodigoAsiento codigoVueloDos3 = new CodigoAsiento("LV2O","17");
            FechaFormatoLatinoamericano fec = new FechaFormatoLatinoamericano("15/12/2017");
            asiento5 = new DatosAsientoOceanic(precio3, clase, ubicacion2, horaSalida2, fec, 12, "LA");
            asiento6 = new DatosAsientoOceanic(precio3, clase, ubicacion2, horaSalida2, fec, 13, "lA");
            
            
            vueloDos = new Vuelo(paris, montevideo, horaSalida2, fechaSalida2);
            vueloDos.agregarAsiento(asiento5);
            vueloDos.agregarAsiento(asiento6);
            
            
            
            busquedaFecha = new FechaFlexible("2017/05/12");
            busquedaHora = new Hora("13:30");
            busquedaCiudadPartida = new CiudadPartida("ROM");
            busquedaCiudadDestino = new CiudadDestino("MON");
            precioMaximo = new PrecioMaximoAsiento(500);
            precioMinimo = new PrecioMinimoAsiento(150);
            busquedaClase = new ClaseAsientoVuelo(ClasesAsientoVuelo.TURISTA);
            
            
            busquedaUno = new Busqueda(paris,montevideo,fechaSalida2,clase1);
            busqueda2 = new Busqueda(paris,fechaSalida2);
            /*busquedaDos = new Busqueda(new CiudadPartida("ROM"), new CiudadDestino("MON"),new FechaFlexible("2017/05/12"));
            busquedaTres = new Busqueda(new CiudadPartida("ROM"), new CiudadDestino("MON"),new FechaFlexible("2017/05/12"));*/
        } catch (FormatoFechaIncorrectoException | FechaNoValidaException | FormatoHoraIncorrectoException | HoraInvalidaException | PrecioNegativoException | ParametrosInsuficienteException ex) {
            Assert.assertEquals(true, false);
        }
    }

    @Test
    public void seIngresaUnCodigoDeCiudadDeDosCaracteresYSeModifica(){
        try {
            AerolineaOceanic aerolineaO = new AerolineaOceanic();
            assertEquals("El codigo de ciudad no fue modificado","LR_" ,aerolineaO.modificarCodigoCiudad("LR"));
        } catch (PorcentajeIncorrectoException ex) {
            Assert.assertEquals(true, false);
        }
    }
    
    @Test
    public void seIngresaElCodigoDeCiudadLAYSeModifica(){
        try {
            AerolineaOceanic aerolineaO = new AerolineaOceanic();
            assertEquals("El codigo de ciudad no fue modificado","SLA" ,aerolineaO.modificarCodigoCiudad("LA"));
        } catch (PorcentajeIncorrectoException ex) {
            Assert.assertEquals(true, false);
        }
    }

    @Test
    public void seIngresaUnCodigoDeCiudadDeTresCaracteresYNoSeModifica(){
        try {
            AerolineaOceanic aerolineaO = new AerolineaOceanic();
            assertEquals("El codigo de ciudad no fue modificado","BUE" ,aerolineaO.modificarCodigoCiudad("BUE"));
        } catch (PorcentajeIncorrectoException ex) {
            Assert.assertEquals(true, false);
        }
    }
    
    @Test
    public void seAgregaUnVueloYExisteUnAsientoQueCumplaConLasCaracteristicas(){
        try {
            AerolineaOceanic aerolineaO = new AerolineaOceanic();
            aerolineaO.agregarVuelo(vueloDos);
            busqueda2.asientosCumplenRequisitoBusqueda(vueloDos.getDatosAsientoVuelo());
            assertEquals(asiento5,busqueda2.asientosCumplenRequisitoBusqueda(vueloDos.getDatosAsientoVuelo()));
        } catch (PorcentajeIncorrectoException ex) {
            Assert.assertEquals(true, false);
        }
        
    }
    
    
}
