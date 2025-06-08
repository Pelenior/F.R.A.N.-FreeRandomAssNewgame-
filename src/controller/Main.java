package controller;
import model.*;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		    
		Juego juego = new Juego();
		juego.comenzar();
	}
}