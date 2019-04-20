package aerolinea.datosAsiento.excepcionesAsiento;


public class PrecioNegativoException extends InstantiationException{

    public PrecioNegativoException(String mensaje) {
        super(mensaje);
    }
    
}
