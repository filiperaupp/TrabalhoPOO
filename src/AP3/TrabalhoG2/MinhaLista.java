package AP3.TrabalhoG2;

import java.util.Scanner;

/**
 * Created by filip on 11/06/2017.
 */
public class MinhaLista {
    public Pessoa inicio;
    public Pessoa fim;
    public int totalcontatos = 0;
    public int totaltelefones = 0;
    public int totalemails = 0;
    public int insercoes = 0;
    public int remocoes = 0;

    public void addContato(Pessoa pessoa) {
        if (this.inicio == null) {
            this.inicio = pessoa; //Adiciona Início quando nulo
            this.fim = pessoa;
            posAdition(pessoa);
        } else if (pessoa.nome.compareToIgnoreCase(this.inicio.nome) < 0 || pessoa.nome.compareToIgnoreCase(this.inicio.nome) == 0) {
            this.inicio.anterior = pessoa;
            pessoa.proximo = this.inicio;
            this.inicio = pessoa;             //Add inicio part.2
            Pessoa aux = this.inicio;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            this.fim = pessoa;
            posAdition(pessoa);
        } else if (pessoa.nome.compareToIgnoreCase(this.fim.nome) > 0 || pessoa.nome.compareToIgnoreCase(this.fim.nome) == 0) {
            Pessoa aux = this.inicio;
            while (aux.proximo != null) {           //Add fim
                aux = aux.proximo;
            }
            aux.proximo = pessoa;
            this.fim = pessoa;
            this.fim.anterior = aux;
            posAdition(pessoa);
        } else {
            Pessoa aux = this.inicio;
            int teste = 1;                    //Add meio
            do {
                aux = aux.proximo;
                if (pessoa.nome.compareToIgnoreCase(aux.anterior.nome) > 0 && pessoa.nome.compareToIgnoreCase(aux.nome) < 0) {
                    break;
                }
            } while (teste==1);
            pessoa.proximo = aux.anterior.proximo;
            pessoa.anterior = aux.anterior;
            aux.anterior.proximo = pessoa;
            aux.anterior = pessoa;
            posAdition(pessoa);
        }
    }

    public void removerContato(String name) {
        if (this.inicio == null) {
            System.out.println("AP3.Agenda vazia.");
        }
        else {
            Pessoa aux = this.inicio;
            int position = 1;
            while (!aux.nome.equals(name)) {
                if (aux.proximo == null) {
                    break;
                }
                aux = aux.proximo;
                position++;
            }
            if (aux.proximo==null && !aux.nome.equals(name)) {
                System.out.println("Contato não existe.");
            }
            else {
                if (position == 1) {
                    posRemotion(this.inicio);
                    this.inicio = this.inicio.proximo;
                    if (this.inicio!=null) {
                        this.inicio.anterior = null;             //Remove inicio
                    }
                }
                else if (position == this.totalcontatos && this.totalcontatos!= 1) {
                    posRemotion(aux);
                    aux.anterior.proximo = null;                     //Remove fim
                } else {
                    posRemotion(aux);
                    aux.anterior.proximo = aux.proximo;
                    aux.proximo.anterior = aux.anterior;      //Remove meio
                }
            }
        }
    }

    public void editarContato(String name) {
        Scanner tc = new Scanner(System.in);
        if (this.inicio == null) {
            System.out.println("AP3.Agenda vazia.");
        } else {
            Pessoa aux = this.inicio;
            while (!aux.nome.equals(name)) {
                if (aux.proximo == null) {
                    break;
                }
                aux = aux.proximo;
            }
            if (aux.proximo==null && !aux.nome.equals(name)) {
                System.out.println("Contato não existe.");
            } else {
                removerContato(aux.nome);
                aux.meusemails.qtd = 0;
                aux.meustelefones.qtd = 0;
                aux.meusemails.inicio = null;
                aux.meustelefones.inicio = null;
                aux.proximo = null;
                aux.anterior = null;
                Pessoa novocontato = new Pessoa();
                novocontato.ler();
                addContato(novocontato);
                this.insercoes--;
                this.remocoes--;
            }
        }
    }

    public void mostrarApenasUm(String name) {
        if (this.inicio == null) {
            System.out.println("AP3.Agenda vazia.");
        } else {
            Pessoa aux = this.inicio;
            while (!aux.nome.equals(name)) {
                if (aux.proximo == null) {
                    break;
                }
                aux = aux.proximo;
            }
            if (aux.proximo==null && !aux.nome.equals(name)) {
                System.out.println("Contato não existe.");
            } else {
                System.out.println("Dados do contato: ");
                aux.mostrarDados();
            }
        }
    }

    public void mostrarTodos() {
        String CSI = "\u001B[";
        if (this.inicio == null) {
            System.out.println("AP3.Agenda vazia.");
        } else {
            Pessoa aux = this.inicio;
            int cont = 1;
            System.out.println("--- Inicio AP3.Agenda ---");
            do {
                System.out.print (CSI + "31" + "m");
                System.out.println("**Contato " + cont + ": ");
                System.out.print (CSI + "m");
                aux.mostrarDados();
                aux = aux.proximo;
                cont++;
            } while (aux != null);
            System.out.println("--- Fim AP3.Agenda ---");
        }
    }

    public void informacoesGerais() {
            String CSI = "\u001B[";
            System.out.print (CSI + "34" + "m");
            System.out.println("--- Informações Geerais: ");
            System.out.println("Total de contatos: " + this.totalcontatos);
            System.out.println("Total de telefones: " + this.totaltelefones);
            System.out.println("Total de emails: " + this.totalemails);
            System.out.println("Total de inserções: " + this.insercoes);
            System.out.println("Total de remoções: " + this.remocoes);
            System.out.println();
            System.out.print (CSI + "m");
    }

    public void posRemotion(Pessoa pessoa) {
        this.totalemails -= pessoa.meusemails.qtd;
        this.totaltelefones -= pessoa.meustelefones.qtd;
        this.totalcontatos--;
        this.remocoes++;
    }

    public void posAdition(Pessoa pessoa) {
        this.totalemails += pessoa.meusemails.qtd;
        this.totaltelefones += pessoa.meustelefones.qtd;
        this.totalcontatos++;
        this.insercoes++;
    }
}