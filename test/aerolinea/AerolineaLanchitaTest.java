package aerolinea;

import aerolinea.datosAsiento.ClaseAsientoVuelo;
import aerolinea.datosAsiento.ClasesAsientoVuelo;
import aerolinea.datosAsiento.CodigoAsiento;
import aerolinea.datosAsiento.DatosAsientoGeneral;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import aerolinea.datosAsiento.DatosAsientoOceanic;
import aerolinea.datosAsiento.PrecioAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;
import aerolinea.datosAsiento.UbicacionAsientoVuelo;
import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.excepcionesAerolinea.PorcentajeIncorrectoException;
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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AerolineaLanchitaTest {
    LinkedList<DatosAsientoGeneral> asientos;
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
    public AerolineaLanchitaTest() {
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
            asientos = new LinkedList<>();
            asientos.add(asiento);
            asientos.add(asiento1);
            asientos.add(asiento2);
            asientos.add(asiento3);
            asientos.add(asiento4);
            
            losAngeles = new CiudadDestino("LA");
            buenosAires = new CiudadPartida("BA");
            
            fechaSalida = new FechaFlexible("2018/11/01");
            
            
            vuelo = new Vuelo(buenosAires, losAngeles, horaSalida, fechaSalida);
            vuelo.agregarAsiento(asiento);
            vuelo.agregarAsiento(asiento1);
            vuelo.agregarAsiento(asiento2);
            vuelo.agregarAsiento(asiento3);
            vuelo.agregarAsiento(asiento4);
            
            asuncion = new CiudadPartida("ASU");
            paris = new CiudadPartida("PAR");
            montevideo = new CiudadDestino("MON");
            roma = new CiudadDestino("ROM");
            fechaSalida2 = new FechaFlexible("2017/12/03");
            horaSalida2 = new Hora("18:30");
            CodigoAsiento codigoVueloDos1 = new CodigoAsiento("LV2O","15");
            CodigoAsiento codigoVueloDos2 = new CodigoAsiento("LV2O","16");
            CodigoAsiento codigoVueloDos3 = new CodigoAsiento("LV2O","17");
            asiento5 = new DatosAsientoLanchita(codigoVueloDos1, precio3, clase, ubicacion2);
            asiento6 = new DatosAsientoLanchita(codigoVueloDos1, precio1, clase1, ubicacion);
            asiento7 = new DatosAsientoLanchita(codigoVueloDos1, precio2, clase2, ubicacion);
            
            vueloDos = new Vuelo(paris, montevideo, horaSalida2, fechaSalida2);
            vueloDos.agregarAsiento(asiento5);
            vueloDos.agregarAsiento(asiento6);
            vueloDos.agregarAsiento(asiento7);
            
            CodigoAsiento codigoVueloTres1 = new CodigoAsiento("X70","2");
            CodigoAsiento codigoVueloTres2 = new CodigoAsiento("X70","3");
            CodigoAsiento codigoVueloTres3 = new CodigoAsiento("X70","4");
            fechaSalida3 = new FechaFlexible("2016/04/03");
            horaSalida3 = new Hora("15:30");
            asiento8 = new DatosAsientoLanchita(codigoVueloTres1, precio3, clase, ubicacion2);
            asiento9 = new DatosAsientoLanchita(codigoVueloTres2, precio2, clase2, ubicacion);
            asiento10 = new DatosAsientoLanchita(codigoVueloTres3, precio1, clase, ubicacion2);
            vueloTres = new Vuelo(asuncion, roma, horaSalida3, fechaSalida3);
            vueloTres.agregarAsiento(asiento8);
            vueloTres.agregarAsiento(asiento9);
            vueloTres.agregarAsiento(asiento10);
            
            fechaSalida4 = new FechaFormatoLatinoamericano("15/05/2016");
            horaSalida4 = new Hora("15:45");
            String codigoVueloOceanic = "v3540"; 
            asientoOc1 = new DatosAsientoOceanic(precio3, clase, ubicacion2, horaSalida4, fechaSalida4, 15, codigoVueloOceanic);
            
            vueloOceanicUno = new Vuelo(paris, roma, horaSalida4, fechaSalida4);
            vueloOceanicUno.agregarAsiento(asientoOc1);
            
            aerolineaUno = new AerolineaLanchita();
            aeroLineaDos = new AerolineaLanchita();
            aerolineaOc = new AerolineaOceanic();
            
        
        } catch (PrecioNegativoException ex) {
            Assert.assertEquals(true, false);
        } catch (FormatoFechaIncorrectoException | FechaNoValidaException | FormatoHoraIncorrectoException | HoraInvalidaException ex) {
            Assert.assertEquals(true, false);
        } catch (PorcentajeIncorrectoException ex) {
            Logger.getLogger(AerolineaLanchitaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void seAgregarVuelosAerolineaUno(){
        aerolineaUno.agregarVuelo(vuelo);
    }
    
    @Test
    public void seAgregarVuelosAerolineaDos(){
        aerolineaUno.agregarVuelo(vueloDos);
        aerolineaUno.agregarVuelo(vueloTres);
    }
    
    @Test
    public void seAgregarVuelosAerolineaOceanic(){
        aerolineaOc.agregarVuelo(vueloOceanicUno);
    }
    
            
    
}
