package ed.ev2.ampliacion.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ed.ev2.refuerzo.controller.CineController;
import ed.ev2.refuerzo.exception.CineException;
import javax.swing.SwingConstants;

public class LoginView extends JFrame implements ActionListener {

	private static final String CREDENCIALES_PASS = "Cuaccuac";
	private static final String CREDENCIALES_NOMBRE = "Duffyduck";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JPasswordField txtPassword;
	private JButton btnEnviar;
	private JButton btnCancelar;
	private JLabel lblMsg;
    private CineController cineController;

	/*
	 * Esto es un comentario javaDoc
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 238, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textNombre = new JTextField();
		textNombre.setName("");
		textNombre.setBounds(153, 83, 114, 19);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(153, 114, 115, 19);
		contentPane.add(txtPassword);

		btnEnviar = new JButton("Login");
		btnEnviar.setBounds(80, 154, 117, 25);
		contentPane.add(btnEnviar);
		btnEnviar.addActionListener(this);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(228, 154, 117, 25);
		contentPane.add(btnCancelar);

		lblMsg = new JLabel("");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setVisible(false);
		lblMsg.setBounds(80, 190, 265, 15);
		contentPane.add(lblMsg);
		
		JLabel lblEncabezado = new JLabel("CINECLUB");
		lblEncabezado.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEncabezado.setBounds(153, 11, 103, 27);
		contentPane.add(lblEncabezado);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(80, 86, 69, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(77, 117, 70, 14);
		contentPane.add(lblContrasea);
		btnCancelar.addActionListener(this);
		
        try {
			cineController=new CineController();
		} catch (CineException e) {
			e.printStackTrace();
		}		
	}

	/*
	 * esto es un comentario de varias lineas
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviar) {
			String nombreStr = this.textNombre.getText();
			String passStr = new String(this.txtPassword.getPassword());
			if (this.validarEntradas(nombreStr, passStr) && cineController.verificarCredencialesCliente(nombreStr, passStr)) {
				CineVistaVentanas ventanaCine = new CineVistaVentanas();
				ventanaCine.setCineController(cineController);
				ventanaCine.mostrar();
				this.dispose();
			} else {
				lblMsg.setForeground(Color.RED);
				lblMsg.setText("Credenciales incorrectas");
				lblMsg.setVisible(true);
			}
		} else if (e.getSource() == btnCancelar) {
			this.dispose();
		}
	}

	private boolean validarEntradas(String nombre, String pass) {
		return (((nombre!=null) && !(nombre.equals(""))) && ((pass!=null) && !(pass.equals(""))));
	}
}
