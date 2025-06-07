package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;

import dao.*;

public class Juego {
	//Atributos
	private static Juego instanciaJuego;//singelton, garantiza que tan solo exista un (objeto) juego 
	private Protagonista prota;//protagonista elegido (vacío)
	private Combate combate;//clase combate, que recibe el nombre de combate
	private Eventos evento;//clase eventos, que recibe el nombre de evento
	
	private String nombreJugador;
	private String pasiva;
	
	private DaoPersonajes daoPersonajes = new DaoPersonajes();
	private DaoAtaques daoAtaques = new DaoAtaques();
	
	int puntuacion;
	int totalPuntuacion;

	private Random random;
	private int numeroSalas = 0;
	private Scanner sc;
	
	public static boolean gameOver = false;
	
	private static boolean hasLambo = false;
	private boolean haHuidoAlgunaVez = false;
	
	// FINALES
	private static boolean finalKillDragonSteve = false;
	private static boolean finalKillDragonPerroSteve = false;
	private static boolean finalHuirPerroSteve = false;
	private static boolean finalHuirSteve = false;
	
	private static boolean finalKillSansNoGenocideAlex = false;
	private static boolean finalKillSansGenocideAlex = false;
	private static boolean finalLigarAlex = false;
	private static boolean finalMascotaAlex = false;
	
	private static boolean finalDrogasChickenLittle = false;
	private static boolean finalBitcoinChickenLittle = false;
	private static boolean finalLamboChickenLittle = false;
	private static boolean finalKillCoronel = false;
	
	public Juego() throws SQLException {//permite que se pueda usar en esta clase
		combate = new Combate();
		evento = new Eventos();
		sc = new Scanner(System.in);
		random = new Random();
	}
	
	public static Juego getInstanciaJuego() throws SQLException {
        if (instanciaJuego == null) {//si no se ha creado el juego, se crea
        	instanciaJuego = new Juego();
        }
        return instanciaJuego;//si ya está creado
    }
	
	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public void comenzar() throws SQLException
	{
		contrasena(sc);
		elegirPersonaje(sc, random);
		
		//bucle del juego
		bucleJuego();
	}
	
	//inicio juego
	public void contrasena(Scanner sc) throws SQLException{
		String decision;
		String contrasena = "";
		DaoJugador perfil = new DaoJugador();
		int idAscii = 99;
		boolean AsciiBien = false;
		
//		principios();
		
		do {
			System.out.println("Bienvenido desconocido usuario, elija su forma de inicio: \n  1.Nuevo Perfil | 2.Perfil existente");
			decision = sc.nextLine();
			
		}while(!decision.equals("1") && !decision.equals("2"));
		
		do {
			if(decision.equals("1")) {
				System.out.println("De acuerdo desconocido cree un Nuevo Perfil:");
				
				do {
					
					System.out.println("\nNombre:");
					nombreJugador = sc.nextLine();
					if (perfil.comprobarNombre(nombreJugador) == false) {
						System.out.println("Ese perfil ya existe\nIniciar sesion: 1.No 2.Si");
						decision = sc.nextLine();
					}
					
				}while(perfil.comprobarNombre(nombreJugador) == false && !decision.equals("2"));
					
				if (!decision.equals("2")) {
					System.out.println("Contraseña:");
					contrasena = sc.nextLine();
							
					do {
						try {
							System.out.println("Elija un valor del 1-100:");
							idAscii = sc.nextInt();
							AsciiBien = true;
						}catch(Exception e) {
							System.out.println("El valor debe ser un numero");
							AsciiBien = false;
						}
					}while(AsciiBien == false);
							
					perfil.guardarJugador(nombreJugador, contrasena, idAscii, 0);
					System.out.println("De acuerdo " + nombreJugador + " su perfil se ha guardado correctamente\nPor seguridad inicie sesion para saber que todo esta correcto");
				
				}		
			}
			if(decision.equals("2")) {
				System.out.println("\nBienvenido de nuevo pues, rellene sus datos para saber que es usted:\n");
			}
			
			System.out.println("Repita su Nombre:");
			nombreJugador = sc.nextLine();
			
			System.out.println("Repita su Contraseña:");
			contrasena = sc.nextLine();
			
			if (perfil.inicioSesion(nombreJugador, contrasena) == false) {
				System.out.println(Color.RED_BOLD_BRIGHT + "El nombre o contraseña son incorrectos" + Color.RESET);
			}
			
		}while(perfil.inicioSesion(nombreJugador, contrasena) == false);
		
		System.out.println("\nGenial, este eres tu\n                      " + Color.YELLOW_BOLD_BRIGHT + nombreJugador.toUpperCase() + Color.RESET);
		ASCII.printAscii(perfil.getAscii(nombreJugador));
		
		System.out.println("Te doy la bienvenida final al mundo de Minecraft,\nde ahora en adelante, ELIJA SU PROPIA AVENTURA\n\n" + Color.WHITE_BOLD_BRIGHT + "[PULSE ENTER PARA CONTINUAR]");
		sc.nextLine();
		
	}
	
