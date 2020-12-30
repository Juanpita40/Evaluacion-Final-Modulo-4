package idao;

import java.util.List;

import modelo.Profesional;



public interface iprofesionaldao {
	public boolean registrar(Profesional profesional);
	public List<Profesional> obtener();
	public boolean actualizar(Profesional profesional);
	public boolean eliminar(Profesional profesional);
	public Profesional obtenerprofporrut(Profesional profesional);
}
