package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVuelo;
import aerolinea.busqueda.FiltroBusqueda;

public class CodigoAsiento implements FiltroBusqueda {
    String codigoAsiento;
    String numeroVuelo;
    String numeroAsiento;

    public CodigoAsiento(String codigoAsiento) {
        this.codigoAsiento = codigoAsiento;
        this.numeroVuelo = codigoAsiento.split("-")[0];
        this.numeroAsiento = codigoAsiento.split("-")[1];
    }
    
    public CodigoAsiento(String numeroVuelo, String numeroAsiento){
        this.codigoAsiento = numeroVuelo + "-" + numeroAsiento;
        this.numeroVuelo = numeroVuelo;
        this.numeroAsiento = numeroAsiento;
    }

    public String getCodigoAsiento() {
        return codigoAsiento;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }
    

    @Override
    public boolean asientoVueloCumpleParametro(AsientoVuelo asiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
