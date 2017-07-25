package entidades;

import java.util.ArrayList;

public class Estoque
{
	private static ArrayList<Produto> produtosDisponiveis = new ArrayList<>();
	private static ArrayList<Produto> produtosVendidos = new ArrayList<>();
	private static double valorEstoque;
	private static double valorVendido;
	private static int qntProdutosDisponiveis;
	private static int qntProdutosVendidos;
	
	public Estoque()
	{
		super();
		setValorEstoque(0);
		setValorVendido(0);
		setQntProdutosDisponiveis(0);
		setQntProdutosVendidos(0);
	}

	public static ArrayList<Produto> getProdutosDisponiveis()
	{
		return produtosDisponiveis;
	}

	public void setProdutosDisponiveis(ArrayList<Produto> produtosDisponiveis)
	{
		Estoque.produtosDisponiveis = produtosDisponiveis;
	}

	public ArrayList<Produto> getProdutosVendidos()
	{
		return produtosVendidos;
	}

	public void setProdutosVendidos(ArrayList<Produto> produtosVendidos)
	{
		Estoque.produtosVendidos = produtosVendidos;
	}

	public double getValorEstoque()
	{
		return valorEstoque;
	}

	public static void setValorEstoque(double valorEstoque)
	{
		Estoque.valorEstoque += valorEstoque;
	}

	public double getValorVendido()
	{
		return valorVendido;
	}

	public static void setValorVendido(double valorVendido)
	{
		Estoque.valorVendido += valorVendido;
	}

	public int getQntProdutosDisponiveis()
	{
		return qntProdutosDisponiveis;
	}

	public static void setQntProdutosDisponiveis(int qntProdutosDisponiveis)
	{
		Estoque.qntProdutosDisponiveis += qntProdutosDisponiveis;
	}

	public int getQntProdutosVendidos()
	{
		return qntProdutosVendidos;
	}

	public static void setQntProdutosVendidos(int qntProdutosVendidos)
	{
		Estoque.qntProdutosVendidos += qntProdutosVendidos;
	}	
	
	public void adicionaProduto(Produto produto)
	{
		// Verifica se o produto já existe no estoque e adiciona a quantidade
		if (produtosDisponiveis.contains(produto))
		{
			produtosDisponiveis.get(produtosDisponiveis.indexOf(produto)).setQntEstoque(produto.getQntEstoque());
			setQntProdutosDisponiveis(produto.getQntEstoque());
			setValorEstoque(produto.getQntEstoque() * produto.getValor());
		}
		
		// Cadastra produto novo
		else
		{
			produtosDisponiveis.add(produto);
			setQntProdutosDisponiveis(produto.getQntEstoque());
			setValorEstoque(produto.getQntEstoque() * produto.getValor());
		}
	}
	
	public static void removeProduto(int qntProdutos, Produto produto)
	{
		// Verifica se o produto e a quantidade estão em estoque
		if (produtosDisponiveis.contains(produto) &&
			 qntProdutos <= produtosDisponiveis.get(produtosDisponiveis.indexOf(produto)).getQntEstoque())
		{
			produtosDisponiveis.get(produtosDisponiveis.indexOf(produto)).removeQuantidade(qntProdutos);
			setQntProdutosDisponiveis(-produto.getQntEstoque());
			setValorEstoque(produto.getQntEstoque() * (-produto.getValor()));
			
		}
		else
			System.out.println("Produto indisponível no estoque.");
	}
	
	public static void adicionaProdutoVendido(Produto produto)
	{
		produtosVendidos.add(produto);
		setQntProdutosVendidos(produto.getQntEstoque());
		setValorVendido(produto.getQntEstoque() * produto.getValor());
	}
	
	public String listarEstoque()
	{
		return produtosDisponiveis.toString() + "Valor total: " + getValorEstoque() + "\n"
				 + "Quantidade de produtos: " + getQntProdutosDisponiveis() + "\n";
	}
	
	public String listarVendidos()
	{
		return produtosVendidos.toString();
	}
}
