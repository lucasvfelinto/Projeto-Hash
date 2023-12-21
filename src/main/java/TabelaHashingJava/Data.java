package TabelaHashingJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Data {
    private List<String> dados;
    private String fileName;
    private int maxSize = 300;

    public Data() {
        this("src/main/java/chaves.txt");
    }

    public Data(String nomeArquivo) {
        this.fileName = nomeArquivo;
        this.dados = new ArrayList<>();
        this.carregarArquivo();
    }

    public void carregarArquivo() {
        File arquivo = new File(this.fileName);
        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado: " + this.fileName);
            return;
        }

        try (Scanner scanner = new Scanner(arquivo)) {
            int contador = 0;
            while (scanner.hasNext() && contador < maxSize) {
                this.dados.add(scanner.nextLine());
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }

    public List<String> getDados() {
        return new ArrayList<>(this.dados);
    }

    public List<String> getDados(int count) {
        count = Math.min(this.dados.size(), count);
        return new ArrayList<>(this.dados.subList(0, count));
    }

    public void printData() {
        // Checa se a lista dados está vazia
        if (dados.isEmpty()) {
            System.out.println("Nenhuma chave para exibir.");
            return;
        }

        // Exibe as chaves
        System.out.println("Chaves lidas do arquivo:");
        for (String chave : dados) {
            System.out.println(chave);
        }
    }    

    public static void main(String[] args) {
        Data d = new Data();
        d.printData();
    }
}