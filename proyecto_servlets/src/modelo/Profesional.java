package modelo;
/**
 * Clase hija de usuario en la cual establecemmos los atributos del perfil que hereda usuario.
 * @author grupo 3 Fernando Cabrera, Jorge Navarrete, Karen Recabarren, Juvenal Colipi, Juan Lagos.
 *
 */
public class Profesional extends Usuario {
	private String titulo;
	private String fechaingreso;
	private String telefono;
	private String apellido;
	private String proyecto;
	
	
	public Profesional() {
		super();
	}


	public Profesional(String titulo, String fechaingreso,String nombre, String fechanacimiento, String run, String telefono, String apellido, String proyecto) {
		super(nombre, fechanacimiento, run);
		this.titulo = titulo;
		this.fechaingreso = fechaingreso;
		this.telefono = telefono;
		this.apellido = apellido;
		this.proyecto = proyecto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(String fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getProyecto() {
		return proyecto;
	}


	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}


	@Override
	public String toString() {
		return "Profesional [titulo=" + titulo + ", fechaingreso=" + fechaingreso + "]";
	}

	@Override
	public void analizarUsuario() {
		System.out.println("El nombre del profesional es: " + this.getNombre()
						  +"\nSu titulo es: "+ titulo + " y su Fecha de ingreso es: "+ fechaingreso );
	}
	/**
	 *Retorna los atributos del padre para mostrar en la lista de usuarios.
	 */
	public String mostrarusuario() {
		return "El nombre del usuario es: " + this.getNombre()
		           +"\nSu RUN es:"+ this.getRun();
	}
}
