package AP3.Canil;

import java.util.Scanner;

/**
 * Created by filip on 29/05/2017.
 */
public class Caes {
    Scanner tc = new Scanner(System.in);
    public int numerodocao;
    public String esterelizacao;
    public String vacinas;

    public void registrar() {
        System.out.println("Numero do cão: ");
        this.numerodocao= tc.nextInt();
        System.out.println("Esterilizado? sim/nao");
        this.esterelizacao = tc.next();
        System.out.println("Já tomou as vacinas? sim/nao");
        this.vacinas = tc.next();
    }
    public void contarCaesVacinas(Caes[] cao, int qtd) {
        int totalvacinados = 0;
        for (int i=0;i<qtd;i++) {
            if (cao[i].vacinas.equals("sim")) {
                totalvacinados++;
            }
        }
        System.out.println("Total de caes vacinados: " + totalvacinados);
    }
    public void contarCaesEsterilizados(Caes[] cao, int qtd) {
        int totalesteril = 0;
        for (int i=0;i<qtd;i++) {
            if (cao[i].esterelizacao.equals("sim")) {
                totalesteril++;
            }
        }
        System.out.println("Total de caes vacinados: " + totalesteril);
    }
    public void mostrarCaes(Caes[] caozinho, int qtd) {
        for (int i=0;i<qtd;i++) {
            System.out.println("");
            System.out.println("--- Cao nº " + (i+1) + " ---");
            System.out.println("Esterilizado: " + caozinho[i].esterelizacao);
            System.out.println("Vacinas: " + caozinho[i].vacinas);
        }
    }
}
