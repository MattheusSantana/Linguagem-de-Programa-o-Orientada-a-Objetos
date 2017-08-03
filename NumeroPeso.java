package entidades;

public class NumeroPeso {
	private int quantidade;
	private double peso;
	public NumeroPeso(int quantidade, double peso) {
		super();
		setPeso(peso);
		setQuantidade(quantidade);
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NumeroPeso [quantidade=");
		builder.append(quantidade);
		builder.append(", peso=");
		builder.append(peso);
		builder.append("]");
		return builder.toString();
	}
	
	
}
