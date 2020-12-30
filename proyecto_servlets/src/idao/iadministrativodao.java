package idao;

import java.util.List;

import modelo.Administrativo;


public interface iadministrativodao {
	public boolean registrar(Administrativo administrativo);
	public List<Administrativo> obtener();
	public boolean actualizar(Administrativo administrativo);
	public boolean eliminar(Administrativo administrativo);
	public Administrativo obteneradmiporut(Administrativo administrativo);
}
