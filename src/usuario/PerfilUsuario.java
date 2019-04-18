package usuario;

import java.util.LinkedList;

public class PerfilUsuario {
    boolean esVip;
    double dineroGastado;
    LinkedList<Busqueda> busquedas;//Guardo una lista de las busquedas que realizo x temas estadisticos

    public PerfilUsuario() {
        //La idea es que no arranque siendo vip y cuando supere la cantidad prevista
        //lo ascendemos a vip, pero inicia siendo un usuario estandar
        esVip = false;
        dineroGastado = 0;
        busquedas = new LinkedList<>();
    }
    
    
}
