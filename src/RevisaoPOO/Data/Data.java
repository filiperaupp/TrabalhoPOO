package RevisaoPOO.Data;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by filip on 15/08/2017.
 */
public class Data {
    Scanner tc = new Scanner(System.in);
    int dia,mes,ano;
    String trintaUm[] = {"1","3","5","7","8","10","12"};
    String trinta[] = {"4","6","9","11"};
    String mesStr;
    boolean foi = false;

    public void lerDia(){
        System.out.println("Dia:");
        this.dia = tc.nextInt();
    }

    public void ler() {
        System.out.println("Ano: ");
        this.ano = tc.nextInt();
        do {
            System.out.println("Mes:");
            this.mes = tc.nextInt();
            if (mes < 1 || mes >12) {
                System.out.println("Mes inválido. Digite novamente.");
            }
        } while (mes < 1 || mes > 12);
        mesStr = Integer.toString(mes);
        do {
            if (mes==2) {
                do{
                    lerDia();
                    if (this.dia <1 || this.dia>29){
                        System.out.println("Dia invalido. Digite novamente");
                    }
                } while (this.dia <1 || this.dia>29);
                foi = true;
            }
            for (String month: trintaUm){
                if (mesStr.equals(month)){
                    do{
                        lerDia();
                        if (this.dia <1 || this.dia>31){
                            System.out.println("Dia invalido. Digite novamente");
                        }
                    } while (this.dia <1 || this.dia>31);
                    foi = true;
                }
            }
            for (String month: trinta) {
                if (mesStr.equals(month)){
                    do{
                        lerDia();
                        if (this.dia <1 || this.dia>30){
                            System.out.println("Dia invalido. Digite novamente");
                        }
                    } while (this.dia <1 || this.dia>30);
                    foi = true;
                }
            }
        }while (foi==false);
    }
}
