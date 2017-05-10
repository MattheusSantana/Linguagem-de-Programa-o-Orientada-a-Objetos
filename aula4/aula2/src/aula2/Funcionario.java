package aula2;

public class Funcionario {
	private String nome;
	private String rg;
	private String entrada_banco;
	private String departamento;
	private double salario;
	
	
	public Funcionario(){
		super();
	}
	
	public Funcionario(String nome, String rg, String entrada_banco, String departamento, double salario){
		setNome(nome);
		setRg(rg);
		setEntrada_banco(entrada_banco);
		setDepartamento(departamento);
		setSalario(salario);
	
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEntrada_banco() {
		return entrada_banco;
	}
	public void setEntrada_banco(String entrada_banco) {
		this.entrada_banco = entrada_banco;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	void recebeAumento (double aumento){
		if(aumento > 0)
			salario+=aumento;
	}
	
	double calculaGanhoAnual(){
		return (salario*12);
	}


	@Override
	public String toString() {
		return "Funcionario:\nNome: " + nome + "\nrg: " + rg + "\nData de Entrada no Banco: " + entrada_banco + "\nDepartamento: "
				+ departamento + "\nsalario: " + salario + "\n";
	}

}