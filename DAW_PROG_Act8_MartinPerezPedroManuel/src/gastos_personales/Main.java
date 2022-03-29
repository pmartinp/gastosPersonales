package gastos_personales;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leer= new Scanner(System.in);
		boolean menu=true;
		int opcion=0;
		double cantidad;
		String descripcion;
		
		Usuario usuario = new Usuario();
		crearUsuario(usuario);
		
		Cuenta cuenta = new Cuenta(usuario);
		cuenta.getUsuario().saludar();
		
		
		while(menu) {
			
			mostrarMenu();
			
			try {
				opcion=leer.nextInt();
			
				switch(opcion) {
				
				//Introduce un nuevo gasto
				case 1:
					introducirGasto(cuenta);
					break;
					
				//Introduce un nuevo ingreso
				case 2: 
					introducirIngreso(cuenta);
					break;
					
				//Mostrar gastos
				case 3:
					mostrarGastos(cuenta);
					break;
					
				//Mostrar ingresos
				case 4: 
					mostrarIngresos(cuenta);
					break;
					
				//Mostrar saldo
				case 5:
					mostrarSaldo(cuenta);
					break;
					
				//Salir
				case 0: 
					System.out.println("Fin del programa."+ "\nGracias por utilizar la aplicación");
					menu=false;
					break;
					
				default:
					System.out.println("Introduzca una opción válida");
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Introduzca una opción válida");
				leer.next();
			}
			
			
			
		}
	}
	public static void crearUsuario(Usuario usuario) {
		Scanner leer= new Scanner(System.in);
		
		System.out.println("Creación de usuario");
		System.out.print("\nNombre: ");
		String nombre=leer.nextLine();
		System.out.print("Fecha de nacimiento: ");
		String fecha=leer.next();
		
		while(usuario.validadFecha(fecha)) {
			System.out.println("Introduzca una fecha correcta:");
			fecha=leer.next();
		}
		System.out.print("DNI: ");
		String DNI=leer.next();
		
		usuario.setNombre(nombre);
		usuario.setFecha_nacimiento(fecha);
		
		while(!usuario.setDNI(DNI)) {
			System.out.print("DNI incorrecto, introduzca un DNI válido: ");
			DNI=leer.next();
		}
		
		System.out.println("Acceso autorizado a la aplicación. Tu edad es "+usuario.calcularEdad());
	}


	public static void mostrarMenu() {
		System.out.println("Realiza una nueva acción:");
		System.out.println("1 Introduce un nuevo gasto");
		System.out.println("2 Introduce un nuevo ingreso");
		System.out.println("3 Mostrar los gastos");
		System.out.println("4 Mostrar los ingresos");
		System.out.println("5 Mostrar saldo");
		System.out.println("0 Salir");
	}

	public static void introducirGasto(Cuenta cuenta) {
		Scanner leer= new Scanner(System.in);
		
		System.out.print("Cantidad: ");
		double cantidad=leer.nextDouble();
		System.out.print("Descripcion: ");
		String descripcion=leer.nextLine();
		descripcion=leer.nextLine();
		
		System.out.println("Saldo nuevo: "+cuenta.addGastos(descripcion, cantidad));
	}
	
	public static void introducirIngreso(Cuenta cuenta) {
		Scanner leer= new Scanner(System.in);
		
		System.out.print("Cantidad: ");
		double cantidad=leer.nextDouble();
		System.out.print("Descripcion: ");
		String descripcion=leer.nextLine();
		descripcion=leer.nextLine();
		
		System.out.println("Saldo nuevo: "+cuenta.addIngresos(descripcion, cantidad));
	}

	public static void mostrarGastos(Cuenta cuenta) {
		System.out.println(cuenta.getGastos());
	}
	public static void mostrarIngresos(Cuenta cuenta) {
		System.out.println(cuenta.getIngreso());
	}
	public static void mostrarSaldo(Cuenta cuenta) {
		System.out.println("Saldo: "+ cuenta.getSaldo());
	}
}
