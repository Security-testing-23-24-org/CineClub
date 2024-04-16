package ed.ev2.refuerzo.controller;

import java.io.IOException;
import java.sql.SQLException;

import ed.ev2.ampliacion.model.CineManagement;
import ed.ev2.ampliacion.vista.CineVistaConsola;
import ed.ev2.ampliacion.vista.CineVistaVentanas;
import ed.ev2.ampliacion.vista.LoginView;
import ed.ev2.ampliacion1.vo.ButacaVo;
import ed.ev2.refuerzo.exception.CineException;

public class CineController {
	
	public static final int FILAS=10;
	public static final int ASIENTOS=15;

	private CineVistaConsola cine;
	private CineManagement model;
	
	public CineController() throws CineException{
		cine = new CineVistaConsola(this);
		model = new CineManagement();
	}
	
	public boolean verificarCredencialesCliente(String nombre, String password) {
		return model.verificarCredencialesCliente(nombre, password);
	}
	
//	public void cargarMatrizButacas() throws CineException{
//		model.cargarMatrizButacas();
//	}
	
//	private String[][] mostrarButacas() {
//		return model.generarMatrizOcupacion();
//	}

//	public String[][] obtenerOcupacionCine() {
//		return model.generarMatrizOcupacion();
//	}
	
	public boolean reservarButaca(ButacaVo b) {
		return model.reservarButaca(b);
	}
	
//	public ButacaVo reservarPrimeraButacaLibre() {
//		return model.reservarPrimeraButacaLibre();
//	}
	
//	public boolean devolverButaca(ButacaVo b) {
//		return model.devolverButaca(b);
//	}
	
//	public void persistirOcupacion() {
//		model.persistirButacas();
//	}

	public CineVistaConsola getCine() {
		return cine;
	}

	public void setCine(CineVistaConsola cine) {
		this.cine = cine;
	}

	// Defensa de la práctica -INICIO	        	
//	public EstadisticasVo calcularEstadisticas() {
//		return model.calcularEstadisticas();
//	}
	// Defensa de la práctica -FIN	        	

//	public CineVistaVentanas getCine() {
//		return cine;
//	}
//
//
//	public void setCine(CineVistaVentanas cine) {
//		this.cine = cine;
//	}
	
//	public CineManagement getModel() {
//		return model;
//	}
//
//
//	public void setModel(CineManagement model) {
//		this.model = model;
//	}
	
	
//	public String mostrarOcupacion() {
//		String[][] matrizOcupacion=this.mostrarButacas();
//		StringBuilder cadenaOcupacion=new StringBuilder();
//		cadenaOcupacion.append("\n\n\n\n").append("           ");
//		for (int i=0; i<CineController.FILAS; i++) {
//			for (String s:matrizOcupacion[i]) {
//				cadenaOcupacion.append(s).append("  ");
//			}
//			cadenaOcupacion.append("\n").append("           ");
//		}
//		return cadenaOcupacion.toString();
//	}

	
	public static void main(String[] argv) throws IOException, SQLException, ClassNotFoundException{
		LoginView frame = new LoginView();
		frame.setVisible(true);
	}	
}