	private void elegirPersonaje(Scanner sc, Random random) throws SQLException {
				
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
							prota = daoPersonajes.getDataProta("Steve");//protagonista elegido- CAMBIARLO CUANDO HAYA DB
							prota.setVida(prota.getVidaMax());
							pasiva = "Guerrera maldita por su tribu. Su maldicion la obliga a seguir enfrentando enemigos y la impide usar objetos de cura";
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
							prota = daoPersonajes.getDataProta("Alex");//protagonista elegido- CAMBIARLO CUANDO HAYA DB
							prota.setVida(prota.getVidaMax());
							pasiva = "Aumenta la probabilidad de evitar trampas y mayor conocimiento en puzzles";
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
							prota = daoPersonajes.getDataProta("Chicken Little");//protagonista elegido- CAMBIARLO CUANDO HAYA DB	
							prota.setVida(prota.getVidaMax());
							pasiva = "Un pollo fugitivo, buscado por el KFC desde pequeño";
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
				
				System.out.println(Color.RESET + "Has escogido a...\r\n");
				System.out.println("                    " + Color.YELLOW_BOLD_BRIGHT + prota.getNombre().toUpperCase() + "\r\n" + Color.RESET);// toUpperCase vuelve el String todo a Mayúsculas
				
				ASCII.printAscii(prota.getIdAscii());
				
				
				System.out.println("Informacion del personaje:\n");
				lore();
				System.out.println("  " + Color.WHITE_UNDERLINED + "Stats:" + Color.RESET + "           " + Color.WHITE_UNDERLINED +  "Ataques:\r\n" + Color.RESET);
				System.out.println("  Vida: " + prota.getVidaMax() + "     | " + "1: " + prota.selectAllAtaques().get(0) + ": " + daoAtaques.getDesc(prota.selectAllAtaques().get(0)));
				System.out.println("  Defensa: " + prota.getDefensa() + "   | " + "2: " + prota.selectAllAtaques().get(1)+ ": " + daoAtaques.getDesc(prota.selectAllAtaques().get(1)));
				System.out.println("  Fuerza: " + prota.getFuerza() + "    | " + "3: " + prota.selectAllAtaques().get(2)+ ": " + daoAtaques.getDesc(prota.selectAllAtaques().get(2)));
				System.out.println("  Veolcidad: " + prota.getVelocidad() + " | " + "4: " + pasiva);
				
				System.out.println(Color.WHITE_BOLD_BRIGHT + "\n¡¡BUENA SUERTE!!\n" + Color.RESET);
				
				System.out.println("[PRESIONA CUALQUIER CARACTER PARA INICIAR TU AVENTURA]");
				sc.nextLine();
		
		
	}
	
