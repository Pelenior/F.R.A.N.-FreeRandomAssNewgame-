package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;
public class Eventos {
	
	private String [] evento = {"Bruja", "Maldición", "Trampa", "Juan", "Puzzle"};
	private ArrayList<String> eventosLista = new ArrayList<String>();
	
	private int puntuacion;
	
	//función selecionar eventos
	//poner metodo público, que escoje un evento aleatorio y llama la función de ese evento
	 public void elegirEvento (Protagonista prota) throws SQLException {
		
		 puntuacion = 0;
		 
		 for (String eventoString : evento) {
			eventosLista.add(eventoString);
		}
		
		switch(prota.getNombre()) {
		case "Steve":
			eventosLista.add("Perro");
			break;
		case "Alex":
			eventosLista.add("Pelea Steve");
			break;
		case "Pollo":
			eventosLista.add("Lamborgini");
			eventosLista.add("Drogas");
			break;
		}
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		int eventoAleatorio = random.nextInt(0, evento.length);
		String eventoSeleccionado = eventosLista.get(eventoAleatorio);
		
		//switch del evento
		switch (eventoSeleccionado) {
		case "Bruja":
			eventoBruja(prota, random, sc);
			break;
			
		case "Maldición":
			eventoMaldicion(prota, random, sc);
			break;
			
		case "Trampa":
			eventoTrampa(prota, random, sc);
			break;
		
		case "Juan":
			eventoJuan(prota, random, sc);
			break;
			
		case "Perro":
			eventoPerro(prota, random, sc);
			break;
		
		case "Lamborgini":
			eventoLamborgini(prota, random, sc);
			break;
		
		case "Drogas":
			eventoDrogas(prota, sc);
			break;
			
		case "Puzzle":
			eventoPuzzle(random, sc, prota);
			break;
		case "Pelea Steve":
		{
			Combate combate = new Combate();
			if(combate.combate(sc, random, prota, "Steve", random.nextBoolean()))
			{
				calculoFinCombate(random, prota);
			}
			else
			{
				Juego.gameOver = true;
			}
			break;
		}
	
		default:
			System.out.println("ERROR EN LA SELECCIÓN EVENTO");
		}

		
	}
		
