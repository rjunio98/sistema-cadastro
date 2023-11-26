import java.util.Locale;
import java.util.Scanner;

import entities.LeitorArquivo;
import entities.SalvadorDeArquivo;
import entities.Usuario;

public class App {
    public static void main(String[] args) {
        LeitorArquivo leitor = new LeitorArquivo();
        leitor.lerArquivo();

        Usuario usuario = obterRespostasUsuario();
        System.out.println(usuario.toString());

        SalvadorDeArquivo.salvarRespostas(usuario);
    }

    private static Usuario obterRespostasUsuario() {
        try (Scanner sc = new Scanner(System.in).useLocale(Locale.US)) {
            System.out.println();

            System.out.print("Qual seu nome completo? ");
            String nome = sc.nextLine();

            System.out.print("Qual seu email de contato? ");
            String email = sc.nextLine();

            System.out.print("Qual sua idade? ");
            Integer idade = sc.nextInt();
            sc.nextLine();

            System.out.print("Qual sua altura? ");
            Double altura = sc.nextDouble();

            System.out.println();
            return new Usuario(nome, email, idade, altura);
        }
    }
}
