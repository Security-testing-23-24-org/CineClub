package ed.ev2.ampliacion.cine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import ed.ev2.ampliacion.model.CineManagement;
import ed.ev2.ampliacion1.vo.ButacaVo;
import ed.ev2.refuerzo.exception.CineException;

public class GestionCine {
	private ButacaVo[][] vButacas;
	private Scanner sc;
	public static final int FILAS=10;
	public static final int ASIENTOS=15;
	private static final String CARACTER_SEPARADOR=":";
	private static final String FICHERO_RESERVAS="./entradasVendidas.txt";

	public GestionCine(){
		vButacas=new ButacaVo[FILAS][ASIENTOS];
		for(int i=0; i < FILAS; i++) {
			for (int j=0; j < ASIENTOS; j++) {
				ButacaVo butacaActual= new ButacaVo();
				butacaActual.setFila(i);
				butacaActual.setAsiento(j);
				vButacas[i][j]=butacaActual;
			}
		}
		sc=new Scanner(System.in);				
	}
	
	public boolean reservarButaca(ButacaVo b) {
		boolean butacaReservada=false;
		if ((b.getFila() > 0) && (b.getFila() <= FILAS) &&
				(b.getAsiento() > 0) && (b.getAsiento() <= ASIENTOS)) {
			if (!vButacas[b.getFila()-1][b.getAsiento()-1].isOcupado()) {
				vButacas[b.getFila()-1][b.getAsiento()-1].setOcupado(true);
				butacaReservada=true;
			}
		}
		
		return butacaReservada;
	}
	
	public ButacaVo reservarPrimeraButacaLibre() {
		int fila=0, asiento=0;
		ButacaVo butacaActual=null;
		
		while ((fila<CineManagement.FILAS) && (butacaActual==null)) {
			while ((asiento<CineManagement.ASIENTOS) && (butacaActual==null)) {
				if (!vButacas[fila][asiento].isOcupado()) {
					vButacas[fila][asiento].setOcupado(true);
					butacaActual=new ButacaVo();
					butacaActual.setFila(fila+1);
					butacaActual.setAsiento(asiento+1);
				}
				asiento++;
			}
			fila++;
			asiento=0;
		}
				
		return butacaActual;
	}
			
	public boolean devolverButaca(ButacaVo b) {
		boolean butacaDevuelta=false;
		
		if ((b.getFila() > 0) && (b.getFila() <= FILAS) &&
				(b.getAsiento() > 0) && (b.getAsiento() <= ASIENTOS)) {
			if (this.isAsientoOcupado(b)) {
				vButacas[b.getFila()-1][b.getAsiento()-1].setOcupado(false);
				butacaDevuelta=true;
			}
		}
		
		return butacaDevuelta;
	}
	
	public boolean isAsientoOcupado(ButacaVo b){
		boolean asientoOcupado=false;
		
		if ((b.getFila() > 0) && (b.getFila() <= FILAS) &&
				(b.getAsiento() > 0) && (b.getAsiento() <= ASIENTOS)) {
			asientoOcupado=vButacas[b.getFila()-1][b.getAsiento()-1].isOcupado();
		}
		
		return asientoOcupado;
	}
	
	public String[][] generarMatrizOcupacion() {
		String[][] matrizOcupacion=new String[FILAS][ASIENTOS];

		for (int i=0; i<FILAS; i++) {
			for (int j=0; j<ASIENTOS; j++) {
				if (vButacas[i][j]!=null)
				matrizOcupacion[i][j]=vButacas[i][j].mostrarEnMatriz();
			}
		}
		
		return matrizOcupacion;
	}
	
	public void cargarMatrizButacas() throws CineException{
		try {
			FileReader fr=new FileReader(FICHERO_RESERVAS);
			BufferedReader br=new BufferedReader(fr);
			String infoButaca="";			
			String[] posicion= new String[] {"",""};
			while ((infoButaca=br.readLine())!=null) {
				posicion=infoButaca.split(CARACTER_SEPARADOR);
				vButacas[Integer.parseInt(posicion[0])][Integer.parseInt(posicion[1])].setOcupado(true);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			String mensaje="Todas las butacas del cine se encuentran disponibles!!!";
			throw new CineException(mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void persistirOcupacion() {
		try {
			FileWriter fw = new FileWriter("./entradasVendidas.txt");
			PrintWriter pw = new PrintWriter(fw);
			for (int i=0; i<FILAS; i++) {
				for (int j=0; j<ASIENTOS; j++) {
					if(vButacas[i][j].isOcupado()) {
						pw.println(vButacas[i][j]);
					}
				}
			}
			
			pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}	
	
	public void mostrarMenu() {
		System.out.println("1. Mostrar butacas.");
		System.out.println("2. Comprar entrada.");
		System.out.println("3. Comprar primera entrada libre.");
		System.out.println("4. Devolver una entrada.");
		System.out.println("5. Salir");
	}
	
	public String mostrarOcupacion(String[][] matrizOcupacion) {
		StringBuilder cadenaOcupacion=new StringBuilder();
		cadenaOcupacion.append("\n\n\n\n").append("           ");
		for (int i=0; i<CineManagement.FILAS; i++) {
			for (String s:matrizOcupacion[i]) {
				cadenaOcupacion.append(s).append("  ");
			}
			cadenaOcupacion.append("\n").append("           ");
		}
		return cadenaOcupacion.toString();
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
	
	public void gestionarMenu() {
		boolean salir=false;
		try {
			this.cargarMatrizButacas();
		} catch (CineException e) {
				System.out.println("\n\n\t\t\t" + e.getMessage());
		}
		
		do {
			mostrarMenu();
			String opcion=sc.nextLine();
			switch(Integer.parseInt(opcion)) {
			case(1):
				System.out.println(mostrarOcupacion(this.generarMatrizOcupacion()));
				break;
			case(2):
				ButacaVo butacaParaReservar=this.pedirDatosButaca();
				boolean resultadoReserva=this.reservarButaca(butacaParaReservar);
				mostrarResultadoReservaButaca(resultadoReserva, butacaParaReservar);
				break;
			case(3):
				ButacaVo butacaReservada=this.reservarPrimeraButacaLibre();
				if (butacaReservada!=null) {
					mostrarResultadoReservaButaca(true, butacaReservada);
				} else {
					this.mostrarResultadoReservaButaca(false, butacaReservada);
				}
				break;
			case(4):
				ButacaVo butacaParaDevolver=this.pedirDatosButaca();
				boolean resultadoDevolucion=this.devolverButaca(butacaParaDevolver);
				this.mostrarResultadoDevolucionButaca(resultadoDevolucion, butacaParaDevolver);
				break;
			case(5):
				this.persistirOcupacion();
				salir=true;
				break;
			default:
				
			}
		}while (!salir);
	}
	
//	public static void main(String[] argv) {
//		GestionCine cine = new GestionCine();
//		cine.gestionarMenu();
//	}	




}
