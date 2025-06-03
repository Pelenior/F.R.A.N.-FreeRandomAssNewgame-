package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoPersonajes;

public class Protagonista extends Personaje {
	
	private int suerte=0;
	private boolean badOmen = false;
	private boolean haHuido = false;
	private ArrayList<Objeto> listaObjetos;
	
	//constructor
	public Protagonista(String nombre, double vidaMax, double defensa, double fuerza, double velocidad, int idAscii, int suerte) {
		this.nombre = nombre;
		this.vidaMax = vidaMax;
		this.vida = vidaMax;
		this.defensa = defensa;
		this.fuerza = fuerza;
		this.velocidad = velocidad;
		this.idAscii = idAscii;
		this.suerte = suerte;
		
		ataqueController.rellenarAtaques(this);
	}
	
	public Protagonista() {
		
	}

	public int getSuerte() {
		return suerte;
	}

	public void setSuerte(int suerte) {
		this.suerte = suerte;
	}

	public boolean getBadOmen() {
		return badOmen;
	}

	public void setBadOmen(boolean badOmen) {
		this.badOmen = badOmen;
	}
	
	public boolean getHaHuido()
	{
		return haHuido;
	}
	
	public void setHaHuido(boolean haHuido)
	{
		this.haHuido = haHuido;
	}

	public ArrayList<Objeto> getListaObjetos() {
		return listaObjetos;
	}

	public void setListaObjetos(ArrayList<Objeto> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}
	
	public void insertProta(String nombre, Double vidaMax, Double defensa, Double fuerza, Double velocidad, Integer idAscii, Boolean karma) throws SQLException{
		DaoPersonajes DaoPersonajes = new DaoPersonajes();
		DaoPersonajes.insertProta( nombre,  vidaMax,  defensa,  fuerza,  velocidad,  idAscii,  karma);
	}
	
	public Protagonista getDataProta() throws SQLException{
		DaoPersonajes DaoPersonajes = new DaoPersonajes();
		return DaoPersonajes.getDataProta(this.nombre);
	}
	
	public void updateProta(String nombre, Double vidaMax, Double defensa, Double fuerza, Double velocidad, Integer idAscii, Boolean karma) throws SQLException{
		DaoPersonajes DaoPersonajes = new DaoPersonajes();
		DaoPersonajes.updateProta( nombre,  vidaMax,  defensa,  fuerza,  velocidad,  idAscii,  karma);
	}

	@Override
	public void atacar(Personaje target)
	{
		ataqueController.seleccionarAtaqueProta(this, target);
		
	}
	
	//GAME OVER
	public void gameOver() 
	{
		if(getVida()<0) {
			vida=0;
		}
		
		if(getVida()==0) {
			boolean gameOver = true;
		}
	
	}
	
}
