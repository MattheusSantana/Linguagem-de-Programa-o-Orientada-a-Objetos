public class Conta {
	int numero;
	String dono;
	double saldo;

	boolean saca(double quantidade) {
		if(saldo >= quantidade) {
			//saldo = saldo - quantidade;
			saldo -= quantidade;
			return true;
		}
		else {
			System.out.printf("Você não tem dinheiro suficiente!");
			return false;
		}
	}
}