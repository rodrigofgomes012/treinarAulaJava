package br.com.treinar.bb.view;

import java.util.Scanner;

import br.com.treinar.bb.controller.BancoController;
import br.com.treinar.bb.model.Cliente;
import br.com.treinar.bb.model.banco.Conta;
import br.com.treinar.bb.model.banco.ContaCorrente;
import br.com.treinar.bb.model.banco.ContaPoupanca;
import br.com.treinar.bb.model.banco.ContaSalario;

public class TelaCadastroBB {

	private BancoController controller;
	private Scanner input;
	
	public TelaCadastroBB() {
		controller = new BancoController();
		input = new Scanner(System.in);
	}
	
	public void iniciarOperacao() {
		int opcao;
		do {
			imprimirMenu();
			opcao = input.nextInt();
			switch (opcao) {
			case 1:
				criarConta();
				break;
			case 2:
				depositar();
				break;
			case 3:
				exibirSaldo();
				break;
			case 4:
				sacar();
				break;
			case 5:
				alterarTaxaRendimento();
				break;
			case 6:
				exibirTaxaRendimento();
				break;
			case 7:
				cobrarMensalidade();
			case 8:
				listarContas();
				break;
			case 9:
				deletarContas();
				break;
			case 10:
				transferirEntreContas();
				break;
			case 0:
				break;

			default:
				System.out.println("Opcção inválida");
				break;
			}
		} while (opcao != 0);
		
		input.close();
	}
	
	private static void imprimirMenu() {
		System.out.print(""
			+ "Informe a opção:\n"
			+ "\t0 - Sair\n"
			+ "\t1 - Criar Conta\n"
			+ "\t2 - Depositar\n"
			+ "\t3 - Exibir Saldo\n"
			+ "\t4 - Sacar\n"
			+ "\t5 - Alterar Taxa de Rendimento\n"
			+ "\t6 - Exibir Taxa de Rendimento\n"
			+ "\t7 - Cobrar Mensalidade\n"
			+ "\t8 - Listar Contas\n"
			+ "\t9 - Deletar Contas\n"
			+ "\t10 - Transferência de Valores\n"
			+ "\t\n=> "
		);
	}
	
	private void cobrarMensalidade() {
		controller.cobrarMensalidade();
	}

	private void alterarTaxaRendimento() {
		System.out.print("Informe a taxa de rendimento: ");
		float taxaRendimento = input.nextFloat();
		controller.alterarTaxaRendimento(taxaRendimento);
	}

	private void sacar() {
		System.out.println("Digite o número da conta que deseja sacar: ");
		int numeroConta = input.nextInt();
		int posicao = controller.pesquisarConta(numeroConta);
		if (posicao == -1) {
			System.out.println("Essa conta não existe em nossos registros !\n");
			depositar();
		}else {
			System.out.print("Informe o Valor a ser sacado: ");
			boolean sacou = controller.sacar(input.nextDouble(), posicao);
			String mensagem = sacou ? "Saque efetuado com sucesso" : "Saldo insuficiente";
			System.out.println(mensagem);			
		}

	}

	private void criarConta() {
		System.out.print("Digite:\n\t1 - Conta Corrente\n\t2 - Conta Poupança\n\t3 - Conta Salário\n=> ");
		int opcao = input.nextInt();
		switch (opcao) {
		case 1:
			criarContaCorrente();
			break;
		case 2:
			criarContaPoupanca();
			break;
		case 3:
			criarContaSalario();
			break;

		default:
			break;
		}
	}

	private void criarContaSalario() {
		ContaSalario cs = new ContaSalario();
		criarContaGenerica(cs);
		System.out.print("Informe o dia de credito do salario: ");
		int diaCreditoSalario = input.nextInt();
		cs.setDiaCreditoSalario(diaCreditoSalario);
		System.out.print("Informe valor do produto: ");
		cs.setValorPagar(input.nextDouble());
		controller.criarConta(cs);
	}

	private void criarContaPoupanca() {
		ContaPoupanca cp = new ContaPoupanca();
		criarContaGenerica(cp);
		controller.criarConta(cp);
	}

