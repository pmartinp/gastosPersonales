package gastos_personales;

import java.time.LocalDate;
import java.util.Arrays;

public class Usuario implements Persona{
	
	static int[] diasMes= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static LocalDate todaysDate = LocalDate.now();
	private String nombre, fecha_nacimiento, DNI;
	
	public Usuario() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDNI() {
		return DNI;
	}

	public boolean setDNI(String DNI) {
		
		if(DNI.matches("[0-9]{8}[\\-][a-zA-Z]") || DNI.matches("[0-9]{8}[a-zA-Z]")) {
			this.DNI = DNI;
			return true;
		}
		else {
			return false;
		}
	}

	public int calcularEdad() {
		
		int[] fecha_nac= Arrays.stream(fecha_nacimiento.substring(0, fecha_nacimiento.length()).split("-"))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();
		int edad=0;
		int anio=fecha_nac[2];
		
		if(todaysDate.getMonthValue()<fecha_nac[1]) {
			anio++;
		}
		else if(todaysDate.getMonthValue()==fecha_nac[1] && todaysDate.getDayOfMonth()<fecha_nac[0]) {
			anio++;
		}
		edad=todaysDate.getYear()-anio;
		return edad;
	}
	
	public String saludar() {
		return "Bienvenido al programa de gestión de gastos personales "+ this.nombre;
	}
	
	//funcion extra para validar la fecha
	public boolean validadFecha(String fecha){
        boolean validoFecha=false;
        
        //comprueba el formato de fecha, pudiendo admitir tanto / como -
        if(!fecha.matches("\\d{1,2}[\\-\\/]\\d{1,2}[\\-\\/]\\d{4}")) {
        	System.out.println("Formato de fecha incorrecto");
        	validoFecha=true;
        }
        
        //comprueba que sea una fecha existente
        if(validoFecha==false) {
        	 int[] fecha_nac= Arrays.stream(fecha.substring(0, fecha.length()).split("[-/]"))
                     .map(String::trim).mapToInt(Integer::parseInt).toArray();
             
             if (fecha_nac[0]<1 || fecha_nac[0]>31) {
                 validoFecha=true;
             }

             if (fecha_nac[1]<1 || fecha_nac[1]>12) {
                 validoFecha=true;
             }

             if (fecha_nac[1]==2 && fecha_nac[0]==29 && fecha_nac[2] % 4 == 0) {
                 validoFecha=true;
             }
        }

        return validoFecha;
        }
	
	@Override
	public String toString() {
		return "nombre: " + nombre + "\nfecha_nacimiento: " + fecha_nacimiento + "\nDNI: " + DNI;
	}
	
	
}
