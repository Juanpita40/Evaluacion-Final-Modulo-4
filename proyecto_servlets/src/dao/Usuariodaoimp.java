package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import conexion.Conexion;
import idao.iusuariodao;
import modelo.Usuario;

public class Usuariodaoimp implements iusuariodao {

	@Override
	public boolean registrar(Usuario usuario) {
		boolean registrar = false;
		
		Statement stm = null;
		Connection con = null;
		
//		String sql = "INSERT INTO CAPACITACION values ('" 
//						+ capacitacion.getDia() + "','"
//						+ capacitacion.getHora() + "','" 
//						+ capacitacion.getLugar() + "','"
//						+ capacitacion.getDuracion() + "','"
//						+ capacitacion.getCantasist() + "','"
//						+ capacitacion.getRutclte() + "')";

		try {
			con = Conexion.conectar();
			stm = con.createStatement();
//			stm.execute(sql);
			registrar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Usuariodaoimp, "
					+ "método registrar");
			e.printStackTrace();
		}
		
		return registrar;
	}

	@Override
	public List<Usuario> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario obtenerusuarioporrun(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
