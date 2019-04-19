/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarios;

import horarios.excepcionesHora.FormatoHoraIncorrectoException;
import horarios.excepcionesHora.HoraInvalidaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juanm
 */
public class HoraTest {
    
    public HoraTest() {
    }

    @Test
    public void seCreaHoraExitosamenteYFuncionanLosGetters() {
        try {
            Hora hora = new Hora("20:15");
            Assert.assertEquals(20, hora.getHora());
            Assert.assertEquals(15, hora.getMinutos());
        } catch (FormatoHoraIncorrectoException | HoraInvalidaException ex) {
            Assert.assertEquals(true, false);
        }
    }
    
    @Test(expected = FormatoHoraIncorrectoException.class)
    public void fallaCreacionHoraPorLongitudDesproporcionada() throws FormatoHoraIncorrectoException, HoraInvalidaException{
        Hora hora = new Hora("20:156");
    }
    
    @Test(expected = FormatoHoraIncorrectoException.class)
    public void fallaCreacionHoraPorCaracteresInvalidos() throws FormatoHoraIncorrectoException, HoraInvalidaException{
        Hora hora = new Hora("20/15");
    }
    
    @Test(expected = HoraInvalidaException.class)
    public void fallaCreacionHoraPorHoraInvalida() throws FormatoHoraIncorrectoException, HoraInvalidaException{
        Hora hora = new Hora("24:16");
    }
    
    @Test(expected = HoraInvalidaException.class)
    public void fallaCreacionHoraPorMinutosInvalidos() throws FormatoHoraIncorrectoException, HoraInvalidaException{
        Hora hora = new Hora("20:60");
    }
}
