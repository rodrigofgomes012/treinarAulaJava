package br.com.treinar.bb;

import java.util.Scanner;

import br.com.treinar.bb.model.Conta;
import br.com.treinar.bb.view.TelaCadastroBB;

public class Main {
	
	public static void main(String[] args) {
		TelaCadastroBB cadastro = new TelaCadastroBB();
		cadastro.iniciarOperacao();
		System.out.println("good-by");
		
	}

}
