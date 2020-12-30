package modelo;
/**
 * Esta es la clase Padre de la que heredan tres clases que son: Clientes, Profesionales, Administrativos
 * aca  tambien esta contenido los metodos que ingresan datos a los arrays
 * @author grupo 3 Fernando Cabrera, Jorge Navarrete, Karen Recabarren, Juvenal Colipi, Juan Lagos.
 *
 */
public abstract  class Usuario implements Asesoria{
	private String nombre;
	private String fechanacimiento;
	private String run;
	
	
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String fechanacimiento, String run) {
		super();
		this.nombre = nombre;
		this.fechanacimiento = fechanacimiento;
		this.run = run;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", fechanacimiento=" + fechanacimiento + ", run=" + run + "]";
	}
	
	/**
	 * @return Retorna la edad del usuario de la lista
	 */
	public String mostrarEdad() {
		int temp = 0;
		temp = 2020 - Integer.valueOf(this.fechanacimiento.substring(6, this.fechanacimiento.length()));

		
		return "El usuario tiene "+ temp +" años";
	}
	/**
	 * analizarUsuario()
	 * Metodo que permite imprimir el nombre y rut de la clase usuario y sera sobrescrita en las clases hijas 
	 */
	public void analizarUsuario() {
		System.out.println("El nombre del usuario es: " + nombre 
				           +"\nSu RUN es:"+ run);
	}
	/**
	 *encontrarRun()
	 *Metodo que nos permitira obtener el rut de nuestro usuario de la lista. 
	 */
	@Override
	public String encontrarRun() {
		return this.getRun();
				
	}

}
