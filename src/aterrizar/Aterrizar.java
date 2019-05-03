package aterrizar;

import usuario.Usuario;
import aerolinea.AerolineaGeneral;
import aerolinea.vuelo.AsientoGeneralVuelo;
import java.util.LinkedList;
import java.util.TreeSet;

public class Aterrizar {
    LinkedList<AerolineaGeneral> aerolineas;
    TreeSet<Usuario> usuarios;
    LinkedList<AsientoGeneralVuelo> asientosSobreReservados;
    

    public Aterrizar() {
        aerolineas = new LinkedList<>();
        usuarios = new TreeSet<>();
    }
    
    
    public void realizarSobreReserva(AsientoGeneralVuelo asiento, Usuario usuario){
        asiento.getDatosAsiento().getEstado().sobrereservarAsiento();
        asientosSobreReservados.add(asiento);
        usuario.agregarAsientoSobrereservado(asiento);
    }
    
    public void agregarAerolinea(AerolineaGeneral aerolinea){
        aerolineas.add(aerolinea);
    }
    
    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
}
