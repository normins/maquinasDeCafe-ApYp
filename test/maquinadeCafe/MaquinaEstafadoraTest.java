package maquinadeCafe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaquinaEstafadoraTest {
	
	MaquinaDeCafe maquina; //la declaramos
	
	@Before
	public void setup() {
		maquina = new MaquinaEstafadora(); // la construimos del tipo premium
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
	public void queElPrimerVasoEstaLlenoYElSiguienteVacio() {
		assertTrue(maquina.servirCafe().estaLLeno());
		assertFalse(maquina.servirCafe().estaLLeno());
		assertTrue(maquina.servirCafe().estaLLeno());
		assertFalse(maquina.servirCafe().estaLLeno());
	}
	
	@Test
	public void queSeAgotaElCafe() {
		for (int i = 0; i < 200; i++) {
			maquina.servirCafe();
		}
		assertFalse(maquina.puedeServir());	
	}
	
	@Test
	public void queNoSeAgotaElCafe() {
		VasoDeCafe vaso = null;
		for (int i = 0; i < 199; i++) {
			vaso = maquina.servirCafe();
		}
		assertTrue(vaso.estaLLeno());	
	}
	
	@Test
	public void queLuegoDeAgotarElCafeSirveVasoVacio() {
		for (int i = 0; i < 200; i++) {
			maquina.servirCafe();
		}
		VasoDeCafe vaso = maquina.servirCafe();
		assertFalse(vaso.estaLLeno());		
	}
}