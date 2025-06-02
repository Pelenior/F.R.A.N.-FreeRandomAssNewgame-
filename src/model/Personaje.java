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
	private int monedas = 0;
	protected int idAscii;

	AtaqueController ataqueController = new AtaqueController();
	
	private boolean flechaRecargada = false;
	private boolean cargaPreparada = false;

	private boolean cargaRecargada = false;
	private boolean recargaRapida = false;
	private int cooldownMaldicionWither = 0;
	private int danoExtra = 0;
	private int pollos = 0;
	private boolean escudoPollo = false;
	private int numVex = 0;
	private boolean hasTotem = false;
	private boolean haUsadoDesesperation = false;
	private boolean pillagerActivo = false;
	private int turnosAlientoDragon = 0;
	private int turnosEnderman = 0;
	private int karma = 0;
	private int turnosPectoralesCoronel = 0;
	
	//getters y setters
	public String getNombre()
	{
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
	public int getMonedas()
	{
		return monedas;
	}
	public void setMonedas(int monedas)
	{
		this.monedas = monedas;
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
	
	public boolean getCargaPreparada()
	{
		return cargaPreparada;
	}
	public void setCargaPreparada(boolean cargaPreparada)
	{
		this.cargaPreparada = cargaPreparada;
	}
	public boolean getCargaRecargada()
	{
		return cargaRecargada;
	}
	public void setCargaRecargada(boolean cargaRecargada)
	{
		this.cargaRecargada = cargaRecargada;
	}
	
	public int getNumVex()
	{
		return numVex;
	}
	public void setNumVex(int numVex)
	{
		this.numVex = numVex;
	}
	
	public boolean getHasTotem()
	{
		return hasTotem;
	}
	public void setHasTotem(boolean hasTotem)
	{
		this.hasTotem = hasTotem;
	}
	
	public boolean getHaUsadoDesesperation()
	{
		return haUsadoDesesperation;
	}
	public void setHaUsadoDesesperation(boolean haUsadoDesesperation)
	{
		this.haUsadoDesesperation = haUsadoDesesperation;
	}
	public boolean getPillagerActivo()
	{
		return pillagerActivo;
	}
	public void setPillagerActivo(boolean pillagerActivo)
	{
		this.pillagerActivo = pillagerActivo;
	}
	
	public int getTurnosAlientoDragon()
	{
		return turnosAlientoDragon;
	}
	public void setTurnosAlientoDragon(int turnosAlientoDragon)
	{
		this.turnosAlientoDragon = turnosAlientoDragon;
	}
	
	public int getTurnosEnderman()
	{
		return turnosEnderman;
	}
	public void setTurnosEnderman(int turnosEnderman)
	{
		this.turnosEnderman = turnosEnderman;
	}
	
	public int getKarma()
	{
		return karma;
	}
	
	public void setKarma(int karma)
	{
		this.karma = karma;
	}
	
	public int getTurnosPectoralesCoronel()
	{
		return turnosPectoralesCoronel;
	}
	public void setTurnosPectoralesCoronel(int turnosPectoralesCoronel)
	{
		this.turnosPectoralesCoronel = turnosPectoralesCoronel;
	}
	
	public abstract void atacar(Personaje target);
	
	
}
