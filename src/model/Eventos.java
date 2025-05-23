package model;

import java.util.Random;
import java.util.Scanner;

public class Eventos {
	
	private static String [] evento = {"Bruja", "Maldición", "Trampa", "Juan", "Perro", "Lamborgini", "Drogas", "Puzzle"};
	
	//función selecionar eventos
	//poner metodo público, que escoje un evento aleatorio y llama la función de ese evento
	public static void elegirEvento (Protagonista prota) {
		Random random = new Random();
		
		
		int eventoAleatorio = random.nextInt(0, evento.length);
		String eventoSeleccionado = evento[eventoAleatorio];
		
		//switch del evento
		switch (eventoSeleccionado) {
		case "Bruja":
			eventoBruja(eventoSeleccionado, random, null);
			break;
			
		case "Maldición":
			eventoMaldicion(eventoSeleccionado, random, null, eventoAleatorio);
			break;
			
		case "Trampa":
			eventoTrampa(eventoSeleccionado, random, null, eventoAleatorio, eventoAleatorio, eventoAleatorio);
			break;
		
		case "Juan":
			eventoJuan(eventoSeleccionado, random, null);
			break;
			
		case "Perro":
			eventoPerro(eventoSeleccionado, random, null);
			break;
		
		case "Lamborgini":
			eventoLamborgini(eventoSeleccionado, random, null, eventoAleatorio, eventoAleatorio);
			break;
		
		case "Drogas":
			eventoDrogas(eventoSeleccionado, null, eventoAleatorio, eventoAleatorio, eventoAleatorio, eventoAleatorio, eventoAleatorio, eventoAleatorio);
			break;
			
		case "Puzzle":
			eventoPuzzle(null, random, null, eventoSeleccionado);
			break;
	
		default:
			System.out.println("ERROR EN LA SELECCIÓN EVENTO");
		}

		
	}
		//eventos
		// Métodos individuales para cada evento
		private static void eventoBruja(String nombrePersonaje, Random random, Scanner sc) {
			String decision;
			String efecto = "";
			String cantidad = "";
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			
			String[] pocionesBruja = {Color.GREEN + "Vida" + Color.RESET, Color.PURPLE + "Suerte" + Color.RESET, Color.YELLOW + 
					"Ataque" + Color.RESET, Color.RED_BOLD + "Daño" + Color.RESET, Color.BLUE_BOLD + "Lentitud" + Color.RESET, 
					Color.BLACK_BOLD + "Debilidad" + Color.RESET};
			
			int pocionElegida = 0;
			
			pocionElegida = random.nextInt(pocionesBruja.length);
			
			System.out.println("En tu camino te encuentras con una carretilla. Te asomas a investigar...");
			System.out.println("¡Dentro habia una bruja!");
			System.out.println("La bruja te mira a los ojos y te sonrie de forma malevola.");
			System.out.println("");
			
			if(nombrePersonaje.equals("Steve"))
			{
				System.out.println("\"¿Quieres algo para el camino?\"-pregunto mientras levantaba una pocima de " + pocionesBruja[pocionElegida]);
			}
			else
			{
				System.out.println("\"¿Quieres algo para el camino?\"-pregunto mientras levantaba una extraña pocima");
			}
			
			System.out.println("");
			System.out.println(" 1.Si | 2.No");
			
			decision = sc.nextLine();
			
			while (!decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2") && !decision.equalsIgnoreCase("Si") && !decision.equalsIgnoreCase("No")) {
				
				System.out.println("La bruja se rie de ti al ver tus problemas al responder");
				System.out.println(" 1.Si | 2.No");
				decision = sc.nextLine();
			}
			
			if(decision.equalsIgnoreCase("Si") || decision.equalsIgnoreCase("1")) {
				
				System.out.println("Agarras la pocion y te la bebes sin dudar");
				System.out.println("");
				
				switch(pocionElegida) {
				
					case 0: {
						System.out.println("Te sientes refortalecido, recuperas 5 de vida");
						efecto = "Vida";
						cantidad = "5";
					break;
					}
					case 1: {
						System.out.println("Te sientes muy afortunado, ganas 3 de suerte");
						efecto = "Suerte";
						cantidad = "3";
					break;
					}
					case 2: {
						System.out.println("Te sientes fortalecido, ganas 3 de ataque");
						efecto = "Fuerza";
						cantidad = "3";
					break;
					}
					case 3: {
						System.out.println("Sientes un pinchazo repentino, pierdes 3 de vida máxima");
						efecto = "VidaMax";
						cantidad = "-3";
					break;
					}
					case 4: {
						System.out.println("Te sientes muy pesado, pierdes 3 de velocidad");
						efecto = "Velocidad";
						cantidad = "-3";
					break;
					}
					case 5: {
						System.out.println("Te sientes debilitado, pierdes 2 de ataque");
						efecto = "Fuerza";
						cantidad = "-2";
					break;
					}
				}
				
				finalArray[0][0] = efecto;
				finalArray[0][1] = cantidad;
				
				System.out.println("");
				System.out.println("La bruja se rie al verte tomar la pocion y se marcha lentamente");
				System.out.println("Confundido por la situacion decides continuar tu aventura.");
				
				//// FIN DEL EVENTO ////
			}
			if(decision.equalsIgnoreCase("No") || decision.equalsIgnoreCase("2")) {
				
				System.out.println("Rechazas la oferta y te marchas caminando pensando en si has tomado la decision correcta");
				//// FIN DEL EVENTO ////
				
			}
			return;
		}

