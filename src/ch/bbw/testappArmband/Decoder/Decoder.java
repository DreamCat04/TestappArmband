package ch.bbw.testappArmband.Decoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Decoder {
	// The decoder should decode all the code blocks
	public Decoder() { //Constructor
		HashMap<String, String> festivalNames = new HashMap<String, String>();
		HashMap persons = new HashMap<>();
		HashMap <String, String> days = new HashMap<String, String>();
		HashMap<Integer, String> zones = new HashMap<Integer, String>();
		
		festivalNames.put("FO", "Frauenfeld Openair");
		festivalNames.put("SO", "St.Gallen Openair");
		festivalNames.put("OG", "Openair Gampel");
		festivalNames.put("OZ", "Openair Zürich");
		
		days.put("1", "Donnerstag");
		days.put("2", "Freitag");
		days.put("3", "Do & Fr");
		days.put("4", "Samstag");
		days.put("5", "Do & Sa");
		days.put("6", "Fr & Sa");
		days.put("7", "Do & Sa");
		days.put("8", "Sonntag");
		days.put("9", "Do & So");
		days.put("A", "Fr & So");
		days.put("B", "Do, Fr, So");
		days.put("C", "Sa & So");
		days.put("D", "Do, Sa, So");
		days.put("E", "Fr - So");
		days.put("F", "Alle Tage");
		
		
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Geben Sie hier ihren Code ein: ");
		String code = keyboard.next();
		if(code.length() != 18) {
			System.out.println("Sie haben einen ungültigen Code eingeben.");
		} else {
		String[] splitCode = code.split("-");
		String location = splitCode[0].substring(0, 2);
		int year = Integer.parseInt(splitCode[0].substring(2,4));
		//Hexadecimal to decimal
		int id = Integer.parseInt(splitCode[1], 16);
		String dates = splitCode[2];
		String binaryZone = splitCode[3];

		
		}
	}
	
}
