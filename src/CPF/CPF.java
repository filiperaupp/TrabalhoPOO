package CPF;

import java.util.InputMismatchException;
/**
 * Created by filip on 30/08/2017.
 */
public class CPF {

    public static boolean verificaCPF(StringBuilder sb) {
        if (sb.length()<11) {
            return false;
        }
        else if (sb.length()>11) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean isCPF(String CPF) {
// considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
// converte o i-esimo caractere do CPF em um numero:
// por exemplo, transforma o caractere '0' no inteiro 0
// (48 eh a posicao de '0' na tabela ASCII)
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

// Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static String imprimeCPF(String CPF) {
        if (isCPF(CPF))
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
                CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        else
            return "inválido";
    }

    public static String imprimeCPF2 (String CPF) {

        if (isCPF(CPF))
            return CPF;
        else
            return "inválido";
    }

    public static void imprimeCPF3 (String CPF) {
        if (isCPF(CPF)) {
            int save = 0;
            for (int i = 0; i < 11; i++) {
                if (CPF.charAt(i) == '0') {
                    System.out.print("");
                } else {
                    save = i;
                    break;
                }
            }
            for (int j = save; j < 11; j++) {
                System.out.print(CPF.charAt(j));
            }
        }
        else {
            System.out.println("inválido");
        }
    }
}
