package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Produto;
import entidades.TAMANHO;
import entidades.TIPO;
import entidades.Vendedor;


public class ConectaBD {
	static ResultSet result;
	static Statement query;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
				try {
					DriverManager.registerDriver(new org.sqlite.JDBC());
				} catch (SQLException e) {
					System.err.println("Erro ao registrar driver.");
					e.printStackTrace();
				}
				
				//Passando drive do sqlite para efetuar conexão para efetuar a conexão. 
				try {
					Connection connection = DriverManager.getConnection("jdbc:sqlite:bd.sqlite");
					 query = connection.createStatement();
					
					// cadastrarVendedor("joao", 5000.0, 12.0);
					 cadastrarProduto(25.0, 50, "tam_g", "CAMISETA_F");
					 result = query.executeQuery("SELECT * FROM produto");
					
					
					 
					 while(result.next()){
					System.out.print(result.getString("id_produto"));
					System.out.print(" ");
					System.out.print(result.getString("valor"));
					System.out.print(" ");
					System.out.print(result.getString("tipo"));
					System.out.print(" ");
					System.out.print(result.getString("qnt_estoque"));
					System.out.print(" ");
					System.out.println(result.getString("tamanho"));
					}
				}
					catch (SQLException e) {
					System.out.println("Erro ao conectar banco de dados.");
					e.printStackTrace();
				}
				
			}
	
	public static void cadastrarVendedor(String n, Double salarioBase, Double txComissao){
		
		Vendedor vendedor = new Vendedor(n, salarioBase, txComissao);
		 try {
			 String str = "INSERT INTO vendedor(nome, salario_base, qnt_vendas, tx_comissao)" + "" +  "VALUES('" +n+ "','" + salarioBase.toString() +"', 0,'" + txComissao.toString() + "')";
	
			query.executeUpdate(str);
	
		 } catch (SQLException e) {
			System.out.println("Não foi possível cadastrar o vendedor!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static void cadastrarProduto(Double valor, int qntEstoque, String tam, String t){
	
		Produto produto = new Produto(valor, qntEstoque, TAMANHO.TAM_G, TIPO.CAMISETA_F);
		
		 try {
			 String str = "INSERT INTO produto(valor, qnt_estoque, tamanho, tipo)" + "" +  "VALUES('" +valor.toString()+ "','"	 + Integer.toString(qntEstoque) +"','" + tam + "'," + "'"+ t + "')";
	
			query.executeUpdate(str);
	
		 } catch (SQLException e) {
			System.out.println("Não foi possível cadastrar o produto!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


