package org.example.view;
import org.example.controller.LeitorController;
import java.util.Scanner;
public class LeitorView {
    private Scanner scanner = new Scanner(System.in);
    private LeitorController leitorController = new LeitorController();
    public void menuLeitor() {
        int escolha=0;
        do {
            System.out.println("Você deseja: \n1-Fazer login | 2-Cadastrar-se | 0-Sair");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    informacoesParaLogin();
                    break;

                case 2:
                    informacoesParaRegistro();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.err.println("Opção Inválida!!! ");
                    menuLeitor();
            }

        }while (escolha!=0);
    }
    public void informacoesParaLogin() {
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Senha: ");
        String password = scanner.next();
        leitorController.login(email, password);
    }
    public void informacoesParaRegistro() {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("Cpf: ");
        String cpf = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Senha: ");
        String senha = scanner.next();
        leitorController.cadastro(nome, cpf, email, senha);
    }
    public void menu(){
        int escolha=0;
        do {
            System.out.println("Você deseja: 1-Ver livros | 2-Ver livro emprestados\n0-Sair");
            escolha = scanner.nextInt();

            switch (escolha){
                case 1:

                    break;

                case 2:
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Opção inválida");
                    menu();
            }

        }while (escolha!=0);
    }
}