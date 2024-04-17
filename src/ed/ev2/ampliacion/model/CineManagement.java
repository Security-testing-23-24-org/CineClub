package ed.ev2.ampliacion.model;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.h2.tools.RunScript;

import asir.iaw.ev2.db.SqlUtilidades;
import ed.ev2.ampliacion1.vo.ButacaVo;
import ed.ev2.refuerzo.exception.CineException;

public class CineManagement {
	private Properties prop;
	private String dataBaseDriver;
	private String dataBaseURL;
	private String dataBaseUser;
	private String dataBasePass;
	private String scriptCreacionDB;
	private Connection conn; // The connection must be the same for each test-case of the class.

	public static final int FILAS = 10;
	public static final int ASIENTOS = 15;
	private static final String CINECLUB_DB_H2_SCRIPT_CREACION_DB = "cineclub.db.h2.script-creacion-db";
	private static final String CINECLUB_DB_H2_DRIVER = "cineclub.db.h2.driver";
	private static final String CINECLUB_DB_H2_URL = "cineclub.db.h2.url";
	private static final String CINECLUB_DB_H2_USER = "cineclub.db.h2.user";
	private static final String CINECLUB_DB_H2_PASSWORD = "cineclub.db.h2.password";
	private static final String CINECLUB_DB_H2_CREACION_TABLA_OCUPACION = "cineclub.db.h2.creacion-tabla-ocupacion";
	private static final String CINECLUB_DB_H2_MODIFICAR_OCUPACION_BUTACA = "cineclub.db.h2.modificar-ocupacion-butaca";
	private static final String CINECLUB_DB_H2_OBTENER_OCUPACION_BUTACA = "cineclub.db.h2.obtener-ocupacion-butaca";
	private static final String CINECLUB_DB_H2_OBTENER_CLIENTE = "cineclub.db.h2.obtener-cliente";

	public CineManagement() throws CineException {
		try {
			FileInputStream fileProperties = new FileInputStream("./Resources/Application.properties");
			prop = new Properties();
			prop.load(fileProperties);

			dataBaseDriver = prop.getProperty(CINECLUB_DB_H2_DRIVER);
			dataBaseURL = prop.getProperty(CINECLUB_DB_H2_URL);
			dataBaseUser = prop.getProperty(CINECLUB_DB_H2_USER);
			dataBasePass = prop.getProperty(CINECLUB_DB_H2_PASSWORD);
			scriptCreacionDB = prop.getProperty(CINECLUB_DB_H2_SCRIPT_CREACION_DB);

			// DB Creation by means of a script execution
			Class.forName(dataBaseDriver);
			conn = DriverManager.getConnection(dataBaseURL, dataBaseUser, dataBasePass);
			RunScript.execute(conn, new FileReader(scriptCreacionDB));
		} catch (SQLException | IOException | ClassNotFoundException e) {
			throw new CineException("ERROR en la generación de la base de datos!!!\n" + e.getMessage());
		}

//		conn.close();
	}

	public boolean reservarButaca(ButacaVo b) {
		boolean valorRetorno = false;

		try {
			String queryModificarOcupacionButaca = prop.getProperty(CINECLUB_DB_H2_MODIFICAR_OCUPACION_BUTACA);
			String queryParametrizada = SqlUtilidades.prepararQuery(queryModificarOcupacionButaca, new String[] {
					Boolean.toString(b.isOcupado()), Integer.toString(b.getFila()), Integer.toString(b.getAsiento()) });
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(queryParametrizada);
			valorRetorno = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return valorRetorno;
	}

//	public boolean verificarCredencialesCliente(String nombre, String password) {
//		boolean valorRetorno=false;
//		String nombreLeido="";
//		String passLeida="";
//		
//		try {
//			String queryObtenerCliente=prop.getProperty(CINECLUB_DB_H2_OBTENER_CLIENTE);
//			String queryParametrizada = SqlUtilidades.prepararQuery(queryObtenerCliente, new String[] {
//			nombre, password });					
//			Statement stmt=conn.createStatement();
//			ResultSet rs=stmt.executeQuery(queryParametrizada);
//			while (rs.next()) {
//				nombreLeido=rs.getString(1);
//				passLeida=rs.getString(2);
//			}
//			if (nombre.equals(nombreLeido) && password.equals(passLeida)) {
//				valorRetorno=true;
//			}			
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return valorRetorno;
//	}

	public boolean verificarCredencialesCliente(String nombre, String password) throws SQLException {
		boolean valorRetorno = false;
		String nombreLeido = "";
		String passLeida = "";

		String query = "SELECT * FROM cliente WHERE nombre = '" + nombre + "' AND pass = '" + password + "'";

		try (Statement statement = conn.createStatement()) {

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				nombreLeido = rs.getString(1);
				passLeida = rs.getString(2);
			}
			if (nombre.equals(nombreLeido) && password.equals(passLeida)) {
				valorRetorno = true;
			}
		}

		return valorRetorno;
	}

	private String prepararQuery(String q, String[] parametros) {
		StringBuilder sb = new StringBuilder(q);

		for (String parametroActual : parametros) {
			sb.replace(sb.indexOf("?"), sb.indexOf("?") + 1, parametroActual);
		}

		return sb.toString();
	}

}
