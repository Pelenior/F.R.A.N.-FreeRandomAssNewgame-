package dao;

import java.sql.*;

public class DaoJugador {
	private Connection conn = null;
	private static DaoJugador instance = null;

	public DaoJugador() throws SQLException {
		
		conn = DbConnection.getConnection();
	}
	
	public static DaoJugador getInstance() throws SQLException{
		
		if(instance == null) {
			instance = new DaoJugador();
		}
		return instance;
	}
	
	public boolean inicioSesion(String nombre, String contraseña) throws SQLException {
	    String sql = "SELECT * FROM jugador WHERE nombre = ? AND contraseña = ?";
	    
	    PreparedStatement ps = conn.prepareStatement(sql);
	    
	    ps.setString(1, nombre);
	    ps.setString(2, contraseña);

	    ResultSet rs = ps.executeQuery();

	    boolean accesoPermitido = rs.next();

	    rs.close();
	    ps.close();

	    return accesoPermitido;
	}

	public boolean guardarJugador(String nombre, String contraseña, int idAscii, int puntuacion) throws SQLException {
		
	    boolean comprobacionNombre = comprobarNombre(nombre);
//	    System.out.println("Nombre válido: " + comprobacionNombre);

	    if (comprobacionNombre) {
	        String sql = "INSERT INTO jugador (nombre, contraseña, idAscii, puntuacion) VALUES (?, ?, ?, ?)";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, nombre);
	        ps.setString(2, contraseña);
	        ps.setInt(3, idAscii);
	        ps.setInt(4, puntuacion);

	        int result = ps.executeUpdate();
	        if (result > 0) {
	            System.out.println("Jugador insertado correctamente.\n");
	        } else {
	            System.out.println("No se pudo insertar el jugador.");
	        }

	        ps.close();
	    } else {
	        System.out.println("El nombre está cogido.");
	        
	    }
	    return comprobacionNombre;
	}

	public boolean comprobarNombre(String nombreJugador) throws SQLException {
	    String sql = "SELECT * FROM jugador WHERE nombre = ?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, nombreJugador);
	    ResultSet rs = ps.executeQuery();

	    boolean nombreDisponible = !rs.next();

	    rs.close();
	    ps.close();

	    return nombreDisponible;
	}

	
	public boolean comprobarContraseña(String contraseña) throws SQLException {
		String sql = "SELECT * FROM jugador WHERE contraseña = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);

	    ResultSet rs = ps.executeQuery(sql);
		
	    boolean comprobar =!rs.next();
	    
	    ps.close();
	    rs.close();
	    
	    return comprobar;
	}
	
	public int getAscii(String nombreJugador) throws SQLException {
		String sql = "SELECT idAscii FROM jugador WHERE nombre = ?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, nombreJugador);

	    ResultSet rs = ps.executeQuery();

	    
	    int id = 99;
	    if (rs.next()) {
	        id = rs.getInt("idAscii");
	    }

	    rs.close();
	    ps.close();

	    return id;
	}
	
	public int getPuntuacion(String nombreJugador) throws SQLException {
		String sql = "SELECT puntuacion FROM jugador WHERE nombre = ?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, nombreJugador);

	    ResultSet rs = ps.executeQuery();

	    
	    int puntuacion = 0;
	    if (rs.next()) {
	    	puntuacion = rs.getInt("puntuacion");
	    }

	    rs.close();
	    ps.close();

	    return puntuacion;
	}
}
