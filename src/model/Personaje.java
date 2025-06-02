package model;

import java.util.ArrayList;

abstract class Personaje {
	//Atributos
	protected String nombre;
	protected double vidaMax;
	protected double vida;
	protected double defensa;
	protected double fuerza;
	protected double velocidad;
	protected int idAscii;

	AtaqueController ataqueController = new AtaqueController();
	
	private boolean flechaRecargada = false;
	private boolean recargaRapida = false;
	private int cooldownMaldicionWither = 0;
	private int danoExtra = 0;
	private int pollos = 0;
	private boolean escudoPollo = false;
	
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
	
	public boolean getFlechaRecargada()
	{
		return flechaRecargada;
	}
	public void setFlechaRecargada(boolean flechaRecargada)
	{
		this.flechaRecargada = flechaRecargada;
	}
	
	public boolean getRecargaRapida()
	{
		return recargaRapida;
	}
	public void setRecargaRapida(boolean recargaRapida)
	{
		this.recargaRapida = recargaRapida;
	}
	
	public int getCooldownMaldicionWither()
	{
		return cooldownMaldicionWither;
	}
	public void setCooldownMaldicionWither(int cooldownMaldicionWither)
	{
		this.cooldownMaldicionWither = cooldownMaldicionWither;
	}
	
	public int getDanoExtra()
	{
		return danoExtra;
	}
	public void setDanoExtra(int danoExtra)
	{
		this.danoExtra = danoExtra;
	}
	
	public int getPollos()
	{
		return pollos;
	}
	public void setPollos(int pollos)
	{
		this.pollos = pollos;
	}
	
	public boolean isEscudoPollo()
	{
		return escudoPollo;
	}
	public void setEscudoPollo(boolean escudoPollo)
	{
		this.escudoPollo = escudoPollo;
	}
	
	public abstract void atacar(Personaje target);
	
	
}
