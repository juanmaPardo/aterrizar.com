package aerolinea.vuelo;

import aerolinea.busqueda.FiltroBusqueda;


public class CiudadPartida extends Ciudad implements FiltroBusqueda {

    public CiudadPartida(String origen) {
        super(origen);
    }
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoGeneralVuelo asiento) {
        return asiento.getOrigen().getCiudad().equals(ciudad);
    }
    
}
