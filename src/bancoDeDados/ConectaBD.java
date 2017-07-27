package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import entidades.Produto;
import entidades.TAMANHO;
import entidades.TIPO;
import entidades.Vendedor;

public class ConectaBD {
	static ResultSet result;
	static Statement query;

	public ConectaBD(){
		super();
				try {
					DriverManager.registerDriver(new org.sqlite.JDBC());
				} catch (SQLException e) {
					System.err.println("Erro ao registrar driver.");
					e.printStackTrace();
				}

				// Passando drive do sqlite para efetuar conexão para efetuar a conexão.
				try {
					Connection connection = DriverManager.getConnection("jdbc:sqlite:bd.sqlite");
					query = connection.createStatement();

					} catch (SQLException e) {
					System.out.println("Erro ao conectar banco de dados.");
					e.printStackTrace();
				}
	
	}
	
	
	public static void cadastrarVendedor(String n, Double salarioBase, Double txComissao) {

		Vendedor vendedor = new Vendedor(n, salarioBase, txComissao);
		try {
			String str = "INSERT INTO vendedor(nome, salario_base, qnt_vendas, tx_comissao)" + "" + "VALUES('" + n
					+ "','" + salarioBase.toString() + "', 0,'" + txComissao.toString() + "')";

			query.executeUpdate(str);

		} catch (SQLException e) {
			System.out.println("Não foi possível cadastrar o vendedor!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void cadastrarProduto(Double valor, int qntEstoque, String tamanho, String tipo) {
		

		Produto produto = new Produto(valor, qntEstoque, TAMANHO.valueOf(tamanho), TIPO.valueOf(tipo));
		if(buscaProduto(produto) == 1){
			try {
			String str = "INSERT INTO produto(valor, qnt_estoque, tamanho, tipo)" + "" + "VALUES('" + valor.toString()
					+ "','" + Integer.toString(qntEstoque) + "','" + tamanho + "'," + "'" + tipo + "')";

			query.executeUpdate(str);
			System.out.println("Produto Cadastrado!!");
		} catch (SQLException e) {
			System.out.println("Não foi possível cadastrar o produto!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}



	/*Verifica se o produto passado por parâmentro ja foi cadastrado no banco! retorna 1 caso não esteja cadastrado e 0 caso contrário!*/
	public static int buscaProduto(Produto produto) {
		String sql = "SELECT tipo, tamanho, valor FROM produto";
		
		/*Navegando por todas as tuplas do banco e verificando caso o produto já esteja cadastrado!*/
		try {
			result = query.executeQuery(sql);
			while(result.next()){
				/*Se o valor, tipo e o tamanho do produto for igual á tupla que está sendo análisada retorne 0.*/
				
			if (result.getString("tipo").equals(produto.getTipo().toString())
					&& result.getString("tamanho").equals(produto.getTamanho().toString()) 
					&& result.getString("valor").equals(String.valueOf(produto.getValor()))){
					
					System.out.println("Produto já cadastrado!");
					return 0;
			}
			}
			
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	
public static Object[][] preencherTabelaProdutos(){
		int qtd = 0;
		String sql;
		try {
			 sql = "SELECT count(*) AS count FROM  produto";
			result = query.executeQuery(sql);
		qtd = Integer.parseInt((result.getString("count")));
			
			
			 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		System.out.println(qtd);
	Object dados[][] =  new Object[qtd][4];
		try {
						
			/*Pegando todas as tuplas da tabela produto*/
			 sql = "SELECT * FROM produto";
			System.out.println("Entrou");
			result = query.executeQuery(sql);
			
			//PRECISA DEFINIR O TAMANHO DAS LINHAS E COLUNAS ?
			
		
			int i = 0;
			while (result.next()){
				dados[i][0] = result.getString("tipo");
				dados[i][1] = result.getString("tamanho");
				dados[i][2] = result.getString("valor");
				dados[i][3] = result.getString("qnt_estoque");
				
				i++;
			}
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao preencher os dados!");
			e.printStackTrace();
		}
	
		return dados;
	}

}
