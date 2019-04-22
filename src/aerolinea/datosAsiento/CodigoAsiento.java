//package aerolinea.datosAsiento;

import aerolinea.datosAsiento.excepcionesAsiento.CodigoAsientoException;
import aerolinea.vuelo.AsientoVueloLanchita;
import aerolinea.busqueda.FiltroBusqueda;
import aerolinea.datosAsiento.DatosAsientoLanchita;
import aerolinea.vuelo.AsientoGeneral;
import aerolinea.vuelo.AsientoGeneralVuelo;

public class CodigoAsiento implements FiltroBusqueda {
    private String codigoAsiento;
    private String numeroVuelo;
    private String numeroAsiento;

    public CodigoAsiento(String codigoAsiento) throws CodigoAsientoException {
        if(!codigoAsiento.contains("-")){
            throw new CodigoAsientoException("El formato enviado es incorrecto");
        }
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
    public boolean asientoVueloCumpleParametro(AsientoGeneral asiento) {
        DatosAsientoLanchita datosAsientoLanchita =(DatosAsientoLanchita)asiento.getDatosAsiento();
        return datosAsientoLanchita.getCodigoAsiento() == codigoAsiento;
    }
}
