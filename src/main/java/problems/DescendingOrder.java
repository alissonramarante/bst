package problems;

import java.util.ArrayList;
import java.util.List;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/*O método descendingOrder(), que retorna um array contendo as chaves da árvore ordenadas em 
valor decrescente. Faça a análise de seu algoritmo.
Obs: sua implementação NÃO pode originar um array ordenado e depois inverter!
 */

public class DescendingOrder<T extends Comparable<T>> extends BSTImpl<T> {
    public Integer[] descendingOrder() {
        List<T> resultList = new ArrayList<>();
        descendingOrderHelper(root, resultList);
        return (Integer[]) resultList.toArray((T[]) new Comparable[resultList.size()]);
    }

    private void descendingOrderHelper(BSTNode<T> node, List<T> resultList) {
        if (node.getData() != null) {
            descendingOrderHelper((BSTNode<T>) node.getRight(), resultList);
            resultList.add(node.getData());
            descendingOrderHelper((BSTNode<T>) node.getLeft(), resultList);
        }
    }

}