		private static void eventoMaldicion(String nombrePersonaje, Random random, Scanner sc, double suertePersonaje) {
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			String decision = "";
			double suerteEvento = 0;
			int totalMonedasConseguidas = 0;
			
			System.out.println("En tu camino te encuentras con un grupo de pillagers muertos en el suelo.");
			if(nombrePersonaje.equals("Steve"))
			{
				System.out.println("Entre ellos eres capaz de vislumbrar un pequeño cofre grabado con un simbolo " + Color.BLACK_BOLD_BRIGHT + 
						"maldito" + Color.RESET);
			}
			else
			{
				System.out.println("Entre ellos eres capaz de vislumbrar un pequeño cofre grabado con un simbolo que no reconoces");
			}
			System.out.println("");
			System.out.println("¿Abres el cofre?");
			if(nombrePersonaje.equals("Steve"))
			{
				System.out.println("Si lo abres quedaras maldito por el " + Color.BLACK_BOLD_BRIGHT +"mal presagio" + Color.RESET);
			}
			System.out.println("");
			System.out.println("  1.Si | 2.No");
			
			decision = sc.nextLine();
			
			while (!decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2") && !decision.equalsIgnoreCase("Si") && !decision.equalsIgnoreCase("No")) {

				System.out.println("Te quedas confundido al no saber si abrir o no el cofre, tal vez necesitas volver a elegir.");
				System.out.println("");
				System.out.println("¿Abres el cofre?");
				if(nombrePersonaje.equals("Steve"))
				{
					System.out.println("Si lo abres quedaras maldito por el " + Color.BLACK_BOLD_BRIGHT +"mal presagio" + Color.RESET);
				}
				System.out.println("");
				System.out.println("  1.Si | 2.No");
				decision = sc.nextLine();
			}
			
			if(decision.equalsIgnoreCase("1") || decision.equalsIgnoreCase("Si"))//ignora las mayusculas
			{
				System.out.println("Abres el cofre...");
				
				suerteEvento = random.nextInt(1, 11);
				suerteEvento += suertePersonaje / 2;
				
				if(suerteEvento < 8) 
				{
					finalArray[0][0] = "Monedas";
					totalMonedasConseguidas = random.nextInt(1, 15);
					finalArray[0][1] = Integer.toString(totalMonedasConseguidas);//de int a String
				}
				else
				{
					finalArray[0][0] = "Monedas";
					totalMonedasConseguidas = random.nextInt(20, 35);
					finalArray[0][1] = Integer.toString(totalMonedasConseguidas);
				}
				
				if(totalMonedasConseguidas > 25)
				{
					System.out.println("¡Vaya suerte!");
				}
				
				System.out.println("Dentro del cofre había un total de " + monedas(nombrePersonaje, totalMonedasConseguidas) + Color.YELLOW +
						(nombrePersonaje.equals("Chicken Little") ? " semillas" : " esmeraldas") + Color.RESET);
				
				if(totalMonedasConseguidas <= 5)
				{
					System.out.println("Un desperdicio de tiempo.");
				}
				
				
				if(nombrePersonaje.equals("Steve"))
				{
					System.out.println("Tras recoger las esmeraldas te das cuenta de que ahora tienes el símbolo del " + Color.BLACK_BOLD_BRIGHT +  "mal presagio grabado " + Color.RESET + "en la mano");
				}
				else
				{
					System.out.println("Tras recoger las esmeraldas te das cuenta de que ahora tienes ese extraño símbolo grabado en la mano");
				}
				
				System.out.println("¡Has sido maldecido!");
				
				finalArray[1][0] = "Bad Omen";
				finalArray[1][1] = "true";
				
				System.out.println("Asustado te marchas dejando la masacre atras");
				//// FIN DEL PUZZLE ////
			}
			else
			{
				System.out.println("Decides no tocar el cofre y evitar el riesgo.");
				System.out.println("Te marchas dejando la masacre atras");
				
				//// FIN DEL PUZZLE ////
			}
			
			return;
		}

