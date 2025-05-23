package model;

public class Enemigo extends Personaje {
	boolean isRaid; 
	boolean isBoss;
	boolean isSteve;
	
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
		
		rellenarAtaques(this);
	}
	
}
