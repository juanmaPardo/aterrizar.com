package usuario;

import aerolinea.datosAsiento.ClaseAsiento;
import aerolinea.datosAsiento.UbicacionAsiento;
import fecha.Fecha;


public class Busqueda {
    //Origen y destino los asumo string xk no tengo un enum con todos los lados posibles,
    //asi que matcheo con los string y listo
    String origen;
    String destino;
    Fecha fecha;//Ya sea de llegada o salida, nos da lo mismo, mostramos todo.
    ClaseAsiento claseAsiento;
    UbicacionAsiento ubicacionAsiento;
    double precioMinimo;
    double precioMaximo;
    boolean mostrarReservados;

    public Busqueda(String origen, String destino, Fecha fecha, ClaseAsiento claseAsiento, UbicacionAsiento ubicacionAsiento, double precioMinimo, double precioMaximo, boolean mostrarReservados) {
        //Los que vienen con null implica que no hay que buscarlos, asi lo pense yo
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.claseAsiento = claseAsiento;
        this.ubicacionAsiento = ubicacionAsiento;
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
        this.mostrarReservados = mostrarReservados;
    }
    
    
    
}
