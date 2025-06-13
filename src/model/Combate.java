package model;

import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.sql.*;
import dao.*;

public class Combate {
	
	String bioma = "";
	String clima = "";
	String terreno = "";
	
	private int turnos = 0;
	
	public int getTurnos() {
		return turnos;
	}

	private Enemigo enemigo;
	
	public static void imprimirStats(Protagonista prota, Enemigo enemigo, String tipoCombate) throws SQLException
	{
		String nombre =  Color.RED_BOLD_BRIGHT + enemigo.getNombre().toUpperCase() + Color.RESET;
		
		if(tipoCombate.equals("Boss")) System.out.printf("%50s", nombre);
		else System.out.printf("%40s", nombre);
		
		String color = ""; // por defecto
		
		if(enemigo.getVida() >0) {
			float percentage = (float) (enemigo.getVida() / enemigo.getVidaMax());
	
	        // Según el % de vida, aplicar color
	        if (percentage > 0.90) {
	            color = ""; // sin color
	        } else if (percentage > 0.8) {
	            color = Color.RED_BRIGHT_ASCII;
	        } else if (percentage > 0.5) {
	            color = Color.RED_BOLD;
	        } else if (percentage > 0.20) {
	            color =  Color.RED_FAINT;
	        } else {
	            color = Color.RED_BOLD;
	        }
		}
		System.out.println(color);
		ASCII.printAscii(enemigo.getDataEnemigo().getIdAscii());
		System.out.println(Color.RESET);

		int espacios = Math.max(27 - prota.getNombre().length(), 0);
		String padding = " ".repeat(espacios);

		String output = "Stats de " + prota.getNombre() + " son:" + padding + "Stats de " + enemigo.getNombre() + " son:";
		System.out.println(output);

		//Para truncar el valor (ej. Si DecimalFormat es "0.00", 1.0987 = 1.09)
//		DecimalFormat dfVidaPersonaje;
//		DecimalFormat dfVidaMaxPersonaje = new DecimalFormat("0");
//		DecimalFormat dfDefensaPersonaje;
//		DecimalFormat dfFuerzaPersonaje;
//		DecimalFormat dfVelocidadPersonaje;
//		
//		DecimalFormat dfVidaEnemigo;
//		DecimalFormat dfVidaMaxEnemigo = new DecimalFormat("0");
//		DecimalFormat dfDefensaEnemigo = new DecimalFormat("0");
//		DecimalFormat dfFuerzaEnemigo = new DecimalFormat("0");
//		DecimalFormat dfVelocidadEnemigo = new DecimalFormat("0");
		
		
//		if(prota.getVida() < 10)
//		{
//			dfVidaPersonaje = new DecimalFormat("0.00");
//		}
//		else
//		{
//			dfVidaPersonaje = new DecimalFormat("0.0");
//		}
//		
//		if(enemigo.getVida() < 10)
//		{
//			dfVidaEnemigo = new DecimalFormat("0.00");
//		}
//		else
//		{
//			dfVidaEnemigo = new DecimalFormat("0.0");
//		}
//		
//		if(prota.getDefensa() >= 10 || prota.getDefensa() < 0)
//		{
//			dfDefensaPersonaje = new DecimalFormat("0,00");
//		}
//		else
//		{
//			dfDefensaPersonaje = new DecimalFormat("0.0");
//		}
//		
//		if(prota.getFuerza() >= 10 || prota.getFuerza() < 0)
//		{
//			dfFuerzaPersonaje = new DecimalFormat("0");
//		}
//		else
//		{
//			dfFuerzaPersonaje = new DecimalFormat("0.0");
//		}
//		
//		if(prota.getVelocidad() >= 10)
//		{
//			dfVelocidadPersonaje = new DecimalFormat("0");
//		}
//		else if(prota.getVelocidad() < 0)
//		{
//			dfVelocidadPersonaje = new DecimalFormat("00");
//		}
//		else
//		{
//			dfVelocidadPersonaje = new DecimalFormat("0.0");
//		}
		
		System.out.println("==============================================================================================");

		// Vida
		String vidaProtaColor = prota.getVida() > prota.getVidaMax() / 2 ? Color.GREEN_BRIGHT :
		                        (prota.getVida() > prota.getVidaMax() / 4 ? Color.YELLOW : Color.RED_BRIGHT);
		String vidaEnemigoColor = enemigo.getVida() > enemigo.getVidaMax() / 2 ? Color.GREEN_BRIGHT :
		                          (enemigo.getVida() > enemigo.getVidaMax() / 4 ? Color.YELLOW : Color.RED_BRIGHT);
		System.out.printf("Vida:        %s%-5.0f%s/%s%-5.0f%s                 Vida:        %s%-5.0f%s/%s%-5.0f%s%n",
		    vidaProtaColor, prota.getVida(), Color.RESET,
		    Color.GREEN_BRIGHT, prota.getVidaMax(), Color.RESET,
		    vidaEnemigoColor, enemigo.getVida(), Color.RESET,
		    Color.GREEN_BRIGHT, enemigo.getVidaMax(), Color.RESET);

		// Defensa
		System.out.printf("Defensa:     %-5.0f                       Defensa:     %-5.0f%n",
		    (prota.getDefensa() - prota.getPenalizacionDefensa()),
		    enemigo.getDefensa());

		// Fuerza
		System.out.printf("Fuerza:      %s%-5.0f%s                       Fuerza:      %s%-5.0f%s%n",
		    Color.RED_BRIGHT, (prota.getFuerza() - prota.getPenalizacionAtaque()), Color.RESET,
		    Color.RED_BRIGHT, enemigo.getFuerza(), Color.RESET);

		// Velocidad
		System.out.printf("Velocidad:   %s%-5.0f%s                       Velocidad:   %s%-5.0f%s%n",
		    Color.CYAN, prota.getVelocidad(), Color.RESET,
		    Color.CYAN, enemigo.getVelocidad(), Color.RESET);

		System.out.println("==============================================================================================");

	}
	
