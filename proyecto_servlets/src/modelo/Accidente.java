package modelo;
/**
 * Registramos uno o muchos accidentes de Cliente.
 * @author grupo 3 Fernando Cabrera, Jorge Navarrete, Karen Recabarren, Juvenal Colipi, Juan Lagos.
 *
 */
public class Accidente extends Cliente {
	private int idaccidente;
	private int rutacc;
	private String hora;
	private String lugar;
	private String origen;
	private String consecuencias;
	
	public Accidente() {
		super();
	}

	public Accidente(int idaccidente, int rutacc, String hora, String lugar, String origen, String consecuencias) {
		super();
		this.idaccidente = idaccidente;
		this.rutacc = rutacc;
		this.hora = hora;
		this.lugar = lugar;
		this.origen = origen;
		this.consecuencias = consecuencias;
	}

	public int getIdaccidente() {
		return idaccidente;
	}

	public void setIdaccidente(int idaccidente) {
		this.idaccidente = idaccidente;
	}

	public int getRutacc() {
		return rutacc;
	}

	public void setRutacc(int rutacc) {
		this.rutacc = rutacc;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getConsecuencias() {
		return consecuencias;
	}

	public void setConsecuencias(String consecuencias) {
		this.consecuencias = consecuencias;
	}

	@Override
	public String toString() {
		return "Accidente [idaccidente=" + idaccidente + ", rutacc=" + rutacc + ", hora=" + hora + ", lugar=" + lugar
				+ ", origen=" + origen + ", consecuencias=" + consecuencias + "]";
	}
	
	
	
}
