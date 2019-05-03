package aerolinea.datosAsiento;

import fecha.Fecha;
import horarios.Hora;


public class DatosAsientoGeneral {
    protected PrecioAsiento precio;
    protected ClaseAsientoVuelo clase;
    protected UbicacionAsiento ubicacionAsiento;
    protected EstadoAsiento estado;
    protected CodigoAsiento codigo;

    public DatosAsientoGeneral(PrecioAsiento precio, ClaseAsientoVuelo clase, UbicacionAsiento ubicacionAsiento,CodigoAsiento codigo) {
        this.precio = precio;
        this.clase = clase;
        this.ubicacionAsiento = ubicacionAsiento;
        this.estado = new EstadoAsiento();
        this.codigo = codigo;
    }

    public ClaseAsientoVuelo getClase() {
        return clase;
    }

    public CodigoAsiento getCodigoAsiento() {
        return codigo;
    }


    public PrecioAsiento getPrecio() {
        return precio;
    }

    public ClaseAsientoVuelo getClaseAsiento() {
        return clase;
    }

    public UbicacionAsiento getUbicacionAsiento() {
        return ubicacionAsiento;
    }

    public EstadoAsiento getEstado() {
        return estado;
    }

    
}
