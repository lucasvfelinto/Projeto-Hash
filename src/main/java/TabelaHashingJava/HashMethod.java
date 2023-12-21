package TabelaHashingJava;

import java.util.List;

public interface HashMethod {
    void inserir(String chave);
    void inserirchaves(List<String> chaves);
    boolean recuperar(String chave);
    void imprimirHistograma();
}
