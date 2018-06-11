package br.com.treinar.bb.view;

import java.util.Scanner;

import br.com.treinar.bb.controller.BancoController;

public class TelaCadastroBB {
	
	private Scanner input;
	private int numConta;
	private String nomeCliente;
	private double limiteCredito;
	private String cPF;
	
	BancoController controle = new BancoController();
		
	public TelaCadastroBB () {
		input = new Scanner(System.in);
			
	}
	
	public void iniciarOperacao() {
		int opcao = 0;
		do {
			imprimirMenu();
			opcao = input.nextInt();
			switch (opcao) {
			
			case 0:
				
				System.out.println("Valeu !");
				
				break;
			
			case 1:
				capturaDados();
				System.out.println("Informe o limite de crédito :");
				double limiteCredito = input.nextDouble();
				controle.criarConta(numConta, nomeCliente, cPF, limiteCredito);
				System.out.println("Conta Criada !");
				
				break;
				
			case 2:
				capturaDados();
				controle.depositarConta(numConta, nomeCliente);
				System.out.println("Depósito Realizado !");
								
				break;
				
			case 3:
				capturaDados();
				controle.sacarConta(numConta, nomeCliente, cPF);
				System.out.println("Saque Realizado !");
				
				break;

			default:
				System.out.println("Opção incorreta: Escolha uma opção Valida");
				break;
			}
			
		} while (opcao != 0 );
		
	}

	private void imprimirMenu() {
		System.out.println("\n\t Informe a opção:\n"
				+"\t0 - Sair\n"
				+"\t1 - Criar Conta\n"
				+"\t2 - Depositar\n"
				+"\t3 - Sacar");
		
	}
	
	public void capturaDados() {
		
		System.out.println("Informe um número para Conta :");
		this.numConta = input.nextInt();
		
		System.out.println("Informe o nome do cliente :");
		this.nomeCliente = input.next();
				
		System.out.println("Informe o CPF: ");
		this.cPF = input.next();
				
	}
	
}
