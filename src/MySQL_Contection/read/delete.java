package MySQL_Contection.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class delete {
	private static String HOST="localhost";
	private static String BBDD="gestor_tareas";
	private static String USER="root";
	private static String PASSWORD="";
	
	public static void main(String[] args) {
		ArrayList<Tarea> tareas = new ArrayList<>();
		
		try {
			//Cargar libreria
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Crear conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://"+HOST+"/"+BBDD,USER,PASSWORD);
			
			//Crear Statement
			Statement st = conexion.createStatement();
			
			//Ejecutar st y recibir
			ResultSet rs = st.executeQuery("select * from tareas");
			
	
		
			while(rs.next()) {
				Tarea t = new Tarea();
				t.setId(rs.getInt("id"));
				t.setTitulo(rs.getString("titulo"));
				t.setDescripcion(rs.getString("descripcion"));
				tareas.add(t);
			}
			for(Tarea t:tareas) {
				System.out.println(t.toString());
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error al importar liberira");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectarse a la BBDD");
			e.printStackTrace();
		}

	}

}
