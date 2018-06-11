package br.com.treinar.bb.controller;

import java.util.Scanner;

import br.com.treinar.bb.model.Conta;

public class BancoController {
	private Conta conta;
	Scanner input = new Scanner(System.in);
	
	public void criarConta(int numConta, String nomeCliente, String cPF, double limiteCredito) {
		
		Conta conta = new Conta(numConta, nomeCliente, cPF, limiteCredito);
			
		System.out.println("\nConta: " + numConta
				+"\nNome do Cliente : " + nomeCliente
				+"\nCPF: " + cPF
				+ "\nLimite de Credito: " + limiteCredito);
		
	}
	
	public boolean checaDados(int numConta, String nomeCliente, String cPF){
		Boolean dados = true;
		return dados;
	}
	
	public void depositarConta(int numConta, String nomeCliente, String cPF) {
		
		System.out.println("Informe o valor do depósito :");
		double valorDeposito = input.nextDouble();
		conta.depositarSaldo(valorDeposito);
		
	}
	public void sacarConta() {
				
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}


}
