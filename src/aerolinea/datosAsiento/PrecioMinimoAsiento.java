package aerolinea.datosAsiento;

import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.vuelo.AsientoGeneral;

public class PrecioMinimoAsiento extends PrecioAsiento{

    public PrecioMinimoAsiento(double precioAsiento) throws PrecioNegativoException {
        super(precioAsiento);
    }
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoGeneral asiento) {
        return asiento.getDatosAsiento().getPrecio() >= precioAsiento;
    }
}
