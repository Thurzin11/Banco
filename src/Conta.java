import javax.swing.JOptionPane;

public class Conta {
	
	private static int ContadorDeContas  = 1;
	
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;

	public Conta(Pessoa pessoa) {
		this.numeroConta = Conta.ContadorDeContas;
		this.pessoa = pessoa;
		Conta.ContadorDeContas +=1;

	}

	public int getNumeroConta() {
		return numeroConta ;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		return"\nNumero da conta: " + this.getNumeroConta()+
				"\nNome: " + this.pessoa.getNome()+
				"\nCpf: " + this.pessoa.getCpf()+
				"\nEmail: " + this.pessoa.getEmail()+
				"\nSaldo: " + this.getSaldo();
	}

	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Deposito foi realizado com sucesso!!!");
		} else {
			System.out.println("Não foi possivel realizar o deposito!!!");
		}
	}

	public void sacar(Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso!!!");
		} else {
			System.out.println("Não foi possivel realizar o saque!!!");
		}
	}
	
	public void tranferencia(Conta contaDeposito, Double valor) {
		if(valor>0 && this.getSaldo()>=valor) {
			 setSaldo(getSaldo()-valor);
			 contaDeposito.saldo = contaDeposito.getSaldo()+ valor;
			 System.out.println("Tranferencia realizada com sucesso!!!");
		}else {
			System.out.println("Não foi possivel realizar transferencia!!!");
		}
	}

}
