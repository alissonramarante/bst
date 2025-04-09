package problems;

import java.util.List;

import adt.bst.BST;

/**
 * Interface definindo um metodo para calcular os nós que estao a uma
 * determinada
 * distancia de um outro nó da BST.
 */
public interface BSTNodesKDistance<T extends Comparable<T>> extends BST<T> {

    /**
     * Dado um valor e uma distancia, retorna uma lista de nós que estao a uma
     * determinada distancia
     * do valor.
     * 
     * Restrições:
     * - Você pode usar estrutura auxiliar para resolver o problema (armazenar
     * valores, etc)
     * - Voce NÃO pode converter a BST em outra estrutura e fazer seu algoritmo
     * focado nessa
     * estrutura
     * - Voce DEVE desenvolver seu algoritmo atravessando a BST de alguma forma
     * - Você DEVE resolver o problema utilizado recursão.
     * - Voce NÃO pode usar metodos prontos da BST além dos que foram fornecidos com
     * a implementacao desta interface
     * - Caso o valor não esteja presente na BST o algoritmo reve retornar a lista
     * vazia
     * - A distancia de um nó para ele mesmo é 0.
     * - Qualquer de um nó para seus vizinhos imediatos é 1 (ascendente ou
     * descendente),
     * e assim por diante.
     * - A lista resultante não pode conter elementos repetidos
     * - Voce pode assumir que a BST não possui elementos duplicados
     * 
     * Exemplo:
     * BST:
     * 4
     * / \
     * 2 6
     * / \
     * 1 3
     * 
     * valor = 2, distancia = 1 ==> [1,3,4] (podendo estar em qualquer ordem)
     * valor = 2, distancia = 2 ==> [6]
     * valor = 6, distancia = 3 ==> [1,3] (podendo estar em qualquer ordem)
     * 
     * 
     * @param value    o valor que pode estar ou nao na BST
     * @param distance a distancia desejada
     * @return lista dos valores da BST que estao a uma determinada distancia do nó
     *         contendo o valor
     */
    public List<T> nodesAtDistance(T value, int distance);
}