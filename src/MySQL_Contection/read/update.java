package MySQL_Contection.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class update {
	private static String HOST="localhost";
	private static String BBDD="gestor_tareas";
	private static String USER="root";
	private static String PASSWORD="";
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		String id="";
		String titulo="";
		String descripcion="";
		int cont=0;
		
		try {
			//Cargar libreria
				Class.forName("com.mysql.cj.jdbc.Driver");
			//Crear conexion
				Connection conexion = DriverManager.getConnection("jdbc:mysql://"+HOST+"/"+BBDD,USER,PASSWORD);
			
			//Pedir el id de la tupla a cambiar
				System.out.println("Inserte el id de la tarea que quiere cambiar");
				id=scan.nextLine();
				
				String sqlRead = "select * from tareas where id= ?";
				PreparedStatement pst= conexion.prepareStatement(sqlRead);
				pst.setString(1,id);
				
				ResultSet rs= pst.executeQuery();
				
				if(rs.next()) {
					Tarea t = new Tarea();
					t.setId(rs.getInt("id"));
					t.setTitulo(rs.getString("titulo"));
					t.setDescripcion(rs.getString("descripcion"));
					System.out.println(t.toString());
					
				}else {
					System.out.println("Id no encontrado");
				}
				
				System.out.println("Inserte el titulo nuevo");
				titulo=scan.nextLine();
				
				System.out.println("Inserte la descripcion nueva");
				descripcion=scan.nextLine();
				
				String sqlUpdate="UPDATE tareas SET titulo= ? ,descripcion= ? WHERE id= ?";
				pst.setString(1, titulo);
				System.out.println("Se han modificado: "+cont);
				
		} catch (ClassNotFoundException e) {
			System.out.println("Error al importar liberira");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectarse a la BBDD");
			e.printStackTrace();
		}

	}

}
