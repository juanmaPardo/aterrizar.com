package aerolinea.datosAsiento;

import fecha.Fecha;
import horarios.Hora;


public class DatosAsientoGeneral {
    protected PrecioAsiento precio;
    protected ClaseAsientoVuelo clase;
    protected UbicacionAsientoVuelo ubicacionAsiento;
    protected EstadoAsientoVuelo estado;

    public DatosAsientoGeneral(PrecioAsiento precio, ClaseAsientoVuelo clase, UbicacionAsientoVuelo ubicacionAsiento, EstadoAsientoVuelo estado) {
        this.precio = precio;
        this.clase = clase;
        this.ubicacionAsiento = ubicacionAsiento;
        this.estado = estado;
    }


    public PrecioAsiento getPrecio() {
        return precio;
    }

    public ClaseAsientoVuelo getClase() {
        return clase;
    }

    public UbicacionAsientoVuelo getUbicacionAsiento() {
        return ubicacionAsiento;
    }

    public EstadoAsientoVuelo getEstado() {
        return estado;
    }    
    
}
