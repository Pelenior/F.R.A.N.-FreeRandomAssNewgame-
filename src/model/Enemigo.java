package model;

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
	
}
