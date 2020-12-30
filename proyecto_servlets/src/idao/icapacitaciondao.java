package idao;

import java.util.List;

import modelo.Capacitacion;



public interface icapacitaciondao {
	
	public boolean registrar(Capacitacion capacitacion);
	public List<Capacitacion> obtener();
	public boolean actualizar(Capacitacion capacitacion);
	public boolean eliminar(Capacitacion capacitacion);
	public Capacitacion obtenercapaporid(Capacitacion cliente);
}
