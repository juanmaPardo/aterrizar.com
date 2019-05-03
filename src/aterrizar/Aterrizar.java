package aterrizar;

import aerolinea.AerolineaGeneral;
import usuario.Usuario;
import aerolinea.AerolineaGeneral;
import aerolinea.vuelo.AsientoGeneralVuelo;
import java.util.LinkedList;
import java.util.TreeMap;

public class Aterrizar {
    LinkedList<AerolineaGeneral> aerolineas;
    LinkedList<AsientoGeneralVuelo> asientosSobreReservados;
    protected TreeMap<Integer,Usuario> usuarios;

    public Aterrizar() {
        aerolineas = new LinkedList<>();
        usuarios = new TreeMap<>();
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
        usuarios.put(usuario.getDni(), usuario);
    }
}
