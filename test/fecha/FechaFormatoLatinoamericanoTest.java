package fecha;

import fecha.excepcionesFecha.FechaNoValidaException;
import fecha.excepcionesFecha.FormatoFechaIncorrectoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juanm
 */
public class FechaFormatoLatinoamericanoTest {
    
    public FechaFormatoLatinoamericanoTest() {
    }
    
    @Test
    public void seCreaExitosamenteUnaFechaFormatoLatinoamericanoYFuncionanGetters(){
        try {
            FechaFormatoLatinoamericano ffl = new FechaFormatoLatinoamericano("12/01/2012");
            Assert.assertEquals(12, ffl.getDia());
            Assert.assertEquals(1, ffl.getMes());
            Assert.assertEquals(2012, ffl.getAnio());
        } catch (FormatoFechaIncorrectoException | FechaNoValidaException ex) {
            Assert.assertEquals(false, true);
        }
        
    }
    
}
