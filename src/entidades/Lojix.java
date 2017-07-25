package entidades;

public class Lojix
{

	public static void main(String[] args)
	{
		Estoque estoque = new Estoque();
	
		// Cadastrar produtos
		Produto p1 = new Produto(15.0, 1, TAMANHO.TAM_P, TIPO.CAMISETA_M);
		Produto p2 = new Produto(10.0, 2, TAMANHO.TAM_G, TIPO.CALCA_M);
		Produto p3 = new Produto(16.5, 3, TAMANHO.TAM_M, TIPO.CAMISETA_F);
		Produto p4 = new Produto(20.75, 4, TAMANHO.TAM_P, TIPO.SHORT_F);
		
		estoque.adicionaProduto(p1);
		estoque.adicionaProduto(p2);
		estoque.adicionaProduto(p3);
		estoque.adicionaProduto(p4);
		
		System.out.println(estoque.listarEstoque());
		
		Produto p5 = new Produto(15.0, 6, TAMANHO.TAM_P, TIPO.CAMISETA_M);
		estoque.adicionaProduto(p5);
		System.out.println(estoque.listarEstoque());
	}

}