	private void criarContaCorrente() {
		ContaCorrente cc = new ContaCorrente();
		criarContaGenerica(cc);
		System.out.print("Informe o limite de credito: ");
		double limiteCredito = input.nextDouble();
		cc.setLimiteCredito(limiteCredito);
		cc.setLimiteCreditoAtual(limiteCredito);
		System.out.print("Informe valor do produto: ");
		cc.setValorPagar(input.nextDouble());
		controller.criarConta(cc);
	}

	private void criarContaGenerica(Conta conta) {
		input.nextLine();
		System.out.print("Informe o numero da conta: ");
		int numeroConta = input.nextInt();
		int posicao = controller.pesquisarConta(numeroConta);
		while (posicao != -1) {
			System.out.print("Essa conta já existe,informe outro número : ");
			numeroConta = input.nextInt();
			posicao = controller.pesquisarConta(numeroConta);
		}
		input.nextLine();
		System.out.print("Informe o nome do cliente: ");
		String nomeCliente = input.nextLine();
		System.out.print("Informe o CPF do cliente: ");
		String cpfCliente = input.nextLine();
		conta.setCliente(new Cliente());
		conta.getCliente().setNome(nomeCliente);
		conta.getCliente().setCpf(cpfCliente);
		conta.setNumero(numeroConta);
		}
	
	private void exibirSaldo() {
		System.out.println("Digite o número da conta: ");
		int numeroConta = input.nextInt();
		int posicao = controller.pesquisarConta(numeroConta);
		if (posicao == -1) {
			System.out.println("Essa conta não existe em nossos registros !\n");
			depositar();
		}else {
			double saldo = controller.recuperarSaldo(posicao);
			System.out.println("Saldo atual: " + saldo);
			
		}

	}
	private void exibirTaxaRendimento() {
		System.out.println("Taxa rendimento atual: " + controller.recuperarTaxaRendimento());
	}

	private void depositar() {
		System.out.println("Digite o número da conta a receber o saldo: ");
		int numeroConta = input.nextInt();
		int posicao = controller.pesquisarConta(numeroConta);
		if (posicao == -1) {
			System.out.println("Essa conta não existe em nossos registros !\n");
			depositar();
		}else {
			System.out.println("Informe o valor a depositar: ");
			controller.depositar(input.nextDouble(), posicao);			
		}
	}

	private void deletarContas() {
		System.out.println("Digite o número da conta a ser deletada: ");
		int numeroConta = input.nextInt();
		int posicao = controller.pesquisarConta(numeroConta);
		if (posicao == -1) {
			System.out.println("Essa conta não existe em nossos registros !\n");
			iniciarOperacao();
		}else {
				controller.deletarContas(posicao);	
				System.out.println("Conta deletada com sucesso !");
			}
			
		}
	
	private void listarContas() {
		Conta[] contas = controller.recuperarContas();
		for (int i = 0; i < contas.length; i++) {
			if (contas[i] != null) {
				System.out.println(i + " - " + contas[i]);
			}
		}
	}
	
	private void transferirEntreContas() {
							
		System.out.println(" Por favor informe a conta a ser sacada: ");
		int numeroContaSacada = input.nextInt();
		int posicaoContaSacada = controller.pesquisarConta(numeroContaSacada);
		if (posicaoContaSacada == -1) {
			System.out.println(" Essa conta não existe em nossos registros !\n");
			iniciarOperacao();
		}
		
		System.out.println(" Por favor informe a conta destinatária: ");
		int numeroContaDestinataria = input.nextInt();
		int posicaoContaDestinataria = controller.pesquisarConta(numeroContaDestinataria);
		if (posicaoContaDestinataria == -1) {
			System.out.println(" Essa conta não existe em nossos registros !\n");
			iniciarOperacao();
		}
			
		System.out.println(" Informe o valor da transferência: ");
		double valorTransferencia = input.nextDouble();
		if (controller.recuperarSaldo(posicaoContaSacada) < valorTransferencia) {
			System.out.println(" Seu saldo é insuficiente !\n");
			iniciarOperacao();
		}else{
			controller.sacar(valorTransferencia, posicaoContaSacada);
			controller.depositar(valorTransferencia, posicaoContaDestinataria);
		}
		
		System.out.println(" Transferência realizada com sucesso ! ");
			
		
	}
	
	
	
}
