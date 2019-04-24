package aerolinea.datosAsiento;

import aerolinea.datosAsiento.excepcionesAsiento.PrecioNegativoException;
import aerolinea.vuelo.AsientoVueloLanchita;
import aerolinea.vuelo.CiudadDestino;
import aerolinea.vuelo.CiudadPartida;
import fecha.FechaFlexible;
import fecha.excepcionesFecha.FechaNoValidaException;
import fecha.excepcionesFecha.FormatoFechaIncorrectoException;
import horarios.Hora;
import horarios.excepcionesHora.FormatoHoraIncorrectoException;
import horarios.excepcionesHora.HoraInvalidaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DatosAsientoGeneralTest {
    PrecioAsiento precio;
    PrecioMaximoAsiento precioMax;
    PrecioMinimoAsiento precioMin;
    ClaseAsientoVuelo clase;
    UbicacionAsiento ubicacion;
    CiudadDestino losAngeles;
    CiudadPartida buenosAires;
    FechaFlexible fechaSalida;
    DatosAsientoLanchita asiento;
    Hora horaSalida;
    AsientoVueloLanchita asientoLanchita;
    public DatosAsientoGeneralTest() {
    }
    
    @Before
    public void setUp() {
        try {
            CodigoAsiento codigoVuelo= new CodigoAsiento("LV2O","15");
            precio = new PrecioAsiento(125.50);
            precioMax = new PrecioMaximoAsiento(200);
            precioMin = new PrecioMinimoAsiento(115);
            clase = new ClaseAsientoVuelo(ClasesAsientoVuelo.TURISTA);
            ubicacion = new UbicacionAsiento(UbicacionAsientoVuelo.VENTANA);
            losAngeles = new CiudadDestino("LA");
            buenosAires = new CiudadPartida("BA");
            fechaSalida = new FechaFlexible("2018/11/01");
            horaSalida = new Hora("18:30");
            asiento = new DatosAsientoLanchita(codigoVuelo, precio, clase, ubicacion);
            asientoLanchita = new AsientoVueloLanchita(asiento, losAngeles, buenosAires, fechaSalida, horaSalida);
        } catch (PrecioNegativoException | FormatoFechaIncorrectoException | FechaNoValidaException | FormatoHoraIncorrectoException | HoraInvalidaException ex) {
            Logger.getLogger(DatosAsientoGeneralTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void asientoCumpleParametroPrecio(){
        Assert.assertEquals(true,precio.asientoVueloCumpleParametro(asientoLanchita));
    }
    @Test
    public void asientoNoCumpleParametroPrecio() throws PrecioNegativoException{
        PrecioAsiento precioAs = new PrecioAsiento(125.30);
        Assert.assertEquals(false,precioAs.asientoVueloCumpleParametro(asientoLanchita));
    }
    @Test
    public void asientoCumpleParametroCiudadDestino(){
        Assert.assertEquals(true,losAngeles.asientoVueloCumpleParametro(asientoLanchita));
    }
    @Test
    public void asientoNoCumpleParametroDestino(){
        CiudadDestino ciudad = new CiudadDestino("a");
        Assert.assertEquals(false,ciudad.asientoVueloCumpleParametro(asientoLanchita));
    }
    @Test
    public void asientoCumpleParametroCiudadOrigen(){
        Assert.assertEquals(true,buenosAires.asientoVueloCumpleParametro(asientoLanchita));
    }
    @Test
    public void asientoNoCumpleParametroCiudadOrigen(){
        CiudadPartida ciudad = new CiudadPartida("aa");
        Assert.assertEquals(false,ciudad.asientoVueloCumpleParametro(asientoLanchita));
    }
    @Test
    public void asientoCumpleParametroPrecioMaximo(){
        Assert.assertEquals(true,precioMax.asientoVueloCumpleParametro(asientoLanchita));
    }
    @Test
    public void asientoNoCumpleParametroPrecioMaximo() throws PrecioNegativoException{
        PrecioMaximoAsiento precio = new PrecioMaximoAsiento(110);
        Assert.assertEquals(false,precio.asientoVueloCumpleParametro(asientoLanchita));
    }
    
    @Test
    public void asientoCumpleParametroPrecioMinimo() throws PrecioNegativoException{
        Assert.assertEquals(true,precioMin.asientoVueloCumpleParametro(asientoLanchita));
    }
    @Test
    public void asientoNoCumpleParametroPrecioMinimo() throws PrecioNegativoException{
        PrecioMinimoAsiento precio = new PrecioMinimoAsiento(200);
        Assert.assertEquals(false,precio.asientoVueloCumpleParametro(asientoLanchita));
    }
    
    @Test
    public void asientoCumpleParametroFecha() throws PrecioNegativoException{
        Assert.assertEquals(true,fechaSalida.asientoVueloCumpleParametro(asientoLanchita));
    }
    
    @Test
    public void asientoNoCumpleParametroFecha() throws PrecioNegativoException, FormatoFechaIncorrectoException, FechaNoValidaException{
        FechaFlexible fecha = new FechaFlexible("2016/11/18");
        Assert.assertEquals(false,fecha.asientoVueloCumpleParametro(asientoLanchita));
    }
    
    @Test
    public void asientoCumpleParametroHora() throws PrecioNegativoException{
        Assert.assertEquals(true,horaSalida.asientoVueloCumpleParametro(asientoLanchita));
    }
    
    @Test
    public void asientoNoCumpleParametroHora() throws PrecioNegativoException, FormatoHoraIncorrectoException, HoraInvalidaException{
        Hora hSal = new Hora("13:25");
        Assert.assertEquals(false,hSal.asientoVueloCumpleParametro(asientoLanchita));
    }
    
    @Test
    public void asientoCumpleParametroClase() throws PrecioNegativoException{
        Assert.assertEquals(true,clase.asientoVueloCumpleParametro(asientoLanchita));
    }
    
    @Test
    public void asientoNoCumpleParametroClase() throws PrecioNegativoException{
        ClaseAsientoVuelo clasev = new ClaseAsientoVuelo(ClasesAsientoVuelo.EJECUTIVO);
        Assert.assertEquals(false,clasev.asientoVueloCumpleParametro(asientoLanchita));
    }
    
    @Test
    public void asientoCumpleParametroUbicacion() throws PrecioNegativoException{
        Assert.assertEquals(true,ubicacion.asientoVueloCumpleParametro(asientoLanchita));
    }
    
    @Test
    public void asientoNoCumpleParametroUbicacion() throws PrecioNegativoException{
        UbicacionAsiento ubic = new UbicacionAsiento(UbicacionAsientoVuelo.PASILLO);
        Assert.assertEquals(false,ubic.asientoVueloCumpleParametro(asientoLanchita));
    }
}
