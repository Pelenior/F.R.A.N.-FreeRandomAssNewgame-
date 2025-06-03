package model;

import java.sql.SQLException;

import dao.DaoPersonajes;

public class Enemigo extends Personaje {
	
	//Constructor
	public Enemigo(String nombre, double vidaMax, double defensa, double velocidad, double fuerza) {
		this.nombre = nombre;
		this.vidaMax = vidaMax;
		vida = vidaMax;
		this.defensa = defensa;
		this.velocidad = velocidad;
		this.fuerza = fuerza;
		
		ataqueController.rellenarAtaques(this);
	}
	
	public void insertEnemigo(String nombre, Double vidaMax, Double defensa, Double fuerza, Double velocidad, Integer idAscii,Boolean isRaid, Boolean isBoss, Boolean isSteve) throws SQLException{
		DaoPersonajes DaoPersonajes = new DaoPersonajes();
		DaoPersonajes.insertEnemigo( nombre,  vidaMax,  defensa,  fuerza,  velocidad,  idAscii, isRaid,  isBoss,  isSteve);
	}
	
	public void updateEnemigo(String nombre, Double vidaMax, Double defensa, Double fuerza, Double velocidad, Integer idAscii,Boolean isRaid, Boolean isBoss, Boolean isSteve) throws SQLException{
		DaoPersonajes DaoPersonajes = new DaoPersonajes();
		DaoPersonajes.updateEnemigo( nombre,  vidaMax,  defensa,  fuerza,  velocidad,  idAscii, isRaid,  isBoss,  isSteve);
	}
	
	@Override
	public void atacar(Personaje target)
	{
		ataqueController.seleccionarAtaqueEnemigo(this, target);
	}
	
}
