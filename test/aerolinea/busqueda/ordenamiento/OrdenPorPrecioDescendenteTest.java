package aerolinea.busqueda.ordenamiento;

import aerolinea.datosAsiento.DatosAsientoGeneral;
import aerolinea.datosAsiento.PrecioAsiento;
import aerolinea.vuelo.AsientoGeneral;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;


public class OrdenPorPrecioDescendenteTest {
    
    public OrdenPorPrecioDescendenteTest() {
    }
    
    @Before
    public void setUp() {
    }

    
    @Test
    public void testOrdenar() {
        AsientoGeneral as1 = Mockito.mock(AsientoGeneral.class);
        AsientoGeneral as2 = Mockito.mock(AsientoGeneral.class);
        AsientoGeneral as3 = Mockito.mock(AsientoGeneral.class);
        DatosAsientoGeneral datos1 = Mockito.mock(DatosAsientoGeneral.class);
        DatosAsientoGeneral datos2 = Mockito.mock(DatosAsientoGeneral.class);
        DatosAsientoGeneral datos3 = Mockito.mock(DatosAsientoGeneral.class);
        PrecioAsiento precio1 = Mockito.mock(PrecioAsiento.class);
        PrecioAsiento precio2 = Mockito.mock(PrecioAsiento.class);
        PrecioAsiento precio3 = Mockito.mock(PrecioAsiento.class);
        
        
        Mockito.when(datos1.getPrecio()).thenReturn(precio1);
        Mockito.when(datos2.getPrecio()).thenReturn(precio2);
        Mockito.when(datos3.getPrecio()).thenReturn(precio3);
        
        Mockito.when(precio1.getPrecioAsiento()).thenReturn(125.12);
        Mockito.when(precio2.getPrecioAsiento()).thenReturn(145.12);
        Mockito.when(precio3.getPrecioAsiento()).thenReturn(135.12);
        
        Mockito.when(as1.getDatosAsiento()).thenReturn(datos1);
        Mockito.when(as2.getDatosAsiento()).thenReturn(datos2);
        Mockito.when(as3.getDatosAsiento()).thenReturn(datos3);
        
        
        List<AsientoGeneral> lista = Arrays.asList(as2,as1,as3);
        OrdenPorPrecioDescendente ordenada = new OrdenPorPrecioDescendente();
        ordenada.ordenar(lista);
        MatcherAssert.assertThat(lista,IsIterableContainingInOrder.contains(as2,as3,as1));
    }
    
}
