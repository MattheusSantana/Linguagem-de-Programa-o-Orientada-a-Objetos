package gui;

import bancoDeDados.ConectaBD;
import entidades.TAMANHO;
import entidades.TIPO;

public class JMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPrincipal jPrincipal = new JPrincipal();
		ConectaBD.cadastrarProduto(25.0, 5, TAMANHO.TAM_P.toString(),TIPO.JAQUETA_F.toString());
		
	}

}
