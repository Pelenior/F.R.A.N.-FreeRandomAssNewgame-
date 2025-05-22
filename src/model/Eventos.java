package model;

import java.util.Random;

public class Eventos {
	
	private static String [] evento = {"Bruja", "Maldición", "Trampa", "Juan", "Perro", "Lamborgini", "Drogas", "Puzzle"};
	
	//función selecionar eventos
	//poner metodo público, que escoje un evento aleatorio y llama la función de ese evento
	public static void elegirEvento (Protagonista prota) {
		Random random = new Random();
		
		
		int eventoAleatorio = random.nextInt(0, evento.length);
		
		//switch del evento
		switch (evento) {
		case "Bruja":
			break;
			
		case "Maldición":
			break;
			
		case "Trampa":
			break;
		
		case "Juan":	
			break;
			
		case "Perro":
			break;
		
		case "Lamborgini":
			break;
		
		case "Drogas":
			break;
			
		case "Puzzle":
			break;
	
		default:
		}
	
		
	}
	//eventos
	
	
	

}
