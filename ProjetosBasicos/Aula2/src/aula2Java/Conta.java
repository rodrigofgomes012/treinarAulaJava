package aula2Java;

public class Conta {
	public int numero;
	public double saldo;
	public Cliente cliente;
	public double limiteCredito;

	public boolean sacar(double valorSaque) { // Alt shift R troca o nome da variavel
		boolean deuParaSacar = false;
		if (valorSaque <= saldo) {
			saldo -= valorSaque;
			deuParaSacar = true;
		}
		return deuParaSacar;
		
	}
	
	public double consultarSaldo() {
			return saldo;	
	}
	
	public void depositarNoSaldo(double valorDeposito) {
		saldo += valorDeposito;
		
	}
			
}