		private static void eventoTrampa(String nombrePersonaje, Random random, Scanner sc, double velocidadPersonaje, double defensaPersonaje, int numeroMonedas) {
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			
			boolean trampa = random.nextBoolean();
			
			int daño = 0;
			int monedasPerdidas = 0;
			
			if(nombrePersonaje.equals("Steve"))
			{
				velocidadPersonaje += 4; // solo se cambia dentro el método!!
			}
			
			if(trampa)
			{
				System.out.println("En tu camino te encuentras un estrecho pasaje");
				System.out.println("Al intentar pasar por el activas una trampa y varias flechas comienzan a dispararse desde las paredes en todas direcciones");
				System.out.println("");
				
				if(velocidadPersonaje >= 8) {
					System.out.println("Rapidamente reaccionas al sonido del mecanismo y te apartas sin recibir daño");
				}
				else if(velocidadPersonaje >= 5 && velocidadPersonaje < 8) {
					daño = random.nextInt(3,6);
					System.out.println("Consigues esquivar la mayoria de las flechas recibiendo " + Color.RED_BRIGHT + daño + 
							Color.RESET + " de daño");
					}
				else if(velocidadPersonaje < 5 && velocidadPersonaje >= 2) {
					daño = random.nextInt(5,9);
					System.out.println("Consigues esquivar las flechas parcialmente recibiendo recibiendo " + Color.RED_BRIGHT + daño +
							Color.RESET + " de daño");
					}
				else {
					daño = random.nextInt(8,11);
					System.out.println("Recibes las flechas de lleno " + Color.RED_BRIGHT + daño + Color.RESET + " de daño");
				}
				
				if(velocidadPersonaje >= 8)
				{
					System.out.println("Cuando las flechas dejaron de salir te levantaste  y continuaste con tu camino agredecido de seguir vivo");
				}
				else
				{
					System.out.println("Cuando las flechas dejaron de salir te levantaste rebisaste tus heridas y continuaste con tu camino agredecido de seguir vivo");
				}
				
				if(daño > 0)
				{
					daño -= (daño * (defensaPersonaje / 2)) / 10; //defensa
					finalArray[0][0] = "Vida";
					finalArray[0][1] = Integer.toString(-daño);
				}
			}
			else
			{
				System.out.println("En tu camino te encuentras un estrecho pasaje");
				System.out.println("Al intentar pasar eres atacado por un grupo de saqueadores quienes van directamente a por tus esmeraldas");
				System.out.println("");
				
				if(velocidadPersonaje >= 8) {
					System.out.println("Rapidamente reaccionas al sonido de los atacantes y sales corriendo");
				}
				else if(velocidadPersonaje >= 5 && velocidadPersonaje < 8) {
					monedasPerdidas = random.nextInt(3,6);
					if(numeroMonedas < monedasPerdidas) monedasPerdidas = numeroMonedas;
					System.out.println("Bloqueas gran parte de sus ataques pero consiguen robarte " + Color.RED_BRIGHT + monedas(nombrePersonaje, monedasPerdidas) + Color.RESET + (nombrePersonaje.equals("Chicken Little") ? " semillas" : " esmeraldas"));
					}
				else if(velocidadPersonaje < 5 && velocidadPersonaje >= 2) {
					monedasPerdidas = random.nextInt(5,9);
					if(numeroMonedas < monedasPerdidas) monedasPerdidas = numeroMonedas;
					System.out.println("Esquivas parte de sus ataques pero consiguen robarte " + Color.RED_BRIGHT + monedas(nombrePersonaje, monedasPerdidas) + Color.RESET + (nombrePersonaje.equals("Chicken Little") ? " semillas" : " esmeraldas"));
					}
				else {
					monedasPerdidas = random.nextInt(8,11);
					if(numeroMonedas < monedasPerdidas) monedasPerdidas = numeroMonedas;
					System.out.println("Los asaltantes te pillan desprevenido llevandose una gran parte de tu tesoro, pierdes " + Color.RED_BRIGHT + monedas(nombrePersonaje, monedasPerdidas) + Color.RESET + (nombrePersonaje.equals("Chicken Little") ? " semillas" : " esmeraldas"));
				}
				
				if(velocidadPersonaje >= 8)
				{
					System.out.println("Sigues corriendo dejando atras a los ladrones y continuas tu aventura");
				}
				else
				{
					System.out.println("Los ladrones se marchan satisfechos con su botin, decides marcharte y continuar tu aventura agradecido de al menos seguir vivo");
				}
				
				if(monedasPerdidas > 0)
				{
					if(numeroMonedas < monedasPerdidas) monedasPerdidas = numeroMonedas;
					finalArray[0][0] = "Monedas";
					finalArray[0][1] = Integer.toString(-monedasPerdidas);
				}
			}
			
			return;
		}

