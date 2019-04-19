package aerolinea.vuelo;

import aerolinea.busqueda.FiltroBusqueda;


public class CiudadPartida extends Ciudad implements FiltroBusqueda {

    public CiudadPartida(String origen) {
        super(origen);
    }
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoVuelo asiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
