package maquinadeCafe;

public abstract class MaquinaDeCafe {

	private int gramosDeCafe;
	private static final int GRAMOS_POR_CAFE = 10;
	private static final int CANTIDAD_INICIAL_DE_CAFE = 1000;

	public MaquinaDeCafe() {
		this.gramosDeCafe = CANTIDAD_INICIAL_DE_CAFE;
	}

	public VasoDeCafe servirCafe() {
		if (this.puedeServir()) {
			this.restarCafe();
			return new VasoDeCafe(true); // true = lleno)
		}
		return new VasoDeCafe(false); // false = vacío)
	}

	protected void restarCafe() {
		this.gramosDeCafe -= GRAMOS_POR_CAFE;
	}

	protected boolean puedeServir() {
		return this.gramosDeCafe >= GRAMOS_POR_CAFE;
	}

	public int getGramosDeCafe() {
		return this.gramosDeCafe;
	}
}
