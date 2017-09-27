package AP3.Revision;

import java.util.Scanner;

/**
 * Created by filip on 08/08/2017.
 */
public class Revisao {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        String ope;
        double num1, num2;

        System.out.println("Digite: ");
        System.out.println("'soma' para somar ");
        System.out.println("'sub' para subtrair");
        System.out.println("'div' para dividir");
        System.out.println("'multi' para multiplicar");
        ope = tc.nextLine();
        System.out.println("Digite o primeiro numero: ");
        num1 = tc.nextDouble();
        System.out.println("Digite o segundo numero: ");
        num2 = tc.nextDouble();
        System.out.println("O resultado é: " + Functions.calculadora(num1,num2,ope));
    }
}
