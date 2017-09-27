package AP3.Agenda;


import java.util.Scanner;

/**
 * Created by filip on 30/05/2017.
 */
public class AgendaSystem {
    public Contato inicio;
    public Contato fim;
    public int qtd = 0;

    public void addContato(Contato contato) {
        if (this.inicio == null) {
            this.inicio = contato; //Adiciona Início quando nulo
            this.fim = contato;
            qtd++;
        } else if (contato.nome.compareToIgnoreCase(this.inicio.nome) < 0 || contato.nome.compareToIgnoreCase(this.inicio.nome) == 0) {
            contato.proximo = this.inicio;
            this.inicio = contato;             //Add inicio part.2
            qtd++;
            Contato aux = this.inicio;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            this.fim = contato;
        } else if (contato.nome.compareToIgnoreCase(this.fim.nome) > 0 || contato.nome.compareToIgnoreCase(this.fim.nome) == 0) {
            Contato aux = this.inicio;
            while (aux.proximo != null) {           //Add fim
                aux = aux.proximo;
            }
            aux.proximo = contato;
            this.fim = contato;
            qtd++;
        } else {
            Contato aux = this.inicio;
            Contato ant = this.inicio;               //Add meio
            int teste = 1;
            do {
                ant = aux;
                aux = aux.proximo;
                if (contato.nome.compareToIgnoreCase(ant.nome) > 0 && contato.nome.compareToIgnoreCase(aux.nome) < 0) {
                    break;
                }
            } while (teste==1);
            contato.proximo = ant.proximo;
            ant.proximo = contato;
            qtd++;
        }
        System.out.println("Contato adicionado com sucesso.");
    }

    public void removerContato(String name) {
        if (this.inicio == null) {
            System.out.println("AP3.Agenda vazia.");
        }
        else {
            Contato aux = this.inicio;
            Contato ant = this.inicio;
            int position = 1;
            while (!aux.nome.equals(name)) {
                if (aux.proximo == null) {
                    break;
                }
                ant = aux;
                aux = aux.proximo;
                position++;
            }
            if (aux.proximo==null && !aux.nome.equals(name)) {
                System.out.println("Contato não existe.");
            }
            else {
                if (position == 1) {
                    this.inicio = this.inicio.proximo;
                    this.qtd--;
                }
                if (position == qtd && qtd != 1) {
                    ant.proximo = null;
                    qtd--;
                } else {
                    ant.proximo = aux.proximo;
                    qtd--;
                }
                System.out.println("Contato removido.");
            }
        }
    }

    public void mostrarContatos() {
        if (this.inicio == null) {
            System.out.println("AP3.Agenda vazia.");
        } else {
            Contato aux = this.inicio;
            int cont = 1;
            System.out.println("--- Inicio AP3.Agenda ---");
            do {
                System.out.println("**Contato " + cont + ": ");
                aux.mostrar();
                aux = aux.proximo;
                cont++;
            } while (aux != null);
            System.out.println("--- Fim AP3.Agenda ---");
        }
    }

    public void editarContato(String name) {
        Scanner tc = new Scanner(System.in);
        if (this.inicio == null) {
            System.out.println("AP3.Agenda vazia.");
        } else {
            Contato anterior = this.inicio;
            Contato aux = this.inicio;
            while (!aux.nome.equals(name)) {
                if (aux.proximo == null) {
                    break;
                }
                anterior = aux;
                aux = aux.proximo;
            }
            if (aux.proximo==null && !aux.nome.equals(name)) {
                System.out.println("Contato não existe.");
            } else {
                aux.ler();
            }
        }
    }

    public void mostrarOnlyOne(String name) {
        if (this.inicio == null) {
            System.out.println("AP3.Agenda vazia.");
        } else {
            Contato aux = this.inicio;
            Contato ant = this.inicio;
            while (!aux.nome.equals(name)) {
                if (aux.proximo == null) {
                    break;
                }
                ant = aux;
                aux = aux.proximo;
            }
            if (aux.proximo==null && !aux.nome.equals(name)) {
                System.out.println("Contato não existe.");
            } else {
                System.out.println("Dados do contato: ");
                aux.mostrar();
            }
        }
    }
}

/*public void addInicio(Contato contato) {
        if (this.inicio==null) {
            this.inicio = contato;              //Base para adidioncar
            this.fim = contato;
            qtd++;
        }
        else {
            contato.proximo = this.inicio;
            this.inicio = contato;
            qtd++;
        }
    }
    public void addFim(Contato contato){
        if (this.inicio==null) {
            addInicio(contato);
        }
        else {
            Contato aux = this.inicio;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = contato;
            this.fim = contato;
            qtd++;
        }
    }

    public void addMeio(Contato contato, int position) {
        if (this.inicio==null || position==1) {
            addInicio(contato);
        }
        else {
            Contato aux = this.inicio;
            Contato ant = this.inicio;
            int cont = 1;
            while (cont != position) {
                ant = aux;
                aux = aux.proximo;
                cont++;
            }
            if (cont == (qtd+1)) {
                addFim(contato);
            }
            else {
                contato.proximo = ant.proximo;
                ant.proximo = contato;
                qtd++;
            }
        }
    } */

