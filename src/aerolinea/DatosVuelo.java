package aerolinea;

import aerolinea.datosAsiento.ClaseAsiento;
import aerolinea.datosAsiento.EstadoAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;

public class DatosVuelo {
    String codigoAsiento;
    double precio;
    ClaseAsiento clase;
    UbicacionAsiento ubicacion;
    EstadoAsiento estado;

    public DatosVuelo(String codigoAsiento, double precio, ClaseAsiento clase, UbicacionAsiento ubicacion, EstadoAsiento estado) {
        this.codigoAsiento = codigoAsiento;
        this.precio = precio;
        this.clase = clase;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }
    
    
}
