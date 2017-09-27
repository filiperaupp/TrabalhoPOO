package AP3.Listas;

/**
 * Created by filip on 23/05/2017.
 */
public class Lista {
    public Aluno inicio;
    public Aluno fim;
    public int qtd;

    public void addInicio(Aluno a) {
        if (this.inicio == null) {
            this.inicio = a;
            this.fim = a;
            qtd++;
        }
        else {
            a.proximo = this.inicio;
            this.inicio = a;
            qtd++;
        }
    }

    public void addFIm (Aluno a) {
        if (this.inicio==null) {
            addInicio(a);
        }
        else {
            this.fim.proximo = a;
            this. fim = a;
            qtd++;
        }
    }

    public void fimHard (Aluno a) {
        if (this.inicio==null) {
            addInicio(a);
        }
        else {
            Aluno aux = inicio;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = a;
            qtd++;
            this.fim = a;
        }
    }

    void removerInicio() {
        if (this.qtd == 0) {
            System.out.println("Erro.");
        }
        if (this.qtd == 1) {
            this.inicio = null;
            this.fim = null;
            qtd --;
        }
        else {
            this.inicio = this.inicio.proximo;
            qtd--;
        }
    }

    void removerFim() {
        if (this.qtd == 0) {
            System.out.println("Erro.");
        }
        if (this.qtd == 1) {
            this.inicio = null;
            this.fim = null;
            qtd --;
        }
        else {
            Aluno aux = this.inicio;
            Aluno ant = this.inicio;
            while (aux.proximo != null) {
                ant = aux;
                aux = aux.proximo;
            }
            ant.proximo = null;
            this.fim = ant;
            qtd--;
        }
    }

    void removerPosicao(int posicao) {
        if (this.qtd<posicao) {
            System.out.println("Posicao nao existe.");
        }
        else {
            if (posicao==1) {
                removerInicio();
            }
            else {
                int cont = 0;
                Aluno aux = this.inicio;
                Aluno ant = this.inicio;
                while (aux.proximo != null || cont == (posicao-1)) {
                    ant = aux;
                    aux = aux.proximo;
                    cont++;
                }
                ant.proximo = aux.proximo;
                qtd--;
            }
        }
    }

    void addPosicao(Aluno a, int posicao) {
        if (this.qtd<posicao) {
            System.out.println("Posicao nao existe.");
        }
        else {
            if (posicao==1) {
                addInicio(a);
            }
            else {
                int cont = 0;
                Aluno aux = this.inicio;
                Aluno ant = this.inicio;
                while (aux.proximo != null || cont == (posicao)) {
                    ant = aux;
                    aux = aux.proximo;
                    cont++;
                }
                a.proximo = ant.proximo;
                ant.proximo = a;
                qtd++;
            }
        }
    }
}
