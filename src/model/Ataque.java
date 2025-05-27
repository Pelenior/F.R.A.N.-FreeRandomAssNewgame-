package model;

public class Ataque {

	private String nombre;
	
	public Ataque(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public double atacar(Personaje personaje, Ataque ataque)
	{
		double danoFinal = 0;
		switch(ataque.getNombre())
		{
			case "Por si Espada":
			{
				danoFinal = 4;
			}
		}
		//etc
		return danoFinal;
	}
	
}
