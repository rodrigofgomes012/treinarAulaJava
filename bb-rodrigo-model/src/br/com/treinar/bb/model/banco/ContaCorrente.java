package br.com.treinar.bb.model.banco;

import br.com.treinar.bb.model.tipodado.TipoCliente;

public class ContaCorrente extends Conta implements IProdutoPagavel {

	private double va1orPagar;
	private double limiteCredito;
	private double limiteCreditoAtual;

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public double getLimiteCreditoAtual() {
		return limiteCreditoAtual;
	}

	public void setLimiteCreditoAtual(double limiteCreditoAtual) {
		this.limiteCreditoAtual = limiteCreditoAtual;
	}
	
	@Override
	public double getValorPagar() {
		return this.va1orPagar;
	}

	@Override
	public void setValorPagar(double valorPagar) {
		this.va1orPagar = valorPagar;
	}


	@Override
	public void sacar(double valor) throws SaldoInsuficienteException {
		
		if (valor <= super.getSaldo() + this.limiteCreditoAtual) {
			if (valor <= super.getSaldo()) {
				super.setSaldo(super.getSaldo() - valor);
			} else {
				limiteCreditoAtual = limiteCreditoAtual - (valor - super.getSaldo());
				super.setSaldo(0);
			}
		} 
	}
	
	@Override
	public double consultarSaldo() {
		double saldoAtual = super.consultarSaldo();
		return saldoAtual + this.limiteCreditoAtual;
	}
	
	@Override
	public void depositar(double valorDeposito) {
		double valorDevido = this.limiteCredito - this.limiteCreditoAtual;
		if (super.getCliente().getTipoCliente().equals(TipoCliente.ESPECIAL)) {
		 	valorDeposito =+ 1.0; //clientes especiais ganham R$ 1 real ao depositar;
		}
		if (valorDevido == 0) {
			super.setSaldo(super.getSaldo() + valorDeposito);
		} else {
			if (valorDeposito > valorDevido) {
				this.limiteCreditoAtual += valorDevido;
				super.setSaldo(valorDeposito - valorDevido);
			} else {
				this.limiteCreditoAtual += valorDeposito;				
			}
		}
	}

	
	@Override
	public void pagarValorMensalidade() {
		try {
			super.sacar(this.va1orPagar);
		} catch (SaldoInsuficienteException e) {
			System.out.println("Saldo Insuficiente !");
		}
						
		//TODO - apos tres meses sem pagar cancela a conta
	}

	@Override
	public String toString() {
		return  super.toString() + " " + "ContaCorrente [va1orPagar=" + va1orPagar + ", limiteCredito=" + limiteCredito + ", limiteCreditoAtual="
				+ limiteCreditoAtual + "]";
	}
	
}
