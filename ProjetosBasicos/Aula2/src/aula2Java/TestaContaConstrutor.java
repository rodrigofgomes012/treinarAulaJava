package aula2Java;

public class TestaContaConstrutor {
	public static void main(String[] args) {
		ContaConstrutor contaConstrutor1= new ContaConstrutor(300);
		
		System.out.println("O limite de credito �: "+ contaConstrutor1.getLimiteCredito());
		
		ContaConstrutor contaConstrutor2  = new ContaConstrutor(2000, "Carlos Soares");
		
		System.out.println("O limite de usu�rio "
		+contaConstrutor2.getLimiteCredito() + " � igual �: "
		+contaConstrutor2.getCliente().getNome());
	}
	
	//Ctrl + shift + i ver o resultado de uma linha. Tipo impress�o.

}
