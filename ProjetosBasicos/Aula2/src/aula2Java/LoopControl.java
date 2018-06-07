package aula2Java;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class LoopControl {
	public static void main(String[] args) {
		int cont = 0;
		
		System.out.println("\nwhile");
		while (cont<10) {
			System.out.println(++cont);
			
		}
		System.out.println("\ndo while");
		do {
			System.out.println(cont--);
			
		} while (cont > 0);
//		Ctrl + shift + c
		System.out.println("\n for");
		for (int i = 0; i <=10; i++) {
			System.out.println(i);
					
		}
		
	} 

}
