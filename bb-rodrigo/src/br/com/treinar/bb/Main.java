package br.com.treinar.bb;

import java.util.Scanner;

import br.com.treinar.bb.model.Conta;

public class Main {

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int opcao;
		
		do {
			
			imprimirMenu(); //Alt shift M transforma algo em um metodo;
			opcao = input.nextInt();		
				
			switch (opcao) {
			case 1:
				criarConta();
				
				break;
			case 2:
				System.out.println("DEPOSITAR");//TODO - DEPOSITAR
				
				break;
			case 3:
				System.out.println("SACAR");//TODO - SACAR CONTA
				
				break;
	
			case 0:
				System.out.println("VALEU");
				
				break;
			default:
				
				System.out.println("OPÇÃO INVÁLIDA DIGITE NOVAMENTE");
				break;
		}
			
		} while (opcao != 0);
		System.out.println("good-by ");
		
		input.close();
	}

	private static void criarConta() {
		Conta c = new Conta();
		System.out.println("Informe o numero da conta: ");
		
	}

	private static void imprimirMenu() {
		System.out.print(""
				+ "Informe a opção:\n"
				+ "\t0 - Sair\n"
				+ "\t1 - Criar Conta \\n"
				+ "\t\n=> "
		);
	}

}
