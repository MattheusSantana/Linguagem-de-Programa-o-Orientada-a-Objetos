package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bancoDeDados.ConectaBD;


/*Cadastra um novo vendedor*/
public class JVendedor extends JFrame implements ActionListener {
	private JLabel nome;
	private JLabel salario;
	private JTextField nomeTF;
	private JTextField salarioTF;
	private JButton cadastrar;
	private JButton cancelar;	
	
	ConectaBD bd = new ConectaBD();

	public JVendedor(){
		setLayout(null);
		setSize(600,800);
		JLabel titulo = new JLabel("Cadastrar Vendedor");
		titulo.setBounds(100, 30, 150, 20);
		
		
		nome = new JLabel("Nome:");
		nome.setBounds(100, 70, 150, 20);
		
		nomeTF = new JTextField(30);
		nomeTF.setBounds(100, 90, 150, 20);
		
		salario = new JLabel("Salario:");
		salario.setBounds(100, 170, 150, 20);
		
		salarioTF = new JTextField(30);
		salarioTF.setBounds(100, 190, 150, 20);
	
		cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(100, 470, 200, 40);
		cadastrar.addActionListener(this);
		cancelar = new JButton("Cancelar");
		cancelar.setBounds(300, 470, 200, 40);
		cancelar.addActionListener(this);
	
		
		add(titulo);
		add(nome);
		add(nomeTF);
		add(salario);
		add(salarioTF);
		add(cadastrar);
		add(cancelar);
		
		setVisible(true);
		
	}
	/*Cadastra o vendedor*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cadastrar){
		
				int resultado = bd.cadastrarVendedor(nomeTF.getText().toString(), Double.parseDouble(salarioTF.getText().toString()), 0.0);
				
				/*Informando o usuário sobre o resultado do cadastro*/
				if(resultado == 1)
					JOptionPane.showMessageDialog(null, "Vendedor Cadastrado!");
				else if(resultado == 0)
					JOptionPane.showMessageDialog(null, "Vendedor ja Cadastrado!");	
				else
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar Vendedor!");
				
		}
		/*Fechando a tela*/
		if(e.getSource()== cancelar){
			System.exit(0);
		}
	}
}
