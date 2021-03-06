package com.flor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flor.modelo.*;

public class SabanaDAO {

	private Conexion con;
	private Connection connection;
	
	public SabanaDAO (String URL, String Username, String Password) throws SQLException {
		//System.out.println(jdbcURL);
		con = new Conexion(URL, Username, Password);
	}
	
	//MOTRAR TODOS LOS DATOS DE LA SABANA
	public List<Sabana> listarSabana() throws SQLException {
	
		List<Sabana> listaSabana = new ArrayList<Sabana>();
		String sql = "SELECT * FROM sabana";
		con.con();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		
		while(resulSet.next()) {
			int clave_horario = resulSet.getInt("clave_horario");
			String clave_maestro = resulSet.getString("clave_maestro");
			String clave_materia = resulSet.getString("clave_materia");
			String clave_carrera = resulSet.getString("clave_carrera");
			String materia = resulSet.getString("materia");
			String carrera = resulSet.getString("carrera");
			String maestro = resulSet.getString("maestro");
			String periodo = resulSet.getString("periodo");
			String turno = resulSet.getString("turno");
			String grupo = resulSet.getString("grupo");
			int no_alumnos = resulSet.getInt("no_alumnos");
			int semestre = resulSet.getInt("semestre");
			int creditos = resulSet.getInt("creditos");
			String lunes = resulSet.getString("lunes");
			String martes = resulSet.getString("martes");
			String miercoles = resulSet.getString("miercoles");
			String jueves = resulSet.getString("jueves");
			String viernes = resulSet.getString("viernes");
			String salon = resulSet.getString("salon");
			int horas_t = resulSet.getInt("horas_t");
			int horas_p = resulSet.getInt("horas_p");
			Sabana sabana = new Sabana(clave_horario, clave_maestro, clave_materia, clave_carrera, materia, carrera,
					maestro,periodo, turno, grupo, no_alumnos, semestre, creditos, lunes, martes,
					miercoles, jueves, viernes, salon, horas_t, horas_p);
			listaSabana.add(sabana);
		}
		con.desconectar();
		return listaSabana;	
	}
}