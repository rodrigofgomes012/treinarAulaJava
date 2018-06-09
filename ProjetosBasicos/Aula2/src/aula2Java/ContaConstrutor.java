package aula2Java;

public class ContaConstrutor {
	private int numeroConta;
	private double saldo;
	private ClienteConstrutor cliente;
	private double limiteCredito;
	
	public ContaConstrutor() {
		System.out.println("O Objeto foi criado");
	}

	public ContaConstrutor(double limiteCredito) {
		this();
		this.limiteCredito = limiteCredito;
			
	}
	
	public ContaConstrutor(double limiteCredito, String nomeCliente) {
		this(limiteCredito);
		this.cliente = new ClienteConstrutor();
		this.cliente.setNome(nomeCliente);
		
	}
	
	
	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ClienteConstrutor getCliente() {
		return cliente;
	}

	public void setCliente(ClienteConstrutor cliente) {
		this.cliente = cliente;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}



	
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