		private static void eventoJuan(String nombrePersonaje, Random random, Scanner sc) {
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			
			String decision;
			
			          String[] encantamiento = {"Proteccion", "Afilado", "Espinas", "Fortuna", "Eficiencia", "Recarga rapida"};
			String[] encantamientoEncriptado = {"!¡∷𝙹ℸ ̣ ᒷᓵᓵ╎𝙹リ", "ᒷᓭ!¡╎リᔑᓭ", "ᔑ⎓╎ꖎᔑ↸𝙹", "ᒷ⎓╎ᓵ╎ᒷリᓵ╎ᔑ", "∷ᒷᓵᔑ∷⊣ᔑ  ∷ᔑ!¡╎↸ᔑ", "⎓𝙹∷ℸ ̣ ⚍リᔑ"};
			String[] nivel = {"I","II","III","IV","V",""};
			int[] costeVidaArray = new int[4];
			
			String[][] encantamientosNivelesSeleccionados = new String[4][2];
			
			System.out.println("En tu camino te encuentras un campamento muy extraño.");
			System.out.println("Esta conformado por una gran tienda de campaña azul y un puesto de venta con lo que parece ser una mesa de encantamientos.");
			System.out.println("¿Te acercas a investigar?");
			System.out.println("");
			System.out.println("  1.Si | 2.No");
			
			decision = sc.nextLine();
			
			while (!decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2") && !decision.equalsIgnoreCase("Si") && !decision.equalsIgnoreCase("No")) {

				System.out.println("La dificil decisión de si acercarte o no, te deja confuso por lo que piensas " + "\"" + decision + "\"" + 
									" pero rápidamente te das cuenta de lo ridiculo que es eso y decides volver a elegir");
				System.out.println("¿Te acercas a investigar?");
				System.out.println("");
				System.out.println("  1.Si | 2.No");
				decision = sc.nextLine();
			}
			
			if(decision.equals("1") || decision.equalsIgnoreCase("Si"))
			{
				System.out.println("Te acercas al campamento y...");
				System.out.println(Color.CYAN_BOLD_BRIGHT + "    ¡Fuassshhhh!" + Color.RESET);
				System.out.println("Un enorme caballo aparece tras el mostrador");
				System.out.println("");
				System.out.println(Color.WHITE_BOLD_BRIGHT + "\"Bienvenido a mi tienda viajero\"" + Color.RESET +  "-dijo entusiamsado el caballo");
				System.out.println("");
				System.out.println( "\"¡¿Un caballo que habla?!\" " + Color.RESET +  "-dices sorprendido");
				System.out.println("");
				System.out.println(Color.WHITE_BOLD_BRIGHT + "\"¡El nombre es JUAN y realmente soy un mago transformado en caballo\" " + Color.RESET + "-explica alegremente");
				System.out.println("");
				System.out.println("Eso lo hace claramente menos raro-piensas");
				System.out.println("");
				System.out.println(Color.WHITE_BOLD_BRIGHT + "\"Ya que estas aqui, acercate a mirar mis ofertas de hoy\"" + Color.RESET + "-dijo emocionado");
				System.out.println("");
				System.out.println("Te acercas al mostrador y miras el libro que " + Color.WHITE_BOLD_BRIGHT + "JUAN" + Color.RESET + " está sosteniendo");
				System.out.println("");
				System.out.println(Color.WHITE_BOLD_BRIGHT + "\"Estos son los encantamientos disponibles, recuerda que cada uno de estos drena tu salud\"" + Color.RESET 	
									+ "-explico señalando al libro");
				System.out.println("");
				
				for (int i = 0; i < 4; i++) {
					
					int encantamientoRandom = random.nextInt(encantamiento.length);
					int nivelRandom = 0;
					if(encantamientoRandom <= 1) {nivelRandom = random.nextInt(nivel.length-2);} //Nivel del encantamiento
					else if(encantamientoRandom > 1 && encantamientoRandom < 4) {nivelRandom = random.nextInt(nivel.length-3);}
					else if(encantamientoRandom == 5) { nivelRandom = 5;}
					else {nivelRandom = random.nextInt(nivel.length);}
					
					int costeVida = 0;
					costeVida = (nivelRandom+1) * 3; // coste de vida según el nivel
					
					if(nivelRandom == 5)
					{
						costeVida = 9; // recarga rápida es igual al coste de un nivel III
					}
					
					if(nombrePersonaje.equals("Steve")) {// si es steve, te salen los encantamientos con nombre
						System.out.println( "     " + (i + 1)  + "." + Color.CYAN_UNDERLINED + Color.CYAN_BOLD_BRIGHT + encantamiento[encantamientoRandom] + " " + nivel[nivelRandom]  + Color.RESET + "-> -" + costeVida +  " de vida maxima" + "\r\n");
					}else System.out.println( "     " + (i + 1)  + "." + Color.CYAN_UNDERLINED + Color.CYAN_BOLD_BRIGHT + encantamientoEncriptado[encantamientoRandom] + " " + nivel[nivelRandom] + Color.RESET + "-> -" + costeVida +  " de vida maxima"  + "\r\n");
					
					String[] guardarEncantamiento = new String[2];
				
					guardarEncantamiento[0] = encantamiento[encantamientoRandom];// guarda en una array los encantamientos, niveles y coste de vida
					guardarEncantamiento[1] = nivel[nivelRandom];
					
					costeVidaArray[i] = costeVida;
					encantamientosNivelesSeleccionados[i] = guardarEncantamiento;// guarda en una matriz los arrays de distintos encantamientos, y niveles
				}
				
				decision = sc.nextLine();
				
				while (!decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2") && !decision.equalsIgnoreCase("3") && !decision.equalsIgnoreCase("4")) {

					System.out.println(Color.WHITE_BOLD_BRIGHT + "\"No entiendo a que te refieres con " + decision + ", dime 1,2,3,4 para elegir tu encantamiento\"" + Color.RESET + "-dijo extrañado");
					decision = sc.nextLine();
				}
				
//				for (int i = 0; i < encantamientosNivelesSeleccionados.length; i++) {
//				for (int j = 0; j < encantamientosNivelesSeleccionados[i].length; j++) {
//					System.out.println(encantamientosNivelesSeleccionados[i][j]);
//				}
//			}
				switch(decision) {// se guardan los encantamientos
				
				case "1":{
					finalArray[0][0] = encantamientosNivelesSeleccionados[0][0];
					finalArray[0][1] = encantamientosNivelesSeleccionados[0][1];
					
					finalArray[1][0] = "VidaMax";
					finalArray[1][1] = Integer.toString(-costeVidaArray[0]);// cambia int a string
					
					break;
				}
				case "2":{
					finalArray[0][0] = encantamientosNivelesSeleccionados[1][0];
					finalArray[0][1] = encantamientosNivelesSeleccionados[1][1];
					
					finalArray[1][0] = "VidaMax";
					finalArray[1][1] = Integer.toString(-costeVidaArray[1]);
					break;
				}
				case "3":{
					finalArray[0][0] = encantamientosNivelesSeleccionados[2][0];
					finalArray[0][1] = encantamientosNivelesSeleccionados[2][1];
					
					finalArray[1][0] = "VidaMax";
					finalArray[1][1] = Integer.toString(-costeVidaArray[2]);
					break;
				}
				case "4":{
					finalArray[0][0] = encantamientosNivelesSeleccionados[3][0];
					finalArray[0][1] = encantamientosNivelesSeleccionados[3][1];
					
					finalArray[1][0] = "VidaMax";
					finalArray[1][1] = Integer.toString(-costeVidaArray[3]);
					break;
				}
				}
				
				System.out.println(Color.WHITE_BOLD_BRIGHT +"\"Perfecto ahora mismo realizo el encatamiento de " + Color.CYAN_UNDERLINED + Color.CYAN_BOLD_BRIGHT + finalArray[0][0] + " " + finalArray[0][1] + Color.RESET + " espero que difrutes de tu eleccion\"-dijo alegremente" + Color.RESET);
				System.out.println("");
				System.out.println(Color.WHITE_BOLD_BRIGHT +"\"Espero que disfrutes de tu aventura buen viaje\"-dijo mintras te despedia levantando una pezuña" + Color.RESET);
				
			}
			else {
				System.out.println("Decides no darle mas importancia y pasas de largo.");
				System.out.println("");
				System.out.println("En poco tiempo ya has dejado atras el campamento aunque jurarias poder escucha sonidos de caballo en la distancia.");
				
				//// LA LISTA ESTA VACIA ASI QUE DEVUELVE UNA VACIA ////
			}
			
			return;
		}

