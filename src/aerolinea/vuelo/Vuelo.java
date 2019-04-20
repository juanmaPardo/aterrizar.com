package aerolinea.vuelo;

import aerolinea.datosAsiento.DatosAsiento;
import aerolinea.vuelo.informacionVuelo.InformacionVuelo;
import fecha.Fecha;
import java.util.LinkedList;


public class Vuelo {
    private LinkedList<DatosAsiento> asientosVuelo;
    private InformacionVuelo informacionVuelo;

    public Vuelo(InformacionVuelo informacionVuelo) {
        asientosVuelo = new LinkedList<>();
        this.informacionVuelo = informacionVuelo;
    }

    public Vuelo(LinkedList<DatosAsiento> asientosVuelo,InformacionVuelo informacionVuelo) {
        this.asientosVuelo = new LinkedList<>();
        this.asientosVuelo.addAll(asientosVuelo);
        this.informacionVuelo = informacionVuelo;
    }
    
    public LinkedList<AsientoVuelo> getDatosAsientoVuelo(){
        LinkedList<AsientoVuelo> datoAsientoVuelo = new LinkedList<>();
        asientosVuelo.forEach(asiento ->{
            datoAsientoVuelo.add(new AsientoVuelo(asiento, informacionVuelo.getInformacionRuta().getOrigen(),  informacionVuelo.getInformacionRuta().getDestino()));
        });
        return datoAsientoVuelo;
    }
    
    public void agregarAsiento(DatosAsiento asientoVuelo){
        asientosVuelo.add(asientoVuelo);
    }

    public LinkedList<DatosAsiento> getAsientosVuelo() {
        return asientosVuelo;
    }
    
}
