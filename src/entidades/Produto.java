package entidades;

public class Produto
{
	private int id, qntEstoque;
	private double valor; //Valor de cada produto.
	private TAMANHO tamanho;
	private TIPO tipo;
	
	public Produto (double valor, int qntEstoque, TAMANHO tamanho, TIPO tipo)
	{
		super();
		setValor(valor);
		setQntEstoque(qntEstoque);
		setTamanho(tamanho);
		setTipo(tipo);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getQntEstoque()
	{
		return qntEstoque;
	}

	public void setQntEstoque(int qntEstoque)
	{
		if (qntEstoque >= 0)
			this.qntEstoque = qntEstoque;
	}

	public double getValor()
	{
		return valor;
	}

	public void setValor(double valor)
	{
		if (valor > 0)
			this.valor = valor;
	}

	public TAMANHO getTamanho()
	{
		return tamanho;
	}

	public void setTamanho(TAMANHO tamanho)
	{
		this.tamanho = tamanho;
	}

	public TIPO getTipo()
	{
		return tipo;
	}

	public void setTipo(TIPO tipo)
	{
		this.tipo = tipo;
	}
	
	public void adicionaQuantidade(int quantidade)
	{
		setQntEstoque(getQntEstoque() + quantidade);
	}
	
	public void removeQuantidade(int quantidade)
	{
		if (quantidade <= getQntEstoque())
		{
			setQntEstoque(getQntEstoque() - quantidade);
		}
	}

	@Override
	public String toString()
	{
		return "Produto [tipo=" + tipo + ", tamanho=" + tamanho + "\nqntEstoque=" + qntEstoque + ", valor="
				+ valor + "]\n";
	}
}
