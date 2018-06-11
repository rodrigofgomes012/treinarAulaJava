package br.com.treinar.bb.model;

import br.com.treinar.bb.model.Cliente;

public class Conta {
	private int numConta;
	private double saldo;
	public Cliente cliente;
	private double limiteCredito;
	
	public Conta(int numConta, String nomeCliente, String cPF) {
		this.numConta = numConta;
		Cliente cliente = new Cliente();
		cliente.nome = nomeCliente;
		cliente.cpf = cPF;
	}
	
	public Conta(int numConta, String nomeCliente, String cPF, double limiteCredito) {
		this(numConta, nomeCliente, cPF);
		this.limiteCredito = limiteCredito;
		
	}
	
	public double consultarSaldo() {
		return saldo;	
	}

	public void depositarSaldo(double valorDeposito) {
	this.saldo += valorDeposito;
	
	}
	
	public boolean sacar(double valorSaque) { // Alt shift R troca o nome da variavel
		boolean deuParaSacar = false;
		if (valorSaque <= saldo) {
			saldo -= valorSaque;
			deuParaSacar = true;
		}
		return deuParaSacar;
		
	}
	
		
	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}


}