	private void lore()
	{
		//mensaje
		if(numeroSalas == 4)
		{
			switch(prota.getNombre())
			{
				case "Steve":
				{
					System.out.println(prota.getNombre() + " está avanzando por el bosque, donde encuentra su antigua casa");
					System.out.println("Es una casa hecha por tierra, tiene marcas de llamas y quemaduras y está casi derrumbada");
					System.err.println("Aquí es donde vivió " + prota.getNombre() + ", antes de el trágico evento que provocó la ira de Steve contra el Dragón...\r\n");
					break;
				}
				case "Alex":
				{
					System.out.println(prota.getNombre() + " se encuentra con el pueblo donde creció");
					System.out.println("Antes, Alex era una niña tranquila que no quería hacer daño a nadie");
					System.out.println("Su clan, sin embargo, no estaba de acuerdo con esto, y la tuvieron que maldecir para que se vuelva agresiva");
					System.out.println("Enfadada, " + prota.getNombre() + " sigue su camino sin mirar atrás\r\n");
					break;
				}
				case "Chicken Little":
				{
					System.out.println(prota.getNombre() + " se sienta y contempla su viaje");
					System.out.println("El fin de " + prota.getNombre() + " es terminar con el KFC, ya que le llevan persiguiendo mucho tiempo");
					System.out.println("¿Pero por qué?");
					System.out.println("¿Solo querrán un pollo de buena calidad...?");
					System.out.println(prota.getNombre() + " se levanta y continua con su aventura\r\n");
					break;
				}
			}
			System.out.println();
		}
		else if(numeroSalas == 9)
		{
			switch(prota.getNombre())
			{
				case "Steve":
				{
					
					if(prota.getNiebla())
					{
						System.out.println(prota.getNombre() + " está andando con Niebla a su lado, pensando en la suerte que tiene de poder revivirlo");
						System.out.println("Resulta que el Dragón fue el que provocó la pérdida de Niebla!");
						System.out.println(prota.getNombre() + " se agarra a su espada y continua su aventura\r\n");
					}
					else
					{
						System.out.println(prota.getNombre() + " está pensando en Niebla, su perro fallecido");
						System.out.println(prota.getNombre() + " recuerda la noche en la que lo perdió como si fuera ayer...");
						System.out.println("Resulta que el Dragón escupió su fuego morado contra la casa de " + prota.getNombre() + ", lo que provocó la muerte de Niebla");
						System.out.println(prota.getNombre() + " se agarra a su espada y continua su aventura\r\n");
					}
					break;
				}
				case "Alex":
				{
					System.out.println(prota.getNombre() + " está caminando por un pantano, donde se encuentra con una casa de brujas");
					System.out.println(prota.getNombre() + " recuerda cuando fue maldita, resulta que la maldición la hace agresiva y la convierte en una Bruja lentamente");
					System.out.println("La única forma que tiene de salvarse es llenando su sed de sangre con sus víctimas... verdad?\r\n");
					break;
				}
				case "Chicken Little":
				{
					System.out.println(prota.getNombre() + " mira a uno de sus pollitos que salió de uno de sus ataques huevo");
					System.out.println(prota.getNombre() + " lo sube a sus brazos y lo acaricia...");
					System.out.println("\"Pronto acabará el imperio del KFC...\"-Dice Chicken Little");
					System.out.println("Resulta que " + prota.getNombre() + " es perseguido por el KFC ya que tiene la habilidad de crear pollos infinitos...");
					System.out.println("Pero " + prota.getNombre() + " tiene planes diferentes...");
					System.out.println(prota.getNombre() + " pretende crear su propio imperio de pollos!");
					System.out.println(prota.getNombre() + " deja en el suelo a su pollito y continua su camino\r\n");
					break;
				}
			}
		}
		else {
			switch(prota.getNombre()) {
			
				case "Steve":
					System.out.println("Lore: Guerrero movido por la venganza, obsesionado con derrotar al dragón por venganza.\n");
					break;
					
				case "Alex":
					System.out.println("Lore: Guerrera maldita por su tribu. Su maldicion la obliga a seguir enfrentando enemigos y la impide usar objetos de cura.\n");
					break;
					
				case "Chsicken Little":
					System.out.println("Lore: Un pollo fugitivo, buscado por el KFC desde pequeño.\n");
					break;
			}
			
		}
	}

