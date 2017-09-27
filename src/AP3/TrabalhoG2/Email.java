package AP3.TrabalhoG2;

import java.util.Scanner;

/**
 * Created by filip on 11/06/2017.
 */
public class Email {
    Scanner tc = new Scanner(System.in);
    public String email;
    public Email proximo;

    public void add() {
        System.out.println("Email: ");
        this.email = tc.next();
    }
}