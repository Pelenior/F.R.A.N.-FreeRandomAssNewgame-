package model;

import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Combate {
	
	private Enemigo enemigo;
	
	public static void imprimirStats(Protagonista prota, Enemigo enemigo)
	{
		switch(prota.getNombre())
		{
			case "Steve":
			{
				System.out.println("Las estadísticas de " + prota.getNombre() + " son:              Las estadísticas de " + enemigo.getNombre() + " son:");
				break;
			}
			case "Alex":
			{
				System.out.println("Las estadísticas de " + prota.getNombre() + " son:               Las estadísticas de " + enemigo.getNombre() + " son:");
				break;
			}
			case "Chicken Little":
			{
				System.out.println("Las estadísticas de " + prota.getNombre() + " son:     Las estadísticas de " + enemigo.getNombre() + " son:");
			}
		}
		
		//Para truncar el valor (ej. Si DecimalFormat es "0.00", 1.0987 = 1.09)
		DecimalFormat dfVidaPersonaje;
		DecimalFormat dfVidaMaxPersonaje = new DecimalFormat("0");
		DecimalFormat dfDefensaPersonaje;
		DecimalFormat dfFuerzaPersonaje;
		DecimalFormat dfVelocidadPersonaje;
		
		DecimalFormat dfVidaEnemigo;
		DecimalFormat dfVidaMaxEnemigo = new DecimalFormat("0");
		DecimalFormat dfDefensaEnemigo = new DecimalFormat("0");
		DecimalFormat dfFuerzaEnemigo = new DecimalFormat("0");
		DecimalFormat dfVelocidadEnemigo = new DecimalFormat("0");
		
		
		if(prota.getVida() < 10)
		{
			dfVidaPersonaje = new DecimalFormat("0.00");
		}
		else
		{
			dfVidaPersonaje = new DecimalFormat("0.0");
		}
		
		if(enemigo.getVida() < 10)
		{
			dfVidaEnemigo = new DecimalFormat("0.00");
		}
		else
		{
			dfVidaEnemigo = new DecimalFormat("0.0");
		}
		
		if(prota.getDefensa() >= 10 || prota.getDefensa() < 0)
		{
			dfDefensaPersonaje = new DecimalFormat("0,00");
		}
		else
		{
			dfDefensaPersonaje = new DecimalFormat("0.0");
		}
		
		if(prota.getFuerza() >= 10 || prota.getFuerza() < 0)
		{
			dfFuerzaPersonaje = new DecimalFormat("0");
		}
		else
		{
			dfFuerzaPersonaje = new DecimalFormat("0.0");
		}
		
		if(prota.getVelocidad() >= 10)
		{
			dfVelocidadPersonaje = new DecimalFormat("0");
		}
		else if(prota.getVelocidad() < 0)
		{
			dfVelocidadPersonaje = new DecimalFormat("00");
		}
		else
		{
			dfVelocidadPersonaje = new DecimalFormat("0.0");
		}
		System.out.println("Vida actual: " + (prota.getVida() > prota.getVidaMax() / 2 ? Color.GREEN_BRIGHT : (prota.getVida() > prota.getVidaMax() / 4 ?Color.YELLOW : Color.RED_BRIGHT)) + dfVidaPersonaje.format(prota.getVida()) + Color.RESET + "/" + Color.GREEN_BRIGHT + dfVidaMaxPersonaje.format(prota.getVidaMax()) + Color.RESET + "                        Vida actual: " + (enemigo.getVida() > enemigo.getVidaMax() / 2 ? Color.GREEN_BRIGHT : (enemigo.getVida() > enemigo.getVidaMax() / 4 ? Color.YELLOW : Color.RED_BRIGHT)) + dfVidaEnemigo.format(enemigo.getVida()) + Color.RESET + "/" + Color.GREEN_BRIGHT + dfVidaMaxEnemigo.format(enemigo.getVidaMax()) + Color.RESET);
		System.out.println("Defensa:     " + dfDefensaPersonaje.format(prota.getDefensa()) + "                            Defensa:     " + dfDefensaEnemigo.format(enemigo.getDefensa()));
		System.out.println("Fuerza:      " + Color.RED_BRIGHT + dfFuerzaPersonaje.format(prota.getFuerza()) + Color.RESET + "                            Fuerza:      " + Color.RED_BRIGHT + dfFuerzaEnemigo.format(enemigo.getFuerza()) + Color.RESET);
		System.out.println("Velocidad:   " + Color.CYAN + dfVelocidadPersonaje.format(prota.getVelocidad()) + Color.RESET + "                            Velocidad:   " + Color.CYAN + dfVelocidadEnemigo.format(enemigo.getVelocidad()) + Color.RESET);
		System.out.println("==============================================================================================");
	}
	
	public Combate()
	{

	}
	
	private void seleccionEnemigo(Random random, Protagonista prota, String tipoCombate, int numeroEnemigos)
	{
		String[] nombreEnemigos;
		double[] vidaMaxEnemigos;
		double[] defensaEnemigos;
		double[] velocidadEnemigos;
		
		int seleccionRandom = 0;
		
		if(tipoCombate.equals("Boss"))
		{
			nombreEnemigos = new String[]     {"Dragon", "Sans", "Coronel Sanders"};
			vidaMaxEnemigos = new double[]    {50.0,     1.0,    50.0};
			defensaEnemigos = new double[]    {5,        0,      5};
			velocidadEnemigos = new double[]  {5,        10,     5};
			switch(prota.getNombre())
			{
				case "Steve":
				{
					seleccionRandom = 0;
					break;
				}
				case "Alex":
				{
					seleccionRandom = 1;
					break;
				}
				case "Chicken Little":
				{
					seleccionRandom = 2;
					break;
				}
			}
		}
		else if(tipoCombate.equals("Steve"))
		{
			nombreEnemigos = new String[]    {"Steve"};
			vidaMaxEnemigos =   new double[] {30.0};
			defensaEnemigos =   new double[] {5};
			velocidadEnemigos = new double[] {5};
			
			seleccionRandom = 0;
		}
		else if(tipoCombate.equals("Raid") && numeroEnemigos > 1)
		{
			nombreEnemigos =    new String[] {"Pillager", "Vindicator", "Evoker"};
			vidaMaxEnemigos =   new double[] {20.0,        20.0,         15.0};
			defensaEnemigos =   new double[] {1,           2,            0};
			velocidadEnemigos = new double[] {3,           3,            4};
			
			seleccionRandom = random.nextInt(0, nombreEnemigos.length);
		}
		else if(tipoCombate.equals("Raid") && numeroEnemigos == 1)
		{
			nombreEnemigos = new String[]    {"Devastator"};
			vidaMaxEnemigos = new double[]   {30};
			defensaEnemigos = new double[]   {4};
			velocidadEnemigos = new double[] {2};
			
			seleccionRandom = 0;
			
		}
		else
		{
			nombreEnemigos =    new String[] {"Zombie", "Esqueleto", "Creeper"};
			vidaMaxEnemigos =   new double[] {20.0,     15.0,        15.0};
			defensaEnemigos =   new double[] {1,        0,           0};
			velocidadEnemigos = new double[] {1,        2,           5};
			
			seleccionRandom = random.nextInt(0, nombreEnemigos.length);
		}
		
		enemigo = new Enemigo(nombreEnemigos[seleccionRandom], vidaMaxEnemigos[seleccionRandom],
							  defensaEnemigos[seleccionRandom], velocidadEnemigos[seleccionRandom], 0);
	}
	
	//devuelve false si el protagonista pierde
	public boolean combate(Scanner sc, Random random, Protagonista prota, String tipoCombate)
	{
		//Variables que permanecen entre encuentros con enemigos
		int numeroEnemigosTotal = 0;
		int numeroEnemigos = 0;
		int turnos = 0;
		ArrayList<Enemigo> listaEnemigos = new ArrayList<Enemigo>();
		
		if(tipoCombate.equals("Boss") || tipoCombate.equals("Steve"))
		{
			numeroEnemigosTotal = 1;
		}
		else
		{
			numeroEnemigosTotal = random.nextInt(3, 6);
		}
		numeroEnemigos = numeroEnemigosTotal;
		
		System.out.println(prota.getNombre() + " se encuentra con " + Color.RED_BRIGHT + numeroEnemigos + " enemigos" + Color.RESET + "!");
		
		while(numeroEnemigos != 0)
		{
			//variables que NO permanecen entre encuentros con enemigos
			turnos++;
			seleccionEnemigo(random, prota, tipoCombate, numeroEnemigos);
			
			System.out.println("Turno " + turnos);
			
			if(prota.getVida() > 0)
			{
				if(turnos > 1)
					System.out.println("Quedan un total de " + Color.RED_BRIGHT + numeroEnemigos + " enemigos" + Color.RESET + "!\r\n"); else System.out.println("");
				if(enemigo.getNombre().equals("Sans"))
				{
					System.out.println("El siguiente enemigo al que se enfrenta " + prota.getNombre() + " es " + Color.RED_BRIGHT + "Sans" + Color.RESET + "\r\n");
				}
				else
				{
					if(turnos > 1)
						System.out.println("El siguiente enemigo al que se enfrenta " + prota.getNombre() + " es un " + Color.RED_BRIGHT + enemigo.getNombre() + Color.RESET + "\r\n");
					else
						System.out.println("El primer enemigo al que se enfrenta " + prota.getNombre() + " es un " + Color.RED_BRIGHT + enemigo.getNombre() + Color.RESET + "\r\n");
				}
			}
			
			if(enemigo.getNombre().equals("Sans"))
			{
				System.out.println("A " + prota.getNombre() + " no le afecta la maldición aquí... ");
				System.out.println(prota.getNombre() + Color.CYAN + " ahora se puede curar" + Color.RESET + "!");
			}
			
			else if(enemigo.getNombre().equals("Dragon"))
			{
				System.out.println("El Dragón vuela por el end, " + Color.RED_BRIGHT + "es más difícil acertar tus ataques contra él" + Color.RESET);
				prota.setVelocidad(prota.getVelocidad() - 3);
			}
			
			while(prota.getVida() > 0 && enemigo.getVida() > 0 && !prota.getHaHuido())
			{
				if(prota.getKarma() > 0)
				{
					prota.setVida(prota.getVida() - (prota.getKarma() / 2));
					if(prota.getVida() < 1)
					{
						prota.setVida(1);
					}
					System.out.println("El " + Color.CYAN + "karma" + Color.RESET + " afecta a " + prota.getNombre() + "...");
					prota.setKarma(prota.getKarma() / 2);
					System.out.println(prota.getNombre() + " ahora tiene " + Color.RED_BRIGHT +  prota.getKarma() + Color.CYAN + " karma" + Color.RESET);
				}
				imprimirStats(prota, enemigo);
			}
		}
		
		return true;
	}

}
