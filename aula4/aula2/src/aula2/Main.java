package aula2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
			Funcionario f1 = new Funcionario("joao","009009", "RH", "12/12/2012", 2000.00);
		
		
			Scanner scan = new Scanner(System.in);
			
			Funcionario funcionario = new Funcionario();
			System.out.println("Digite o nome do FUncionário\n");
			funcionario.setNome(scan.next());
			
			System.out.println("Digite o rg\n");
			funcionario.setRg(scan.next());
			
			System.out.println("Digite o departamento\n");
			funcionario.setDepartamento(scan.next());
			
			System.out.println("digite a data de entrada do Funcionário no banco");
			funcionario.setEntrada_banco(scan.next());
			
			System.out.println("digite o Salario do Funcionário");
			funcionario.setSalario(scan.nextDouble());
			
			/*Imprimindo funcionário cadastro pelo método construtor*/
			System.out.println("Funcionário 1:\n");
			System.out.println(f1.toString());
			
			/*Imprimindo funcionário cadastrado pelo usuário*/
			System.out.println("Novo Funcionário:\n"); 
			System.out.println(funcionario.toString());
			
			
			
			scan.close();
		}
}