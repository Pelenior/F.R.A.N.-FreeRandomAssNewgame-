package controller;
import model.*;

import java.sql.*;

import dao.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		    
		Juego juego = new Juego();
		DaoPersonajes DaoPersonajes = new DaoPersonajes();
		
		try {
			DaoPersonajes.selectALLProta();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		juego.comenzar();
		
		
	}

}