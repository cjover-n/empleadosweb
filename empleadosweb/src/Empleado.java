

public class Empleado {
	
	private String nombre;
	private int id;

	public int getId() {
		return id;
	}

	public Empleado(String nombre, int id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}
	
	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Empleado ()
	{
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	

}
