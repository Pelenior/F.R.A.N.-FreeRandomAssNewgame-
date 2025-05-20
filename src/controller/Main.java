package controller;

public class Main {

	public static void main(String[] args) {
		    
		        String[] memeLyrics = {
		            "whenImetUinthesuma",
		            "andIheldyourhandintheheatajune",
		            "wewaitedforthesumma",
		            "itfeltliketheperfectdream",
		            "burninskinfromthesunbeams",
		            "wewereyoungandwildandfree",
		            "uandmeinmidjuly",
		            "icecreamdrippinonmysneaks",
		            "dancinundertheskyblu",
		            "sunscreamonmycheek",
		            "poolsidevibesandbeats",
		            "lostinbeatsandsunsetfeels",
		            "smilesalloveru",
		            "grillitupatthaparkbbqstyle",
		            "uweremyfavsummathing",
		            "flipflopsandsandytoes",
		            "wheniturnedandlookedu",
		            "everythingwasgolden",
		            "chillinwitmysunnieson",
		            "candyshopintheheatscene",
		            "windowsdownmusicloud",
		            "chasinlightinourhearts",
		            "neonsunsetkissintide",
		            "uandmedoinnothin",
		            "evrydaywasajunesong",
		            "wefellinluvinsumma",
		            "whenyoulaughinechoinside",
		            "beachwavesinurhair",
		            "sippinonlemondreamz",
		            "nobodycouldstopus",
		            "thiswasourgoldenszn",
		            "skateridesandbubblegum",
		            "sundazeandbarefeet",
		            "midnightswimsandgiggles",
		            "summawaslitcuzofu"
		        };

		        for (String line : memeLyrics) {
		            System.out.println(line);
		            try {
		                Thread.sleep(3000); // Espera 3 segundos entre frases
		            } catch (InterruptedException e) {
		                System.err.println("Interrupción durante el delay.");
		            }
		        }

	}

}