	private void bossBattle() throws SQLException
	{
		System.out.println("La historia de " + prota.getNombre() + " está llegando a su fin...");
		System.out.println("El siguiente evento para " + prota.getNombre() + " será un combate contra...");
		switch(prota.getNombre())
		{
			case "Steve":
			{
				System.out.println("¡EL ENDER DRAGON!");
				break;
			}
			case "Alex":
			{
				System.out.println("¡SANS!        ¿!¿!EL DEL FORTNITE?!?!");
				break;
			}
			case "Chicken Little":
			{
				System.out.println("¡EL CORONEL SANDERS!");
				break;
			}
		}
		
		System.out.println("");
		if(prota.getNombre().equals("Chicken Little") && hasLambo)
		{
			String decision = "";
			
			System.out.println(prota.getNombre() + " se acuerda de su " + Color.PURPLE + "Lambo" + Color.RESET + ", y se da cuenta de que podría huir de todo esto...");
			System.out.println("¿Qué hará " + prota.getNombre() + "?");
			System.out.println("1. Luchar | 2. Huir");
			decision = sc.nextLine();
			while(!decision.equals("1") && !decision.equals("2"))
			{
				System.out.println(decision + " no es una opción ahora mismo");
				System.out.println("1. Luchar | 2. Huir");
				decision = sc.nextLine();
			}
			
			if(decision.equals("2"))
			{
				finalLamboChickenLittle = true;
				gameOver = true;
			}
			else
			{
				System.out.println("No, has venido hasta aquí para pelear\r\n");
			}
		}
		
		if(prota.getNombre().equals("Steve") && !prota.getHaMatado())
		{
			finalHuirSteve = true;
			gameOver = true;
		}
		else if(!gameOver)
		{
			if(combate.combate(sc, random, prota, "Boss", false))
			{
				calculoFinCombate();
			}
			else
			{
				gameOver = true;
			}
			if(prota.getVida() > 0)
			{
				switch(prota.getNombre())
				{
					case "Steve":
					{
						if(prota.getNiebla())
						{
							finalKillDragonPerroSteve = true;
						}
						else
						{
							finalKillDragonSteve = true;
						}
						break;
					}
					case "Alex":
					{
						if(haHuidoAlgunaVez)
						{
							finalKillSansNoGenocideAlex = true;
						}
						else
						{
							finalKillSansGenocideAlex = true;
						}
					}
					case "Chicken Little":
					{
						finalKillCoronel = true;
					}
				}
			}
			gameOver = true;
		}
	}
	
	public void calculoPuntuacion(int randomVidaAtaque) {
	
		 puntuacion = (int) (((prota.getNumEnemigos() * prota.getVida()) + (prota.getSuerte() * prota.getMonedas())) - (combate.getTurnos() * 10));
		 totalPuntuacion = totalPuntuacion + puntuacion;
	}
	