	public Combate()
	{

	}
	
	private void seleccionEnemigo(Random random, Protagonista prota, String tipoCombate, int numeroEnemigos) throws SQLException
	{
		ArrayList<String> nombreEnemigos = new ArrayList<String>();
		ArrayList<Object> vidaMaxEnemigos = new ArrayList<Object>();
		ArrayList<Object> defensaEnemigos = new ArrayList<Object>();
		ArrayList<Object> fuerzaEnemigos = new ArrayList<Object>();
		ArrayList<Object> velocidadEnemigos = new ArrayList<Object>();
		ArrayList<Object> asciiEnemigos = new ArrayList<Object>();
		
		DaoPersonajes daoPersonajes = new DaoPersonajes();
		
		ArrayList<ArrayList<Object>> listaEnemigos;
		ArrayList<ArrayList<Object>> listaNombresEnemigosBoss = new ArrayList<ArrayList<Object>>();
		ArrayList<ArrayList<Object>> listaNombresEnemigosSteve = new ArrayList<ArrayList<Object>>();
		ArrayList<ArrayList<Object>> listaNombresEnemigosRaid = new ArrayList<ArrayList<Object>>();
		ArrayList<ArrayList<Object>> listaNombresEnemigosRaidBoss = new ArrayList<ArrayList<Object>>();
		ArrayList<ArrayList<Object>> listaNombresEnemigosNormal = new ArrayList<ArrayList<Object>>();
		
		listaEnemigos = daoPersonajes.selectALLEnemigo();
		
		for(ArrayList<Object> i : listaEnemigos)
		{
			if((boolean) i.get(7) && !(boolean)i.get(6))
			{
				listaNombresEnemigosBoss.add(i);
			}
		}
		
		for(ArrayList<Object> i : listaEnemigos)
		{
			if((boolean)i.get(8))
			{
				listaNombresEnemigosSteve.add(i);
			}
		}
		
		for(ArrayList<Object> i : listaEnemigos)
		{
			if((boolean)i.get(6) && !(boolean)i.get(7))
			{
				listaNombresEnemigosRaid.add(i);
			}
		}
		
		for(ArrayList<Object> i : listaEnemigos)
		{
			if((boolean)i.get(6) && (boolean)i.get(7))
			{
				listaNombresEnemigosRaidBoss.add(i);
			}
		}
		
		for(ArrayList<Object> i : listaEnemigos)
		{
			if(!(boolean)i.get(6) && !(boolean)i.get(7) && !(boolean)i.get(8))
			{
				listaNombresEnemigosNormal.add(i);
			}
		}
		
		int seleccionRandom = 0;
		
		if(tipoCombate.equals("Boss"))
		{
			prota.getAtaqueController().eliminarAtaque("Huir");
			for(ArrayList<Object> i : listaNombresEnemigosBoss)
			{
				nombreEnemigos.add((String) i.get(0));
			}
			for(ArrayList<Object> i : listaNombresEnemigosBoss)
			{
				vidaMaxEnemigos.add(i.get(1));
			}
			for(ArrayList<Object> i : listaNombresEnemigosBoss)
			{
				defensaEnemigos.add(i.get(2));
			}
			for(ArrayList<Object> i : listaNombresEnemigosBoss)
			{
				fuerzaEnemigos.add(i.get(3));
			}
			for(ArrayList<Object> i : listaNombresEnemigosBoss)
			{
				velocidadEnemigos.add(i.get(4));
			}
			for(ArrayList<Object> i : listaNombresEnemigosBoss)
			{
				asciiEnemigos.add(i.get(5));
			}
			switch(prota.getNombre())
			{
				case "Steve":
				{
					seleccionRandom = 1;
					break;
				}
				case "Alex":
				{
					seleccionRandom = 2;
					prota.anadirAtaque("Cura");
					break;
				}
				case "Chicken Little":
				{
					seleccionRandom = 0;
					break;
				}
			}
		}
		else if(tipoCombate.equals("Steve"))
		{
			for(ArrayList<Object> i : listaNombresEnemigosSteve)
			{
				nombreEnemigos.add((String) i.get(0));
			}
			for(ArrayList<Object> i : listaNombresEnemigosSteve)
			{
				vidaMaxEnemigos.add(i.get(1));
			}
			for(ArrayList<Object> i : listaNombresEnemigosSteve)
			{
				defensaEnemigos.add(i.get(2));
			}
			for(ArrayList<Object> i : listaNombresEnemigosSteve)
			{
				fuerzaEnemigos.add(i.get(3));
			}
			for(ArrayList<Object> i : listaNombresEnemigosSteve)
			{
				velocidadEnemigos.add(i.get(4));
			}
			for(ArrayList<Object> i : listaNombresEnemigosSteve)
			{
				asciiEnemigos.add(i.get(5));
			}
			
			seleccionRandom = 0;
		}
		else if(tipoCombate.equals("Raid") && numeroEnemigos > 1)
		{
			for(ArrayList<Object> i : listaNombresEnemigosRaid)
			{
				nombreEnemigos.add((String) i.get(0));
			}
			for(ArrayList<Object> i : listaNombresEnemigosRaid)
			{
				vidaMaxEnemigos.add(i.get(1));
			}
			for(ArrayList<Object> i : listaNombresEnemigosRaid)
			{
				defensaEnemigos.add(i.get(2));
			}
			for(ArrayList<Object> i : listaNombresEnemigosRaid)
			{
				fuerzaEnemigos.add(i.get(3));
			}
			for(ArrayList<Object> i : listaNombresEnemigosRaid)
			{
				velocidadEnemigos.add(i.get(4));
			}
			for(ArrayList<Object> i : listaNombresEnemigosRaid)
			{
				asciiEnemigos.add(i.get(5));
			}
			
			seleccionRandom = random.nextInt(0, nombreEnemigos.size());
		}
		else if(tipoCombate.equals("Raid") && numeroEnemigos == 1)
		{
			for(ArrayList<Object> i : listaNombresEnemigosRaidBoss)
			{
				nombreEnemigos.add((String) i.get(0));
			}
			for(ArrayList<Object> i : listaNombresEnemigosRaidBoss)
			{
				vidaMaxEnemigos.add(i.get(1));
			}
			for(ArrayList<Object> i : listaNombresEnemigosRaidBoss)
			{
				defensaEnemigos.add(i.get(2));
			}
			for(ArrayList<Object> i : listaNombresEnemigosRaidBoss)
			{
				fuerzaEnemigos.add(i.get(3));
			}
			for(ArrayList<Object> i : listaNombresEnemigosRaidBoss)
			{
				velocidadEnemigos.add(i.get(4));
			}
			for(ArrayList<Object> i : listaNombresEnemigosRaidBoss)
			{
				asciiEnemigos.add(i.get(5));
			}
			
			seleccionRandom = 0;
			
		}
		else
		{
			for(ArrayList<Object> i : listaNombresEnemigosNormal)
			{
				nombreEnemigos.add((String) i.get(0));
			}
			for(ArrayList<Object> i : listaNombresEnemigosNormal)
			{
				vidaMaxEnemigos.add(i.get(1));
			}
			for(ArrayList<Object> i : listaNombresEnemigosNormal)
			{
				defensaEnemigos.add(i.get(2));
			}
			for(ArrayList<Object> i : listaNombresEnemigosNormal)
			{
				fuerzaEnemigos.add(i.get(3));
			}
			for(ArrayList<Object> i : listaNombresEnemigosNormal)
			{
				velocidadEnemigos.add(i.get(4));
			}
			for(ArrayList<Object> i : listaNombresEnemigosNormal)
			{
				asciiEnemigos.add(i.get(5));
			}
			
			seleccionRandom = random.nextInt(0, nombreEnemigos.size());
		}
		enemigo = new Enemigo(nombreEnemigos.get(seleccionRandom), (double) vidaMaxEnemigos.get(seleccionRandom),
							  (double) defensaEnemigos.get(seleccionRandom), (double) velocidadEnemigos.get(seleccionRandom),
							  (double) fuerzaEnemigos.get(seleccionRandom), 0);
	}
	
