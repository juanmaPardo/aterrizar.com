package aerolinea.datosAsiento;

import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.vuelo.AsientoGeneralVuelo;
import aerolinea.vuelo.AsientoVueloLanchita;


public class PrecioMaximoAsiento extends PrecioAsiento {

    public PrecioMaximoAsiento(double precioAsiento) throws PrecioNegativoException {
        super(precioAsiento);
    }
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoGeneralVuelo asiento) {
        return asiento.getDatosAsiento().getPrecio().getPrecioAsiento() <= precioAsiento;
    }
}
