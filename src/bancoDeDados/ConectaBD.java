package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
					
					 cadastrarVendedor("joao", 5000.0, 12.0);
					 result = query.executeQuery("SELECT * FROM vendedor");
					
					while(result.next()){
					System.out.println(result.getString("nome"));
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
			System.out.println("Erro aqui");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


