package aula2;

public class Data {
	private Integer dia, mes, ano;
	
	public Data(){
		super();
	}
	
	public Data(Integer dia, Integer mes, Integer ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	
	
}