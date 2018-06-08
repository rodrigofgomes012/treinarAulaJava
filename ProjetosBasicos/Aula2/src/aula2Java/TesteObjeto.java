package aula2Java;

public class TesteObjeto {
	public static void main(String[] args) {
		Conta conta1 = new Conta();
		conta1.cliente = new Cliente();
		conta1.cliente.nome = "Rodrigo";
		conta1.saldo = 4500;
		conta1.numero = 8672453;
		
		Conta conta2 = conta1;
		System.out.println(conta2.numero);
		conta2 = new Conta();
		// forçando nullpointer exception
		//conta2.cliente = new Cliente(); Não da o erro
		System.out.println(conta2.cliente.nome);
		

	}

}
