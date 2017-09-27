package AP3.TrabalhoG2;

import java.util.Scanner;

/**
 * Created by filip on 11/06/2017.
 */
public class Fone {
    Scanner tc = new Scanner(System.in);
    public String telefone;
    public  Fone proximo;

    public void add() {
        System.out.println("Telefone: ");
        this.telefone = tc.next();
    }
}