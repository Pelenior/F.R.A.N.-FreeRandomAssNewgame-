package model;

import java.util.Random;

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
	
	public void atacar(Personaje user, Personaje target)
	{
		double danoFinal = 0;
		danoFinal += user.getFuerza();
		switch(nombre)
		{
		
		case "Por si Espada":
		{
			danoFinal = 4;
			break;
		}
		
		case "Arco":
		{
			boolean recargaRapidaPersonaje = false;
			boolean flechaRecargada = false;

			if(recargaRapidaPersonaje)
			{
				danoFinal = 7; // recarga rápida ataca siempre con la flecha
			}
			else
			{
				if(!flechaRecargada)
				{
					danoFinal = -1; // -1 == Flecha no recargada
				}
				else
				{
					danoFinal = 7; // 7 == Flecha usada
				}
			}
			// Si no tiene flecha, devolvemos un -1 y lo capturamos fuera de la función.
			break;

		}
		
		case "Ataque Crítico":
		{
			// Selección random del ataque Crítico
			Random random = new Random();
			int criticoRandom = random.nextInt(1, 11);
			switch(criticoRandom)
			{
			
			case 1, 5://si el "dado" da 1 o 5
				{
					danoFinal = 1;
					break;
				}
			
			case 2, 6:
				{
					danoFinal = 2;
					break;
				}
			
			case 3, 7:
				{
					danoFinal = 3;					
					break;
				}
			
			case 4, 8:
				{
					danoFinal = 4;
					break;
				}
			
			case 9:
				{
					danoFinal = 0;
					break;
				}
			
			case 10:
				{
					danoFinal = 15;
					break;
				}
			}
			
			break;
		}
		
		case "Hacha":
		{
			danoFinal=5;
			break;
		}
		
		case "Poción de Fuerza":
		{
			danoFinal = -1; // -1 == Poción
			break;
		}
		
		case "Maldición de Wither":
		{
			danoFinal=0;
			break;
		}
			
		case "Tricotada":
		{
			boolean recargaRapida= false;
			System.out.println("Chicken Little ataca con su pico!");
			System.out.println("Tak");
			System.out.println("Tak");
			System.out.println("Tak");
			if(recargaRapida)
			{
				System.out.println("\r\nEl encantamiento de Recarga Rápida hace que Chicken Little ataque una cuarta vez!");
				System.out.println("Tak");
			}
			danoFinal = 1;
			break;
		}
		
		case "Ataque huevo":
		{
			danoFinal=4;
			break;
		}
		
		case "Llamada de pollos":
		{
			danoFinal=4;
			break;
		}
		
		case "Puñetazo":
		{
			danoFinal=1;
			break;
		}
		
		case "Mordisco":
		{
			danoFinal=2;
			break;
		}
		
		case "Infección":
		{
			Random random = new Random();
			int randomInfeccion = random.nextInt(1, 11);
			// Selección random de Infección
			switch(randomInfeccion)
			{
				case 1, 2, 3, 4:
					{
						danoFinal = 1;
						break;
					}
				case 5, 6, 7, 8:
					{
						danoFinal = 2;
						break;
					}
				case 9:
					{
						danoFinal = 0;
						break;
					}
				case 10:
					{
//						System.out.println(nombrePersonaje + " se muere jaja lol xd");
						danoFinal = 5;
						break;
					}
				default:
					{
						System.out.println("Error en el random del ataque Infección del enemigo Zombie");
					}
			}
			break;
		}
		
		case "Flecha":
			boolean flechaRecargada=false;
		{
			if(!flechaRecargada)
			{
				danoFinal = -1; // -1 == Recargar flecha
			}
			else
			{
				danoFinal = 4; // 4 == Disparar flecha
			}
			break;
		}
	
		case "Esquele-Ton":
		{
			danoFinal=3;
			break;
		}
		
		case "Tss":
		{
			danoFinal=0;
			break;
		}
		
		case "Tss Tss":
		{
			danoFinal=0;
			break;
		}
		
		case "Explosión":
		{
			danoFinal=10;
			break;
		}
		
		case "Espada":
		{
			danoFinal=3;
			break;
		}
		
		case "Ballesta":
		{
			flechaRecargada = false;
			if(!flechaRecargada)
			{
			danoFinal = -1; // -1 == Recargar flecha
			}
			else
			{
			danoFinal = 7; // 4 == Disparar flecha
			}
			break;
		}
		case "Hachazo":
		{
			danoFinal=4;
			break;
		}
		case "Carga":
			boolean cargaPreparada=false;
		{
			if(!cargaPreparada)
			{
				danoFinal = 0; // 0 == Carga
			}
			else
			{
				danoFinal = 7; // 7 == Usar carga
			}
			break;
		}
		case "Carga Crítica":
			boolean cargaCriticaPreparada=false;
		{
			if(!cargaCriticaPreparada)
			{
				danoFinal = -1; // -1 == Carga crítica
			}
			else
			{
				danoFinal = 14; // 14 == Usar carga crítica
			}
			break;
		}
		case "Invocación":
		{
			danoFinal=0;
			break;
		}
		case "Cocodrilos":
		{
			danoFinal=4;
			break;
		}
		case "Tótem de inmortalidad":
		{
			danoFinal=-1;
			break;
		}
		case "Cabezazo":
		{
			danoFinal=5;
			break;
		}
		case "Desesperación":
		{
			danoFinal=-1;
			break;
		}
		case "Mega mordisco":
		{
			danoFinal=7;
			break;
		}
		case "Aliento de Dragón":
		{
			danoFinal=5;
			break;
		}
		case "Enderman":
		{
			danoFinal=12;
			break;
		}
		case "Hueso":
		{
			danoFinal=1;
			break;
		}
		case "Gaster Blaster":
		{
			danoFinal=2;
			break;
		}
		case "Sans Dance":
		{
			danoFinal=5;
			break;
		}
		case "Pollo":
		{
			danoFinal=6;
			break;
		}
		case "Despilfarro":
		{
			danoFinal=10;
			break;
		}
		case "Pectorales":
		{
			danoFinal=10;
			break;
		}
		}
		//etc
	}
	
}
