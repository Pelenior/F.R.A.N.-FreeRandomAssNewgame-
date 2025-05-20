package model;

import java.util.Random;

public class Eventos {
	
	private String [] evento = {"Bruja", "Maldición", "Trampa", "Juan", "Perro", "Lamborgini", "Drogas", "Puzzle"};
	
	//función selecionar eventos
	//poner metodo público, que escoje un evento aleatorio y llama la función de ese evento
	public void elegirEvento (String[]evento) {
		Random random = new Random();
		
		int eventoAleatorio = random.nextInt(0, evento.length);
		
		//switch del evento
	}
	//eventos
	
	
	

}
