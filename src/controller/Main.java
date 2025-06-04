package controller;
import model.*;

import java.sql.*;

import dao.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		    
		Juego juego = new Juego();
//		DaoPersonajes DaoPersonajes = new DaoPersonajes();
//		DaoAtaques DaoAtaques = new DaoAtaques();
//		Protagonista prota = new Protagonista("Chicken Little", 20, 0, 1, 3, 2, 0);
//		Enemigo enemigo = new Enemigo("Zombie", 20, 0, 1, 3, 2);
//		
//		try {
//			System.out.println(prota.getDataProta().getVidaMax());
//			System.out.println(enemigo.getDataEnemigo().getVidaMax());
//			System.out.println(DaoAtaques.selectAllAtaques(enemigo.getNombre()));
//			System.out.println(DaoAtaques.selectAllAtaques(prota.getNombre()));
//			prota.setNombre("Alex");
//			System.out.println(DaoAtaques.selectAllAtaques(prota.getNombre()));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		juego.comenzar();
		
	}

}