package MySQL_Contection.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			
			//Pedir datos y ejecutar query
				System.out.println("Inserte id para borrar");
				select=scan.nextLine();
				
				String sqlRead = "select * from tareas where id= ?";
				PreparedStatement pst= conexion.prepareStatement(sqlRead);
				pst.setString(1,select);
				
				ResultSet rs = pst.executeQuery();
				
			//Mirar si hay alguien con ese id
				if(rs.next()) {
				Tarea t = new Tarea();
				t.setId(rs.getInt("id"));
				t.setTitulo(rs.getString("titulo"));
				t.setDescripcion(rs.getString("descripcion"));

				//Borrar la tupla
					String sqlDelete="DELETE FROM tareas WHERE ID= ?";
					pst= conexion.prepareStatement(sqlDelete);
					pst.setString(1,select);
					pst.execute();
					
					System.out.println(t.toString()+" Ha sido borrado");
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
