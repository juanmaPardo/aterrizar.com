package aerolinea.busqueda;

import aerolinea.vuelo.AsientoGeneralVuelo;
import aerolinea.vuelo.AsientoVueloLanchita;

public interface FiltroBusqueda {
    
    public boolean asientoVueloCumpleParametro(AsientoGeneralVuelo asiento);
}
