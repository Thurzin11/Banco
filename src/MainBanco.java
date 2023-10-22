import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JOptionPane;

public class MainBanco {

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {

		System.out.println("-----------------------------------------------------");
		System.out.println("--------------Bem-Vindo-A-Nossa-Agencia--------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("*****Selecione uma operação que deseja realizar *****");
		System.out.println("-----------------------------------------------------");
		System.out.println("|    			Opção 1 - Criar Conta 				 |");
		System.out.println("|    			Opção 2 - Depositar   				 |");
		System.out.println("|    			Opção 3 - Sacar       				 |");
		System.out.println("|    			Opção 4 - Transferir  				 |");
		System.out.println("|    			Opção 5 - Listar     				 |");
		System.out.println("|   			Opção 6 - Sair 						 |");

		int operacao = scanner.nextInt();

		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			tranferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("Ate a proxima!");
			System.exit(0);
		default:
			System.out.println("Opção Inválida!");
			operacoes();
			break;
		}
	}

	public static void criarConta() {
		System.out.println("\nNome: ");
		String nome = scanner.next();

		System.out.println("\nCpf: ");
		String cpf = scanner.next();

		System.out.println("\nEmail: ");
		String email = scanner.next();

		Pessoa pessoa = new Pessoa(nome, cpf, email);

		Conta conta = new Conta(pessoa);
		
		contasBancarias.add(conta);
		
		System.out.println("Conta criada com sucesso!!!");

		operacoes();

	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta) {
					conta = c;
				}
			}
		}
		return conta;
	}

	public static void depositar() {
		System.out.println("Numero da conta");
		int numeroConta = scanner.nextInt();
		Conta conta = encontrarConta(numeroConta);
		if (conta != null) {
			System.out.println("Qual valor deseja depositar?");
			Double valorDeposito = scanner.nextDouble();
			conta.depositar(valorDeposito);
		} else {
			System.out.println("Conta não encontrada");
		}
		operacoes();
	}

	public static void sacar() {
		System.out.println("Numero da conta");
		int numeroConta = scanner.nextInt();
		Conta conta = encontrarConta(numeroConta);
		if (conta != null) {
			System.out.println("Qual valor deseja sacar?");
			Double valorSaque = scanner.nextDouble();
			conta.sacar(valorSaque);
		} else {
			System.out.println("Conta não encontrada");
		}
		operacoes();
	}

	public static void tranferir() {
		System.out.println("Numero da conta que voce deseja tranferir?");
		int numeroConta = scanner.nextInt();
		Conta contaTransferencia = encontrarConta(numeroConta);
		if (contaTransferencia != null) {
			System.out.println("Qual numero da conta do destinatario?");
			int numeroContaDestinatario = scanner.nextInt();
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			if (contaDestinatario != null) {
				System.out.println("Qual o valor da transferencia?");
				Double valor = scanner.nextDouble();
				contaTransferencia.tranferencia(contaDestinatario, valor);
			} else {
				System.out.println("Conta para deposito não encontrada");
			}
		} else {
			System.out.println("Conta para transferencia não encontrada");
		}
		operacoes();
	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não ha contas cadastradas!!");
		}
		operacoes();
	}
}
