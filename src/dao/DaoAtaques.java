package dao;

import java.sql.*;
import java.util.ArrayList;
import model.*;

public class DaoAtaques {
	private Connection conn = null;
	private static DaoAtaques instance = null;

	public DaoAtaques() throws SQLException {
		
		conn = DbConnection.getConnection();
	}
	
	public static DaoAtaques getInstance() throws SQLException{
		
		if(instance == null) {
			instance = new DaoAtaques();
		}
		return instance;
	}
	
	/**
	 * Recupera todos los nombres de ataques asociados a un personaje,
	 * incluyendo los ataques por defecto según su tipo y nombre.
	 * @param nombrePersonaje nombre del personaje a consultar
	 * @return lista con los nombres de los ataques
	 */
	public ArrayList<String> selectAllAtaques(String nombrePersonaje) throws SQLException {
	    ArrayList<String> listaNombresAtaques = new ArrayList<>();

	    // Consulta para obtener el id del ataque y tipo del personaje
	    String query = """
		        SELECT relacion_ataques.ataque_id, personajes.tipo
		        FROM relacion_ataques
		        JOIN personajes ON relacion_ataques.personaje_nombre = personajes.nombre
		        WHERE relacion_ataques.personaje_nombre = ?
		        """;

	    PreparedStatement stmt = conn.prepareStatement(query);
	    stmt.setString(1, nombrePersonaje);
	    ResultSet rs = stmt.executeQuery();

	    ArrayList<Integer> ataqueIds = new ArrayList<>();
	    String tipo = null;
	    
	    // Guardar los ID de ataques y el tipo del personaje
	    while (rs.next()) {
	        ataqueIds.add(rs.getInt("ataque_id"));
	        tipo = rs.getString("tipo");
	    }

	    rs.close();
	    stmt.close();

	    // Lógica según el nombre y tipo
	    // Agrega ataques especiales dependiendo del tipo de personaje
	    if ("protagonista".equalsIgnoreCase(tipo)) {
	        if ("Alex".equalsIgnoreCase(nombrePersonaje)) {
	            ataqueIds.add(2); // Huir
	        } else {
	            ataqueIds.add(1); // Cura
	            ataqueIds.add(2); // Huir
	        }
	    }

	    // Consulta para obtener el nombre del ataque a partir de sus ID
	    String queryAtaque = "SELECT nombre FROM ataques WHERE id = ?";
	    PreparedStatement stmtAtaque = conn.prepareStatement(queryAtaque);

	    for (int ataqueId : ataqueIds) {
	        stmtAtaque.setInt(1, ataqueId);
	        ResultSet rsAtaque = stmtAtaque.executeQuery();
	        if (rsAtaque.next()) {
	            listaNombresAtaques.add(rsAtaque.getString("nombre"));
	        }
	        rsAtaque.close();
	    }

	    stmtAtaque.close();

	    return listaNombresAtaques;
	}

	/**
	 * Inserta un nuevo ataque en la tabla 'ataques'
	 * @param id ID del ataque
	 * @param nombre Nombre del ataque
	 * @param desc Descripción del ataque
	 */
	public void insertAtaque(int id, String nombre, String desc) throws SQLException {
	    String sql = "INSERT INTO ataques (id, nombre, descripcion) VALUES (?, ?, ?)";
	    PreparedStatement ps = conn.prepareStatement(sql);

	    ps.setInt(1, id);
	    ps.setString(2, nombre);
	    ps.setString(3, desc);

	    int result = ps.executeUpdate();
	    if (result > 0) {
	        System.out.println("Ataque insertado correctamente.");
	    } else {
	        System.out.println("No se pudo insertar el ataque.");
	    }

	    ps.close();
	}

	/**
	 * Actualiza un ataque existente por su ID
	 * @param id ID del ataque a actualizar
	 * @param nombre Nuevo nombre
	 * @param desc Nueva descripción
	 */
	public void updateAtaque(int id, String nombre, String desc) throws SQLException {
	    String sql = "UPDATE ataques SET nombre = ?, descripcion = ? WHERE id = ?";
	    PreparedStatement ps = conn.prepareStatement(sql);

	    ps.setString(1, nombre);
	    ps.setString(2, desc);
	    ps.setInt(3, id);

	    int result = ps.executeUpdate();
	    if (result > 0) {
	        System.out.println("Ataque actualizado correctamente.");
	    } else {
	        System.out.println("No se pudo actualizar el ataque.");
	    }

	    ps.close();
	}

	/**
	 * Elimina un ataque de la base de datos por su ID
	 * @param idAtaque ID del ataque a eliminar
	 */
	public void deleteAtaque(int idAtaque) throws SQLException {
	    String sql = "DELETE FROM ataques WHERE id = ?";
	    PreparedStatement ps = conn.prepareStatement(sql);

	    ps.setInt(1, idAtaque);

	    int result = ps.executeUpdate();
	    if (result > 0) {
	        System.out.println("Ataque eliminado correctamente.");
	    } else {
	        System.out.println("No se encontró el ataque con ID " + idAtaque);
	    }

	    ps.close();
	}

	public String getDesc(String nombreJugador) throws SQLException {
		String sql = "SELECT descripcion FROM ataques WHERE nombre = ?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, nombreJugador);

	    ResultSet rs = ps.executeQuery();

	    
	    String descripcion = "";
	    if (rs.next()) {
	    	descripcion = rs.getString("descripcion");
	    }

	    rs.close();
	    ps.close();

	    return descripcion;
	}
}
