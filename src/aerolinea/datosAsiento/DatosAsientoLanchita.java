package aerolinea.datosAsiento;

import aerolinea.datosAsiento.ClaseAsientoVuelo;
import aerolinea.datosAsiento.EstadoAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;

public class DatosAsientoLanchita extends DatosAsientoGeneral{
    private CodigoAsiento codigoAsiento;

    public DatosAsientoLanchita(CodigoAsiento codigoAsiento, PrecioAsiento precio, ClaseAsientoVuelo clase, UbicacionAsiento ubicacionAsiento) {
        super(precio, clase, ubicacionAsiento);
        this.codigoAsiento = codigoAsiento;
    }

    
   /* public void reservarAsiento(){
        
    }*/

    public String getCodigoAsiento() {
        return codigoAsiento.getCodigoAsiento();
    }
    
    
}
