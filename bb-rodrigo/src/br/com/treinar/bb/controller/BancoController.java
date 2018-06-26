package br.com.treinar.bb.controller;

import br.com.treinar.bb.model.banco.Banco;
import br.com.treinar.bb.model.banco.Conta;
import br.com.treinar.bb.model.banco.ContaPoupanca;
import br.com.treinar.bb.model.banco.IProdutoPagavel;

public class BancoController {

	private int posicao;
	private Banco banco;
	
	public BancoController() {
		posicao = 0;
		banco = new Banco();
		Conta[] contas = new Conta[2];
		banco.setContas(contas);
	}

	public Conta[] recuperarContas() {
		return banco.getContas();
	}
	
	public void criarConta(Conta conta) {
		if (posicao < banco.getContas().length) {
			this.banco.getContas()[posicao++] = conta;			
		}
	}

	public void depositar(double valor, int posicao) {
		banco.getContas()[posicao].depositar(valor);
	}

	public double recuperarSaldo(int posicao) {
		return banco.getContas()[posicao].consultarSaldo();
	}
	
	public boolean sacar(double valor, int posicao) {
		return banco.getContas()[posicao].sacar(valor);
	}

	public void alterarTaxaRendimento(float novaTaxa) {
		ContaPoupanca.setTaxaRendimento(novaTaxa);
	}

	public float recuperarTaxaRendimento() {
		return ContaPoupanca.getTaxaRendimento();
	}

	public void cobrarMensalidade() {
		Conta[] contas = banco.getContas();
		for (int i = 0; i < contas.length; i++) {
			if (contas[i] instanceof IProdutoPagavel) {
				((IProdutoPagavel) contas[i]).pagarValorMensalidade();			
			}
		}
		
	}

	public int pesquisarConta(int numeroConta) {
		int posicao = -1;
		Conta[] contas = banco.getContas();
		for (int i = 0; i < contas.length; i++) {
			if (contas[i] != null && contas[i].getNumero() == numeroConta) {
				return posicao = i;
			}
		}
		return posicao;
	}

	public void deletarContas(int posicao) {
		Conta[] contas = banco.getContas();
		
		if (contas.length == posicao) {
			contas[posicao] = null;
		}else {
			for (int i = posicao; i < contas.length-1; i++) {
				contas[i] = contas[i+1];
			}
		}
						
		this.posicao--;
	}

}
