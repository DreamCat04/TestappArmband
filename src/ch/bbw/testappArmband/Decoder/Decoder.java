package ch.bbw.testappArmband.Decoder;

import java.util.Scanner;

public class Decoder {
	public Decoder() {
		String out = "";
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Geben Sie hier ihren Code ein: ");
		out = keyboard.next();
		System.out.println(out);
	}
}