	private void penalizaciones(Protagonista prota, Random random, String tipoCombate)
	{
		String colorBioma = "";
		String colorTerreno = "";
		String colorClima = "";
		
		switch(random.nextInt(0, 10))
		{
			case 0, 1, 2, 3, 4, 5, 6, 7:
			{
				bioma = "Overworld";
				colorBioma = Color.GREEN_BOLD_BRIGHT;
				break;
			}
			case 8:
			{
				bioma = "Nether";
				colorBioma = Color.BLACK_BOLD_BRIGHT;
				break;
			}
			case 9:
			{
				bioma = "End";
				colorBioma = Color.PURPLE_BOLD_BRIGHT;
				break;
			}
		}
		switch(random.nextInt(0, 4))
		{
			case 0:
			{
				clima = "Despejado";
				colorClima = Color.CYAN_BOLD;
				break;
			}
			case 1:
			{
				clima = "Nublado";
				colorClima = Color.BLACK_BOLD_BRIGHT;
				break;
			}
			case 2:
			{
				clima = "Lluvioso";
				colorClima = Color.BLUE_BOLD_BRIGHT;
				break;
			}
			case 3:
			{
				clima = "Tormentoso";
				colorClima = Color.BLACK_BOLD;
				break;
			}
		}
		switch(random.nextInt(0, 3))
		{
			case 0:
			{
				terreno = "Llano";
				colorTerreno = Color.GREEN_BOLD;
				break;
			}
			case 1:
			{
				terreno = "Rocoso";
				colorTerreno = Color.BLACK_BOLD_BRIGHT;
				break;
			}
			case 2:
			{
				terreno = "Montañoso";
				colorTerreno = Color.YELLOW_BOLD;
				break;
			}
		}
		
		if(tipoCombate.equals("Boss"))
		{
			if(prota.getNombre().equals("Steve"))
			{
				bioma = "End";
			}
		}
		
		
		switch(bioma)
		{
			case "Nether":
			{
				prota.setPenalizacionAtaque(prota.getPenalizacionAtaque() + 0.5);
				clima = "Despejado";
				break;
			}
			case "End":
			{
				clima = "Despejado";
				prota.setPenalizacionAtaque(prota.getPenalizacionAtaque() + 1);
				break;
			}
		}
		switch(clima)
		{
			case "Lluvioso":
			{
				prota.setPenalizacionAtaque(prota.getPenalizacionAtaque() + 0.5);
				break;
			}
			case "Tormentoso":
			{
				prota.setPenalizacionAtaque(prota.getPenalizacionAtaque() + 1);
				break;
			}
		}
		switch(terreno)
		{
			case "Rocoso":
			{
				prota.setPenalizacionAtaque(prota.getPenalizacionAtaque() + 0.5);
				prota.setPenalizacionDefensa(prota.getPenalizacionDefensa() + 1);
				break;
			}
			case "Montañoso":
			{
				prota.setPenalizacionAtaque(prota.getPenalizacionAtaque() + 1);
				prota.setPenalizacionDefensa(prota.getPenalizacionDefensa() + 1.5);
				break;
			}
		}
		
		System.out.println("La batalla tendrá lugar en el " + colorBioma + bioma + Color.RESET + ", es un lugar " + colorTerreno + terreno + Color.RESET + " y el clima es " + colorClima + clima + Color.RESET);
		if(prota.getPenalizacionAtaque() > 0)
		{
			System.out.println("El escenario hace que " + prota.getNombre() + " pierda " + Color.RED_BOLD_BRIGHT + prota.getPenalizacionAtaque() + Color.RED_BOLD + " puntos de fuerza!" + Color.RESET);
		}
		if(prota.getPenalizacionDefensa() > 0)
		{
			System.out.println("El escenario hace que " + prota.getNombre() + " pierda " + Color.RED_BOLD_BRIGHT + prota.getPenalizacionDefensa() + Color.BLUE_BOLD + " puntos de defensa!" + Color.RESET);
		}
	}
	