	//eventos
		// Métodos individuales para cada evento
		private void eventoBruja(Protagonista prota, Random random, Scanner sc) {
			String decision;
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
//						efecto = "Vida";
//						cantidad = "5";
						prota.setVida(prota.getVida()+5);
						puntuacion = 30;
					break;
					}
					case 1: {
						System.out.println("Te sientes muy afortunado, ganas 3 de suerte");
//						efecto = "Suerte";
//						cantidad = "3";
						prota.setSuerte(prota.getSuerte()+3);
						puntuacion = 30;
					break;
					}
					case 2: {
						System.out.println("Te sientes fortalecido, ganas 3 de ataque");
//						efecto = "Fuerza";
//						cantidad = "3";
						prota.setFuerza(prota.getFuerza()+3);
						puntuacion = 30;
					break;
					}
					case 3: {
						System.out.println("Sientes un pinchazo repentino, pierdes 3 de vida máxima");
//						efecto = "VidaMax";
//						cantidad = "-3";
						prota.setVidaMax(prota.getVidaMax()-3);
						puntuacion = -30;
					break;
					}
					case 4: {
						System.out.println("Te sientes muy pesado, pierdes 3 de velocidad");
//						efecto = "Velocidad";
//						cantidad = "-3";
						prota.setVelocidad(prota.getVelocidad()-3);
						puntuacion = -30;
					break;
					}
					case 5: {
						System.out.println("Te sientes debilitado, pierdes 2 de ataque");
//						efecto = "Fuerza";
//						cantidad = "-2";
						prota.setFuerza(prota.getFuerza()-2);
						puntuacion = -30;
					break;
					}
				}
				
				System.out.println("");
				System.out.println("La bruja se rie al verte tomar la pocion y se marcha lentamente");
				if (puntuacion <= 0) {
					System.out.println("Confundido por la situacion decides continuar tu aventura, perdiendo " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				}else System.out.println("Confundido por la situacion decides continuar tu aventura, ganando " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				
				System.out.println("Funciona? " + Juego.totalPuntuacion);
				Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
				//// FIN DEL EVENTO ////
			}
			if(decision.equalsIgnoreCase("No") || decision.equalsIgnoreCase("2")) {
				
				System.out.println("Rechazas la oferta y te marchas caminando pensando en si has tomado la decision correcta");
				//// FIN DEL EVENTO ////
				
			}
			return;
		}

		private void eventoMaldicion(Protagonista prota, Random random, Scanner sc) {
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
				suerteEvento += prota.getSuerte() / 2;
				
				if(suerteEvento < 8) 
				{
					totalMonedasConseguidas = random.nextInt(1, 15);
					prota.setMonedas(prota.getMonedas() + totalMonedasConseguidas);
				}
				else
				{
					totalMonedasConseguidas = random.nextInt(20, 35);
					prota.setMonedas(prota.getMonedas() + totalMonedasConseguidas);
				}
				
				if(totalMonedasConseguidas > 25)
				{
					System.out.println("¡Vaya suerte!");
					puntuacion = 50;
				}
				
				System.out.println("Dentro del cofre había un total de " + Juego.monedas(prota.getNombre(), totalMonedasConseguidas) + Color.YELLOW +
						(prota.getNombre().equals("Chicken Little") ? " semillas" : " esmeraldas") + Color.RESET);
				
				if(totalMonedasConseguidas <= 5)
				{
					System.out.println("Un desperdicio de tiempo.");
					puntuacion = -20;
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
				
				prota.setBadOmen(true);
				
				System.out.println("Asustado te marchas dejando la masacre atras");
				
				if (puntuacion <= 0) {
					System.out.println("Asustado te marchas dejando la masacre atras, perdiendo " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				}else System.out.println("Asustado te marchas dejando la masacre atras, ganando " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				
//				System.out.println("Funciona? " + Juego.totalPuntuacion);
				Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
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

		private void eventoTrampa(Protagonista prota, Random random, Scanner sc) {
			
			boolean trampa = random.nextBoolean();
			
			int dano = 0;
			int monedasPerdidas = 0;
			int velocidadExtra = 0;
			
			if(prota.getNombre().equals("Steve"))
			{
				velocidadExtra += 4; // solo se cambia dentro el método!! Un pequeño boost que no permanece fuera
			}
			
			if(trampa)
			{
				System.out.println("En tu camino te encuentras un estrecho pasaje");
				System.out.println("Al intentar pasar por el activas una trampa y varias flechas comienzan a dispararse desde las paredes en todas direcciones");
				System.out.println("");
				
				if(prota.getVelocidad() + velocidadExtra >= 8) {
					System.out.println("Rapidamente reaccionas al sonido del mecanismo y te apartas sin recibir daño");
					puntuacion = 50;
				}
				else if(prota.getVelocidad() + velocidadExtra >= 5 && prota.getVelocidad() < 8) {
					dano = random.nextInt(3,6);
					System.out.println("Consigues esquivar la mayoria de las flechas recibiendo " + Color.RED_BRIGHT + dano + 
							Color.RESET + " de daño");
					puntuacion = -10;
					}
				else if(prota.getVelocidad() + velocidadExtra < 5 && prota.getVelocidad() >= 2) {
					dano = random.nextInt(5,9);
					System.out.println("Consigues esquivar las flechas parcialmente recibiendo recibiendo " + Color.RED_BRIGHT + dano +
							Color.RESET + " de daño");
					puntuacion = -20;
					}
				else {
					dano = random.nextInt(8,11);
					System.out.println("Recibes las flechas de lleno " + Color.RED_BRIGHT + dano + Color.RESET + " de daño");
					puntuacion = -30;
				}
				
				if(prota.getVelocidad() + velocidadExtra >= 8)
				{
					System.out.println("Cuando las flechas dejaron de salir te levantaste  y continuaste con tu camino agredecido de seguir vivo");
				}
				else
				{
					System.out.println("Cuando las flechas dejaron de salir te levantaste rebisaste tus heridas y continuaste con tu camino agredecido de seguir vivo");
				}
				
				if(dano > 0)
				{
					dano -= (dano * (prota.getDefensa() / 2)) / 10; //defensa
					prota.setVida(prota.getVida() - dano);
				}
			}
			else
			{
				System.out.println("En tu camino te encuentras un estrecho pasaje");
				System.out.println("Al intentar pasar eres atacado por un grupo de saqueadores quienes van directamente a por tus esmeraldas");
				System.out.println("");
				
				if(prota.getVelocidad() + velocidadExtra >= 8) {
					System.out.println("Rapidamente reaccionas al sonido de los atacantes y sales corriendo");
					puntuacion = 50;
				}
				else if(prota.getVelocidad() + velocidadExtra >= 5) {
					monedasPerdidas = random.nextInt(3,6);
					System.out.println("Bloqueas gran parte de sus ataques pero consiguen robarte " + Color.RED_BRIGHT + prota.getMonedas() + Color.RESET + (prota.getNombre().equals("Chicken Little") ? " semillas" : " esmeraldas"));
					puntuacion = -10;
				}
				else if(prota.getVelocidad() + velocidadExtra < 5 && prota.getVelocidad() + velocidadExtra >= 2) {
					monedasPerdidas = random.nextInt(5,9);
					System.out.println("Esquivas parte de sus ataques pero consiguen robarte " + Color.RED_BRIGHT + prota.getMonedas() + Color.RESET + (prota.getNombre().equals("Chicken Little") ? " semillas" : " esmeraldas"));
					puntuacion = -20;
				}
				else {
					monedasPerdidas = random.nextInt(8,11);
					System.out.println("Los asaltantes te pillan desprevenido llevandose una gran parte de tu tesoro, pierdes " + Color.RED_BRIGHT + prota.getMonedas() + Color.RESET + (prota.getNombre().equals("Chicken Little") ? " semillas" : " esmeraldas"));
					puntuacion = -30;
				}
				
				if(prota.getVelocidad() + velocidadExtra >= 8)
				{
					System.out.println("Sigues corriendo dejando atras a los ladrones y continuas tu aventura");
				}
				else
				{
					System.out.println("Los ladrones se marchan satisfechos con su botin, decides marcharte y continuar tu aventura agradecido de al menos seguir vivo");
				}
				
				if(monedasPerdidas > 0)
				{
					if(prota.getMonedas() < monedasPerdidas)
					{
						prota.setMonedas(0);
					}
					else
					{
						prota.setMonedas(prota.getMonedas() - monedasPerdidas);
					}
				}
			}
			
//			System.out.println("Funciona? " + Juego.totalPuntuacion);
			Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
			
			if (puntuacion <= 0) {
				System.out.println("Pierdes " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " puntos por la experiencia");
			}else System.out.println("Ganas " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " puntos por la experiencia");
			
			return;
		}

		private void eventoJuan(Protagonista prota, Random random, Scanner sc) {
			String finalEncantamiento = "";
			String finalEncantamientoNivel = "";
			
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
						finalEncantamiento = encantamientosNivelesSeleccionados[0][0];
						finalEncantamientoNivel = encantamientosNivelesSeleccionados[0][1];
						prota.setVidaMax(prota.getVidaMax() - costeVidaArray[0]);
						break;
					}
					case "2":{
						finalEncantamiento = encantamientosNivelesSeleccionados[1][0];
						finalEncantamientoNivel = encantamientosNivelesSeleccionados[1][1];
						prota.setVidaMax(prota.getVidaMax() - costeVidaArray[1]);
						break;
					}
					case "3":{
						finalEncantamiento = encantamientosNivelesSeleccionados[2][0];
						finalEncantamientoNivel = encantamientosNivelesSeleccionados[2][1];
						prota.setVidaMax(prota.getVidaMax() - costeVidaArray[2]);
						break;
					}
					case "4":{
						finalEncantamiento = encantamientosNivelesSeleccionados[3][0];
						finalEncantamientoNivel = encantamientosNivelesSeleccionados[3][1];
						prota.setVidaMax(prota.getVidaMax() - costeVidaArray[3]);
						break;
					}
				}
				switch(finalEncantamiento)
				{
					case "Proteccion":
					{
						int defensaFinal = 0;
						switch(finalEncantamientoNivel)
						{
							case "I":
							{
								defensaFinal = 1;
								break;
							}
							case "II":
							{
								defensaFinal = 2;
								break;
							}
							case "III":
							{
								defensaFinal = 3;
								break;
							}
							case "IV":
							{
								defensaFinal = 4;
								break;
							}
							default:
							{
								System.out.println("Error en la selección del nivel de Protección");
							}
						}
						prota.setDefensa(prota.getDefensa() + defensaFinal);
						break;
					}
					case "Afilado":
					{
						int fuerzaFinal = 0;
						switch(finalEncantamientoNivel)
						{
							case "I":
							{
								fuerzaFinal = 1;
								break;
							}
							case "II":
							{
								fuerzaFinal = 2;
								break;
							}
							case "III":
							{
								fuerzaFinal = 3;
								break;
							}
							case "IV":
							{
								fuerzaFinal = 4;
								break;
							}
							default:
							{
								System.out.println("Error en la selección del nivel de Fuerza");
							}
						}
						prota.setFuerza(prota.getFuerza() + fuerzaFinal);
						break;
					}
					case "Espinas":
					{
						double espinasFinal = 0;
						switch(finalEncantamientoNivel)
						{
							case "I":
							{
								espinasFinal = 1.5;
								break;
							}
							case "II":
							{
								espinasFinal = 3;
								break;
							}
							case "III":
							{
								espinasFinal = 5;
								break;
							}
							default:
							{
							}
						}
						prota.setEspinas(prota.getEspinas() + espinasFinal);
						break;
					}
					case "Eficiencia":
					{
						int velocidadFinal = 0;
						switch(finalEncantamientoNivel)
						{
							case "I":
							{
								velocidadFinal = 1;
								break;
							}
							case "II":
							{
								velocidadFinal = 2;
								break;
							}
							case "III":
							{
								velocidadFinal = 3;
								break;
							}
							case "IV":
							{
								velocidadFinal = 4;
								break;
							}
							case "V":
							{
								velocidadFinal = 5;
								break;
							}
							default:
							{
								System.out.println("Error en la selección del nivel de Eficiencia");
							}
						}
						prota.setVelocidad(prota.getVelocidad() + velocidadFinal);
						break;
					}
					case "Fortuna":
					{
						int suerteFinal = 0;
						switch(finalEncantamientoNivel)
						{
							case "I":
							{
								suerteFinal = 1;
								break;
							}
							case "II":
							{
								suerteFinal = 2;
								break;
							}
							case "III":
							{
								suerteFinal = 3;
								break;
							}
							default:
							{
								System.out.println("Error en la selección del nivel de Eficiencia");
							}
						}
						prota.setSuerte(prota.getSuerte() + suerteFinal);
						break;
					}
					case "Recarga rapida":
					{
						prota.setRecargaRapida(true);
						break;
					}
				}
				
				System.out.println(Color.WHITE_BOLD_BRIGHT +"\"Perfecto ahora mismo realizo el encatamiento de " + Color.CYAN_UNDERLINED + Color.CYAN_BOLD_BRIGHT + finalEncantamiento + " " + finalEncantamientoNivel + Color.RESET + " espero que difrutes de tu eleccion\"-dijo alegremente" + Color.RESET);
				System.out.println("");
				System.out.println(Color.WHITE_BOLD_BRIGHT +"\"Espero que disfrutes de tu aventura buen viaje\"-dijo mientras te despedia levantando una pezuña" + Color.RESET);
				
				puntuacion = 100;
//				System.out.println("Funciona? " + Juego.totalPuntuacion);
				Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
				System.out.println("\nReconfortado por la experiencia obtienes " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " puntos");
			}
			else {
				System.out.println("Decides no darle mas importancia y pasas de largo.");
				System.out.println("");
				System.out.println("En poco tiempo ya has dejado atras el campamento aunque jurarias poder escucha sonidos de caballo en la distancia.");
				
				puntuacion = -100;
//				System.out.println("Funciona? " + Juego.totalPuntuacion);
				Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
				System.out.println("\nLa sensacion de arrepentimiento te hace perder " + Color.BLACK_BOLD_BRIGHT + puntuacion + Color.RESET + " puntos");
				
				//// LA LISTA ESTA VACIA ASI QUE DEVUELVE UNA VACIA ////
			}
			
			return;
		}
		

		private void eventoPerro(Protagonista prota, Random random, Scanner sc) {
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
					
						prota.setNiebla(true);
						
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
							Juego.finalHuirPerroSteve = true;
							Juego.gameOver = true;
						}
					break;
				}
				
				case "2": { 
					
					randomGenio = random.nextInt(0,11); // niebla siempre es verdadero, y las otras 3 opciones son random
					
					numerin = random.nextInt(nombresGonzalo.length);
					
					if(randomGenio >= 6) {
						System.out.println("\"¡Felicidades! Has obtenido 3 puntos de fuerza. ¡Sigue así, tu progreso es impresionante!\"-dijo entusiasmado");
						System.out.println("Gracias a " + Color.GREEN_BOLD_BRIGHT + "Gonzalo " + nombresGonzalo[numerin] + Color.RESET +  "ahora te sientes mas poderoso aunque tambien la gran pena de no poder ver mas a Niebla");
						
						prota.setFuerza(prota.getFuerza()+3);
						puntuacion = 200;
						
					} else System.out.println("\"Lamentablemente, no puedo conceder ese deseo en este momento. Sin embargo, siempre estaré aquí para ayudarte en lo que necesites. ¡Sigue adelante!\"-dijo alegre");
					break;
				}
				case "3": { 
					
					randomGenio = random.nextInt(0,11);
					
					numerin = random.nextInt(nombresGonzalo.length);
					
					if(randomGenio >= 7) {
						prota.setMonedas(prota.getMonedas()+30);
						System.out.println("\"¡Enhorabuena! Has obtenido " + Juego.monedas(prota.getNombre(), 30) + Color.YELLOW + (prota.getNombre().equals("Chicken Little") ? " semillas" : " esmeraldas") + Color.RESET + ". ¡Tu tesoro crece y tu aventura continúa!\"-dijo entusiasmado");
						System.out.println("Gracias a " + Color.GREEN_BOLD_BRIGHT + "Gonzalo " + nombresGonzalo[numerin] + Color.RESET +  "ahora te sientes mas rico aunque tambien la gran pena de no poder ver mas a Niebla");
						
						puntuacion = 200;
					} else System.out.println("\"Lamentablemente, no puedo conceder ese deseo en este momento. Sin embargo, siempre estaré aquí para ayudarte en lo que necesites. ¡Sigue adelante!\"-dijo alegre");
					break;
				}
				case "4": { 
					
					randomGenio = random.nextInt(0,11);
					
					numerin = random.nextInt(nombresGonzalo.length);
					
					if(randomGenio >= 8) {
						prota.setVidaMax(prota.getVidaMax()+10);
						System.out.println("\"¡Excelente! Has obtenido 10 puntos de vida máxima. ¡Tu fuerza y resistencia aumentan! ¡Sigue avanzando con más energía!\"-dijo entusiasmado");
						System.out.println("Gracias a " + Color.GREEN_BOLD_BRIGHT + "Gonzalo " + nombresGonzalo[numerin] + Color.RESET +  "ahora te sientes mas resisitente, aunque tambien la gran pena de no poder ver mas a Niebla");
						
						puntuacion = 200;
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
				
				if (puntuacion >= 0) {
					System.out.println("\nAlegre decides continuar tu aventura, ganando " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				}
				
			}
			
			else
			{
				System.out.println("Te marchas esquivando la urna cuidadosamente.");
				System.out.println("Al rato ya dejas la urna atras y conforme te alejas te invade el arrepentimiento por no descubrir que hay en la urna.");
			}
			return;
		}

		private void eventoLamborgini(Protagonista prota, Random random, Scanner sc) {
			
			String decision;
			int objetosAComprar = 3;
			
			boolean salir = false;
			
			System.out.println("En tu camino te encuentras un Mercader errante.");
			System.out.println("");
			System.out.println("\"Ven pequeño amigo, mira los bienes que ofrezco amigo\"");
			System.out.println("");
			System.out.println("Te acercas tentado por la amabilidad del vendedor");
			System.out.println("Ves un monton de vienes variados y extraños");
			
			while(salir == false && prota.getVida() > 0)
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
					if(prota.getMonedas() >= 5 && objetosAComprar > 0) {
						prota.setMonedas(prota.getMonedas()-5);
						objetosAComprar--;
						prota.setVida(prota.getVida()-5);
					System.out.println("Te comes la Comida sospechosa");
					System.out.println("Parece que te cuesta digerirlo \r\n" + "  -5 de vida \r\n" 
									   +  "   +5 de vida \r\n" + "Aunque te da una indigestion y pierdes -5 de vida");
					puntuacion = -69;
					}
					else
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
					if(prota.getMonedas() >= 5 && objetosAComprar > 0) {
						prota.setMonedas(prota.getMonedas()-5);
						objetosAComprar--;
						prota.setDefensa(prota.getDefensa()-2);
					System.out.println("Te pones la Armadura de dudosa calidad");
					System.out.println("Te pones la armadura encima y de alguna forma esta parece hacerte mas debil");
					System.out.println("   -2 de armadura");
					
					puntuacion = -69;
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
					if(prota.getMonedas() >= 50 && objetosAComprar > 0) {
						prota.setMonedas(prota.getMonedas()-50);
						objetosAComprar--;
						prota.setVelocidad(prota.getVelocidad()+4);
						Juego.hasLambo = true;
					System.out.println("El aldeano saca un motherfucking lamborgini de su bolsillo dejandote asombrado.");
					System.out.println("Sin dudarlo te subes al lamborgini, sintiendote mas rapido que nadie");
					System.out.println("   +4 de velocidad");
					
					puntuacion = 200;
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
					if(prota.getMonedas() >= 5 && objetosAComprar > 0) {
						prota.setMonedas(prota.getMonedas()-5);
						objetosAComprar--;
						prota.setFuerza(prota.getFuerza()-1);
					System.out.println("Te pones el Protector para picos 3000, se siente muy extraño.");
					System.out.println("   +99 de fuerza \r\n" + "   -100 de fuerza");
					System.out.println("");
					
					puntuacion = -69;
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
				System.out.println("Funciona? " + Juego.totalPuntuacion);
				Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
				
				if (puntuacion <= 0) {
					System.out.println("Confundido por la situacion decides continuar tu aventura, perdiendo " + Color.BLACK_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				}else System.out.println("Con tu MOTHERFUCKING LAMBORGINI te sientes imparable ganando" + Color.YELLOW_BOLD_BRIGHT + "∞" + Color.RESET + " puntos (O tal vez " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + ") por la experiencia");
				
			}
				
			return;
		}

		private void eventoDrogas(Protagonista prota, Scanner sc) {
			
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
				System.out.println(Color.PURPLE + "Vida: "  + Color.RED_BRIGHT + prota.getVida()/0.69 + "/" + prota.getVidaMax());
				System.out.println(Color.YELLOW + "Defensa: "  + Color.GREEN_BRIGHT +  prota.getDefensa()/0.69);
				System.out.println(Color.CYAN + "Fuerza: " + Color.PURPLE + prota.getFuerza()/0.69);
				System.out.println(Color.RED_BRIGHT + "Velocidad: " + Color.BLUE + prota.getVelocidad()/0.69);
				System.out.println("!PUNTUACION HA AUMENTADO A " + Color.YELLOW_BOLD_BRIGHT + "9999999999" + Color.RED_BOLD + "9" + Color.YELLOW_BOLD_BRIGHT + "99999999999999999999¡");
				System.out.println(prota.getNombre() + " se encuentra a Barbie Playera y a Buzz Lightyear, los cuales estaban tomandose un martini juntos en la playa");
				System.out.println("Pronto después llega Freddy Fazbear y se une a la fiesta");
				System.out.println("Sin embargo, " + prota.getNombre() + " no se encuentra muy bien...");
				System.out.println(prota.getNombre() + " se desmaya en frente de" + Color.GREEN_BOLD_BRIGHT + "Buzz Lightyear, " + Color.PURPLE_BOLD_BRIGHT + "Barbie Playera " + Color.RESET + "y" + Color.YELLOW_BOLD + "Freddy Fazbear!" + Color.RESET);
				
				puntuacion = 1000;
				System.out.println("Funciona? " + Juego.totalPuntuacion);
				Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
				
				Juego.gameOver = true;
				Juego.finalDrogasChickenLittle = true;
			}			
			
			return;
		}

		private void eventoDescripcionObjetosTienda(){
			System.out.println("Poción de vida = Te cura 10 puntos. Una ganga, ¿verdad? Y es barato, cómpralo, je, je.\r\n");

	        System.out.println("Poción de fuerza = Cuando estés en pelea, tus golpes aumentan un 4 de daño."
	                			+ " Solo se puede usar cada 5 encuentros. Oye, no me mires a así, ¡yo no escribí las reglas!\r\n");

	        System.out.println("Kit de cuero = Aumenta tu defensa a 1. Te protege poco, ¿por qué crees que es tan barato?"
	                			+ "Piensa que es la versión humilde de los ´kit´.\r\n");

	        System.out.println("Kit de hierro = Aumenta tu defensa a 2. Te protege más que el de cuero, ¡considera comprarlo! Je, je, je\r\n");

	        System.out.println("Kit de diamante = Aumenta tu defensa a 3. Es considerable y te hará ver ¡d-i-v-i-n-o!\r\n");

	        System.out.println("Kit de netherita = Aumenta tu defensa a 4. Es la mejor armadura, ¡te invito a comprarla! Je, je, je\r\n");

	        System.out.println("Tótem de inmortalidad = Cura el 50% de tu vida y te revive si mueres en combate. ¡Un artefacto muy útil!"
	                			+ "No te vendría mal comprarlo, ¿Verdad\r\n");

	        System.out.println("Ender Pearl = Huyes del combate. Perfecto si estás a 1 de vida, no tienes pociones para curarte, "
	                			+ "ni tampoco el Tótem de inmortalidad, aunque te recomiendo comprar todo *giño**giño*\r\n");
		}

		
		public void eventoMercader(Protagonista prota, Scanner sc, Random random){
			boolean puedeLigar = false;
			boolean haLigado = false;
			
			if(prota.getFuerza()>=5)
			{
				puedeLigar = true;
			}
			boolean generoAldeano = random.nextBoolean(); // false == chico, true == chica
			
	        System.out.println("Entras a la tienda.");
	        System.out.println("*suena DELTARUNE OST - Rouxls Kaard Shop Hip Shop*");

	        if(generoAldeano)
	        {
	        	System.out.println("Una aldeana te recibe.\r\n");
	        }
	        else
	        {
	        	System.out.println("Un aldeano te recibe.\r\n");
	        }
	        
	        // Mensaje de bienvenida.
	        System.out.println("¡Bienvenido, cliente! Compra todo lo que quieras. Gasta todas tus" + (prota.getNombre().equals("Chicken Little") ? " semillas " :  " esmeraldas ") + "si quieres, je, je.\r\n");
	        
	        // Definición de los productos disponibles en la tienda.
	        String nombreArmadura = "";
	        int costeArmadura = 0;
	        
	        // Descripción de los productos.
	        System.out.println("¿Quieres una descripción de todos mis objetos? —Dijo " + (generoAldeano ? "la aldeana" : "el aldeano"));
	        System.out.println("1 = Sí, 2 = No");
	        
	        String respuesta = sc.nextLine();
	        if(respuesta.equals("1") || respuesta.equalsIgnoreCase("si"))
	        {
	        	System.out.println("Aquí tienes una descripción de todos mis objetos —Dijo " + (generoAldeano ? "la aldeana" : " el aldeano"));
	        	eventoDescripcionObjetosTienda();
	        }
	        else
	        {
	        	System.out.println("Genial, vamos a comprar... —Dijo " + (generoAldeano ? "la aldeana" : " el aldeano"));
	        }
	        
	        String opcionesTienda = ""; // Variable para almacenar la opción de compra seleccionada.
	        int comprasRestantes = 3; // máximo de compras por tienda


	        while (!opcionesTienda.equals("6") && comprasRestantes > 0)
	        {
	        	switch(prota.comprobarArmadura())
	            {
	            	case "":
	            	{
	            		nombreArmadura = "Armadura de cuero";
	            		costeArmadura = 2;
	            		break;
	            	}
	            	case "Armadura de cuero":
	            	{
	            		nombreArmadura = "Armadura de hierro";
	            		costeArmadura = 4;
	            		break;
	            	}
	            	case "Armadura de hierro":
	            	{
	            		nombreArmadura = "Armadura de diamante";
	            		costeArmadura = 8;
	            		break;
	            	}
	            	case "Armadura de diamante":
	            	{
	            		nombreArmadura = "Armadura de netherite";
	            		costeArmadura = 16;
	            		break;
	            	}
	            	default:
	            	{
	            		nombreArmadura = prota.getNombre() + " ya posee todas las armaduras";
	            		costeArmadura = 9999;
	            		break;
	            	}
	            }
	        	
	        	String tiendaEsmeraldas[] = {"Poción de vida ("+ Juego.monedas(prota.getNombre(), 5) + ")", "Poción de fuerza ("+ Juego.monedas(prota.getNombre(), 7) + ")",
	            		nombreArmadura + " (" + Juego.monedas(prota.getNombre(), costeArmadura) + ")", "Tótem de inmortalidad ("+ Juego.monedas(prota.getNombre(), 30) + ")", 
	            		"Ender Pearl ("+ Juego.monedas(prota.getNombre(), 20) + ")"}; // Opciones y contenido
	        	
	        	for (int i = 0; i < tiendaEsmeraldas.length; i++)
	    		{
	    			System.out.println((i + 1) + " = " + tiendaEsmeraldas[i]);
	    		}
	        	System.out.println("6 = Salir");
	        	
	        	if(prota.getNombre().equals("Alex") && generoAldeano)
	        	{
	        		System.out.println("7 = Ligar...");
	        	}
	        	System.out.println("");
	        	
	        	System.out.println("Tienes " + Color.YELLOW_BRIGHT + Juego.monedas(prota.getNombre(), prota.getMonedas()) + (prota.getNombre().equals("Chicken Little") ? " semillas " :  " esmeraldas ") + Color.RESET +  "y puedes comprar " + comprasRestantes +" objetos más\r\n");
	        	
	        	opcionesTienda = sc.nextLine(); // Leer la opción seleccionada por el jugador.

	            String objetoComprado = ""; // Variable que almacena el objeto comprado.
	            int costeObjeto = 0;
	            
	            switch(opcionesTienda)
	            {
	            	case "1":
	            	{
	            		objetoComprado = "Pocion de vida";
	            		costeObjeto = 5;
	            		break;
	            	}
	            	case "2":
	            	{
	            		objetoComprado = "Pocion de fuerza";
	            		costeObjeto = 7;
	            		break;
	            	}
	            	case "3":
	            	{
	            		objetoComprado = "Armadura";
	            		costeObjeto = costeArmadura;
	            		break;
	            	}
	            	case "4":
	            	{
	            		objetoComprado = "Totem de inmortalidad";
	            		costeObjeto = 30;
	            		break;
	            	}
	            	case "5":
	            	{
	            		objetoComprado = "Ender pearl";
	            		costeObjeto = 20;
	            		break;
	            	}
	            	case "7":
	            	{
	            		if(prota.getNombre().equals("Alex") && generoAldeano)
	            		{
	            			System.out.println(prota.getNombre() + " decide ligar con la aldeana...");
	            			System.out.println("La aldeana parece interesada...");
	            			if(!puedeLigar)
	            			{
	            				System.out.println("Pero acaba rechazando a " + prota.getNombre() + ", ya que no parece que tiene suficiente " + Color.CYAN + "fuerza" + Color.RESET + "...");
	            			}
	            			else
	            			{
	            				System.out.println("La aldeana liga con " + prota.getNombre() + " también!");
	            				haLigado = true;
	            			}
	            		}
	            		else
	            		{
	            			System.out.println("Opción no válida. Elige una opción del 1 al 6.");
	            		}
	            		break;
	            	}
	            	default:
	            	{
	            		if(!opcionesTienda.equals("6"))
	            		{
	            			System.out.println("Opción no válida. Elige una opción del 1 al 6.");
	            		}
	            	}
	            }
	            
	            if(!opcionesTienda.equals("6"))
	            {
	            	if(prota.getMonedas() >= costeObjeto && comprasRestantes > 0)
	        		{
	        			prota.setMonedas(prota.getMonedas()-costeObjeto);
	        			switch(objetoComprado)
	        			{
	        				case "Pocion de vida":
	        				{
	        					prota.anadirObjeto("Pocion de vida");
	        					System.out.println(prota.getNombre() + " ahora tiene " + prota.recorrerListaObjetos("Pocion de vida") + " pociones de vida.");
	        					break;
	        				}
	        				case "Pocion de fuerza":
	        				{
	        					prota.setTurnosPocionFuerza(5);
	        					prota.anadirObjeto("Pocion de fuerza");
	        					System.out.println(prota.getNombre() + " ahora tiene " + prota.recorrerListaObjetos("Pocion de fuerza") + " pociones de fuerza.");
	        					break;
	        				}
	        				case "Armadura":
	        				{
	        					switch(prota.comprobarArmadura())
	        					{
	        						case "":
	        						{
	        							prota.anadirArmadura("Armadura de cuero");
	        							System.out.println(prota.getNombre() + " ahora tiene una armadura de cuero.");
	        							prota.setDefensa(prota.getDefensa() + 1);
	        							break;
	        						}
	        						case "Armadura de cuero":
	        						{
	        							prota.anadirArmadura("Armadura de hierro");
	    	        					prota.eliminarObjeto("Armadura de cuero");
	        							System.out.println(prota.getNombre() + " ahora tiene una armadura de hierro.");
	        							prota.setDefensa(prota.getDefensa() + 1);
	        							break;
	        						}
	        						case "Armadura de hierro":
	        						{
	        							prota.anadirArmadura("Armadura de diamante");
	    	        					prota.eliminarObjeto("Armadura de hierro");
	        							System.out.println(prota.getNombre() + " ahora tiene una armadura de diamante.");
	        							prota.setDefensa(prota.getDefensa() + 1);
	        							break;
	        						}
	        						case "Armadura de diamante":
	        						{
	        							prota.anadirArmadura("Armadura de netherite");
	    	        					prota.eliminarObjeto("Armadura de diamante");
	        							System.out.println(prota.getNombre() + " ahora tiene una armadura de netherite.");
	        							prota.setDefensa(prota.getDefensa() + 1);
	        							break;
	        						}
	        						default:
	        						{
	        							System.out.println("Error en la selección de armadura");
	        						}
	        					}
	        					switch(prota.comprobarArmadura())
	        		            {
	        		            	case "":
	        		            	{
	        		            		nombreArmadura = "Armadura de cuero";
	        		            		costeArmadura = 2;
	        		            		break;
	        		            	}
	        		            	case "Armadura de cuero":
	        		            	{
	        		            		nombreArmadura = "Armadura de hierro";
	        		            		costeArmadura = 4;
	        		            		break;
	        		            	}
	        		            	case "Armadura de hierro":
	        		            	{
	        		            		nombreArmadura = "Armadura de diamante";
	        		            		costeArmadura = 8;
	        		            		break;
	        		            	}
	        		            	case "Armadura de diamante":
	        		            	{
	        		            		nombreArmadura = "Armadura de netherite";
	        		            		costeArmadura = 16;
	        		            		break;
	        		            	}
	        		            	default:
	        		            	{
	        		            		nombreArmadura = prota.getNombre() + " ya posee todas las armaduras";
	        		            		costeArmadura = 9999;
	        		            		break;
	        		            	}
	        		            }
	        					break;
	        				}
	        				case "Totem de inmortalidad":
	        				{
	        					prota.anadirObjeto("Totem de inmortalidad");
	        					System.out.println(prota.getNombre() + " ahora tiene " + prota.recorrerListaObjetos("Totem de inmortalidad") + " totemes de inmortalidad.");
	        					break;
	        				}
	        				case "Ender pearl":
	        				{
	        					prota.anadirObjeto("Ender pearl");
	        					System.out.println(prota.getNombre() + " ahora tiene " + prota.recorrerListaObjetos("Ender pearl") + " ender pearls.");
	        					break;
	        				}
	        			}
	        			if(opcionesTienda.equals("1") || opcionesTienda.equals("2") ||opcionesTienda.equals("3") ||opcionesTienda.equals("4") ||opcionesTienda.equals("5"))
	        			{
	        				System.out.println("Gracias por su compra!\r\n");
	        				comprasRestantes--;
	        			}
	        		}
	        		else
	        		{
	        			if(comprasRestantes <= 0)
	        			{
	        				System.out.println("Ya has comprado todas mis pertenencias! —Le dijo " + (generoAldeano ? "la aldeana" : " el aldeano") + " a " + prota.getNombre());
	        			}
	        			else
	        			{
	        				System.out.println("No tienes suficiente dinero, ponte a chambear —Le dijo furiosamente " + (generoAldeano ? "la aldeana" : "el aldeano") + " a " + prota.getNombre());
	        			}
	        		}
	            }
	        }
	        if(comprasRestantes == 0) {
	        	System.out.println("\"Has completado tu cupo de compras diario, vuelve otro dia por mas\"-dijo amablemante " + (generoAldeano ? "la aldeana" : "el aldeano"));
	        	
	        	}
	        if(haLigado)
	        {
	        	System.out.println("Espera un momento! -Dice la aldeana");
	        	System.out.println(prota.getNombre() + " se da la vuelta...");
	        	Juego.gameOver = true;
	        	Juego.finalLigarAlex = true;
	        }
	        else
	        {
	        	System.out.println("Hasta pronto!\r\n");
	        	System.out.println("Con esto te marchas con ganas de volver para poder probar los otros objetos de la tienda");
	        }
		}
		
		private void eventoPuzzle(Random random, Scanner sc, Protagonista prota) {
	        int puzzleAleatorio = random.nextInt(1, 6);
		    
	        //Eventos
	        switch(puzzleAleatorio) {// coge un puzzle aleatorio
	                
	                //Piedra, Papel y Tigera
	                case 1: {
	                    puzzlePiedraPapelTijera(prota, random, sc);
	                    break;
	                }
	                //Lamparas
	                case 2: {
	                        
	                    puzzleLamparas(random, sc, prota);
	                    break;
	                }
	                //Adivinanza
	                case 3: {
	                    puzzleAdivinanza(random, sc, prota);
	                    break;
	                }
	                //Adivinanza
	                case 4: {
	                    puzzleTrivia(random, sc, prota);
	                    break;
	                }
	                //Opinión
	                case 5: {
	                    puzzleOpinion(random, sc, prota);
	                    break;
	                }
	                    
	            }
		}

		//Puzzle
		public void puzzlePiedraPapelTijera(Protagonista prota, Random random, Scanner sc){
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
				
				System.out.println("    1.Piedra | 2.Papel | 3.Tijera ");
				
				decisionPlayer = sc.nextLine();
				
				while (!decisionPlayer.equals("1") && !decisionPlayer.equals("2") && !decisionPlayer.equals("3")) {

					System.out.println("\"Ser de conocimiento escaso, introduce, 1, 2 o 3\"-dijo");
					decisionPlayer = sc.nextLine();
				}
				
				String[] ppt = {"¡Piedra!", "¡Papel!", "¡Tijera!"}; 
				int decisionPlayerI = Integer.valueOf(decisionPlayer);
				
				decisionEnemigo = random.nextInt(1,4);
				
				
				switch(decisionPlayerI - decisionEnemigo)/*hemos descubierto que si restas las decisiones, 
				siendo piedra 0, papel 1, y tijera 2, la respuesta numérica nos dice quien ha ganado*/
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
					prota.setSuerte(prota.getSuerte()+3);
					System.out.println("Te sientes afortunado... +3 de " + Color.YELLOW + "suerte" + Color.RESET + "!");
					
					puntuacion = 200;
					System.out.println("Funciona? " + Juego.totalPuntuacion);
					Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
					System.out.println("Complacido con el resultado, ganas " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
					
				}
				if(derrota == 3) {
					System.out.println("\"Desaparece de mi vista, aburrido infeliz\"-dice claramente decepcionado");
					System.out.println("");
					
					puntuacion = -50;
					System.out.println("Funciona? " + Juego.totalPuntuacion);
					Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
					System.out.println("Avergonzado con el resultado, pierdes " + Color.BLACK_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				}
				
			}
		}
		
		public void puzzleLamparas(Random random, Scanner sc, Protagonista prota){
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
				
				prota.setMonedas(prota.getMonedas()+15);
//				finalArray[0][0] = "Monedas";
//				finalArray[0][1] = "15";
				
				puntuacion = 200;
//				System.out.println("Funciona? " + Juego.totalPuntuacion);
				Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
				System.out.println("Complacido con el resultado, ganas " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
			
			}
			
			if(turnos == 0 && aciertos != 4) {
				System.out.println("Las luces se apagan repetinamente al acabarse tus turnos restantes.");
				System.out.println("Entristecido te marchas con las manos vacias.");
				
				puntuacion = -50;
//				System.out.println("Funciona? " + Juego.totalPuntuacion);
				Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
				System.out.println("Frustrado con el resultado, pierdes " + Color.BLACK_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
			}
		}
		System.out.println("");
		System.out.println("Guardas tu botin y continuas tu aventura felizmente");
			
		}
		
		public void puzzleAdivinanza(Random random, Scanner sc, Protagonista prota){
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
		            String decisionString = sc.nextLine(); 
		            System.out.println("Ser de inteligencia deficiente, tu respuesta " + decisionString + " no es suficiente.");
		        }
				
				double numeroGracioso = random.nextDouble(0, 1);
				if(decisionDouble == numeroGracioso)
				{
					acierto = true;
					
					System.out.println("La caja emite una pequeña musica");
					System.out.println(Color.CYAN_BRIGHT + "¡FELICIDADES HAS ADIVINADO EL NUMERO DE LA SUERTE SUPREMA!-dice la voz" + Color.RESET);
					System.out.println("A partir de ahora tendras todo lo que necesites");
				}
				
				int resultadoReal = random.nextInt(0,2);/*También puede ganar si su número es exactamente 0 o 1, porque 
				nextInt(0, 2) genera 0 o 1).*/
				if(decisionDouble == resultadoReal)
				{
					acierto = true;
					
					System.out.println("\"Adivinaza adivinada, la puerta ya no esta sellada\"-dijo la voz");
					System.out.println(Color.CYAN_BRIGHT + "¡CLing!¡Clang!" + Color.RESET);
					System.out.println("La enorme puerta se abre ante ti, pasas aliviado de poder escapar finalmente.");
					System.out.println("Esta experiencia expande tus conocimientos ganando " + Color.YELLOW_BRIGHT + "2 de velocidad" + Color.RESET);
					
					prota.setVelocidad(prota.getVelocidad()+2);
					
					puntuacion = 200;
//					System.out.println("Funciona? " + Juego.totalPuntuacion);
					Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
					System.out.println("Complacido con el resultado, ganas " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				}
				if(turnos == 0 && acierto != true) {
					
					System.out.println("\"La prueba no ha sido superda\"-dijo la voz");
					System.out.println("\"Para por la puerta pasar, "  + Color.RED_BOLD + Juego.monedas(prota.getNombre(), 10) + " esmeraldas deberas pagar\"-dijo la puerta" + Color.RESET);
					System.out.println("");
					
					prota.setMonedas(prota.getMonedas()-10);
					
					puntuacion = -50;
//					System.out.println("Funciona? " + Juego.totalPuntuacion);
					Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
					System.out.println("Confundido con el resultado, pierdes " + Color.BLACK_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				}
			}
			
			System.out.println("");
			System.out.println("Atraviesas la puerta y continuas con tu aventura");
			
			sc.nextLine();
			
		}
		
		public void puzzleTrivia(Random random, Scanner sc, Protagonista prota){
			//// VARIABLES ////
			String decision;
			int aciertos = 0;
			int errores = 0;
					
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
				ASCII.printAscii(11);
				
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
							prota.setMonedas(prota.getMonedas()+10);
						break;
						
						case 2:
							System.out.println("Recibes una" + Color.YELLOW_BOLD + " pocion de Vida " + Color.RESET + "del ajolote");
							
							prota.anadirObjeto("Pocion de vida");
						break;
						
						case 3:
							System.out.println("Recibes una" + Color.YELLOW_BOLD + " pocion de Fuerza " + Color.RESET + "del ajolote");
							
							prota.anadirObjeto("Pocion de fuerza");
						break;
						
						case 4:
							System.out.println("Recibes" + Color.BLUE_BOLD +" armadura" + Color.RESET);
							
							prota.setDefensa(prota.getDefensa()+1);
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
								
							prota.setVida(prota.getVida()-10);
						break;
							
						case 2:
							System.out.println("El ajolote te roba " + Color.RED_BOLD + Juego.monedas(prota.getNombre(), 10) + (prota.getNombre().equals("Chicken Little") ? " semillas" : " esmeraldas") + Color.RESET);
								
							prota.setMonedas(prota.getMonedas()-10);
						break;
						
						case 3:
							System.out.println("Recibes la maldicion del" + Color.BLACK_BOLD + " mal presagio " + Color.RESET);
							
							prota.setBadOmen(true);
						break;
							
						case 4:
							System.out.println("Tu armadura" + Color.RED_BOLD + " pierde porder " + Color.RESET);
							
							prota.setDefensa(prota.getDefensa()-1);
						}
					}
				System.out.println("");
				
				
				
			}
			//// VICTORIA ////
			if(aciertos >= 3) {
				if(errores > 0) {
					System.out.println("\"Felicidades viajero has logrado pasar la prueba con " + errores + " errores\"-dijo alegre");
					
					puntuacion = 100;
//					System.out.println("Funciona? " + Juego.totalPuntuacion);
					Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
					System.out.println("Complacido con el resultado, ganas " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				}
				if(errores == 0) {
					System.out.println("\"Felicidades viajero has logrado pasar la prueba sin cometer ningun error como recompensa te dare parte de mi poder\"-dijo el ajolote entusiasmado \r\n");
					System.out.println("Te sientes mas fuerte, tu vida maxima aumenta 10 puntos");
					
					prota.setVidaMax(prota.getVidaMax()+10);
					
					puntuacion = 300;
//					System.out.println("Funciona? " + Juego.totalPuntuacion);
					Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
					System.out.println("Extremadamente complacido con el resultado, ganas " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				}
			}
			
			//// DERROTA ////
			if(aciertos < 3) {
				if(aciertos > 0) {
					System.out.println(Color.RED_BRIGHT + "\"No has superado la prueba " + Color.RESET + "viajero, puedes pasar aunque con un castigo\"-dijo aburrido \r\n");
					System.out.println("Te sientes mas debil, pierdes 5 de vida maxima");
					
					prota.setVidaMax(prota.getVidaMax()-5);
					
					puntuacion = -50;
//					System.out.println("Funciona? " + Juego.totalPuntuacion);
					Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
					System.out.println("Avergonzado con el resultado, ganas " + Color.BLACK_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				}
				if(aciertos == 0) {
					System.out.println("\"Por lo que veo ni siquiera lo has intentado, vaya perdida de tiempo, continua con tu aventura desgraciado\"-dijo el ajolote completamente decepcionado \r\n");
					System.out.println("Humillado sientes como parte de tu fuerza escapa de tu cuerpo, pierdes 10 de vida maxima");
					
					prota.setVidaMax(prota.getVidaMax()-10);
					
					puntuacion = -150;
//					System.out.println("Funciona? " + Juego.totalPuntuacion);
					Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
					System.out.println("Pierdes " + Color.BLACK_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
				}
			}	
			
		}
		
		public void puzzleOpinion(Random random, Scanner sc, Protagonista prota){
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
						
						puntuacion = 50;
//						System.out.println("Funciona? " + Juego.totalPuntuacion);
						Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
						System.out.println("Ganas " + Color.YELLOW_BOLD + puntuacion + Color.RESET + " por la experiencia");
						
						break;	
					}
					case 6,7: {
						System.out.println("\"Bueno no es un 10 pero me hace feliz que lo disfrutes\"-dijo sonriente \r\n");
						System.out.println("\"Espero que tengas una gran suerte en tu aventura\"-dijo sonriente");
						System.out.println("");
						System.out.println("Te sientes complacido por estas palabras, tu suerte aumenta en 2 \r\n");
						
						prota.setSuerte(prota.getSuerte()+2);
						
						puntuacion = 100;
//						System.out.println("Funciona? " + Juego.totalPuntuacion);
						Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
						System.out.println("Ganas " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
						
						fin = true;
						break;
					}
					case 8,9,10: {
						System.out.println("\"¡Oh en serio! Me alegro de que los estes disfrutando\"-dijo alegre \r\n");
						System.out.println("\"Una verdadera pena que tengas que partir, aunque te llevas mi bendicion para que sigas disfrutando de tu aventura");
						System.out.println("");
						System.out.println("Te sientes altamente compalacido por las palabras del anciano, tu suerte aumenta en 2 y tu vida maxima en 5 \r\n");
						
						prota.setSuerte(prota.getSuerte()+2);
						prota.setVidaMax(prota.getVidaMax()+5);
						
						puntuacion = 500;
//						System.out.println("Funciona? " + Juego.totalPuntuacion);
						Juego.totalPuntuacion = Juego.totalPuntuacion + puntuacion;
						System.out.println("Ganas " + Color.YELLOW_BOLD_BRIGHT + puntuacion + Color.RESET + " por la experiencia");
						fin = true;
					}
				}
				
				if(opinionElegida > 5) { System.out.println("\nContinuas con tu aventura despues de este gratificante evento, dejando atras la roca del anciano"); }
				if(opinionElegida == 5) { System.out.println("\nContinuas con tu aventura despues de este extraño evento, dejando atras la roca del anciano"); }
					
				}
			}
			
			if(decision.equalsIgnoreCase("Rechazarle") || decision.equalsIgnoreCase("2")) {
				System.out.println("Rechazas la oferta del anciano, quien se queda muy desilusionado, y decides continuar con tu camino");
				System.out.println("Al rato ya has perdido de vista la roca del anciano");
				
				//// FINALIZA EL PUZZLE ////
			}
}
		
		private void calculoFinCombate(Random random, Protagonista prota)
		{
			if(!prota.getHaHuido() && prota.getVida() > 0)
			{
				prota.setHaMatado(true);
				int randomVidaAtaque = random.nextInt(1, 11);
				if(randomVidaAtaque <= 4)
				{
					prota.setVidaMax(prota.getVidaMax() + prota.getNumEnemigos());
					prota.setVida(prota.getVida() + prota.getNumEnemigos());
					System.out.println(prota.getNombre() + " consigue " + prota.getNumEnemigos() + " puntos de vida máxima tras el combate!\r\n");
				}
				else if(randomVidaAtaque > 4 && randomVidaAtaque <= 8)
				{
					prota.setFuerza(prota.getFuerza() + (double) (prota.getNumEnemigos()) / 2);
					System.out.println(prota.getNombre() + " consigue " + (double) (prota.getNumEnemigos()) / 2 + " puntos de fuerza tras el combate!\r\n");
				}
				else
				{
					prota.setVidaMax(prota.getVidaMax() + prota.getNumEnemigos() / 2);
					prota.setVida(prota.getVida() + prota.getNumEnemigos() / 2);
					prota.setFuerza(prota.getFuerza() + (double) (prota.getNumEnemigos()) / 4);
					System.out.println(prota.getNombre() + " consigue " + (double) (prota.getNumEnemigos()) / 2 + " puntos de vida máxima y " + (double) (prota.getNumEnemigos()) / 4 + " puntos de fuerza tras el combate! Qué suerte!\r\n");
				}
				
				int randomMonedas = random.nextInt(1, 11);
				randomMonedas += prota.getSuerte() /2;
				if(randomMonedas <= 2)
				{
					System.out.println(prota.getNombre() + Color.RED_BRIGHT + " no ha encontrado" + Color.RESET + " ninguna " + Color.YELLOW + (prota.getNombre().equals("Chicken Little") ? " semilla " : " esmeralda ") + Color.RESET + "tras el combate\r\n");
				}
				else if(randomMonedas > 2 && randomMonedas <= 8)
				{
					prota.setMonedas(prota.getMonedas() + prota.getNumEnemigos());
					System.out.println(prota.getNombre() + " consigue " + Juego.monedas(prota.getNombre(), prota.getNumEnemigos()) + (prota.getNombre().equals("Chicken Little") ? " semillas " : " esmeraldas ") + "tras el combate\r\n");
				}
				else
				{
					System.out.println("¡" + Color.RED_BRIGHT + "S" + Color.YELLOW_BRIGHT + "U" + Color.GREEN_BRIGHT + "E" + Color.BLUE_BRIGHT + "R" + Color.PURPLE_BRIGHT + "T" + Color.CYAN_BRIGHT + "E" + Color.RESET + "!");
					prota.setMonedas(prota.getMonedas() + prota.getNumEnemigos() * 3);
					System.out.println(prota.getNombre() + " consigue " + Juego.monedas(prota.getNombre(), prota.getNumEnemigos() * 3) + (prota.getNombre().equals("Chicken Little") ? " semillas " : " esmeraldas ") + "tras el combate\r\n");
				}
			}
		}
}