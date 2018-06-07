package aula2Java;

public class Cadastro {
	public static void main(String[] args) {
		Pessoa nomePessoa1 = new Pessoa(); // A variavel criada é somente uma referencia para onde está o objeto da memoria;
		
		nomePessoa1.nome = "Carla Alves";
		
		System.out.println(nomePessoa1.nome);
		
		Pessoa nomePessoa2 = nomePessoa1;
		// uma referência pode apontar para somente um objeto;
		// um objeto pode ser apontado por varios objetos;
		
		Pessoa nomePessoa3 = nomePessoa1;
		
		nomePessoa2 = new Pessoa();
		// java não atribui o valor. Java atribui a referência
	}
	
	

}
