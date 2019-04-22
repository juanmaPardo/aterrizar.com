package aerolinea.datosAsiento;

import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.vuelo.AsientoGeneral;
import aerolinea.vuelo.AsientoGeneralVuelo;
import aerolinea.vuelo.AsientoVueloLanchita;

public class PrecioMinimoAsiento extends PrecioAsiento{

    public PrecioMinimoAsiento(double precioAsiento) throws PrecioNegativoException {
        super(precioAsiento);
    }
    
    @Override
    public boolean asientoVueloCumpleParametro(AsientoGeneral asiento) {
        return asiento.getDatosAsiento().getPrecio().getPrecioAsiento() >= precioAsiento;
    }
}
