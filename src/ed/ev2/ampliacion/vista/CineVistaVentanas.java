package ed.ev2.ampliacion.vista;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ed.ev2.ampliacion1.vo.ButacaVo;
import ed.ev2.ampliacion1.vo.EstadisticasVo;
import ed.ev2.refuerzo.controller.CineController;
import ed.ev2.refuerzo.exception.CineException;

public class CineVistaVentanas  implements ActionListener {

	
	
	    private JFrame vp;
	    private JButton mostrarOcupacionBtn;
	    private JButton comprarEntradaBtn;
	    private JButton devolverEntradaBtn;
	    private JButton salirBtn;
	    private JTextArea ocupacionTextArea;
	    // Datos compra butaca
		private JLabel msgComprarEntradaLabel;
		private JLabel filaLabel;
		private JTextField filaTextField;
		private JLabel asientoLabel;
		private JTextField asientoTextField;
		private JButton compraBtn;
		private JButton cancelarCompraBtn;
	    // Datos devolver butaca
		private JButton devolverBtn;
		// Defensa de la práctica -INICIO
//	    private JButton mostrarEstadisticasBtn;
//	    private JLabel butacasOcupadasLabel;
//	    private JLabel butacasVaciasLabel;
//	    private JLabel cantidadButacasOcupadasLabel;
//	    private JLabel cantidadButacasVaciasLabel;
		// Defensa de la práctica -FIN		
	    
	    
	    private CineController cineController;
	    

	    public CineVistaVentanas(){
	        vp=new JFrame();
	        vp.setTitle("Cine Club");
	        	        
	        mostrarOcupacionBtn = new JButton();
	        comprarEntradaBtn = new JButton();
	        devolverEntradaBtn = new JButton();
	        salirBtn = new JButton();
	        ocupacionTextArea = new JTextArea();
	        msgComprarEntradaLabel = new JLabel("Introduce la fila y el asiento de la butaca");
	        filaLabel = new JLabel("Fila");
	        filaTextField = new JTextField();
	        asientoLabel = new JLabel("asiento");
	        asientoTextField = new JTextField();
	        compraBtn=new JButton();
	        devolverBtn=new JButton();
	        cancelarCompraBtn=new JButton();
			// Defensa de la práctica -INICIO
//	        mostrarEstadisticasBtn=new JButton();
//	        butacasOcupadasLabel=new JLabel();
//	        butacasVaciasLabel=new JLabel();
//	        cantidadButacasOcupadasLabel=new JLabel();
//	        cantidadButacasVaciasLabel=new JLabel();
			// Defensa de la práctica -FIN	        	        
	        
	    }

