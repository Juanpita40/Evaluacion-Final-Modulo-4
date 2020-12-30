package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import idao.iprofesionaldao;
import modelo.Profesional;

public class Profesionaldaoimp implements iprofesionaldao {

	@Override
	public boolean registrar(Profesional profesional) {
		boolean registrar = false;
		
		Statement stm = null;
		Connection con = null;
		
		String sql = "INSERT INTO PROFESIONALES VALUES  ('"
				+ profesional.getRun() +"', '"
				+ profesional.getNombre() +"', '"
				+ profesional.getApellido() +"', '"
				+ profesional.getTelefono() +"', '"
				+ profesional.getTitulo() +"', '"
				+ profesional.getProyecto() +"')";

		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			registrar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Profesionaldaoimp, "
					+ "método registrar");
			e.printStackTrace();
		}
		
		return registrar;
	}

	@Override
	public List<Profesional> obtener() {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM "
				+ "PROFESIONALES";
		List<Profesional> listaprof = new ArrayList<Profesional>();
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				Profesional prof = new Profesional();
				prof.setRun(rs.getString(1));
				prof.setNombre(rs.getString(2));
				prof.setApellido(rs.getString(3));
				prof.setTelefono(rs.getString(4));
				prof.setTitulo(rs.getString(5));
				prof.setProyecto(rs.getString(6));
				listaprof.add(prof);
			}
			
			rs.close();
			stm.close();
			con.close();
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Profesionaldaoimp, "
					+ "método obtener");
			e.printStackTrace();
		}		
		
		return listaprof;
	}

	@Override
	public boolean actualizar(Profesional profesional) {
		
		Connection con = null;
		Statement stm = null;

		boolean actualizar = false;

		String sql = "UPDATE PROFESIONALES SET "
				+ "NOMBRE = '" + profesional.getNombre() + "', "
				+ "APELLIDOS = '" + profesional.getApellido() + "', "
				+ "TELEFONO = '" + profesional.getTelefono() + "', "
				+ "TITULO = '" + profesional.getTitulo() + "', "
				+ "PROYECTO = '" + profesional.getProyecto() + "' "
				+ "WHERE RUTPROF = '" + profesional.getRun() + "'";	
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			actualizar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Profesionaldaoimp, "
					+ "método actualizar");
			e.printStackTrace();
		}
		
		return actualizar;
	}

	@Override
	public boolean eliminar(Profesional profesional) {
		Connection con = null;
		Statement stm = null;

		boolean eliminar = false;

		String sql = "DELETE FROM PROFESIONALES "
				+ "WHERE RUTPROF = '" + profesional.getRun() + "'";
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			eliminar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Profesionaldaoimp, "
					+ "método eliminar");
			e.printStackTrace();
		}
		
		return eliminar;
	}

	@Override
	public Profesional obtenerprofporrut(Profesional profesional) {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		Profesional prof = new Profesional();
		
		String sql = "SELECT * FROM "
				+ "PROFESIONALES WHERE RUTPROF = '" + profesional.getRun() + "'";
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				prof.setRun(rs.getString(1));
				prof.setNombre(rs.getString(2));
				prof.setApellido(rs.getString(3));
				prof.setTelefono(rs.getString(4));
				prof.setTitulo(rs.getString(5));
				prof.setProyecto(rs.getString(6));
				
			}
			
			rs.close();
			stm.close();
			con.close();
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase ProfesionalDaoimp, "
					+ "método obtenerprofporrut");
			e.printStackTrace();
		}
		
		return prof;
	}

}
