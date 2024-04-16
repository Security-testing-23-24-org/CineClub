package ed.ev2.ampliacion.vista;

import java.util.Scanner;

import ed.ev2.ampliacion.model.CineManagement;
import ed.ev2.ampliacion1.vo.ButacaVo;
import ed.ev2.refuerzo.controller.CineController;
import ed.ev2.refuerzo.exception.CineException;

public class CineVistaConsola {
	
	private CineController cc;
	private Scanner sc;
	
	public CineVistaConsola(CineController controller){
		cc=controller;
		sc=new Scanner(System.in);
	}
	
	public void mostrarMenu() {
		System.out.println("1. Mostrar butacas.");
		System.out.println("2. Comprar entrada.");
		System.out.println("3. Comprar primera entrada libre.");
		System.out.println("4. Devolver una entrada.");
		System.out.println("5. Salir");
	}
	
	public void mostrarOcupacion(String[][] matrizOcupacion) {
		for (int i=0; i<CineManagement.FILAS; i++) {
			for (String s:matrizOcupacion[i]) {
				System.out.print(s + "  ");
			}
			System.out.println("\n");
		}
	}
	
	public ButacaVo pedirDatosButaca() {
		ButacaVo bReserva=new ButacaVo();
		
		System.out.println("Introduce la fila: ");
		bReserva.setFila(Integer.parseInt(sc.nextLine()));
		System.out.println("Introduce el asiento: ");
		bReserva.setAsiento(Integer.parseInt(sc.nextLine()));
		
		return bReserva;
	}
	
	public void mostrarResultadoReservaButaca(boolean resultado, ButacaVo butaca) {
		if (resultado) {
			System.out.println("\n\t\t-----------------------------");
			System.out.println("\t\tLa butaca: " + butaca);
			System.out.println("\t\tSe ha reservado correctamente");
			System.out.println("\t\t-----------------------------");
		} else {
			System.out.println("\n\t\t------------------------------------");
			System.out.println("\t\tNo se ha podido realizar la reserva!");
			System.out.println("\t\t------------------------------------");
		}
	}
	
	public void mostrarResultadoDevolucionButaca(boolean resultado, ButacaVo butaca) {
		if (resultado) {
			System.out.println("\n\t\t-----------------------------");
			System.out.println("\t\tLa butaca: " + butaca);
			System.out.println("\t\tSe ha devuelto correctamente");
			System.out.println("\t\t-----------------------------");
		} else {
			System.out.println("\n\t\t------------------------------------");
			System.out.println("\t\tNo se ha podido devolver la butaca!");
			System.out.println("\t\t------------------------------------");
		}
	}
	
//	public void gestionarMenu() {
//		boolean salir=false;
//		try {
//			cc.cargarMatrizButacas();
//		} catch (CineException e) {
//				System.out.println("\n\n\t\t\t" + e.getMessage());
//		}
//				
//		do {
//			mostrarMenu();
//			String opcion=sc.nextLine();
//			switch(Integer.parseInt(opcion)) {
//			case(1):
//				mostrarOcupacion(cc.obtenerOcupacionCine());
//				break;
//			case(2):
//				ButacaVo butacaParaReservar=this.pedirDatosButaca();
//				butacaParaReservar.setOcupado(true);
//				boolean resultadoReserva=cc.reservarButaca(butacaParaReservar);
//				mostrarResultadoReservaButaca(resultadoReserva, butacaParaReservar);
//				break;
//			case(3):
//				ButacaVo butacaReservada=cc.reservarPrimeraButacaLibre();
//				if (butacaReservada!=null) {
//					mostrarResultadoReservaButaca(true, butacaReservada);
//				} else {
//					this.mostrarResultadoReservaButaca(false, butacaReservada);
//				}
//				break;
//			case(4):
//				ButacaVo butacaParaDevolver=this.pedirDatosButaca();
//				boolean resultadoDevolucion=cc.devolverButaca(butacaParaDevolver);
//				this.mostrarResultadoDevolucionButaca(resultadoDevolucion, butacaParaDevolver);
//				break;
//			case(5):
//				cc.persistirOcupacion();
//				salir=true;
//				break;
//			default:
//				
//			}
//		}while (!salir);
//	}
	
	
}
