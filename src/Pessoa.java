
public class Pessoa {
	
	
	private  static int counter = 1;
	private int numeroPessoa ;
    private String nome;
    private String cpf;
    private String email;
	
	public Pessoa(String nome, String cpf, String email) {
		this.numeroPessoa = Pessoa.counter;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		Pessoa.counter += 1;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public String toString() {
		return	"\nNome: " + this.getNome()+
				"\nCpf: " + this.getCpf()+
				"\nEmail: " + this.getEmail();
	}
	
	
	
	
}
