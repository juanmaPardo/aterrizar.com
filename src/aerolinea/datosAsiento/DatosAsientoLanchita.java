package aerolinea.datosAsiento;

import aerolinea.datosAsiento.ClaseAsientoVuelo;
import aerolinea.datosAsiento.EstadoAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;

public class DatosAsientoLanchita extends DatosAsientoGeneral{

    public DatosAsientoLanchita(CodigoAsiento codigoAsiento, PrecioAsiento precio, ClaseAsientoVuelo clase, UbicacionAsiento ubicacionAsiento) {
        super(precio, clase, ubicacionAsiento,codigoAsiento);
    }

    
   /* public void reservarAsiento(){
        
    }*/
    
    
}
