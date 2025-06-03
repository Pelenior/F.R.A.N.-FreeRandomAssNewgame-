package controller;
import model.*;

import java.sql.*;

import dao.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		    
		Juego juego = new Juego();
		DaoPersonajes DaoPersonajes = new DaoPersonajes();
		Protagonista prota = new Protagonista("Chicken Little", 20, 0, 1, 3, 2, 0);
		Enemigo enemigo = new Enemigo("Zombie", 20, 0, 1, 3, 2);
		
		try {
			System.out.println(prota.getDataProta().getVidaMax());
			System.out.println(enemigo.getDataEnemigo().getVidaMax());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		juego.comenzar();
		
	}

}