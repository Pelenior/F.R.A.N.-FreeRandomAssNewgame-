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
		boolean haceDano = false;
		danoFinal += user.getFuerza();
		switch(nombre)
		{
			
			case "Por si Espada":
			{
				danoFinal = 4;
				System.out.println("Steve blande su espada contra el enemigo");
				haceDano = true;
				break;
			}
			
			case "Arco":
			{
	
				if(user.getRecargaRapida())
				{
					danoFinal = 7; // recarga rápida ataca siempre con la flecha
					System.out.println("Steve no necesita recargar una flecha gracias a su Recarga Rápida!");
				}
				else
				{
					if(!user.getFlechaRecargada())
					{
						user.setFlechaRecargada(true); //flecha no recargada
						System.out.println(user.getNombre() + " recarga una flecha...");
					}
					else
					{
						user.setFlechaRecargada(false); //Flecha usada
						danoFinal = 7;
						System.out.println(user.getNombre() + " dispara con su arco!");
						haceDano = true;
					}
				}
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
						System.out.println(user.getNombre() + "" + Color.GREEN_BRIGHT + "brazo" + Color.RESET + " al enemigo");
						haceDano = true;
						break;
					}
				
				case 2, 6:
					{
						danoFinal = 2;
						System.out.println(user.getNombre() + " ataca con su espada y le da en la " + Color.YELLOW + "pierna" + Color.RESET + " al enemigo");
						haceDano = true;
						break;
					}
				
				case 3, 7:
					{
						danoFinal = 3;
						System.out.println(user.getNombre() + " ataca con su espada y le da en el " + Color.YELLOW + "estómago" + Color.RESET + " al enemigo");
						haceDano = true;
						break;
					}
				
				case 4, 8:
					{
						danoFinal = 4;
						System.out.println(user.getNombre() + " ataca con su espada y le da en el " + Color.RED_BRIGHT + "pecho" + Color.RESET + " al enemigo");
						haceDano = true;
						break;
					}
				
				case 9:
					{
						danoFinal = 0;
						System.out.println("Steve se tropieza y se cae!");
						break;
					}
				
				case 10:
					{
						danoFinal = 15;
						System.out.println("Steve maneja su espada con total gracia y " + Color.BLACK + "la clava en el cráneo del enemigo" + Color.RESET + "!");
						haceDano = true;
						break;
					}
				}
				break;
			}
			
			case "Hacha":
			{
				danoFinal = 5;
				System.out.println(user.getNombre() + " usa el hacha para atacar al enemigo");
				haceDano = true;
				break;
			}
			
			case "Poción de Fuerza":
			{
				System.out.println(user.getNombre() + " se toma una " + Color.CYAN + "poción de fuerza" + Color.RESET);
				user.setDanoExtra(user.getDanoExtra() + 4);
				break;
			}
			
			case "Maldición de Wither":
			{
				danoFinal = (int) (target.getVida() * 0.3);
				System.out.println(user.getNombre() + " maldice al enemigo con una " + Color.BLACK + "flor de wither" + Color.RESET);
				haceDano = true;
				user.setCooldownMaldicionWither(3);
				break;
			}
				
			case "Tricotada":
			{
				System.out.println(user.getNombre() + " ataca con su pico!");
				System.out.println("Tak");
				System.out.println("Tak");
				System.out.println("Tak");
				if(user.getRecargaRapida())
				{
					System.out.println("\r\nEl encantamiento de Recarga Rápida hace que " + user.getNombre() + " ataque una cuarta vez!");
					System.out.println("Tak");
				}
				danoFinal = 1;
				haceDano = true;
				break;
			}
			
			case "Ataque huevo":
			{
				danoFinal = 4;
				System.out.println(user.getNombre() + " lanza un huevo!");
				System.out.println("Al estallar el huevo aparece " + Color.CYAN + "un pollito..." + Color.RESET);
				haceDano = true;
				user.setPollos(user.getPollos() + 1);
				break;
			}
			
			case "Llamada de pollos":
			{
				System.out.println(user.getNombre() + Color.CYAN + " prepara a sus pollitos" + Color.RESET + " para el siguiente ataque...");
				user.setEscudoPollo(true);
				break;
			}
			
			case "Puñetazo":
			{
				danoFinal = 1;
				System.out.println("El " + user.getNombre() + " le pega un puñetazo a " + target.getNombre());
				haceDano = true;
				break;
			}
			
			case "Mordisco":
			{
				danoFinal = 2;
				System.out.println("El " + user.getNombre() + " le muerde el brazo a " + target.getNombre());
				haceDano = true;
				break;
			}
			
			case "Infección":
			{
				Random random = new Random();
				System.out.println("El " + user.getNombre() + " infecta a " + target.nombre + "...");
				int randomInfeccion = random.nextInt(1, 11);
				// Selección random de Infección
				switch(randomInfeccion)
				{
					case 1, 2, 3, 4:
						{
							danoFinal = 1;
							System.out.println("Era una " + Color.YELLOW + "infección pequeña" + Color.RESET);
							haceDano = true;
							break;
						}
					case 5, 6, 7, 8:
						{
							danoFinal = 2;
							System.out.println("Era una " + Color.YELLOW + "infección de pulmones" + Color.RESET);
							haceDano = true;
							break;
						}
					case 9:
						{
							danoFinal = 0;
							System.out.println(target.getNombre() + Color.GREEN_BRIGHT + " es invulnerable" + Color.RESET + " a la infección!");
							break;
						}
					case 10:
						{
							danoFinal = 5;
							System.out.println("¡La infección llega a " + Color.RED_BRIGHT + "tu cerebro!" + Color.RESET);
							haceDano = true;
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
					haceDano = true;
				}
				break;
			}
		
			case "Esquele-Ton":
			{
				danoFinal=3;
				haceDano = true;
				break;
			}
			
			case "Tss":
			{
				danoFinal=0;
				System.out.println("El creeper parpadea\r\n" + Color.GREEN_BRIGHT + "Tss" + Color.RESET);
				break;
			}
			
			case "Tss Tss":
			{
				danoFinal=0;
				System.out.println("El creeper parpadea 2 veces\r\n" + Color.YELLOW + "Tss Tss" + Color.RESET);
				break;
			}
			
			case "Explosión":
			{
				danoFinal=10;
				System.out.println(Color.CYAN + "El creeper se queda callado..." + Color.RESET + "\r\n" + Color.RED_BRIGHT + "BOOOOM!!!!!" + Color.RESET);
				haceDano = true;
				break;
			}
			
			case "Espada":
			{
				danoFinal=3;
				haceDano = true;
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
				haceDano = true;
				}
				break;
			}
			case "Hachazo":
			{
				danoFinal=4;
				haceDano = true;
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
					haceDano = true;
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
					haceDano = true;
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
				haceDano = true;
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
				haceDano = true;
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
				haceDano = true;
				break;
			}
			case "Aliento de Dragón":
			{
				danoFinal=5;
				haceDano = true;
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
				haceDano = true;
				break;
			}
			case "Gaster Blaster":
			{
				danoFinal=2;
				haceDano = true;
				break;
			}
			case "Sans Dance":
			{
				danoFinal=5;
				haceDano = true;
				break;
			}
			case "Pollo":
			{
				danoFinal=6;
				haceDano = true;
				break;
			}
			case "Despilfarro":
			{
				danoFinal=10;
				haceDano = true;
				break;
			}
			case "Pectorales":
			{
				danoFinal=10;
				break;
			}
		}
		
		if(danoFinal > 0 && haceDano)
		{
			if(target.getDefensa() > 0)
			{
				danoFinal -= (danoFinal * (target.getDefensa() / 2)) / 10; // cálculo de defensa
			}
			
			System.out.println(user.getNombre() + " hace " + danoFinal + " puntos de daño a " + target.getNombre() + "!");
			if(user.getDanoExtra() > 0)
			{
				user.setDanoExtra(0);
			}
		}
		
	}
	
}
