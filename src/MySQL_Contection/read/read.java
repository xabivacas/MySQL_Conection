package MySQL_Contection.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class read {

	public static void main(String[] args) {
		String host="localhost";
		String BBDD="gestor_tareas";
		String user="root";
		String password="";
		
		try {
			//Cargar libreria
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Crear conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://"+host+"/"+BBDD,user,password);
			
			//Crear Statement
			Statement st = conexion.createStatement();
			
			//Ejecutar st y recibir
			ResultSet rs = st.executeQuery("select * from tareas");
			
			while(rs.next()) {
				Tarea t = new Tarea();
				t.setId(rs.getInt("id"));
				t.setTitulo(rs.getString("titulo"));
				t.setDescripcion(rs.getString("descripcion"));
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
