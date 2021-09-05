package maquinadeCafe;

public class VasoDeCafe {
	private boolean lleno = false;

	public VasoDeCafe(boolean lleno) {
		this.lleno = lleno;
	}

	@Override
	public String toString() {
		return "VasoDeCafe [lleno=" + lleno + "]";
	}

	public boolean estaLLeno() {
		return this.lleno;
	}
	
}
