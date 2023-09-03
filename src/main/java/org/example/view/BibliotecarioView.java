package org.example.view;
import org.example.controller.BibliotecarioController;
import org.example.controller.EmprestimoController;
import java.util.Scanner;
public class BibliotecarioView {
    Scanner scanner = new Scanner(System.in);
    BibliotecarioController bibliotecarioController = new BibliotecarioController();
    EmprestimoController emprestimoController = new EmprestimoController();
    public void login(){
        System.out.println("Por favor, efetue seu login para ter acesso as opções: ");
        System.out.println("Informe o seu acesso: ");
        int acesso = scanner.nextInt();
        menuBibliotecario(bibliotecarioController.login(acesso));
    }
    public void menuBibliotecario(boolean longin){
        int escolha = 0;
        do {
            System.out.println("Informe a opção desejada:\n1- Cadastrar Autor | 2- Cadastrar Livro");
            System.out.println("3- Deletar um cadastro | 4- Efetuar um empréstimo");
            System.out.println("5-Associar Livro a um Autor | 6-Associar Autor a um Livro");
            System.out.println("0-Sair");
            escolha = scanner.nextInt();

            switch (escolha){
                case 1:
                    registrarAutor();
                    break;

                case 2:
                    registrarLivro();
                    break;

                case 3:
                    menuDeletar();
                    break;

                case 4:
                    efetuarEmprestimo();
                    break;

                case 5:
                    associarAutor();
                    break;

                case 6:
                    associarLivro();
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while (escolha!=0);
    }
    public void registrarAutor(){
        System.out.println("Informe o nome do Autor: ");
        String nome = scanner.nextLine();
        System.out.println("Informe o CPF do Autor: ");
        String cpf = scanner.nextLine();
        System.out.println("Informe o e-mail do Autor: ");
        String email = scanner.nextLine();
        bibliotecarioController.registrarAutor(nome,cpf,email);
    }
    public void registrarLivro(){
        System.out.println("Qual o título do livro?:");
        String titulo = scanner.nextLine();
        System.out.println("Qual a descrição?: ");
        String descricao = scanner.nextLine();
        System.out.println("Qual o gênero?: ");
        String genero = scanner.nextLine();
        bibliotecarioController.registrarLivro(titulo,descricao,genero);
    }
    public void efetuarEmprestimo(){
        System.out.println("Digite o id do livro que deseja pegar emprestado:");
        int id_livro = scanner.nextInt();
        System.out.println("Digite o seu id:");
        int id_leitor = scanner.nextInt();
        emprestimoController.efetuarEmprestimo(id_livro,id_leitor);
    }
    public void menuDeletar(){
        int escolha;
        do {
            System.out.println("Informe qual tipo de cadastro deseja excluir: ");
            System.out.println("1-Excluir um livro | 2-Excluir um autor");
            System.out.println("3-Excluir um usuário | 0-Sair");

            escolha = scanner.nextInt();
            System.out.println("Informe o id: ");
            int id = scanner.nextInt();
            switch (escolha){
                case 1:
                    bibliotecarioController.deletarLivro(id);
                    System.out.println("Livro deletado!");
                break;

                case 2:
                    bibliotecarioController.deletarAutor(id);
                    System.out.println("Autor deletado!");
                break;

                case 3:
                    bibliotecarioController.deletarLeitor(id);
                    System.out.println("Leitor deletado!");
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválido");
                    menuDeletar();
            }
        }while (escolha!= 0);
    }
    public void associarAutor(){
        System.out.println("Informe o id do Autor: ");
        int id_autor = scanner.nextInt();
        System.out.println("Informe o id do Livro: ");
        int id_livro = scanner.nextInt();
        bibliotecarioController.associarIdLivroAoAutor(id_autor,id_livro);
    }
    public void associarLivro(){
        System.out.println("Informe o id do Livro: ");
        int id_livro = scanner.nextInt();
        System.out.println("Informe o id do Autor: ");
        int id_autor = scanner.nextInt();
        bibliotecarioController.associarIdAutorAoLivro(id_livro,id_autor);
    }
}