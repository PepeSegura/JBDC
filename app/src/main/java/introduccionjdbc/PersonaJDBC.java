package introduccionjdbc;

import java.sql.*;
import java.util.*;

import introduccionjdbc.datos.Persona;

public class PersonaJDBC {

	private final String SQL_INSERT = "INSERT INTO persona(nombre,apellido)values(?,?)";
	private final String SQL_UPDATE = "UPDATE persona set nombre=?,apellido=? where id_persona=?";
	private final String SQL_DELETE = "DELETE FROM persona where id_persona=?";
	private final String SQL_SELECT = "SELECT id_persona,nombre,apellido FROM persona ORDER BY id_persona";

	public int insert(String nombre, String apellido) {

		int rows = 0;
		try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);) {
			int index = 1;
			stmt.setString(index++, nombre);
			stmt.setString(index++, apellido);
			System.out.println("Ejecuantado:insert");
			rows = stmt.executeUpdate();
			System.out.println("Registros afectados: " + rows);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return rows;

	}

	public int update(int id_persona, String nombre, String apellido) {

		int rows = 0;
		try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);) {
			int index = 1;
			stmt.setString(index++, nombre);
			stmt.setString(index++, apellido);
			stmt.setInt(index++, id_persona);
			System.out.println("Ejecuantado:update");
			rows = stmt.executeUpdate();
			System.out.println("Registros afectados: " + rows);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return rows;

	}

	public int delete(int id_persona) {

		int rows = 0;
		try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);) {

			stmt.setInt(1, id_persona);
			System.out.println("Ejecuantado:delete");
			rows = stmt.executeUpdate();
			System.out.println("Registros afectados: " + rows);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return rows;

	}

	public List<Persona> select() {
		List<Persona> personas = new ArrayList<>();
		Persona persona = null;

		try (Connection conn = Conexion.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				persona = new Persona();
				int index = 1;
				persona.setId_persona(rs.getInt(index++));
				persona.setNombre(rs.getString(index++));
				persona.setApellido(rs.getString(index++));
				personas.add(persona);
			}
			System.out.println("Ejecuantado:select");

		} catch (Exception e) {

			e.printStackTrace();
		}
		return personas;

	}

	// etc...

}
