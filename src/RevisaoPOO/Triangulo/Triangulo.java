package RevisaoPOO.Triangulo;

import java.util.Scanner;

/**
 * Created by filip on 15/08/2017.
 */
public class Triangulo {
    Scanner tc = new Scanner(System.in);
    double altura=0,base=0;

    public void ler() {

        System.out.println("Altura do triangulo: ");
        this.altura = tc.nextDouble();
        System.out.println("Base do triangulo");
        this.base = tc.nextDouble();
    }

    public void mostrar() {
        System.out.println("-------------------");
        System.out.println("Altura do triangulo: "+this.altura);
        System.out.println("Base do triangulo:"+this.base);
        System.out.println("-------------------");
    }

    public void calcular() {
        System.out.println();
        System.out.println("Area do triangulo: "+(this.altura*this.base/2));
    }

}
