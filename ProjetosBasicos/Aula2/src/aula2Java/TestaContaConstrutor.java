package aula2Java;

public class TestaContaConstrutor {
	public static void main(String[] args) {
		ContaConstrutor contaConstrutor1= new ContaConstrutor(300);
		
		System.out.println("O limite de credito é: "+ contaConstrutor1.getLimiteCredito());
		
		ContaConstrutor contaConstrutor2  = new ContaConstrutor(2000, "Carlos Soares");
		
		System.out.println("O limite de usuário "
		+contaConstrutor2.getLimiteCredito() + " é igual á: "
		+contaConstrutor2.getCliente().getNome());
	}
	
	//Ctrl + shift + i ver o resultado de uma linha. Tipo impressão.

}
