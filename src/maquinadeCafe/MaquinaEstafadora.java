package maquinadeCafe;

public class MaquinaEstafadora extends MaquinaPremium {

	private boolean yaEstafe = true;

	@Override
	public VasoDeCafe servirCafe() {
		if (yaEstafe) {
			this.yaEstafe = false;
			return super.servirCafe(); // devuelve vaso lleno
		} else {
			this.yaEstafe = true;
			return new VasoDeCafe(false); // devuelve vaso vacío
		}
	}
}