		private static void eventoPerro(String nombrePersonaje, Random random, Scanner sc) {
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};	
			String decision;
			String[] nombresGonzalo = {"Puertas Torres","Pablo Tomate","Pérez Torres", "Paredes Téllez", "Pascual Toledo", "Prieto Tapia", "Ponce Trujillo",
					  "Portillo Terán", "Poveda Tovar", "Peralta Téllez", "Paniagua Torres", "Pizarro Tomás",
					  "Palacios Torres", "Pinto Tarazona", "Paz Tuero", "Pujol Tanco", "Pani Tello",
					  "Prado Tobar", "Peña Trujillo", "Pérez Tapia", "Pinto Teruel", "Pascual Téllez",
					  "Pavía Tapia", "Pérez Tovar", "Porras Tellez", "Plaza Torralba", "Pantoja Torrado",
					  "Parra Trejo", "Pueyo Trujillo", "Pérez Torralba", "Pino Tejada", "Poveda Turón",
					  "Pichardo Tejeda", "Polanco Tarazona", "Paredes Tomás", "Pérez Taboada", "Palacios Téllez",
					  "Paz Tovar", "Pineda Téllez", "Puig Torres", "Peralta Torres", "Pinto Turón",
					  "Ponce Taboada", "Prado Torres", "Puga Téllez", "Pujol Teruel", "Paz Toro",
					  "Padilla Tapia", "Pérez Tejada", "Pinto Tovar", "Pérez Trujillo", "Perdomo Torres"};
			
			int numerin = random.nextInt(nombresGonzalo.length);
			int randomGenio = 0;
			
			System.out.println("En tu camino te encuentras una urna.");
			System.out.println("¿Quieres investigar la urna?");
			System.out.println("");
			System.out.println("  1.Si | 2.No");
			
			decision = sc.nextLine();
			
			while (!decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2") && !decision.equalsIgnoreCase("Si") && !decision.equalsIgnoreCase("No")) {

				System.out.println("La dificil decision de si acercarte o no te deja confuso por lo que piensas " + "\"" + decision + "\"" + 
									" pero rapidamente te das cuenta de lo ridiculo que es eso y decides volver a elegir");
				System.out.println("¿Te acercas a investigar?");
				System.out.println("");
				System.out.println("  1.Si | 2.No");
				decision = sc.nextLine();
			}
			
