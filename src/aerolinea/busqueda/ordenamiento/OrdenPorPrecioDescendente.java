package aerolinea.busqueda.ordenamiento;

import aerolinea.vuelo.AsientoGeneral;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ComparadorPorPrecioDescendiente implements Comparator<AsientoGeneral>{

    @Override
    public int compare(AsientoGeneral o1, AsientoGeneral o2) {
        return Double.compare(o2.getDatosAsiento().getPrecio().getPrecioAsiento(), o1.getDatosAsiento().getPrecio().getPrecioAsiento());
    }

}

public class OrdenPorPrecioDescendente implements OrdenamientoAsientos {

    @Override
    public void ordenar(List<AsientoGeneral> lista) {
        Collections.sort(lista,new ComparadorPorPrecioDescendiente());
    }
    
}
