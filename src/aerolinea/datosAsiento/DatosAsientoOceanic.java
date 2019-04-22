
package aerolinea.datosAsiento;

import aerolinea.vuelo.AsientoVueloLanchita;
import aerolinea.vuelo.CiudadDestino;
import aerolinea.vuelo.CiudadPartida;
import fecha.FechaFormatoLatinoamericano;
import horarios.Hora;

public class DatosAsientoOceanic extends DatosAsientoGeneral{
    private Hora horaDeSalida;
    private FechaFormatoLatinoamericano fechaDeSalida;
    private Integer numeroDeAsiento;
    private String codigoDeVuelo;
    
    public DatosAsientoOceanic (PrecioAsiento precio, ClaseAsientoVuelo clase, UbicacionAsiento ubicacionAsiento, Hora horaDeSalida,FechaFormatoLatinoamericano fechaDeSalida, Integer numeroDeAsiento, String codigoDeVuelo ){
        super(precio, clase,ubicacionAsiento);
        this.horaDeSalida = horaDeSalida;
        this.fechaDeSalida = fechaDeSalida;  
        this.numeroDeAsiento = numeroDeAsiento;
        this.codigoDeVuelo = codigoDeVuelo;
    }
    
    public Hora getHoraDeSalida(){
        return horaDeSalida;
    }
    
    public String getFechaDeSalida(){
        return fechaDeSalida.representacionEnLatinoamericano();
    }
    
    public Integer getNumeroDeAsiento(){
        return numeroDeAsiento;
    }
    
    public String getCodigoDeVuelo(){
        return codigoDeVuelo;  
}

    
    
    
    
    
    
}
