package aerolinea.vuelo;

import aerolinea.busqueda.FiltroBusqueda;


public class CiudadDestino extends Ciudad implements FiltroBusqueda{

    public CiudadDestino(String destino) {
        super(destino);
    }

    @Override
    public boolean asientoVueloCumpleParametro(AsientoGeneralVuelo asiento) {
        return asiento.getDestino().getCiudad().equals(ciudad);
    }
    
}
