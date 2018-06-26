package br.com.treinar.bb.teste;

import java.util.Scanner;

import br.com.treinar.bb.model.tipodado.TipoCliente;

public class TesteEnum2 {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		TipoCliente[] tiposDeCliente = TipoCliente.values();
				
		System.out.println("Informe o ordinal do ENUM: ");
		System.out.print("-> ");
		int posicaoEnum = sc.nextInt();
		
		while(posicaoEnum >= tiposDeCliente.length){
			System.out.println("Os Ordinais v�lidos devem ser inteiros menores que "+tiposDeCliente.length);
			System.out.println("Informe um ordinal v�lido!");
			posicaoEnum = sc.nextInt();
		}
		
		System.out.println(" Sal�rio minimo para ser cliente "
				+tiposDeCliente[posicaoEnum].name()+" � : "+tiposDeCliente[posicaoEnum].getSalarioMinimo());
		
		
								
		sc.close();
		
	}
	
}
