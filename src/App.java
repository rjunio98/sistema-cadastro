import java.util.Locale;
import java.util.Scanner;

import entities.LeitorArquivo;
import entities.Usuario;

public class App {
    public static void main(String[] args) {
        LeitorArquivo leitor = new LeitorArquivo();
        leitor.lerArquivo();

        try (Scanner sc = new Scanner(System.in).useLocale(Locale.US)) {
            System.out.println();

            System.out.print("Qual seu nome completo? ");
            String nome = sc.nextLine();

            System.out.print("Qual seu email de contato? ");
            String email = sc.nextLine();

            System.out.print("Qual sua idade? ");
            Integer idade = sc.nextInt();

            System.out.print("Qual sua altura? ");
            Double altura = sc.nextDouble();
            sc.nextLine();

            Usuario usuario = new Usuario(nome, email, idade, altura);
            System.out.println(usuario.toString());
        }   
    }
} 