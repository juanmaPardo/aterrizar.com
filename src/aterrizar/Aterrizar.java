package aterrizar;

import usuario.Usuario;
import aerolinea.Aerolinea;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Aterrizar {
    LinkedList<Aerolinea> aerolineas;
    TreeSet<Usuario> usuarios;

    public Aterrizar() {
        aerolineas = new LinkedList<>();
        usuarios = new TreeSet<>();
    }
    
    
    public void agregarAerolinea(Aerolinea aerolinea){
        aerolineas.add(aerolinea);
    }
    
    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
}
