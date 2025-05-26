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
			eventoBruja(prota, random, null);
			break;
			
		case "Maldición":
			eventoMaldicion(prota, random, null, eventoAleatorio);
			break;
			
		case "Trampa":
			eventoTrampa(prota, random, null, eventoAleatorio, eventoAleatorio, eventoAleatorio);
			break;
		
		case "Juan":
			eventoJuan(prota, random, null);
			break;
			
		case "Perro":
			eventoPerro(prota, random, null);
			break;
		
		case "Lamborgini":
			eventoLamborgini(prota, random, null, eventoAleatorio, eventoAleatorio);
			break;
		
		case "Drogas":
			eventoDrogas(prota, null, eventoAleatorio, eventoAleatorio, eventoAleatorio, eventoAleatorio, eventoAleatorio, eventoAleatorio);
			break;
			
		case "Puzzle":
			eventoPuzzle(null, random, null, prota);
			break;
	
		default:
			System.out.println("ERROR EN LA SELECCIÓN EVENTO");
		}

		
	}
		//eventos
		// Métodos individuales para cada evento
		private static void eventoBruja(Protagonista prota, Random random, Scanner sc) {
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
			
			if(prota.getNombre().equals("Steve"))
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

		private static void eventoMaldicion(Protagonista prota, Random random, Scanner sc, double suertePersonaje) {
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			String decision = "";
			double suerteEvento = 0;
			int totalMonedasConseguidas = 0;
			
			System.out.println("En tu camino te encuentras con un grupo de pillagers muertos en el suelo.");
			if(prota.getNombre().equals("Steve"))
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
			if(prota.getNombre().equals("Steve"))
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
				if(prota.getNombre().equals("Steve"))
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
				
				System.out.println("Dentro del cofre había un total de " + Juego.monedas(prota.getNombre(), totalMonedasConseguidas) + Color.YELLOW +
						(prota.getNombre().equals("Chicken Little") ? " semillas" : " esmeraldas") + Color.RESET);
				
				if(totalMonedasConseguidas <= 5)
				{
					System.out.println("Un desperdicio de tiempo.");
				}
				
				
				if(prota.getNombre().equals("Steve"))
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

		private static void eventoTrampa(Protagonista prota, Random random, Scanner sc, double velocidadPersonaje, double defensaPersonaje, int numeroMonedas) {
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			
			boolean trampa = random.nextBoolean();
			
			int daño = 0;
			int monedasPerdidas = 0;
			
			if(prota.getNombre().equals("Steve"))
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
				else if(velocidadPersonaje >= 5) {
					monedasPerdidas = random.nextInt(3,6);
					if(numeroMonedas < monedasPerdidas) monedasPerdidas = numeroMonedas;
					/*System.out.println("Bloqueas gran parte de sus ataques pero consiguen robarte " + Color.RED_BRIGHT + monedas(nombrePersonaje, monedasPerdidas) + Color.RESET + (nombrePersonaje.equals("Chicken Little") ? " semillas" : " esmeraldas"));*/
					}
				else if(velocidadPersonaje < 5 && velocidadPersonaje >= 2) {
					monedasPerdidas = random.nextInt(5,9);
					if(numeroMonedas < monedasPerdidas) monedasPerdidas = numeroMonedas;
					/*System.out.println("Esquivas parte de sus ataques pero consiguen robarte " + Color.RED_BRIGHT + monedas(nombrePersonaje, monedasPerdidas) + Color.RESET + (nombrePersonaje.equals("Chicken Little") ? " semillas" : " esmeraldas"));*/
					}
				else {
					monedasPerdidas = random.nextInt(8,11);
					if(numeroMonedas < monedasPerdidas) monedasPerdidas = numeroMonedas;
					/*System.out.println("Los asaltantes te pillan desprevenido llevandose una gran parte de tu tesoro, pierdes " + Color.RED_BRIGHT + monedas(nombrePersonaje, monedasPerdidas) + Color.RESET + (nombrePersonaje.equals("Chicken Little") ? " semillas" : " esmeraldas"));*/
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

		private static void eventoJuan(Protagonista prota, Random random, Scanner sc) {
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			
			String decision;
			
			String[] encantamiento = {"Proteccion", "Afilado", "Espinas", "Fortuna", "Eficiencia", "Recarga rapida"};
			String[] encantamientoEncriptado = {"!¡∷𝙹ℸ ̣ ᒷᓵᓵ╎𝙹リ", "ᒷᓭ!¡╎リᔑᓭ", "ᔑ⎓╎ꖎᔑ↸𝙹", "ᒷ⎓╎ᓵ╎ᒷリᓵ╎ᔑ", "∷ᒷᓵᔑ∷⊣ᔑ  ∷ᔑ!¡╎↸ᔑ", "⎓𝙹∷ℸ ̣ ⚍リᔑ"};
			String[] nivel = {"I","II","III","IV","V",""};
			int[] costeVidaArray = new int[4];//4 espacios(0 a 3), uno por cada encantamiento generado aleatoriamente.
			
			String[][] encantamientosNivelesSeleccionados = new String[4][2];
			/*La matriz tiene 4 filas: los 4 encantamientos diferentes que se mostrarán al jugador.
			 * Cada fila tiene 2 columnas: El nombre del encantamiento. El nivel del encantamiento*/
			
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
					//Se suma 1 porque los niveles comienzan desde 0 (nivel I).
					//Multiplica por 3 para obtener el coste total.
					
					if(nivelRandom == 5)
					{
						costeVida = 9; // recarga rápida es igual al coste de un nivel III
					}
					
					if(prota.getNombre().equals("Steve")) {// si es steve, te salen los encantamientos con nombre
						System.out.println( "     " + (i + 1)  + "." + Color.CYAN_UNDERLINED + Color.CYAN_BOLD_BRIGHT + encantamiento[encantamientoRandom] + " " + nivel[nivelRandom]  + Color.RESET + "-> -" + costeVida +  " de vida maxima" + "\r\n");
					}else System.out.println( "     " + (i + 1)  + "." + Color.CYAN_UNDERLINED + Color.CYAN_BOLD_BRIGHT + encantamientoEncriptado[encantamientoRandom] + " " + nivel[nivelRandom] + Color.RESET + "-> -" + costeVida +  " de vida maxima"  + "\r\n");
					
					String[] guardarEncantamiento = new String[2];
					//array con dos elementos: Nombre y Nivel del encantamiento
					guardarEncantamiento[0] = encantamiento[encantamientoRandom];//guarda los encantamientos, niveles y coste de vida
					guardarEncantamiento[1] = nivel[nivelRandom];
					
					costeVidaArray[i] = costeVida;
					encantamientosNivelesSeleccionados[i] = guardarEncantamiento;//guarda en una matriz los arrays de distintos encantamientos, y niveles
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

		private static void eventoPerro(Protagonista prota, Random random, Scanner sc) {
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
			
			if (decision.equalsIgnoreCase("1") || decision.equalsIgnoreCase("Si"))
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
				
				if(prota.getNombre().equals("Steve")) {
				System.out.println("  1.Revivir a Niebla | 2.Mas poder | 3.Dinero ilimitado | 4.Ser invencible");
				}
				else {
					System.out.println("  1.Mas poder | 2.Dinero ilimitado | 3.Ser invencible");
				}
				System.out.println("");
				
				decision = sc.nextLine();
				
				while (!decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2") && !decision.equalsIgnoreCase("3") && !decision.equalsIgnoreCase("4") && !decision.equalsIgnoreCase("Revivir a Niebla") && !decision.equalsIgnoreCase("Más poder") && !decision.equalsIgnoreCase("3") && !decision.equalsIgnoreCase("4")) {
		
					System.out.println("Decidido exclamas " + "\"" + decision + "\"");
					System.out.println("\"No he entendido tu deseo, ¿Puedes repetirlo?\"");
					System.out.println("");
					
					if (prota.getNombre().equals("Steve")) {
					System.out.println(" 1.Revivir a Niebla | 2.Mas poder | 3.Dinero ilimitado | 4.Ser invencible");
					}
					else {
						System.out.println("  1.Mas poder | 2.Dinero ilimitado | 3.Ser invencible");
					}
					decision = sc.nextLine();
				}
				
				if (prota.getNombre().equals("Steve")) {
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
						System.out.println("\"¡Enhorabuena! Has obtenido " + Juego.monedas(prota.getNombre(), 30) + Color.YELLOW + (prota.getNombre().equals("Chicken Little") ? " semillas" : " esmeraldas") + Color.RESET + ". ¡Tu tesoro crece y tu aventura continúa!\"-dijo entusiasmado");
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
				} else {
					switch(decision) {
				case "1": { 
					
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
				
				case "2": { 
					
					randomGenio = random.nextInt(0,11);
					
					numerin = random.nextInt(nombresGonzalo.length);
					
					if(randomGenio >= 7) {
						finalArray[0][0] = "Monedas";
						finalArray[0][1] = "30";
						System.out.println("\"¡Enhorabuena! Has obtenido " + Juego.monedas(prota.getNombre(), 30) + Color.YELLOW + (prota.getNombre().equals("Chicken Little") ? " semillas" : " esmeraldas") + Color.RESET + ". ¡Tu tesoro crece y tu aventura continúa!\"-dijo entusiasmado");
						System.out.println("Gracias a " + Color.GREEN_BOLD_BRIGHT + "Gonzalo " + nombresGonzalo[numerin] + Color.RESET +  "ahora te sientes mas rico aunque tambien la gran pena de no poder ver mas a Niebla");
						
					} else System.out.println("\"Lamentablemente, no puedo conceder ese deseo en este momento. Sin embargo, siempre estaré aquí para ayudarte en lo que necesites. ¡Sigue adelante!\"-dijo alegre");
					break;
				}
				
				case "3": { 
					
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
			}
			
			else
			{
				System.out.println("Te marchas esquivando la urna cuidadosamente.");
				System.out.println("Al rato ya dejas la urna atras y conforme te alejas te invade el arrepentimiento por no descubrir que hay en la urna.");
			}
			return;
		}

		private static void eventoLamborgini(Protagonista prota, Random random, Scanner sc, int numeroMonedas, double vidaPersonaje) {
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
				System.out.println("Tienes " + Color.YELLOW + Juego.monedas(prota.getNombre(), prota.getMonedas()) + Color.RESET + " semillas");
				System.out.println("¿Compras algo?");
				System.out.println("");
				System.out.println("   1.Comida sospechosa (" + Juego.monedas(prota.getNombre(), 5) + ") \r\n" + "   2.Armadura de dudosa calidad (" + Juego.monedas(prota.getNombre(), 5) + ") \r\n" + 
						   "   3.Un motherfucking lamborgini (" + Juego.monedas(prota.getNombre(), 50) + ") \r\n" + "   4.Protector para picos 3000 (" + Juego.monedas(prota.getNombre(), 5) + ") \r\n" + "   5.Marcharte \r\n");
				
				decision = sc.nextLine();
				
				while (!decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2") && !decision.equalsIgnoreCase("3") && !decision.equalsIgnoreCase("4") && !decision.equalsIgnoreCase("5") &&!decision.equalsIgnoreCase("Comida sospechosa") && !decision.equalsIgnoreCase("Armadura de dudosa calidad") && !decision.equalsIgnoreCase("Un motherfucking lamborgini") && !decision.equalsIgnoreCase("Protector para picos 3000") && !decision.equalsIgnoreCase("Marcharte")) {
					
					System.out.println("La dificil decision de si comprar o no te deja confuso por lo que piensas " + "\"" + decision + "\"" + 
										" pero rapidamente te das cuenta de lo ridiculo que es eso y decides volver a elegir");
					System.out.println("¿Compras algo?");
					System.out.println("");
					System.out.println("   1.Comida sospechosa (" + Juego.monedas(prota.getNombre(), 5) + ") \r\n" + "   2.Armadura de dudosa calidad (" + Juego.monedas(prota.getNombre(), 5) + ") \r\n" + 
							   "   3.Un motherfucking lamborgini (" + Juego.monedas(prota.getNombre(), 50) + ") \r\n" + "   4.Protector para picos 3000 (" + Juego.monedas(prota.getNombre(), 5) + ") \r\n" + "   5.Marcharte \r\n");
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

		private static void eventoDrogas(Protagonista prota, Scanner sc, double vidaMaxPersonaje, double vidaPersonaje, double defensaPersonaje,
			double velocidadPersonaje, int numeroMonedas,double fuerzaPersonaje) {
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			
			String decision = "";
			
			System.out.println(prota.getNombre() + " se adentra a un bosque");
			System.out.println("Aquí, " + prota.getNombre() + " encuentra unas " + Color.PURPLE + "setas" + Color.RESET + "...");
			System.out.println("A " + prota.getNombre() + "Le resultan realmente apeticbles..." + "tal vez podrian comerse...");
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
				System.out.println("A " + prota.getNombre() + " le mata la curiosidad...");
				System.out.println("...");
				System.out.println(".......");
				System.out.println("Consumes las " + Color.PURPLE + "setas" + Color.RESET + "......");
				System.out.println("........");
				System.out.println(prota.getNombre() + " se siente.... " + "¡" + Color.PURPLE + "B" + Color.YELLOW + "I" + Color.GREEN_BRIGHT + "E" + Color.RED_BRIGHT + "N" + Color.RESET + "!");
				System.out.println("......");
				System.out.println(Color.PURPLE + prota.getNombre().toUpperCase()  + Color.GREEN_BRIGHT +  "SE SIENT" + Color.RED_BRIGHT +  "E MUCH" + Color.YELLOW + "ISIMO MAS" + Color.PURPLE +  "PO"  + Color.BLUE + "DEROSO" + Color.RESET);
				System.out.println("¡Las estadisticas de " + prota.getNombre().toUpperCase() + " se han multiplicado!");
				System.out.println(Color.PURPLE + "Vida: "  + Color.RED_BRIGHT + (vidaPersonaje/0.69) + "/" + vidaMaxPersonaje);
				System.out.println(Color.YELLOW + "Defensa: "  + Color.GREEN_BRIGHT +  defensaPersonaje/0.69);
				System.out.println(Color.CYAN + "Fuerza: " + Color.PURPLE + fuerzaPersonaje/0.69);
				System.out.println(Color.RED_BRIGHT + "Velocidad: " + Color.BLUE + velocidadPersonaje/0.69);
				System.out.println(prota.getNombre() + " se encuentra a Barbie Playera y a Buzz Lightyear, los cuales estaban tomandose un martini juntos en la playa");
				System.out.println("Pronto después llega Freddy Fazbear y se une a la fiesta");
				System.out.println("Sin embargo, " + prota.getNombre() + " no se encuentra muy bien...");
				System.out.println(prota.getNombre() + " se desmaya en frente de Buzz Lightyear Barbie Playera y Freddy Fazbear!");
				finalArray[0][0] = "Drogas";
				finalArray[0][1] = "true";
			}
			
			
			return;
		}

		private static void eventoPuzzle(String[][] finalEventoArray, Random random, Scanner sc, Protagonista prota) {
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
	                        
	                    finalEventoArray = puzzleLamparas(random, sc, prota);
	                    break;
	                }
	                //Adivinanza
	                case 3: {
	                    finalEventoArray = puzzleAdivinanza(random, sc, prota);
	                    break;
	                }
	                //Adivinanza
	                case 4: {
	                    finalEventoArray = puzzleTrivia(random, sc, prota);
	                    break;
	                }
	                //Opinión
	                case 5: {
	                    finalEventoArray = puzzleOpinion(random, sc, prota);
	                    break;
	                }
	                    
	            }
			return;
		}

		//Puzzle
		public static String[][] puzzlePiedraPapelTijera(Random random, Scanner sc){
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			int victoria = 0;
			int derrota = 0;

			System.out.println("Un esqueleto de apariencia magica se presenta ante ti.");
			System.out.println("El te reta a una partida de Piedra, Papel y Tijera.");
			System.out.println("");
			System.out.println("\"Escoge tu proximo movimiento\"-te dice con voz siniestra ");
			System.out.println("");
			
			while(victoria < 3 && derrota < 3)
			{
				String decisionPlayer = "";
				int decisionEnemigo = 1;
				int intg;//intg es una varibale que combierte las String en int
				
				
				System.out.println("    1.Piedra | 2.Papel | 3.Tijera ");
				
				decisionPlayer = sc.nextLine();
				
				while (!decisionPlayer.equals("1") && !decisionPlayer.equals("2") && !decisionPlayer.equals("3")) {

					System.out.println("\"Ser de conocimiento escaso, introduce, 1, 2 o 3\"-dijo");
					decisionPlayer = sc.nextLine();
				}
				
				String[] ppt = {"¡Piedra!", "¡Papel!", "¡Tijera!"}; 
				int decisionPlayerI = (intg = Integer.valueOf(decisionPlayer));
				
				decisionEnemigo = random.nextInt(1,4);
				
				
				switch(decisionPlayerI - decisionEnemigo)//hemos descubierto que si restas las decisiones, siendo piedra 0, papel 1, y tijera 2, la respuesta numérica nos dice quien ha ganado
				{
				case 1, -2: //victoria
					victoria++;
					System.out.println("   " + (Color.GREEN + ppt[decisionPlayerI -1] + Color.RESET) + " |VS| " + (Color.RED +ppt[decisionEnemigo-1] + Color.RESET));
					
					String[] frases1 = {"\"Finalmente alguien divertido\"-dice sonriente", "\"Gran predicción\"-exclama el esqueleto", 
							   "El esqueleto hace una voltereta en direccion trasera", "El esqueleto sonrie"};
					System.out.println(frases1[random.nextInt(frases1.length)]);
					System.out.println("");
					if(victoria < 3 && derrota < 3) System.out.println("\"Elige otra vez\"-dice alegre");
				break;
				
				case -1,2: //derrota
					derrota++;
					System.out.println("   " + (Color.GREEN + ppt[decisionPlayerI -1] + Color.RESET) + " |VS| " + (Color.RED +ppt[decisionEnemigo-1] + Color.RESET));
				
					String[] frases2 = {"\"Has demostrado tu deficiente inteligencia\"-dice el esqueleto decepcionado", "\"Vaya desagradecido\"-exclama el esqueleto", 
							   "El esqueleto mueve la cabeza en señal de desaprobacion", "El esqueleto se queda inmovil"};
					System.out.println(frases2[random.nextInt(frases2.length)]);
					System.out.println("");
					if(victoria < 3 && derrota < 3) System.out.println("\"Elige otra vez\"-dice entristecido");
				break;
				
				case 0: //empate
					System.out.println("   " + (Color.GREEN + ppt[decisionPlayerI -1] + Color.RESET) + " |VS| " + (Color.RED +ppt[decisionEnemigo-1] + Color.RESET));
					
					String[] frases3 = {"\"Curioso...un empate\"-dice el esqueleto mientras se rascaba la cabeza", "\"Empate, vaya sorpresa\"-exclama el esqueleto", 
							   "El esqueleto te mira con sus ojos vacios", "El esqueleto se queda inmovil"};
					System.out.println(frases3[random.nextInt(frases3.length)]);
					System.out.println("");
					if(victoria < 3 && derrota < 3) System.out.println("\"Elige otra vez\"-dice animado");
				}
				
				System.out.println("    TU: " + Color.GREEN_BOLD + victoria + Color.RESET + " / " + Color.RED_BOLD + derrota + Color.RESET + " :ESQUELETO \r\n");
				
				if(victoria == 3) {
					System.out.println("\"Te agradezco este agradable momento, puedes continuar\"-dice complacido");
					System.out.println("");
					finalArray[0][0] = "Suerte";
					finalArray[0][1] = "3";
					System.out.println("Te sientes afortunado... +3 de " + Color.YELLOW + "suerte" + Color.RESET + "!");
				}
				if(derrota == 3) {
					System.out.println("\"Desaparece de mi vista, aburrido infeliz\"-dice claramente decepcionado");
					System.out.println("");
				}
				
			}
			return finalArray;
		}
		
		public static String[][] puzzleLamparas(Random random, Scanner sc, Protagonista prota){
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			
			int intg = 0;
			int aciertos = 0;
			int turnos= 10;
			
			int comprobacionInicial = 0;
			
			String[] lampara = { "  ⬛⬛⬛⬛⬛  "
					 ,"  ⬛⬛⬛⬛⬛  "
					 ,"  ⬛⬛⬛⬛⬛  "
					 ,"  ⬛⬛⬛⬛⬛  "};
			
			boolean[] encendido = new boolean[4];
			String decision = "";
			
			for (int i = 0; i < encendido.length; i++) {
				
				encendido[i] = random.nextBoolean();//Las lámparas se encienden o apagan al azar.
			}
			
			for (int i = 0; i < encendido.length; i++) {
				
				if(encendido[i])
				{
					comprobacionInicial++;
				}
			}
			
			if(comprobacionInicial == 4)
			{
				encendido[random.nextInt(0, 4)] = false; //si estan todas encendidads, se apaga una
			}
			
			System.out.println("Te encuentras una fila de 4 lamparas de redstone");
			System.out.println("Te fijas que hay un boton debajo de cada lampara");
			System.out.println("");
			
		while(aciertos < 4 && turnos != 0)
		{
			for (int i = 0; i < 4; i++) {//imprime  el estado visual de las lámparas, true = encendida, false = apagada
				System.out.println((encendido[0] ? Color.YELLOW_BRIGHT + lampara[i] : lampara[i]) + Color.RESET + (encendido[1] ? Color.YELLOW_BRIGHT + lampara[i] : lampara[i]) + Color.RESET  + 
						   (encendido[2] ? Color.YELLOW_BRIGHT + lampara[i] : lampara[i]) + Color.RESET  + (encendido[3] ? Color.YELLOW_BRIGHT + lampara[i] : lampara[i]) + Color.RESET );
				
			}
			
			if(aciertos < 4)
			{
				aciertos = 0;
				
				System.out.println("Cual boton eliges pulsar");
				System.out.println("      1   2    3   4");
				
					decision = sc.nextLine();
				
					while (!decision.equals("1") && !decision.equals("2") && !decision.equals("3")&& !decision.equals("4")) {
		
						System.out.println("Tontamente decides presionar el boton " + decision + " pero resulta que no existe, intentalo otra vez.");
						decision = sc.nextLine();
					}
					
				intg = Integer.valueOf(decision);// de String a int
				
				/*Cambia el estado de la lámpara seleccionada y las que se encuentran a la izquierda(-1) y la derecha(+1).
				 *  y que se encuetrn entre 1-4. Si el jugador pulsa "2", se alteran las lámparas 1, 2 y 3.*/
				encendido[(intg - 1)] = encendido[(intg - 1)] ? false : true;
//				if(encendido[(intg - 1)])                   //if (?) else (:)
//				{
//					encendido[(intg - 1)] = false;
//				}
//				else
//				{
//					encendido[(intg - 1)] = true;
//				}
				if(intg > 1) {
					encendido[(intg - 1) - 1] = encendido[(intg - 1) - 1] ? false : true;
				}
				if(intg < 4) {
					encendido[(intg - 1) + 1] = encendido[(intg - 1) + 1] ? false : true;
				}	
				//Cuenta cuántas lámparas están encendidas después de cada jugada.
				for (int i = 0; i < encendido.length; i++) {
					if(encendido[i] == true) {
						aciertos++;
					}
				}
			}
			
			if(aciertos == 4) {
				
				System.out.println("\"¡Clank!  ¡Clank!\"");
				System.out.println("");
				for (int i = 0; i < 4; i++) {
					System.out.println((encendido[0] ? Color.YELLOW_BRIGHT + lampara[i] : lampara[i]) + Color.RESET + (encendido[1] ? Color.YELLOW_BRIGHT + lampara[i] : lampara[i]) + Color.RESET  + 
							   (encendido[2] ? Color.YELLOW_BRIGHT + lampara[i] : lampara[i]) + Color.RESET  + (encendido[3] ? Color.YELLOW_BRIGHT + lampara[i] : lampara[i]) + Color.RESET );
					
				}
				System.out.println("");
				
				System.out.println("Escuchas un sonido mecanico tras las lamaparas y en un abrir y cerrar de ojos la pared ante ti se abre revelando un enorme cofre");
				System.out.println("Obtienes " + Juego.monedas(prota.getNombre(), 15) + (prota.getNombre().equals("Chicken Little") ? " semillas " :  " esmeraldas "));
				
				finalArray[0][0] = "Monedas";
				finalArray[0][1] = "15";
			
			}
			
			if(turnos == 0 && aciertos != 4) {
				System.out.println("Las luces se apagan repetinamente al acabarse tus turnos restantes.");
				System.out.println("Entristecido te marchas con las manos vacias.");
			}
			
			System.out.println("");
			System.out.println("Guardas tu botin y continuas tu aventura felizmente");
		}
			
			return finalArray;
		}
		
		public static String[][] puzzleAdivinanza(Random random, Scanner sc, Protagonista prota){
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			
			String decision = "";
			
			boolean acierto = false;
			double decisionDouble = 0.0;
			int turnos= 5;
			
			System.out.println("Una enorme puerta de hierro bloquea tu camino");
			System.out.println("No parece tener forma de abrirla, ni pomo, ni botones, ni palancas");
			System.out.println("¿Intentaras forzar la puerta?");
			System.out.println("");
			System.out.println("       1.Si    |    2.No");
			
			decision = sc.nextLine();
			
			while (!decision.equalsIgnoreCase("Si") && !decision.equalsIgnoreCase("No") && !decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2")) {

				System.out.println("Con toda tu inteligencia tratas de decidirte y exclamas" + "¡" + decision + "!" + ", pero eso no resuelve nada...");
				System.out.println("De nuevo, ¿Intentaras forzar la puerta? \n");
				System.out.println("");
				System.out.println("       1.Si    |    2.No");
				decision = sc.nextLine();
			}
			
			if(decision.equalsIgnoreCase("Si") || decision.equalsIgnoreCase("1")) {
				System.out.println("Empujas la puerta con todas tus fuerzas pero no pasa nada. La intentas golpear hasta el agotamiento, pero tampoco pasa nada.");
				System.out.println("Despues de tanto esfuerzo te das cuenta de que obviamente no vas a forzar una puerta enorme de hierro.");
				System.out.println("Desesperado procedes a irte, pero un sonido llama tu atencion...");

			}
			if(decision.equalsIgnoreCase("No") || decision.equalsIgnoreCase("2")) {
				System.out.println("Decides pensar otra obpcion pues es imposible forzar algo tan pesado");
				System.out.println("Al rato un pequeño ruido interrumpe tu pensamiento");
			}
			
			
			System.out.println("¡Es un bloque musical!");
			
			while(acierto == false && turnos != 0)
			{
				turnos--;
				
				System.out.println("Por el bloque se comienza a escuchar una voz");
				System.out.println("");
				System.out.println("\"Para aquellos limitados por la puerta, dejadme haceros una oferta\"-dijo la voz de la caja");
				System.out.println("");
				System.out.println("\"Si entre el 0 y el 1 un numero real hallais, tal vez pasar podais\"-dijo la voz de la caja");
				System.out.println("\"Restan " + Color.RED_BOLD + turnos + Color.RESET + " turnos, para dar tu respuesta\"-dijo la voz");
				System.out.println("¿Que numero sera el que elijas? \n");
				
				if (sc.hasNextDouble()) {
					
					decisionDouble = sc.nextDouble();        
		        } 
				else {
		        	// lee el resto de la línea como String
		            String decisionString = sc.nextLine(); 
		            System.out.println("Ser de inteligencia deficiente, tu respuesta " + decisionString + " no es suficiente.");
		        }
				
				double numeroGracioso = random.nextDouble(0, 1);
//				System.out.println(numeroGracioso);
				if(decisionDouble == numeroGracioso)
				{
					acierto = true;
					
					System.out.println("La caja emite una pequeña musica");
					System.out.println(Color.CYAN_BRIGHT + "¡FELICIDADES HAS ADIVINADO EL NUMERO DE LA SUERTE SUPREMA!-dice la voz" + Color.RESET);
					System.out.println("A partir de ahora tendras todo lo que necesites");
					
					////// TODO Y esto te hace ganar basicamente y te saca del bucle del juego System.out.println("Vendo cocaína en la Calle Inventada numero 123"); /////////////////
				}
				
				int resultadoReal = random.nextInt(0,2);/*Ttambién puede ganar si su número es exactamente 0 o 1, porque 
				nextInt(0, 2) genera 0 o 1).*/
				if(decisionDouble == resultadoReal)
				{
					acierto = true;
					
					System.out.println("\"Adivinaza adivinada, la puerta ya no esta sellada\"-dijo la voz");
					System.out.println(Color.CYAN_BRIGHT + "¡CLing!¡Clang!" + Color.RESET);
					System.out.println("La enorme puerta se abre ante ti, pasas aliviado de poder escapar finalmente.");
					System.out.println("Esta experiencia expande tus conocimientos ganando " + Color.YELLOW_BRIGHT + "2 de velocidad" + Color.RESET);
					
					finalArray[0][0] = "Velocidad";
					finalArray[0][1] = "2";
				}
				if(turnos == 0 && acierto != true) {
					
					System.out.println("\"La prueba no ha sido superda\"-dijo la voz");
					System.out.println("\"Para por la puerta pasar, "  + Color.RED_BOLD + Juego.monedas(prota.getNombre(), 10) + " esmeraldas deberas pagar\"-dijo la puerta" + Color.RESET);
					System.out.println("");
					
					finalArray[0][0] = "Monedas";
					finalArray[0][1] = "-10";
				}
			}
			
			System.out.println("");
			System.out.println("Atraviesas la puerta y continuas con tu aventura");
			
			sc.nextLine();
			
			return finalArray;
		}
		
		public static String[][] puzzleTrivia(Random random, Scanner sc, Protagonista prota){
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			
			//// VARIABLES ////
			String decision;
			int aciertos = 0;
			int errores = 0;
			int nextIndex = 0;
					
			//// INTRODUCCIÓN AL PUZZLE ////
			System.out.println("En medio de tu camino una enorme criatura se planta ante ti.");
			System.out.println("Es un ajolote, el mas grande que hayas visto nunca, el se queda sentado en una pose muy parecida a una esfinge \r\n");
			System.out.println("\"Pequeña criatura, este camino esta prohibido, si aun asi deseas pasar nos tendremos que enfrentar\"-dijo la criatura con una voz relajada ");
			System.out.println("");
			System.out.println("¿Cual sera tu elección?");
			System.out.println(" 1. Aceptar el desafio | 2. Atacar a la criatura");
					
			decision = sc.nextLine();
			
			//// COMPROBAR DECISIÓN ////
			while (!decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2")) {
							
					System.out.println("Confundido por la dificultad de decidir 1,2 o 3, terminas gritando " + "¡" + decision + "!");
					System.out.println("El ajolote te mira extrañado");
					System.out.println("\"¿Has decidido ya?\"-dice con voz amenazante");
					System.out.println(" 1. Aceptar el desafio | 2. Atacar a la criatura \r\n");
					decision = sc.nextLine();
			}
			
			//// REACCION A LAS DECISIÓN (NO SIRVE DE NADA PERO ME HACE GRACIA) ////
			if(decision.equals("2")) {
				
				System.out.println("Te avalanzas contra el ajolote con todas tus fuerzas y le golpeas en toda la cara");
				System.out.println("Este simplemente te mira decepcionado");
				System.out.println("\"Bien ahora que has tomado tu decision deja que te explique las reglas del enfrentamiento\"-dijo con tono enfadado");
			}
			
			System.out.println("\"De acuerdo, nos efretaremos en un combate de preguntas\"-dijo el ajolote animado \r\n");
			System.out.println("\"Yo te hare un total de " + Color.YELLOW_BRIGHT + "5 preguntas " + Color.RESET + 
							   "y si fallas alguna yo te quitare algo de mi eleccion, pero si aciertas tu recibiras algo de mi eleccion\"-explico la criatura \r\n");
			System.out.println("\"Sin perder mas tiempo comienzo con la primera pregunta\"-dijo tras finalizar la explicacion");
			System.out.println("");
			
			
			
			//// BUCLE DEL PUZZLE ////
			for (int i = 0; i < 5; i++)
			{
				System.out.println(Color.PURPLE_BRIGHT + "                                                                                                    \r\n"
						+ "                              ▓▓▓▓▓▓                             ▓▓▓▓▓                              \r\n"
						+ "                              ▓▓▓▓▓▓                             ▓▓▓▓▓                              \r\n"
						+ "               ▓▓▓▓▓          ▓▓▓▓▓▓▓▓▓▓▓                   ▓▓▓▓▓▓▓▓▓▓          ▓▓▓▓▓▓              \r\n"
						+ "               ▓▓▓▓▓          ▓▓▓▓▓▓▓▓▓▓▓                   ▓▓▓▓▓▓▓▓▓▓          ▓▓▓▓▓▓              \r\n"
						+ "               ▓▓▓▓▓▓▓▓▓▓          ▓▓▓▓▓▓▓▓▓▓▓         ▓▓▓▓▓▓▓▓▓▓          ▓▓▓▓▓▓▓▓▓▓▓              \r\n"
						+ "               ▓▓▓▓▓▓▓▓▓▓          ▓▓▓▓▓▓▓▓▓▓▓         ▓▓▓▓▓▓▓▓▓▓          ▓▓▓▓▓▓▓▓▓▓▓              \r\n"
						+ "                    ▓▓▓▓▓▓▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓▓▓▓▓                    \r\n"
						+ "                    ▓▓▓▓▓▓▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓▓▓▓▓                    \r\n"
						+ "                         ▓▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓                         \r\n"
						+ "                         ▓▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓                         \r\n"
						+ "                         ▓▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓                         \r\n"
						+ "               ▓▓▓▓▓          " + Color.BLACK + "█████▒" + Color.PURPLE_BRIGHT + "░░░░░░░░░" + Color.BLACK + "▒▓▓▓▓▓▓▓▓▓" + Color.PURPLE_BRIGHT + "░░░░░░░░░░" + Color.BLACK + "▓████" + Color.PURPLE_BRIGHT + "          ▓▓▓▓▓▓              \r\n"
						+ "               ▓▓▓▓▓          " + Color.BLACK + "█████▒" + Color.PURPLE_BRIGHT + "░░░░░░░░░" + Color.BLACK + "▒▓▓▓▓▓▓▓▓▓" + Color.PURPLE_BRIGHT + "░░░░░░░░░░" + Color.BLACK + "▓████" + Color.PURPLE_BRIGHT + "          ▓▓▓▓▓▓              \r\n"
						+ "               ▓▓▓▓▓▓▓▓▓▓     ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     ▓▓▓▓▓▓▓▓▓▓▓              \r\n"
						+ "               ▓▓▓▓▓▓▓▓▓▓     ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     ▓▓▓▓▓▓▓▓▓▓▓              \r\n"
						+ "                    ▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓                   \r\n"
						+ "                    ▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓                   \r\n"
						+ "                                                                                                    \r\n" + Color.RESET);
				
				//// SELECCION DE PREGUNTAS ////
				String[][] PreguntasRespuestas = { {"               ¿Cuantos turnos tardara un creeper en explotar, en una situacion normal?", "3"}, 
													{"                   ¿Cuanta vida restaura una pocion, en situaciones normales?", "10"}, 
													{"                Responde verdadero o falso, ¿las brujas son capaces de darte pocion de suerte?", "verdadero"},
													{"                Responde verdadero o falso, ¿las brujas son capaces de darte un gato?", "falso"},
													{"                   ¿Que efecto de estado provoca un asalto a una aldea?", "Mal presagio"},
													{"                              ¿Que criatura posee tres cabezas?", "Wither"},
													{"               ¿Cual es el maximo de enemigos por encuentro, en situaciones normales?", "5"},
													{"                              ¿Cuanto ataque otorga la pocion de fuerza?", "4"}, 
													{"               ¿Cuales son los tres numeros de la parte trasera de tu tarjeta bancaria?", "si"}};
				
				int pregunta = random.nextInt(PreguntasRespuestas.length);
				System.out.println(Color.YELLOW_BRIGHT + PreguntasRespuestas[pregunta][0].toUpperCase() + Color.RESET + Color.CYAN);
				
				decision = sc.nextLine();
				System.out.println(Color.RESET);
				
				
				// Comprueba las decisiones que pueden dar error 
				if(decision.equalsIgnoreCase("malpresagio") || decision.equalsIgnoreCase("BadOmen") || decision.equalsIgnoreCase("Bad Omen")) {
					decision = "Mal presagio";
				}
				
				if(pregunta == 8) {decision = "si";}
				
				//// RECOMPENSA AL GANAR ////
				if(PreguntasRespuestas[pregunta][1].equalsIgnoreCase(decision))
				{
					System.out.println("\"Respuesta" + Color.GREEN_BOLD +  " correcta"  + Color.RESET + ", ahora decidire tu recompensa\"-dice el ajolote");
					
					int recompensaTrivial = random.nextInt(1, 5);
					
					aciertos++;
			
					switch(recompensaTrivial) {
					
						case 1:
							System.out.println("Recibes " + Color.GREEN_BOLD + Juego.monedas(prota.getNombre(), 10) + (prota.getNombre().equals("Chicken Little") ? " semillas " : " esmeraldas ") + Color.RESET + "del ajolote");
							
							finalArray[i][0] = "Monedas";
							finalArray[i][1] = "10";
						break;
						
						case 2:
							System.out.println("Recibes una" + Color.YELLOW_BOLD + " pocion de Vida " + Color.RESET + "del ajolote");
							
							finalArray[i][0] = "Pocion Vida";
							finalArray[i][1] = "1";
						break;
						
						case 3:
							System.out.println("Recibes una" + Color.YELLOW_BOLD + " pocion de Fuerza " + Color.RESET + "del ajolote");
							
							finalArray[i][0] = "Pocion Fuerza";
							finalArray[i][1] = "5";
						break;
						
						case 4:
							System.out.println("Recibes" + Color.BLUE_BOLD +" armadura" + Color.RESET);
							
							finalArray[i][0] = "Defensa";
							finalArray[i][1] = "1";
					}
				}
				
				//// CASTIGO AL FALLAR ////
				if(!PreguntasRespuestas[pregunta][1].equalsIgnoreCase(decision)) {
					
					System.out.println("\"Respuesta" + Color.RED_BOLD +  " incorrecta "  + Color.RESET + ", ahora decidire tu castigo\"-dice el ajolote");
						
					int castigoTrivial = random.nextInt(1, 5);
					
					errores++;
						
					switch(castigoTrivial) {
						
						case 1:
							System.out.println("El ajolote te golpea quitandote" + Color.RED_BOLD + " 10 de daño " + Color.RESET);
								
							finalArray[i][0] = "Vida";
							finalArray[i][1] = "-5";
						break;
							
						case 2:
							System.out.println("El ajolote te roba " + Color.RED_BOLD + Juego.monedas(prota.getNombre(), 10) + (prota.getNombre().equals("Chicken Little") ? " semillas" : " esmeraldas") + Color.RESET);
								
							finalArray[i][0] = "Monedas";
							finalArray[i][1] = "-10";
						break;
						
						case 3:
							System.out.println("Recibes la maldicion del" + Color.BLACK_BOLD + " mal presagio " + Color.RESET);
								
							finalArray[i][0] = "Bad Omen";
							finalArray[i][1] = "10";
						break;
							
						case 4:
							System.out.println("Tu armadura" + Color.RED_BOLD + " pierde porder " + Color.RESET);
								
							finalArray[i][0] = "Defensa";
							finalArray[i][1] = "-1";
						}
					}
				
				nextIndex = i;
				System.out.println("");
				
				
				
			}
			//// VICTORIA ////
			if(aciertos >= 3) {
				if(errores > 0) {System.out.println("\"Felicidades viajero has logrado pasar la prueba con " + errores + " errores\"-dijo alegre");}
				if(errores == 0) {
					System.out.println("\"Felicidades viajero has logrado pasar la prueba sin cometer ningun error como recompensa te dare parte de mi poder\"-dijo el ajolote entusiasmado \r\n");
					System.out.println("Te sientes mas fuerte, tu vida maxima aumenta 10 puntos");
					
					finalArray[nextIndex][0] = "VidaMax";
					finalArray[nextIndex][1] = "10";
				}
			}
			
			//// DERROTA ////
			if(aciertos < 3) {
				if(aciertos > 0) {
					System.out.println(Color.RED_BRIGHT + "\"No has superado la prueba " + Color.RESET + "viajero, puedes pasar aunque con un castigo\"-dijo aburrido \r\n");
					System.out.println("Te sientes mas debil, pierdes 5 de vida maxima");
					
					finalArray[nextIndex][0] = "VidaMax";
					finalArray[nextIndex][1] = "-5";
				}
				if(aciertos == 0) {
					System.out.println("\"Por lo que veo ni siquiera lo has intentado, vaya perdida de tiempo, continua con tu aventura desgraciado\"-dijo el ajolote completamente decepcionado \r\n");
					System.out.println("Humillado sientes como parte de tu fuerza escapa de tu cuerpo, pierdes 10 de vida maxima");
					
					finalArray[nextIndex][0] = "VidaMax";
					finalArray[nextIndex][1] = "-10";
				}
			}	
			
			return finalArray;
		}
		
		public static String[][] puzzleOpinion(Random random, Scanner sc, Protagonista prota){
			String[][] finalArray = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
			
			String decision;
			boolean opinionValida = false;
			String[] opinion = {"0","1","2","3","4","5","6","7","8","9","10"};
			boolean fin = false;
			
			System.out.println("En tu camino encuentras a un anciano sentado pensativo.");
			System.out.println("Cuando se percata de tu presencia te saluda amablemente con la mano.");
			System.out.println("\"Joven aventurero, permiteme hacerte una sencilla pregunta\"-dijo con voz calmada");
			System.out.println("");
			System.out.println("   1.Aceptar | 2.Rechazarle");
			
			decision = sc.nextLine();
			
			while (!decision.equalsIgnoreCase("Aceptar") && !decision.equalsIgnoreCase("Rechazarle") && !decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2")) {
				
				System.out.println("\"Puedes repetir joven, no he entendido tu respuesta\"-dijo extrañado");
				decision = sc.nextLine();
			}
			
			if(decision.equalsIgnoreCase("Aceptar") || decision.equalsIgnoreCase("1")) {
				
				System.out.println("\"De acuerdo joven, ahi va mi pregunta\"-dijo entusiasmado");
				
				while(fin == false) {
					
					System.out.println("");
					System.out.println("\"¿Cual es la opinión que sostienes sobre este mundo en una escala del 0-10?\"-pregunto");
					
					while(opinionValida == false) {
						
						decision = sc.nextLine();
						for (int i = 0; i < opinion.length; i++) {
							if(opinion[i].equals(decision)) {
								opinionValida = true;
								i = 10;
								}
						}	
						if(opinionValida == false) {
							System.out.println("Joven tu respuesta " + decision + " no esta entre 0-10, responda otra vez.");
						}
						
					}
					
					int opinionElegida = Integer.valueOf(decision);
					
					switch(opinionElegida) {
					
					case 0,1,2,3,4: {
						opinionValida= false;
						System.out.println("\"¿Estas seguro de tu opinion?\"-pregunto seriamente");
						System.out.println("  1.Si | 2.No");
						decision = sc.nextLine();
							
							while (!decision.equalsIgnoreCase("Si") && !decision.equalsIgnoreCase("No") && !decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2")) {
									
								System.out.println("\"Puedes repetir joven, no he entendido tu respuesta\"-dijo extrañado");
								decision = sc.nextLine();
							}
							
						if(decision.equalsIgnoreCase("Si") || decision.equalsIgnoreCase("1")) {
							System.out.println("\"¿Seguro?, esta es tu " + Color.RED_BOLD_BRIGHT + "ultima advertencia" + Color.RESET + "\"-pregunto de nuevo");
							System.out.println("  1.Si | 2.No");
							decision = sc.nextLine();
								
							while (!decision.equalsIgnoreCase("Si") && !decision.equalsIgnoreCase("No") && !decision.equalsIgnoreCase("1") && !decision.equalsIgnoreCase("2")) {
									
								System.out.println("\"Puedes repetir joven, no he entendido tu respuesta\"-dijo extrañado");
								decision = sc.nextLine();
							}
						}
						if(decision.equalsIgnoreCase("Si") || decision.equalsIgnoreCase("1")) { 
							System.err.println("OPINION NO VALIDA");
							System.out.println(Color.RED_BOLD_BRIGHT + "Piensatelo mejor en tu próxima partida." +Color.RESET);
							System.out.println(prota.getNombre() + " piensa- Partida...?");
							System.out.println("Pero antes de darse cuenta...");
							decision = sc.nextLine();
							throw new Error("Sorry!! 😥"); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!:)    sorry not sorry    (:
						}
						if(decision.equalsIgnoreCase("No") || decision.equalsIgnoreCase("2")) { 
							System.out.println("\"Bien hecho, espero que hayas aprendido la leccion, ahora responde\"-dijo con una sonrisa burlona \r\n");
						}
						break;	
					}
					case 5: {
						System.out.println("\"Ni bien ni mal ¿eh?, bueno es una opinion aceptable\"-dijo poco emocionado \r\n");
						System.out.println("\"Suerte con tu aventura joven\"-dijo aburrido");
						fin = true;
						
					}
					case 6,7: {
						System.out.println("\"Bueno no es un 10 pero me hace feliz que lo disfrutes\"-dijo sonriente \r\n");
						System.out.println("\"Espero que tengas una gran suerte en tu aventura\"-dijo sonriente");
						System.out.println("");
						System.out.println("Te sientes complacido por estas palabras, tu suerte aumenta en 2 \r\n");
						
						finalArray[0][0] = "Suerte";
						finalArray[0][1] = "2";
						fin = true;
						break;
					}
					case 8,9,10: {
						System.out.println("\"¡Oh en serio! Me alegro de que los estes disfrutando\"-dijo alegre \r\n");
						System.out.println("\"Una verdadera pena que tengas que partir, aunque te llevas mi bendicion para que sigas disfrutando de tu aventura");
						System.out.println("");
						System.out.println("Te sientes altamente compalacido por las palabras del anciano, tu suerte aumenta en 2 y tu vida maxima en 5 \r\n");
						
						finalArray[0][0] = "Suerte";
						finalArray[0][1] = "2";
						finalArray[1][0] = "VidaMax";
						finalArray[1][1] = "5";
						fin = true;
					}
				}
				
				if(opinionElegida > 5) { System.out.println("Continuas con tu aventura despues de este gratificante evento, dejando atras la roca del anciano"); }
				if(opinionElegida == 5) { System.out.println("Continuas con tu aventura despues de este extraño evento, dejando atras la roca del anciano"); }
					
				}
			}
			
			if(decision.equalsIgnoreCase("Rechazarle") || decision.equalsIgnoreCase("2")) {
				System.out.println("Rechazas la oferta del anciano, quien se queda muy desilusionado, y decides continuar con tu camino");
				System.out.println("Al rato ya has perdido de vista la roca del anciano");
				
				//// FINALIZA EL PUZZLE ////
			}
			return finalArray;
}
}