package model;

import java.util.ArrayList;

public class Protagonista extends Personaje {
	
	private int suerte=0;
	private int monedas = 0;
	private boolean badOmen = false;
	private boolean haHuido = false;
	private int karma = 0;
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
	
	public int getMonedas()
	{
		return monedas;
	}
	public void setMonedas(int monedas) {
		this.monedas = monedas;
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
	
	public int getKarma()
	{
		return karma;
	}
	
	public void setKarma(int karma)
	{
		this.karma = karma;
	}

	public ArrayList<Objeto> getListaObjetos() {
		return listaObjetos;
	}

	public void setListaObjetos(ArrayList<Objeto> listaObjetos) {
		this.listaObjetos = listaObjetos;
	}

	@Override
	public void atacar(Personaje target)
	{
		ataqueController.seleccionarAtaqueProta(this, target);
		
	}
	
}
