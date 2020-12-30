package idao;

import java.util.List;

import modelo.Usuario;

public interface iusuariodao {
	
	public boolean registrar(Usuario usuario);
	public List<Usuario> obtener();
	public boolean actualizar(Usuario usuario);
	public boolean eliminar(Usuario usuario);
	public Usuario obtenerusuarioporrun(Usuario usuario);

}