	private void calculoFinCombate()
	{
		if(!prota.getHaHuido() && prota.getVida() > 0)
		{
			prota.setHaMatado(true);
			int randomVidaAtaque = random.nextInt(1, 11);
			if(randomVidaAtaque <= 4)
			{
				calculoPuntuacion(randomVidaAtaque);
				prota.setVidaMax(prota.getVidaMax() + prota.getNumEnemigos());
				prota.setVida(prota.getVida() + prota.getNumEnemigos());
				System.out.println(prota.getNombre() + " consigue " + prota.getNumEnemigos() + " puntos de vida máxima tras el combate!\r\n");
			}
			else if(randomVidaAtaque > 4 && randomVidaAtaque <= 8)
			{
				calculoPuntuacion(randomVidaAtaque);
				prota.setFuerza(prota.getFuerza() + (double) (prota.getNumEnemigos()) / 2);
				System.out.println(prota.getNombre() + " consigue " + (double) (prota.getNumEnemigos()) / 2 + " puntos de fuerza tras el combate!\r\n");
			}
			else
			{
				calculoPuntuacion(randomVidaAtaque);
				prota.setVidaMax(prota.getVidaMax() + prota.getNumEnemigos() / 2);
				prota.setVida(prota.getVida() + prota.getNumEnemigos() / 2);
				prota.setFuerza(prota.getFuerza() + (double) (prota.getNumEnemigos()) / 4);				
				System.out.println(prota.getNombre() + " consigue " + (double) (prota.getNumEnemigos()) / 2 + " puntos de vida máxima y " + (double) (prota.getNumEnemigos()) / 4 + " puntos de fuerza tras el combate! Qué suerte!\r\n");
			}
			
			System.out.println(nombreJugador + " ha conseguido " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " puntos en combate usando a " + prota.getNombre());
			
			int randomMonedas = random.nextInt(1, 11);
			randomMonedas += prota.getSuerte() /2;
			if(randomMonedas <= 2)
			{
				System.out.println(prota.getNombre() + Color.RED_BRIGHT + " no ha encontrado" + Color.RESET + " ninguna " + Color.YELLOW + (prota.getNombre().equals("Chicken Little") ? " semilla " : " esmeralda ") + Color.RESET + "tras el combate\r\n");
			}
			else if(randomMonedas > 2 && randomMonedas <= 8)
			{
				prota.setMonedas(prota.getMonedas() + prota.getNumEnemigos());
				System.out.println(prota.getNombre() + " consigue " + monedas(prota.getNombre(), prota.getNumEnemigos()) + (prota.getNombre().equals("Chicken Little") ? " semillas " : " esmeraldas ") + "tras el combate\r\n");
			}
			else
			{
				System.out.println("¡" + Color.RED_BRIGHT + "S" + Color.YELLOW_BRIGHT + "U" + Color.GREEN_BRIGHT + "E" + Color.BLUE_BRIGHT + "R" + Color.PURPLE_BRIGHT + "T" + Color.CYAN_BRIGHT + "E" + Color.RESET + "!");
				prota.setMonedas(prota.getMonedas() + prota.getNumEnemigos() * 3);
				System.out.println(prota.getNombre() + " consigue " + monedas(prota.getNombre(), prota.getNumEnemigos() * 3) + (prota.getNombre().equals("Chicken Little") ? " semillas " : " esmeraldas ") + "tras el combate\r\n");
			}
		}
		prota.setHaHuido(false);
	}

	private void bucleJuego() throws SQLException
	{
		while(!gameOver)
		{
			lore();
			if(numeroSalas == 14)
			{
				bossBattle();
			}
			else
			{
				seleccionCaminos(random, sc);
			}
			numeroSalas+=1;
		}
		finales();
	}
	
	private void seleccionCaminos(Random random, Scanner scanner) throws SQLException {
		
		String[] listaCaminos = {Color.RED_BRIGHT + "Combate" + Color.RESET, Color.CYAN + "Evento Aleatorio" + Color.RESET, Color.YELLOW + "Mercader" + Color.RESET};
		String[] listaCaminosAburrida = {"Combate", "Evento Aleatorio", "Mercader"};
		
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
		
		List<String> caminosDisponiblesAburridos = new ArrayList<String>();
		
		while(numeroCaminos > 0)
		{
			eventoRandom = random.nextInt(0, listaCaminos.length);//aleatoriamente se elige un camino de la lista
			// Lista con String del nombre del evento
			caminosDisponibles.add(listaCaminos[eventoRandom]);//lista de caminos
			caminosDisponiblesAburridos.add(listaCaminosAburrida[eventoRandom]);//lista sin colores
			numeroCaminos--;
			
			// Lista con numeros desde 1 hasta x, según el número de eventos que haya
			listaOpcionesPosibles.add(Integer.toString(contadorOpciones));//lista que enumera los caminos
			contadorOpciones++;
		}
		
		boolean seleccionCorrecta = false;
		
		String seleccionCamino = "";
	
		while(!seleccionCorrecta)
		{
			System.out.println("A dónde irá " + prota.getNombre() + " ahora...");
			
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
				System.out.println(prota.getNombre() + " no parece muy decidido...");
				System.out.println("(Escoge con números)\r\n");
			}
		}
		
