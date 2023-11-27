import java.util.Locale;
import java.util.Scanner;

import entities.LeitorArquivo;
import entities.MenuPrincipal;
import entities.SalvadorDeArquivo;
import entities.Usuario;

public class App {
    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        LeitorArquivo leitor = new LeitorArquivo();
        SalvadorDeArquivo salvador = new SalvadorDeArquivo();

        leitor.lerArquivo();

        System.out.println("----- Menu Principal -----");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Listar Usuários Cadastrados");
        System.out.println("3 - Cadastrar Nova Pergunta");
        System.out.println("4 - Deletar Pergunta");
        System.out.println("5 - Pesquisar Usuários");
        System.out.println("6 - Sair");
        System.out.println("---------------------------");

        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Usuario usuario = obterRespostasUsuario(scanner);
                    System.out.println(usuario.toString());
                    salvador.salvarRespostas(usuario);
                    menuPrincipal.adicionarUsuario(usuario);
                    break;
                case 2:
                    menuPrincipal.listarUsuariosCadastrados();
                    break;
                case 3:
                    menuPrincipal.cadastrarNovaPergunta();
                    break;
                case 4:
                    menuPrincipal.deletarPergunta();
                    break;
                case 5:
                    menuPrincipal.pesquisarUsuario();
                    break;
                case 6:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar a opção: " + e.getMessage());
        }
    }

    private static Usuario obterRespostasUsuario(Scanner scanner) {
        System.out.println();
    
        System.out.print("Qual seu nome completo? ");
        String nome = scanner.nextLine();
    
        scanner.nextLine();
    
        System.out.print("Qual seu email de contato? ");
        String email = scanner.nextLine();
    
        System.out.print("Qual sua idade? ");
        Integer idade = scanner.nextInt();
        scanner.nextLine(); 
    
        System.out.print("Qual sua altura? ");
        Double altura = scanner.nextDouble();
        scanner.nextLine(); 
    
        System.out.println();
    
        return new Usuario(nome, email, idade, altura);
    }
    
    
}
