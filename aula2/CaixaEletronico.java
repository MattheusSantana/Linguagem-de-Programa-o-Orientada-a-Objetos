public class CaixaEletronico {
	public static void main(String[] args) {
		double valorDoSaque = 200;


		Conta minhaConta = new Conta();
		Conta minhaConta2 = new Conta();

		minhaConta.saca(valorDoSaque);
		minhaConta2.saca(valorDoSaque);

	}
}