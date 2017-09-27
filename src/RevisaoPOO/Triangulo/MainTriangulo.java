package RevisaoPOO.Triangulo;

import java.util.Scanner;

/**
 * Created by filip on 15/08/2017.
 */
public class MainTriangulo {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        Triangulo tri = new Triangulo();

        tri.ler();
        tri.mostrar();
        tri.calcular();

    }
}
