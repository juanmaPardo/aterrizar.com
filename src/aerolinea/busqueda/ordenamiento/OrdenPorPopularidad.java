package aerolinea.busqueda.ordenamiento;

import aerolinea.vuelo.AsientoGeneral;
import java.util.List;


public class OrdenPorPopularidad implements OrdenamientoAsientos {

    @Override
    public List<AsientoGeneral> ordenar(List<AsientoGeneral> lista) {
        lista.sort();
    }
    
}
