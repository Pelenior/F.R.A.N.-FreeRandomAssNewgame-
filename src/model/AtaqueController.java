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
		}
	}
	
	public void seleccionarAtaqueProta(Protagonista prota)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Qué ataque usa " + prota.getNombre() + "?");
		String ataques = "";
		for(int i = 0 ; i < listaAtaques.size(); i++)
		{
			ataques += i + ". " + listaAtaques.get(i).getNombre();
		}
		System.out.println(ataques);
	}
	
	public void seleccionarAtaqueEnemigo(Enemigo enemigo)
	{
		Random rd = new Random();
	}
}
