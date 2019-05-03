
package aerolinea.datosAsiento.excepcionesAsiento;

public class AsientoNoReservadoException extends RuntimeException {

    public AsientoNoReservadoException(String message) {
        super(message);
    }
}
