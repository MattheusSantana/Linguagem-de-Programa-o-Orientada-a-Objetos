package entidades;

import java.util.ArrayList;

public class Vendedor
{
	private String nome;
	private double salarioBase, valorVendas, txComissao;
	private int qntVendas;
	
	public Vendedor(String nome, double salarioBase, double txComissao)
	{
		super();
		setNome(nome);
		setSalarioBase(salarioBase);
		setTxComissao(txComissao);
		setValorVendas(0);
		setQntVendas(0);
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public double getSalarioBase()
	{
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase)
	{
		if (salarioBase > 0)
			this.salarioBase = salarioBase;
	}

	public double getValorVendas()
	{
		return valorVendas;
	}

	public void setValorVendas(double valorVendas)
	{
		this.valorVendas += valorVendas;
	}

	public double getTxComissao()
	{
		return txComissao;
	}

	public void setTxComissao(double txComissao)
	{
		if (txComissao > 0)
			this.txComissao = txComissao;
	}

	public int getQntVendas()
	{
		return qntVendas;
	}

	public void setQntVendas(int qntVendas)
	{
		this.qntVendas += qntVendas;
	}
	


	
}
