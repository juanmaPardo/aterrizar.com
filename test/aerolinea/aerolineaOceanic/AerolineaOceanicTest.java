
package aerolinea.aerolineaOceanic;

import aerolinea.AerolineaOceanic;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AerolineaOceanicTest {
    
    public AerolineaOceanicTest() {
    }

    @Test
    public void seIngresaUnCodigoDeCiudadDeDosCaracteresYSeModifica(){
        AerolineaOceanic aerolineaO = new AerolineaOceanic();
        assertEquals("El codigo de ciudad no fue modificado","LR_" ,aerolineaO.modificarCodigoCiudad("LR"));
    }
    
    @Test
    public void seIngresaElCodigoDeCiudadLAYSeModifica(){
        AerolineaOceanic aerolineaO = new AerolineaOceanic();
        assertEquals("El codigo de ciudad no fue modificado","SLA" ,aerolineaO.modificarCodigoCiudad("LA"));
    }

    @Test
    public void seIngresaUnCodigoDeCiudadDeTresCaracteresYNoSeModifica(){
        AerolineaOceanic aerolineaO = new AerolineaOceanic();
        assertEquals("El codigo de ciudad no fue modificado","BUE" ,aerolineaO.modificarCodigoCiudad("BUE"));
    }
}
