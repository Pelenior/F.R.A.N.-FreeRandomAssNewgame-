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
				listaAtaques.add(new Ataque("Esquele-Ton"));
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
				listaAtaques.add(new Ataque("Carga"));
				listaAtaques.add(new Ataque("Desesperación"));
				break;
			}
			case "Dragón":
			{
				listaAtaques.add(new Ataque("Mega mordisco"));
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
		}
	}
	
	public void seleccionarAtaqueProta(Protagonista prota)
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
		
		listaAtaques.get(Integer.valueOf(seleccion)).atacar();
	}
	
	public void seleccionarAtaqueEnemigo(Enemigo enemigo)
	{
		Random rd = new Random();
		
		int ataqueRandom = 0;
		
		ataqueRandom = rd.nextInt(0, listaAtaques.size());
		
		listaAtaques.get(ataqueRandom).atacar();
		
	}
}
