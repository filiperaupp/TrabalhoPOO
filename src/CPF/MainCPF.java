package CPF;

import java.util.Scanner;

/**
 * Created by filip on 06/09/2017.
 */
public class MainCPF {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        StringBuilder meuCPF = new StringBuilder();

        do {
            System.out.println("Digite o CPF: ");
            meuCPF.append(tc.next());
            if (!CPF.verificaCPF(meuCPF)){
                System.out.println("Digite seu cpf com os zeros iniciais e sem traços e/ou pontos");
            }
        } while (!CPF.verificaCPF(meuCPF));

        if (CPF.isCPF(meuCPF.toString())){
            System.out.println("CPF válido");
        }
        else {
            System.out.println("CPF inválido");
        }

        System.out.println(CPF.imprimeCPF(meuCPF.toString()));
        System.out.println(CPF.imprimeCPF2(meuCPF.toString()));
        CPF.imprimeCPF3(meuCPF.toString());

    }
}
