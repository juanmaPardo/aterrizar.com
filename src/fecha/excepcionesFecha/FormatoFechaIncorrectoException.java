package fecha.excepcionesFecha;


public class FormatoFechaIncorrectoException extends InstantiationException{

    public FormatoFechaIncorrectoException() {
    }

    public FormatoFechaIncorrectoException(String mensaje) {
        super(mensaje);
    }
    
}
