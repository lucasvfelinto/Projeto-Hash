package TabelaHashingJava;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class HashPorMultiplicacao implements HashMethod {
    private int tamanhoTabela = 100;
    private double constante = 0.6180339887;
    private ArrayList<LinkedList<String>> tabela;
    private HashMap<Integer, Integer> histograma;

    public HashPorMultiplicacao() {        
        tabela = new ArrayList<LinkedList<String>>(Collections.nCopies(tamanhoTabela, new LinkedList<String>()));
        histograma = new HashMap<>();
        for (int i = 0; i < tamanhoTabela; i++) {
            histograma.put(i, 0);
        }
    }

    public int hash(String chave) {
        double valor = chave.hashCode() * constante;
        double parteFracionaria = valor -  Math.floor(valor);
        return (int) (tamanhoTabela * parteFracionaria);
    }

    public int hash(Integer chave) {
        double valor = chave.hashCode() * constante;
        double parteFracionaria = valor - (int) valor;
        return (int) (tamanhoTabela * parteFracionaria);
    }

    @Override
    public void inserir(String chave) {
        int indice = hash(chave);
        tabela.get(indice).add(chave);
        histograma.put(indice, histograma.get(indice) + 1);
    }

    public void inserir(Integer chave) {
        inserir(chave.toString());
    }

    @Override
    public void inserirchaves(List<String> chaves) {
        for (String chave : chaves) {
            inserir(chave);
        }
    }

    @Override
    public boolean recuperar(String chave) {
        int indice = hash(chave);
        return tabela.get(indice).contains(chave);
    }

    public boolean recuperar(Integer chave) {
        return recuperar(chave.toString());
    }

    @Override
    // public void imprimirHistograma() {
    //     System.out.println("Histograma de Distribuição:");
    //     for (Map.Entry<Integer, Integer> entry : histograma.entrySet()) {
    //         System.out.print("Índice " + entry.getKey() + ": ");
    //         for (int i = 0; i < entry.getValue(); i++) {
    //             System.out.print("*");
    //         }
    //         System.out.println(" (" + entry.getValue() + ")");
    //     }
    // }
    public void imprimirHistograma() {
        HistogramaGrafico.exibirHistograma(histograma);
    }
}