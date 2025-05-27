package model;

public class Enemigo extends Personaje {
	//Atributos
	boolean isRaid; 
	boolean isBoss;
	boolean isSteve;
	
	//Constructor
	public Enemigo(String nombre, double vidaMax, double vida, double defensa, double fuerza, double velocidad, boolean isRaid, boolean isBoss, boolean isSteve) {
		this.nombre = nombre;
		this.vidaMax = vidaMax;
		this.vida = vida;
		this.defensa = defensa;
		this.fuerza = fuerza;
		this.velocidad = velocidad;
		this.isRaid = isRaid;
		this.isBoss = isBoss;
		this.isSteve = isSteve;
		
		ataqueController.rellenarAtaques(this);
	}
	
}
