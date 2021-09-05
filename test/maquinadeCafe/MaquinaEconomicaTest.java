package maquinadeCafe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MaquinaEconomicaTest {
	MaquinaDeCafe maquina; // la declaramos

	@Before
	public void setup() {
		maquina = new MaquinaEconomica(); // la construimos del tipo economica
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
	public void queNoRestaAntesDelTercero() {
		maquina.servirCafe();
		maquina.servirCafe();
		assertEquals(1000, maquina.getGramosDeCafe());
	}

	@Test
	public void queRestaDespuesDelTercero() {
		maquina.servirCafe();
		maquina.servirCafe();
		maquina.servirCafe();
		assertEquals(1000 - 10, maquina.getGramosDeCafe());
	}
	@Test
	public void queSeAgotaElCafe() {
		for (int i = 0; i < 300; i++) {
			maquina.servirCafe();
		}
		assertFalse(maquina.puedeServir());
	}
	
	@Test
	public void queNoSeAgotaElCafe() {
		for (int i = 0; i < 299; i++) {
			maquina.servirCafe();
		}
		assertTrue(maquina.puedeServir());
	}

	@Test
	public void queLuegoDeAgotarElCafeSirveVasoVacio() {
		for (int i = 0; i < 300; i++) {
			maquina.servirCafe();
		}
		VasoDeCafe vaso = maquina.servirCafe();
		assertFalse(vaso.estaLLeno());		
	}
}	