			if(decision.equalsIgnoreCase("1") || decision.equalsIgnoreCase("Si"))
			{
				System.out.println("De repente, emerge un espiritu azul brillante de la urna");
				System.out.println("\"Soy el magnifico e inigualabe " + Color.GREEN_BOLD_BRIGHT +  "Gonzalo " + nombresGonzalo[numerin] + Color.RESET + ". Por despertarme te concedo 1 deseo\"-explicó agradecido");
				System.out.println("\"Puedo concederte cualquier cosa aunque cuanto mas poderoso sea mas posibilidades de que me niegue\"-dijo");
				System.out.println("");
				System.out.println("\"¿Cual va a ser el deseo?\"");
				System.out.println("");
				System.out.println("Tras la explicacion te das cuenta de una cosa, con este deseo puedes ¡revivir a Niebla! ");
				System.out.println("Aunque tal vez podrias desear mas poder para completar tu venganza");
				System.out.println("");
				System.out.println("  1.Revivir a Niebla | 2.Mas poder | 3.Dinero ilimitado | 4.Ser invencible");
				System.out.println("");
				
				decision = sc.nextLine();
				
				while (!decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2") && !decision.equalsIgnoreCase("3") && !decision.equalsIgnoreCase("4") && !decision.equalsIgnoreCase("Revivir a Niebla") && !decision.equalsIgnoreCase("Más poder") && !decision.equalsIgnoreCase("3") && !decision.equalsIgnoreCase("4")) {
		
					System.out.println("Decidido exclamas " + "\"" + decision + "\"");
					System.out.println("\"No he entendido tu deseo, ¿Puedes repetirlo?\"");
					System.out.println("");
					System.out.println(" 1.Revivir a Niebla | 2.Mas poder | 3.Dinero ilimitado | 4.Ser invencible");
					decision = sc.nextLine();
				}
				
				switch(decision) {
				
				case "1": {
					numerin = random.nextInt(nombresGonzalo.length);
						System.out.println("Le pides entre lágrimas a " + Color.GREEN_BOLD_BRIGHT + "Gonzalo " + nombresGonzalo[numerin] + Color.RESET + " que reviva a tu querido perro Niebla.");
						System.out.println("Éste te mira complacido y en un movimiento de manos hace lo imposible");
						System.out.println("Niebla se encuentra sentado ante ti, nada mas verlo corres a abrazarlo mientras que el responde lamiendo tu cara");
						System.out.println(Color.YELLOW_BOLD_BRIGHT + "¡NIEBLA SE HA UNIDO AL EQUIPO!" + Color.RESET);
					
						finalArray[0][0] = "Niebla";
						finalArray[0][1] = "true";
						
						System.out.println("Ahora con Niebla en tu equipo, te preguntas si deberías empezar una vida desde cero, en vez de enfrentarte al Dragon...");
						System.out.println("¿Qué harás?");
						System.out.println(" 1.Seguir con tu aventura | 2.Dejar al Dragon en paz");
						
						String decisionHuir = sc.nextLine();
						
						while(!decisionHuir.equalsIgnoreCase("1") && !decisionHuir.equalsIgnoreCase("2") && !decisionHuir.equalsIgnoreCase("seguir") && !decisionHuir.equalsIgnoreCase("dejar"))
						{
							System.out.println(decisionHuir + " no es una opción ahora mismo");
							System.out.println("¿Qué harás?");
							System.out.println(" 1.Seguir con tu aventura | 2.Dejar al Dragon en paz");
						}
						
						if(decisionHuir.equalsIgnoreCase("2") || decisionHuir.equalsIgnoreCase("dejar"))
						{
							finalArray[1][0] = "Final Paz";
							finalArray[1][1] = "true";
						}
					break;
				}
				
				case "2": { 
					
					randomGenio = random.nextInt(0,11); // niebla siempre es verdadero, y las otras 3 opciones son random
					
					numerin = random.nextInt(nombresGonzalo.length);
					
					if(randomGenio >= 6) {
						System.out.println("\"¡Felicidades! Has obtenido 3 puntos de fuerza. ¡Sigue así, tu progreso es impresionante!\"-dijo entusiasmado");
						System.out.println("Gracias a " + Color.GREEN_BOLD_BRIGHT + "Gonzalo " + nombresGonzalo[numerin] + Color.RESET +  "ahora te sientes mas poderoso aunque tambien la gran pena de no poder ver mas a Niebla");
						
						finalArray[0][0] = "Fuerza";
						finalArray[0][1] = "3";
						
					} else System.out.println("\"Lamentablemente, no puedo conceder ese deseo en este momento. Sin embargo, siempre estaré aquí para ayudarte en lo que necesites. ¡Sigue adelante!\"-dijo alegre");
					break;
				}
				case "3": { 
					
					randomGenio = random.nextInt(0,11);
					
					numerin = random.nextInt(nombresGonzalo.length);
					
					if(randomGenio >= 7) {
						finalArray[0][0] = "Monedas";
						finalArray[0][1] = "30";
						System.out.println("\"¡Enhorabuena! Has obtenido 30" + Color.YELLOW + (nombrePersonaje.equals("Chicken Little") ? " semillas" : " esmeraldas") + Color.RESET + ". ¡Tu tesoro crece y tu aventura continúa!\"-dijo entusiasmado");
						System.out.println("Gracias a " + Color.GREEN_BOLD_BRIGHT + "Gonzalo " + nombresGonzalo[numerin] + Color.RESET +  "ahora te sientes mas rico aunque tambien la gran pena de no poder ver mas a Niebla");
						
					} else System.out.println("\"Lamentablemente, no puedo conceder ese deseo en este momento. Sin embargo, siempre estaré aquí para ayudarte en lo que necesites. ¡Sigue adelante!\"-dijo alegre");
					break;
				}
				case "4": { 
					
					randomGenio = random.nextInt(0,11);
					
					numerin = random.nextInt(nombresGonzalo.length);
					
					if(randomGenio >= 8) {
						finalArray[0][0] = "VidaMax";
						finalArray[0][1] = "10";
						System.out.println("\"¡Excelente! Has obtenido 10 puntos de vida máxima. ¡Tu fuerza y resistencia aumentan! ¡Sigue avanzando con más energía!\"-dijo entusiasmado");
						System.out.println("Gracias a " + Color.GREEN_BOLD_BRIGHT + "Gonzalo " + nombresGonzalo[numerin] + Color.RESET +  "ahora te sientes mas resisitente, aunque tambien la gran pena de no poder ver mas a Niebla");
						
					} else System.out.println("\"Lamentablemente, no puedo conceder ese deseo en este momento. Sin embargo, siempre estaré aquí para ayudarte en lo que necesites. ¡Sigue adelante!\"-dijo alegre");
					break;
				}
			}
				
				numerin = random.nextInt(nombresGonzalo.length);
				
				System.out.println("");
				System.out.println(Color.GREEN_BOLD_BRIGHT + "Gonzalo " + nombresGonzalo[numerin] + Color.RESET + " alza la mano y la mueve en seña de despedida");
				System.out.println("\"Mi trabajo ha concluido, ¡Ha sido un placer interactuar contigo! espero vernos pronto, ¡Hasta la proxima!\"");
				
				numerin = random.nextInt(nombresGonzalo.length);
				
				System.out.println(Color.GREEN_BOLD_BRIGHT + "Gonzalo " + nombresGonzalo[numerin] + Color.RESET + " se esfuma ante ti");
				
			}
			
