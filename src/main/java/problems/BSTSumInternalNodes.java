package main.java.problems;

import adt.bst.BST;

/**
 * Interface contendo método para somar todos os nós internos de uma BST. Um nó interno é um nó
 * que não é folha e nem é raiz
 **/
public interface BSTSumInternalNodes {
    /**
     * Metodo para somar todos os nós internos de uma BST. 
     * 
     * Restricoes e informacoes:
     * - A classe BSTInteger é fornecida para que voces nao implementem
     *   nenhuma BST. Voces podem usa-la para testar a implementacao de seu metodo
     * - Voce DEVE implementar o metodo USANDO RECURSAO. Voce pode usar metodo auxiliar
     *   desde que implementado na classe BSTSumInternalNodesImpl. 
     * - Voce NÃO pode editar nenhuma outra classe
     * - Voce NAO pode implementar nenhuma outra classe nova
     * - Para implementar o metodo sumInternalNodes voce DEVE, da classe BSTInteger,
     *   USAR APENAS o metodo getRoot
     * - Voce pode usar qualquer método da classe BSTNode mas NÃO pode modifica-la
     * - Voce DEVE implementar seu algoritmo com complexidade K*Theta(N) onde K = 1
     * - Sua implementacao DEVE ter relacao de recorrencia T(N) = 2T(N) + O(1)
     * - Voce NÃO PODE usar nenhuma outra estrutura auxiliar nem converter a BST 
     *   em outra estrutura, string, etc.
     * - Voce NÃO pode resolver o problema pelo seu complemento. Por exemplo: somar
     *   todos os nós da bST e depois excluir a raiz e as folhas.
     **/
    public int sumInternalNodes(BST<Integer> bst);
}
