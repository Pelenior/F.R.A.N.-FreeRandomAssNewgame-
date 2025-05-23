package model;

import java.util.ArrayList;

abstract class Personaje {
	//Atributos
	String nombre;
	double vidaMax;
	double vida;
	double defensa;
	double fuerza;
	double velocidad;
	int idAscii;
	ArrayList<Ataque> listaAtaques = new ArrayList<Ataque>();
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getVidaMax() {
		return vidaMax;
	}
	public void setVidaMax(double vidaMax) {
		this.vidaMax = vidaMax;
	}
	public double getVida() {
		return vida;
	}
	public void setVida(double vida) {
		this.vida = vida;
	}
	public double getDefensa() {
		return defensa;
	}
	public void setDefensa(double defensa) {
		this.defensa = defensa;
	}
	public double getFuerza() {
		return fuerza;
	}
	public void setFuerza(double fuerza) {
		this.fuerza = fuerza;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public int getIdAscii() {
		return idAscii;
	}

	public void setIdAscii(int idAscii) {
		this.idAscii = idAscii;
	}
	
	public void addListaAtaques(Ataque ataqueIn)
	{
		listaAtaques.add(ataqueIn);
	}
	
	protected void rellenarAtaques(Personaje personaje)
	{
		//Switch para rellenar los ataques según el nombre
		//Ejemplo
//		Ataque ataque1 = new Ataque("Patada");
//		personaje.getListaAtaque().add(ataque1);
		switch(personaje.getNombre())
		{
			case "Steve":
			{
				personaje.addListaAtaques(new Ataque("Por si Espada"));
				personaje.addListaAtaques(new Ataque("Arco"));
				personaje.addListaAtaques(new Ataque("Ataque Crítico"));
				break;
			}
			case "Alex":
			{
				personaje.addListaAtaques(new Ataque("Hacha"));
				personaje.addListaAtaques(new Ataque("Poción de Fuerza"));
				personaje.addListaAtaques(new Ataque("Maldición de Wither"));
				break;
			}
			case "Chicken Little":
			{
				personaje.addListaAtaques(new Ataque("Tricotada"));
				personaje.addListaAtaques(new Ataque("Ataque huevo"));
				personaje.addListaAtaques(new Ataque("Llamada de pollos"));
				break;
			}
		}
	}
	
}
