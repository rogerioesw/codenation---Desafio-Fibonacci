package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		double salarioLiq = calcularInss(salarioBase);
		if(salarioLiq > 6000.00) {
			salarioLiq = salarioLiq - (salarioLiq*0.15);
		}
		else if(salarioLiq > 3000.00 && salarioLiq <= 6000.00) {
			salarioLiq = salarioLiq - (salarioLiq*0.075);
		}
		return Math.round(salarioLiq);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		double salarioLiq = 0.0;
		if(salarioBase < 1039.00) {
			return 0;
		}
		else if(salarioBase <= 1500.00) {
			salarioLiq = salarioBase - (salarioBase*0.08);
		}
		else if(salarioBase > 1500.00 && salarioBase < 4000.00 ) {
			salarioLiq = salarioBase - (salarioBase*0.09);
		}
		else {
			salarioLiq = salarioBase - (salarioBase*0.11);
		}

		return salarioLiq;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/