	//devuelve false si el protagonista pierde
	public boolean combate(Scanner sc, Random random, Protagonista prota, String tipoCombate, boolean enemigoEmpiezaPrimero) throws SQLException
	{
		//Variables que permanecen entre encuentros con enemigos
		
		penalizaciones(prota, random, tipoCombate);
		
		DecimalFormat dfOneDecimal = new DecimalFormat("0.0");
		DecimalFormat dfZeroDecimal = new DecimalFormat("0");
		
		int numeroEnemigos = 0;
		int danoVex = 0;
		turnos = 0;
		int danoAliento = 0;
		int danoEnderman = 0;
		int danoNiebla = 0;
		
		if(tipoCombate.equals("Boss") || tipoCombate.equals("Steve"))
		{
			numeroEnemigos = 1;
		}
		else
		{
			numeroEnemigos = random.nextInt(3, 6);
		}
		
		prota.setNumEnemigos(numeroEnemigos);
		
		System.out.println(prota.getNombre() + " se encuentra con " + Color.RED_BRIGHT + numeroEnemigos + " enemigos" + Color.RESET + "!");
		
		while(numeroEnemigos != 0 && prota.getVida() > 0 && !prota.getHaHuido())
		{
			//variables que NO permanecen entre encuentros con enemigos
			seleccionEnemigo(random, prota, tipoCombate, numeroEnemigos);
			
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
						System.out.println("El " + Color.YELLOW_BOLD_BRIGHT + "siguiente enemigo " + Color.RESET + "al que se enfrenta " + prota.getNombre() + " es un " + Color.RED_BRIGHT + enemigo.getNombre() + Color.RESET + "\r\n");
					else
						System.out.println("El primer enemigo al que se enfrenta " + prota.getNombre() + " es un " + Color.RED_BRIGHT + enemigo.getNombre() + Color.RESET + "\r\n");
				}
			}
			
