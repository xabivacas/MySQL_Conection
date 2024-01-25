package MySQL_Contection.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class read {

	private static String HOST="localhost";
	private static String BBDD="gestor_tareas";
	private static String USER="root";
	private static String PASSWORD="";
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ArrayList<Tarea> tareas = new ArrayList<>();
		String select="";
		
		try {
			//Cargar libreria
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Crear conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://"+HOST+"/"+BBDD,USER,PASSWORD);
			
			//Crear Statement
			Statement st = conexion.createStatement();
			
			System.out.println("Inserte un id");
			select=scan.nextLine();
			
			String sql ="select * from tareas where id= ?";
			PreparedStatement pst= conexion.prepareStatement(sql);
			pst.setString(1,select);
			
			//Ejecutar st y recibir
			ResultSet rs = pst.executeQuery();
			
	
		
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
