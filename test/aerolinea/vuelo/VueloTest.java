package aerolinea.vuelo;

import aerolinea.datosAsiento.ClaseAsiento;
import aerolinea.datosAsiento.ClasesAsientoVuelo;
import aerolinea.datosAsiento.CodigoAsiento;
import aerolinea.datosAsiento.DatosAsiento;
import aerolinea.datosAsiento.EstadoAsiento;
import aerolinea.datosAsiento.EstadoAsientoVuelo;
import aerolinea.datosAsiento.PrecioAsiento;
import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.datosAsiento.UbicacionAsiento;
import aerolinea.datosAsiento.UbicacionAsientoVuelo;
import fecha.Fecha;
import fecha.FechaFlexible;
import java.util.LinkedList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VueloTest {
    LinkedList<DatosAsiento> asientos;
    DatosAsiento asiento;
    DatosAsiento asiento1;
    DatosAsiento asiento2;
    DatosAsiento asiento3;
    DatosAsiento asiento4;
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
            ClaseAsiento clase = new ClaseAsiento(ClasesAsientoVuelo.TURISTA);
            ClaseAsiento clase1 = new ClaseAsiento(ClasesAsientoVuelo.EJECUTIVO);
            ClaseAsiento clase2 = new ClaseAsiento(ClasesAsientoVuelo.PRIMERA_CLASE);
            UbicacionAsiento ubicacion = new UbicacionAsiento(UbicacionAsientoVuelo.VENTANA);
            UbicacionAsiento ubicacion2 = new UbicacionAsiento(UbicacionAsientoVuelo.PASILLO);
            
            
            asiento = new DatosAsiento(codigo, precio1, clase, ubicacion);
            asiento1 = new DatosAsiento(codigo1, precio1, clase, ubicacion);
            asiento2 = new DatosAsiento(codigo2, precio2, clase1, ubicacion2);
            asiento3 = new DatosAsiento(codigo3, precio2, clase1, ubicacion2);
            asiento4 = new DatosAsiento(codigo4, precio3, clase2, ubicacion);
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
            
            vuelo = new Vuelo(orig, dest,fechaSalida,fechaaLlegada);
          
        } catch (PrecioNegativoException ex) {
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
        LinkedList<AsientoVuelo> resultado = vuelo.getDatosAsientoVuelo();
        resultado.forEach(asiento ->{
            Assert.assertEquals(asiento.getDestino(), "LA");
            Assert.assertEquals(asiento.getOrigen(), "BA");
            assertTrue(asientos.contains(asiento.getDatosAsiento()));
            
        });
        //assertThat()
    }
}
