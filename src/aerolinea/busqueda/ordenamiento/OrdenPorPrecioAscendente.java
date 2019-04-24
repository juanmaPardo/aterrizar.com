package aerolinea.busqueda.ordenamiento;

import aerolinea.vuelo.AsientoGeneral;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ComparadorPorPrecioAscendente implements Comparator<AsientoGeneral>{

    @Override
    public int compare(AsientoGeneral o1, AsientoGeneral o2) {
        return Double.compare(o1.getDatosAsiento().getPrecio().getPrecioAsiento(), o2.getDatosAsiento().getPrecio().getPrecioAsiento());
    }

}

public class OrdenPorPrecioAscendente implements OrdenamientoAsientos {

    @Override
    public void ordenar(List<AsientoGeneral> lista) {
        Collections.sort(lista,new ComparadorPorPrecioAscendente());
    }
    
}