	    public void mostrar(){
	        vp.setBounds(300, 90, 900, 600);
	        vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        vp.setResizable(false);
	        vp.setLayout(null);

	        // Botón Mostrar ocupacion
	        mostrarOcupacionBtn.setText("Mostrar ocupacion");
	        mostrarOcupacionBtn.setFont(new Font("Arial", Font.PLAIN, 15));
	        mostrarOcupacionBtn.setSize(160, 25);
	        mostrarOcupacionBtn.setLocation(80, 50);
	        mostrarOcupacionBtn.addActionListener(this);

	        // Botón Comprar entrada
	        comprarEntradaBtn.setText("Comprar entrada");
	        comprarEntradaBtn.setFont(new Font("Arial", Font.PLAIN, 15));
	        comprarEntradaBtn.setSize(150, 25);
	        comprarEntradaBtn.setLocation(250, 50);
	        comprarEntradaBtn.addActionListener(this);

	        // Botón Devolver entrada
	        devolverEntradaBtn.setText("Devolver entrada");
	        devolverEntradaBtn.setFont(new Font("Arial", Font.PLAIN, 15));
	        devolverEntradaBtn.setSize(160, 25);
	        devolverEntradaBtn.setLocation(410, 50);
	        devolverEntradaBtn.addActionListener(this);
	        
			// Defensa de la práctica -INICIO	        
	        // Botón estadísticas
//	        mostrarEstadisticasBtn.setText("Estadísticas");
//	        mostrarEstadisticasBtn.setFont(new Font("Arial", Font.BOLD, 18));
//	        mostrarEstadisticasBtn.setSize(160, 25);
//	        mostrarEstadisticasBtn.setLocation(580, 50);
//	        mostrarEstadisticasBtn.addActionListener(this);
//
//	        butacasOcupadasLabel.setSize(120, 20);
//	        butacasOcupadasLabel.setLocation(270, 180);
//	        butacasOcupadasLabel.setText("Butacas ocupadas:");
//	        butacasOcupadasLabel.setVisible(false);
//
//	        butacasVaciasLabel.setSize(120, 20);
//	        butacasVaciasLabel.setLocation(270, 210);
//	        butacasVaciasLabel.setText("Butacas vacias:");
//	        butacasVaciasLabel.setVisible(false);
//
//	        cantidadButacasOcupadasLabel.setSize(50, 20);
//	        cantidadButacasOcupadasLabel.setLocation(390, 180);
//	        cantidadButacasOcupadasLabel.setVisible(false);
//
//	        cantidadButacasVaciasLabel.setSize(50, 20);
//	        cantidadButacasVaciasLabel.setLocation(390, 210);
//	        cantidadButacasVaciasLabel.setVisible(false);				        
			// Defensa de la práctica -FIN
	        
	        // Botón Salida
	        salirBtn.setText("Salir");
	        salirBtn.setFont(new Font("Arial", Font.PLAIN, 15));
	        salirBtn.setSize(80, 25);
	        salirBtn.setLocation(750, 50);
	        salirBtn.addActionListener(this);
	        
	        // Ocupación
	        ocupacionTextArea.setFont(new Font("Arial", Font.PLAIN, 15));
	        ocupacionTextArea.setSize(350, 350);
	        ocupacionTextArea.setLocation(250, 130);
	        ocupacionTextArea.setLineWrap(true);
	        ocupacionTextArea.setEditable(false);
	        ocupacionTextArea.setVisible(false);
	        	        
	        // Pedir datos butaca
	        msgComprarEntradaLabel.setSize(250, 20);
			msgComprarEntradaLabel.setLocation(250, 150);
			msgComprarEntradaLabel.setVisible(false);
			filaLabel.setSize(50, 20);
			filaLabel.setLocation(270, 180);
			filaLabel.setVisible(false);
			filaTextField.setSize(150, 25);
			filaTextField.setLocation(320, 180);
			filaTextField.setVisible(false);
			asientoLabel.setSize(50, 20);
			asientoLabel.setLocation(270, 210);
			asientoLabel.setVisible(false);
			asientoTextField.setSize(150, 25);
			asientoTextField.setLocation(320, 210);
			asientoTextField.setVisible(false);
			compraBtn.setSize(100, 35);
			compraBtn.setLocation(280 , 250);
			compraBtn.setText("Comprar");
			compraBtn.setVisible(false);
			compraBtn.addActionListener(this);
			
			devolverBtn.setSize(100, 35);
			devolverBtn.setLocation(280 , 250);
			devolverBtn.setText("Devolver");
			devolverBtn.setVisible(false);
			devolverBtn.addActionListener(this);

			cancelarCompraBtn.setSize(100, 35);
			cancelarCompraBtn.setLocation(400, 250);
			cancelarCompraBtn.setText("Cancelar");
			cancelarCompraBtn.setVisible(false);
			cancelarCompraBtn.addActionListener(this);
	        
	        vp.add(mostrarOcupacionBtn); vp.add(comprarEntradaBtn);
	        vp.add(devolverEntradaBtn); 
			// Defensa de la práctica -INICIO	        
//	        vp.add(mostrarEstadisticasBtn);
//	        vp.add(butacasOcupadasLabel); vp.add(butacasVaciasLabel);
//	        vp.add(cantidadButacasOcupadasLabel); vp.add(cantidadButacasVaciasLabel);
			// Defensa de la práctica -FIN	        
	        vp.add(salirBtn);
	        vp.add(ocupacionTextArea);
	        vp.add(msgComprarEntradaLabel);
	        vp.add(filaLabel);vp.add(filaTextField);vp.add(asientoLabel);
	        vp.add(asientoTextField); vp.add(compraBtn);
	        vp.add(cancelarCompraBtn); vp.add(devolverBtn);
	        
	        vp.setVisible(true);                
	    }

