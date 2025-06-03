package dao;

import java.sql.*;
import model.*;

public class DaoPersonajes {
	
	private Connection conn = null;
	private static DaoPersonajes instance = null;
	private Protagonista dataProta = new Protagonista();
	private Enemigo dataEnemigo = new Enemigo();
	
	public DaoPersonajes() throws SQLException {
		
		conn = DbConnection.getConnection();
	}
	
	public static DaoPersonajes getInstance() throws SQLException{
		
		if(instance == null) {
			instance = new DaoPersonajes();
		}
		return instance;
	}
	
	public void insertProta(String nombre, Double vidaMax, Double defensa, Double fuerza, Double velocidad, Integer idAscii, Boolean karma) throws SQLException {
	    String insertSql = "INSERT INTO personajes (nombre, tipo, vidaMax, defensa, fuerza, velocidad, idAscii, karma, isRaid, isBoss, isSteve) "
	                     + "VALUES (?, 'protagonista', ?, ?, ?, ?, ?, ?, NULL, NULL, NULL)";

	    PreparedStatement statement = conn.prepareStatement(insertSql);
	    statement.setString(1, nombre);

	    if (vidaMax != null) statement.setDouble(2, vidaMax); else statement.setNull(2, java.sql.Types.DOUBLE);
	    if (defensa != null) statement.setDouble(3, defensa); else statement.setNull(3, java.sql.Types.DOUBLE);
	    if (fuerza != null) statement.setDouble(4, fuerza); else statement.setNull(4, java.sql.Types.DOUBLE);
	    if (velocidad != null) statement.setDouble(5, velocidad); else statement.setNull(5, java.sql.Types.DOUBLE);
	    if (idAscii != null) statement.setInt(6, idAscii); else statement.setNull(6, java.sql.Types.INTEGER);
	    if (karma != null) statement.setBoolean(7, karma); else statement.setNull(7, java.sql.Types.BOOLEAN);

	    int rowsInserted = statement.executeUpdate();

	    if (rowsInserted > 0) {
	        System.out.println("Protagonista insertado correctamente");
	    } else {
	        System.out.println("No se insertó el protagonista");
	    }

	    statement.close();
	}
	
	public void insertEnemigo(String nombre, Double vidaMax, Double defensa, Double fuerza, Double velocidad, Integer idAscii,Boolean isRaid, Boolean isBoss, Boolean isSteve) throws SQLException {
		String insertSql = "INSERT INTO personajes (nombre, tipo, vidaMax, defensa, fuerza, velocidad, idAscii, karma, isRaid, isBoss, isSteve) "
				+ "VALUES (?, 'enemigo', ?, ?, ?, ?, ?, NULL, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(insertSql);
		statement.setString(1, nombre);
		
		if (vidaMax != null) statement.setDouble(2, vidaMax); else statement.setNull(2, java.sql.Types.DOUBLE);
		if (defensa != null) statement.setDouble(3, defensa); else statement.setNull(3, java.sql.Types.DOUBLE);
		if (fuerza != null) statement.setDouble(4, fuerza); else statement.setNull(4, java.sql.Types.DOUBLE);
		if (velocidad != null) statement.setDouble(5, velocidad); else statement.setNull(5, java.sql.Types.DOUBLE);
		if (idAscii != null) statement.setInt(6, idAscii); else statement.setNull(6, java.sql.Types.INTEGER);
		
		// karma es NULL para enemigo
		if (isRaid != null) statement.setBoolean(7, isRaid); else statement.setNull(7, java.sql.Types.BOOLEAN);
		if (isBoss != null) statement.setBoolean(8, isBoss); else statement.setNull(8, java.sql.Types.BOOLEAN);
		if (isSteve != null) statement.setBoolean(9, isSteve); else statement.setNull(9, java.sql.Types.BOOLEAN);
		
		int rowsInserted = statement.executeUpdate();
		
		if (rowsInserted > 0) {
		System.out.println("Enemigo insertado correctamente");
		} else {
		System.out.println("No se insertó el enemigo");
		}
		
		statement.close();
	}

	public void selectALLEnemigo() throws SQLException {
	    String selectAllData = "SELECT * FROM enemigos";

	    Statement statementSelect = conn.createStatement();
	    ResultSet resultData = statementSelect.executeQuery(selectAllData);

	    int countData = 0;

	    while (resultData.next()) {
	        String nombre = resultData.getString("nombre");
	        double vidaMax = resultData.getDouble("vidaMax");
	        double defensa = resultData.getDouble("defensa");
	        double fuerza = resultData.getDouble("fuerza");
	        double velocidad = resultData.getDouble("velocidad");
	        int idAscii = resultData.getInt("idAscii");
	        boolean isRaid = resultData.getBoolean("isRaid");
	        boolean isBoss = resultData.getBoolean("isBoss");
	        boolean isSteve = resultData.getBoolean("isSteve");

	        countData++;

	        System.out.println("Enemigo " + countData + "\n"
	                + "Nombre: " + nombre + "\n"
	                + "Vida Max: " + vidaMax + "\n"
	                + "Defensa: " + defensa + "\n"
	                + "Fuerza: " + fuerza + "\n"
	                + "Velocidad: " + velocidad + "\n"
	                + "idAscii: " + idAscii + "\n"
	                + "Es Raid: " + isRaid + "\n"
	                + "Es Boss: " + isBoss + "\n"
	                + "Es Steve: " + isSteve + "\n"
	                + "----------------------------");
	    }

	    statementSelect.close();
	}
	
