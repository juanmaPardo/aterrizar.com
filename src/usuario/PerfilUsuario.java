package usuario;

import aerolinea.busqueda.Busqueda;
import java.util.LinkedList;

public class PerfilUsuario {
    private double dineroGastado;
    private LinkedList<Busqueda> busquedas;//Guardo una lista de las busquedas que realizo x temas estadisticos

    public PerfilUsuario() {
        //La idea es que no arranque siendo vip y cuando supere la cantidad prevista
        //lo ascendemos a vip, pero inicia siendo un usuario estandar
        dineroGastado = 0;
        busquedas = new LinkedList<>();
    }
    
    public boolean esVip(){
        return dineroGastado >= 100000;
    }
    
    public double dineroGastado(){
        return dineroGastado;
    }
    
    public void incrementarDineroGastado(double cantidad){
        dineroGastado += cantidad;
    }
    
    public LinkedList<Busqueda> busquedasRealizadas(){
        return busquedas;
    }
    
}