			else
			{
				System.out.println("Te marchas esquivando la urna cuidadosamente.");
				System.out.println("Al rato ya dejas la urna atras y conforme te alejas te invade el arrepentimiento por no descubrir que hay en la urna.");
			}
			return;
		}

		private static void eventoLamborgini(String nombrePersonaje, Random random, Scanner sc, int numeroMonedas, double vidaPersonaje) {
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			
			String decision;
			
			int monedasAPagar = 0;
			
			int indiceArray = 0;
			int objetosAComprar = 3;
			
			boolean salir = false;
			
			System.out.println("En tu camino te encuentras un Mercader errante.");
			System.out.println("");
			System.out.println("\"Ven pequeño amigo, mira los bienes que ofrezco amigo\"");
			System.out.println("");
			System.out.println("Te acercas tentado por la amabilidad del vendedor");
			System.out.println("Ves un monton de vienes variados y extraños");
			
			while(salir == false && vidaPersonaje > 0)
			{
				System.out.println("Tienes " + Color.YELLOW + monedas(nombrePersonaje, numeroMonedas) + Color.RESET + " semillas");
				System.out.println("¿Compras algo?");
				System.out.println("");
				System.out.println("   1.Comida sospechosa (" + monedas(nombrePersonaje, 5) + ") \r\n" + "   2.Armadura de dudosa calidad (" + monedas(nombrePersonaje, 5) + ") \r\n" + 
								   "   3.Un motherfucking lamborgini (" + monedas(nombrePersonaje, 50) + ") \r\n" + "   4.Protector para picos 3000 (" + monedas(nombrePersonaje, 5) + ") \r\n" + "   5.Marcharte \r\n");
				
				decision = sc.nextLine();
				
				while (!decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2") && !decision.equalsIgnoreCase("3") && !decision.equalsIgnoreCase("4") && !decision.equalsIgnoreCase("5") &&!decision.equalsIgnoreCase("Comida sospechosa") && !decision.equalsIgnoreCase("Armadura de dudosa calidad") && !decision.equalsIgnoreCase("Un motherfucking lamborgini") && !decision.equalsIgnoreCase("Protector para picos 3000") && !decision.equalsIgnoreCase("Marcharte")) {
					
					System.out.println("La dificil decision de si comprar o no te deja confuso por lo que piensas " + "\"" + decision + "\"" + 
										" pero rapidamente te das cuenta de lo ridiculo que es eso y decides volver a elegir");
					System.out.println("¿Compras algo?");
					System.out.println("");
					System.out.println("   1.Comida sospechosa (" + monedas(nombrePersonaje, 5) + ") \r\n" + "   2.Armadura de dudosa calidad (" + monedas(nombrePersonaje, 5) + ") \r\n" + 
							   "   3.Un motherfucking lamborgini (" + monedas(nombrePersonaje, 50) + ") \r\n" + "   4.Protector para picos 3000 (" + monedas(nombrePersonaje, 5) + ") \r\n" + "   5.Marcharte \r\n");
					decision = sc.nextLine();
				}
				
				switch(decision) {
				
				case "1","Comida sospechosa": {
					if(numeroMonedas >= 5 && objetosAComprar > 0) {
						numeroMonedas = numeroMonedas - 5;
						monedasAPagar += 5;
						objetosAComprar--;
					finalArray[indiceArray][0] = "Vida";//como no sabes cuanto vas a comprar, cambiamos la posición en la que guardamos cosas en la matriz
					finalArray[indiceArray][1] = "-5";
					indiceArray++;
					
					System.out.println("Te comes la Comida sospechosa");
					System.out.println("Parece que te cuesta digerirlo \r\n" + "  -5 de vida \r\n" 
									   +  "   +5 de vida \r\n" + "Aunque te da una indigestion y pierdes -5 de vida");
					
					}else
					{
						if(objetosAComprar <= 0)
						{
							System.out.println("No me quedan pertenencias!");
						}
						else
						{
							System.out.println("No tienes suficientes semillas");
						}
					}
					break;
				}
				case "2","Armadura de dudosa calidad": {
					if(numeroMonedas >= 5 && objetosAComprar > 0) {
						numeroMonedas = numeroMonedas - 5;
						monedasAPagar += 5;
						objetosAComprar--;
						finalArray[indiceArray][0] = "Defensa";
						finalArray[indiceArray][1] = "-2";
						indiceArray++;
					System.out.println("Te pones la Armadura de dudosa calidad");
					System.out.println("Te pones la armadura encima y de alguna forma esta parece hacerte mas debil");
					System.out.println("   -2 de armadura");
					
					}else
					{
						if(objetosAComprar <= 0)
						{
							System.out.println("No me quedan pertenencias!");
						}
						else
						{
							System.out.println("No tienes suficientes semillas");
						}
					}
					break;
				}
				case "3","Un motherfucking lamborgini": {
					if(numeroMonedas >= 50 && objetosAComprar > 0) {
						numeroMonedas = numeroMonedas - 50;
						monedasAPagar += 50;
						objetosAComprar--;
						finalArray[indiceArray][0] = "Velocidad";
						finalArray[indiceArray][1] = "4";
						indiceArray++;
						finalArray[indiceArray][0] = "Lambo";
						finalArray[indiceArray][1] = "true";
						indiceArray++;
					System.out.println("El aldeano saca un motherfucking lamborgini de su bolsillo dejandote asombrado.");
					System.out.println("Sin dudarlo te subes al lamborgini, sintiendote mas rapido que nadie");
					System.out.println("   +4 de velocidad");
					
					}else
					{
						if(objetosAComprar <= 0)
						{
							System.out.println("No me quedan pertenencias!");
						}
						else
						{
							System.out.println("No tienes suficientes semillas");
						}
					}
					break;
				}
				case "4","Protector para picos 3000": {
					if(numeroMonedas >= 5 && objetosAComprar > 0) {
						numeroMonedas = numeroMonedas - 5;
						monedasAPagar += 5;
						objetosAComprar--;
						finalArray[indiceArray][0] = "Fuerza";
						finalArray[indiceArray][1] = "-1";
						indiceArray++;
					System.out.println("Te pones el Protector para picos 3000, se siente muy extraño.");
					System.out.println("   +99 de fuerza \r\n" + "   -100 de fuerza");
					System.out.println("");
					
					}else 
					{
						if(objetosAComprar <= 0)
						{
							System.out.println("No me quedan pertenencias!");
						}
						else
						{
							System.out.println("No tienes suficientes semillas");
						}
					}
					break;
				}
				case "5","Marcharte":{
					System.out.println("Te marchas sin mirar atrás");
					salir = true;
					break;
				}
			}
			}
			
			finalArray[4][0] = "Monedas";
			finalArray[4][1] = Integer.toString(-monedasAPagar);
			
			return;
		}

		private static void eventoDrogas(String nombrePersonaje,Scanner sc, double vidaMaxPersonaje, double vidaPersonaje, double defensaPersonaje,
			double velocidadPersonaje, int numeroMonedas,double fuerzaPersonaje) {
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			
			String decision = "";
			
			System.out.println(nombrePersonaje + " se adentra a un bosque");
			System.out.println("Aquí, " + nombrePersonaje + " encuentra unas " + Color.PURPLE + "setas" + Color.RESET + "...");
			System.out.println("A " + nombrePersonaje + "Le resultan realmente apeticbles..." + "tal vez podrian comerse...");
			System.out.println("¿Comer las setas?\r\n");
			System.out.println("1.Si | 2.No");
			decision = sc.nextLine();
			
			while(!decision.equals("1") && !decision.equals("2") && !decision.equalsIgnoreCase("Si") && !decision.equalsIgnoreCase("No"))
			{
				System.out.println("1.Si | 2.No");
				decision = sc.nextLine();
			}
			
			if(decision.equals("2") || decision.equalsIgnoreCase("No"))
			{
				System.out.println("No, ni de broma.");
				System.out.println("Sigues tu camino");
			}
			else
			{
				System.out.println("A " + nombrePersonaje + " le mata la curiosidad...");
				System.out.println("...");
				System.out.println(".......");
				System.out.println("Consumes las " + Color.PURPLE + "setas" + Color.RESET + "......");
				System.out.println("........");
				System.out.println(Color.nombrePersonaje + " se siente.... " + "¡" + Color.PURPLE + "B" + Color.YELLOW + "I" + Color.GREEN_BRIGHT + "E" + Color.RED_BRIGHT + "N" + Color.RESET + "!");
				System.out.println("......");
				System.out.println(Color.PURPLE + nombrePersonaje.toUpperCase()  + Color.GREEN_BRIGHT +  "SE SIENT" + Color.RED_BRIGHT +  "E MUCH" + Color.YELLOW + "ISIMO MAS" + Color.PURPLE +  "PO"  + Color.BLUE + "DEROSO" + Color.RESET);
				System.out.println("¡Las estadisticas de " + nombrePersonaje.toUpperCase() + " se han multiplicado!");
				System.out.println(Color.PURPLE + "Vida: "  + Color.RED_BRIGHT + (vidaPersonaje/0.69) + "/" + vidaMaxPersonaje);
				System.out.println(Color.YELLOW + "Defensa: "  + Color.GREEN_BRIGHT +  defensaPersonaje/0.69);
				System.out.println(Color.CYAN + "Fuerza: " + Color.PURPLE + fuerzaPersonaje/0.69);
				System.out.println(Color.RED_BRIGHT + "Velocidad: " + Color.BLUE + velocidadPersonaje/0.69);
				System.out.println(nombrePersonaje + " se encuentra a Barbie Playera y a Buzz Lightyear, los cuales estaban tomandose un martini juntos en la playa");
				System.out.println("Pronto después llega Freddy Fazbear y se une a la fiesta");
				System.out.println("Sin embargo, " + nombrePersonaje + " no se encuentra muy bien...");
				System.out.println(nombrePersonaje + " se desmaya en frente de Buzz Lightyear Barbie Playera y Freddy Fazbear!");
				finalArray[0][0] = "Drogas";
				finalArray[0][1] = "true";
			}
			
			
			return;
		}

		private static void eventoPuzzle(String[][] finalEventoArray, Random random, Scanner sc, String nombrePersonaje) {
			String[] puzzlesDisponibles = {"PPT", "Luces", "Adivina", "Trivia", "Opinion"};
	        
	        int puzzleAleatorio = random.nextInt(1, 6);
		    
	        //Eventos
	        switch(puzzleAleatorio) {// coge un puzzle aleatorio
	                
	                //Piedra, Papel y Tigera
	                case 1: {
	                    finalEventoArray = puzzlePiedraPapelTijera(random, sc);
	                    break;
	                }
	                //Lamparas
	                case 2: {
	                        
	                    finalEventoArray = puzzleLamparas(random, sc, nombrePersonaje);
	                    break;
	                }
	                //Adivinanza
	                case 3: {
	                    finalEventoArray = puzzleAdivinanza(random, sc);
	                    break;
	                }
	                //Adivinanza
	                case 4: {
	                    finalEventoArray = puzzleTrivia(random, sc, nombrePersonaje);
	                    break;
	                }
	                //Opinión
	                case 5: {
	                    finalEventoArray = puzzleOpinion(random, sc, nombrePersonaje);
	                    break;
	                }
	                    
	            }
			return;
		}

	
	

}
