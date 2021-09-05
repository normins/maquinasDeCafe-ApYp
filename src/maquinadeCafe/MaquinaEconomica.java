package maquinadeCafe;

public class MaquinaEconomica extends MaquinaDeCafe{

	private int contadordeServidos = 0;
	
	@Override
	public void restarCafe() {
		this.contadordeServidos ++;
		if (this.contadordeServidos % 3 == 0) {
			// esto es lo que tenemos que hacer, pero no tenemos acceso
			// el que sabe restarCafe es MaquienaDeCafe
			//this.gramosDeCafe -= GRAMOS_POR_CAFE;
			super.restarCafe();
			this.contadordeServidos = 0;
		}
	}
}
