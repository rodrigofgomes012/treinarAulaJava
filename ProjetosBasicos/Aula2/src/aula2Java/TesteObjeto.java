package aula2Java;

public class TesteObjeto {
	public static void main(String[] args) {
		Conta conta1 = new Conta();
		conta1.cliente = new Cliente();
		conta1.cliente.nome = "Rodrigo";
		conta1.saldo = 4500;
		conta1.numero = 8672453;
		System.out.println("O cliente "+conta1.cliente.nome+" de conta número "+conta1.numero+" possui saldo de R$"+conta1.numero );
	}

}
