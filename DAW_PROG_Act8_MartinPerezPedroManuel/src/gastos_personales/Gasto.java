package gastos_personales;

public class Gasto extends Dinero{

	public Gasto(double gasto, String descripcion) {
		super.dinero=gasto;
		super.descripcion=descripcion;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\ngasto:" + dinero + "\ndescripcion:" + descripcion;
	}
}
