package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    List<Usuario> listaDeUsuarios = new ArrayList<>();

    public void listarUsuariosCadastrados(){
        System.out.println("Lista de Usuários Cadastrados:");
        for(Usuario usuario: listaDeUsuarios){
            System.out.println("Nome:" + usuario.getNome());
        }
    }

     public void cadastrarNovaPergunta() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite a nova pergunta: ");
            String novaPergunta = scanner.nextLine();

            adicionarPerguntaAoArquivo(novaPergunta);

            System.out.println("Nova pergunta cadastrada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao cadastrar a nova pergunta: " + e.getMessage());
        }
    }

    private void adicionarPerguntaAoArquivo(String novaPergunta) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("formulario.txt", true))) {
            writer.write(novaPergunta);
            writer.newLine(); // Adiciona uma nova linha para a próxima pergunta
        }
    }

    private LeitorArquivo leitorArquivo = new LeitorArquivo();

    public void deletarPergunta() {
        List<String> perguntas = leitorArquivo.obterPerguntasDoFormulario();

        if (perguntas.isEmpty()) {
            System.out.println("Não há perguntas para deletar.");
            return;
        }

        System.out.println("Lista de Perguntas:");
        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println((i + 1) + ". " + perguntas.get(i));
        }

        System.out.print("Digite o número da pergunta a ser deletada: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int numeroPergunta = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            if (numeroPergunta < 1 || numeroPergunta > perguntas.size()) {
                System.out.println("Número de pergunta inválido.");
                return;
            }

            String perguntaRemovida = perguntas.remove(numeroPergunta - 1);
            leitorArquivo.salvarPerguntasNoArquivo(perguntas);

            System.out.println("Pergunta \"" + perguntaRemovida + "\" removida com sucesso.");
        }
    }


    public void pesquisarUsuario() {
        if (listaDeUsuarios.isEmpty()) {
            System.out.println("Não há usuários para pesquisar.");
            return;
        }

        System.out.println("Opções de pesquisa:");
        System.out.println("1 - Por nome");
        System.out.println("2 - Por idade");
        System.out.println("3 - Por e-mail");
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Escolha a opção de pesquisa (1-3): ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    pesquisarPorNome();
                    break;
                case 2:
                    pesquisarPorIdade();
                    break;
                case 3:
                    pesquisarPorEmail();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void pesquisarPorNome() {
        System.out.print("Digite o nome para pesquisa: ");
        String nomePesquisa;
        try (Scanner scanner = new Scanner(System.in)) {
            nomePesquisa = scanner.nextLine().toLowerCase();
        }
    
        listaDeUsuarios.stream()
                .filter(usuario -> usuario.getNome().toLowerCase().contains(nomePesquisa))
                .forEach(usuario -> System.out.println(usuario));
    }
    
    private void pesquisarPorIdade() {
        System.out.print("Digite a idade para pesquisa: ");
        int idadePesquisa;
        try (Scanner scanner = new Scanner(System.in)) {
            idadePesquisa = scanner.nextInt();
        }
    
        listaDeUsuarios.stream()
                .filter(usuario -> usuario.getIdade() == idadePesquisa)
                .forEach(usuario -> System.out.println(usuario));
    }
    
    private void pesquisarPorEmail() {
        System.out.print("Digite o e-mail para pesquisa: ");
        String emailPesquisa;
        try (Scanner scanner = new Scanner(System.in)) {
            emailPesquisa = scanner.nextLine().toLowerCase();
        }
    
        listaDeUsuarios.stream()
                .filter(usuario -> usuario.getEmail().toLowerCase().contains(emailPesquisa))
                .forEach(usuario -> System.out.println(usuario));
    }

    public void adicionarUsuario(Usuario usuario) {
    }
    
}
