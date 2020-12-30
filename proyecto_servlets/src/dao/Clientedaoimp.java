package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import idao.iclientedao;
import modelo.Cliente;

public class Clientedaoimp implements iclientedao {

	@Override
	public boolean registrar(Cliente cliente) {
		boolean registrar = false;
		
		Statement stm = null;
		Connection con = null;
		
		String sql = "INSERT INTO CLIENTE VALUES ('"
				+ cliente.getRun() + "', '"
				+ cliente.getNombre() + "', '"
				+ cliente.getApellidos() +"', '"
				+ cliente.getTelefono() +"', '"
				+ cliente.getAfp() + "', "
				+ cliente.getPrevision() + ", '"
				+ cliente.getDireccion() + "', '"
				+ cliente.getComuna() + "', "
				+ cliente.getEdad()+")";

		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			registrar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Clientedaoimp, "
					+ "método registrar");
			e.printStackTrace();
		}
		
		return registrar;
	}

	@Override
	public List<Cliente> obtener() {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM "
				+ "CLIENTE ORDER BY RUTCLIENTE";
		List<Cliente> listaCliente 
			= new ArrayList<Cliente>();
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				Cliente clte = new Cliente();
				clte.setRun(rs.getString(1));
				clte.setNombre(rs.getString(2));
				clte.setApellidos(rs.getString(3));
				clte.setTelefono(rs.getString(4));
				clte.setAfp(rs.getString(5));
				clte.setPrevision(rs.getInt(6));
				clte.setDireccion(rs.getString(7));
				clte.setComuna(rs.getString(8));
				clte.setEdad(rs.getInt(9));
				
				listaCliente.add(clte);
			}
			
			rs.close();
			stm.close();
			con.close();
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Clientedaoimp, "
					+ "método obtener");
			e.printStackTrace();
		}		
		
		return listaCliente;

}

	@Override
	public boolean actualizar(Cliente cliente) {
		
		Connection con = null;
		Statement stm = null;

		boolean actualizar = false;

		String sql = "UPDATE CLIENTE SET "
				+ "RUTCLIENTE = '" + cliente.getRun() + "', "
				+ "NOMBRES = '" + cliente.getNombre() + "', "
				+ "APELLIDOS = '" + cliente.getApellidos() + "', "
				+ "TELEFONO = '" + cliente.getTelefono() + "', "
				+ "AFP = '" + cliente.getAfp() + "', "
				+ "SISTEMASALUD = '" + cliente.getPrevision() + "', "
				+ "DIRECCION = '" + cliente.getDireccion() + "', "
				+ "COMUNA = '" + cliente.getComuna() + "', "
				+ "EDAD = '" + cliente.getEdad() + "', ";
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			actualizar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Clinetedaoimp, "
					+ "método actualizar");
			e.printStackTrace();
		}
		
		return actualizar;
	}

	@Override
	public boolean eliminar(Cliente cliente) {
		Connection con = null;
		Statement stm = null;

		boolean eliminar = false;

		String sql = "DELETE FROM CLIENTE "
				+ "WHERE RUTCLIENTE = '" + cliente.getRun() + "'";
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			eliminar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Clientedaoimp, "
					+ "método eliminar");
			e.printStackTrace();
		}
		
		return eliminar;
	}

	@Override
	public Cliente obtenerclienteporrun(Cliente cliente) {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		Cliente clte = new Cliente();
		
		String sql = "SELECT * FROM "
				+ "CLIENTE WHERE RUTCLIENTE = " + cliente.getRutclte()+"";
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				clte.setRun(rs.getString(1));
				clte.setNombre(rs.getString(2));
				clte.setApellidos(rs.getString(3));
				clte.setTelefono(rs.getString(4));
				clte.setAfp(rs.getString(5));
				clte.setPrevision(rs.getInt(6));
				clte.setDireccion(rs.getString(7));
				clte.setComuna(rs.getString(8));
				clte.setEdad(rs.getInt(9));
			}
			
			rs.close();
			stm.close();
			con.close();
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase ClientenDaoimp, "
					+ "método obtenerclienteporrut");
			e.printStackTrace();
		}
		
		return clte;
	}
	
}
