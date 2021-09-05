package maquinadeCafe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaquinaPremiumTest {

	MaquinaDeCafe maquina; //la declaramos
	
	@Before
	public void setup() {
		maquina = new MaquinaPremium(); // la construimos del tipo premium
	}
	
	@Test
	public void queDevuelveUnVasoAlServir() {
		VasoDeCafe vaso = maquina.servirCafe();
		assertNotNull(vaso);
	}

	@Test
	public void quePuedeServirUnCafe() {
		assertTrue(maquina.puedeServir());
	}
	
	@Test
	public void queSeAgotaElCafe() {
		for (int i = 0; i < 100; i++) {
			maquina.servirCafe();
		}
		assertFalse(maquina.puedeServir());	
	}
	
	@Test
	public void queLuegoDeAgotarElCafeSirveVasoVacio() {
		for (int i = 0; i < 100; i++) {
			maquina.servirCafe();
		}
		VasoDeCafe vaso = maquina.servirCafe();
		assertFalse(vaso.estaLLeno());		
	}
}