	    public void actionPerformed(ActionEvent e){
			if (e.getSource() == mostrarOcupacionBtn) {
				
//		        butacasOcupadasLabel.setVisible(false);
//		        butacasVaciasLabel.setVisible(false);
//		        cantidadButacasOcupadasLabel.setVisible(false);
//		        cantidadButacasVaciasLabel.setVisible(false);
				
				ocupacionTextArea.setVisible(true);
				ocupacionTextArea.setText("");
//				ocupacionTextArea.setText(cineController.mostrarOcupacion());
			} else if ((e.getSource() == comprarEntradaBtn) || (e.getSource() == devolverEntradaBtn)) {
//		        butacasOcupadasLabel.setVisible(false);
//		        butacasVaciasLabel.setVisible(false);
//		        cantidadButacasOcupadasLabel.setVisible(false);
//		        cantidadButacasVaciasLabel.setVisible(false);
				
				ocupacionTextArea.setVisible(false);
				msgComprarEntradaLabel.setVisible(true);
				filaLabel.setVisible(true);
				filaTextField.setText("");				
				filaTextField.setVisible(true);
				asientoLabel.setVisible(true);
				asientoTextField.setText("");				
				asientoTextField.setVisible(true);
				if (e.getSource() == comprarEntradaBtn) {
					compraBtn.setVisible(true);
				} else {
					devolverBtn.setVisible(true);
				}
				cancelarCompraBtn.setVisible(true);						
			} else if ((e.getSource() == compraBtn) || (e.getSource() == devolverBtn)) {
//		        butacasOcupadasLabel.setVisible(false);
//		        butacasVaciasLabel.setVisible(false);
//		        cantidadButacasOcupadasLabel.setVisible(false);
//		        cantidadButacasVaciasLabel.setVisible(false);

				ButacaVo butacaParaReservar=new ButacaVo();
				butacaParaReservar.setFila(Integer.valueOf(filaTextField.getText()));
				butacaParaReservar.setAsiento(Integer.valueOf(asientoTextField.getText()));
				if (e.getSource() == compraBtn) {
					if (cineController.reservarButaca(butacaParaReservar)) {
						JOptionPane.showMessageDialog(vp, "La butaca ha sido reservada correctamente");
					} else {
						JOptionPane.showMessageDialog(vp, "Error en la reserva de la butaca");					
					}
				} else {
//					if (cineController.devolverButaca(butacaParaReservar)) {
//						JOptionPane.showMessageDialog(vp, "La butaca ha sido devuelta correctamente");
//					} else {
//						JOptionPane.showMessageDialog(vp, "Error en la devolución de la butaca");					
//					}					
				}				
				msgComprarEntradaLabel.setVisible(false);
				filaLabel.setVisible(false);
				filaTextField.setVisible(false);
				asientoLabel.setVisible(false);
				asientoTextField.setVisible(false);
				compraBtn.setVisible(false);
				devolverBtn.setVisible(false);
				cancelarCompraBtn.setVisible(false);				
			} else if (e.getSource() == cancelarCompraBtn){
				
//		        butacasOcupadasLabel.setVisible(false);
//		        butacasVaciasLabel.setVisible(false);
//		        cantidadButacasOcupadasLabel.setVisible(false);
//		        cantidadButacasVaciasLabel.setVisible(false);
				
				msgComprarEntradaLabel.setVisible(false);
				filaLabel.setVisible(false);
				filaTextField.setVisible(false);
				asientoLabel.setVisible(false);
				asientoTextField.setVisible(false);
				compraBtn.setVisible(false);
				devolverBtn.setVisible(false);
				cancelarCompraBtn.setVisible(false);
			} else if (e.getSource() == salirBtn) {
				vp.dispatchEvent(new  WindowEvent(vp, WindowEvent.WINDOW_CLOSING));				
			}
			// Defensa de la práctica -INICIO	        
//			else if (e.getSource() == mostrarEstadisticasBtn) {
//				ocupacionTextArea.setVisible(false);
//				filaLabel.setVisible(false);
//				filaTextField.setVisible(false);
//				asientoLabel.setVisible(false);
//				asientoTextField.setVisible(false);
//				compraBtn.setVisible(false);
//				devolverBtn.setVisible(false);
//				cancelarCompraBtn.setVisible(false);				
//				
//				
//		        butacasOcupadasLabel.setVisible(true);
//		        butacasVaciasLabel.setVisible(true);
//		        
//		        EstadisticasVo estadisticas=cineController.calcularEstadisticas();
//		        
//		        cantidadButacasOcupadasLabel.setVisible(true);
//		        cantidadButacasOcupadasLabel.setText(Integer.toString(estadisticas.getButacasOcupadas()));
//		        cantidadButacasVaciasLabel.setVisible(true);
//		        cantidadButacasVaciasLabel.setText(Integer.toString(estadisticas.getButacasLibres()));		        		        
//			}
			// Defensa de la práctica -FIN	        

		}

		public CineController getCineController() {
			return cineController;
		}

		public void setCineController(CineController cineController) {
			this.cineController = cineController;
		}
	    
//		public String mostrarOcupacion(String[][] matrizOcupacion) {
//			StringBuilder cadenaOcupacion=new StringBuilder();
//			cadenaOcupacion.append("\n\n\n\n").append("           ");
//			for (int i=0; i<CineController.FILAS; i++) {
//				for (String s:matrizOcupacion[i]) {
//					cadenaOcupacion.append(s).append("  ");
//				}
//				cadenaOcupacion.append("\n").append("           ");
//			}
//			return cadenaOcupacion.toString();
//		}
	   
}
