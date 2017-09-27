package AP3.ArrayLista;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by filip on 12/06/2017.
 */
public class StringList {

    public void addNoLocal(String string, int x, ArrayList<String> array) {
        array.add(x,string);
    }

    public void remover(String string, ArrayList array) {
        if (array.contains(string)) {
            array.remove(string);
        }
    }

    public void mostrarTamanhoLista(ArrayList array) {
        System.out.println("Tamannho da lista: " + array.size());
    }

    public int tamanhoString(ArrayList array, int indice) {
        String palavra = (String) array.get(indice);
        return palavra.length();
    }

    public int somaStrings(ArrayList array) {
        int soma = 0;
        String palavra;
        for (int i=0;i<array.size();i++) {
            palavra = (String) array.get(i);
            soma += palavra.length();
        }
        return soma;
    }

    public boolean alterarString(ArrayList array, String string, int indice) {
        if (indice>array.size()) {
            return false;
        }
        else {
            array.set(indice,string);
            return true;
        }
    }

    public void addNoFim(ArrayList array) {
        Scanner tc = new Scanner(System.in);
        String palavra;
        System.out.println("Palavra para adicionar: ");
        palavra = tc.next();
        array.add(palavra);
    }

    public void mostrarMaiuscula(ArrayList<String> array) {
        String palavra;
        for (int i=0;i<array.size();i++) {
            palavra = (String) array.get(i);
            System.out.println(palavra.toUpperCase());
        }
    }

    public void mostrarComLetraInicial(ArrayList array, char letra) {
        String palavra;
        for (int i=0;i<array.size();i++) {
            palavra = (String) array.get(i);
            if (palavra.charAt(0) == letra) {
                System.out.println(palavra);
            }
        }
    }


}








