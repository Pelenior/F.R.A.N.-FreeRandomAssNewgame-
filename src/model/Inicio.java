package model;

import java.util.Scanner;

public class Inicio {
	
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
		System.out.println(Color.GREEN_BRIGHT + "CONTRASEÑA ACEPTADA" + Color.RESET);
	}
	
}
