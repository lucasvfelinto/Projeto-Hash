package TabelaHashingJava;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class HashPorMeioQuadrado implements HashMethod {
    private int tamanhoTabela = 100;
    private ArrayList<LinkedList<String>> tabela;
    private HashMap<Integer, Integer> histograma;

    public HashPorMeioQuadrado() {
        tabela = new ArrayList<LinkedList<String>>(Collections.nCopies(tamanhoTabela, new LinkedList<String>()));
        histograma = new HashMap<>();
        for (int i = 0; i < tamanhoTabela; i++) {
            histograma.put(i, 0);
        }
    }

    public int hash(String chave) {
        int quadrado = chave.hashCode() * chave.hashCode(); // Quadrado da chave
        String strQuadrado = String.valueOf(quadrado);
        int meio = strQuadrado.length() / 2;
        String strMeioQuadrado = strQuadrado.substring(meio - 1, meio + 1); // Pega o meio do quadrado
        int hashValue = Integer.parseInt(strMeioQuadrado);
        return hashValue % tamanhoTabela;
    }
    @Override
    public void inserir(String chave) {
        int indice = hash(chave);
        tabela.get(indice).add(chave);
        histograma.put(indice, histograma.get(indice) + 1);
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