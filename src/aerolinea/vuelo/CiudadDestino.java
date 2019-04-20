package aerolinea.vuelo;

import aerolinea.busqueda.FiltroBusqueda;


public class CiudadDestino extends Ciudad implements FiltroBusqueda{

    public CiudadDestino(String destino) {
        super(destino);
    }

    @Override
    public boolean asientoVueloCumpleParametro(AsientoVuelo asiento) {
        return asiento.getOrigen() == ciudad;
    }
    
}
