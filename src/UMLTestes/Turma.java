package UMLTestes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by filip on 23/08/2017.
 */
public class Turma {
    private int codTurma;
    private Curso curso;

    private ArrayList<Matricula> matriculas;

    public boolean criarTurma(){
        if (matriculas.size()<20) {
            return false;
        }
        else {
            return true;
        }
    }



    /*Scanner tc = new Scanner(System.in);
    private int codigo;
    private String nome;
    private String curso;

    public void criar(int cod) {
        this.codigo = cod;
        System.out.println("Nome da turma:");
        this.nome = tc.nextLine();
        System.out.println("Nome do curso da turma: ");
        this.curso = tc.nextLine();
        //chamr função que verifica turma
    }

    public  void mostrar() {
        System.out.println("Turma: "+ this.nome);
        System.out.println("Curso: "+ this.curso);
        System.out.println("Codigo: "+ this.codigo);
        System.out.println("-/-/-");
    }*/


}
