package aerolinea.datosAsiento;

import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.vuelo.AsientoGeneral;


public class PrecioMaximoAsiento extends PrecioAsiento {

    public PrecioMaximoAsiento(double precioAsiento) throws PrecioNegativoException {
        super(precioAsiento);
    }
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoGeneral asiento) {
        return asiento.getDatosAsiento().getPrecio() <= precioAsiento;
    }
}
