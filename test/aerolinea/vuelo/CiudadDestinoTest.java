
package aerolinea.vuelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CiudadDestinoTest {
    
    @Test
    public void testCiudad(){
        CiudadDestino cd = new CiudadDestino("BUE");
        Assert.assertEquals("BUE", cd.getCiudad());
    }
    
}
