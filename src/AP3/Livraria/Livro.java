package AP3.Livraria;
import java.util.Scanner;

/**
 * Created by ramon on 09/08/17.
 */
public class Livro {

    public String nome;
    public String descricao;
    public double valor;
    public int isbn;
    public Autor autor = new Autor();


    public void ler() {
        Scanner tc = new Scanner(System.in);
        System.out.println("Digite o nome do livro");
        this.nome = tc.next();///
        System.out.println("Digite a descricao do livro");
        this.descricao = tc.next();///
        System.out.println("Digite o isbn do livro");
        this.isbn = tc.nextInt();///
        System.out.println("Digite o valor do livro");
        this.valor = tc.nextDouble();///
        this.autor.ler();

    }

    public void mostrar() {
        System.out.println(this.nome);
        System.out.println(this.descricao);
        System.out.println(this.isbn);
        System.out.println(this.valor);
        this.autor.mostrar();
    }

    public boolean aplicarDescontoDe(double p) {
        if (p> 0.3) {
            return false;
        }
        this.valor -= this.valor * p;
        return true;
    }

    public double mostrarDescontoAplicado(double p) {
        double desconto = this.valor * p;
        return desconto;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;

        if (isbn != livro.isbn) return false;
        return nome != null ? nome.equals(livro.nome) : livro.nome == null;
    }
}


