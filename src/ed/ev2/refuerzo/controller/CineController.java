package ed.ev2.refuerzo.controller;

import java.io.IOException;
import java.sql.SQLException;

import ed.ev2.ampliacion.model.CineManagement;
import ed.ev2.ampliacion.vista.CineVistaConsola;
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
	
	public boolean reservarButaca(ButacaVo b) {
		return model.reservarButaca(b);
	}
	
	public CineVistaConsola getCine() {
		return cine;
	}

	public void setCine(CineVistaConsola cine) {
		this.cine = cine;
	}
	
	public static void main(String[] argv) throws IOException, SQLException, ClassNotFoundException{
		LoginView frame = new LoginView();
		frame.setVisible(true);
	}	
}
