package aerolinea.datosAsiento;

import aerolinea.datosAsiento.ClaseAsiento;
import aerolinea.datosAsiento.EstadoAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;

public class DatosAsiento {
    private CodigoAsiento codigoAsiento;
    private PrecioAsiento precio;
    private ClaseAsiento clase;
    private UbicacionAsiento ubicacion;
    private EstadoAsiento estado;

    public DatosAsiento(CodigoAsiento codigoAsiento, PrecioAsiento precio, ClaseAsiento clase, UbicacionAsiento ubicacion) {
        this.codigoAsiento = codigoAsiento;
        this.precio = precio;
        this.clase = clase;
        this.ubicacion = ubicacion;
        this.estado = new EstadoAsiento(EstadoAsientoVuelo.DISPONIBLE);//Por default esta disponible
    }
    
    public void reservarAsiento(){
        estado.reservarAsiento();
    }
    
    public String getCodigoAsiento() {
        return codigoAsiento.getCodigoAsiento();
    }

    public double getPrecio() {
        return precio.getPrecioAsiento();
    }

    public ClasesAsientoVuelo getClaseAsiento() {
        return clase.getClaseAsiento();
    }

    public UbicacionAsientoVuelo getUbicacion() {
        return ubicacion.getUbicacionAsiento();
    }

    public EstadoAsientoVuelo getEstado() {
        return estado.getEstadoAsiento();
    }
    
    
}
