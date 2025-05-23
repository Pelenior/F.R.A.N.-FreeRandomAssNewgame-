package model;

public class Protagonista extends Personaje {
	
	int monedas = 0;
	
	public Protagonista(String nombre, double vidaMax, double defensa, double fuerza, double velocidad, int idAscii) {
		this.nombre = nombre;
		this.vidaMax = vidaMax;
		this.vida = vidaMax;
		this.defensa = defensa;
		this.fuerza = fuerza;
		this.velocidad = velocidad;
		this.idAscii = idAscii;
		
		rellenarAtaques(this);
	}
	
	public int getMonedas()
	{
		return monedas;
	}
	

}
