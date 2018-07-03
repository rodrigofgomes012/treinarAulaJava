package br.com.treinar.bb.model.banco;

public class ContaSalario extends Conta implements IProdutoPagavel {

	private int diaCreditoSalario;
	private double va1orPagar;

	public int getDiaCreditoSalario() {
		return diaCreditoSalario;
	}

	public void setDiaCreditoSalario(int diaCreditoSalario) {
		this.diaCreditoSalario = diaCreditoSalario;
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
	public void depositar(double valor) {
		super.setSaldo(super.getSaldo() + valor);
	}
	
	@Override
	public void sacar(double valor) throws SaldoInsuficienteException {
		valor += valor; //taxa para sacar na conta salário;
		super.sacar(valor);
	}

	@Override
	public void pagarValorMensalidade() {
		try {
			super.sacar(this.va1orPagar);
		} catch (SaldoInsuficienteException e) {
			System.out.println(" Saldo Insuficiente !");
			
		}
	}

	@Override
	public String toString() {
		return super.toString() + " " + "ContaSalario [diaCreditoSalario=" + diaCreditoSalario + ", va1orPagar=" + va1orPagar + "]";
	}

}
