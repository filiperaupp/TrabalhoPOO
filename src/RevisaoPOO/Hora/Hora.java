package RevisaoPOO.Hora;

import java.util.Scanner;

/**
 * Created by filip on 16/08/2017.
 */
public class Hora {
    Scanner tc = new Scanner(System.in);
    int hora,minutos,segundos;

    public void ler() {
        do {
            System.out.println("Horas: ");
            this.hora = tc.nextInt();
            if (hora <0 || hora>23) {
                System.out.println("Hora invalida. Digite novamente.");
            }
        } while (hora <0 || hora>23);
        do {
            System.out.println("Minutos: ");
            this.minutos= tc.nextInt();
            if (minutos < 0 || minutos > 59) {
                System.out.println("Minutos invalidos. Digite novamente.");
            }
        } while (minutos < 0 || minutos > 59);
        do {
            System.out.println("Segundos: ");
            this.segundos= tc.nextInt();
            if (segundos < 0 || segundos> 59) {
                System.out.println("Segundos invalidos. Digite novamente.");
            }
        } while (segundos< 0 || segundos > 59);
    }
}