	public void selectALLPersonajes() throws SQLException {
	    String selectAllData = "SELECT * FROM protagonistas";

	    Statement statementSelect = conn.createStatement();

	    ResultSet resultData = statementSelect.executeQuery(selectAllData);

	    int countData = 0;

	    while (resultData.next()) {
	        String nombre = resultData.getString("nombre");
	        double vidaMax = resultData.getDouble("vidaMax");
	        double defensa = resultData.getDouble("defensa");
	        double fuerza = resultData.getDouble("fuerza");
	        double velocidad = resultData.getDouble("velocidad");
	        int idAscii = resultData.getInt("idAscii");
	        boolean karma = resultData.getBoolean("karma");

	        countData++;

	        System.out.println("Protagonista " + countData + "\n"
	                + "Nombre: " + nombre + "\n"
	                + "Vida Max: " + vidaMax + "\n"
	                + "Defensa: " + defensa + "\n"
	                + "Fuerza: " + fuerza + "\n"
	                + "Velocidad: " + velocidad + "\n"
	                + "idAscii: " + idAscii + "\n"
	                + "Karma: " + karma + "\n"
	                + "----------------------------");
	    }

	    statementSelect.close();
	}
	
	public void selectALLProta() throws SQLException {
	    String selectAllData = "SELECT * FROM protagonistas";

	    Statement statementSelect = conn.createStatement();

	    ResultSet resultData = statementSelect.executeQuery(selectAllData);

	    int countData = 0;

	    while (resultData.next()) {
	        String nombre = resultData.getString("nombre");
	        double vidaMax = resultData.getDouble("vidaMax");
	        double defensa = resultData.getDouble("defensa");
	        double fuerza = resultData.getDouble("fuerza");
	        double velocidad = resultData.getDouble("velocidad");
	        int idAscii = resultData.getInt("idAscii");
	        boolean karma = resultData.getBoolean("karma");

	        countData++;

	        System.out.println("Protagonista " + countData + "\n"
	                + "Nombre: " + nombre + "\n"
	                + "Vida Max: " + vidaMax + "\n"
	                + "Defensa: " + defensa + "\n"
	                + "Fuerza: " + fuerza + "\n"
	                + "Velocidad: " + velocidad + "\n"
	                + "idAscii: " + idAscii + "\n"
	                + "Karma: " + karma + "\n"
	                + "----------------------------");
	    }

	    statementSelect.close();
	}

	public void selectThis(String nombre) throws SQLException {
    String sql = "SELECT * FROM personajes WHERE nombre = ?";

    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, nombre);

    ResultSet result = statement.executeQuery();

    if (result.next()) {
        System.out.println("Nombre: " + result.getString("nombre"));
        System.out.println("Tipo: " + result.getString("tipo"));
        System.out.println("Vida Max: " + result.getDouble("vidaMax"));
        System.out.println("Defensa: " + result.getDouble("defensa"));
        System.out.println("Fuerza: " + result.getDouble("fuerza"));
        System.out.println("Velocidad: " + result.getDouble("velocidad"));
        System.out.println("idAscii: " + result.getInt("idAscii"));
        System.out.println("Karma: " + result.getBoolean("karma"));
        System.out.println("isRaid: " + result.getBoolean("isRaid"));
        System.out.println("isBoss: " + result.getBoolean("isBoss"));
        System.out.println("isSteve: " + result.getBoolean("isSteve"));
    } else {
        System.out.println("No se encontró ningún personaje con el nombre: " + nombre);
    }

