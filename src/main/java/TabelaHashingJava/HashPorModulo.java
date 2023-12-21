package TabelaHashingJava;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HashPorModulo implements HashMethod {
    private int tamanhoTabela = 100;
    private ArrayList<LinkedList<String>> tabela;
    private HashMap<Integer, Integer> histograma;

    public HashPorModulo() {
        tabela = new ArrayList<LinkedList<String>>(Collections.nCopies(tamanhoTabela, new LinkedList<String>()));
        histograma = new HashMap<>();
        for (int i = 0; i < tamanhoTabela; i++) {
            histograma.put(i, 0);
        }
    }

    public int hash(String chave) {
        return chave.hashCode() % tamanhoTabela;
    }

    @Override
    public void inserir(String chaves) {
        int indice = Math.abs(hash(chaves)) % tamanhoTabela;
        tabela.get(indice).add(chaves);
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
        int indice = Math.abs(hash(chave)) % tamanhoTabela;
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