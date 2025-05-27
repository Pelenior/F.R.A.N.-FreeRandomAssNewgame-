package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Juego {
	//Atributos
	private static Juego instanciaJuego;//singelton, garantiza que tan solo exista un (objeto) juego 
	private static Protagonista prota;//protagonista elegido (vacío)
	private Combate combate;//clase combate, que recibe el nombre de combate
	private Eventos evento;//clase eventos, que recibe el nombre de evento
	
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
	
	//inicio juego
	public static void contrasena(Scanner sc) {
		String password = "jugones";
		String contrasena = "";
		
		// mientras la contraseña no sea la correcta, seguirá preguntando
		do
		{
			System.out.println(Color.RESET + "Contraseña: " + Color.RED_BRIGHT);
			contrasena = sc.nextLine();
		}
		while(!contrasena.equals(password));
		System.out.println(Color.GREEN_BRIGHT + "CONTRASEÑA ACEPTADA \n" + Color.RESET);
	}
	
	public static void elegirPersonaje() {
		
				Scanner sc = new Scanner(System.in);
				Random random = new Random();
				
				//Indica el ascii a imprimir
				ASCII.printAscii(0);
				
				System.out.println("Un juego creado por: Pelayo Santos, Aitana Herranz y Diego Baudot");
				
				contrasena(sc);
				
				System.out.println(Color.WHITE_BOLD_BRIGHT + "¡BIENVENIDO AL MUNDO DE MINECRAFT!\n");	
				System.out.println("¡PARA EMPEZAR ELIJE EL PERSONAJE QUE MAS TE GUSTE!\n");
		        ASCII.printAscii(1);
		        
				String eleccionPersonajeString = "";
				int asciiProta;
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
				do
				{
					System.out.println(Color.WHITE_BOLD_BRIGHT + "                       ELIGE \r\n"
											+ Color.BLUE_BOLD_BRIGHT + "                     1 " + Color.RESET + "|" + Color.GREEN_BOLD_BRIGHT + " 2 " + Color.RESET +"|" + Color.YELLOW_BOLD_BRIGHT + " 3 " + Color.CYAN_BRIGHT + Color.WHITE_BOLD_BRIGHT);
					eleccionPersonajeString = sc.nextLine();
				}
				while(!eleccionPersonajeString.equals("1") && !eleccionPersonajeString.equals("2") && !eleccionPersonajeString.equals("3"));
				
				switch(eleccionPersonajeString)
					{
					case "1":
						{
							prota = new Protagonista("Steve", 20, 0, 1, 3, 2);//protagonista elegido- CAMBIARLO CUANDO HAYA DB
							//ESTO METERLO DENTRO DE UNA DB
//							nombrePersonaje = "Steve";
//							vidaMaxPersonaje = 20;
//							defensaPersonaje = 0;
//							velocidadPersonaje = 3;
//							fuerzaPersonaje = 1;
//							lorePersonaje = "Guerrero movido por la venganza, obsesionado con derrotar al dragón por venganza\r\n";
//							infoPersonajes[0] = "1.Espada: 3 de daño";
//							infoPersonajes[1] = "2.Arco: 7 de daño, pero tienes que recargar para usar otra vez";
//							infoPersonajes[2] =	"3.Ataque crítico: 0-15 de daño";
//							infoPersonajes[3] =	"Aumenta la probabilidad de evitar trampas y mayor conocimiento en puzzles";
							break;
						}
					case "2":
						{
							prota = new Protagonista("Alex", 30, 0, 0, 1, 3);//protagonista elegido- CAMBIARLO CUANDO HAYA DB
							//ESTO METERLO DENTRO DE UNA DB
//							nombrePersonaje =  "Alex";
//							vidaMaxPersonaje = 30;
//							defensaPersonaje = 0;
//							velocidadPersonaje = 1;
//							lorePersonaje = "Guerrera maldita por su tribu. Su maldicion la obliga a seguir enfrentando enemigos y la impide usar objetos de cura.\r\n";
//							infoPersonajes[0] = "1.Hacha: 5 de daño";
//							infoPersonajes[1] = "2.Poción de fuerza: Incrementa el daño del siguiente ataque en +4 de daño";
//							infoPersonajes[2] =	"3.Maldición del wither: Reduce la vida del enemigo en un 20% de su vida actual. Solo se puede usar una vez cada 3 turnos";
//							infoPersonajes[3] =	"Solo puede regenerar vida matando enemigos. Cada vez que derrota a un enemigo, recupera el 10% de su HP";
							break;
						}
					case "3":
						{
							prota = new Protagonista("Chicken Little", 15, 0, 0, 3.5, 4);//protagonista elegido- CAMBIARLO CUANDO HAYA DB			
							//ESTO METERLO DENTRO DE UNA DB
//							nombrePersonaje = "Chicken Little";
//							vidaMaxPersonaje = 15;
//							defensaPersonaje = 0;
//							velocidadPersonaje = 3.5;
//							lorePersonaje = "Un pollo fugitivo, buscado por el KFC desde pequeño.\r\n";
//							infoPersonajes[0] = "1.Tricotada: 2 de daño x 3 veces";
//							infoPersonajes[1] = "2.Ataque Huevo: 4 de daño y +1 pollo";
//							infoPersonajes[2] =	"3.Llamada de pollos: te cubres de pollos y la siguiente vez que te ataquen, harás 4x el nº de pollos que tengas";
//							infoPersonajes[3] =	"Aumenta la probabilidad de huir cuando su HP es menor del 50%. (60% de probabilidad de escape en estas condiciones)";
							break;
						}
					default:
						{
							System.out.println(Color.RED_BOLD_BRIGHT + "Ha ocurrido un error en la selección de personaje, " + eleccionPersonajeString + " no esta disponible." + Color.WHITE_BOLD_BRIGHT);
						}
					}
				
		//		double vidaPersonaje = vidaMaxPersonaje;
				
				System.out.println(Color.RESET + "Has escogido a...\r\n");
				System.out.println("                    " + Color.YELLOW_BOLD_BRIGHT + prota.getNombre().toUpperCase() + "\r\n" + Color.RESET);// toUpperCase vuelve el String todo a Mayúsculas
				
				ASCII.printAscii(prota.getIdAscii());
				
				System.out.println("Informacion del personaje:\n");
		//		System.out.println(lorePersonaje); ESTO VA CON LA DB
				System.out.println(Color.WHITE_UNDERLINED + "Stats:" + Color.RESET + "           " + Color.WHITE_UNDERLINED +  "Ataques:\r\n" + Color.RESET);
				System.out.println("Vida: " + prota.getVida()); //+ "     | " + infoPersonajes[0]); ESTO VA CON LA DB
				System.out.println("Defensa: " + prota.getDefensa()); //+ "   | " + infoPersonajes[1]); ESTO VA CON LA DB
				System.out.println("Fuerza: " + prota.getFuerza()); //+ "    | " + infoPersonajes[2]); ESTO VA CON LA DB
				System.out.println("Veolcidad: " + prota.getVelocidad()); // + " | Pasiva:" + infoPersonajes[3] + "\n"); ESTO VA CON LA DB
				
				System.out.println(Color.WHITE_BOLD_BRIGHT + "¡¡BUENA SUERTE!!\n" + Color.RESET);
				
				System.out.println("[PRESIONA CUALQUIER CARACTER PARA INICIAR TU AVENTURA]");
				sc.nextLine();
		
		
	}

	public void seleccionCaminos(Random random, Scanner scanner, String nombrePersonaje) {
		
		String[] listaCaminos = {Color.RED_BRIGHT + "Combate" + Color.RESET, Color.CYAN + "Evento Aleatorio" + Color.RESET, Color.YELLOW + "Mercader" + Color.RESET};
		
		System.out.println("Elige un camino");
		
		// Selección de Caminos
				// Para seleccionar caminos, creamos una Lista tipo String que añade el nombre de un evento random
				// Al mismo tiempo, hay una Lista int en la que hay números que sirve para comprobar
				// si la elección del usuario existe, y si existe, la podemos coger desde la primera Lista
				int numeroCaminos = random.nextInt(2, 5);//número random entre 2 y 4 caminos
				int eventoRandom = 0;//el camino aleatorio
				int contadorOpciones = 1;//contador
				
				List<String> listaOpcionesPosibles = new ArrayList<String>();
				
				List<String> caminosDisponibles = new ArrayList<String>();
				
				while(numeroCaminos > 0)
				{
					eventoRandom = random.nextInt(listaCaminos.length);//aleatoriamente se elige un camino de la lista
					// Lista con String del nombre del evento
					caminosDisponibles.add(listaCaminos[eventoRandom]);//lista de caminos
					numeroCaminos--;
					
					// Lista con numeros desde 1 hasta x, según el número de eventos que haya
					listaOpcionesPosibles.add(Integer.toString(contadorOpciones));//lista que enumera los caminos
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
						System.out.println((i+1) + ". " + caminosDisponibles.get(i));//imprime el camino seleccionado
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
				String seleccionStr = (String) caminosDisponibles.get(Integer.valueOf(seleccionCamino) - 1);//guarda camino
				
				
				switch(seleccionStr) {//ir al camino (evento) elegido, que puede ser o
					case Color.RED_BRIGHT + "Combate" + Color.RESET: 
						if(combate.combate(prota, "Normal"))
						{
							
						}
						else
						{
							
						}
						
					break;
					case "Evento Aleatorio" + Color.RESET, Color.YELLOW + "Mercader" + Color.RESET:
						evento.elegirEvento(prota);
					break;
				}
				
	}
	
	public static int monedas(String nombrePersonaje, int numeroEsmeraldas)
	{
		int monedas = numeroEsmeraldas;
		if(nombrePersonaje.equals("Chicken Little"))
		{
			monedas *= 5;// si eres Chicken Little, tienes 5 veces el número de semillas
		}
		return monedas;
	}
}
