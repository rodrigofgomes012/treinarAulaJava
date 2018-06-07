package aula2Java;

public class Cadastro {
	public static void main(String[] args) {
		Pessoa nomePessoa1 = new Pessoa(); // A variavel criada � somente uma referencia para onde est� o objeto da memoria;
		
		nomePessoa1.nome = "Carla Alves";
		
		System.out.println(nomePessoa1.nome);
		
		Pessoa nomePessoa2 = nomePessoa1;
		// uma refer�ncia pode apontar para somente um objeto;
		// um objeto pode ser apontado por varios objetos;
		
		Pessoa nomePessoa3 = nomePessoa1;
		
		nomePessoa2 = new Pessoa();
		// java n�o atribui o valor. Java atribui a refer�ncia
	}
	
	

}
