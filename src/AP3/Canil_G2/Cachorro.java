package AP3.Canil_G2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by filip on 19/06/2017.
 */
public class Cachorro {
    public String nome;
    public String raca;
    public int idade;
    public char sexo;
    public char pedigree;
    public char premiacao;

    public void lerDados( ArrayList<Cachorro> meuscaes ){
        Scanner entrada = new Scanner(System.in);
        boolean encontrou = false;
        do {
            System.out.println("Informe nome do cachorro: ");
            this.nome = entrada.next();
            if (!meuscaes.isEmpty()) {
                for (int i = 0; i < meuscaes.size(); i++) {
                    if (this.nome.equals(meuscaes.get(i).nome)) {
                        System.out.println("Já existe esse cachorro cadastrado!");
                        encontrou = true;
                        break;
                    }
                }
                if (!encontrou) {
                    break;
                }
            }
            else {
                break;
            }
        }while( true );

        System.out.println("Informe raça do cachorro: ");
        this.raca = entrada.next();
        System.out.println("Informe idade do cachorro: ");
        this.idade = entrada.nextInt();
        do {
            System.out.println("Informe sexo do cachorro: ");
            this.sexo = entrada.next().toLowerCase().charAt(0);
            if (sexo!= 'm' && sexo!= 'f') {
                System.out.println("Letra invalida. Digite novamente.");
            }
        } while (sexo!= 'm' && sexo!= 'f');
        do {
            System.out.println("Informe pedigree do cachorro: ");
            this.pedigree = entrada.next().toLowerCase().charAt(0);
            if (pedigree!= 's' && pedigree!= 'n') {
                System.out.println("Letra invalida. Digite novamente.");
            }
        } while (sexo!= 'm' && sexo!= 'f');
        do {
            System.out.println("Informe premiação do cachorro: ");
            this.premiacao = entrada.next().toLowerCase().charAt(0);
            if (premiacao!= 's' && premiacao!= 'n') {
                System.out.println("Letra invalida. Digite novamente.");
            }
        } while (sexo!= 'm' && sexo!= 'f');
    }
}
