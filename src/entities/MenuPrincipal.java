package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private final List<Usuario> listaDeUsuarios = new ArrayList<>();
    private final LeitorArquivo leitorArquivo = new LeitorArquivo();
    private final Scanner scanner = new Scanner(System.in);

    public void adicionarUsuario(Usuario usuario) {
        listaDeUsuarios.add(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    public void listarUsuariosCadastrados() {
        System.out.println("Lista de Usuários Cadastrados:");
        listaDeUsuarios.forEach(System.out::println);
    }

    public void cadastrarNovaPergunta() {
        System.out.print("Digite a nova pergunta: ");
        String novaPergunta = scanner.nextLine();

        adicionarPerguntaAoArquivo(novaPergunta);

        System.out.println("Nova pergunta cadastrada com sucesso!");
    }

    private void adicionarPerguntaAoArquivo(String novaPergunta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("formulario.txt", true))) {
            writer.write(novaPergunta);
            writer.newLine(); // Adiciona uma nova linha para a próxima pergunta
        } catch (IOException e) {
            System.out.println("Erro ao cadastrar a nova pergunta: " + e.getMessage());
        }
    }

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
        int numeroPergunta = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (numeroPergunta < 1 || numeroPergunta > perguntas.size()) {
            System.out.println("Número de pergunta inválido.");
            return;
        }

        String perguntaRemovida = perguntas.remove(numeroPergunta - 1);
        leitorArquivo.salvarPerguntasNoArquivo(perguntas);

        System.out.println("Pergunta \"" + perguntaRemovida + "\" removida com sucesso.");
    }

    public void pesquisarUsuario() {
        List<Usuario> listaDeUsuarios = leitorArquivo.obterUsuariosDoArquivo();

        if (listaDeUsuarios.isEmpty()) {
            System.out.println("Não há usuários para pesquisar.");
            return;
        }

        System.out.println("Opções de pesquisa:");
        System.out.println("1 - Por nome");
        System.out.println("2 - Por idade");
        System.out.println("3 - Por e-mail");

        System.out.print("Escolha a opção de pesquisa (1-3): ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (opcao) {
            case 1:
                pesquisarPorNome(listaDeUsuarios);
                break;
            case 2:
                pesquisarPorIdade(listaDeUsuarios);
                break;
            case 3:
                pesquisarPorEmail(listaDeUsuarios);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void pesquisarPorNome(List<Usuario> listaDeUsuarios) {
        System.out.print("Digite o nome para pesquisa: ");
        String nomePesquisa = scanner.nextLine().toLowerCase();

        listaDeUsuarios.stream()
                .filter(usuario -> usuario.getNome().toLowerCase().contains(nomePesquisa))
                .forEach(usuario -> System.out.println(usuario));
    }

    private void pesquisarPorIdade(List<Usuario> listaDeUsuarios) {
        System.out.print("Digite a idade para pesquisa: ");
        int idadePesquisa = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        listaDeUsuarios.stream()
                .filter(usuario -> usuario.getIdade() == idadePesquisa)
                .forEach(usuario -> System.out.println(usuario));
    }

    private void pesquisarPorEmail(List<Usuario> listaDeUsuarios) {
        System.out.print("Digite o e-mail para pesquisa: ");
        String emailPesquisa = scanner.nextLine().toLowerCase();

        listaDeUsuarios.stream()
                .filter(usuario -> usuario.getEmail().toLowerCase().contains(emailPesquisa))
                .forEach(usuario -> System.out.println(usuario));
    }

    public void fecharScanner() {
        scanner.close();
    }
}
