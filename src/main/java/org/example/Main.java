package org.example;
import org.example.view.BibliotecarioView;
import org.example.view.LeitorView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BibliotecarioView bibliotecarioView = new BibliotecarioView();
        LeitorView leitorView = new LeitorView();

        int escolha=0;
        do {
            System.out.println("Bem-vindo a biblioteca");
            System.out.println("Você é: 1-Administrador | 2-Visitante | 0-Sair");
            escolha = scanner.nextInt();
            switch (escolha){
                case 1:
                    bibliotecarioView.login();
                    break;

                case 2:
                    leitorView.menuLeitor();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Opção inválida");
            }
        }while (escolha!=0);
    }
}