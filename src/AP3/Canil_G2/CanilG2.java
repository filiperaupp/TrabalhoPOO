package AP3.Canil_G2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by filip on 19/06/2017.
 */
public class CanilG2 {
    public ArrayList<Cachorro> meuscaes = new ArrayList<Cachorro>();
    public int caescadastrados = 0;
    public int numerofemeas = 0;
    public int numeromachos = 0;
    public int totalpremiacao = 0;

    public void cadastrar() {
        Cachorro caozinho = new Cachorro();
        caozinho.lerDados( meuscaes );
        meuscaes.add(caozinho);
        caescadastrados++;
        if (caozinho.premiacao == 's') {
            totalpremiacao++;
        }
        if (caozinho.sexo == 'm') {
            numeromachos++;
        }
        else {
            numerofemeas++;
        }
    }

    public void remover() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        System.out.println("Escolha uma das opções de exclusão:");
        System.out.println("1 - Nome  semelhante");
        System.out.println("2 - Nome  igual");
        System.out.println("3 - Pedigree");
        opcao = entrada.nextInt();
        switch ( opcao ){
            case 1:{
                String subCao;
                String subComparacao;
                System.out.println("Nome do cão para remoção: ");
                subCao = entrada.next().substring(0,4);
                for (int i=0;i<meuscaes.size();i++) {
                    subComparacao = meuscaes.get(i).nome.substring(0,4);
                    if (subCao.equals(subComparacao)) {
                        forRemotion(meuscaes.get(i));
                        meuscaes.remove(i);
                        break;
                    }
                }
            }
            case 2: {
                String nomecao;
                String nomeremocao;
                System.out.println("Nome do cachorro para remoção: ");
                nomeremocao = entrada.next();
                for (int i=0;i<meuscaes.size();i++) {
                    nomecao = meuscaes.get(i).nome;
                    if (nomecao.equals(nomeremocao)) {
                        forRemotion(meuscaes.get(i));
                        meuscaes.remove(i);
                    }
                }
            }
            case 3: {
                String confirma;
                System.out.println("Deseja remover TODOS os cães com Pedigree?");
                confirma = entrada.next();
                if (confirma.equalsIgnoreCase("s")) {
                    for (int i=0;i<meuscaes.size();i++) {
                        if (meuscaes.get(i).pedigree == 's') {
                            forRemotion(meuscaes.get(i));
                            meuscaes.remove(0);
                        }
                        System.out.println("Caes removidos.");
                    }
                }
                else {
                    System.out.println("Remoção cancelada.");
                }
            }
            default: {
                System.out.println("Operação inválida.");
            }
        }
    }

    public void listar() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        System.out.println("Escolha uma das opções de listagem: ");
        System.out.println("1- Listar por raça;");
        System.out.println("2- Listar por nomes semelhantes");
        System.out.println("3- Listar por Pedigree");
        opcao = entrada.nextInt();
        switch (opcao) {
            case 1: {
                String opcaoraca;
                System.out.println("Digite a raça escolhida: ");
                opcaoraca = entrada.next();
                for (int i=0;i<meuscaes.size();i++) {
                    if( meuscaes.get(i).raca.equals( opcaoraca ) ){
                        System.out.println(meuscaes.get(i).nome);
                    }
                }
                break;
            }

            case 2: {
                String opcao_nome_sem;
                System.out.println("Informe o nome a procurar: ");
                opcao_nome_sem = entrada.next();
                for ( int i = 0; i < meuscaes.size(); i++ ) {

                    if( meuscaes.get(i).nome.equalsIgnoreCase( opcao_nome_sem.substring(0,4) ) ){
                        System.out.println( meuscaes.get(i).nome );
                    }

                }
                break;
            }

            case 3: {
                String opcaopedrigree;
                System.out.println("Listar todos cães com pedigree?(s/n) ");
                opcaopedrigree = entrada.next();
                for (int i=0;i<meuscaes.size();i++) {
                    if( meuscaes.get(i).pedigree == opcaopedrigree.toLowerCase().charAt(0) ){
                        System.out.println(meuscaes.get(i).nome);
                    }
                }
                break;
            }

            default: {
                System.out.println("Opção inválida.");
                break;
            }
        }
    }

    public void forRemotion(Cachorro caozinho) {
        caescadastrados--;
        if (caozinho.premiacao == 's') {
            totalpremiacao--;
        }
        if (caozinho.sexo == 'm') {
            numeromachos--;
        }
        else {
            numerofemeas--;
        }
    }

    public void mostrarInformacoes() {
        System.out.println("--- Informações gerais --- ");
        System.out.println("Total caes: " + this.caescadastrados);
        System.out.println("Total de femeas: " + this.numerofemeas);
        System.out.println("Total de machos: " + this.numeromachos);
        System.out.println("Total de premiações: " + this.totalpremiacao);
        System.out.println("---------------------------");
    }
}
