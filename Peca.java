package entidades;

public class Peca implements Comparable<Peca>{
	private String regiao ;
	private double peso ;
	private String cidade;
	private String estado;
	private String fazenda;
	public Peca(String regiao, double peso, String cidade, String estado, String fazenda) {
		super();
		setCidade(cidade);
		setEstado(estado);
		setFazenda(fazenda);
		setPeso(peso);
		setRegiao(regiao);
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFazenda() {
		return fazenda;
	}
	public void setFazenda(String fazenda) {
		this.fazenda = fazenda;
	}
	@Override
	public int compareTo(Peca o) {
			
		return this.getCidade().compareTo(o.getCidade());
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Peca [regiao=");
		builder.append(regiao);
		builder.append(", peso=");
		builder.append(peso);
		builder.append(", cidade=");
		builder.append(cidade);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", fazenda=");
		builder.append(fazenda);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