    statement.close();
}

	public void updateProta(String nombre, Double vidaMax, Double defensa, Double fuerza, Double velocidad, Integer idAscii, Boolean karma) throws SQLException {
	    String updateSql = "UPDATE personajes SET vidaMax=?, defensa=?, fuerza=?, velocidad=?, idAscii=?, karma=?, isRaid=NULL, isBoss=NULL, isSteve=NULL WHERE nombre=? AND tipo='protagonista'";

	    PreparedStatement statement = conn.prepareStatement(updateSql);

	    if (vidaMax != null) statement.setDouble(1, vidaMax); else statement.setNull(1, java.sql.Types.DOUBLE);
	    if (defensa != null) statement.setDouble(2, defensa); else statement.setNull(2, java.sql.Types.DOUBLE);
	    if (fuerza != null) statement.setDouble(3, fuerza); else statement.setNull(3, java.sql.Types.DOUBLE);
	    if (velocidad != null) statement.setDouble(4, velocidad); else statement.setNull(4, java.sql.Types.DOUBLE);
	    if (idAscii != null) statement.setInt(5, idAscii); else statement.setNull(5, java.sql.Types.INTEGER);
	    if (karma != null) statement.setBoolean(6, karma); else statement.setNull(6, java.sql.Types.BOOLEAN);

	    statement.setString(7, nombre);

	    int rowsUpdated = statement.executeUpdate();

	    if (rowsUpdated > 0) {
	        System.out.println("Protagonista actualizado correctamente");
	    } else {
	        System.out.println("No se actualizó el protagonista");
	    }

	    statement.close();
	}

	public void updateEnemigo(String nombre, Double vidaMax, Double defensa, Double fuerza, Double velocidad, Integer idAscii, Boolean isRaid, Boolean isBoss, Boolean isSteve) throws SQLException {
		String updateSql = "UPDATE personajes SET vidaMax=?, defensa=?, fuerza=?, velocidad=?, idAscii=?, karma=NULL, isRaid=?, isBoss=?, isSteve=? WHERE nombre=? AND tipo='enemigo'";
		
		PreparedStatement statement = conn.prepareStatement(updateSql);
		
		if (vidaMax != null) statement.setDouble(1, vidaMax); else statement.setNull(1, java.sql.Types.DOUBLE);
		if (defensa != null) statement.setDouble(2, defensa); else statement.setNull(2, java.sql.Types.DOUBLE);
		if (fuerza != null) statement.setDouble(3, fuerza); else statement.setNull(3, java.sql.Types.DOUBLE);
		if (velocidad != null) statement.setDouble(4, velocidad); else statement.setNull(4, java.sql.Types.DOUBLE);
		if (idAscii != null) statement.setInt(5, idAscii); else statement.setNull(5, java.sql.Types.INTEGER);
		
		// karma es NULL para enemigo
		if (isRaid != null) statement.setBoolean(6, isRaid); else statement.setNull(6, java.sql.Types.BOOLEAN);
		if (isBoss != null) statement.setBoolean(7, isBoss); else statement.setNull(7, java.sql.Types.BOOLEAN);
		if (isSteve != null) statement.setBoolean(8, isSteve); else statement.setNull(8, java.sql.Types.BOOLEAN);
		
		statement.setString(9, nombre);
		
		int rowsUpdated = statement.executeUpdate();
		
		if (rowsUpdated > 0) {
		System.out.println("Enemigo actualizado correctamente");
		} else {
		System.out.println("No se actualizó el enemigo");
		}
		
		statement.close();
	}

	public void deletePersonaje(String nombre) throws SQLException {
	    String sql = "DELETE FROM personajes WHERE nombre=?";

	    PreparedStatement statement = conn.prepareStatement(sql);
	    statement.setString(1, nombre);

	    int deleted = statement.executeUpdate();

	    if (deleted > 0) {
	        System.out.println("Personaje eliminado correctamente.");
	    } else {
	        System.out.println("No se encontró el personaje para eliminar.");
	    }

	    statement.close();
	}
	
	public Protagonista getDataProta(String nombre) throws SQLException {
	    String query = "SELECT * FROM personajes WHERE nombre = ? AND tipo = 'protagonista'";

	    PreparedStatement statement = conn.prepareStatement(query);
	    statement.setString(1, nombre);

	    ResultSet rs = statement.executeQuery();

	    if (rs.next()) {
	        dataProta.setNombre(nombre);
	        dataProta.setVidaMax(rs.getDouble("vidaMax"));
	        dataProta.setDefensa(rs.getDouble("defensa"));
	        dataProta.setFuerza(rs.getDouble("fuerza"));
	        dataProta.setVelocidad(rs.getDouble("velocidad"));
	        dataProta.setIdAscii(rs.getInt("idAscii"));
	        
	    } else {
	        System.out.println("No se encontró el protagonista: " + nombre);
	        return null;
	    }

	    rs.close();
	    statement.close();
	    return dataProta;
	}
	public Enemigo getDataEnemigo(String nombre) throws SQLException {
	    String query = "SELECT * FROM personajes WHERE nombre = ? AND tipo = 'enemigo'";

	    PreparedStatement statement = conn.prepareStatement(query);
	    statement.setString(1, nombre);

	    ResultSet rs = statement.executeQuery();

	    if (rs.next()) {
	        dataEnemigo.setNombre(nombre);
	        dataEnemigo.setVidaMax(rs.getDouble("vidaMax"));
	        dataEnemigo.setDefensa(rs.getDouble("defensa"));
	        dataEnemigo.setFuerza(rs.getDouble("fuerza"));
	        dataEnemigo.setVelocidad(rs.getDouble("velocidad"));
	        dataEnemigo.setIdAscii(rs.getInt("idAscii"));
	        
	    } else {
	        System.out.println("No se encontró el enemigo: " + nombre);
	        return null;
	    }

	    rs.close();
	    statement.close();
	    return dataEnemigo;
	}




}
