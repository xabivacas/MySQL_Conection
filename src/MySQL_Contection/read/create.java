package MySQL_Contection.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class create {
	private static String HOST="localhost";
	private static String BBDD="gestor_tareas";
	private static String USER="root";
	private static String PASSWORD="";
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String titulo="";
		String descripcion="";
		
		try {
			//Cargar libreria
				Class.forName("com.mysql.cj.jdbc.Driver");
			//Crear conexion
				Connection conexion = DriverManager.getConnection("jdbc:mysql://"+HOST+"/"+BBDD,USER,PASSWORD);
			
			//Pedir datos y ejecutar query
				System.out.println("Inserte titulo");
				titulo=scan.nextLine();
				
				System.out.println("Inserte la descripcion");
				descripcion=scan.nextLine();
				
				String sql="INSERT INTO tareas(titulo, descripcion) VALUES (?,?)";
				PreparedStatement pst = conexion.prepareStatement(sql);
				pst.setString(1, titulo);
				pst.setString(2, descripcion);
				pst.execute();
				
				System.out.println("Insert completado");
				
		} catch (ClassNotFoundException e) {
			System.out.println("Error al importar liberira");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectarse a la BBDD");
			e.printStackTrace();
		}

	}

}
