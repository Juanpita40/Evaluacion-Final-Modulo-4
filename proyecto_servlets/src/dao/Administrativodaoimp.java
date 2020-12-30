package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import idao.iadministrativodao;
import modelo.Administrativo;


public class Administrativodaoimp implements iadministrativodao {

	@Override
	public boolean registrar(Administrativo administrativo) {
		boolean registrar = false;
		
		Statement stm = null;
		Connection con = null;
		
		String sql = "INSERT INTO ADMINISTRATIVOS VALUES  ('"
				+ administrativo.getRun() +"', '"
				+ administrativo.getNombre() +"', '"
				+ administrativo.getApellidos() +"', '"
				+ administrativo.getCorreo() +"', '"
				+ administrativo.getArea() +"')";

		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			registrar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Administrativodaoimp, "
					+ "método registrar");
			e.printStackTrace();
		}
		
		return registrar;
	}

	@Override
	public List<Administrativo> obtener() {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM "
				+ "ADMINISTRATIVOS";
		List<Administrativo> listaadmi = new ArrayList<Administrativo>();
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				Administrativo admi = new Administrativo();
				admi.setRun(rs.getString(1));
				admi.setNombre(rs.getString(2));
				admi.setApellidos(rs.getString(3));
				admi.setCorreo(rs.getString(4));
				admi.setArea(rs.getString(5));
				listaadmi.add(admi);
			}
			
			rs.close();
			stm.close();
			con.close();
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Administrativodaoimp, "
					+ "método obtener");
			e.printStackTrace();
		}		
		
		return listaadmi;
	}

	@Override
	public boolean actualizar(Administrativo administrativo) {
		
		Connection con = null;
		Statement stm = null;

		boolean actualizar = false;

		String sql = "UPDATE ADMINISTRATIVOS SET "
				+ "NOMBRE = '" + administrativo.getNombre() + "', "
				+ "APELLIDOS = '" + administrativo.getApellidos() + "', "
				+ "CORREO = '" + administrativo.getCorreo() + "', "
				+ "AREA = '" + administrativo.getArea() + "' "
				+ "WHERE RUTADMI = '" + administrativo.getRun() + "'";	
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			actualizar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Administrativodaoimp, "
					+ "método actualizar");
			e.printStackTrace();
		}
		
		return actualizar;
	}

	@Override
	public boolean eliminar(Administrativo administrativo) {
		Connection con = null;
		Statement stm = null;

		boolean eliminar = false;

		String sql = "DELETE FROM ADMINISTRATIVOS "
				+ "WHERE RUTADMI = '" + administrativo.getRun() + "'";
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			eliminar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Administrativosdaoimp, "
					+ "método eliminar");
			e.printStackTrace();
		}
		
		return eliminar;
	}

	@Override
	public Administrativo obteneradmiporut(Administrativo administrativo) {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		Administrativo admi = new Administrativo();
		
		String sql = "SELECT * FROM "
				+ "ADMINISTRATIVOS WHERE RUTADMI = '" + administrativo.getRun() + "'";
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				admi.setRun(rs.getString(1));
				admi.setNombre(rs.getString(2));
				admi.setApellidos(rs.getString(3));
				admi.setCorreo(rs.getString(4));
				admi.setArea(rs.getString(5));
				
			}
			
			rs.close();
			stm.close();
			con.close();
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase AdministrativoDaoimp, "
					+ "método obteneradmiporrut");
			e.printStackTrace();
		}
		
		return admi;
	}


	
}
