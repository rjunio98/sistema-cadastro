package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SalvadorDeArquivo {

    private static Integer contadorArquivos = 1;

    public void salvarRespostas(Usuario usuario) {
        String nomeArquivo = criarNomeArquivo(usuario.getNome());
        String conteudoArquivo = formatarConteudo(usuario);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudoArquivo);
            System.out.println("Respostas salvas com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar as respostas: " + e.getMessage());
        }
    }

    private static String criarNomeArquivo(String nomeCompleto) {
        String nomeArquivo = contadorArquivos + "-" + nomeCompleto.toUpperCase().replaceAll("\\s", "") + ".TXT";
        contadorArquivos++;
        return nomeArquivo;
    }

    private static String formatarConteudo(Usuario usuario) {
        return "Nome: " + usuario.getNome() +
               "\nEmail: " + usuario.getEmail() +
               "\nIdade: " + usuario.getIdade() +
               "\nAltura: " + usuario.getAltura();
    }
}
