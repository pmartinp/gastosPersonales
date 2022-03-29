package gastos_personales;

import java.util.ArrayList;

public class Cuenta{

	private double saldo;
	private Usuario usuario;
	private ArrayList<Gasto> gastos=new ArrayList<Gasto>();
	private ArrayList<Ingreso> ingresos=new ArrayList<Ingreso>();
	
	
	public Cuenta(Usuario usuario) {
		this.usuario=usuario;
		this.saldo=0;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public double addIngresos(String descripcion, double cantidad) {
		Ingreso ingreso = new Ingreso(cantidad, descripcion);
		ingresos.add(ingreso);
		this.saldo+=ingreso.dinero;
		return this.saldo;
	}
	
	public double addGastos(String descripcion, double cantidad) {
		//comprobamos que haya saldo suficiente
		if(saldo>cantidad) {
			Gasto gasto = new Gasto(cantidad, descripcion);
			gastos.add(gasto);
			this.saldo-=gasto.dinero;
		}
		else {
			System.out.println("No se dispone de saldo para realizar este gasto");
		}
		
		return this.saldo;
	}
	public ArrayList<Gasto> getGastos() {
		return gastos;
	}
	public ArrayList<Ingreso> getIngreso() {
		return ingresos;
	}

	@Override
	public String toString() {
		return "usuario: " + usuario+ "\nsaldo: "+ saldo;
	}
	
	
}
