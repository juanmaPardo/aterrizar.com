package aerolinea.datosAsiento;

import aerolinea.datosAsiento.ClaseAsiento;
import aerolinea.datosAsiento.EstadoAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;

public class DatosAsiento {
    CodigoAsiento codigoAsiento;
    PrecioAsiento precio;
    ClaseAsiento clase;
    UbicacionAsiento ubicacion;
    EstadoAsiento estado;

    public DatosAsiento(CodigoAsiento codigoAsiento, PrecioAsiento precio, ClaseAsiento clase, UbicacionAsiento ubicacion, EstadoAsiento estado) {
        this.codigoAsiento = codigoAsiento;
        this.precio = precio;
        this.clase = clase;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public String getCodigoAsiento() {
        return codigoAsiento.getCodigoAsiento();
    }

    public double getPrecio() {
        return precio.getPrecioAsiento();
    }

    public ClaseAsiento getClaseAsiento() {
        return clase;
    }

    public UbicacionAsiento getUbicacion() {
        return ubicacion;
    }

    public EstadoAsiento getEstado() {
        return estado;
    }
    
    
}
