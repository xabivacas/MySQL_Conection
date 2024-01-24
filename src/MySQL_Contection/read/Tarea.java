package MySQL_Contection.read;

public class Tarea {
	private int id;
	private String titulo;
	private String descripcion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String toString() {
		return "Tarea: "+this.id+", "+this.titulo+", "+this.descripcion;
		
	}
	
}
