package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Caminos {
	public static String seleccionCaminos(Random random, Scanner scanner, String[] listaEventos, String nombrePersonaje){
		// Para seleccionar caminos, creamos una Lista de Strings. Añadímos el nombre de un evento random
		// Al mismo tiempo, tenemos una Lista int que añadimos numeros que sirven para comprobar
		// si la selección del usuario existe la podemos coger desde la primera Lista
		
		int numeroCaminos = random.nextInt(2, 5);//caminos del 2-4
		int eventoRandom = 0;
		int contadorOpciones = 1;
		
		List<String> listaOpcionesPosibles = new ArrayList<String>();//Dentro de la lista van a ser String
		
		List<String> caminosDisponibles = new ArrayList<String>();
		
		while(numeroCaminos > 0)
		{
			eventoRandom = random.nextInt(listaEventos.length);//el eventoRandom es aleatorio de la lista eventos
			// Lista con String del nombre del evento
			caminosDisponibles.add(listaEventos[eventoRandom]);//de los caminos disponibles ocurre un evento aleatorio de lista eventos
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
			for(int i = 0; i < caminosDisponibles.size(); i++)//añadir sin que tener que editar
			{
				System.out.println((i+1) + ". " + caminosDisponibles.get(i));//imprime el camino escojido
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
			if(!seleccionCorrecta)//si la opcion no es correcta
			{
				System.out.println(nombrePersonaje + " no parece muy decidido...");
				System.out.println("(Escoge con números)\r\n");
			}
		}
		
		// Guardamos el nombre de selección elegida en String
		String seleccionStr = (String) caminosDisponibles.get(Integer.valueOf(seleccionCamino) - 1);
		
		return seleccionStr;
	}
}
