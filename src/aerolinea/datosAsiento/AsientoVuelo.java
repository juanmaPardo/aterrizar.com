package aerolinea.datosAsiento;

import aerolinea.datosAsiento.ClaseAsiento;
import aerolinea.datosAsiento.EstadoAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;

public class AsientoVuelo {
    String codigoAsiento;
    double precio;
    ClaseAsiento clase;
    UbicacionAsiento ubicacion;
    EstadoAsiento estado;

    public AsientoVuelo(String codigoAsiento, double precio, ClaseAsiento clase, UbicacionAsiento ubicacion, EstadoAsiento estado) {
        this.codigoAsiento = codigoAsiento;
        this.precio = precio;
        this.clase = clase;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }
    
    
}
