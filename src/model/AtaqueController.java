package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AtaqueController {

	ArrayList<Ataque> listaAtaques;
	
	public AtaqueController()
	{
		listaAtaques = new ArrayList<Ataque>();
	}
	
	public void rellenarAtaques(Personaje personaje)
	{
		switch(personaje.getNombre())
		{
			case "Steve":
			{
				listaAtaques.add(new Ataque("Por si Espada"));
				listaAtaques.add(new Ataque("Arco"));
				listaAtaques.add(new Ataque("Ataque Crítico"));
				listaAtaques.add(new Ataque("Cura"));
				listaAtaques.add(new Ataque("Huir"));
				break;
			}
			case "Alex":
			{
				listaAtaques.add(new Ataque("Hacha"));
				listaAtaques.add(new Ataque("Poción de Fuerza"));
				listaAtaques.add(new Ataque("Maldición de Wither"));
				listaAtaques.add(new Ataque("Huir"));
				break;
			}
			case "Chicken Little":
			{
				listaAtaques.add(new Ataque("Tricotada"));
				listaAtaques.add(new Ataque("Ataque huevo"));
				listaAtaques.add(new Ataque("Llamada de pollos"));
				listaAtaques.add(new Ataque("Cura"));
				listaAtaques.add(new Ataque("Huir"));
				break;
			}
			case "Zombie":
			{
				listaAtaques.add(new Ataque("Puñetazo"));
				listaAtaques.add(new Ataque("Mordisco"));
				listaAtaques.add(new Ataque("Infección"));
				break;
			}
			case "Esqueleto":
			{
				listaAtaques.add(new Ataque("Puñetazo"));
				listaAtaques.add(new Ataque("Flecha"));
				break;
			}
			case "Creeper":
			{
				listaAtaques.add(new Ataque("Tss"));
				listaAtaques.add(new Ataque("Tss Tss"));
				listaAtaques.add(new Ataque("Explosión"));
				break;
			}
			case "Saqueador":
			{
				listaAtaques.add(new Ataque("Espada"));
				listaAtaques.add(new Ataque("Ballesta"));
				listaAtaques.add(new Ataque("Saquear"));
				break;
			}
			case "Vindicador":
			{
				listaAtaques.add(new Ataque("Hachazo"));
				listaAtaques.add(new Ataque("Carga"));
				listaAtaques.add(new Ataque("Carga Crítica"));
				break;
			}
			case "Evocador":
			{
				listaAtaques.add(new Ataque("Invocación"));
				listaAtaques.add(new Ataque("Cocodrilos"));
				listaAtaques.add(new Ataque("Tótem de inmortalidad"));
				break;
			}
			case "Devastador":
			{
				listaAtaques.add(new Ataque("Cabezazo"));
				listaAtaques.add(new Ataque("Mega Carga"));
				listaAtaques.add(new Ataque("Desesperación"));
				break;
			}
			case "Dragón":
			{
				listaAtaques.add(new Ataque("Mega Mordisco"));
				listaAtaques.add(new Ataque("Aliento de Dragón"));
				listaAtaques.add(new Ataque("Enderman"));
				break;
			}
			case "Sans":
			{
				listaAtaques.add(new Ataque("Hueso"));
				listaAtaques.add(new Ataque("Gaster Blaster"));
				listaAtaques.add(new Ataque("Sans Dance"));
				break;
			}
			case "Coronel":
			{
				listaAtaques.add(new Ataque("Pollo"));
				listaAtaques.add(new Ataque("Despilfarro"));
				listaAtaques.add(new Ataque("Pectorales"));
				break;
			}
			case "Steve Corrupto":
			{
				listaAtaques.add(new Ataque("Espadazo Corrupto"));
				listaAtaques.add(new Ataque("Flecha Corrupta"));
				listaAtaques.add(new Ataque("Ataque Crítico Corrupto"));
				break;
			}
		}
	}
	
	public void seleccionarAtaqueProta(Protagonista prota, Personaje target)
	{
		Scanner sc = new Scanner(System.in);
		String seleccion = "";
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
			if(!(Integer.valueOf(seleccion) <= listaAtaques.size()))
			{
				System.out.println("Escribe en números un ataque\n");
				seleccion = "";
			}
		}
		while(seleccion.equals(""));
		
		listaAtaques.get(Integer.valueOf(seleccion) - 1).atacar(prota, target);
	}
	
	public void seleccionarAtaqueEnemigo(Enemigo enemigo, Personaje target)
	{
		Random rd = new Random();
		int ataqueRandom = 0;
		
		if(enemigo.getNombre().equals("Creeper"))
		{
			ataqueRandom = enemigo.getCargasCreeper();
			ataqueRandom = rd.nextInt(0, listaAtaques.size());
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
			if(enemigo.getTotemUsado())
			{
				ataqueRandom = rd.nextInt(0, listaAtaques.size() - 1);
			}
			else
			{
				ataqueRandom = rd.nextInt(0, listaAtaques.size());
			}
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
}
