package gastos_personales;

public class Ingreso extends Dinero{

	public Ingreso(double ingreso, String descripcion) {
		super.dinero=ingreso;
		super.descripcion=descripcion;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\ningreso:" + dinero + "\ndescripcion:" + descripcion;
	}
}
