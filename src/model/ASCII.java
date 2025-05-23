package model;

public class ASCII {

		
	
		
		//metodo para imprimir el ascii elegido
		//segun int imprime un ascii
		public static void printAscii(int ascii) {
			
			switch(ascii) {
				case 0: {																								
					System.out.println(  Color.BLUE_BOLD_BRIGHT + "██████████████████████████████████████████████████████████████████████████████████████████████" + Color.YELLOW_BRIGHT + "▓▒▒▒▒▒▒▒▓"  + Color.BLUE_BOLD_BRIGHT + "██████████████████████████████████████████████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "█████████████████████████████████████████████████████████████████████████████████████████████" + Color.YELLOW_BRIGHT + "▓▒▒▓▓▒▓▓▒▒▓"  + Color.BLUE_BOLD_BRIGHT + "█████████████████████████████████████████████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "█████████████████████████████████████████████████████████████████████████████████████████████" + Color.YELLOW_BRIGHT + "▓▒▒▒▓▓▓▒▒▒▓"  + Color.BLUE_BOLD_BRIGHT + "█████████████████████████████████████████████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "█████████████████████████████████████████████████████████████████████████████████████████████" + Color.YELLOW_BRIGHT + "▓▒▒▒▒▒▒▒▒▒▓"  + Color.BLUE_BOLD_BRIGHT + "█████████████████████████████████████████████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "█████████████████████████████████████████████████████████████████████████████████████████████" + Color.YELLOW_BRIGHT + "▓▒▒▒▓"  + Color.BLUE_BOLD_BRIGHT + "█" + Color.YELLOW_BRIGHT + "▓▒▒▒▓"  + Color.BLUE_BOLD_BRIGHT + "█████████████████████████████████████████████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "█████████████████████████████████████████████████████████████████████████████████████████████" + Color.YELLOW_BRIGHT + "▓▒▒▓"  + Color.BLUE_BOLD_BRIGHT + "███" + Color.YELLOW_BRIGHT + "▓▒▒▓"  + Color.BLUE_BOLD_BRIGHT + "█████████████████████████████████████████████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "████████████████████████████████████████████████████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▓▒▒▓" + Color.BLUE_BOLD_BRIGHT + "██" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▓▒▒▒▒▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▒▒▒▒▓▒▒▒▒▒▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "███████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "███████████████████████████████████████████████████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▓"  + Color.BLUE_BOLD_BRIGHT + "██" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▒▓▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▓▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▓▓▒▓▓▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "██████████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "██████████████████████████████████████████████████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▒▒▓▓▒▒▒▒▒▓▓▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▓"  + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▓" + Color.BLUE_BOLD_BRIGHT + "██" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▓▓▒▒▓" + Color.BLUE_BOLD_BRIGHT + "██" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█████████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "██████████████████████████████████████████████████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▒▓▓▒▒▒▓▓▒▒▒▒▓▓▒▒▒▒▒▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "███" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▒▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "██" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "████████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "█████████████████████████████████████████████████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▓▒▒▒▓▒▒▒▒▓▓▒▒▒▒▓▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "████████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "██████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓▓▒▒▒▓▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "███████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "████████████████████████████████████████████████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▓▒▒▒▒▓▓▒▒▓" + Color.BLUE_BOLD_BRIGHT + "███" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▓▓▒▒▒▒▒▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▒▒▒▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "██" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▓▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "█████" + Color.WHITE_BOLD_BRIGHT + "▓▒▒▒▓" + Color.BLUE_BOLD_BRIGHT + "██████████████████████████████████████████████████████████████\r\n"
							+ Color.BLUE_BOLD_BRIGHT +  "█████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████\r\n"
							+ Color.GREEN_BOLD_BRIGHT + "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
							+ Color.YELLOW_BOLD +       "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒" + Color.BLACK_BRIGHT + "▓▒▒▒▒▓▒▒▓▓▒▓▒▓▒▒▒▓" + Color.YELLOW_BOLD + "▒▒" + Color.BLACK_BRIGHT + "▓▒▒▓▒▒▒▓▒▒▒▓▒▒▓▓▒▓▒▓" + Color.YELLOW_BOLD + "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
							+ Color.YELLOW_BOLD +       "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒" + Color.BLACK_BRIGHT + "▓▒▒▓▓▒▓▒▓▒▒▒▓▒▒▓" + Color.YELLOW_BOLD + "▒▒" + Color.BLACK_BRIGHT + "▓▒▒▓█▓▒▓▓▒▒▒▓▒▓▒▓▓▒▓" + Color.YELLOW_BOLD + "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n"
							+ Color.YELLOW_BOLD +       "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\r\n" + Color.RESET);
					break;
				}
				case 1: {																								
					System.out.println(Color.YELLOW + "\r\n▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\r\n" + Color.RESET   
        					+ Color.YELLOW + "▓▓" + Color.RESET + Color.BLACK_BRIGHT + "▒" + Color.RESET + " 1- " + Color.BLUE_BRIGHT +  "Steve    " + Color.RESET + Color.BLACK_BRIGHT + "  ▒" + Color.RESET + " 2- " + Color.GREEN_BRIGHT + "Alex     " + Color.RESET + Color.BLACK_BRIGHT + "  ▒" + Color.RESET + " 3- " + Color.YELLOW + "Chicken Little" + Color.RESET + Color.BLACK_BRIGHT + "▒" + Color.RESET  + Color.YELLOW + "▓▓" + Color.RESET + "\r\n"
        					+ Color.YELLOW + "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓" + Color.BLACK_BRIGHT +"▓▓▓▓" + Color.YELLOW +"▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\r\n" + Color.RESET 
        					+ Color.YELLOW + "▓▓" + Color.RESET + Color.BLACK_BRIGHT + "▒" + Color.RESET + " Vida= " + Color.GREEN + 20 + Color.RESET + Color.BLACK_BRIGHT + "      ▒" + Color.RESET + " Vida= " + Color.GREEN + 30 + Color.RESET + Color.BLACK_BRIGHT + "      ▒" + Color.RESET + " Vida= " + Color.GREEN + 15 + Color.RESET + Color.BLACK_BRIGHT + "         ▒" + Color.RESET + Color.YELLOW + "▓▓" + Color.RESET + "\r\n"
        					+ Color.YELLOW + "▓▓" + Color.RESET + Color.BLACK_BRIGHT + "▒" + Color.RESET + " Fuerza= " + Color.PURPLE + 1 + Color.RESET + Color.BLACK_BRIGHT + "     ▒" + Color.RESET + " Fuerza= " + Color.PURPLE + 0 + Color.RESET + Color.BLACK_BRIGHT + "     ▒" + Color.RESET + " Fuerza= " + Color.PURPLE + 0 + Color.RESET + Color.BLACK_BRIGHT + "        ▒" + Color.RESET + Color.YELLOW + "▓▓" + Color.RESET + "\r\n"
        					+ Color.YELLOW + "▓▓" + Color.RESET + Color.BLACK_BRIGHT + "▒" + Color.RESET + " Armadura= " + Color.BLUE + 0 + Color.RESET + Color.BLACK_BRIGHT + "   ▒" + Color.RESET + " Armadura= " + Color.BLUE + 0 + Color.RESET + Color.BLACK_BRIGHT + "   ▒" + Color.RESET + " Armadura= " + Color.BLUE + 0 + Color.RESET + Color.BLACK_BRIGHT + "      ▒" + Color.RESET + Color.YELLOW + "▓▓" + Color.RESET + "\r\n" 
        					+ Color.YELLOW + "▓▓" + Color.RESET + Color.BLACK_BRIGHT + "▒" + Color.RESET + " Agilidad= " + Color.YELLOW_BRIGHT + 3 + Color.RESET + Color.BLACK_BRIGHT + "   ▒" + Color.RESET + " Agilidad= " + Color.YELLOW_BRIGHT + 1 + Color.RESET + Color.BLACK_BRIGHT + "   ▒" + Color.RESET +" Agilidad= " + Color.YELLOW_BRIGHT + 3.5 + Color.RESET + Color.BLACK_BRIGHT + "    ▒" + Color.RESET + Color.YELLOW + "▓▓" + Color.RESET + "\r\n"
        					+ Color.YELLOW + "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\r\n" + Color.WHITE_BOLD_BRIGHT);
					break;
				}
				//Steve
				case 2: {
					System.out.println(
			                  "    ████████████████████████████████████████  \r\n"
			                + "    ████████████████████████████████████████  \r\n"
			                + "    ████████████████████████████████████████  \r\n"
			                + "    ████████████████████████████████████████  \r\n"
			                + "    ███▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒███  \r\n"
			                + "    ███▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒███  \r\n"
			                + "    ██▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒██  \r\n"
			                + "    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░  \r\n"
			                + "    ░░░░░░░░░▒▒▒▓▓▓░░░░░░░░░░▓▓▓▒▒▒░░░░░░░░░  \r\n"
			                + "    ░░░░░░░░░▒▒▒▓▓▓░░░░░░░░░░▓▓▓▒▒▒░░░░░░░░░  \r\n"
			                + "    ░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░▒▒▒  \r\n"
			                + "    ▒▒▒░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░▒▒▒  \r\n"
			                + "    ▒▒▒░░░░░░▓▓▓▓▓▓░░░░░░░░░░▓▓▓▓▓▓░░░░░░▒▒▒  \r\n"
			                + "    ▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒  \r\n"
			                + "    ▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒  \r\n"
			                + "    ▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒  \r\n");
					break;
				}
				//Alex
				case 3: {
					System.out.println(   "    ████████████████████████████████████████     \r\n"
				                        + "    ████████████████████████████████████████     \r\n"
				                        + "    ████████████████████████████████████████     \r\n"
				                        + "    ████████████████████████████████████████     \r\n"
				                        + "    ███████████████████░░░░░░░░░████████████     \r\n"
				                        + "    ███████████████████░░░░░░░░░████████████     \r\n"
				                        + "    ███████████████░░░░░░░░░░░░░░░░█████████     \r\n"
				                        + "    ███████████████░░░░░░░░░░░░░░░░█████████     \r\n"
				                        + "    ░░░░░░░░░▒▒▒▓▓▓░░░░░░░░░░▓▓▓▒▒▒░░░░░░░░░     \r\n"
				                        + "    ░░░░░░░░░▒▒▒▓▓▓░░░░░░░░░░▓▓▓▒▒▒░░░░░░░░░     \r\n"
				                        + "    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n"
				                        + "    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n"
				                        + "    ░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░     \r\n"
				                        + "    ░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░     \r\n"
				                        + "    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n"
				                        + "    ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n");
					break;
				}
				//Pollo
				case 4: {
					System.out.println(   "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░     \r\n"
				                        + "     ░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░     \r\n"
				                        + "     ░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░     \r\n"
				                        + "     ░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░     \r\n"
				                        + "     ░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░     \r\n"
				                        + "     ████████████████████████████████████████     \r\n"
				                        + "     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓     \r\n"
				                        + "     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓     \r\n"
				                        + "     ████████████████████████████████████████     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒     \r\n");
					break;
				}
				//Zombie
				case 5: {
					System.out.println(   "     ████████████████████████████████████████     \r\n"
				                        + "     ████████████████████████████████████████     \r\n"
				                        + "     ███████████████░░░░░░░░░░░░░░░██████████     \r\n"
				                        + "     █████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n"
				                        + "     █████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n"
				                        + "     ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n"
				                        + "     ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n"
				                        + "     ░░░░░░░▓▓▓▓▓▓▓▓░░░░░░░░░░▓▓▓▓▓▓▓▓░░░░░░░     \r\n"
				                        + "     ░░░░░░░▓▓▓▓▓▓▓▓░░░░░░░░░░▓▓▓▓▓▓▓▓░░░░░░░     \r\n"
				                        + "     ░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░     \r\n"
				                        + "     ░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░     \r\n"
				                        + "     ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒     \r\n");
					break;
				}
				//Esqueleto
				case 6: {
					System.out.println(   "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n"
				                        + "     ▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n"
				                        + "     ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n"
				                        + "     ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░     \r\n"
				                        + "     ░░░░░░░▓▓▓▓▓▓▓▓░░░░░░░░░░▓▓▓▓▓▓▓▓░░░░░░░     \r\n"
				                        + "     ░░░░░░░▓▓▓▓▓▓▓▓░░░░░░░░░░▓▓▓▓▓▓▓▓░░░░░░░     \r\n"
				                        + "     ░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░     \r\n"
				                        + "     ▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒     \r\n");
					break;
				}
				//Creeper
				case 7: {
					System.out.println(   "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▒▒▒▒▒▓▓▓▓▓▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░▒▒▒▒▒▒▒▒▒▒     \r\n"
				                        + "     ▒▒▒▒▒▒▒▒▒▒░░░░░▒▒▒▒▒▒▒▒▒▒░░░░░▒▒▒▒▒▒▒▒▒▒     \r\n");
					break;
				}
				case 8: {
					
				}
				case 9: {
					
				}
				case 10: {
					
				}

			
			}
		}


}
