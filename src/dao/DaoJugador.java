package dao;

import java.sql.*;
import java.util.ArrayList;

import model.Color;

public class DaoJugador {
	private Connection conn = null;
	private static DaoJugador instance = null;
	public static String rankEstetico = "";

	public DaoJugador() throws SQLException {
		
		conn = DbConnection.getConnection();
	}
	
	public static DaoJugador getInstance() throws SQLException{
		
		if(instance == null) {
			instance = new DaoJugador();
		}
		return instance;
	}
	
	public static String getRankEstetico() {
		return rankEstetico;
	}

	public static void setRankEstetico(String rankEstetico) {
		DaoJugador.rankEstetico = rankEstetico;
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

	public boolean guardarJugador(String nombre, String contraseña, int idAscii, int puntuacion, String rank) throws SQLException {
		
	    boolean comprobacionNombre = comprobarNombre(nombre);
//	    System.out.println("Nombre válido: " + comprobacionNombre);

	    if (comprobacionNombre) {	    	
	        String sql = "INSERT INTO jugador (nombre, contraseña, idAscii, puntuacion, rank) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, nombre);
	        ps.setString(2, contraseña);
	        ps.setInt(3, idAscii);
	        ps.setInt(4, puntuacion);
	        ps.setString(5, rank);

	        int result = ps.executeUpdate();
	        if (result < 0) {
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
	
	public int getPuntuacion(String nombre) throws SQLException {
		String sql = "SELECT puntuacion, rank FROM jugador WHERE nombre = ?";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, nombre);

	    ResultSet rs = ps.executeQuery();

	    int puntuacion = 0;
	    if (rs.next()) {
	    	puntuacion = rs.getInt("puntuacion");
	    	rankEstetico = rs.getString("rank");
	    	switch(rankEstetico) {
	    	case"ZZZ-RANK":
	    		rankEstetico = Color.BLACK_BOLD_BRIGHT + "ZZZ" + Color.RESET;
	    		break;
	    	case"C-RANK":
	    		rankEstetico = Color.GREEN_BOLD_BRIGHT + "C-RANK" + Color.RESET;
	    		break;
	    	case"B-RANK":
	    		rankEstetico = Color.YELLOW_BOLD_BRIGHT + "B-RANK" + Color.RESET;
	    		break;
	    	case"A-RANK":
	    		rankEstetico = Color.PURPLE_BOLD_BRIGHT + "A-RANK" + Color.RESET;
	    		break;
	    	case"S-RANK":
	    		rankEstetico = Color.RED_BOLD_BRIGHT + "S-RANK" + Color.RESET;
	    		break;
	    	case"SS-RANK":
	    		rankEstetico = Color.RED_BOLD_BRIGHT + "SS-RANK" + Color.RESET;
	    		break;
	    	case"SSS-RANK":
	    		rankEstetico = Color.RED_UNDERLINED + Color.RED_BOLD_BRIGHT + "SSS-RANK" + Color.RESET;
	    		break;
	    	case"X-RANK":
	    		rankEstetico = Color.CYAN_UNDERLINED  + Color.BLACK_BACKGROUND + Color.CYAN_BOLD_BRIGHT + "X-RANK" + Color.RESET;
	    		break;
	    	}
	    }
	    
	    rs.close();
	    ps.close();

	    return puntuacion;
	}
	

	public void setPuntuacion(String nombre, int puntuacion) throws SQLException {
	    String sql = "UPDATE jugador SET puntuacion = ? WHERE nombre = ?";
	    
	    String rank = "";
	    
	    PreparedStatement statement = conn.prepareStatement(sql);
	    statement.setInt(1, puntuacion);
	    statement.setString(2, nombre);
	    
	    int update = statement.executeUpdate();
	    
	    if (update > 0) {
	        System.out.println("\nLa puntuacion de " + nombre + " es ahora " + Color.YELLOW_BOLD_BRIGHT + puntuacion + "pts" + Color.RESET);
	        
	        if(puntuacion <= 0) {
	        	rank = "ZZZ-RANK";
	        	rankEstetico = Color.BLACK_BOLD_BRIGHT + "ZZZ-RANK" + Color.RESET;
	        }
	        else if(puntuacion > 0 && puntuacion <= 250) {
	        	rank = "C-RANK";
	        	rankEstetico = Color.GREEN_BOLD_BRIGHT + "C-RANK" + Color.RESET;
	        }
	        else if(puntuacion > 250 && puntuacion <= 500) {
	        	rank = "B-RANK";
	        	rankEstetico = Color.YELLOW_BOLD_BRIGHT + "B-RANK" + Color.RESET;
	        }
	        else if(puntuacion > 500 && puntuacion <= 1000) {
	        	rank = "A-RANK";
	        	rankEstetico = Color.PURPLE_BOLD_BRIGHT + "A-RANK" + Color.RESET;
	        }
	        else if(puntuacion > 1000 && puntuacion <= 1250) {
	        	rank = "S-RANK";
	        	rankEstetico = Color.RED_BOLD_BRIGHT + "S-RANK" + Color.RESET;
	        }
	        else if(puntuacion > 1250 && puntuacion <= 1500) {
	        	rank = "SS-RANK";
	        	rankEstetico = Color.RED_BOLD_BRIGHT + "SS-RANK" + Color.RESET;
	        }
	        else if(puntuacion > 1500 && puntuacion <= 1750) {
	        	rank = "SSS-RANK";
	        	rankEstetico = Color.RED_UNDERLINED + Color.RED_BOLD_BRIGHT + "SSS-RANK" + Color.RESET;
	        }
	        else if(puntuacion > 1750 && puntuacion <= 2000) {
	        	rank = "X-RANK";
	        	rankEstetico = Color.CYAN_UNDERLINED  + Color.BLACK_BACKGROUND + Color.CYAN_BOLD_BRIGHT + "X-RANK" + Color.RESET;
	        }
	        setRank(nombre,rank,rankEstetico);
	    } else {
	        System.out.println("No se encontró al jugador con nombre: " + nombre);
	    }

	    statement.close();
	}
	
	public void setRank(String nombre, String rank, String rankEstetico) throws SQLException {
	    String updateSql = "UPDATE jugador SET rank = ? WHERE nombre = ?";

	    PreparedStatement statement = conn.prepareStatement(updateSql);
	    statement.setString(1, rank);
	    statement.setString(2, nombre);

	    int rowsUpdated = statement.executeUpdate();

	    if (rowsUpdated > 0) {
	    	System.out.println(Color.WHITE_BOLD_BRIGHT + "HAS OBTENIDO EL " + Color.RESET + rankEstetico + "\n");
	    } else {
	        System.out.println("No se encontró el jugador con nombre: " + nombre);
	    }

	    statement.close();
	}

	public void leaderboard(String nombreJugador) throws SQLException {
	    String query = "SELECT nombre, puntuacion, rank FROM jugador ORDER BY puntuacion DESC";
	    PreparedStatement statement = conn.prepareStatement(query);
	    ResultSet rs = statement.executeQuery();

	    System.out.println("--------------------------------------------------------");
	    System.out.printf(Color.WHITE_BOLD_BRIGHT + "%-20s %-15s %-15s%n", "Nombre", "Puntuación", "Rango" + Color.RESET);
	    System.out.println("--------------------------------------------------------");

	    while (rs.next()) {
	        String nombre = rs.getString("nombre");
	        int puntuacion = rs.getInt("puntuacion");
	        String rank = rs.getString("rank");

	        if (nombre.equalsIgnoreCase(nombreJugador)) {
	            // Resaltar con asteriscos
	            System.out.printf(Color.WHITE_BOLD_BRIGHT + "%-20s %-15d %-15s%n", nombre, puntuacion, rank + Color.RESET);
	        } else {
	            System.out.printf("%-20s %-15d %-15s%n", nombre, puntuacion, rank);
	        }
	    }

	    rs.close();
	    statement.close();
	}

}
