package aerolinea.vuelo;

import aerolinea.busqueda.FiltroBusqueda;


public class CiudadDestino extends Ciudad implements FiltroBusqueda{

    public CiudadDestino(String origen) {
        super(origen);
    }

    @Override
    public boolean asientoVueloCumpleParametro(AsientoVuelo asiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
