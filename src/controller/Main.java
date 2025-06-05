package controller;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import dao.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		    
//		Juego juego = new Juego();
//		juego.comenzar();
		
		DaoJugador daojugador = new DaoJugador();
		daojugador.inicioSesion("Null", "null");
		
		
	}

}