			if(enemigo.getNombre().equals("Sans"))
			{
				System.out.println("A " + prota.getNombre() + " no le afecta la maldición aquí... ");
				System.out.println(prota.getNombre() + Color.CYAN + " ahora se puede curar" + Color.RESET + "!");
				enemigo.setStamina(15);
			}
			else if(enemigo.getNombre().equals("Dragon"))
			{
				System.out.println("El Dragón vuela por el end, " + Color.RED_BRIGHT + "es más difícil acertar tus ataques contra él" + Color.RESET);
				prota.setVelocidad(prota.getVelocidad() - 3);
			}
			else if(enemigo.getNombre().equals("Ravager"))
			{
				enemigo.setPillagerActivo(true);
			}
			
			while(prota.getVida() > 0 && enemigo.getVida() > 0 && !prota.getHaHuido())
			{
				turnos++;
				System.out.println(Color.YELLOW_BOLD_BRIGHT + Color.YELLOW_UNDERLINED + "\nTURNO " + turnos + Color.RESET);
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
				imprimirStats(prota, enemigo, tipoCombate);
				
				System.out.println(prota.getNombre() + " tiene " + (prota.getVida() > prota.getVidaMax() / 2 ? Color.GREEN_BRIGHT : (prota.getVida() > prota.getVidaMax() / 4 ? Color.YELLOW : Color.RED_BRIGHT)) + dfOneDecimal.format(prota.getVida()) + Color.RESET + "/" + Color.GREEN_BRIGHT + dfZeroDecimal.format(prota.getVidaMax()) + Color.RESET + " puntos de vida\r\n");
				
				if(enemigo.getNombre().equals("Sans") || enemigo.getNombre().equals("Steve"))
				{
					System.out.println(enemigo.getNombre() + " tiene " + (enemigo.getVida() > enemigo.getVidaMax() / 2 ? Color.GREEN_BRIGHT : (enemigo.getVida() > enemigo.getVidaMax() / 4 ? Color.YELLOW : Color.RED_BRIGHT)) + dfOneDecimal.format(enemigo.getVida()) + Color.RESET + "/" + Color.GREEN_BRIGHT + dfZeroDecimal.format(enemigo.getVidaMax()) + Color.RESET + " puntos de vida");
				}
				else
				{
					System.out.println("El " + enemigo.getNombre() + " enemigo tiene " + (enemigo.getVida() > enemigo.getVidaMax() / 2 ? Color.GREEN_BRIGHT : (enemigo.getVida() > enemigo.getVidaMax() / 4 ? Color.YELLOW : Color.RED_BRIGHT)) + dfOneDecimal.format(enemigo.getVida()) + Color.RESET + "/" + Color.GREEN_BRIGHT + dfZeroDecimal.format(enemigo.getVidaMax()) + Color.RESET + " puntos de vida");
				}
				
				if(enemigoEmpiezaPrimero)
				{
					System.out.println(Color.RED_BRIGHT + "El " + Color.RESET + enemigo.getNombre() + Color.RED_BRIGHT + " da el primer paso" + Color.RESET + "!");
				}
				if(!enemigoEmpiezaPrimero)
				{
					System.out.println("==============================================================================================");
					//ataque del protagonista
					prota.atacar(sc, enemigo);
					if(prota.getNiebla())
					{
						System.out.println("Niebla ataca al enemigo contigo!");
						danoNiebla = 3;
						if(enemigo.getDefensa() > 0)
						{
							danoNiebla -= (danoNiebla * (enemigo.getDefensa() / 2)) / 10;
						}
						System.out.println("Niebla hace " + danoNiebla + " puntos de daño al " + enemigo.getNombre());
						enemigo.setVida(enemigo.getVida() - danoNiebla);
					}
				}
				if(enemigoEmpiezaPrimero)
					enemigoEmpiezaPrimero = false;
				
				//ataque del enemigo
				System.out.println("==============================================================================================");
				if(enemigo.getVida() > 0 && prota.getVida() > 0 && !prota.getHaHuido())
				{
					enemigo.atacar(sc, prota);
				}
				if(prota.getCooldownMaldicionWither() > 0)
				{
					prota.setCooldownMaldicionWither(prota.getCooldownMaldicionWither() - 1);
				}
				if(enemigo.getTurnosPectoralesCoronel() > 0)
				{
					enemigo.setTurnosPectoralesCoronel(enemigo.getTurnosPectoralesCoronel() - 1);
				}
				if(prota.getTurnosAlientoDragon() > 0)
				{
					prota.setTurnosAlientoDragon(prota.getTurnosAlientoDragon() - 1);
				}
				if(prota.getTurnosEnderman() == 0 && prota.getAlientoDragonActivo())
				{
					danoEnderman = 12;
					danoEnderman -= (danoEnderman * (prota.getDefensa() / 2)) / 10;
					System.out.println("Los " + Color.PURPLE_BRIGHT + "enderman" + Color.RED_BRIGHT + " atacan a " + Color.RESET + prota.getNombre() + "!");
					prota.setVida(prota.getVida() - danoEnderman);
					danoEnderman = 0;
					prota.setEndermanActivo(false);
				}
				else if(prota.getTurnosEnderman() > 0)
				{
					prota.setTurnosEnderman(prota.getTurnosEnderman() - 1);
				}
				
				if(enemigo.getNumVex() > 0)
				{
					System.out.println("Los " + enemigo.getNumVex() + Color.RED_BRIGHT + " Vex" + Color.RESET + " atacan a " + prota.getNombre() + "!");
					danoVex = enemigo.getNumVex() * 2;
					if(prota.getDefensa() > 0)
					{
						danoVex -= (danoVex * (prota.getDefensa() / 2)) / 10; // defensa
					}
					prota.setVida(prota.getVida() - danoVex);
					System.out.println("Los " + Color.RED_BRIGHT + "Vex" + Color.RESET + " hacen un total de " + Color.RED_BRIGHT + danoVex + Color.RESET + " puntos de daño a " + prota.getNombre());
				}
				if(prota.getTurnosAlientoDragon() == 0 && prota.getAlientoDragonActivo())
				{
					danoAliento = 5;
					danoAliento -= (danoAliento * (prota.getDefensa() / 2)) / 10;
					System.out.println("El " + Color.PURPLE_BRIGHT + "aliento de dragón" + Color.RESET + " sigue afectando a " + prota.getNombre());
					prota.setVida(prota.getVida() - danoAliento);
					danoAliento = 0;
					prota.setAlientoDragonActivo(false);
				}
				else if(prota.getTurnosAlientoDragon() > 0 && prota.getAlientoDragonActivo())
				{
					prota.setTurnosAlientoDragon(prota.getTurnosAlientoDragon() - 1);
				}
				if(enemigo.getStamina() > 0)
				{
					enemigo.setStamina(enemigo.getStamina() - 1);
				}
				if(enemigo.getVida() < 0 && enemigo.getHasTotem())
				{
					enemigo.setVida(enemigo.getVidaMax() / 2);
					enemigo.setHasTotem(false);
					System.out.println("El " + Color.PURPLE_BRIGHT + "tótem de inmortalidad" + Color.RESET + " salva a " + enemigo.getNombre() + "!");
				}
				if(prota.getVida() < 0 && prota.recorrerListaObjetos("Totem de inmortalidad") > 0)
				{
					prota.setVida(prota.getVidaMax() / 2);
					prota.eliminarObjeto("Totem de inmortalidad");
					System.out.println("El " + Color.PURPLE_BRIGHT + "tótem de inmortalidad" + Color.RESET + " salva a " + prota.getNombre() + "!");
					System.out.println(prota.getNombre() + " ahora tiene " + prota.recorrerListaObjetos("Totem de inmortalidad") + Color.PURPLE_BRIGHT + " tótems de inmortalidad" + Color.RESET);
				}
			}
			numeroEnemigos--;
		}
		prota.setPenalizacionAtaque(0);
		prota.setPenalizacionDefensa(0);
		if(prota.getVida() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
