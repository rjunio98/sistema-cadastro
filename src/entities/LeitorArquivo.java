package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {
    private static final String PATH = "C:/Users/Gamer/OneDrive/Documentos/sistema-cadastro/sistema cadastro/formulario.txt";

    public void lerArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void salvarPerguntasNoArquivo(List<String> perguntas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true))) {
            for (String pergunta : perguntas) {
                writer.write(pergunta);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar perguntas no arquivo: " + e.getMessage());
        }
    }

    public List<String> obterPerguntasDoFormulario() {
        List<String> perguntas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line = br.readLine();

            while (line != null) {
                perguntas.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao obter perguntas do formulário: " + e.getMessage());
        }

        return perguntas;
    }

    public List<Usuario> obterUsuariosDoArquivo() {
        return null;
    }
}
