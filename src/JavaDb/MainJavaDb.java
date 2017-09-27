package JavaDb;

import java.util.Scanner;

/**
 * Created by filip on 13/09/2017.
 */
public class MainJavaDb {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        DbUtils banco = new DbUtils();
        //banco.criarDB();
        AlunoDao daoAluno = new AlunoDao();
        int ope =0;

        do {
            System.out.println("--- Menu ---");
            System.out.println("1- Inserir aluno");
            System.out.println("2- Remover aluno");
            System.out.println("3- Editar Aluno");
            System.out.println("4- Listar alunos");
            System.out.println("5- Sair");
            ope = tc.nextInt();
            switch (ope) {
                case 1: {
                    Aluno aluno = new Aluno();
                    System.out.println("Id: ");
                    aluno.setId(tc.nextLong());
                    System.out.println("Nome: ");
                    aluno.setNome(tc.nextLine());
                    System.out.println("Idade: ");
                    aluno.setIdade(tc.nextInt());
                    System.out.println("Código: ");
                    aluno.setCodigo(tc.next());
                    System.out.println("Salario: ");
                    aluno.setSalario(tc.nextDouble());
                    daoAluno.save(aluno);
                    break;
                }
                case 2: {

                    break;
                }
                case 3: {

                    break;
                }
                case 4: {

                    break;
                }
                case 5:

                    break;
            }
        } while (ope!=5);

        //DbHelper sqlLite= new DbHelper();
        //sqlLite.executarSQL("INSERT NTO ALUNO (NOME,IDADE,CODIGO,SALARIO) VALUES ('Ramon', 32, '021131000', 200 )");

        Aluno a= new Aluno("Sadi",34,"0034",30.0);

        daoAluno.save(a);
        daoAluno.list();
    }
}