		// Guardamos el nombre de selección elegida en String
		String seleccionStr = (String) caminosDisponiblesAburridos.get(Integer.valueOf(seleccionCamino) - 1);//guarda camino
		
		
		switch(seleccionStr) {//ir al camino (evento) elegido
			case "Combate":
			{
				if(combate.combate(sc, random, prota, "Normal", random.nextBoolean()))
				{
					calculoFinCombate();
				}
				else
				{
					gameOver = true;
				}
				break;
			}
			case "Evento Aleatorio":
			{
				evento.elegirEvento(prota);
				break;
			}
			case "Mercader":
			{
				evento.eventoMercader(prota, scanner, random);
				break;
			}
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
	
	public void esperar(int milisegundos) {
		try {
		    Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}
	
	//¿Principios?
	public void principios() {
		String[] carga = {"Presentando...","Presentando....","Presentando.....","Presentando con mas energia...","Ostia que estaba apagado..","Ya esta :)"};
		String[] grupo = {"Pelayo Santos", "Aitana Herranz", "Diego Baudot"};
		
		System.out.println("\n\nEL grupo 13:\n");
		for (int i = 0; i < grupo.length; i++) {
			System.out.print(grupo[i] + "   "); 
	        esperar(500);
		}
		
		esperar(1000);
		
		System.out.println("\n\n                                                                                              PRESENTAN:\n");
		
		esperar(2000);
		
		for (int i = 0; i < carga.length; i++) {
			System.out.print(carga[i] + "   "); 
			esperar(1000);
		}
		
		System.out.println(Color.YELLOW_BOLD_BRIGHT + "\n\n                                                                                        =================\n\n                                                                                       PRESENTAN FINALMENTE\n\n                                                                                        =================\n" +Color.RESET);
	    
		esperar(1000);
		
		for (int i = 0; i < 10; i++) {
	        System.out.println(Color.BLUE_BOLD_BRIGHT + "█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████" + Color.WHITE_BOLD_BRIGHT);
	        System.out.println(Color.BLUE_BOLD_BRIGHT + "█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████" + Color.WHITE_BOLD_BRIGHT);
	 	   
		
		}
		    
		ASCII.printAscii(0);
		System.out.println("Por: Pelayo Santos, Aitana Herranz y Diego Baudot\n");
		System.out.println("=============================================================================================================================================================================================================");
		
		for (int i = 0;  i < 2; i++) {
			System.out.println();
			
		}
		
	}
	//¿finales?
 	public void finales() {
		if(prota.getVida() <= 0 && !finalMascotaAlex)
		{
			switch(prota.getNombre())
			{
				case "Steve":
				{
					System.out.println("Aquí acaba la historia de " + prota.getNombre() + "...");
					if(!prota.getNiebla())
					{
						System.out.println("Nunca consiguió vengar a Niebla...");
					}
					else
					{
						System.out.println("Nunca consiguió derrotar el dragón...");
					}
					
					break;
				}
				case "Alex":
				{
					System.out.println("Aquí acaba la historia de " + prota.getNombre() + "...");
					System.out.println("Nunca consiguió curar su maldición...");
					break;
				}
				case "Chicken Little":
				{
					System.out.println("Aquí acaba la historia de " + prota.getNombre() + "...");
					System.out.println("El KFC lo convertirá en pollo frito...");
				}
			}
		}
		else
		{
			switch(prota.getNombre())
			{
				case "Steve":
				{
					if(finalKillDragonSteve)
					{
						System.out.println(prota.getNombre() + " asesta el golpe de gracia contra el Dragón...");
						System.out.println("El Dragón case debilitado...");
						System.out.println(prota.getNombre() + " piensa si todo esto mereció la pena...");
					}
					else if(finalKillDragonPerroSteve)
					{
						System.out.println("Niebla y " + prota.getNombre() + " asestan el golpe de gracia juntos contra el Dragón...");
						System.out.println("El Dragón cae debilitado...");
						System.out.println("Niebla y " + prota.getNombre() + " dan un salto en el aire celebrando su victoria");
					}
					else if(finalHuirPerroSteve)
					{
						System.out.println("Tras un rato pensando, " + prota.getNombre() + " decide que es mejor quedarse con Niebla que pelear al Dragón");
						System.out.println("Niebla y " + prota.getNombre() + " caminan hacia una aldea cercana donde reharán su vida");
					}
					else if(finalHuirSteve)
					{
						System.out.println(prota.getNombre() + " está cara a cara contra el Dragón...");
						System.out.println("Pero " + prota.getNombre() + " no quiere pelear, y el Dragón es consciente de esto");
						System.out.println("El Dragón le perdona la vida a " + prota.getNombre() + " y vuelve a su cueva para descansar mil años más");
					}
					break;
				}
				case "Alex":
				{
					if(finalKillSansGenocideAlex)
					{
						System.out.println("Sans no es rival contra la sed de sangre de " + prota.getNombre());
						System.out.println(prota.getNombre() + " asesina a Sans sin ningún problema");
						System.out.println("Tras toda la muerte provocada por " + prota.getNombre() + ", su maldición se va desvaneciendo, quedando liberada");
					}
					else if(finalKillSansNoGenocideAlex)
					{
						System.out.println(prota.getNombre() + " consigue derrotar a Sans");
						System.out.println("...");
						System.out.println(prota.getNombre() + " no se siente diferente, su sed de sangre sigue existiendo...");
						System.out.println("Sabes perfectamente lo que está pensando; \"Debí haber matado a esos enemigos en vez de huir\"...");
						System.out.println(prota.getNombre() + " seguirá trayendo la muerte a este mundo");
					}
					else if(finalLigarAlex)
					{
						System.out.println(prota.getNombre() + " decide quedarse con la aldeana y se da cuenta de que su maldición se está disipando...");
						System.out.println("Vivan las novias!");
					}
					else if(finalMascotaAlex)
					{
						System.out.println("Steve se acerca a " + prota.getNombre() + " y la ayuda a levantarse...");
						System.out.println("Steve sale del trance en el que estaba y se da cuenta de que " + prota.getNombre() + " no es su perro Niebla, y la deja ir");
						System.out.println("Tras este evento, " + prota.getNombre() + " se da cuenta de que Steve la ha dejado una manzana dorada");
						System.out.println(prota.getNombre() + " se come la manzana y... ¡su maldición deja de surtir efecto!");
						System.out.println(prota.getNombre() + " es libre de la maldición!");
					}
					break;
				}
				case "Chicken Little":
				{
					if(finalDrogasChickenLittle)
					{
						System.out.println("No hagan drogas!");
					}
					else if(finalBitcoinChickenLittle)
					{
						System.out.println(prota.getNombre() + " se da cuentas de todas las semillas que tiene...");
						System.out.println("Con esta información, " + prota.getNombre() + " decide crear su propia moneda: \"Chicoin Little\"");
						System.out.println(prota.getNombre() + " se retira de su aventura y se vuelve millonario");
					}
					else if(finalLamboChickenLittle)
					{
						System.out.println(prota.getNombre() + " se sube a su " + Color.PURPLE + "Lambo" + Color.RESET + " y sale pitando!");
					}
					else if(finalKillCoronel)
					{
						System.out.println(prota.getNombre() + " consigue derrotar al Coronel Sanders y es libre!");
						System.out.println("Todos los trabajadores del KFC hacen a " + prota.getNombre() + " el CEO");
					}
				}
			}
		}
		
		System.out.println("FIN DEL JUEGO");
	}
			
}
