package model;

import java.text.DecimalFormat;
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
		user.setRepetirAtaque(false);
		double danoFinal = 0;
		boolean haceDano = false;
		double randomGolpe = 0;
		Random random = new Random();
		DecimalFormat dfOneDecimal = new DecimalFormat("0.0");
		DecimalFormat dfZeroDecimal = new DecimalFormat("0");
		switch(nombre)
		{
			case "Curar":
			{
				System.out.println(user.getNombre() + " trata de curarse...");
				//TODO cura
				//if no potions:
				System.out.println(user.getNombre() + " no tiene pociones!");
				user.setRepetirAtaque(true);
				break;
			}
			case "Huir":
			{
				System.out.println(user.getNombre() + " trata de huir!");
				int randomHuir = random.nextInt(1, 11);
				randomHuir += user.getVelocidad()/2;
				//TODO ender pearl
				
//				if((int) objetosTienda.get(4) > 0)
//				{
//					System.out.println(nombrePersonaje + " usa una " + PURPLE_BRIGHT + "ender pearl" + RESET + " para huir!");
//					objetosTienda.set(4, (int) objetosTienda.get(4) - 1);
//					System.out.println(nombrePersonaje + " ahora tiene " + (int) objetosTienda.get(4) + PURPLE_BRIGHT + " ender pearls" + RESET);
//					randomHuir = 10;
//				}
				if(randomHuir >= 8)
				{
					System.out.println(user.getNombre() + Color.GREEN_BRIGHT + " consigue huir de los enemigos" + Color.RESET + "!\r\n");
					user.setHaHuido(true);
				}
				else
				{
					System.out.println("Los enemigos " + Color.RED_BRIGHT + "no dejan que " + Color.RESET +  user.getNombre() +  Color.RED_BRIGHT + " huya" + Color.RESET + "!");
				}
				break;
			}
			case "Por si Espada":
			{
				danoFinal = 4 + user.getFuerza();
				System.out.println(user.getNombre() + " blande su espada contra el enemigo");
				haceDano = true;
				break;
			}
			
			case "Arco":
			{
	
				if(user.getRecargaRapida())
				{
					danoFinal = 7 + user.getFuerza(); // recarga rápida ataca siempre con la flecha
					System.out.println(user.getNombre() + " no necesita recargar una flecha gracias a su Recarga Rápida!");
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
						danoFinal = 7 + user.getFuerza();
						System.out.println(user.getNombre() + " dispara con su arco!");
						haceDano = true;
					}
				}
				break;
	
			}
			
			case "Ataque Crítico":
			{
				// Selección random del ataque Crítico
				int criticoRandom = random.nextInt(1, 11);
				switch(criticoRandom)
				{
				
				case 1, 5://si el "dado" da 1 o 5
					{
						danoFinal = 1 + user.getFuerza();
						System.out.println(user.getNombre() + "" + Color.GREEN_BRIGHT + "brazo" + Color.RESET + " al enemigo");
						haceDano = true;
						break;
					}
				
				case 2, 6:
					{
						danoFinal = 2 + user.getFuerza();
						System.out.println(user.getNombre() + " ataca con su espada y le da en la " + Color.YELLOW + "pierna" + Color.RESET + " al enemigo");
						haceDano = true;
						break;
					}
				
				case 3, 7:
					{
						danoFinal = 3 + user.getFuerza();
						System.out.println(user.getNombre() + " ataca con su espada y le da en el " + Color.YELLOW + "estómago" + Color.RESET + " al enemigo");
						haceDano = true;
						break;
					}
				
				case 4, 8:
					{
						danoFinal = 4 + user.getFuerza();
						System.out.println(user.getNombre() + " ataca con su espada y le da en el " + Color.RED_BRIGHT + "pecho" + Color.RESET + " al enemigo");
						haceDano = true;
						break;
					}
				
				case 9:
					{
						System.out.println("Steve se tropieza y se cae!");
						break;
					}
				
				case 10:
					{
						danoFinal = 15 + user.getFuerza();
						System.out.println("Steve maneja su espada con total gracia y " + Color.BLACK + "la clava en el cráneo del enemigo" + Color.RESET + "!");
						haceDano = true;
						break;
					}
				}
				break;
			}
			
			case "Hacha":
			{
				danoFinal = 5 + user.getFuerza();
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
				if(user.getCooldownMaldicionWither() > 0)
				{
					System.out.println("Ese ataque sigue en Cooldown!");
					user.setRepetirAtaque(true);
				}
				else
				{
					danoFinal = (int) (target.getVida() * 0.3) + user.getFuerza();
					System.out.println(user.getNombre() + " maldice al enemigo con una " + Color.BLACK + "flor de wither" + Color.RESET);
					haceDano = true;
					user.setCooldownMaldicionWither(3);// turnos de espera para usar el ataque
				}
				break;
			}
				
			case "Tricotada":
			{
				System.out.println(user.getNombre() + " ataca con su pico!");
				System.out.println("Tak");
				System.out.println("Tak");
				System.out.println("Tak");
				danoFinal += 1 + user.getFuerza();
				danoFinal += 1 + user.getFuerza();
				danoFinal += 1 + user.getFuerza();
				if(user.getRecargaRapida())
				{
					System.out.println("\r\nEl encantamiento de Recarga Rápida hace que " + user.getNombre() + " ataque una cuarta vez!");
					System.out.println("Tak");
					danoFinal += 1 + user.getFuerza();
				}
				haceDano = true;
				break;
			}
			
			case "Ataque huevo":
			{
				danoFinal = 4 + user.getFuerza();
				System.out.println(user.getNombre() + " lanza un huevo!");
				System.out.println("Al estallar el huevo aparece " + Color.CYAN + "un pollito..." + Color.RESET);
				haceDano = true;
				user.setPollos(user.getPollos() + 1);
				break;
			}
			
			case "Llamada de pollos":
			{
				if(user.getEscudoPollo())
				{
					System.out.println("Los pollitos ya están preparados...");
					user.setRepetirAtaque(true);
				}
				else
				{
					System.out.println(user.getNombre() + Color.CYAN + " prepara a sus pollitos" + Color.RESET + " para el siguiente ataque...");
					user.setEscudoPollo(true);
				}
				break;
			}
			
			case "Puñetazo":
			{
				danoFinal = 1 + user.getFuerza();
				System.out.println("El " + user.getNombre() + " le pega un puñetazo a " + target.getNombre());
				haceDano = true;
				break;
			}
			
			case "Mordisco":
			{
				danoFinal = 2 + user.getFuerza();
				System.out.println("El " + user.getNombre() + " le muerde el brazo a " + target.getNombre());
				haceDano = true;
				break;
			}
			
			case "Infección":
			{
				System.out.println("El " + user.getNombre() + " infecta a " + target.nombre + "...");
				int randomInfeccion = random.nextInt(1, 11);
				// Selección random de Infección
				switch(randomInfeccion)
				{
					case 1, 2, 3, 4:
						{
							danoFinal = 1 + user.getFuerza();
							System.out.println("Era una " + Color.YELLOW + "infección pequeña" + Color.RESET);
							haceDano = true;
							break;
						}
					case 5, 6, 7, 8:
						{
							danoFinal = 2 + user.getFuerza();
							System.out.println("Era una " + Color.YELLOW + "infección de pulmones" + Color.RESET);
							haceDano = true;
							break;
						}
					case 9:
						{
							System.out.println(target.getNombre() + Color.GREEN_BRIGHT + " es invulnerable" + Color.RESET + " a la infección!");
							break;
						}
					case 10:
						{
							danoFinal = 5 + user.getFuerza();
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
			{
				if(!user.getFlechaRecargada())
				{
					System.out.println("El " + user.getNombre() + Color.CYAN + " recarga una flecha" + Color.RESET);
					user.setFlechaRecargada(true);
				}
				else
				{
					danoFinal = 4 + user.getFuerza();
					System.out.println("El " + user.getNombre() + " dispara con su arco a " + target.getNombre() + "!");
					user.setFlechaRecargada(false);
					haceDano = true;
				}
				break;
			}
		
			case "Esquele-Ton":
			{
				danoFinal = 3;
				System.out.println("El " + user.getNombre() + " comienza a bailar spooky scary skeletons");
				haceDano = true;
				break;
			}
			
			case "Tss":
			{
				System.out.println("El " + user.getNombre() + " parpadea\r\n" + Color.GREEN_BRIGHT + "Tss" + Color.RESET);
				user.setCargasCreeper(user.getCargasCreeper() + 1);
				break;
			}
			
			case "Tss Tss":
			{
				System.out.println("El " + user.getNombre() + " parpadea 2 veces\r\n" + Color.YELLOW + "Tss Tss" + Color.RESET);
				user.setCargasCreeper(user.getCargasCreeper() + 1);
				break;
			}
			
			case "Explosión":
			{
				danoFinal=10 + user.getFuerza();
				System.out.println(Color.CYAN + "El " + user.getNombre() + " se queda callado..." + Color.RESET + "\r\n" + Color.RED_BRIGHT + "BOOOOM!!!!!" + Color.RESET);
				haceDano = true;
				user.setVida(0);
				break;
			}
			
			case "":
			{
				
			}
			
			case "Espada":
			{
				danoFinal = 3 + user.getFuerza();
				System.out.println("El " + user.getNombre() + " le pega un espadazo a " + target.getNombre());
				haceDano = true;
				break;
			}
			
			case "Ballesta":
			{
				if(!user.getFlechaRecargada())
				{
					user.setFlechaRecargada(true);
				}
				else
				{
					danoFinal = 7 + user.getFuerza();
					user.setFlechaRecargada(false);
					haceDano = true;
				}
				break;
			}
			case "Saqueo":
			{
				System.out.println("El " + user.getNombre() + " le roba " + Juego.monedas(target.getNombre(), 2) + (target.getNombre().equals("Chicken Little") ? " semillas " :  " esmeraldas ") + "a " + target.getNombre());
				break;
			}
			case "Hachazo":
			{
				danoFinal = 4 + user.getFuerza();
				System.out.println("El " + user.getNombre() + " le pega un hachazo a " + target.getNombre());
				haceDano = true;
				break;
			}
			case "Carga":
			{
				if(!user.getCargaPreparada())
				{
					System.out.println("El " + user.getNombre() + Color.CYAN + "se prepara para cargar" + Color.RESET + " contra " + target.getNombre() + "...");
					user.setCargaPreparada(true);
				}
				else
				{
					danoFinal = 7 + user.getFuerza();
					System.out.println("El " + user.getNombre() + " carga contra " + target.getNombre() + "!");
					user.setCargaPreparada(false);
					user.setCargaCriticaPreparada(true);
					haceDano = true;
				}
				break;
			}
			case "Carga Crítica":
			{
				if(!user.getCargaCriticaRecargada())
				{
					System.out.println("El " + user.getNombre() + Color.CYAN + "se prepara para cargar fuertemente" + Color.RESET + " contra " + user.getNombre() + "...");
					user.setCargaCriticaRecargada(true);
				}
				else
				{
					danoFinal = 14 + user.getFuerza();
					System.out.println("El " + user.getNombre() + Color.RED_BRIGHT + "carga con toda su fuerza" + Color.RESET + " contra " + target.getNombre() + "!");
					user.setCargaCriticaRecargada(false);
					haceDano = true;
				}
				break;
			}
			case "Invocación":
			{
				System.out.println("El " + user.getNombre() + Color.CYAN + "invoca a un pequeño aliado" + Color.RESET + "...");
				user.setNumVex(user.getNumVex() + 1);
				break;
			}
			case "Cocodrilos":
			{
				danoFinal = 4 + user.getFuerza();
				System.out.println("El " + user.getNombre() + " invoca a cocodrilos que aparecen debajo de los pies de " + target.getNombre() + "!");
				haceDano = true;
				break;
			}
			case "Tótem de inmortalidad":
			{
				System.out.println("El " + user.getNombre() + Color.CYAN + "prepara un " + Color.PURPLE_BRIGHT + "tótem de inmortalidad" + Color.RESET + "...");
				user.setHasTotem(true);
				user.setTotemUsado(true);
				break;
			}
			case "Cabezazo":
			{
				danoFinal = 5 + user.getFuerza();
				System.out.println("El " + user.getNombre() + " le pega un cabezazo a " + target.getNombre());
				haceDano = true;
				break;
			}
			case "Mega Carga":
			{
				if(!user.getCargaRecargada())
				{
					System.out.println("El " + user.getNombre() + Color.CYAN + "se prepara para cargar" + Color.RESET + " contra " + target.getNombre() + "...");
					user.setCargaRecargada(true);
				}
				else
				{
					danoFinal = 12 + user.getFuerza();
					System.out.println("El " + user.getNombre() + " carga contra " + target.getNombre() + "!");
					user.setCargaRecargada(false);
					haceDano = true;
				}
				break;
			}
			case "Desesperación":
			{
				System.out.println("El " + user.getNombre() + Color.RED_BRIGHT + "entra en desesperación" + Color.RESET + " y se come al Pillager que estaba montado encima!");
				user.setHaUsadoDesesperation(true);
				user.setPillagerActivo(false);
				user.setVida(user.getVida() + 15);
				break;
			}
			case "Mega mordisco":
			{
				danoFinal = 7 + user.getFuerza();
				System.out.println("El " + user.getNombre() + " le pega un Mordisco a " + target.getNombre());
				haceDano = true;
				break;
			}
			case "Aliento de Dragón":
			{
				danoFinal = 5 + user.getFuerza();
				System.out.println("El " + user.getNombre() + " suelta su aliento sobre " + target.getNombre());
				target.setTurnosAlientoDragon(1);
				target.setAlientoDragonActivo(true);
				haceDano = true;
				break;
			}
			case "Enderman":
			{
				System.out.println("El " + user.getNombre() + " llama a sus " + Color.PURPLE_BRIGHT + "enderman" + Color.RESET);
				target.setTurnosEnderman(2);
				target.setEndermanActivo(true);
				break;
			}
			case "Hueso":
			{
				danoFinal = 1 + user.getFuerza();
				System.out.println(user.getNombre() + " usa sus huesos contra " + target.getNombre());
				target.setKarma(target.getKarma() + 1);
				haceDano = true;
				break;
			}
			case "Gaster Blaster":
			{
				danoFinal = 2 + user.getFuerza();
				System.out.println("Un " + Color.PURPLE_BRIGHT + "Gaster Blaster" + Color.RESET + " ataca a " + target.getNombre());
				target.setKarma(target.getKarma() + 2);
				haceDano = true;
				break;
			}
			case "Sans Dance":
			{
				System.out.println(user.getNombre() + " se prepara para su " + Color.RED_BRIGHT + "ataque más poderoso" + Color.RESET + "...\r\n");
				for(int i = 0; i < 3; i++)// hace 3 ataques aleatorios
				{
					if(random.nextInt(2) == 0) // si sale 0 hace un ataque, si sale 1 hace otro
					{
						danoFinal += 3 + user.getFuerza();
						System.out.println(user.getNombre() + " usa sus huesos contra " + target.getNombre());
						target.setKarma(target.getKarma() + 1);
					}
					else
					{
						danoFinal += 4 + user.getFuerza();
						System.out.println("Un " + Color.PURPLE_BRIGHT + "Gaster Blaster" + Color.RESET + " ataca a " + target.getNombre());
						target.setKarma(target.getKarma() + 2);
					}
				}
				System.out.println("\r\nEl " + Color.CYAN + "karma" + Color.RESET + " de " + target.getNombre() + " ahora es " + Color.RED_BRIGHT + target.getKarma() + Color.RESET + "!\r\n");
				haceDano = true;
				break;
			}
			case "Pollo":
			{
				danoFinal = 6 + user.getFuerza();
				System.out.println("El " + user.getNombre() + " intenta freir a " + target.getNombre());
				if(target.getVelocidad() > -5)
				{
					System.out.println("El ataque " + Color.RED_BRIGHT + "le baja la velocidad a " + Color.RESET + target.getNombre());
					target.setVelocidad(target.getVelocidad() - 3);
					if(target.getVelocidad() < -5)
					{
						target.setVelocidad(-5);
					}
					System.out.println(target.getNombre() + " ahora tiene " + Color.CYAN + target.getVelocidad() + Color.RESET + " puntos de velocidad");
				}
				haceDano = true;
				break;
			}
			case "Despilfarro":
			{
				System.out.println("El " + user.getNombre() + Color.YELLOW + " usa el dinero" + Color.RESET + " de " + target.getNombre() + " en su contra!");
				danoFinal = Juego.monedas(target.getNombre(), target.getMonedas())/5;
				if(target.getMonedas() > 0)
				{
					haceDano = true;
				}
				break;
			}
			case "Pectorales":
			{
				System.out.println("El " + user.getNombre() + Color.CYAN + " prepara sus pectorales" + Color.RESET + " contra el ataque de " + target.getNombre());
				user.setTurnosPectoralesCoronel(1);
				break;
			}
			case "Espadazo Corrupto":
			{
				System.out.println(user.getNombre() + " le pega un espadazo sin rencores a " + target.getNombre());
				danoFinal = 5 + user.getFuerza();
				haceDano = true;
				break;
			}
			case "Flecha Corrupta":
			{
				if(!user.getFlechaRecargada())
				{
					System.out.println("Steve " + Color.CYAN + "recarga una flecha" + Color.RESET + "...");
					user.setFlechaRecargada(true);
				}
				else
				{
					System.out.println("Steve dispara con su arco!");
					danoFinal = 10 + user.getFuerza();
					user.setFlechaRecargada(false);
					haceDano = true;
				}
				break;
			}
			case "Ataque Crítico Corrupto":
			{
				// Selección random del ataque Crítico
				int criticoRandom = random.nextInt(1, 11);
				switch(criticoRandom)
				{
				case 1, 5:
					{
						danoFinal = 1 + user.getFuerza();
						System.out.println(user.getNombre() + " ataca con su espada y le da en el " + Color.GREEN_BRIGHT + "brazo" + Color.RESET + " a " + target.getNombre());
						haceDano = true;
						break;
					}
				case 2, 6:
					{
						danoFinal = 2 + user.getFuerza();
						System.out.println(user.getNombre() + " ataca con su espada y le da en la " + Color.YELLOW + "pierna" + Color.RESET + " a " + target.getNombre());
						haceDano = true;
						break;
					}
				case 3, 7:
					{
						danoFinal = 3 + user.getFuerza();
						System.out.println(user.getNombre() + " ataca con su espada y le da en el " + Color.YELLOW + "estómago" + Color.RESET + " a " + target.getNombre());
						haceDano = true;
						break;
					}
				case 4, 8:
					{
						danoFinal = 4 + user.getFuerza();
						System.out.println(user.getNombre() + " ataca con su espada y le da en el " + Color.RED_BRIGHT + "pecho" + Color.RESET + " a " + target.getNombre());
						haceDano = true;
						break;
					}
				case 9:
					{
						System.out.println(user.getNombre() + " se tropieza y se cae!");
						break;
					}
				case 10:
					{
						danoFinal = 15 + user.getFuerza();
						System.out.println(user.getNombre() + " maneja su espada con total gracia y " + Color.BLACK + "la clava en el cráneo de" + Color.RESET + target.getNombre() + "!");
						haceDano = true;
						break;
					}
				default:
					{
						System.out.println("Error en la selección de random del Ataque Crítico de Steve Enemigo");
					}
				}
				break;
			}
			default:
			{
				System.out.println(Color.RED_BRIGHT + "ERROR EN LA SELEECCION DE ATAQUES DE " + user.getNombre() + Color.RESET);
			}
		}
		
		if(danoFinal > 0 && haceDano && target.getStamina() == 0)
		{
			randomGolpe = random.nextInt(1, 11);
			
			randomGolpe += user.getVelocidad() / 2;
			
			if(randomGolpe >= 5)
			{
				if(target.getNombre().equals("Sans") || target.getNombre().equals("Steve Corrupto") || target.getNombre().equals("Steve") || target.getNombre().equals("Alex") || target.getNombre().equals("Chicken Little"))
				{
					System.out.println("El ataque de " + user.getNombre() + Color.RED_BRIGHT + " impacta totalmente contra " + Color.RESET + target.getNombre());
				}
				else
				{
					System.out.println("El ataque de " + user.getNombre() + Color.RED_BRIGHT + " impacta totalmente contra el " + Color.RESET + target.getNombre());
				}
			}
			else if(randomGolpe >=2 && randomGolpe <= 4)
			{
				if(target.getNombre().equals("Sans") || target.getNombre().equals("Steve Corrupto") || target.getNombre().equals("Steve") || target.getNombre().equals("Alex") || target.getNombre().equals("Chicken Little"))
				{
					System.out.println("El ataque de " + user.getNombre() + Color.YELLOW + " impacta parcialmente contra " + Color.RESET + target.getNombre());
				}
				else
				{
					System.out.println("El ataque de " + user.getNombre() + Color.YELLOW + " impacta parcialmente contra el " + Color.RESET + target.getNombre());
				}
				danoFinal -= danoFinal/2;//impactar parcialmente
			}
			else
			{
				if(target.getNombre().equals("Sans") || target.getNombre().equals("Steve Corrupto") || target.getNombre().equals("Steve") || target.getNombre().equals("Alex") || target.getNombre().equals("Chicken Little"))
				{
					System.out.println("El ataque de " + user.getNombre() + Color.CYAN + " es esquivado por " + Color.RESET + target.getNombre() + "!");
				}
				else
				{
					System.out.println("El ataque de " + user.getNombre() + Color.CYAN + " es esquivado por el " + Color.RESET + target.getNombre() + "!");
				}
				danoFinal = 0;//esquivar ataque
			}
			if(danoFinal > 0 && target.getTurnosPectoralesCoronel() > 0)
			{
				System.out.println("\r\nEl " + target.getNombre() + " se protege con sus pectorales!");
				System.out.println("El " + target.getNombre() + " reflecta todo el daño!");
				user.setVida(user.getVida() - danoFinal);
				System.out.println(user.getNombre() + " ahora tiene " + (user.getVida() > user.getVidaMax() / 2 ? Color.GREEN_BRIGHT : (user.getVida() > user.getVidaMax() / 4 ? Color.YELLOW : Color.RED_BRIGHT)) + dfOneDecimal.format(user.getVida()) + Color.RESET + "/" + Color.GREEN_BRIGHT + dfZeroDecimal.format(user.getVidaMax()) + Color.RESET + " puntos de vida.");
			}
			else
			{
				if(danoFinal > 0 && randomGolpe != 1)
				{
					if(user.getPenalizacionAtaque() > 0)
					{
						danoFinal -= user.getPenalizacionAtaque();
					}
					if(user.getDanoExtra() > 0)
					{
						danoFinal += user.getDanoExtra();
						user.setDanoExtra(0);
					}
					if(target.getDefensa() > 0)
					{
						danoFinal -= (danoFinal * ((target.getDefensa() - target.getPenalizacionDefensa()) / 2)) / 10; // cálculo de defensa
					}
					target.setVida(target.getVida() - danoFinal);
					if(target.getNombre().equals("Sans") || target.getNombre().equals("Steve Corrupto") || target.getNombre().equals("Steve") || target.getNombre().equals("Alex") || target.getNombre().equals("Chicken Little"))
					{
						System.out.println(user.getNombre() + " hace " + Color.RED_BRIGHT + danoFinal + Color.RESET + " puntos de daño a " + target.getNombre() + "."
								+ " Ahora le quedan " + (target.getVida() > target.getVidaMax() / 2 ? Color.GREEN_BRIGHT : (target.getVida() > target.getVidaMax() / 4 ? Color.YELLOW : Color.RED_BRIGHT)) + dfOneDecimal.format(target.getVida()) + Color.RESET + "/" + Color.GREEN_BRIGHT + dfZeroDecimal.format(target.getVidaMax()) + Color.RESET + " puntos de vida.");
					}
					else
					{
						System.out.println(user.getNombre() + " hace " + Color.RED_BRIGHT + danoFinal + Color.RESET + " puntos de daño al "
										+ target.getNombre() + ". Ahora le quedan " + (target.getVida() > target.getVidaMax() / 2 ? Color.GREEN_BRIGHT : (target.getVida() > target.getVidaMax() / 4 ? Color.YELLOW : Color.RED_BRIGHT)) + dfOneDecimal.format(target.getVida()) + Color.RESET + "/" + Color.GREEN_BRIGHT + dfZeroDecimal.format(target.getVidaMax()) + Color.RESET + " puntos de vida.");
					}
				}
				else
				{
					if(target.getNombre().equals("Sans") || target.getNombre().equals("SteveCorrupto") || target.getNombre().equals("Steve") || target.getNombre().equals("Alex") || target.getNombre().equals("Chicken Little"))
					{
						System.out.println(target.getNombre() + " " + Color.RED_BRIGHT + "no recibe daño este turno...\n" + Color.RESET);
					}
					else
					{
						System.out.println("El " + target.getNombre() + Color.RED_BRIGHT + " no recibe daño este turno...\n" + Color.RESET);
					}
				}
			}
		}
		else if(target.getNombre().equals("Sans"))
		{
			System.out.println(target.getNombre() + " esquiva el ataque!");
		}
		
	}
	
}
