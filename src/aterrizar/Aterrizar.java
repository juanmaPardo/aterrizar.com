package aterrizar;

import aerolinea.AerolineaGeneral;
import usuario.Usuario;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Aterrizar {
    LinkedList<AerolineaGeneral> aerolineas;
    protected TreeMap<Integer,Usuario> usuarios;

    public Aterrizar() {
        aerolineas = new LinkedList<>();
        usuarios = new TreeMap<>();
    }
    
    
    public void agregarAerolinea(AerolineaGeneral aerolinea){
        aerolineas.add(aerolinea);
    }
    
    public void agregarUsuario(Usuario usuario){
        usuarios.put(usuario.getDni(), usuario);
    }
}
