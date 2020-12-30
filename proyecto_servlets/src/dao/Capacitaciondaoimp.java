package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import conexion.Conexion;
import idao.icapacitaciondao;
import modelo.Capacitacion;

public class Capacitaciondaoimp implements icapacitaciondao {

	@Override
	public boolean registrar(Capacitacion capacitacion) {
		boolean registrar = false;
		
		Statement stm = null;
		Connection con = null;
		
		String sql = "INSERT INTO CAPACITACION (FECHA, HORA, LUGAR, DURACION, cantidadasistentes,cliente_rutcliente ) VALUES  (TO_DATE('"
				+ capacitacion.getDia() +"','dd/mm/yy'),to_date('" 
				+ capacitacion.getHora() + "','hh24:mi'), '"
				+ capacitacion.getLugar() +"', '"
				+ capacitacion.getDuracion() +"', '"
				+ capacitacion.getCantasist() + "', "
				+ capacitacion.getRutclte() +")";
				
//				"INSERT INTO CAPACITACION values ('" 
//				+ capacitacion.getDia() + "','"
//				+ capacitacion.getHora() + "','" 
//				+ capacitacion.getLugar() + "','"
//				+ capacitacion.getDuracion() + "','"
//				+ capacitacion.getCantasist() + "','"
//				+ capacitacion.getRutclte() + "')";

		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			registrar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Capacitaciondaoimp, "
					+ "método registrar");
			e.printStackTrace();
		}
		
		return registrar;
	}

	@Override
	public List<Capacitacion> obtener() {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM "
				+ "CAPACITACION ORDER BY IDCAPACITACION";
		List<Capacitacion> listaCapa = new ArrayList<Capacitacion>();
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				Capacitacion c = new Capacitacion();
				c.setIdcapa(rs.getInt(1));
				c.setDia(rs.getString(2));
				c.setHora(rs.getString(3));
				c.setLugar(rs.getString(4));
				c.setDuracion(rs.getInt(5));
				c.setCantasist(rs.getInt(6));
				c.setRutclte(rs.getInt(7));
				listaCapa.add(c);
			}
			
			rs.close();
			stm.close();
			con.close();
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Capacitaciondaoimp, "
					+ "método obtener");
			e.printStackTrace();
		}		
		
		return listaCapa;
	}

	@Override
	public boolean actualizar(Capacitacion capacitacion) {
		
		Connection con = null;
		Statement stm = null;

		boolean actualizar = false;

		String sql = "UPDATE CAPACITACION SET "
				+ "FECHA = to_date('" + capacitacion.getDia() + "','dd/mm/yy'), "
				+ "HORA = to_date('" + capacitacion.getHora() + "','hh24:mi'), "
				+ "LUGAR = '" + capacitacion.getLugar() + "', "
				+ "DURACION = '" + capacitacion.getDuracion() + "', "
				+ "CANTIDADASISTENTES = '" + capacitacion.getCantasist() + "', "
				+ "CLIENTE_RUTCLIENTE = '" + capacitacion.getRutclte() + "' "
				+ "WHERE IDCAPACITACION = '" + capacitacion.getIdcapa() + "'";
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			actualizar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Capacitaciondaoimp, "
					+ "método actualizar");
			e.printStackTrace();
		}
		
		return actualizar;
	}

	@Override
	public boolean eliminar(Capacitacion capacitacion) {
		Connection con = null;
		Statement stm = null;

		boolean eliminar = false;

		String sql = "DELETE FROM CAPACITACION "
				+ "WHERE IDCAPACITACION = '" + capacitacion.getIdcapa() + "'";
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			eliminar = true;
			stm.close();
			con.close();			
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase Capacitaciondaoimp, "
					+ "método eliminar");
			e.printStackTrace();
		}
		
		return eliminar;
	}

	@Override
	public Capacitacion obtenercapaporid(Capacitacion capacitacion) {
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		Capacitacion c = new Capacitacion();
		
		String sql = "SELECT * FROM "
				+ "CAPACITACION WHERE IDCAPACITACION = '" + capacitacion.getIdcapa() + "'";
		
		try {
			con = Conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				c.setIdcapa(rs.getInt(1));
				c.setDia(rs.getString(2));
				c.setHora(rs.getString(3));
				c.setLugar(rs.getString(4));
				c.setDuracion(rs.getInt(5));
				c.setCantasist(rs.getInt(6));
				c.setRutclte(rs.getInt(7));
			}
			
			rs.close();
			stm.close();
			con.close();
		}catch(SQLException e) {
			System.out.println("Error: "
					+ "Clase CapacitacionDaoimp, "
					+ "método obtenercapaporid");
			e.printStackTrace();
		}
		
		return c;
	}

}
