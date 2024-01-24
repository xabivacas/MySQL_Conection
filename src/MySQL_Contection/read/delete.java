package MySQL_Contection.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class delete {
	private static String HOST="localhost";
	private static String BBDD="gestor_tareas";
	private static String USER="root";
	private static String PASSWORD="";
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String select="";
		
		try {
			//Cargar libreria
				Class.forName("com.mysql.cj.jdbc.Driver");
			//Crear conexion
				Connection conexion = DriverManager.getConnection("jdbc:mysql://"+HOST+"/"+BBDD,USER,PASSWORD);
			
			//Crear Statement
				Statement st = conexion.createStatement();
			
			//Pedir datos y ejecutar query
				System.out.println("Inserte id para borrar");
				select=scan.nextLine();
				ResultSet rs = st.executeQuery("select * from tareas where id="+select);
				
			//Mirar si hay alguien con ese id
				if(rs.next()) {
				Tarea t = new Tarea();
				t.setId(rs.getInt("id"));
				t.setTitulo(rs.getString("titulo"));
				t.setDescripcion(rs.getString("descripcion"));
			
				//Borrar la tupla
					st.execute("DELETE FROM tareas WHERE ID="+select);
					System.out.println(t.toString()+" ha sido eliminado");
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
