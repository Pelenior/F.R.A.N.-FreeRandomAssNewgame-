package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;

public class AtaqueController {

	ArrayList<Ataque> listaAtaques;
	
	public AtaqueController()
	{
		listaAtaques = new ArrayList<Ataque>();
	}
	
	public void rellenarAtaques(Personaje personaje) throws SQLException
	{
		ArrayList<String> listaNombreAtaques;
		listaNombreAtaques = personaje.selectAllAtaques();
		for(String nombreAtaque : listaNombreAtaques)
		{
			listaAtaques.add(new Ataque(nombreAtaque));
		}
	}
	
	public void seleccionarAtaqueProta(Scanner sc, Protagonista prota, Personaje target)
	{
		String seleccion = "";
		prota.setRepetirAtaque(true);
		do
		{
			do
			{
				System.out.println("¿Qué ataque usa " + prota.getNombre() + "?");
				String ataques = "";
				for(int i = 0 ; i < listaAtaques.size(); i++)
				{
					ataques += (i + 1) + ". " + listaAtaques.get(i).getNombre() + " | ";
				}
				System.out.println(ataques + "\n\r");
				seleccion = sc.nextLine();
				if(!seleccion.equals("1") && !seleccion.equals("2") && !seleccion.equals("3") && !seleccion.equals("4") && !seleccion.equals("5"))
				{
					System.out.println("Escribe en números un ataque\n");
					seleccion = "";
				}
				else if(!(Integer.valueOf(seleccion) <= listaAtaques.size()))
				{
					System.out.println("Escribe en números un ataque\n");
					seleccion = "";
				}
			}
			while(seleccion.equals(""));
			listaAtaques.get(Integer.valueOf(seleccion) - 1).atacar(prota, target);
		}
		while(prota.getRepetirAtaque());
		
	}
	
	public void seleccionarAtaqueEnemigo(Enemigo enemigo, Personaje target)
	{
		Random rd = new Random();
		int ataqueRandom = 0;
		
		if(enemigo.getNombre().equals("Creeper"))
		{
			ataqueRandom = enemigo.getCargasCreeper();
		}
		else if(enemigo.getNombre().equals("Vindicator"))
		{
			if(enemigo.getCargaPreparada())
			{
				ataqueRandom = rd.nextInt(0, listaAtaques.size());
			}
			else
			{
				ataqueRandom = rd.nextInt(0, listaAtaques.size() - 1);
			}
			
			if(enemigo.getCargaRecargada())
			{
				ataqueRandom = 1;
			}
			else if(enemigo.getCargaCriticaRecargada())
			{
				ataqueRandom = 2;
			}
		}
		else if(enemigo.getNombre().equals("Evoker"))
		{
			enemigo.getAtaqueController().eliminarAtaque("Tótem de inmortalidad");
		}
		else if(enemigo.getNombre().equals("Devastator"))
		{
			if(enemigo.getVida() <= enemigo.getVidaMax() / 3 && !enemigo.getHaUsadoDesesperation())
			{
				ataqueRandom = rd.nextInt(0, listaAtaques.size());
			}
			else
			{
				ataqueRandom = rd.nextInt(0, listaAtaques.size() - 1);
			}
			if(enemigo.getCargaPreparada())
			{
				ataqueRandom = 1;
			}
		}
		else if(enemigo.getNombre().equals("Dragón"))
		{
			if(enemigo.getVida() < enemigo.getVidaMax()/2 && enemigo.getTurnosEnderman() == 0)
			{
				ataqueRandom = rd.nextInt(0, listaAtaques.size());
			}
			else
			{
				ataqueRandom = rd.nextInt(0, listaAtaques.size() - 1);
			}
		}
		else if(enemigo.getNombre().equals("Sans"))
		{
			if(enemigo.getStamina() <= 5)
			{
				ataqueRandom = rd.nextInt(0, listaAtaques.size());
			}
			else
			{
				ataqueRandom = rd.nextInt(0, listaAtaques.size() - 1);
			}
		}
		else if(enemigo.getNombre().equals("Coronel"))
		{
			if(enemigo.getTurnosPectoralesCoronel() == 0)
			{
				ataqueRandom = rd.nextInt(0, listaAtaques.size());
			}
			else
			{
				ataqueRandom = rd.nextInt(0, listaAtaques.size() - 1);
			}
		}
		else
		{
			ataqueRandom = rd.nextInt(0, listaAtaques.size());
		}
		
		listaAtaques.get(ataqueRandom).atacar(enemigo, target);
		
	}
	
	public void eliminarAtaque(String nombre)
	{
		for(int i = 0; i < listaAtaques.size(); i++)
		{
			if(listaAtaques.get(i).getNombre().equals(nombre))
			{
				listaAtaques.remove(i);
			}
		}
	}
	
	public void anadirAtaque(String nombre)
	{
		listaAtaques.add(new Ataque(nombre));
	}
}
