package aula2Java;
import java.util.Scanner;

public class TesteMetodo {
	public static void main(String[] args) {
		Conta conta1 = new Conta();
		conta1.cliente = new Cliente();
		conta1.cliente.nome = "Maria Shopia";
		conta1.saldo = 200;
		conta1.numero = 503026;
		System.out.println("Saldo: " + conta1.saldo);
		conta1.sacar(50);
		System.out.println("Novo Saldo: " + conta1.saldo);
		
		boolean sacou = conta1.sacar(40);
		if (sacou) {
			System.out.println("Novo Saldo: " + conta1.saldo);
		
		}else { System.out.println(" Saldo Insuficiente");}
		
		System.out.println("O saldo da conta 1 é: "+conta1.consultarSaldo());
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o valor que deseja depositar: ");
		conta1.depositarNoSaldo(sc.nextDouble());
		
		System.out.println("O valor do saldo é de "+ conta1.consultarSaldo());
		
		sc.close();
		
			

	}

}
