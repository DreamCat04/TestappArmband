package ch.bbw.testappArmband.Decoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Decoder {
    // The decoder should decode all the code blocks
    public Decoder() {
        // These HashMaps are used for decoding
        HashMap<String, String> festivalNames = new HashMap<String, String>();
        HashMap<String, String> days = new HashMap<String, String>();
        HashMap<Integer, String> zones = new HashMap<Integer, String>();

        //In a real case scenario we would use a  of this HashMap
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
        String[] splitCode = code.split("-");

        //Validation of the Bar-code
        //Error message 1
        if (code.length() != 18) {
            System.out.println("Sie haben einen ungültigen Code eingeben.");
            System.exit(1);
        } else {
            //Error message 2
            if (! "FOSGZ".contains(splitCode[0].substring(0,2))) {
                System.out.println("Sie haben einen ungültigen Code eingeben.");
                System.exit(1);

            }
            //Error message 3
            if (!splitCode[0].substring(2, 4).matches("(.*[0-9].*)")) {
                System.out.println("Sie haben eine ungültige Jahreszahl angegeben.");
                System.exit(1);

            }
            //Error message 4
            if (splitCode[1].matches("(.*[G-Z].*)")) {
                System.out.println("Sie haben eine nicht existente ID eigegeben.");
                System.exit(1);

            }
            //Error message 5
            if (splitCode[2].matches("(.*[G-Z].*)")) {
                System.out.println("Sie haben eine ungültiges Datum angegeben.");
                System.exit(1);

            }
            //Error message 6
            if (splitCode[3].matches("(.*[A-Z].*)") || splitCode[3].matches("(.*[2-9].*)")) {
                System.out.println("Sie haben ungültige Zonen eingegeben.");
				System.exit(1);
            }
        }
        String location = festivalNames.get(splitCode[0].substring(0, 2));
        int year = 2000 + Integer.parseInt(splitCode[0].substring(2, 4));
        //Hexadecimal to decimal
        int id = Integer.parseInt(splitCode[1], 16);
        String dates = days.get(splitCode[2]);
        StringBuffer Zones = new StringBuffer();

        //Decoding the zone
        if (splitCode[3].charAt(0) == '1') {
            Zones.append("A");
        }
        if (splitCode[3].charAt(1) == '1') {
            Zones.append("B");
        }
        if (splitCode[3].charAt(2) == '1') {
            Zones.append("C");
        }
        if (splitCode[3].charAt(3) == '1') {
            Zones.append("D");
        }
        if (splitCode[3].charAt(4) == '1') {
            Zones.append("E");
        }

        System.out.println("Name der Veranstaltung:		" + location);
        System.out.println("Das Veranstaltungsjahr:		" + year);
        System.out.println("Die Kundennummer:			" + id);
        System.out.println("Die Tage der Gültigkeit:	" + dates);
        System.out.println("Die gebuchten Zonen:		" + Zones);


    }

}