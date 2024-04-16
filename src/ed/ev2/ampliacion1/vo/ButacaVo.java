package ed.ev2.ampliacion1.vo;

import java.io.Serializable;

public class ButacaVo implements Serializable{
	private static final long serialVersionUID = 3727620403250990322L;
	private int fila;
	private int asiento;
	private boolean ocupado;
	
	public ButacaVo() {
		super();
	}
	
	public ButacaVo(int fila, int asiento) {
		this.fila=fila;
		this.asiento=asiento;
	}
	
	public int getFila() {
		return fila;
	}
	
	public void setFila(int fila) {
		this.fila = fila;
	}
	
	public int getAsiento() {
		return asiento;
	}
	
	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}
	
	public boolean isOcupado() {
		return ocupado;
	}
	
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	@Override
	public String toString() {
		return new StringBuilder(Integer.toString(this.fila)).append(":").append(Integer.toString(this.asiento)).toString();
	}
	
	public String mostrarEnMatriz() {
		String cadenaRetorno="";
		if (ocupado) {
			cadenaRetorno=new StringBuilder("**").toString();
		} else {
			cadenaRetorno=new StringBuilder("--").toString();
		}
		
		return cadenaRetorno;
	}

}
