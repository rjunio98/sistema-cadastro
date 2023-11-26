package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivo {
    String path = "C:/Users/Gamer/OneDrive/Documentos/sistema-cadastro/sistema cadastro/formulario.txt";

    public void lerArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao let arquivo: " + e.getMessage());
        }
    }
}
