package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Juego {
	//Atributos
	private static Juego instanciaJuego;//singelton, garantiza que tan solo exista un (objeto) juego 
	private static Protagonista prota;//protagonista elegido (vacío)
	private Combate combate;//clase combate, que recibre el nombre de combate
	private Eventos evento;//clase eventos, que recibre el nombre de evento
	
	private Juego() {//permite que se pueda usar en esta clase
		combate = new Combate();
		evento = new Eventos();
	}
	
	public static Juego getInstanciaJuego() {
        if (instanciaJuego == null) {//si no se ha creado el juego, se crea
        	instanciaJuego = new Juego();
        }
        return instanciaJuego;//si ya está creado
    }
	
	
	public void elegirPersonaje() {
				Scanner sc = new Scanner(System.in);
				Random random = new Random();
				
				prota = new Protagonista();//protagonista elegido
		//		
		//		//Indica el ascii a imprimir
		//		int ascii = 0;
		//		
		//		printAscii(1);
		//		
		//		System.out.println("Un juego creado por: Pelayo Santos, Aitana Herranz y Diego Baudot");
		//		
		//		contrasena(sc);
		//		
		//		
		//		
		//		
		////		System.out.println(RESET + "Te damos la bienvenida");
		////		System.out.println("¿Qué personaje quieres usar?");
		////		System.out.println("1- " + BLUE_BRIGHT +  "Steve" + RESET);
		////		System.out.println("Steve es un guerrero que busca la venganza por la muerte de su mascota\n");
		////		System.out.println("2- " + GREEN_BRIGHT + "Alex" + RESET);
		////		System.out.println("Alex es una luchadora que tiene sed de sangre\n");
		////		System.out.println("3- " + YELLOW + "Gallina" + RESET);
		////		System.out.println("Chicken Little.\n");
		//		System.out.println(RESET + "¡BIENVENIDO AL MUNDO DE MINECRAFT!");
		//		
		//		System.out.println("¡PARA EMPEZAR ELIJE EL PERSONAJE QUE MAS TE GUSTE!");
		//        System.out.println(YELLOW + "\r\n▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\r\n" + RESET   
		//        					+ YELLOW + "▓▓" + RESET + BLACK_BRIGHT + "▒" + RESET + " 1- " + BLUE_BRIGHT +  "Steve    " + RESET + BLACK_BRIGHT + "  ▒" + RESET + " 2- " + GREEN_BRIGHT + "Alex     " + RESET + BLACK_BRIGHT + "  ▒" + RESET + " 3- " + YELLOW + "Chicken Little" + RESET + BLACK_BRIGHT + "▒" + RESET  + YELLOW + "▓▓" + RESET + "\r\n"
		//        					+ YELLOW + "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓" + BLACK_BRIGHT +"▓▓▓▓" + YELLOW +"▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\r\n" + RESET 
		//        					+ YELLOW + "▓▓" + RESET + BLACK_BRIGHT + "▒" + RESET + " Vida= " + GREEN + 20 + RESET + BLACK_BRIGHT + "      ▒" + RESET + " Vida= " + GREEN + 30 + RESET + BLACK_BRIGHT + "      ▒" + RESET + " Vida= " + GREEN + 15 + RESET + BLACK_BRIGHT + "         ▒" + RESET + YELLOW + "▓▓" + RESET + "\r\n"
		//        					+ YELLOW + "▓▓" + RESET + BLACK_BRIGHT + "▒" + RESET + " Fuerza= " + PURPLE + 1 + RESET + BLACK_BRIGHT + "     ▒" + RESET + " Fuerza= " + PURPLE + 0 + RESET + BLACK_BRIGHT + "     ▒" + RESET + " Fuerza= " + PURPLE + 0 + RESET + BLACK_BRIGHT + "        ▒" + RESET + YELLOW + "▓▓" + RESET + "\r\n"
		//        					+ YELLOW + "▓▓" + RESET + BLACK_BRIGHT + "▒" + RESET + " Armadura= " + BLUE + 0 + RESET + BLACK_BRIGHT + "   ▒" + RESET + " Armadura= " + BLUE + 0 + RESET + BLACK_BRIGHT + "   ▒" + RESET + " Armadura= " + BLUE + 0 + RESET + BLACK_BRIGHT + "      ▒" + RESET + YELLOW + "▓▓" + RESET + "\r\n" 
		//        					+ YELLOW + "▓▓" + RESET + BLACK_BRIGHT + "▒" + RESET + " Agilidad= " + YELLOW_BRIGHT + 3 + RESET + BLACK_BRIGHT + "   ▒" + RESET + " Agilidad= " + YELLOW_BRIGHT + 1 + RESET + BLACK_BRIGHT + "   ▒" + RESET +" Agilidad= " + YELLOW_BRIGHT + 3.5 + RESET + BLACK_BRIGHT + "    ▒" + RESET + YELLOW + "▓▓" + RESET + "\r\n"
		//        					+ YELLOW + "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\r\n" + RESET);
		//		
		//		String eleccionPersonajeString = "";
		//		String nombrePersonaje = "";
		//		String lorePersonaje = "";
		//		String[] infoPersonajes = new String[4];
		//		double vidaMaxPersonaje = 0;
		//		double defensaPersonaje = 0;
		//		double velocidadPersonaje = 0;
		//		double fuerzaPersonaje = 0;
		//		double suertePersonaje = 0;
		//		double espinasPersonaje = 0;
		//		int numeroMonedas = 15;
		//		boolean recargaRapidaPersonaje = false;
		//		boolean niebla = false;
		//		
		//		
		//		do
		//		{
		//			System.out.println(WHITE_BOLD_BRIGHT + "                       ELIGE \r\n"
		//									+ BLUE_BOLD_BRIGHT + "                     1 " + RESET + "|" + GREEN_BOLD_BRIGHT + " 2 " + RESET +"|" + YELLOW_BOLD_BRIGHT + " 3 " + CYAN_BRIGHT);
		//			eleccionPersonajeString = sc.nextLine();
		//		}
		//		while(!eleccionPersonajeString.equals("1") && !eleccionPersonajeString.equals("2") && !eleccionPersonajeString.equals("3"));
		//		switch(eleccionPersonajeString)
		//			{
		//			case "1":
		//				{
		//					nombrePersonaje = "Steve";
		//					vidaMaxPersonaje = 20;
		//					defensaPersonaje = 0;
		//					velocidadPersonaje = 3;
		//					fuerzaPersonaje = 1;
		//					ascii= 2;
		//					lorePersonaje = "Guerrero movido por la venganza, obsesionado con derrotar al dragón por venganza\r\n";
		//					infoPersonajes[0] = "1.Espada: 3 de daño";
		//					infoPersonajes[1] = "2.Arco: 7 de daño, pero tienes que recargar para usar otra vez";
		//					infoPersonajes[2] =	"3.Ataque crítico: 0-15 de daño";
		//					infoPersonajes[3] =	"Aumenta la probabilidad de evitar trampas y mayor conocimiento en puzzles";
		//					break;
		//				}
		//			case "2":
		//				{
		//					nombrePersonaje =  "Alex";
		//					vidaMaxPersonaje = 30;
		//					defensaPersonaje = 0;
		//					velocidadPersonaje = 1;
		//					ascii= 3;
		//					lorePersonaje = "Guerrera maldita por su tribu. Su maldicion la obliga a seguir enfrentando enemigos y la impide usar objetos de cura.\r\n";
		//					infoPersonajes[0] = "1.Hacha: 5 de daño";
		//					infoPersonajes[1] = "2.Poción de fuerza: Incrementa el daño del siguiente ataque en +4 de daño";
		//					infoPersonajes[2] =	"3.Maldición del wither: Reduce la vida del enemigo en un 20% de su vida actual. Solo se puede usar una vez cada 3 turnos";
		//					infoPersonajes[3] =	"Solo puede regenerar vida matando enemigos. Cada vez que derrota a un enemigo, recupera el 10% de su HP";
		//					
		//					
		//					break;
		//				}
		//			case "3":
		//				{
		//					nombrePersonaje = "Chicken Little";
		//					vidaMaxPersonaje = 15;
		//					defensaPersonaje = 0;
		//					velocidadPersonaje = 3.5;
		//					ascii= 4;
		//					lorePersonaje = "Un pollo fugitivo, buscado por el KFC desde pequeño.\r\n";
		//					infoPersonajes[0] = "1.Tricotada: 2 de daño x 3 veces";
		//					infoPersonajes[1] = "2.Ataque Huevo: 4 de daño y +1 pollo";
		//					infoPersonajes[2] =	"3.Llamada de pollos: te cubres de pollos y la siguiente vez que te ataquen, harás 4x el nº de pollos que tengas";
		//					infoPersonajes[3] =	"Aumenta la probabilidad de huir cuando su HP es menor del 50%. (60% de probabilidad de escape en estas condiciones)";
		//					break;
		//				}
		//			default:
		//				{
		//					System.out.println("Ha ocurrido un error en la selección de personaje, " + eleccionPersonajeString + " no esta disponible.");
		//				}
		//			}
		//		
		//		double vidaPersonaje = vidaMaxPersonaje;
		//		
		//		System.out.println(RESET + "Has escogido a...\r\n");
		//		System.out.println("                    " + YELLOW_BOLD_BRIGHT + nombrePersonaje.toUpperCase() + "\r\n" + RESET);// toUpperCase vuelve el String todo a Mayúsculas
		//		
		//		printAscii(ascii);
		//		
		//		System.out.println("Informacion del personaje:\n");
		//		System.out.println(lorePersonaje);
		//		System.out.println(WHITE_UNDERLINED + "Stats:" + RESET + "           " + WHITE_UNDERLINED +  "Ataques:\r\n" + RESET);
		//		System.out.println("Vida: " + vidaPersonaje + "     | " + infoPersonajes[0]);
		//		System.out.println("Defensa: " + defensaPersonaje + "   | " + infoPersonajes[1]);
		//		System.out.println("Fuerza: " + fuerzaPersonaje + "    | " + infoPersonajes[2]);
		//		System.out.println("Veolcidad: " + velocidadPersonaje + " | Pasiva:" + infoPersonajes[3] + "\n");
		//		
		//		System.out.println(WHITE_BOLD_BRIGHT + "¡¡BUENA SUERTE!!\n" + RESET);
		//		
		//		System.out.println("[PRESIONA CUALQUIER CARACTER PARA INICIAR TU AVENTURA]");
		//		sc.nextLine();
		
		
	}

	public void seleccionCaminos(Random random, Scanner scanner, String nombrePersonaje) {
		
		String[] listaCaminos = {Color.RED_BRIGHT + "Combate" + Color.RESET, Color.CYAN + "Evento Aleatorio" + Color.RESET, Color.YELLOW + "Mercader" + Color.RESET};
		
		System.out.println("Elige un camino");
		
		// Selección de Caminos
				// Para seleccionar caminos, creamos una Lista de Strings en la que vamos añadiendo el nombre de un evento random
				// Al mismo tiempo, tenemos una Lista de int en la que vamos añadiendo numeros 1, 2, 3..., la cual nos sirve para comprobar
				// si la selección que mete el usuario por pantalla existe de verdad, y si existe, la podemos coger desde la primera Lista
				int numeroCaminos = random.nextInt(2, 5);
				int eventoRandom = 0;
				int contadorOpciones = 1;
				
				List<String> listaOpcionesPosibles = new ArrayList<String>();
				
				List<String> caminosDisponibles = new ArrayList<String>();
				
				while(numeroCaminos > 0)
				{
					eventoRandom = random.nextInt(listaCaminos.length);
					// Lista con String del nombre del evento
					caminosDisponibles.add(listaCaminos[eventoRandom]);
					numeroCaminos--;
					
					// Lista con numeros desde 1 hasta x, según el número de eventos que haya
					listaOpcionesPosibles.add(Integer.toString(contadorOpciones));
					contadorOpciones++;
				}
				
				boolean seleccionCorrecta = false;
				
				String seleccionCamino = "";
				
				while(!seleccionCorrecta)
				{
					System.out.println("A dónde irá " + nombrePersonaje + " ahora...");
					
					// Imprimimos las opciones
					for(int i = 0; i < caminosDisponibles.size(); i++)
					{
						System.out.println((i+1) + ". " + caminosDisponibles.get(i));
					}
					seleccionCamino = scanner.nextLine();
					
					// Comprobamos si el número ingresado por pantalla está en la Lista de números disponibles
					for(Object opcion : listaOpcionesPosibles)
					{
						if(seleccionCamino.equals(opcion))
						{
							seleccionCorrecta = true;
						}
					}
					if(!seleccionCorrecta)
					{
						System.out.println(nombrePersonaje + " no parece muy decidido...");
						System.out.println("(Escoge con números)\r\n");
					}
				}
				
				// Guardamos el nombre de selección elegida en String
				String seleccionStr = (String) caminosDisponibles.get(Integer.valueOf(seleccionCamino) - 1);
				
				
				switch(seleccionStr) {
					case Color.RED_BRIGHT + "Combate" + Color.RESET: 
						//Combate le pasa un prota y las informacion disponible para el combate
						
					break;
					case "Evento Aleatorio" + Color.RESET, Color.YELLOW + "Mercader" + Color.RESET:
						evento.elegirEvento(prota);
					break;
				}
				
	}
}
