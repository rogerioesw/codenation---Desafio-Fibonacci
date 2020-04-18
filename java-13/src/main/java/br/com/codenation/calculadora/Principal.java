package br.com.codenation.calculadora;

public class Principal {
    public static void main(String[] args) {
        CalculadoraSalario ca = new CalculadoraSalario();

        System.out.println("Salario liquido: R$"+ca.calcularSalarioLiquido(1200.00));
    }
}
